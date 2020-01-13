package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class a implements b {
    private final b lSL;
    private final b lSM;
    private final b lSN;
    @Nullable
    private final Map<com.facebook.c.c, b> lSO;
    private final com.facebook.imagepipeline.i.e lSl;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lSN = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dpj = eVar2.dpj();
                if (dpj == com.facebook.c.b.lOC) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dpj == com.facebook.c.b.lOE) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dpj == com.facebook.c.b.lOK) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dpj == com.facebook.c.c.lOM) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lSL = bVar;
        this.lSM = bVar2;
        this.lSl = eVar;
        this.lSO = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lQM != null) {
            return bVar.lQM.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dpj = eVar.dpj();
        if (dpj == null || dpj == com.facebook.c.c.lOM) {
            dpj = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dpj);
        }
        if (this.lSO != null && (bVar2 = this.lSO.get(dpj)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lSN.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lQL || this.lSL == null) ? a(eVar, bVar) : this.lSL.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSl.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lTi, eVar.dpf(), eVar.dpg());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lSl.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dpf(), eVar.dpg());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lSM.a(eVar, i, hVar, bVar);
    }
}
