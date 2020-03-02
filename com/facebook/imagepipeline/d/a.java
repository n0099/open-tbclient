package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor lRO;
    private final Executor lRP;
    private final Executor lRN = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lRQ = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lRO = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lRP = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doD() {
        return this.lRN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doE() {
        return this.lRN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doF() {
        return this.lRO;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doG() {
        return this.lRP;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doH() {
        return this.lRQ;
    }
}
