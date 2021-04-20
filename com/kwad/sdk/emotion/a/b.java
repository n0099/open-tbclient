package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f34925a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f34926b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f34930f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f34927c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f34928d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f34929e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f34931g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f34925a = cVar;
        this.f34926b = emotionPackage;
        this.f34930f = runnable;
    }

    private void f() {
        try {
            this.f34930f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f34926b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f34926b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f34926b.emotions.size();
    }

    public void b() {
        if (this.f34927c.incrementAndGet() < a() || this.f34928d.get() < a() || !this.f34931g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f34928d.incrementAndGet() < a() || this.f34927c.get() < a() || !this.f34931g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f34931g) {
            synchronized (this.f34929e) {
                if (this.f34931g) {
                    if (this.f34925a != null) {
                        this.f34925a.a(this.f34926b);
                    }
                    this.f34931g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f34931g) {
            synchronized (this.f34929e) {
                if (this.f34931g) {
                    if (this.f34925a != null) {
                        this.f34925a.a(this.f34926b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f34931g = false;
                    f();
                }
            }
        }
    }
}
