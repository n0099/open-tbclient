package com.bytedance.tea.crash.f;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f5182a;
    private final long b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j, long j2) {
        this.f5182a = handler;
        this.b = j;
        this.c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.f5182a.postDelayed(this, b());
        } else {
            this.f5182a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.f5182a.postDelayed(this, j);
        } else {
            this.f5182a.post(this);
        }
    }

    long b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
