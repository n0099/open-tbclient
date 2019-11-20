package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final com.facebook.imagepipeline.a.a.d khD;
    private final b kiP;
    @Nullable
    private final Map<com.facebook.c.c, b> kiQ;
    private final com.facebook.imagepipeline.h.e kit;
    private final Bitmap.Config mBitmapConfig;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kiP = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cHN = dVar2.cHN();
                if (cHN == com.facebook.c.b.kfj) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cHN == com.facebook.c.b.kfl) {
                    return a.this.a(dVar2, aVar);
                }
                if (cHN == com.facebook.c.b.kfr) {
                    return a.this.c(dVar2, aVar);
                }
                if (cHN == com.facebook.c.c.kfs) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.khD = dVar;
        this.mBitmapConfig = config;
        this.kit = eVar;
        this.kiQ = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.kgZ != null) {
            return aVar.kgZ.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cHN = dVar.cHN();
        if (cHN == null || cHN == com.facebook.c.c.kfs) {
            cHN = com.facebook.c.d.r(dVar.getInputStream());
            dVar.c(cHN);
        }
        if (this.kiQ != null && (bVar = this.kiQ.get(cHN)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kiP.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.kgX && this.khD != null) {
                b = this.khD.a(dVar, aVar, this.mBitmapConfig);
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
        com.facebook.common.references.a<Bitmap> a = this.kit.a(dVar, aVar.kgY);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kji, dVar.cHK());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kit.a(dVar, aVar.kgY, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cHK());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.khD.b(dVar, aVar, this.mBitmapConfig);
    }
}
