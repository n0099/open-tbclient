package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class a implements e {
    private final Executor lNo;
    private final Executor lNp;
    private final Executor lNn = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor lNq = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.lNo = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.lNp = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dmg() {
        return this.lNn;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dmh() {
        return this.lNn;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dmi() {
        return this.lNo;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dmj() {
        return this.lNp;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dmk() {
        return this.lNq;
    }
}
