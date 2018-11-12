package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final Bitmap.Config FJ;
    private final com.facebook.imagepipeline.a.a.d ifS;
    private final com.facebook.imagepipeline.h.e igH;
    private final b iha;
    @Nullable
    private final Map<com.facebook.c.c, b> ihb;

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config) {
        this(dVar, eVar, config, null);
    }

    public a(com.facebook.imagepipeline.a.a.d dVar, com.facebook.imagepipeline.h.e eVar, Bitmap.Config config, @Nullable Map<com.facebook.c.c, b> map) {
        this.iha = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar2, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
                com.facebook.c.c bVU = dVar2.bVU();
                if (bVU == com.facebook.c.b.idA) {
                    return a.this.b(dVar2, i, gVar, aVar);
                }
                if (bVU == com.facebook.c.b.idC) {
                    return a.this.a(dVar2, aVar);
                }
                if (bVU == com.facebook.c.b.idI) {
                    return a.this.c(dVar2, aVar);
                }
                if (bVU == com.facebook.c.c.idJ) {
                    throw new IllegalArgumentException("unknown image format");
                }
                return a.this.b(dVar2, aVar);
            }
        };
        this.ifS = dVar;
        this.FJ = config;
        this.igH = eVar;
        this.ihb = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        b bVar;
        if (aVar.ifo != null) {
            return aVar.ifo.a(dVar, i, gVar, aVar);
        }
        com.facebook.c.c bVU = dVar.bVU();
        if (bVU == null || bVU == com.facebook.c.c.idJ) {
            bVU = com.facebook.c.d.r(dVar.getInputStream());
            dVar.c(bVU);
        }
        if (this.ihb != null && (bVar = this.ihb.get(bVU)) != null) {
            return bVar.a(dVar, i, gVar, aVar);
        }
        return this.iha.a(dVar, i, gVar, aVar);
    }

    public com.facebook.imagepipeline.f.b a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.imagepipeline.f.b b;
        InputStream inputStream = dVar.getInputStream();
        if (inputStream == null) {
            return null;
        }
        try {
            if (!aVar.ifm && this.ifS != null) {
                b = this.ifS.a(dVar, aVar, this.FJ);
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
        com.facebook.common.references.a<Bitmap> a = this.igH.a(dVar, aVar.ifn);
        try {
            return new com.facebook.imagepipeline.f.c(a, com.facebook.imagepipeline.f.f.iht, dVar.bVR());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.d dVar, int i, g gVar, com.facebook.imagepipeline.common.a aVar) {
        com.facebook.common.references.a<Bitmap> a = this.igH.a(dVar, aVar.ifn, i);
        try {
            return new com.facebook.imagepipeline.f.c(a, gVar, dVar.bVR());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.f.b c(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.a aVar) {
        return this.ifS.b(dVar, aVar, this.FJ);
    }
}
