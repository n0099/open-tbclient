package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mbw;
    private final Executor mbx;
    private final Executor mbv = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mby = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mbw = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mbx = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dqY() {
        return this.mbv;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dqZ() {
        return this.mbv;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dra() {
        return this.mbw;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor drb() {
        return this.mbx;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor drc() {
        return this.mby;
    }
}
