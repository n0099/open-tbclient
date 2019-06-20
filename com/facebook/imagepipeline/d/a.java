package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jZi;
    private final Executor jZj;
    private final Executor jZk;
    private final Executor jZl;

    public a(int i) {
        k kVar = new k(10);
        this.jZi = Executors.newFixedThreadPool(2);
        this.jZj = Executors.newFixedThreadPool(i, kVar);
        this.jZk = Executors.newFixedThreadPool(i, kVar);
        this.jZl = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEV() {
        return this.jZi;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEW() {
        return this.jZi;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEX() {
        return this.jZj;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEY() {
        return this.jZk;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEZ() {
        return this.jZl;
    }
}
