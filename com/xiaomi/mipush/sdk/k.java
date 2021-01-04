package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hr;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<d, a> f14129a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f14130a;

        /* renamed from: b  reason: collision with root package name */
        public String f14131b;

        public a(String str, String str2) {
            this.f14130a = str;
            this.f14131b = str2;
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
    public static a m135a(d dVar) {
        return f14129a.get(dVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hr m136a(d dVar) {
        return hr.AggregatePushSwitch;
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f14129a.put(dVar, aVar);
        }
    }
}
