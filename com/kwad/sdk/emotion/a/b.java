package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f35292a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f35293b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f35297f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f35294c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f35295d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f35296e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35298g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f35292a = cVar;
        this.f35293b = emotionPackage;
        this.f35297f = runnable;
    }

    private void f() {
        try {
            this.f35297f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f35293b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f35293b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f35293b.emotions.size();
    }

    public void b() {
        if (this.f35294c.incrementAndGet() < a() || this.f35295d.get() < a() || !this.f35298g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f35295d.incrementAndGet() < a() || this.f35294c.get() < a() || !this.f35298g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f35298g) {
            synchronized (this.f35296e) {
                if (this.f35298g) {
                    if (this.f35292a != null) {
                        this.f35292a.a(this.f35293b);
                    }
                    this.f35298g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f35298g) {
            synchronized (this.f35296e) {
                if (this.f35298g) {
                    if (this.f35292a != null) {
                        this.f35292a.a(this.f35293b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f35298g = false;
                    f();
                }
            }
        }
    }
}
