package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e nbT;
    private final b nct;
    private final b ncu;
    private final b ncv;
    @Nullable
    private final Map<com.facebook.c.c, b> ncw;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.ncv = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dIs = eVar2.dIs();
                if (dIs == com.facebook.c.b.mYh) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dIs == com.facebook.c.b.mYj) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dIs == com.facebook.c.b.mYp) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dIs == com.facebook.c.c.mYr) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.nct = bVar;
        this.ncu = bVar2;
        this.nbT = eVar;
        this.ncw = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nau != null) {
            return bVar.nau.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dIs = eVar.dIs();
        if (dIs == null || dIs == com.facebook.c.c.mYr) {
            dIs = com.facebook.c.d.s(eVar.getInputStream());
            eVar.c(dIs);
        }
        if (this.ncw != null && (bVar2 = this.ncw.get(dIs)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.ncv.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.nas || this.nct == null) ? a(eVar, bVar) : this.nct.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nbT.a(eVar, bVar.nat, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.ncQ, eVar.dIo(), eVar.dIp());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nbT.a(eVar, bVar.nat, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dIo(), eVar.dIp());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.ncu.a(eVar, i, hVar, bVar);
    }
}
