package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor imM;
    private final Executor imN;
    private final Executor imO;
    private final Executor imP;

    public a(int i) {
        k kVar = new k(10);
        this.imM = Executors.newFixedThreadPool(2);
        this.imN = Executors.newFixedThreadPool(i, kVar);
        this.imO = Executors.newFixedThreadPool(i, kVar);
        this.imP = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bWs() {
        return this.imM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bWt() {
        return this.imM;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bWu() {
        return this.imN;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bWv() {
        return this.imO;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bWw() {
        return this.imP;
    }
}
