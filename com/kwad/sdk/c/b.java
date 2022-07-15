package com.kwad.sdk.c;

import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements a {
    public static volatile b a;
    public static c b;

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put("errorCode", String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }

    public static void a(c cVar) {
        b = cVar;
    }

    public static synchronized b t() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            bVar = a;
        }
        return bVar;
    }

    public static String u() {
        return a(false, "", 2);
    }

    @Override // com.kwad.sdk.c.a
    public final String a() {
        c cVar = b;
        return cVar != null ? cVar.a() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String b() {
        c cVar = b;
        return cVar != null ? cVar.b() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String c() {
        c cVar = b;
        return cVar != null ? cVar.c() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String d() {
        c cVar = b;
        return cVar != null ? cVar.d() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String e() {
        c cVar = b;
        return cVar != null ? cVar.e() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String f() {
        c cVar = b;
        return cVar != null ? cVar.f() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String g() {
        c cVar = b;
        return cVar != null ? cVar.g() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String h() {
        c cVar = b;
        return cVar != null ? cVar.h() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String i() {
        c cVar = b;
        return cVar != null ? cVar.i() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String j() {
        c cVar = b;
        return cVar != null ? cVar.j() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String k() {
        c cVar = b;
        return cVar != null ? cVar.k() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String l() {
        c cVar = b;
        return cVar != null ? cVar.l() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String m() {
        c cVar = b;
        return cVar != null ? cVar.m() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String n() {
        c cVar = b;
        return cVar != null ? cVar.n() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String o() {
        c cVar = b;
        return cVar != null ? cVar.o() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String p() {
        c cVar = b;
        return cVar != null ? cVar.p() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String q() {
        c cVar = b;
        return cVar != null ? cVar.q() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String r() {
        c cVar = b;
        return cVar != null ? cVar.r() : u();
    }

    @Override // com.kwad.sdk.c.a
    public final String s() {
        c cVar = b;
        return cVar != null ? cVar.s() : u();
    }
}
