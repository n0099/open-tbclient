package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a implements e {
    private final Executor naI;
    private final Executor naJ;
    private final Executor naH = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor naK = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.naI = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.naJ = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGx() {
        return this.naH;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGy() {
        return this.naH;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGz() {
        return this.naI;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGA() {
        return this.naJ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor dGB() {
        return this.naK;
    }
}
