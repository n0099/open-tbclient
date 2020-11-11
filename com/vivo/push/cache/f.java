package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class f extends d<com.vivo.push.model.a> {
    public f(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.d
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length >= 2) {
                try {
                    arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e) {
                    p.d("PushConfigSettings", "str2Clients E: " + e);
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.d
    protected final String a() {
        return "com.vivo.pushservice.other";
    }

    public final String c(String str) {
        String str2;
        synchronized (c) {
            Iterator it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                com.vivo.push.model.a aVar = (com.vivo.push.model.a) it.next();
                if (!TextUtils.isEmpty(aVar.a()) && aVar.a().equals(str)) {
                    str2 = aVar.b();
                    break;
                }
            }
        }
        return str2;
    }

    @Override // com.vivo.push.cache.d
    final String b(String str) throws Exception {
        return new String(g.a(g.a(f4673a), g.a(b), Base64.decode(str, 2)), "utf-8");
    }
}
