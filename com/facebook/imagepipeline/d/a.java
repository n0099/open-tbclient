package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a implements e {
    private final Executor naG;
    private final Executor naH;
    private final Executor naF = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor naI = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.naG = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.naH = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGw() {
        return this.naF;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGx() {
        return this.naF;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGy() {
        return this.naG;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGz() {
        return this.naH;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGA() {
        return this.naI;
    }
}
