package tv.chushou.basis.rxjava.finder;

import java.util.Map;
import java.util.Set;
import tv.chushou.basis.rxjava.entity.EventType;
import tv.chushou.basis.rxjava.entity.ProducerEvent;
import tv.chushou.basis.rxjava.entity.SubscriberEvent;
/* loaded from: classes5.dex */
public interface Finder {
    public static final Finder ANNOTATED = new Finder() { // from class: tv.chushou.basis.rxjava.finder.Finder.1
        @Override // tv.chushou.basis.rxjava.finder.Finder
        public Map<EventType, ProducerEvent> findAllProducers(Object obj) {
            return AnnotatedFinder.findAllProducers(obj);
        }

        @Override // tv.chushou.basis.rxjava.finder.Finder
        public Map<EventType, Set<SubscriberEvent>> findAllSubscribers(Object obj) {
            return AnnotatedFinder.findAllSubscribers(obj);
        }
    };

    Map<EventType, ProducerEvent> findAllProducers(Object obj);

    Map<EventType, Set<SubscriberEvent>> findAllSubscribers(Object obj);
}
