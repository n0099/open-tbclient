package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class f extends d<com.vivo.push.model.a> {
    public f(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.d
    public final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.d
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split(com.vivo.push.cache.impl.a.SPILTE_TAG)) {
            String trim = str2.trim();
            String[] split = trim.trim().split(",");
            if (split.length >= 2) {
                try {
                    arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e2) {
                    p.d("PushConfigSettings", "str2Clients E: " + e2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.d
    public final String b(String str) throws Exception {
        return new String(g.a(g.a(d.f39457a), g.a(d.f39458b), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (d.f39459c) {
            for (T t : this.f39460d) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t.b();
                }
            }
            return null;
        }
    }
}
