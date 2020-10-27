package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor oLy;
    private final Executor oLz;
    private final Executor oLx = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor oLA = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.oLy = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.oLz = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor ekm() {
        return this.oLx;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor ekn() {
        return this.oLx;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eko() {
        return this.oLy;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor ekp() {
        return this.oLz;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor ekq() {
        return this.oLA;
    }
}
