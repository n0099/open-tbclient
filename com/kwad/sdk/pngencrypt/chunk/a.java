package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.pngencrypt.g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34207a;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.f34207a = z;
    }

    @Override // com.kwad.sdk.pngencrypt.g
    public final PngChunk a(d dVar, com.kwad.sdk.pngencrypt.k kVar) {
        PngChunk a2 = a(dVar.f34224c, kVar);
        if (a2 == null) {
            a2 = c(dVar.f34224c, kVar);
        }
        if (a2 == null) {
            a2 = b(dVar.f34224c, kVar);
        }
        a2.b(dVar);
        if (this.f34207a && dVar.f34225d != null) {
            a2.a(dVar);
        }
        return a2;
    }

    public final PngChunk a(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("IDAT")) {
            return new o(kVar);
        }
        if (str.equals("IHDR")) {
            return new q(kVar);
        }
        if (str.equals("PLTE")) {
            return new v(kVar);
        }
        if (str.equals("IEND")) {
            return new p(kVar);
        }
        if (str.equals("tEXt")) {
            return new ab(kVar);
        }
        if (str.equals("iTXt")) {
            return new r(kVar);
        }
        if (str.equals("zTXt")) {
            return new ag(kVar);
        }
        if (str.equals("bKGD")) {
            return new h(kVar);
        }
        if (str.equals("gAMA")) {
            return new l(kVar);
        }
        if (str.equals("pHYs")) {
            return new u(kVar);
        }
        if (str.equals("iCCP")) {
            return new n(kVar);
        }
        if (str.equals("tIME")) {
            return new ac(kVar);
        }
        if (str.equals("tRNS")) {
            return new ad(kVar);
        }
        if (str.equals("cHRM")) {
            return new i(kVar);
        }
        if (str.equals("sBIT")) {
            return new w(kVar);
        }
        if (str.equals("sRGB")) {
            return new y(kVar);
        }
        if (str.equals("hIST")) {
            return new m(kVar);
        }
        if (str.equals("sPLT")) {
            return new x(kVar);
        }
        if (str.equals("fdAT")) {
            return new k(kVar);
        }
        if (str.equals("acTL")) {
            return new g(kVar);
        }
        if (str.equals("fcTL")) {
            return new j(kVar);
        }
        return null;
    }

    public final PngChunk b(String str, com.kwad.sdk.pngencrypt.k kVar) {
        return new af(str, kVar);
    }

    public PngChunk c(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("oFFs")) {
            return new t(kVar);
        }
        if (str.equals("sTER")) {
            return new z(kVar);
        }
        return null;
    }
}
