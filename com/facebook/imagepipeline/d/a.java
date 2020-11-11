package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor oUR;
    private final Executor oUS;
    private final Executor oUQ = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor oUT = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.oUR = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.oUS = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoc() {
        return this.oUQ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eod() {
        return this.oUQ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoe() {
        return this.oUR;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eog() {
        return this.oUS;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoh() {
        return this.oUT;
    }
}
