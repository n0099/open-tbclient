package h.o.c;

import h.g;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class f extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f67898a;

    public f(ThreadFactory threadFactory) {
        this.f67898a = threadFactory;
    }

    @Override // h.g
    public g.a createWorker() {
        return new g(this.f67898a);
    }
}
