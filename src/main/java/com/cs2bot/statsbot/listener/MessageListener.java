package com.cs2bot.statsbot.listener;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MessageListener extends ListenerAdapter {

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    if (event.getAuthor().isBot())
      return;

    if (event.getMessage().getMentions().isMentioned(event.getJDA().getSelfUser())) {
      String content = event.getMessage().getContentRaw();

      
      if (content.contains("help")) {
        event.getChannel().sendMessage("I'm here to help with your CS2 stats! 🎮").queue();
      }
    }
  }
}
