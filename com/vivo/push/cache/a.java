package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class a extends d<com.vivo.push.model.a> {
    public a(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.d
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split("@#")) {
                String trim = str2.trim();
                String[] split = trim.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    try {
                        arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                    } catch (Exception e) {
                        p.d("AppConfigSettings", "str2Clients E: " + e);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.d
    final String b(String str) throws Exception {
        return new String(g.a(g.a(f4671a), g.a(b), Base64.decode(str, 2)), "utf-8");
    }

    public final com.vivo.push.model.a c(String str) {
        com.vivo.push.model.a aVar;
        synchronized (c) {
            Iterator it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (com.vivo.push.model.a) it.next();
                if (!TextUtils.isEmpty(aVar.a()) && aVar.a().equals(str)) {
                    break;
                }
            }
        }
        return aVar;
    }

    @Override // com.vivo.push.cache.d
    protected final String a() {
        return "com.vivo.pushservice.back_up";
    }

    public final int b() {
        com.vivo.push.model.a c = c("push_mode");
        if (c == null || TextUtils.isEmpty(c.b())) {
            return -1;
        }
        try {
            return Integer.parseInt(c.b());
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean a(int i) {
        if (i != -1) {
            return (i & 1) != 0;
        }
        return z.b("persist.sys.log.ctrl", "no").equals("yes");
    }
}
