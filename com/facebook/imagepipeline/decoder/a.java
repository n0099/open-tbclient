package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e mxI;
    private final b myg;
    private final b myh;
    private final b myi;
    @Nullable
    private final Map<com.facebook.c.c, b> myj;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.myi = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dAz = eVar2.dAz();
                if (dAz == com.facebook.c.b.mtV) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dAz == com.facebook.c.b.mtX) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dAz == com.facebook.c.b.mud) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dAz == com.facebook.c.c.muf) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.myg = bVar;
        this.myh = bVar2;
        this.mxI = eVar;
        this.myj = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.mwj != null) {
            return bVar.mwj.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dAz = eVar.dAz();
        if (dAz == null || dAz == com.facebook.c.c.muf) {
            dAz = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dAz);
        }
        if (this.myj != null && (bVar2 = this.myj.get(dAz)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.myi.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.mwh || this.myg == null) ? a(eVar, bVar) : this.myg.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mxI.a(eVar, bVar.mwi, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.myD, eVar.dAv(), eVar.dAw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mxI.a(eVar, bVar.mwi, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dAv(), eVar.dAw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.myh.a(eVar, i, hVar, bVar);
    }
}
