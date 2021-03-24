package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f34635a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f34636b;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f34640f;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f34637c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f34638d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public final Object f34639e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public boolean f34641g = true;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f34635a = cVar;
        this.f34636b = emotionPackage;
        this.f34640f = runnable;
    }

    private void f() {
        try {
            this.f34640f.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f34636b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f34636b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f34636b.emotions.size();
    }

    public void b() {
        if (this.f34637c.incrementAndGet() < a() || this.f34638d.get() < a() || !this.f34641g) {
            return;
        }
        d();
    }

    public void c() {
        if (this.f34638d.incrementAndGet() < a() || this.f34637c.get() < a() || !this.f34641g) {
            return;
        }
        d();
    }

    public void d() {
        if (this.f34641g) {
            synchronized (this.f34639e) {
                if (this.f34641g) {
                    if (this.f34635a != null) {
                        this.f34635a.a(this.f34636b);
                    }
                    this.f34641g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        if (this.f34641g) {
            synchronized (this.f34639e) {
                if (this.f34641g) {
                    if (this.f34635a != null) {
                        this.f34635a.a(this.f34636b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f34641g = false;
                    f();
                }
            }
        }
    }
}
