package com.qq.e.comm.plugin.j;

import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12154a;

    /* renamed from: b  reason: collision with root package name */
    private int f12155b;
    private boolean c;
    private ExecutorService d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f12158a = new b();

        public a a(int i) {
            this.f12158a.f12154a = i;
            return this;
        }

        public a a(ExecutorService executorService) {
            this.f12158a.d = executorService;
            return this;
        }

        public a a(boolean z) {
            this.f12158a.c = z;
            return this;
        }

        public b a() {
            return this.f12158a;
        }

        public a b(int i) {
            this.f12158a.f12155b = i;
            return this;
        }
    }

    private b() {
        this.f12154a = 30000;
        this.f12155b = 30000;
        this.c = true;
    }

    public int a() {
        return this.f12154a;
    }

    public int b() {
        return this.f12155b;
    }

    public boolean c() {
        return this.c;
    }

    public ExecutorService d() {
        return this.d;
    }
}
