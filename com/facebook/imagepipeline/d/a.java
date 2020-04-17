package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mbs;
    private final Executor mbt;
    private final Executor mbr = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mbu = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mbs = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mbt = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dra() {
        return this.mbr;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor drb() {
        return this.mbr;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor drc() {
        return this.mbs;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor drd() {
        return this.mbt;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dre() {
        return this.mbu;
    }
}
