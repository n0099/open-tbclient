package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes10.dex */
public final class h {
    public final Map<String, HashMap<Integer, String>> Yr = new ConcurrentHashMap();
    public Map<String, Integer> Ys = new ConcurrentSkipListMap();
    public int Yt = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public static final h Yu = new h();
    }

    public static h sr() {
        return a.Yu;
    }

    public static int aH(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void aM(int i) {
        if (this.Yt + i > com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqW)) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.Ys.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.Yt -= next.getValue().intValue();
                it.remove();
                if (this.Yt <= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqW) - i) {
                    break;
                }
            }
            for (String str : arrayList) {
                this.Yr.remove(str);
            }
        }
    }

    private void n(String str, String str2) {
        int aH = aH(str2);
        this.Yt += aH;
        this.Ys.put(str, Integer.valueOf(aH));
    }

    public final String o(String str, int i) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqW) != 0 && this.Yr.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.Yr.get(str);
            if (hashMap.containsKey(Integer.valueOf(i))) {
                return hashMap.get(Integer.valueOf(i));
            }
        }
        return "";
    }

    public final void b(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str2) && com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqW) != 0) {
            if (this.Yr.containsKey(str)) {
                if (this.Yr.get(str).containsKey(Integer.valueOf(i))) {
                    return;
                }
                this.Yr.remove(str);
            }
            aM(aH(str2));
            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(Integer.valueOf(i), str2);
            this.Yr.put(str, hashMap);
            n(str, str2);
        }
    }
}
