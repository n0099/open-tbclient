package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    public final com.kwad.sdk.pngencrypt.k ajL;
    public List<PngChunk> alF = new ArrayList();
    public boolean alG = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.ajL = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.alB.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (pngChunk.alB.equals(str)) {
                    if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                        return !(pngChunk instanceof n) || ((n) pngChunk).yQ().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public final List<? extends PngChunk> M(String str, String str2) {
        return a(this.alF, str, str2);
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.br(i);
        this.alF.add(pngChunk);
        if (pngChunk.alB.equals("PLTE")) {
            this.alG = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.alF.size();
    }

    public final List<PngChunk> yH() {
        return this.alF;
    }
}
