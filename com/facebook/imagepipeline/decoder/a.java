package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Ds;
    private final com.facebook.imagepipeline.a.a.d jZw;
    private final b kaH;
    @Nullable
    private final Map<com.facebook.c.c, b> kaI;
    private final com.facebook.imagepipeline.h.e kal;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kaH = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cGH = dVar2.cGH();
                if (cGH == com.facebook.c.b.jXe) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cGH == com.facebook.c.b.jXg) {
                    return a.this.a(dVar2, aVar);
                }
                if (cGH == com.facebook.c.b.jXm) {
                    return a.this.c(dVar2, aVar);
                }
                if (cGH == com.facebook.c.c.jXn) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jZw = dVar;
        this.Ds = config;
        this.kal = eVar;
        this.kaI = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jYS != null) {
            return aVar.jYS.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cGH = dVar.cGH();
        if (cGH == null || cGH == com.facebook.c.c.jXn) {
            cGH = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cGH);
        }
        if (this.kaI != null && (bVar = this.kaI.get(cGH)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kaH.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jYQ && this.jZw != null) {
                b = this.jZw.a(dVar, aVar, this.Ds);
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
        com.facebook.common.references.a<Bitmap> a = this.kal.a(dVar, aVar.jYR);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kba, dVar.cGE());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kal.a(dVar, aVar.jYR, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cGE());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jZw.b(dVar, aVar, this.Ds);
    }
}
