package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes9.dex */
public final class a implements com.kwad.sdk.pngencrypt.g {
    public boolean alt;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.alt = true;
    }

    public static PngChunk a(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("IDAT")) {
            return new g(kVar);
        }
        if (str.equals("IHDR")) {
            return new i(kVar);
        }
        if (str.equals("PLTE")) {
            return new m(kVar);
        }
        if (str.equals("IEND")) {
            return new h(kVar);
        }
        if (str.equals("tEXt")) {
            return new q(kVar);
        }
        if (str.equals("iTXt")) {
            return new j(kVar);
        }
        if (str.equals("zTXt")) {
            return new v(kVar);
        }
        if (str.equals("tIME")) {
            return new r(kVar);
        }
        if (str.equals("tRNS")) {
            return new s(kVar);
        }
        if (str.equals("sPLT")) {
            return new n(kVar);
        }
        return null;
    }

    public static PngChunk b(String str, com.kwad.sdk.pngencrypt.k kVar) {
        return new u(str, kVar);
    }

    public static PngChunk c(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("oFFs")) {
            return new l(kVar);
        }
        if (str.equals("sTER")) {
            return new o(kVar);
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.g
    public final PngChunk a(d dVar, com.kwad.sdk.pngencrypt.k kVar) {
        PngChunk a = a(dVar.alB, kVar);
        if (a == null) {
            a = c(dVar.alB, kVar);
        }
        if (a == null) {
            a = b(dVar.alB, kVar);
        }
        a.b(dVar);
        if (this.alt && dVar.data != null) {
            a.a(dVar);
        }
        return a;
    }
}
