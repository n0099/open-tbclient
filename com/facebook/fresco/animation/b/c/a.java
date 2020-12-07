package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a pie;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.pie = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pie.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Qq(int i) {
        return this.pie.Qw(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pie.getLoopCount();
    }
}
