package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor idR;
    private final Executor idS;
    private final Executor idT;
    private final Executor idU;

    public a(int i) {
        k kVar = new k(10);
        this.idR = Executors.newFixedThreadPool(2);
        this.idS = Executors.newFixedThreadPool(i, kVar);
        this.idT = Executors.newFixedThreadPool(i, kVar);
        this.idU = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUS() {
        return this.idR;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUT() {
        return this.idR;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUU() {
        return this.idS;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUV() {
        return this.idT;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bUW() {
        return this.idU;
    }
}
