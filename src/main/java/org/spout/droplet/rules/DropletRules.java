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
package org.spout.droplet.rules;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.RootCommand;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.util.config.ConfigurationNode;
import org.spout.api.util.config.yaml.YamlConfiguration;
import org.spout.droplet.rules.commands.DropletCommand;
import org.spout.droplet.rules.configuration.DropletConfiguration;

public class DropletRules extends CommonPlugin {
	private DropletConfiguration config = null;

	@Override
	public void onLoad() {
		config = new DropletConfiguration(this);
		config.loadConfig();
	}

	@Override
	public void onEnable() {
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(getEngine(), new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());
		RootCommand root = getEngine().getRootCommand();
		root.addSubCommands(this, DropletCommand.class, commandRegFactory);
		getEngine().getEventManager().registerEvents(new DropletListener(this), this);
		getLogger().info("DropletRules has been enabled");
	}

	@Override
	public void onDisable() {
		config.saveConfig();
		getLogger().info("DropletRules has been disabled");
	}

	public DropletConfiguration getConfig() {
		return config;
	}

	public Map<Integer, List<String>> getRules() {
		return config.getRules();
	}

	public List<String> getRulesForJoin() {
		return config.getRulesOnJoin();
	}

	public boolean showRulesOnJoin() {
		return config.showRulesOnJoin();
	}
}
