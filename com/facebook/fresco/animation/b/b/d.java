package com.facebook.fresco.animation.b.b;
/* loaded from: classes13.dex */
public class d implements a {
    private static final Class<?> mHr = d.class;
    private final int mPh;

    public d() {
        this(3);
    }

    public d(int i) {
        this.mPh = i;
    }

    @Override // com.facebook.fresco.animation.b.b.a
    public void a(b bVar, com.facebook.fresco.animation.b.b bVar2, com.facebook.fresco.animation.a.a aVar, int i) {
        for (int i2 = 1; i2 <= this.mPh; i2++) {
            int frameCount = (i + i2) % aVar.getFrameCount();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(mHr, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bVar.a(bVar2, aVar, frameCount)) {
                return;
            }
        }
    }
}
