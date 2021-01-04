package com.bytedance.tea.crash.f;

import android.os.Handler;
/* loaded from: classes4.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f7954a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7955b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j, long j2) {
        this.f7954a = handler;
        this.f7955b = j;
        this.c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.f7954a.postDelayed(this, b());
        } else {
            this.f7954a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.f7954a.postDelayed(this, j);
        } else {
            this.f7954a.post(this);
        }
    }

    long b() {
        return this.f7955b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
