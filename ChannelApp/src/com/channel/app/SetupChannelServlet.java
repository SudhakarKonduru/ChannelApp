package com.channel.app;

import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@SuppressWarnings("serial")
public class SetupChannelServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String clientId = req.getParameter("clientId");
		String token = channelService.createChannel(clientId);
		
		JSONObject json = new JSONObject();
		try {
			json.put("token", token);
		} catch(JSONException e) {
		}
		
		resp.setContentType("application/json");
	    resp.getWriter().write(json.toString());
	}
}
