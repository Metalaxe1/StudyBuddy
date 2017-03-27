package edu.uncg.studdybuddy.events;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Anthony Ratliff on 3/26/2017.
 */

public class EventDispatcher implements IEventDispatcher {

    protected ArrayList<Listener> listenerList = new ArrayList<>();

    @Override
    public void addEventListener(String type, IEventHandler handler) {
        Listener listener = new Listener(type, handler);
        removeEventListener(type);
        listenerList.add(0, listener);
    }

    @Override
    public void removeEventListener(String type) {
        for (Iterator<Listener> iterator = listenerList.iterator();iterator.hasNext();){
            Listener listener = (Listener) iterator.next();
            if(listener.getType() == type){
                listenerList.remove(listener);
            }
        }
    }

    @Override
    public void dispatchEvent(Event event) {
        for (Iterator<Listener> iterator = listenerList.iterator();iterator.hasNext();){
            Listener listener = (Listener) iterator.next();
            if(event.getStrType() == listener.getType()){
                IEventHandler eventHandler = listener.getHandler();
                eventHandler.callback(event);
            }
        }
    }

    @Override
    public Boolean hasEventListener(String type) {
        return false;
    }

    @Override
    public void removeAllListeners() {

    }
}
