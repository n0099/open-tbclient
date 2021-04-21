package com.sdk.mobile.a;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.b.b;
import com.sdk.base.framework.bean.DataInfo;
/* loaded from: classes6.dex */
public final class a {
    public static <T> f a(Context context, String str, String str2, com.sdk.base.framework.b.a<T> aVar) {
        DataInfo dataInfo;
        String str3;
        b<T> a2;
        j jVar;
        int i;
        String str4;
        com.sdk.mobile.c.a aVar2 = new com.sdk.mobile.c.a(context, aVar);
        if (c.a(str2).booleanValue()) {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            str3 = aVar2.f38913b;
            a2 = aVar2.a();
            jVar = j.f38866b;
            i = 0;
            str4 = "/api/netm/v1.0/qhbt";
        } else {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            dataInfo.putData("mobile", str2);
            str3 = aVar2.f38913b;
            a2 = aVar2.a();
            jVar = j.f38866b;
            i = 0;
            str4 = "/api/netm/v1.0/qhbv";
        }
        return aVar2.a(str3, str4, dataInfo, a2, i, jVar);
    }
}
