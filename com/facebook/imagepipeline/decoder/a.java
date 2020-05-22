package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final b mwW;
    private final b mwX;
    private final b mwY;
    @Nullable
    private final Map<com.facebook.c.c, b> mwZ;
    private final com.facebook.imagepipeline.i.e mwy;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.mwY = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dAl = eVar2.dAl();
                if (dAl == com.facebook.c.b.msL) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dAl == com.facebook.c.b.msN) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dAl == com.facebook.c.b.msT) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dAl == com.facebook.c.c.msV) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.mwW = bVar;
        this.mwX = bVar2;
        this.mwy = eVar;
        this.mwZ = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.muZ != null) {
            return bVar.muZ.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dAl = eVar.dAl();
        if (dAl == null || dAl == com.facebook.c.c.msV) {
            dAl = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dAl);
        }
        if (this.mwZ != null && (bVar2 = this.mwZ.get(dAl)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.mwY.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.muX || this.mwW == null) ? a(eVar, bVar) : this.mwW.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mwy.a(eVar, bVar.muY, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.mxt, eVar.dAh(), eVar.dAi());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mwy.a(eVar, bVar.muY, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dAh(), eVar.dAi());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.mwX.a(eVar, i, hVar, bVar);
    }
}
