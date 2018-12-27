package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FJ;
    private final com.facebook.imagepipeline.a.a.d iqo;
    private final com.facebook.imagepipeline.h.e ird;
    private final b irw;
    @Nullable
    private final Map<com.facebook.c.c, b> irx;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.irw = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bYQ = dVar2.bYQ();
                if (bYQ == com.facebook.c.b.inW) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bYQ == com.facebook.c.b.inY) {
                    return a.this.a(dVar2, aVar);
                }
                if (bYQ == com.facebook.c.b.ioe) {
                    return a.this.c(dVar2, aVar);
                }
                if (bYQ == com.facebook.c.c.iof) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.iqo = dVar;
        this.FJ = config;
        this.ird = eVar;
        this.irx = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.ipK != null) {
            return aVar.ipK.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bYQ = dVar.bYQ();
        if (bYQ == null || bYQ == com.facebook.c.c.iof) {
            bYQ = com.facebook.c.d.s(dVar.getInputStream());
            dVar.c(bYQ);
        }
        if (this.irx != null && (bVar = this.irx.get(bYQ)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.irw.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.ipI && this.iqo != null) {
                b = this.iqo.a(dVar, aVar, this.FJ);
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
        com.facebook.common.references.a<Bitmap> a = this.ird.a(dVar, aVar.ipJ);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.irP, dVar.bYN());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.ird.a(dVar, aVar.ipJ, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bYN());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.iqo.b(dVar, aVar, this.FJ);
    }
}
