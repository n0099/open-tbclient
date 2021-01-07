package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.emotion.c f10027a;

    /* renamed from: b  reason: collision with root package name */
    private final EmotionPackage f10028b;
    private final Runnable f;
    private final AtomicInteger c = new AtomicInteger(0);
    private final AtomicInteger d = new AtomicInteger(0);
    private final Object e = new Object();
    private boolean g = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        this.f10027a = cVar;
        this.f10028b = emotionPackage;
        this.f = runnable;
    }

    private void f() {
        try {
            this.f.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        if (z.a(this.f10028b, "未成功初始化emoji package但调用了get总数.") == null) {
            return 0;
        }
        z.a(this.f10028b.emotions, "未成功初始化emoji package但调用了get总数.");
        return this.f10028b.emotions.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c.incrementAndGet() < a() || this.d.get() < a() || !this.g) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.d.incrementAndGet() < a() || this.c.get() < a() || !this.g) {
            return;
        }
        d();
    }

    void d() {
        if (this.g) {
            synchronized (this.e) {
                if (this.g) {
                    if (this.f10027a != null) {
                        this.f10027a.a(this.f10028b);
                    }
                    this.g = false;
                    f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.g) {
            synchronized (this.e) {
                if (this.g) {
                    if (this.f10027a != null) {
                        this.f10027a.a(this.f10028b, new IllegalStateException("download all cdn fail."));
                    }
                    this.g = false;
                    f();
                }
            }
        }
    }
}
