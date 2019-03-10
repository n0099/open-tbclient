package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.a.a.d jHv;
    private final b jIG;
    @Nullable
    private final Map<com.facebook.c.c, b> jIH;
    private final com.facebook.imagepipeline.h.e jIk;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.jIG = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cyN = dVar2.cyN();
                if (cyN == com.facebook.c.b.jFd) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cyN == com.facebook.c.b.jFf) {
                    return a.this.a(dVar2, aVar);
                }
                if (cyN == com.facebook.c.b.jFl) {
                    return a.this.c(dVar2, aVar);
                }
                if (cyN == com.facebook.c.c.jFm) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jHv = dVar;
        this.FI = config;
        this.jIk = eVar;
        this.jIH = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jGR != null) {
            return aVar.jGR.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cyN = dVar.cyN();
        if (cyN == null || cyN == com.facebook.c.c.jFm) {
            cyN = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cyN);
        }
        if (this.jIH != null && (bVar = this.jIH.get(cyN)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.jIG.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jGP && this.jHv != null) {
                b = this.jHv.a(dVar, aVar, this.FI);
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
        com.facebook.common.references.a<Bitmap> a = this.jIk.a(dVar, aVar.jGQ);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.jIZ, dVar.cyK());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.jIk.a(dVar, aVar.jGQ, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cyK());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jHv.b(dVar, aVar, this.FI);
    }
}
