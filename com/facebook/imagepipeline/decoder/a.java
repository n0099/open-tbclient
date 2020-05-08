package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e mcH;
    private final b mdf;
    private final b mdg;
    private final b mdh;
    @Nullable
    private final Map<com.facebook.c.c, b> mdi;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.mdh = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dsS = eVar2.dsS();
                if (dsS == com.facebook.c.b.lYQ) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dsS == com.facebook.c.b.lYS) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dsS == com.facebook.c.b.lYY) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dsS == com.facebook.c.c.lZa) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.mdf = bVar;
        this.mdg = bVar2;
        this.mcH = eVar;
        this.mdi = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.mbi != null) {
            return bVar.mbi.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dsS = eVar.dsS();
        if (dsS == null || dsS == com.facebook.c.c.lZa) {
            dsS = com.facebook.c.d.s(eVar.getInputStream());
            eVar.c(dsS);
        }
        if (this.mdi != null && (bVar2 = this.mdi.get(dsS)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.mdh.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.mbg || this.mdf == null) ? a(eVar, bVar) : this.mdf.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mcH.a(eVar, bVar.mbh, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.mdC, eVar.dsO(), eVar.dsP());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mcH.a(eVar, bVar.mbh, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dsO(), eVar.dsP());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.mdg.a(eVar, i, hVar, bVar);
    }
}
