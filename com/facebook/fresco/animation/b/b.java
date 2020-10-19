package com.facebook.fresco.animation.b;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public interface b {

    /* loaded from: classes14.dex */
    public interface a {
        void a(b bVar, int i);

        void b(b bVar, int i);
    }

    @Nullable
    com.facebook.common.references.a<Bitmap> MG(int i);

    @Nullable
    com.facebook.common.references.a<Bitmap> MH(int i);

    boolean MI(int i);

    void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2);

    @Nullable
    com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3);

    void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2);

    void clear();
}
