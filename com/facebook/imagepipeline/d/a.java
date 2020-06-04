package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mwx;
    private final Executor mwy;
    private final Executor mww = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mwz = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mwx = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mwy = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyE() {
        return this.mww;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyF() {
        return this.mww;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyG() {
        return this.mwx;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyH() {
        return this.mwy;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyI() {
        return this.mwz;
    }
}
