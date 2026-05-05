package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void requestSupplies(String topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Quartermaster " + getName() + "] prepares gear after message from "
                + from.getName() + ": " + payload);
    }
}