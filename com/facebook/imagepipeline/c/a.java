package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a implements e {
    private final Executor pxV;
    private final Executor pxW;
    private final Executor pxU = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pxX = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pxV = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pxW = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor eua() {
        return this.pxU;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor eub() {
        return this.pxU;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor euc() {
        return this.pxV;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor eud() {
        return this.pxW;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor eue() {
        return this.pxX;
    }
}
