package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hl;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class m {
    private static HashMap<f, a> a = new HashMap<>();

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
        a(f.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(f.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(f.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(f.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static bd a(f fVar) {
        switch (fVar) {
            case ASSEMBLE_PUSH_HUAWEI:
                return bd.UPLOAD_HUAWEI_TOKEN;
            case ASSEMBLE_PUSH_FCM:
                return bd.UPLOAD_FCM_TOKEN;
            case ASSEMBLE_PUSH_COS:
                return bd.UPLOAD_COS_TOKEN;
            case ASSEMBLE_PUSH_FTOS:
                return bd.UPLOAD_FTOS_TOKEN;
            default:
                return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m110a(f fVar) {
        return a.get(fVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hl m111a(f fVar) {
        return hl.AggregatePushSwitch;
    }

    private static void a(f fVar, a aVar) {
        if (aVar != null) {
            a.put(fVar, aVar);
        }
    }
}
