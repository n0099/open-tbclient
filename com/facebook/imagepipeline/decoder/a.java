package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e mcD;
    private final b mdb;
    private final b mdc;
    private final b mdd;
    @Nullable
    private final Map<com.facebook.c.c, b> mde;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.mdd = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dsV = eVar2.dsV();
                if (dsV == com.facebook.c.b.lYM) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dsV == com.facebook.c.b.lYO) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dsV == com.facebook.c.b.lYU) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dsV == com.facebook.c.c.lYW) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.mdb = bVar;
        this.mdc = bVar2;
        this.mcD = eVar;
        this.mde = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.mbe != null) {
            return bVar.mbe.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dsV = eVar.dsV();
        if (dsV == null || dsV == com.facebook.c.c.lYW) {
            dsV = com.facebook.c.d.s(eVar.getInputStream());
            eVar.c(dsV);
        }
        if (this.mde != null && (bVar2 = this.mde.get(dsV)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.mdd.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.mbc || this.mdb == null) ? a(eVar, bVar) : this.mdb.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mcD.a(eVar, bVar.mbd, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.mdy, eVar.dsR(), eVar.dsS());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mcD.a(eVar, bVar.mbd, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dsR(), eVar.dsS());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.mdc.a(eVar, i, hVar, bVar);
    }
}
