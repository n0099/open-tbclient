package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor nUg;
    private final Executor nUh;
    private final Executor nUf = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor nUi = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.nUg = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.nUh = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eao() {
        return this.nUf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eap() {
        return this.nUf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eaq() {
        return this.nUg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor ear() {
        return this.nUh;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor eas() {
        return this.nUi;
    }
}
