package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config Dx;
    private final com.facebook.imagepipeline.a.a.d khL;
    private final com.facebook.imagepipeline.h.e kiB;
    private final b kiX;
    @Nullable
    private final Map<com.facebook.c.c, b> kiY;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.kiX = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cKe = dVar2.cKe();
                if (cKe == com.facebook.c.b.kfs) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cKe == com.facebook.c.b.kfu) {
                    return a.this.a(dVar2, aVar);
                }
                if (cKe == com.facebook.c.b.kfA) {
                    return a.this.c(dVar2, aVar);
                }
                if (cKe == com.facebook.c.c.kfB) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.khL = dVar;
        this.Dx = config;
        this.kiB = eVar;
        this.kiY = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.khh != null) {
            return aVar.khh.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cKe = dVar.cKe();
        if (cKe == null || cKe == com.facebook.c.c.kfB) {
            cKe = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cKe);
        }
        if (this.kiY != null && (bVar = this.kiY.get(cKe)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.kiX.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.khf && this.khL != null) {
                b = this.khL.a(dVar, aVar, this.Dx);
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
        com.facebook.common.references.a<Bitmap> a = this.kiB.a(dVar, aVar.khg);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.kjq, dVar.cKb());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.kiB.a(dVar, aVar.khg, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cKb());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.khL.b(dVar, aVar, this.Dx);
    }
}
