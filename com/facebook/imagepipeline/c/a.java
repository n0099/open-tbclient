package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a implements e {
    private final Executor pCv;
    private final Executor pCw;
    private final Executor pCu = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pCx = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pCv = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pCw = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exS() {
        return this.pCu;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exT() {
        return this.pCu;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exU() {
        return this.pCv;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exV() {
        return this.pCw;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exW() {
        return this.pCx;
    }
}
