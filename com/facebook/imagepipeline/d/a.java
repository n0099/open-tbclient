package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor irf;
    private final Executor irg;
    private final Executor irh;
    private final Executor iri;

    public a(int i) {
        k kVar = new k(10);
        this.irf = Executors.newFixedThreadPool(2);
        this.irg = Executors.newFixedThreadPool(i, kVar);
        this.irh = Executors.newFixedThreadPool(i, kVar);
        this.iri = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXR() {
        return this.irf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXS() {
        return this.irf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXT() {
        return this.irg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXU() {
        return this.irh;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXV() {
        return this.iri;
    }
}
