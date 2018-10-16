package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FF;
    private final com.facebook.imagepipeline.h.e ieW;
    private final com.facebook.imagepipeline.a.a.d ieh;
    private final b ifp;
    @Nullable
    private final Map<com.facebook.c.c, b> ifq;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.ifp = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bWz = dVar2.bWz();
                if (bWz == com.facebook.c.b.ibM) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bWz == com.facebook.c.b.ibO) {
                    return a.this.a(dVar2, aVar);
                }
                if (bWz == com.facebook.c.b.ibU) {
                    return a.this.c(dVar2, aVar);
                }
                if (bWz == com.facebook.c.c.ibV) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.ieh = dVar;
        this.FF = config;
        this.ieW = eVar;
        this.ifq = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.idD != null) {
            return aVar.idD.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bWz = dVar.bWz();
        if (bWz == null || bWz == com.facebook.c.c.ibV) {
            bWz = com.facebook.c.d.r(dVar.getInputStream());
            dVar.c(bWz);
        }
        if (this.ifq != null && (bVar = this.ifq.get(bWz)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.ifp.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.idB && this.ieh != null) {
                b = this.ieh.a(dVar, aVar, this.FF);
            } else {
                b = b(dVar, aVar);
                com.facebook.common.internal.b.n(inputStream);
            }
            return b;
        } finally {
            com.facebook.common.internal.b.n(inputStream);
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.ieW.a(dVar, aVar.idC);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.ifI, dVar.bWw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.ieW.a(dVar, aVar.idC, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bWw());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.ieh.b(dVar, aVar, this.FF);
    }
}
