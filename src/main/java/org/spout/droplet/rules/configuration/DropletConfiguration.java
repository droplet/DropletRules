/*
 * This file is part of DropletRules.
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.spout.droplet.rules.configuration;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationNode;
import org.spout.api.util.config.yaml.YamlConfiguration;

import org.spout.droplet.rules.DropletRules;

public class DropletConfiguration {
	private YamlConfiguration config;

	private Map<Integer, List<String>> rules;
	private List<String> rulesOnJoin;
	private boolean showRulesOnJoin;

	public DropletConfiguration(DropletRules plugin) {
		config = new YamlConfiguration(new File(plugin.getDataFolder(), "config.yml"));
	}

	public Map<Integer, List<String>> getRules() {
		return rules;
	}

	public List<String> getRulesOnJoin() {
		return rulesOnJoin;
	}

	public boolean showRulesOnJoin() {
		return showRulesOnJoin;
	}

	public void loadConfig() {
		try {
			config.load();
			config.setPathSeparator(".");
			config.setWritesDefaults(true);
			if (!config.getNode("rules").isAttached()) {
				setDefaults();
			}
			if (!config.getNode("on-player-join.enabled").isAttached()) {
				config.getNode("on-player-join.enabled").setValue(true);
			}
			ConfigurationNode node = config.getNode("rules");
			int i = 1;
			for (String key : node.getKeys(true)) {
				ConfigurationNode node1 = node.getChild(key);
				List<String> list = node1.getStringList();
				rules.put(i, list);
				i++;
			}
			rulesOnJoin = config.getNode("on-player-join.rules").getStringList(Arrays.asList("Welcome to the server!"));
			showRulesOnJoin = config.getNode("on-player-join.enable").getBoolean(true);
			config.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void saveConfig() {
		try {
			config.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void setDefaults() {
		config.getNode("rules.1").setValue(Arrays.asList("these", "are", "example", "rules"));
		config.getNode("rules.2").setValue(Arrays.asList("this", "is", "page", "number", "two"));
		config.getNode("rules.4").setValue(Arrays.asList("this", "is", "page", "three"));
		config.getNode("on-player-join.enabled").setValue(true);
		config.getNode("on-player-join.rules").setValue(Arrays.asList("Welcome to the server!", "Rules:", "No Griefing", "Have Fun"));
	}
}
