package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e mTP;
    private final b mUq;
    private final b mUr;
    private final b mUs;
    @Nullable
    private final Map<com.facebook.c.c, b> mUt;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.mUs = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dFf = eVar2.dFf();
                if (dFf == com.facebook.c.b.mPX) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dFf == com.facebook.c.b.mPZ) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dFf == com.facebook.c.b.mQf) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dFf == com.facebook.c.c.mQh) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.mUq = bVar;
        this.mUr = bVar2;
        this.mTP = eVar;
        this.mUt = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.mSl != null) {
            return bVar.mSl.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dFf = eVar.dFf();
        if (dFf == null || dFf == com.facebook.c.c.mQh) {
            dFf = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dFf);
        }
        if (this.mUt != null && (bVar2 = this.mUt.get(dFf)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.mUs.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.mSj || this.mUq == null) ? a(eVar, bVar) : this.mUq.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mTP.a(eVar, bVar.mSk, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.mUN, eVar.dFb(), eVar.dFc());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mTP.a(eVar, bVar.mSk, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dFb(), eVar.dFc());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.mUr.a(eVar, i, hVar, bVar);
    }
}
