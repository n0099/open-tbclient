package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jZf;
    private final Executor jZg;
    private final Executor jZh;
    private final Executor jZi;

    public a(int i) {
        k kVar = new k(10);
        this.jZf = Executors.newFixedThreadPool(2);
        this.jZg = Executors.newFixedThreadPool(i, kVar);
        this.jZh = Executors.newFixedThreadPool(i, kVar);
        this.jZi = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEW() {
        return this.jZf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEX() {
        return this.jZf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEY() {
        return this.jZg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cEZ() {
        return this.jZh;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cFa() {
        return this.jZi;
    }
}
