package com.facebook.imagepipeline.d;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements e {
    private final Executor ipX;
    private final Executor ipY;
    private final Executor ipZ;
    private final Executor iqa;

    public a(int i) {
        k kVar = new k(10);
        this.ipX = Executors.newFixedThreadPool(2);
        this.ipY = Executors.newFixedThreadPool(i, kVar);
        this.ipZ = Executors.newFixedThreadPool(i, kVar);
        this.iqa = Executors.newFixedThreadPool(1, kVar);
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXj() {
        return this.ipX;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXk() {
        return this.ipX;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXl() {
        return this.ipY;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXm() {
        return this.ipZ;
    }

    @Override // com.facebook.imagepipeline.d.e
    public Executor bXn() {
        return this.iqa;
    }
}
