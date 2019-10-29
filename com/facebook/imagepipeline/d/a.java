package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor kie;
    private final Executor kif;
    private final Executor kig;
    private final Executor kih;

    public a(int i) {
        k kVar = new k(10);
        this.kie = Executors.newFixedThreadPool(2);
        this.kif = Executors.newFixedThreadPool(i, kVar);
        this.kig = Executors.newFixedThreadPool(i, kVar);
        this.kih = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGe() {
        return this.kie;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGf() {
        return this.kie;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGg() {
        return this.kif;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGh() {
        return this.kig;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cGi() {
        return this.kih;
    }
}
