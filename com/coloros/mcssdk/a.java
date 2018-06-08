package com.coloros.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.coloros.mcssdk.a.d;
import com.coloros.mcssdk.a.e;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static int count = 0;
    private List<com.coloros.mcssdk.b.c> hyW;
    private List<d> hyX;
    private String hyY;
    private String hyZ;
    private com.coloros.mcssdk.d.b hza;
    private String mAppKey;
    private Context mContext;

    private a() {
        this.hyW = new ArrayList();
        this.hyX = new ArrayList();
        synchronized (a.class) {
            if (count > 0) {
                throw new RuntimeException("PushManager can't create again!");
            }
            count++;
        }
        a(new com.coloros.mcssdk.a.a());
        a(new e());
        a(new com.coloros.mcssdk.a.b());
        a(new com.coloros.mcssdk.b.a());
        a(new com.coloros.mcssdk.b.d());
        a(new com.coloros.mcssdk.b.b());
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r3v1 int A[REMOVE]) = (r5v0 com.coloros.mcssdk.e.a) type: VIRTUAL call: com.coloros.mcssdk.e.a.getMessageID():int)] */
    public static void a(Context context, com.coloros.mcssdk.e.a aVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
            intent.setPackage("com.coloros.mcs");
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", aVar.bKx());
            intent.putExtra("appPackage", aVar.getAppPackage());
            intent.putExtra("messageID", new StringBuilder().append(aVar.getMessageID()).toString());
            intent.putExtra("messageType", aVar.getType());
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.b("statisticMessage--Exception" + e.getMessage());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r3v1 int A[REMOVE]) = (r5v0 com.coloros.mcssdk.e.d) type: VIRTUAL call: com.coloros.mcssdk.e.d.getMessageID():int)] */
    public static void a(Context context, com.coloros.mcssdk.e.d dVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
            intent.setPackage("com.coloros.mcs");
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", dVar.bKx());
            intent.putExtra("appPackage", dVar.getAppPackage());
            intent.putExtra("messageID", new StringBuilder().append(dVar.getMessageID()).toString());
            intent.putExtra("messageType", dVar.getType());
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.b("statisticMessage--Exception" + e.getMessage());
        }
    }

    private synchronized void a(d dVar) {
        if (dVar != null) {
            this.hyX.add(dVar);
        }
    }

    private synchronized void a(com.coloros.mcssdk.b.c cVar) {
        if (cVar != null) {
            this.hyW.add(cVar);
        }
    }

    private void as(int i, String str) {
        Intent intent = new Intent();
        intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
        intent.setPackage("com.coloros.mcs");
        intent.putExtra("type", i);
        intent.putExtra(LegoListActivityConfig.PARAMS, str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra(WBConstants.SSO_APP_KEY, this.mAppKey);
        intent.putExtra("appSecret", this.hyY);
        intent.putExtra("registerID", this.hyZ);
        intent.putExtra("sdkVersion", getSDKVersion());
        this.mContext.startService(intent);
    }

    public static a bKu() {
        a aVar;
        aVar = c.hzb;
        return aVar;
    }

    public static boolean cx(Context context) {
        return com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs") && com.coloros.mcssdk.c.d.b(context, "com.coloros.mcs") >= 1012 && com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs", "supportOpenPush");
    }

    private void vI(int i) {
        as(i, "");
    }

    public void b(Context context, String str, String str2, com.coloros.mcssdk.d.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context is null !");
        }
        if (!cx(context)) {
            throw new IllegalArgumentException("the phone is not support oppo push!");
        }
        this.mAppKey = str;
        this.hyY = str2;
        this.mContext = context.getApplicationContext();
        this.hza = bVar;
        vI(12289);
    }

    public List<d> bKs() {
        return this.hyX;
    }

    public List<com.coloros.mcssdk.b.c> bKt() {
        return this.hyW;
    }

    public com.coloros.mcssdk.d.b bKv() {
        return this.hza;
    }

    public String getSDKVersion() {
        return "1.0.1";
    }

    public void ws(String str) {
        this.hyZ = str;
    }
}
