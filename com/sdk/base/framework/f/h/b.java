package com.sdk.base.framework.f.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class b extends com.sdk.base.framework.f.a {
    static {
        b.class.getName();
        boolean z = com.sdk.base.framework.c.f.f13118b;
    }

    public static c a(Context context, ArrayList<String> arrayList) {
        c cVar = c.c;
        return arrayList != null ? a.a(context, arrayList, true) : a.a(context, null, false);
    }

    public static String a(Context context, String str) {
        int b2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str2 = null;
            if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                String substring = str.substring(3);
                str2 = substring.substring(0, substring.length() - 10);
            }
            b2 = com.sdk.base.framework.a.a.c.a(str2).booleanValue() ? -1 : com.sdk.base.framework.a.a.c.a(str2).booleanValue() ? -1 : ("01".equals(str2) || "06".equals(str2) || "09".equals(str2)) ? g.f13148b.b() : ("00".equals(str2) || "02".equals(str2) || "04".equals(str2) || "07".equals(str2)) ? g.f13147a.b() : ("03".equals(str2) || "05".equals(str2) || Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) ? g.c.b() : -1;
            if (b2 == -1 && activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                if (!"WIFI".equalsIgnoreCase(typeName) && "MOBILE".equalsIgnoreCase(typeName)) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if ("cmnet".equals(extraInfo) || "cmwap".equals(extraInfo)) {
                        b2 = g.f13147a.b();
                    } else if ("3gwap".equals(extraInfo) || "uniwap".equals(extraInfo) || "3gnet".equals(extraInfo) || "uninet".equals(extraInfo)) {
                        b2 = g.f13148b.b();
                    } else if ("ctnet".equals(extraInfo) || "ctwap".equals(extraInfo)) {
                        b2 = g.c.b();
                    }
                }
            }
        } catch (Exception e) {
        }
        if (b2 == g.f13148b.b()) {
            return g.f13148b.a();
        }
        if (b2 == g.c.b()) {
            return g.c.a();
        }
        if (b2 == g.f13147a.b()) {
            return g.f13147a.a();
        }
        return "UNKOWN";
    }
}
