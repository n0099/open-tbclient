package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jZe;
    private final Executor jZf;
    private final Executor jZg;
    private final Executor jZh;

    public a(int i) {
        k kVar = new k(10);
        this.jZe = Executors.newFixedThreadPool(2);
        this.jZf = Executors.newFixedThreadPool(i, kVar);
        this.jZg = Executors.newFixedThreadPool(i, kVar);
        this.jZh = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEU() {
        return this.jZe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEV() {
        return this.jZe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEW() {
        return this.jZf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEX() {
        return this.jZg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEY() {
        return this.jZh;
    }
}
