package com.bytedance.tea.crash.f;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f7657a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7658b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j, long j2) {
        this.f7657a = handler;
        this.f7658b = j;
        this.c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.f7657a.postDelayed(this, b());
        } else {
            this.f7657a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.f7657a.postDelayed(this, j);
        } else {
            this.f7657a.post(this);
        }
    }

    long b() {
        return this.f7658b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
