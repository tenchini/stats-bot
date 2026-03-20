package com.cs2bot.statsbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cs2bot.statsbot.listener.MessageListener;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

@Service
public class DiscordBotService {

  @Value("${discord.token}")
  private String token;

  @Autowired
  private MessageListener messageListener;

  private JDA jda;

  @PostConstruct
  public void startBot() {
    try {
      jda = JDABuilder.createLight(token)
          .enableIntents(GatewayIntent.MESSAGE_CONTENT)
          .addEventListeners(messageListener)
          .build();

      System.out.println("Bot is online and listening for mentions!");
    } catch (Exception e) {
      System.err.println("Error starting bot: " + e.getMessage());
    }
  }
}
