package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f35390a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f35391b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f35395f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f35392c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f35393d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f35394e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f35396g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f35390a = cVar;
        this.f35391b = emotionPackage;
        this.f35395f = runnable;
    }

    private void f() {
        try {
            this.f35395f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f35391b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f35391b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f35391b.emotions.size();
    }

    public void b() {
        if (this.f35392c.incrementAndGet() < a() || this.f35393d.get() < a() || !this.f35396g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f35393d.incrementAndGet() < a() || this.f35392c.get() < a() || !this.f35396g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f35396g) {
            synchronized (this.f35394e) {
                if (this.f35396g) {
                    if (this.f35390a != null) {
                        this.f35390a.a(this.f35391b);
                    }
                    this.f35396g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f35396g) {
            synchronized (this.f35394e) {
                if (this.f35396g) {
                    if (this.f35390a != null) {
                        this.f35390a.a(this.f35391b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f35396g = false;
                    f();
                }
            }
        }
    }
}
