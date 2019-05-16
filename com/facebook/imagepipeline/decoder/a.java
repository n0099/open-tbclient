package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Ds;
    private final com.facebook.imagepipeline.a.a.d jZv;
    private final b kaG;
    @Nullable
    private final Map<com.facebook.c.c, b> kaH;
    private final com.facebook.imagepipeline.h.e kak;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kaG = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cGF = dVar2.cGF();
                if (cGF == com.facebook.c.b.jXd) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cGF == com.facebook.c.b.jXf) {
                    return a.this.a(dVar2, aVar);
                }
                if (cGF == com.facebook.c.b.jXl) {
                    return a.this.c(dVar2, aVar);
                }
                if (cGF == com.facebook.c.c.jXm) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jZv = dVar;
        this.Ds = config;
        this.kak = eVar;
        this.kaH = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jYR != null) {
            return aVar.jYR.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cGF = dVar.cGF();
        if (cGF == null || cGF == com.facebook.c.c.jXm) {
            cGF = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cGF);
        }
        if (this.kaH != null && (bVar = this.kaH.get(cGF)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kaG.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jYP && this.jZv != null) {
                b = this.jZv.a(dVar, aVar, this.Ds);
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
        com.facebook.common.references.a<Bitmap> a = this.kak.a(dVar, aVar.jYQ);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kaZ, dVar.cGC());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kak.a(dVar, aVar.jYQ, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cGC());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jZv.b(dVar, aVar, this.Ds);
    }
}
