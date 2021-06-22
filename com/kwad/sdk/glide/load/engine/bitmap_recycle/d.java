package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.Queue;
/* loaded from: classes7.dex */
public abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<T> f36262a = com.kwad.sdk.glide.g.k.a(20);

    public void a(T t) {
        if (this.f36262a.size() < 20) {
            this.f36262a.offer(t);
        }
    }

    public abstract T b();

    public T c() {
        T poll = this.f36262a.poll();
        return poll == null ? b() : poll;
    }
}
