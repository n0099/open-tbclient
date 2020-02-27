package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e lSX;
    @Nullable
    private final Map<com.facebook.c.c, b> lTA;
    private final b lTx;
    private final b lTy;
    private final b lTz;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lTz = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dqx = eVar2.dqx();
                if (dqx == com.facebook.c.b.lPo) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dqx == com.facebook.c.b.lPq) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dqx == com.facebook.c.b.lPw) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dqx == com.facebook.c.c.lPy) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lTx = bVar;
        this.lTy = bVar2;
        this.lSX = eVar;
        this.lTA = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lRy != null) {
            return bVar.lRy.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dqx = eVar.dqx();
        if (dqx == null || dqx == com.facebook.c.c.lPy) {
            dqx = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dqx);
        }
        if (this.lTA != null && (bVar2 = this.lTA.get(dqx)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lTz.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lRx || this.lTx == null) ? a(eVar, bVar) : this.lTx.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSX.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lTU, eVar.dqt(), eVar.dqu());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSX.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dqt(), eVar.dqu());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lTy.a(eVar, i, hVar, bVar);
    }
}
