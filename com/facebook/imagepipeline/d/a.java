package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor idQ;
    private final Executor idR;
    private final Executor idS;
    private final Executor idT;

    public a(int i) {
        k kVar = new k(10);
        this.idQ = Executors.newFixedThreadPool(2);
        this.idR = Executors.newFixedThreadPool(i, kVar);
        this.idS = Executors.newFixedThreadPool(i, kVar);
        this.idT = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUS() {
        return this.idQ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUT() {
        return this.idQ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUU() {
        return this.idR;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUV() {
        return this.idS;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUW() {
        return this.idT;
    }
}
