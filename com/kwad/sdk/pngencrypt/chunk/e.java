package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f36962b;

    /* renamed from: a  reason: collision with root package name */
    public List<PngChunk> f36961a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f36963c = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.f36962b = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                return pngChunk.f36931a.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                if (pngChunk.f36931a.equals(str)) {
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
        return this.f36961a;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        return a(this.f36961a, str, str2);
    }

    public void a(PngChunk pngChunk, int i2) {
        pngChunk.a(i2);
        this.f36961a.add(pngChunk);
        if (pngChunk.f36931a.equals("PLTE")) {
            this.f36963c = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.f36961a.size();
    }
}
