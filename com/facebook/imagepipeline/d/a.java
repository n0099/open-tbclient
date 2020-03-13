package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor lRZ;
    private final Executor lSa;
    private final Executor lRY = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lSb = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lRZ = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lSa = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doE() {
        return this.lRY;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doF() {
        return this.lRY;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doG() {
        return this.lRZ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doH() {
        return this.lSa;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doI() {
        return this.lSb;
    }
}
