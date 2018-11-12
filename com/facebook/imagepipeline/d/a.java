package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor ifB;
    private final Executor ifC;
    private final Executor ifD;
    private final Executor ifE;

    public a(int i) {
        k kVar = new k(10);
        this.ifB = Executors.newFixedThreadPool(2);
        this.ifC = Executors.newFixedThreadPool(i, kVar);
        this.ifD = Executors.newFixedThreadPool(i, kVar);
        this.ifE = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUn() {
        return this.ifB;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUo() {
        return this.ifB;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUp() {
        return this.ifC;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUq() {
        return this.ifD;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUr() {
        return this.ifE;
    }
}
