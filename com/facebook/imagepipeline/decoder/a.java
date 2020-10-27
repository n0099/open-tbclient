package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e oMJ;
    private final b oNh;
    private final b oNi;
    private final b oNj;
    @Nullable
    private final Map<com.facebook.c.c, b> oNk;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.oNj = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c emh = eVar2.emh();
                if (emh == com.facebook.c.b.oIX) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (emh == com.facebook.c.b.oIZ) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (emh == com.facebook.c.b.oJf) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (emh == com.facebook.c.c.oJh) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.oNh = bVar;
        this.oNi = bVar2;
        this.oMJ = eVar;
        this.oNk = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.oLk != null) {
            return bVar.oLk.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c emh = eVar.emh();
        if (emh == null || emh == com.facebook.c.c.oJh) {
            emh = com.facebook.c.d.u(eVar.getInputStream());
            eVar.c(emh);
        }
        if (this.oNk != null && (bVar2 = this.oNk.get(emh)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.oNj.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.oLi || this.oNh == null) ? a(eVar, bVar) : this.oNh.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oMJ.a(eVar, bVar.oLj, null);
        try {
            return new com.facebook.imagepipeline.g.d(a2, g.oNE, eVar.emd(), eVar.eme());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oMJ.a(eVar, bVar.oLj, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a2, hVar, eVar.emd(), eVar.eme());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.oNi.a(eVar, i, hVar, bVar);
    }
}
