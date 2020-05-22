package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hr;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class k {
    private static HashMap<d, a> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static av a(d dVar) {
        switch (dVar) {
            case ASSEMBLE_PUSH_HUAWEI:
                return av.UPLOAD_HUAWEI_TOKEN;
            case ASSEMBLE_PUSH_FCM:
                return av.UPLOAD_FCM_TOKEN;
            case ASSEMBLE_PUSH_COS:
                return av.UPLOAD_COS_TOKEN;
            case ASSEMBLE_PUSH_FTOS:
                return av.UPLOAD_FTOS_TOKEN;
            default:
                return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m114a(d dVar) {
        return a.get(dVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hr m115a(d dVar) {
        return hr.AggregatePushSwitch;
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            a.put(dVar, aVar);
        }
    }
}
