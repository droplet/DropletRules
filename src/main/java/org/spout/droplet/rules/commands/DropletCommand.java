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

import java.util.List;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.exception.CommandException;
import org.spout.droplet.rules.DropletRules;

public class DropletCommand {
	private final DropletRules plugin;

	public DropletCommand(DropletRules plugin) {
		this.plugin = plugin;
	}

	@Command(aliases = { "ruleset", "rules" }, desc = "Displays the rules")
	public void rules(CommandContext args, CommandSource source) throws CommandException {
		int page = 0;
		if (args.length() > 0) {
			if (args.isInteger(0)) {
				page = args.getInteger(0);
			} else {
				throw new CommandException(args.getString(0) + " is not a valid integer!");
			}
		}
		List<String> list = plugin.getRules().get(page);
		if (list == null) {
			throw new CommandException("That page doesn't exist!");
		}
		for (String rule : list) {
			source.sendMessage(rule);
		}
		source.sendMessage("To see the next page, do /rules " + (page + 1));
	}
}
