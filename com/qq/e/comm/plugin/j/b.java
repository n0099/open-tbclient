package com.qq.e.comm.plugin.j;

import java.util.concurrent.ExecutorService;
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12156a;

    /* renamed from: b  reason: collision with root package name */
    private int f12157b;
    private boolean c;
    private ExecutorService d;

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f12160a = new b();

        public a a(int i) {
            this.f12160a.f12156a = i;
            return this;
        }

        public a a(ExecutorService executorService) {
            this.f12160a.d = executorService;
            return this;
        }

        public a a(boolean z) {
            this.f12160a.c = z;
            return this;
        }

        public b a() {
            return this.f12160a;
        }

        public a b(int i) {
            this.f12160a.f12157b = i;
            return this;
        }
    }

    private b() {
        this.f12156a = 30000;
        this.f12157b = 30000;
        this.c = true;
    }

    public int a() {
        return this.f12156a;
    }

    public int b() {
        return this.f12157b;
    }

    public boolean c() {
        return this.c;
    }

    public ExecutorService d() {
        return this.d;
    }
}
