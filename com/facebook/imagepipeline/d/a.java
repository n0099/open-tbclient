package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jHe;
    private final Executor jHf;
    private final Executor jHg;
    private final Executor jHh;

    public a(int i) {
        k kVar = new k(10);
        this.jHe = Executors.newFixedThreadPool(2);
        this.jHf = Executors.newFixedThreadPool(i, kVar);
        this.jHg = Executors.newFixedThreadPool(i, kVar);
        this.jHh = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxc() {
        return this.jHe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxd() {
        return this.jHe;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxe() {
        return this.jHf;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxf() {
        return this.jHg;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxg() {
        return this.jHh;
    }
}
