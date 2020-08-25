package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes3.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a nrj;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.nrj = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.nrj.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Lu(int i) {
        return this.nrj.LA(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.nrj.getLoopCount();
    }
}
