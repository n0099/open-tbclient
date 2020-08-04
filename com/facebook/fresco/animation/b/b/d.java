package com.facebook.fresco.animation.b.b;
/* loaded from: classes18.dex */
public class d implements a {
    private static final Class<?> mPz = d.class;
    private final int mXt;

    public d() {
        this(3);
    }

    public d(int i) {
        this.mXt = i;
    }

    @Override // com.facebook.fresco.animation.b.b.a
    public void a(b bVar, com.facebook.fresco.animation.b.b bVar2, com.facebook.fresco.animation.a.a aVar, int i) {
        for (int i2 = 1; i2 <= this.mXt; i2++) {
            int frameCount = (i + i2) % aVar.getFrameCount();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(mPz, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bVar.a(bVar2, aVar, frameCount)) {
                return;
            }
        }
    }
}
