package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor kjS;
    private final Executor kjT;
    private final Executor kjU;
    private final Executor kjV;

    public a(int i) {
        k kVar = new k(10);
        this.kjS = Executors.newFixedThreadPool(2);
        this.kjT = Executors.newFixedThreadPool(i, kVar);
        this.kjU = Executors.newFixedThreadPool(i, kVar);
        this.kjV = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cJh() {
        return this.kjS;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cJi() {
        return this.kjS;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cJj() {
        return this.kjT;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cJk() {
        return this.kjU;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cJl() {
        return this.kjV;
    }
}
