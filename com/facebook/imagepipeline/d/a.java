package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor kgo;
    private final Executor kgp;
    private final Executor kgq;
    private final Executor kgr;

    public a(int i) {
        k kVar = new k(10);
        this.kgo = Executors.newFixedThreadPool(2);
        this.kgp = Executors.newFixedThreadPool(i, kVar);
        this.kgq = Executors.newFixedThreadPool(i, kVar);
        this.kgr = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cHY() {
        return this.kgo;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cHZ() {
        return this.kgo;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIa() {
        return this.kgp;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIb() {
        return this.kgq;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIc() {
        return this.kgr;
    }
}
