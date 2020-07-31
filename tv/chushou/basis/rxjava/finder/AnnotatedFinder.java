package tv.chushou.basis.rxjava.finder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import tv.chushou.basis.rxjava.annotation.Produce;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.annotation.Tag;
import tv.chushou.basis.rxjava.entity.EventType;
import tv.chushou.basis.rxjava.entity.ProducerEvent;
import tv.chushou.basis.rxjava.entity.SubscriberEvent;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes6.dex */
public final class AnnotatedFinder {
    private static final ConcurrentMap<Class<?>, Map<EventType, SourceMethod>> PRODUCERS_CACHE = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, Map<EventType, Set<SourceMethod>>> SUBSCRIBERS_CACHE = new ConcurrentHashMap();

    private static void loadAnnotatedProducerMethods(Class<?> cls, Map<EventType, SourceMethod> map) {
        loadAnnotatedMethods(cls, map, new HashMap());
    }

    private static void loadAnnotatedSubscriberMethods(Class<?> cls, Map<EventType, Set<SourceMethod>> map) {
        loadAnnotatedMethods(cls, new HashMap(), map);
    }

    private static void loadAnnotatedMethods(Class<?> cls, Map<EventType, SourceMethod> map, Map<EventType, Set<SourceMethod>> map2) {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge()) {
                if (method.isAnnotationPresent(Subscribe.class)) {
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length != 1) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation but requires " + parameterTypes2.length + " arguments.  Methods must require a single argument.");
                    }
                    Class<?> cls2 = parameterTypes2[0];
                    if (cls2.isInterface()) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " which is an interface.  Subscription must be on a concrete class type.");
                    }
                    if ((method.getModifiers() & 1) == 0) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " but is not 'public'.");
                    }
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    EventThread thread = subscribe.thread();
                    Tag[] tags = subscribe.tags();
                    int length = tags == null ? 0 : tags.length;
                    while (true) {
                        int i = length;
                        String str = Tag.DEFAULT;
                        if (i > 0) {
                            str = tags[i - 1].value();
                        }
                        EventType eventType = new EventType(str, cls2);
                        Set<SourceMethod> set = map2.get(eventType);
                        if (set == null) {
                            set = new HashSet<>();
                            map2.put(eventType, set);
                        }
                        set.add(new SourceMethod(thread, method));
                        length = i - 1;
                        if (length > 0) {
                        }
                    }
                } else if (method.isAnnotationPresent(Produce.class)) {
                    if (method.getParameterTypes().length != 0) {
                        throw new IllegalArgumentException("Method " + method + "has @Produce annotation but requires " + parameterTypes.length + " arguments.  Methods must require zero arguments.");
                    }
                    if (method.getReturnType() == Void.class) {
                        throw new IllegalArgumentException("Method " + method + " has a return type of void.  Must declare a non-void type.");
                    }
                    Class<?> returnType = method.getReturnType();
                    if (returnType.isInterface()) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " which is an interface.  Producers must return a concrete class type.");
                    }
                    if (returnType.equals(Void.TYPE)) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation but has no return type.");
                    }
                    if ((method.getModifiers() & 1) == 0) {
                        throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " but is not 'public'.");
                    }
                    Produce produce = (Produce) method.getAnnotation(Produce.class);
                    EventThread thread2 = produce.thread();
                    Tag[] tags2 = produce.tags();
                    int length2 = tags2 == null ? 0 : tags2.length;
                    do {
                        String str2 = Tag.DEFAULT;
                        if (length2 > 0) {
                            str2 = tags2[length2 - 1].value();
                        }
                        EventType eventType2 = new EventType(str2, returnType);
                        if (map.containsKey(eventType2)) {
                            throw new IllegalArgumentException("Producer for type " + eventType2 + " has already been registered.");
                        }
                        map.put(eventType2, new SourceMethod(thread2, method));
                        length2--;
                    } while (length2 > 0);
                } else {
                    continue;
                }
            }
        }
        PRODUCERS_CACHE.put(cls, map);
        SUBSCRIBERS_CACHE.put(cls, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<EventType, ProducerEvent> findAllProducers(Object obj) {
        Class<?> cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map<EventType, SourceMethod> map = PRODUCERS_CACHE.get(cls);
        if (map == null) {
            map = new HashMap<>();
            loadAnnotatedProducerMethods(cls, map);
        }
        if (!map.isEmpty()) {
            for (Map.Entry<EventType, SourceMethod> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new ProducerEvent(obj, entry.getValue().method, entry.getValue().thread));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<EventType, Set<SubscriberEvent>> findAllSubscribers(Object obj) {
        Class<?> cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map<EventType, Set<SourceMethod>> map = SUBSCRIBERS_CACHE.get(cls);
        if (map == null) {
            map = new HashMap<>();
            loadAnnotatedSubscriberMethods(cls, map);
        }
        if (!map.isEmpty()) {
            for (Map.Entry<EventType, Set<SourceMethod>> entry : map.entrySet()) {
                HashSet hashSet = new HashSet();
                for (SourceMethod sourceMethod : entry.getValue()) {
                    hashSet.add(new SubscriberEvent(obj, sourceMethod.method, sourceMethod.thread));
                }
                hashMap.put(entry.getKey(), hashSet);
            }
        }
        return hashMap;
    }

    private AnnotatedFinder() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class SourceMethod {
        private Method method;
        private EventThread thread;

        private SourceMethod(EventThread eventThread, Method method) {
            this.thread = eventThread;
            this.method = method;
        }
    }
}
