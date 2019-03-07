package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jGL;
    private final Executor jGM;
    private final Executor jGN;
    private final Executor jGO;

    public a(int i) {
        k kVar = new k(10);
        this.jGL = Executors.newFixedThreadPool(2);
        this.jGM = Executors.newFixedThreadPool(i, kVar);
        this.jGN = Executors.newFixedThreadPool(i, kVar);
        this.jGO = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwS() {
        return this.jGL;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwT() {
        return this.jGL;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwU() {
        return this.jGM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwV() {
        return this.jGN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwW() {
        return this.jGO;
    }
}
