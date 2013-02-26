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
import java.io.IOException;

import org.spout.api.Spout;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.RootCommand;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.util.config.yaml.YamlConfiguration;

import org.spout.droplet.rules.commands.PlayerCommands;
import org.spout.droplet.rules.configuration.DropletConfiguration;

public class DropletRules extends CommonPlugin {
	private static DropletRules instance;
	public static YamlConfiguration config;
	public static String logged = "Plugin has been ";
	public static String error = "There has been an error";
	public static String p1l1;
	public static String p1l2;
	public static String p1l3;
	public static String p1l4;
	public static String p1l5;
	public static String p2l1;
	public static String p2l2;
	public static String p2l3;
	public static String p2l4;
	public static String p2l5;
	public static String p3l1;
	public static String p3l2;
	public static String p3l3;
	public static String p3l4;
	public static String p3l5;
	public static String p4l1;
	public static String p4l2;
	public static String p4l3;
	public static String p4l4;
	public static String p4l5;
	public static String p5l1;
	public static String p5l2;
	public static String p5l3;
	public static String p5l4;
	public static String p5l5;
	public static String p6l1;
	public static String p6l2;
	public static String p6l3;
	public static String p6l4;
	public static String p6l5;
	public static String p7l1;
	public static String p7l2;
	public static String p7l3;
	public static String p7l4;
	public static String p7l5;
	public static String p7l6;

	@Override
	public void onLoad() {
		setInstance(this);
		config = (new YamlConfiguration(new File("plugins/DropletRules/config.yml")));
		DropletConfiguration.loadConfig();
		ruleCheck();
		rulesOnJoin();
		getLogger().info(logged + " loaded.");
	}

	@Override
	public void onEnable() {
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());
		RootCommand root = getEngine().getRootCommand();
		root.addSubCommands(this, PlayerCommands.class, commandRegFactory);

		getEngine().getEventManager().registerEvents(new EListener(this), this);
		Spout.getLogger().info(logged + "enabled.");
	}

	@Override
	public void onDisable() {
		Spout.getLogger().info(logged + "disabled.");
	}

	private static void setInstance(DropletRules plugin) {
		instance = plugin;
	}

	public static DropletRules getInstance() {
		return instance;
	}

	public static YamlConfiguration getConfig() {
		return config;
	}

	public void ruleCheck(){
		p1l1 = (config.getNode("Rules.page1.1").getString());
		p1l2 = (config.getNode("Rules.page1.2").getString());
		p1l3 = (config.getNode("Rules.page1.3").getString());
		p1l4 = (config.getNode("Rules.page1.4").getString());
		p1l5 = (config.getNode("Rules.page1.5").getString());
		p2l1 = (config.getNode("Rules.page2.1").getString());
		p2l2 = (config.getNode("Rules.page2.2").getString());
		p2l3 = (config.getNode("Rules.page2.3").getString());
		p2l4 = (config.getNode("Rules.page2.4").getString());
		p2l5 = (config.getNode("Rules.page2.5").getString());
		p3l1 = (config.getNode("Rules.page3.1").getString());
		p3l2 = (config.getNode("Rules.page3.2").getString());
		p3l3 = (config.getNode("Rules.page3.3").getString());
		p3l4 = (config.getNode("Rules.page3.4").getString());
		p3l5 = (config.getNode("Rules.page3.5").getString());
		p4l1 = (config.getNode("Rules.page4.1").getString());
		p4l2 = (config.getNode("Rules.page4.2").getString());
		p4l3 = (config.getNode("Rules.page4.3").getString());
		p4l4 = (config.getNode("Rules.page4.4").getString());
		p4l5 = (config.getNode("Rules.page4.5").getString());
		p5l1 = (config.getNode("Rules.page5.1").getString());
		p5l2 = (config.getNode("Rules.page5.2").getString());
		p5l3 = (config.getNode("Rules.page5.3").getString());
		p5l4 = (config.getNode("Rules.page5.4").getString());
		p5l5 = (config.getNode("Rules.page5.5").getString());
		p6l1 = (config.getNode("Rules.page6.1").getString());
		p6l2 = (config.getNode("Rules.page6.2").getString());
		p6l3 = (config.getNode("Rules.page6.3").getString());
		p6l4 = (config.getNode("Rules.page6.4").getString());
		p6l5 = (config.getNode("Rules.page6.5").getString());
		if (p1l1 != null && p6l5 != null){
			getLogger().info("Rules have been loaded");
		}
	}

	public void rulesOnJoin(){
		if (config.getNode("rules.onPlayerJoin.enabled").getBoolean() == true) {
			p7l1 = (config.getNode("Rules.onPlayerJoin.1").getString());
			p7l2 = (config.getNode("Rules.onPlayerJoin.2").getString());
			p7l3 = (config.getNode("Rules.onPlayerJoin.3").getString());
			p7l4 = (config.getNode("Rules.onPlayerJoin.4").getString());
			p7l5 = (config.getNode("Rules.onPlayerJoin.5").getString());
			p7l6 = "To see the rest of the rules use /rules 1";
			getLogger().info("Player join rules are loaded");
		} else if (config.getNode("rules.onPlayerJoin.enabled").getBoolean() == false) {
			getLogger().info("Rules displayed on player join has been disabled");
		}else getLogger().warning(error);
	}
}
