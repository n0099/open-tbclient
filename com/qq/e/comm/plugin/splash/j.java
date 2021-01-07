package com.qq.e.comm.plugin.splash;

import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f12819a = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        int i = this.f12819a.get();
        if (i == 1 || i == 3 || i == 5) {
            return false;
        }
        return this.f12819a.compareAndSet(i, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f12819a.compareAndSet(1, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f12819a.compareAndSet(2, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f12819a.compareAndSet(3, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        int i = this.f12819a.get();
        if (i == 4) {
            return false;
        }
        return this.f12819a.compareAndSet(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f12819a.compareAndSet(1, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f12819a.compareAndSet(3, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f12819a.compareAndSet(3, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f12819a.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f12819a.get() == 2;
    }
}
