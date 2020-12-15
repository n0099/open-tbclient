package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class a implements e {
    private final Executor pll;
    private final Executor plm;
    private final Executor plk = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pln = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pll = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.plm = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etH() {
        return this.plk;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etI() {
        return this.plk;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etJ() {
        return this.pll;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etK() {
        return this.plm;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etL() {
        return this.pln;
    }
}
