package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class a implements b {
    private final b lSQ;
    private final b lSR;
    private final b lSS;
    @Nullable
    private final Map<com.facebook.c.c, b> lST;
    private final com.facebook.imagepipeline.i.e lSq;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lSS = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dpl = eVar2.dpl();
                if (dpl == com.facebook.c.b.lOH) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dpl == com.facebook.c.b.lOJ) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dpl == com.facebook.c.b.lOP) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dpl == com.facebook.c.c.lOR) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lSQ = bVar;
        this.lSR = bVar2;
        this.lSq = eVar;
        this.lST = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lQR != null) {
            return bVar.lQR.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dpl = eVar.dpl();
        if (dpl == null || dpl == com.facebook.c.c.lOR) {
            dpl = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dpl);
        }
        if (this.lST != null && (bVar2 = this.lST.get(dpl)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lSS.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lQQ || this.lSQ == null) ? a(eVar, bVar) : this.lSQ.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSq.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lTn, eVar.dph(), eVar.dpi());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSq.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dph(), eVar.dpi());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lSR.a(eVar, i, hVar, bVar);
    }
}
