package com.google.zxing.client.result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class u extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public v b(com.google.zxing.h hVar) {
        String str;
        String str2;
        String substring;
        String c = c(hVar);
        if (!c.startsWith("sms:") && !c.startsWith("SMS:") && !c.startsWith("mms:") && !c.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> d = d(c);
        boolean z = false;
        if (d == null || d.isEmpty()) {
            str = null;
            str2 = null;
        } else {
            str = d.get("body");
            str2 = d.get("subject");
            z = true;
        }
        int indexOf = c.indexOf(63, 4);
        if (indexOf < 0 || !z) {
            substring = c.substring(4);
        } else {
            substring = c.substring(4, indexOf);
        }
        int i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int indexOf2 = substring.indexOf(44, i + 1);
            if (indexOf2 > i) {
                a(arrayList, arrayList2, substring.substring(i + 1, indexOf2));
                i = indexOf2;
            } else {
                a(arrayList, arrayList2, substring.substring(i + 1));
                return new v((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }

    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        collection2.add(substring.startsWith("via=") ? substring.substring(4) : null);
    }
}
