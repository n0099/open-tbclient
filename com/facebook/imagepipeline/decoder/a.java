package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FJ;
    private final com.facebook.imagepipeline.a.a.d irw;
    private final b isE;
    @Nullable
    private final Map<com.facebook.c.c, b> isF;
    private final com.facebook.imagepipeline.h.e isl;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.isE = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bZy = dVar2.bZy();
                if (bZy == com.facebook.c.b.ipe) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bZy == com.facebook.c.b.ipg) {
                    return a.this.a(dVar2, aVar);
                }
                if (bZy == com.facebook.c.b.ipm) {
                    return a.this.c(dVar2, aVar);
                }
                if (bZy == com.facebook.c.c.ipn) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.irw = dVar;
        this.FJ = config;
        this.isl = eVar;
        this.isF = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.iqS != null) {
            return aVar.iqS.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bZy = dVar.bZy();
        if (bZy == null || bZy == com.facebook.c.c.ipn) {
            bZy = com.facebook.c.d.s(dVar.getInputStream());
            dVar.c(bZy);
        }
        if (this.isF != null && (bVar = this.isF.get(bZy)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.isE.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.iqQ && this.irw != null) {
                b = this.irw.a(dVar, aVar, this.FJ);
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
        com.facebook.common.references.a<Bitmap> a = this.isl.a(dVar, aVar.iqR);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.isX, dVar.bZv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.isl.a(dVar, aVar.iqR, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bZv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.irw.b(dVar, aVar, this.FJ);
    }
}
