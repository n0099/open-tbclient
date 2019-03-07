package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.h.e jHR;
    private final com.facebook.imagepipeline.a.a.d jHc;
    private final b jIn;
    @Nullable
    private final Map<com.facebook.c.c, b> jIo;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.jIn = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c cyD = dVar2.cyD();
                if (cyD == com.facebook.c.b.jEK) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (cyD == com.facebook.c.b.jEM) {
                    return a.this.a(dVar2, aVar);
                }
                if (cyD == com.facebook.c.b.jES) {
                    return a.this.c(dVar2, aVar);
                }
                if (cyD == com.facebook.c.c.jET) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.jHc = dVar;
        this.FI = config;
        this.jHR = eVar;
        this.jIo = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.jGy != null) {
            return aVar.jGy.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c cyD = dVar.cyD();
        if (cyD == null || cyD == com.facebook.c.c.jET) {
            cyD = com.facebook.c.d.u(dVar.getInputStream());
            dVar.c(cyD);
        }
        if (this.jIo != null && (bVar = this.jIo.get(cyD)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.jIn.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.jGw && this.jHc != null) {
                b = this.jHc.a(dVar, aVar, this.FI);
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
        com.facebook.common.references.a<Bitmap> a = this.jHR.a(dVar, aVar.jGx);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.jIG, dVar.cyA());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.jHR.a(dVar, aVar.jGx, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.cyA());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.jHc.b(dVar, aVar, this.FI);
    }
}
