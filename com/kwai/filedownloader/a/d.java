package com.kwai.filedownloader.a;

import com.baidubce.http.Headers;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int e = bVar.e();
        String a2 = bVar.a(Headers.LOCATION);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (a(e)) {
            if (a2 == null) {
                throw new IllegalAccessException(f.a("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(e), bVar.c()));
            }
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", a2, Integer.valueOf(e), arrayList);
            }
            bVar.f();
            bVar = a(map, a2);
            arrayList.add(a2);
            bVar.d();
            e = bVar.e();
            a2 = bVar.a(Headers.LOCATION);
            i++;
            if (i >= 10) {
                throw new IllegalAccessException(f.a("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b a2 = com.kwai.filedownloader.download.b.a().a(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    a2.a(key, str2);
                }
            }
        }
        return a2;
    }

    private static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
