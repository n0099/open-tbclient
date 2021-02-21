package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements b {
    private final com.facebook.imagepipeline.h.e pJO;
    private final b pKm;
    private final b pKn;
    private final b pKo;
    @Nullable
    private final Map<com.facebook.c.c, b> pKp;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pKo = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c eyw = eVar2.eyw();
                if (eyw == com.facebook.c.b.pGo) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (eyw == com.facebook.c.b.pGq) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (eyw == com.facebook.c.b.pGw) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (eyw == com.facebook.c.c.pGy) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pKm = bVar;
        this.pKn = bVar2;
        this.pJO = eVar;
        this.pKp = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pIp != null) {
            return bVar.pIp.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c eyw = eVar.eyw();
        if (eyw == null || eyw == com.facebook.c.c.pGy) {
            eyw = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(eyw);
        }
        if (this.pKp != null && (bVar2 = this.pKp.get(eyw)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pKo.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pIo || this.pKm == null) ? a(eVar, bVar) : this.pKm.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pJO.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pKJ, eVar.eys(), eVar.eyt());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pJO.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.eys(), eVar.eyt());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pKn.a(eVar, i, hVar, bVar);
    }
}
