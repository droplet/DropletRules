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
package org.spout.droplet.rules.commands;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.exception.CommandException;

import org.spout.droplet.rules.DropletRules;

public class NestedCommands {
	String pages = "To see the next page use /rules ";

	public NestedCommands(DropletRules plugin) {
	}

	@Command(aliases = {"1"}, desc = "displays page one of the rules")
	public void one (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p1l1);
		source.sendMessage(DropletRules.p1l2);
		source.sendMessage(DropletRules.p1l3);
		source.sendMessage(DropletRules.p1l4);
		source.sendMessage(DropletRules.p1l5);
		source.sendMessage(pages, "2");
	}

	@Command(aliases = {"2"}, desc = "displays page two of the rules")
	public void two (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p2l1);
		source.sendMessage(DropletRules.p2l2);
		source.sendMessage(DropletRules.p2l3);
		source.sendMessage(DropletRules.p2l4);
		source.sendMessage(DropletRules.p2l5);
		source.sendMessage(pages, "3");
	}

	@Command(aliases = {"3"}, desc = "displays page three of the rules")
	public void three (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p3l1);
		source.sendMessage(DropletRules.p3l2);
		source.sendMessage(DropletRules.p3l3);
		source.sendMessage(DropletRules.p3l4);
		source.sendMessage(DropletRules.p3l5);
		source.sendMessage(pages, "4");
	}

	@Command(aliases = {"4"}, desc = "displays page four of the rules")
	public void four (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p4l1);
		source.sendMessage(DropletRules.p4l2);
		source.sendMessage(DropletRules.p4l3);
		source.sendMessage(DropletRules.p4l4);
		source.sendMessage(DropletRules.p4l5);
		source.sendMessage(pages, "5");
	}

	@Command(aliases = {"5"}, desc = "displays page five of the rules")
	public void five (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p5l1);
		source.sendMessage(DropletRules.p5l2);
		source.sendMessage(DropletRules.p5l3);
		source.sendMessage(DropletRules.p5l4);
		source.sendMessage(DropletRules.p5l5);
		source.sendMessage(pages, "6");
	}

	@Command(aliases = {"6"}, desc = "displays page six of the rules")
	public void six (CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage(DropletRules.p6l1);
		source.sendMessage(DropletRules.p6l2);
		source.sendMessage(DropletRules.p6l3);
		source.sendMessage(DropletRules.p6l4);
		source.sendMessage(DropletRules.p6l5);
		source.sendMessage(pages, "1");
	}
}
