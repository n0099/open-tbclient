package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final com.facebook.imagepipeline.a.a.d kiv;
    private final b kjG;
    @Nullable
    private final Map<com.facebook.c.c, b> kjH;
    private final com.facebook.imagepipeline.h.e kjk;
    private final Bitmap.Config mBitmapConfig;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kjG = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cHP = dVar2.cHP();
                if (cHP == com.facebook.c.b.kga) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cHP == com.facebook.c.b.kgc) {
                    return a.this.a(dVar2, aVar);
                }
                if (cHP == com.facebook.c.b.kgi) {
                    return a.this.c(dVar2, aVar);
                }
                if (cHP == com.facebook.c.c.kgj) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.kiv = dVar;
        this.mBitmapConfig = config;
        this.kjk = eVar;
        this.kjH = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.khQ != null) {
            return aVar.khQ.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cHP = dVar.cHP();
        if (cHP == null || cHP == com.facebook.c.c.kgj) {
            cHP = com.facebook.c.d.r(dVar.getInputStream());
            dVar.c(cHP);
        }
        if (this.kjH != null && (bVar = this.kjH.get(cHP)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kjG.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.khO && this.kiv != null) {
                b = this.kiv.a(dVar, aVar, this.mBitmapConfig);
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
        com.facebook.common.references.a<Bitmap> a = this.kjk.a(dVar, aVar.khP);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kjZ, dVar.cHM());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kjk.a(dVar, aVar.khP, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cHM());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.kiv.b(dVar, aVar, this.mBitmapConfig);
    }
}
