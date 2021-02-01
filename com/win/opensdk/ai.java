package com.win.opensdk;

import com.baidubce.http.Headers;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes3.dex */
public final class ai {
    public static void a(String str, r<am> rVar) {
        try {
            rVar.eIP();
            t eIT = new s(str, "GET", eJc()).eIT();
            am amVar = new am();
            int a2 = a(eIT, amVar);
            if (a2 == 200) {
                rVar.bH(amVar);
            } else {
                rVar.ck(a2, amVar.f23java);
            }
        } catch (JSONException e) {
            rVar.ck(101, e.getMessage());
        } catch (Exception e2) {
            rVar.ck(100, e2.getMessage());
        }
    }

    public static HashMap<String, List<String>> eJc() {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.put(Headers.ACCEPT_ENCODING, Collections.singletonList("application/gzip"));
        hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("User-Agent", Collections.singletonList(be.java));
        return hashMap;
    }

    public static int a(t tVar, am amVar) {
        byte[] bArr = tVar.qjD;
        int i = tVar.java;
        if (i == 200) {
            amVar.abF(new String(bArr, "UTF-8"));
            return amVar.java;
        }
        return i;
    }
}
