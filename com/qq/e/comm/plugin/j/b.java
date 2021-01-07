package com.qq.e.comm.plugin.j;

import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12454a;

    /* renamed from: b  reason: collision with root package name */
    private int f12455b;
    private boolean c;
    private ExecutorService d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f12458a = new b();

        public a a(int i) {
            this.f12458a.f12454a = i;
            return this;
        }

        public a a(ExecutorService executorService) {
            this.f12458a.d = executorService;
            return this;
        }

        public a a(boolean z) {
            this.f12458a.c = z;
            return this;
        }

        public b a() {
            return this.f12458a;
        }

        public a b(int i) {
            this.f12458a.f12455b = i;
            return this;
        }
    }

    private b() {
        this.f12454a = 30000;
        this.f12455b = 30000;
        this.c = true;
    }

    public int a() {
        return this.f12454a;
    }

    public int b() {
        return this.f12455b;
    }

    public boolean c() {
        return this.c;
    }

    public ExecutorService d() {
        return this.d;
    }
}
