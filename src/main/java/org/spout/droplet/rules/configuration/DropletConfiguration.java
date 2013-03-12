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

import java.util.ArrayList;
import java.util.List;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.yaml.YamlConfiguration;

import org.spout.droplet.rules.DropletRules;

public class DropletConfiguration extends YamlConfiguration {
	public static void loadConfig() {
		try {
			DropletRules.getConfig().load();
			DropletRules.getConfig().setPathSeparator(".");
			if (!DropletRules.getConfig().getNode("rules").isAttached()) {
				setConfig();
			}
			if (DropletRules.config.getNode("onPlayerJoin.enabled").getValue() == null) {
				DropletRules.getConfig().getNode("onPlayerJoin.enabled").setValue(true);
			}
			DropletRules.getConfig().save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void setConfig(){
		List<String> rules1 = new ArrayList<String>();
		rules1.add("1. Default rule 1");
		rules1.add("2. Default rule 2");
		List<String> rules2 = new ArrayList<String>();
		rules2.add("11. Default rule 11");
		rules2.add("12. Default rule 22");
		List<String> rules3 = new ArrayList<String>();
		rules3.add("31. Default rule 31");
		rules3.add("34. Default rule 34 (tee-hee)");
		List<String> rulesonjoin = new ArrayList<String>();
		rulesonjoin.add("This is the default rules");
		rulesonjoin.add("This is the default rules");
		DropletRules.getConfig().getNode("Rules.1").setValue(rules1);
		DropletRules.getConfig().getNode("Rules.2").setValue(rules2);
		DropletRules.getConfig().getNode("Rules.4").setValue(rules3);
		DropletRules.getConfig().getNode("onPlayerJoin.enabled").setValue(true);
		DropletRules.getConfig().getNode("onPlayerJoin.rules").setValue(rulesonjoin);
	}
}