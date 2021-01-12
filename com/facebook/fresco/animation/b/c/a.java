package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a puS;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.puS = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.puS.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int OX(int i) {
        return this.puS.Pd(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.puS.getLoopCount();
    }
}
