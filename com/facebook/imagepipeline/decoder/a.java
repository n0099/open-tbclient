package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.a.a.d jGH;
    private final b jHS;
    @Nullable
    private final Map<com.facebook.c.c, b> jHT;
    private final com.facebook.imagepipeline.h.e jHw;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.jHS = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cyJ = dVar2.cyJ();
                if (cyJ == com.facebook.c.b.jEp) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cyJ == com.facebook.c.b.jEr) {
                    return a.this.a(dVar2, aVar);
                }
                if (cyJ == com.facebook.c.b.jEx) {
                    return a.this.c(dVar2, aVar);
                }
                if (cyJ == com.facebook.c.c.jEy) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jGH = dVar;
        this.FI = config;
        this.jHw = eVar;
        this.jHT = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jGd != null) {
            return aVar.jGd.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cyJ = dVar.cyJ();
        if (cyJ == null || cyJ == com.facebook.c.c.jEy) {
            cyJ = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cyJ);
        }
        if (this.jHT != null && (bVar = this.jHT.get(cyJ)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.jHS.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jGb && this.jGH != null) {
                b = this.jGH.a(dVar, aVar, this.FI);
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
        com.facebook.common.references.a<Bitmap> a = this.jHw.a(dVar, aVar.jGc);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.jIl, dVar.cyG());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.jHw.a(dVar, aVar.jGc, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cyG());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jGH.b(dVar, aVar, this.FI);
    }
}
