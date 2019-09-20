package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Dx;
    private final com.facebook.imagepipeline.h.e kkY;
    private final com.facebook.imagepipeline.a.a.d kkj;
    private final b klu;
    @Nullable
    private final Map<com.facebook.c.c, b> klv;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.klu = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cKS = dVar2.cKS();
                if (cKS == com.facebook.c.b.khP) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cKS == com.facebook.c.b.khR) {
                    return a.this.a(dVar2, aVar);
                }
                if (cKS == com.facebook.c.b.khX) {
                    return a.this.c(dVar2, aVar);
                }
                if (cKS == com.facebook.c.c.khY) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.kkj = dVar;
        this.Dx = config;
        this.kkY = eVar;
        this.klv = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.kjF != null) {
            return aVar.kjF.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cKS = dVar.cKS();
        if (cKS == null || cKS == com.facebook.c.c.khY) {
            cKS = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cKS);
        }
        if (this.klv != null && (bVar = this.klv.get(cKS)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.klu.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.kjD && this.kkj != null) {
                b = this.kkj.a(dVar, aVar, this.Dx);
            } else {
                b = b(dVar, aVar);
                com.facebook.common.internal.b.q(inputStream);
            }
            return b;
        } finally {
            com.facebook.common.internal.b.q(inputStream);
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kkY.a(dVar, aVar.kjE);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.klN, dVar.cKP());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kkY.a(dVar, aVar.kjE, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cKP());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.kkj.b(dVar, aVar, this.Dx);
    }
}
