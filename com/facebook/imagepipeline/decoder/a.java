package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FJ;
    private final com.facebook.imagepipeline.h.e inT;
    private final com.facebook.imagepipeline.a.a.d ind;
    private final b iom;
    @Nullable
    private final Map<com.facebook.c.c, b> ion;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.iom = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bYa = dVar2.bYa();
                if (bYa == com.facebook.c.b.ikK) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bYa == com.facebook.c.b.ikM) {
                    return a.this.a(dVar2, aVar);
                }
                if (bYa == com.facebook.c.b.ikS) {
                    return a.this.c(dVar2, aVar);
                }
                if (bYa == com.facebook.c.c.ikT) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.ind = dVar;
        this.FJ = config;
        this.inT = eVar;
        this.ion = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.imz != null) {
            return aVar.imz.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bYa = dVar.bYa();
        if (bYa == null || bYa == com.facebook.c.c.ikT) {
            bYa = com.facebook.c.d.s(dVar.getInputStream());
            dVar.c(bYa);
        }
        if (this.ion != null && (bVar = this.ion.get(bYa)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.iom.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.imx && this.ind != null) {
                b = this.ind.a(dVar, aVar, this.FJ);
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
        com.facebook.common.references.a<Bitmap> a = this.inT.a(dVar, aVar.imy);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.ioF, dVar.bXX());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.inT.a(dVar, aVar.imy, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bXX());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.ind.b(dVar, aVar, this.FJ);
    }
}
