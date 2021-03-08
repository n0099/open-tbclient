package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a implements e {
    private final Executor pKI;
    private final Executor pKJ;
    private final Executor pKH = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pKK = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pKI = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pKJ = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewJ() {
        return this.pKH;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewK() {
        return this.pKH;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewL() {
        return this.pKI;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewM() {
        return this.pKJ;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewN() {
        return this.pKK;
    }
}
