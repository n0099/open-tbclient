package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    public final com.kwad.sdk.pngencrypt.k b;
    public List<PngChunk> a = new ArrayList();
    public boolean c = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.b = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.a.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (pngChunk.a.equals(str)) {
                    if (!(pngChunk instanceof t) || ((t) pngChunk).a().equals(str2)) {
                        return !(pngChunk instanceof n) || ((n) pngChunk).a().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public final List<PngChunk> a() {
        return this.a;
    }

    public final List<? extends PngChunk> a(String str, String str2) {
        return a(this.a, str, str2);
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.a(i);
        this.a.add(pngChunk);
        if (pngChunk.a.equals("PLTE")) {
            this.c = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.a.size();
    }
}
