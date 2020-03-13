package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lOO;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lOO = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lOO.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HT(int i) {
        return this.lOO.HZ(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lOO.getLoopCount();
    }
}
