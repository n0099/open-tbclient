package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor khm;
    private final Executor khn;
    private final Executor kho;
    private final Executor khp;

    public a(int i) {
        k kVar = new k(10);
        this.khm = Executors.newFixedThreadPool(2);
        this.khn = Executors.newFixedThreadPool(i, kVar);
        this.kho = Executors.newFixedThreadPool(i, kVar);
        this.khp = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGc() {
        return this.khm;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGd() {
        return this.khm;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGe() {
        return this.khn;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGf() {
        return this.kho;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGg() {
        return this.khp;
    }
}
