package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor jGW;
    private final Executor jGX;
    private final Executor jGY;
    private final Executor jGZ;

    public a(int i) {
        k kVar = new k(10);
        this.jGW = Executors.newFixedThreadPool(2);
        this.jGX = Executors.newFixedThreadPool(i, kVar);
        this.jGY = Executors.newFixedThreadPool(i, kVar);
        this.jGZ = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxf() {
        return this.jGW;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxg() {
        return this.jGW;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxh() {
        return this.jGX;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxi() {
        return this.jGY;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor cxj() {
        return this.jGZ;
    }
}
