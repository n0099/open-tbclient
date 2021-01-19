package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a implements b {
    private final b pzE;
    private final b pzF;
    private final b pzG;
    @Nullable
    private final Map<com.facebook.c.c, b> pzH;
    private final com.facebook.imagepipeline.h.e pzg;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pzG = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c evV = eVar2.evV();
                if (evV == com.facebook.c.b.pvG) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.b.pvI) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.b.pvO) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (evV == com.facebook.c.c.pvQ) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pzE = bVar;
        this.pzF = bVar2;
        this.pzg = eVar;
        this.pzH = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pxH != null) {
            return bVar.pxH.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c evV = eVar.evV();
        if (evV == null || evV == com.facebook.c.c.pvQ) {
            evV = com.facebook.c.d.y(eVar.getInputStream());
            eVar.c(evV);
        }
        if (this.pzH != null && (bVar2 = this.pzH.get(evV)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pzG.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pxG || this.pzE == null) ? a(eVar, bVar) : this.pzE.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pzg.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pAb, eVar.evR(), eVar.evS());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pzg.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.evR(), eVar.evS());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pzF.a(eVar, i, hVar, bVar);
    }
}
