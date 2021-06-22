package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hk;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<e, a> f41054a = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f41055a;

        /* renamed from: b  reason: collision with root package name */
        public String f41056b;

        public a(String str, String str2) {
            this.f41055a = str;
            this.f41056b = str2;
        }
    }

    static {
        a(e.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static at a(e eVar) {
        int i2 = m.f41057a[eVar.ordinal()];
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
    public static a m120a(e eVar) {
        return f41054a.get(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hk m121a(e eVar) {
        return hk.AggregatePushSwitch;
    }

    public static void a(e eVar, a aVar) {
        if (aVar != null) {
            f41054a.put(eVar, aVar);
        }
    }
}
