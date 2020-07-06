package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mSA;
    private final Executor mSB;
    private final Executor mSz = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mSD = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mSA = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mSB = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDk() {
        return this.mSz;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDl() {
        return this.mSz;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDm() {
        return this.mSA;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDn() {
        return this.mSB;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dDo() {
        return this.mSD;
    }
}
