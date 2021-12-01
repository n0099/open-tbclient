package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;
/* loaded from: classes3.dex */
public interface HasUpstreamPublisher<T> {
    Publisher<T> source();
}
