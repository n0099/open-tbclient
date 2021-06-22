package com.sdk.mobile.a;

import android.content.Context;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.b.b;
import com.sdk.base.framework.bean.DataInfo;
/* loaded from: classes7.dex */
public final class a {
    public static <T> f a(Context context, String str, String str2, com.sdk.base.framework.b.a<T> aVar) {
        DataInfo dataInfo;
        String str3;
        b<T> a2;
        j jVar;
        int i2;
        String str4;
        com.sdk.mobile.c.a aVar2 = new com.sdk.mobile.c.a(context, aVar);
        if (c.a(str2).booleanValue()) {
            dataInfo = new DataInfo();
            dataInfo.putData(YYInnerSSOLoginActivity.o, str);
            str3 = aVar2.f39448b;
            a2 = aVar2.a();
            jVar = j.f39399b;
            i2 = 0;
            str4 = "/api/netm/v1.0/qhbt";
        } else {
            dataInfo = new DataInfo();
            dataInfo.putData(YYInnerSSOLoginActivity.o, str);
            dataInfo.putData("mobile", str2);
            str3 = aVar2.f39448b;
            a2 = aVar2.a();
            jVar = j.f39399b;
            i2 = 0;
            str4 = "/api/netm/v1.0/qhbv";
        }
        return aVar2.a(str3, str4, dataInfo, a2, i2, jVar);
    }
}
