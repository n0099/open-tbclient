package com.meizu.cloud.pushsdk.networking.a;

import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class c implements d {
    public static final int a = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    private final a b;
    private final a c;
    private final Executor d;

    public c() {
        f fVar = new f(10);
        this.b = new a(a, fVar);
        this.c = new a(2, fVar);
        this.d = new e();
    }

    @Override // com.meizu.cloud.pushsdk.networking.a.d
    public a a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.networking.a.d
    public a b() {
        return this.c;
    }

    @Override // com.meizu.cloud.pushsdk.networking.a.d
    public Executor c() {
        return this.d;
    }
}
