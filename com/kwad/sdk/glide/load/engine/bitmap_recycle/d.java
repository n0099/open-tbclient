package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.Queue;
/* loaded from: classes3.dex */
abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f10193a = com.kwad.sdk.glide.g.k.a(20);

    public void a(T t) {
        if (this.f10193a.size() < 20) {
            this.f10193a.offer(t);
        }
    }

    abstract T b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T c() {
        T poll = this.f10193a.poll();
        return poll == null ? b() : poll;
    }
}
