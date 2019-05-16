package com.xiaomi.mipush.sdk;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class l {
    private static HashMap<f, a> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(f.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(f.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(f.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
    }

    public static a a(f fVar) {
        return a.get(fVar);
    }

    private static void a(f fVar, a aVar) {
        if (aVar != null) {
            a.put(fVar, aVar);
        }
    }

    public static com.xiaomi.xmpush.thrift.g b(f fVar) {
        return com.xiaomi.xmpush.thrift.g.AggregatePushSwitch;
    }

    public static be c(f fVar) {
        switch (fVar) {
            case ASSEMBLE_PUSH_HUAWEI:
                return be.UPLOAD_HUAWEI_TOKEN;
            case ASSEMBLE_PUSH_FCM:
                return be.UPLOAD_FCM_TOKEN;
            case ASSEMBLE_PUSH_COS:
                return be.UPLOAD_COS_TOKEN;
            default:
                return null;
        }
    }
}
