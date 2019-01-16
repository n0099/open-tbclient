package com.coloros.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.coloros.mcssdk.a.d;
import com.coloros.mcssdk.a.e;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static int count = 0;
    private List<com.coloros.mcssdk.b.c> iio;
    private List<d> iip;
    private String iiq;
    private String iir;
    private com.coloros.mcssdk.d.b iis;
    private String mAppKey;
    private Context mContext;

    private a() {
        this.iio = new ArrayList();
        this.iip = new ArrayList();
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
            intent.putExtra(WebSocketAction.PARAM_KEY_TASKID, aVar.bTM());
            intent.putExtra("appPackage", aVar.bTN());
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
            intent.putExtra(WebSocketAction.PARAM_KEY_TASKID, dVar.bTM());
            intent.putExtra("appPackage", dVar.bTN());
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
            this.iip.add(dVar);
        }
    }

    private synchronized void a(com.coloros.mcssdk.b.c cVar) {
        if (cVar != null) {
            this.iio.add(cVar);
        }
    }

    private void as(int i, String str) {
        Intent intent = new Intent();
        intent.setAction("com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE");
        intent.setPackage("com.coloros.mcs");
        intent.putExtra("type", i);
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra(WBConstants.SSO_APP_KEY, this.mAppKey);
        intent.putExtra("appSecret", this.iiq);
        intent.putExtra("registerID", this.iir);
        intent.putExtra("sdkVersion", getSDKVersion());
        this.mContext.startService(intent);
    }

    public static a bTJ() {
        a aVar;
        aVar = c.iit;
        return aVar;
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m25do(Context context) {
        return com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs") && com.coloros.mcssdk.c.d.b(context, "com.coloros.mcs") >= 1012 && com.coloros.mcssdk.c.d.a(context, "com.coloros.mcs", "supportOpenPush");
    }

    private void ya(int i) {
        as(i, "");
    }

    public void b(Context context, String str, String str2, com.coloros.mcssdk.d.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context is null !");
        }
        if (!m25do(context)) {
            throw new IllegalArgumentException("the phone is not support oppo push!");
        }
        this.mAppKey = str;
        this.iiq = str2;
        this.mContext = context.getApplicationContext();
        this.iis = bVar;
        ya(UIMsg.k_event.MV_MAP_CACHEMANAGE);
    }

    public List<d> bTH() {
        return this.iip;
    }

    public List<com.coloros.mcssdk.b.c> bTI() {
        return this.iio;
    }

    public com.coloros.mcssdk.d.b bTK() {
        return this.iis;
    }

    public String getSDKVersion() {
        return "1.0.1";
    }

    public void zg(String str) {
        this.iir = str;
    }
}
