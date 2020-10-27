package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a oIk;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.oIk = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.oIk.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Ow(int i) {
        return this.oIk.OC(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.oIk.getLoopCount();
    }
}
