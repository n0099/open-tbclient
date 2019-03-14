package com.coloros.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.coloros.mcssdk.a.d;
import com.coloros.mcssdk.a.e;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static int count = 0;
    private List<com.coloros.mcssdk.b.c> jye;
    private List<d> jyf;
    private String jyg;
    private String jyh;
    private com.coloros.mcssdk.d.b jyi;
    private String mAppKey;
    private Context mContext;

    private a() {
        this.jye = new ArrayList();
        this.jyf = new ArrayList();
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

    private void BN(int i) {
        aI(i, "");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r3v1 int A[REMOVE]) = (r5v0 com.coloros.mcssdk.e.a) type: VIRTUAL call: com.coloros.mcssdk.e.a.getMessageID():int)] */
    public static void a(Context context, com.coloros.mcssdk.e.a aVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
            intent.setPackage("com.coloros.mcs");
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", aVar.csX());
            intent.putExtra("appPackage", aVar.csY());
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
            intent.putExtra("taskID", dVar.csX());
            intent.putExtra("appPackage", dVar.csY());
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
            this.jyf.add(dVar);
        }
    }

    private synchronized void a(com.coloros.mcssdk.b.c cVar) {
        if (cVar != null) {
            this.jye.add(cVar);
        }
    }

    private void aI(int i, String str) {
        Intent intent = new Intent();
        intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
        intent.setPackage("com.coloros.mcs");
        intent.putExtra("type", i);
        intent.putExtra(LegoListActivityConfig.PARAMS, str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra(WBConstants.SSO_APP_KEY, this.mAppKey);
        intent.putExtra("appSecret", this.jyg);
        intent.putExtra("registerID", this.jyh);
        intent.putExtra("sdkVersion", getSDKVersion());
        this.mContext.startService(intent);
    }

    public static a csU() {
        a aVar;
        aVar = c.jyj;
        return aVar;
    }

    public static boolean eI(Context context) {
        return com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs") && com.coloros.mcssdk.c.d.b(context, "com.coloros.mcs") >= 1012 && com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs", "supportOpenPush");
    }

    public void Fj(String str) {
        this.jyh = str;
    }

    public void b(Context context, String str, String str2, com.coloros.mcssdk.d.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context is null !");
        }
        if (!eI(context)) {
            throw new IllegalArgumentException("the phone is not support oppo push!");
        }
        this.mAppKey = str;
        this.jyg = str2;
        this.mContext = context.getApplicationContext();
        this.jyi = bVar;
        BN(UIMsg.k_event.MV_MAP_CACHEMANAGE);
    }

    public List<d> csS() {
        return this.jyf;
    }

    public List<com.coloros.mcssdk.b.c> csT() {
        return this.jye;
    }

    public com.coloros.mcssdk.d.b csV() {
        return this.jyi;
    }

    public String getSDKVersion() {
        return "1.0.1";
    }
}
