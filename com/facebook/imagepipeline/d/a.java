package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements e {
    private final Executor lRf;
    private final Executor lRg;
    private final Executor lRe = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lRh = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lRf = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lRg = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dno() {
        return this.lRe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnp() {
        return this.lRe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnq() {
        return this.lRf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnr() {
        return this.lRg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dnt() {
        return this.lRh;
    }
}
