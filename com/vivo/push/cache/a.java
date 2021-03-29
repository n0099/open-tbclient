package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends d<com.vivo.push.model.a> {
    public a(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.d
    public final String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.d
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split(com.vivo.push.cache.impl.a.SPILTE_TAG)) {
                String trim = str2.trim();
                String[] split = trim.trim().split(",");
                if (split.length >= 2) {
                    try {
                        arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                    } catch (Exception e2) {
                        p.d("AppConfigSettings", "str2Clients E: " + e2);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.d
    public final String b(String str) throws Exception {
        return new String(g.a(g.a(d.f39458a), g.a(d.f39459b), Base64.decode(str, 2)), "utf-8");
    }

    public final com.vivo.push.model.a c(String str) {
        synchronized (d.f39460c) {
            for (T t : this.f39461d) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }

    public final int b() {
        com.vivo.push.model.a c2 = c("push_mode");
        if (c2 != null && !TextUtils.isEmpty(c2.b())) {
            try {
                return Integer.parseInt(c2.b());
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static boolean a(int i) {
        if (i != -1) {
            return (i & 1) != 0;
        }
        return z.b("persist.sys.log.ctrl", "no").equals("yes");
    }
}
