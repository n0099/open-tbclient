package com.facebook.imagepipeline.c;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a implements e {
    private final Executor pId;
    private final Executor pIe;
    private final Executor pIc = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
    private final Executor pIf = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));

    public a(int i) {
        this.pId = Executors.newFixedThreadPool(i, new k(10, "FrescoDecodeExecutor", true));
        this.pIe = Executors.newFixedThreadPool(i, new k(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ews() {
        return this.pIc;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewt() {
        return this.pIc;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewu() {
        return this.pId;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor ewv() {
        return this.pIe;
    }

    @Override // com.facebook.imagepipeline.c.e
    public Executor eww() {
        return this.pIf;
    }
}
