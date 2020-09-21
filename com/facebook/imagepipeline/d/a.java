package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor nEN;
    private final Executor nEO;
    private final Executor nEM = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor nEP = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.nEN = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.nEO = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dWD() {
        return this.nEM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dWE() {
        return this.nEM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dWF() {
        return this.nEN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dWG() {
        return this.nEO;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dWH() {
        return this.nEP;
    }
}
