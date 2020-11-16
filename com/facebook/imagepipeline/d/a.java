package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes17.dex */
public class a implements e {
    private final Executor oWu;
    private final Executor oWv;
    private final Executor oWt = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor oWw = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.oWu = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.oWv = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoa() {
        return this.oWt;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eob() {
        return this.oWt;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoc() {
        return this.oWu;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eod() {
        return this.oWv;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eoe() {
        return this.oWw;
    }
}
