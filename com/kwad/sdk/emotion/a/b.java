package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f35020a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f35021b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f35025f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f35022c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f35023d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f35024e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35026g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f35020a = cVar;
        this.f35021b = emotionPackage;
        this.f35025f = runnable;
    }

    private void f() {
        try {
            this.f35025f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f35021b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f35021b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f35021b.emotions.size();
    }

    public void b() {
        if (this.f35022c.incrementAndGet() < a() || this.f35023d.get() < a() || !this.f35026g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f35023d.incrementAndGet() < a() || this.f35022c.get() < a() || !this.f35026g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f35026g) {
            synchronized (this.f35024e) {
                if (this.f35026g) {
                    if (this.f35020a != null) {
                        this.f35020a.a(this.f35021b);
                    }
                    this.f35026g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f35026g) {
            synchronized (this.f35024e) {
                if (this.f35026g) {
                    if (this.f35020a != null) {
                        this.f35020a.a(this.f35021b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f35026g = false;
                    f();
                }
            }
        }
    }
}
