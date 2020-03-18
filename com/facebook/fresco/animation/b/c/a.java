package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lQu;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lQu = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lQu.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HZ(int i) {
        return this.lQu.If(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lQu.getLoopCount();
    }
}
