package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a implements b {
    private final b pzD;
    private final b pzE;
    private final b pzF;
    @Nullable
    private final Map<com.facebook.c.c, b> pzG;
    private final com.facebook.imagepipeline.h.e pzf;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pzF = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c evV = eVar2.evV();
                if (evV == com.facebook.c.b.pvF) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.b.pvH) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.b.pvN) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.c.pvP) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pzD = bVar;
        this.pzE = bVar2;
        this.pzf = eVar;
        this.pzG = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pxG != null) {
            return bVar.pxG.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c evV = eVar.evV();
        if (evV == null || evV == com.facebook.c.c.pvP) {
            evV = com.facebook.c.d.y(eVar.getInputStream());
            eVar.c(evV);
        }
        if (this.pzG != null && (bVar2 = this.pzG.get(evV)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pzF.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pxF || this.pzD == null) ? a(eVar, bVar) : this.pzD.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pzf.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pAa, eVar.evR(), eVar.evS());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pzf.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.evR(), eVar.evS());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pzE.a(eVar, i, hVar, bVar);
    }
}
