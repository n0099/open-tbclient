package tv.chushou.basis.rxjava;

import io.reactivex.c.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import tv.chushou.basis.rxjava.annotation.Tag;
import tv.chushou.basis.rxjava.entity.DeadEvent;
import tv.chushou.basis.rxjava.entity.EventType;
import tv.chushou.basis.rxjava.entity.ProducerEvent;
import tv.chushou.basis.rxjava.entity.SubscriberEvent;
import tv.chushou.basis.rxjava.finder.Finder;
import tv.chushou.basis.rxjava.thread.ThreadEnforcer;
/* loaded from: classes6.dex */
public class Bus {
    public static final String DEFAULT_IDENTIFIER = "default";
    private final ThreadEnforcer enforcer;
    private final Finder finder;
    private final ConcurrentMap<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final String identifier;
    private final ConcurrentMap<EventType, ProducerEvent> producersByType;
    private final ConcurrentMap<EventType, Set<SubscriberEvent>> subscribersByType;

    public Bus() {
        this("default");
    }

    public Bus(String str) {
        this(ThreadEnforcer.MAIN, str);
    }

    public Bus(ThreadEnforcer threadEnforcer) {
        this(threadEnforcer, "default");
    }

    public Bus(ThreadEnforcer threadEnforcer, String str) {
        this(threadEnforcer, str, Finder.ANNOTATED);
    }

    Bus(ThreadEnforcer threadEnforcer, String str, Finder finder) {
        this.subscribersByType = new ConcurrentHashMap();
        this.producersByType = new ConcurrentHashMap();
        this.flattenHierarchyCache = new ConcurrentHashMap();
        this.enforcer = threadEnforcer;
        this.identifier = str;
        this.finder = finder;
    }

    public String toString() {
        return "[Bus \"" + this.identifier + "\"]";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void register(Object obj) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        if (obj == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        this.enforcer.enforce(this);
        Map<EventType, ProducerEvent> findAllProducers = this.finder.findAllProducers(obj);
        for (EventType eventType : findAllProducers.keySet()) {
            ProducerEvent producerEvent = findAllProducers.get(eventType);
            ProducerEvent putIfAbsent = this.producersByType.putIfAbsent(eventType, producerEvent);
            if (putIfAbsent != null) {
                throw new IllegalArgumentException("Producer method for type " + eventType + " found on type " + producerEvent.getTarget().getClass() + ", but already registered by type " + putIfAbsent.getTarget().getClass() + ".");
            }
            Set<SubscriberEvent> set = this.subscribersByType.get(eventType);
            if (set != null && !set.isEmpty()) {
                for (SubscriberEvent subscriberEvent : set) {
                    dispatchProducerResult(subscriberEvent, producerEvent);
                }
            }
        }
        Map<EventType, Set<SubscriberEvent>> findAllSubscribers = this.finder.findAllSubscribers(obj);
        for (EventType eventType2 : findAllSubscribers.keySet()) {
            Set<SubscriberEvent> set2 = this.subscribersByType.get(eventType2);
            if (set2 == null && (set2 = this.subscribersByType.putIfAbsent(eventType2, (copyOnWriteArraySet = new CopyOnWriteArraySet()))) == null) {
                set2 = copyOnWriteArraySet;
            }
            if (!set2.addAll(findAllSubscribers.get(eventType2))) {
            }
            while (r4.hasNext()) {
            }
        }
        for (Map.Entry<EventType, Set<SubscriberEvent>> entry : findAllSubscribers.entrySet()) {
            ProducerEvent producerEvent2 = this.producersByType.get(entry.getKey());
            if (producerEvent2 != null && producerEvent2.isValid()) {
                for (SubscriberEvent subscriberEvent2 : entry.getValue()) {
                    if (producerEvent2.isValid()) {
                        if (subscriberEvent2.isValid()) {
                            dispatchProducerResult(subscriberEvent2, producerEvent2);
                        }
                    }
                }
            }
        }
    }

    private void dispatchProducerResult(final SubscriberEvent subscriberEvent, ProducerEvent producerEvent) {
        producerEvent.produce().b(new g() { // from class: tv.chushou.basis.rxjava.Bus.1
            @Override // io.reactivex.c.g
            public void accept(Object obj) {
                if (obj != null) {
                    Bus.this.dispatch(obj, subscriberEvent);
                }
            }
        });
    }

    public void unregister(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to unregister must not be null.");
        }
        this.enforcer.enforce(this);
        for (Map.Entry<EventType, ProducerEvent> entry : this.finder.findAllProducers(obj).entrySet()) {
            EventType key = entry.getKey();
            ProducerEvent producerForEventType = getProducerForEventType(key);
            ProducerEvent value = entry.getValue();
            if (value == null || !value.equals(producerForEventType)) {
                throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + obj.getClass() + " registered?");
            }
            this.producersByType.remove(key).invalidate();
        }
        for (Map.Entry<EventType, Set<SubscriberEvent>> entry2 : this.finder.findAllSubscribers(obj).entrySet()) {
            Set<SubscriberEvent> subscribersForEventType = getSubscribersForEventType(entry2.getKey());
            Set<SubscriberEvent> value2 = entry2.getValue();
            if (subscribersForEventType != null && subscribersForEventType.containsAll(value2)) {
                for (SubscriberEvent subscriberEvent : subscribersForEventType) {
                    if (value2.contains(subscriberEvent)) {
                        subscriberEvent.invalidate();
                    }
                }
                subscribersForEventType.removeAll(value2);
            }
        }
    }

    public void post(Object obj) {
        post(Tag.DEFAULT, obj);
    }

    public void post(String str, Object obj) {
        boolean z;
        if (obj == null) {
            throw new NullPointerException("Event to post must not be null.");
        }
        this.enforcer.enforce(this);
        boolean z2 = false;
        Iterator<Class<?>> it = flattenHierarchy(obj.getClass()).iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            Set<SubscriberEvent> subscribersForEventType = getSubscribersForEventType(new EventType(str, it.next()));
            if (subscribersForEventType != null && !subscribersForEventType.isEmpty()) {
                z = true;
                for (SubscriberEvent subscriberEvent : subscribersForEventType) {
                    dispatch(obj, subscriberEvent);
                }
            }
            z2 = z;
        }
        if (!z && !(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
    }

    protected void dispatch(Object obj, SubscriberEvent subscriberEvent) {
        if (subscriberEvent.isValid()) {
            subscriberEvent.handle(obj);
        }
    }

    ProducerEvent getProducerForEventType(EventType eventType) {
        return this.producersByType.get(eventType);
    }

    Set<SubscriberEvent> getSubscribersForEventType(EventType eventType) {
        return this.subscribersByType.get(eventType);
    }

    Set<Class<?>> flattenHierarchy(Class<?> cls) {
        Set<Class<?>> set = this.flattenHierarchyCache.get(cls);
        if (set == null) {
            Set<Class<?>> classesFor = getClassesFor(cls);
            Set<Class<?>> putIfAbsent = this.flattenHierarchyCache.putIfAbsent(cls, classesFor);
            return putIfAbsent == null ? classesFor : putIfAbsent;
        }
        return set;
    }

    private Set<Class<?>> getClassesFor(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }
}
