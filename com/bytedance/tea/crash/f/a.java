package com.bytedance.tea.crash.f;

import android.os.Handler;
/* loaded from: classes4.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f7655a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7656b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j, long j2) {
        this.f7655a = handler;
        this.f7656b = j;
        this.c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.f7655a.postDelayed(this, b());
        } else {
            this.f7655a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.f7655a.postDelayed(this, j);
        } else {
            this.f7655a.post(this);
        }
    }

    long b() {
        return this.f7656b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
