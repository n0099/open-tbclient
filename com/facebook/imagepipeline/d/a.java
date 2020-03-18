package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor lTF;
    private final Executor lTG;
    private final Executor lTE = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lTH = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lTF = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lTG = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dpb() {
        return this.lTE;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dpc() {
        return this.lTE;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dpd() {
        return this.lTF;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dpe() {
        return this.lTG;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dpf() {
        return this.lTH;
    }
}
