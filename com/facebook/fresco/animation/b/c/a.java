package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a pig;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.pig = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pig.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Qq(int i) {
        return this.pig.Qw(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pig.getLoopCount();
    }
}
