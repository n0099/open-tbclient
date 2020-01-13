package com.facebook.fresco.animation.b.b;
/* loaded from: classes12.dex */
public class d implements a {
    private static final Class<?> lGm = d.class;
    private final int lNO;

    public d() {
        this(3);
    }

    public d(int i) {
        this.lNO = i;
    }

    @Override // com.facebook.fresco.animation.b.b.a
    public void a(b bVar, com.facebook.fresco.animation.b.b bVar2, com.facebook.fresco.animation.a.a aVar, int i) {
        for (int i2 = 1; i2 <= this.lNO; i2++) {
            int frameCount = (i + i2) % aVar.getFrameCount();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(lGm, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bVar.a(bVar2, aVar, frameCount)) {
                return;
            }
        }
    }
}
