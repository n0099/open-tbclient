package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor lRM;
    private final Executor lRN;
    private final Executor lRL = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lRO = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lRM = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lRN = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doB() {
        return this.lRL;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doC() {
        return this.lRL;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doD() {
        return this.lRM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doE() {
        return this.lRN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor doF() {
        return this.lRO;
    }
}
