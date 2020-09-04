package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class a implements e {
    private final Executor nuQ;
    private final Executor nuR;
    private final Executor nuP = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor nuS = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.nuQ = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.nuR = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSF() {
        return this.nuP;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSG() {
        return this.nuP;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSH() {
        return this.nuQ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSI() {
        return this.nuR;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSJ() {
        return this.nuS;
    }
}
