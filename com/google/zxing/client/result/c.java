package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class c extends a {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public d b(com.google.zxing.h hVar) {
        String[] a2;
        String c = c(hVar);
        if (!c.startsWith("MECARD:") || (a2 = a("N:", c, true)) == null) {
            return null;
        }
        String a3 = a(a2[0]);
        String b = b("SOUND:", c, true);
        String[] a4 = a("TEL:", c, true);
        String[] a5 = a("EMAIL:", c, true);
        String b2 = b("NOTE:", c, false);
        String[] a6 = a("ADR:", c, true);
        String b3 = b("BDAY:", c, true);
        if (b3 != null && !a(b3, 8)) {
            b3 = null;
        }
        return new d(b(a3), null, b, a4, null, a5, null, null, b2, a6, null, b("ORG:", c, true), b3, null, a("URL:", c, true), null);
    }

    private static String a(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            return String.valueOf(str.substring(indexOf + 1)) + ' ' + str.substring(0, indexOf);
        }
        return str;
    }
}
