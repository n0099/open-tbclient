package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jGq;
    private final Executor jGr;
    private final Executor jGs;
    private final Executor jGt;

    public a(int i) {
        k kVar = new k(10);
        this.jGq = Executors.newFixedThreadPool(2);
        this.jGr = Executors.newFixedThreadPool(i, kVar);
        this.jGs = Executors.newFixedThreadPool(i, kVar);
        this.jGt = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwY() {
        return this.jGq;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cwZ() {
        return this.jGq;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxa() {
        return this.jGr;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxb() {
        return this.jGs;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxc() {
        return this.jGt;
    }
}
