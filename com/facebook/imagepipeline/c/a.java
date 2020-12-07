package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class a implements e {
    private final Executor plj;
    private final Executor plk;
    private final Executor pli = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pll = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.plj = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.plk = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etG() {
        return this.pli;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etH() {
        return this.pli;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etI() {
        return this.plj;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etJ() {
        return this.plk;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor etK() {
        return this.pll;
    }
}
