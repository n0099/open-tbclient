package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Dr;
    private final com.facebook.imagepipeline.a.a.d jZz;
    private final b kaK;
    @Nullable
    private final Map<com.facebook.c.c, b> kaL;
    private final com.facebook.imagepipeline.h.e kao;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kaK = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cGG = dVar2.cGG();
                if (cGG == com.facebook.c.b.jXh) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cGG == com.facebook.c.b.jXj) {
                    return a.this.a(dVar2, aVar);
                }
                if (cGG == com.facebook.c.b.jXp) {
                    return a.this.c(dVar2, aVar);
                }
                if (cGG == com.facebook.c.c.jXq) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jZz = dVar;
        this.Dr = config;
        this.kao = eVar;
        this.kaL = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jYV != null) {
            return aVar.jYV.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cGG = dVar.cGG();
        if (cGG == null || cGG == com.facebook.c.c.jXq) {
            cGG = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cGG);
        }
        if (this.kaL != null && (bVar = this.kaL.get(cGG)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kaK.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jYT && this.jZz != null) {
                b = this.jZz.a(dVar, aVar, this.Dr);
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
        com.facebook.common.references.a<Bitmap> a = this.kao.a(dVar, aVar.jYU);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kbd, dVar.cGD());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kao.a(dVar, aVar.jYU, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cGD());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jZz.b(dVar, aVar, this.Dr);
    }
}
