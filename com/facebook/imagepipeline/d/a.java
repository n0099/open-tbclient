package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor lRa;
    private final Executor lRb;
    private final Executor lQZ = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lRc = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lRa = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lRb = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnm() {
        return this.lQZ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnn() {
        return this.lQZ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dno() {
        return this.lRa;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnp() {
        return this.lRb;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnq() {
        return this.lRc;
    }
}
