package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e lSZ;
    private final b lTA;
    private final b lTB;
    @Nullable
    private final Map<com.facebook.c.c, b> lTC;
    private final b lTz;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lTB = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dqz = eVar2.dqz();
                if (dqz == com.facebook.c.b.lPq) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dqz == com.facebook.c.b.lPs) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dqz == com.facebook.c.b.lPy) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dqz == com.facebook.c.c.lPA) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lTz = bVar;
        this.lTA = bVar2;
        this.lSZ = eVar;
        this.lTC = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lRA != null) {
            return bVar.lRA.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dqz = eVar.dqz();
        if (dqz == null || dqz == com.facebook.c.c.lPA) {
            dqz = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dqz);
        }
        if (this.lTC != null && (bVar2 = this.lTC.get(dqz)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lTB.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lRz || this.lTz == null) ? a(eVar, bVar) : this.lTz.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSZ.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lTW, eVar.dqv(), eVar.dqw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSZ.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dqv(), eVar.dqw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lTA.a(eVar, i, hVar, bVar);
    }
}
