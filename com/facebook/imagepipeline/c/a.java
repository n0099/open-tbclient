package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class a implements e {
    private final Executor pAO;
    private final Executor pAP;
    private final Executor pAN = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pAQ = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pAO = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pAP = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exq() {
        return this.pAN;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exr() {
        return this.pAN;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exs() {
        return this.pAO;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ext() {
        return this.pAP;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor exu() {
        return this.pAQ;
    }
}
