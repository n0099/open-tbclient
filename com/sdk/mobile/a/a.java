package com.sdk.mobile.a;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.i;
import com.sdk.base.framework.bean.DataInfo;
/* loaded from: classes15.dex */
public final class a {
    public static <T> f a(Context context, String str, String str2, com.sdk.base.framework.b.a<T> aVar) {
        com.sdk.mobile.c.a aVar2 = new com.sdk.mobile.c.a(context, aVar);
        if (c.a(str2).booleanValue()) {
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            return aVar2.a(aVar2.f13122b, "/api/netm/v1.0/qhbt", dataInfo, aVar2.a(), 0, i.f13101b);
        }
        DataInfo dataInfo2 = new DataInfo();
        dataInfo2.putData("accessCode", str);
        dataInfo2.putData("mobile", str2);
        return aVar2.a(aVar2.f13122b, "/api/netm/v1.0/qhbv", dataInfo2, aVar2.a(), 0, i.f13101b);
    }
}
