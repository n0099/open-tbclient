package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes11.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lKe;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lKe = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lKe.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HF(int i) {
        return this.lKe.HL(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lKe.getLoopCount();
    }
}
