package com.qq.e.comm.plugin.j;

import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12453a;

    /* renamed from: b  reason: collision with root package name */
    private int f12454b;
    private boolean c;
    private ExecutorService d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f12457a = new b();

        public a a(int i) {
            this.f12457a.f12453a = i;
            return this;
        }

        public a a(ExecutorService executorService) {
            this.f12457a.d = executorService;
            return this;
        }

        public a a(boolean z) {
            this.f12457a.c = z;
            return this;
        }

        public b a() {
            return this.f12457a;
        }

        public a b(int i) {
            this.f12457a.f12454b = i;
            return this;
        }
    }

    private b() {
        this.f12453a = 30000;
        this.f12454b = 30000;
        this.c = true;
    }

    public int a() {
        return this.f12453a;
    }

    public int b() {
        return this.f12454b;
    }

    public boolean c() {
        return this.c;
    }

    public ExecutorService d() {
        return this.d;
    }
}
