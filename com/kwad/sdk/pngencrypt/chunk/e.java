package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    public final com.kwad.sdk.pngencrypt.k aIB;
    public List<PngChunk> aKu = new ArrayList();
    public boolean aKv = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aIB = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.c
                public final boolean a(PngChunk pngChunk) {
                    return pngChunk.agT.equals(str);
                }
            });
        }
        return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.agT.equals(str)) {
                    return false;
                }
                if ((pngChunk instanceof t) && !((t) pngChunk).getKey().equals(str2)) {
                    return false;
                }
                if ((pngChunk instanceof n) && !((n) pngChunk).IT().equals(str2)) {
                    return false;
                }
                return true;
            }
        });
    }

    public final List<PngChunk> IK() {
        return this.aKu;
    }

    public String toString() {
        return "ChunkList: read: " + this.aKu.size();
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.dq(i);
        this.aKu.add(pngChunk);
        if (pngChunk.agT.equals("PLTE")) {
            this.aKv = true;
        }
    }

    public final List<? extends PngChunk> ak(String str, String str2) {
        return a(this.aKu, str, str2);
    }
}
