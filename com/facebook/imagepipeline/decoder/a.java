package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FJ;
    private final com.facebook.imagepipeline.a.a.d irv;
    private final b isD;
    @Nullable
    private final Map<com.facebook.c.c, b> isE;
    private final com.facebook.imagepipeline.h.e isk;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.isD = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bZy = dVar2.bZy();
                if (bZy == com.facebook.c.b.ipd) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bZy == com.facebook.c.b.ipf) {
                    return a.this.a(dVar2, aVar);
                }
                if (bZy == com.facebook.c.b.ipl) {
                    return a.this.c(dVar2, aVar);
                }
                if (bZy == com.facebook.c.c.ipm) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.irv = dVar;
        this.FJ = config;
        this.isk = eVar;
        this.isE = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.iqR != null) {
            return aVar.iqR.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bZy = dVar.bZy();
        if (bZy == null || bZy == com.facebook.c.c.ipm) {
            bZy = com.facebook.c.d.s(dVar.getInputStream());
            dVar.c(bZy);
        }
        if (this.isE != null && (bVar = this.isE.get(bZy)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.isD.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.iqP && this.irv != null) {
                b = this.irv.a(dVar, aVar, this.FJ);
            } else {
                b = b(dVar, aVar);
                com.facebook.common.internal.b.o(inputStream);
            }
            return b;
        } finally {
            com.facebook.common.internal.b.o(inputStream);
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.isk.a(dVar, aVar.iqQ);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.isW, dVar.bZv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.isk.a(dVar, aVar.iqQ, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bZv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.irv.b(dVar, aVar, this.FJ);
    }
}
