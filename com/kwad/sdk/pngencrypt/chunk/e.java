package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f34230b;

    /* renamed from: a  reason: collision with root package name */
    public List<PngChunk> f34229a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f34231c = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.f34230b = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                return pngChunk.f34199a.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                if (pngChunk.f34199a.equals(str)) {
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
        return this.f34229a;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        return a(this.f34229a, str, str2);
    }

    public void a(PngChunk pngChunk, int i2) {
        pngChunk.a(i2);
        this.f34229a.add(pngChunk);
        if (pngChunk.f34199a.equals("PLTE")) {
            this.f34231c = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.f34229a.size();
    }
}
