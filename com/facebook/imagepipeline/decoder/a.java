package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.a.a.d jHn;
    private final com.facebook.imagepipeline.h.e jIc;
    private final b jIy;
    @Nullable
    private final Map<com.facebook.c.c, b> jIz;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.jIy = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cyQ = dVar2.cyQ();
                if (cyQ == com.facebook.c.b.jEV) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cyQ == com.facebook.c.b.jEX) {
                    return a.this.a(dVar2, aVar);
                }
                if (cyQ == com.facebook.c.b.jFd) {
                    return a.this.c(dVar2, aVar);
                }
                if (cyQ == com.facebook.c.c.jFe) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jHn = dVar;
        this.FI = config;
        this.jIc = eVar;
        this.jIz = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jGJ != null) {
            return aVar.jGJ.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cyQ = dVar.cyQ();
        if (cyQ == null || cyQ == com.facebook.c.c.jFe) {
            cyQ = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cyQ);
        }
        if (this.jIz != null && (bVar = this.jIz.get(cyQ)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.jIy.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jGH && this.jHn != null) {
                b = this.jHn.a(dVar, aVar, this.FI);
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
        com.facebook.common.references.a<Bitmap> a = this.jIc.a(dVar, aVar.jGI);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.jIR, dVar.cyN());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.jIc.a(dVar, aVar.jGI, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cyN());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jHn.b(dVar, aVar, this.FI);
    }
}
