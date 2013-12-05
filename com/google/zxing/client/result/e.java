package com.google.zxing.client.result;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class e extends a {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public d b(com.google.zxing.h hVar) {
        String c = c(hVar);
        if (!c.startsWith("BIZCARD:")) {
            return null;
        }
        String a2 = a(b("N:", c, true), b("X:", c, true));
        String b = b("T:", c, true);
        String b2 = b("C:", c, true);
        return new d(b(a2), null, null, a(b("B:", c, true), b("M:", c, true), b("F:", c, true)), null, b(b("E:", c, true)), null, null, null, a("A:", c, true), null, b2, null, b, null, null);
    }

    private static String[] a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            str = String.valueOf(str) + ' ' + str2;
        }
        return str;
    }
}
