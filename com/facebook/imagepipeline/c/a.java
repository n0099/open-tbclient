package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a implements e {
    private final Executor pID;
    private final Executor pIE;
    private final Executor pIC = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pIF = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pID = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pIE = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewA() {
        return this.pIC;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewB() {
        return this.pIC;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewC() {
        return this.pID;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewD() {
        return this.pIE;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewE() {
        return this.pIF;
    }
}
