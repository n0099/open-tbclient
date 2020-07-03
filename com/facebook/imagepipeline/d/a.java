package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mSx;
    private final Executor mSy;
    private final Executor mSw = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mSz = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mSx = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mSy = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDg() {
        return this.mSw;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDh() {
        return this.mSw;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDi() {
        return this.mSx;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDj() {
        return this.mSy;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDk() {
        return this.mSz;
    }
}
