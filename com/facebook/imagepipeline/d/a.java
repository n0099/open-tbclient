package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor khu;
    private final Executor khv;
    private final Executor khw;
    private final Executor khx;

    public a(int i) {
        k kVar = new k(10);
        this.khu = Executors.newFixedThreadPool(2);
        this.khv = Executors.newFixedThreadPool(i, kVar);
        this.khw = Executors.newFixedThreadPool(i, kVar);
        this.khx = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIt() {
        return this.khu;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIu() {
        return this.khu;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIv() {
        return this.khv;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIw() {
        return this.khw;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cIx() {
        return this.khx;
    }
}
