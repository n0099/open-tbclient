package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Dx;
    private final com.facebook.imagepipeline.a.a.d kgF;
    private final b khQ;
    @Nullable
    private final Map<com.facebook.c.c, b> khR;
    private final com.facebook.imagepipeline.h.e khu;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.khQ = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cJJ = dVar2.cJJ();
                if (cJJ == com.facebook.c.b.kel) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cJJ == com.facebook.c.b.ken) {
                    return a.this.a(dVar2, aVar);
                }
                if (cJJ == com.facebook.c.b.ket) {
                    return a.this.c(dVar2, aVar);
                }
                if (cJJ == com.facebook.c.c.keu) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.kgF = dVar;
        this.Dx = config;
        this.khu = eVar;
        this.khR = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.kgb != null) {
            return aVar.kgb.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cJJ = dVar.cJJ();
        if (cJJ == null || cJJ == com.facebook.c.c.keu) {
            cJJ = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cJJ);
        }
        if (this.khR != null && (bVar = this.khR.get(cJJ)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.khQ.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.kfZ && this.kgF != null) {
                b = this.kgF.a(dVar, aVar, this.Dx);
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
        com.facebook.common.references.a<Bitmap> a = this.khu.a(dVar, aVar.kga);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kik, dVar.cJG());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.khu.a(dVar, aVar.kga, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cJG());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.kgF.b(dVar, aVar, this.Dx);
    }
}
