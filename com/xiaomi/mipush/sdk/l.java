package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hk;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<e, a> f37272a = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37273a;

        /* renamed from: b  reason: collision with root package name */
        public String f37274b;

        public a(String str, String str2) {
            this.f37273a = str;
            this.f37274b = str2;
        }
    }

    static {
        a(e.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static at a(e eVar) {
        int i2 = m.f37275a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return at.UPLOAD_FTOS_TOKEN;
                }
                return at.UPLOAD_COS_TOKEN;
            }
            return at.UPLOAD_FCM_TOKEN;
        }
        return at.UPLOAD_HUAWEI_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m121a(e eVar) {
        return f37272a.get(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hk m122a(e eVar) {
        return hk.AggregatePushSwitch;
    }

    public static void a(e eVar, a aVar) {
        if (aVar != null) {
            f37272a.put(eVar, aVar);
        }
    }
}
