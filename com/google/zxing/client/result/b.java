package com.google.zxing.client.result;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public d b(com.google.zxing.h hVar) {
        String c = c(hVar);
        if (!c.contains("MEMORY") || !c.contains("\r\n")) {
            return null;
        }
        String b = b("NAME1:", c, '\r', true);
        String b2 = b("NAME2:", c, '\r', true);
        String[] a2 = a("TEL", 3, c, true);
        String[] a3 = a("MAIL", 3, c, true);
        String b3 = b("MEMORY:", c, '\r', false);
        String b4 = b("ADD:", c, '\r', true);
        return new d(b(b), null, b2, a2, null, a3, null, null, b3, b4 == null ? null : new String[]{b4}, null, null, null, null, null, null);
    }

    private static String[] a(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b = b(String.valueOf(str) + i2 + ':', str2, '\r', z);
            if (b == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(b);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
