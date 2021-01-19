package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a puT;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.puT = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.puT.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int OX(int i) {
        return this.puT.Pd(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.puT.getLoopCount();
    }
}
