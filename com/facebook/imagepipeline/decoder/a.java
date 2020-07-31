package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e nbR;
    private final b ncr;
    private final b ncs;
    private final b nct;
    @Nullable
    private final Map<com.facebook.c.c, b> ncu;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.nct = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dIr = eVar2.dIr();
                if (dIr == com.facebook.c.b.mYf) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dIr == com.facebook.c.b.mYh) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dIr == com.facebook.c.b.mYn) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dIr == com.facebook.c.c.mYp) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.ncr = bVar;
        this.ncs = bVar2;
        this.nbR = eVar;
        this.ncu = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nas != null) {
            return bVar.nas.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dIr = eVar.dIr();
        if (dIr == null || dIr == com.facebook.c.c.mYp) {
            dIr = com.facebook.c.d.s(eVar.getInputStream());
            eVar.c(dIr);
        }
        if (this.ncu != null && (bVar2 = this.ncu.get(dIr)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.nct.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.naq || this.ncr == null) ? a(eVar, bVar) : this.ncr.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nbR.a(eVar, bVar.nar, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.ncO, eVar.dIn(), eVar.dIo());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nbR.a(eVar, bVar.nar, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dIn(), eVar.dIo());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.ncs.a(eVar, i, hVar, bVar);
    }
}
