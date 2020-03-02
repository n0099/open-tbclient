package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lOD;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lOD = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lOD.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HT(int i) {
        return this.lOD.HZ(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lOD.getLoopCount();
    }
}
