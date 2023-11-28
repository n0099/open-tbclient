package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class d {
    public static boolean bd(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String aW = bVar.aW("Location");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (bd(responseCode)) {
            if (aW != null) {
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", aW, Integer.valueOf(responseCode), arrayList);
                }
                bVar.uU();
                bVar = a(map, aW);
                arrayList.add(aW);
                bVar.execute();
                responseCode = bVar.getResponseCode();
                aW = bVar.aW("Location");
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException(f.b("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(f.b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.uT()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    public static b a(Map<String, List<String>> map, String str) {
        b ba = com.kwad.framework.filedownloader.download.b.ve().ba(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    ba.addHeader(key, str2);
                }
            }
        }
        return ba;
    }
}
