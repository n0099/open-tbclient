package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.m;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
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
                    m.d("PushConfigSettings", "str2Clients E: " + e);
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.d
    public final String a(List<com.vivo.push.model.a> list) {
        if (list == null || list.size() <= 0) {
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

    @Override // com.vivo.push.cache.d
    protected final String a() {
        return "com.vivo.pushservice.other";
    }

    public final String b(String str) {
        String str2;
        synchronized (a) {
            Iterator it = this.b.iterator();
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
}
