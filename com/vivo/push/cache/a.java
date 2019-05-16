package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.m;
import com.vivo.push.util.w;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
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
                        m.d("AppConfigSettings", "str2Clients E: " + e);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public final void a(com.vivo.push.model.a aVar) {
        boolean z;
        synchronized (a) {
            if (!TextUtils.isEmpty(aVar.a())) {
                for (T t : this.b) {
                    if (t.a().equals(aVar.a())) {
                        t.a(aVar.b());
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                b((List) this.b);
            }
        }
    }

    @Override // com.vivo.push.cache.d
    public final String a(List<com.vivo.push.model.a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                com.vivo.push.model.a aVar = list.get(i2);
                stringBuffer.append(aVar.a());
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(aVar.b());
                if (i2 != list.size() - 1) {
                    stringBuffer.append("@#");
                }
                i = i2 + 1;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public final com.vivo.push.model.a b(String str) {
        com.vivo.push.model.a aVar;
        synchronized (a) {
            Iterator it = this.b.iterator();
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
        com.vivo.push.model.a b = b("push_mode");
        if (b == null || TextUtils.isEmpty(b.b())) {
            return -1;
        }
        try {
            return Integer.parseInt(b.b());
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean a(int i) {
        if (i != -1) {
            return (i & 1) != 0;
        }
        return w.b("persist.sys.log.ctrl", "no").equals("yes");
    }
}
