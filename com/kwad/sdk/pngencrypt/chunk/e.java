package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    final com.kwad.sdk.pngencrypt.k f10803b;

    /* renamed from: a  reason: collision with root package name */
    List<PngChunk> f10802a = new ArrayList();
    boolean c = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.f10803b = kVar;
    }

    protected static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                return pngChunk.f10793a.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                if (pngChunk.f10793a.equals(str)) {
                    if (!(pngChunk instanceof ae) || ((ae) pngChunk).c().equals(str2)) {
                        return !(pngChunk instanceof x) || ((x) pngChunk).c().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    public List<PngChunk> a() {
        return this.f10802a;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        return a(this.f10802a, str, str2);
    }

    public void a(PngChunk pngChunk, int i) {
        pngChunk.a(i);
        this.f10802a.add(pngChunk);
        if (pngChunk.f10793a.equals("PLTE")) {
            this.c = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.f10802a.size();
    }
}
