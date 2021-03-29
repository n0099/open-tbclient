package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f34636a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f34637b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f34641f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f34638c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f34639d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f34640e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f34642g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f34636a = cVar;
        this.f34637b = emotionPackage;
        this.f34641f = runnable;
    }

    private void f() {
        try {
            this.f34641f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f34637b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f34637b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f34637b.emotions.size();
    }

    public void b() {
        if (this.f34638c.incrementAndGet() < a() || this.f34639d.get() < a() || !this.f34642g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f34639d.incrementAndGet() < a() || this.f34638c.get() < a() || !this.f34642g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f34642g) {
            synchronized (this.f34640e) {
                if (this.f34642g) {
                    if (this.f34636a != null) {
                        this.f34636a.a(this.f34637b);
                    }
                    this.f34642g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f34642g) {
            synchronized (this.f34640e) {
                if (this.f34642g) {
                    if (this.f34636a != null) {
                        this.f34636a.a(this.f34637b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f34642g = false;
                    f();
                }
            }
        }
    }
}
