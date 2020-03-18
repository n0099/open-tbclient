package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e lUQ;
    private final b lVq;
    private final b lVr;
    private final b lVs;
    @Nullable
    private final Map<com.facebook.c.c, b> lVt;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lVs = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dqX = eVar2.dqX();
                if (dqX == com.facebook.c.b.lRh) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dqX == com.facebook.c.b.lRj) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dqX == com.facebook.c.b.lRp) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dqX == com.facebook.c.c.lRr) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lVq = bVar;
        this.lVr = bVar2;
        this.lUQ = eVar;
        this.lVt = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lTr != null) {
            return bVar.lTr.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dqX = eVar.dqX();
        if (dqX == null || dqX == com.facebook.c.c.lRr) {
            dqX = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dqX);
        }
        if (this.lVt != null && (bVar2 = this.lVt.get(dqX)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lVs.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lTq || this.lVq == null) ? a(eVar, bVar) : this.lVq.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lUQ.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lVN, eVar.dqT(), eVar.dqU());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lUQ.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dqT(), eVar.dqU());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lVr.a(eVar, i, hVar, bVar);
    }
}
