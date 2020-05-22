package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes13.dex */
public class a implements e {
    private final Executor mvn;
    private final Executor mvo;
    private final Executor mvm = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor mvp = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.mvn = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.mvo = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyq() {
        return this.mvm;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyr() {
        return this.mvm;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dys() {
        return this.mvn;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyt() {
        return this.mvo;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dyu() {
        return this.mvp;
    }
}
