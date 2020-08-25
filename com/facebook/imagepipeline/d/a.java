package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class a implements e {
    private final Executor nuy;
    private final Executor nuz;
    private final Executor nux = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor nuA = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.nuy = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.nuz = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSw() {
        return this.nux;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSx() {
        return this.nux;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSy() {
        return this.nuy;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSz() {
        return this.nuz;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dSA() {
        return this.nuA;
    }
}
