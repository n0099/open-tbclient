package com.qq.e.comm.plugin.ab.f.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.a.p;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends c {
    private e d;
    private JSONObject e;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f11779a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f11780b = new ConcurrentHashMap<>();
    private Map<Integer, String> c = new HashMap();
    private com.qq.e.comm.plugin.a.d.a f = new com.qq.e.comm.plugin.a.d.a() { // from class: com.qq.e.comm.plugin.ab.f.a.a.3
        @Override // com.qq.e.comm.plugin.a.d.a
        public void a(String str, int i, int i2, long j) {
            if (i == 128 || TextUtils.isEmpty(str) || !a.this.f11780b.containsKey(str)) {
                return;
            }
            String str2 = (String) a.this.f11780b.get(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", a.this.a(i));
                jSONObject2.put("progress", i2);
                jSONObject2.put("total", j);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a.this.d.a(new com.qq.e.comm.plugin.ab.b.e(new d(null, null, str2, null), e.a.OK, jSONObject, 1));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.qq.e.comm.plugin.ab.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1191a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f11787a;

        public C1191a(String str) {
            this.f11787a = str;
        }

        @Override // com.qq.e.comm.plugin.a.f.a
        public void a(int i, String str, boolean z) {
            if (i != 0 || z) {
                return;
            }
            af.a(this.f11787a);
        }

        @Override // com.qq.e.comm.plugin.a.f.a
        public boolean a() {
            return false;
        }
    }

    public a(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        switch (i) {
            case 1:
                return 1;
            case 4:
                return 3;
            case 8:
                return 4;
            case 16:
                return 5;
            case 32:
                return 6;
            case 64:
                return 9;
            case 128:
                return 10;
            default:
                return 0;
        }
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : this.c.entrySet()) {
            try {
                jSONObject.put(entry.getKey() + "", entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        this.d = eVar;
        if (this.f11779a.compareAndSet(false, true)) {
            l.a().a(this.f);
        }
    }

    private void a(com.qq.e.comm.plugin.ab.f.e eVar, String str) {
        eVar.a(new com.qq.e.comm.plugin.ab.b.e(new d(null, null, str, null), e.a.OK, null, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        eVar.a(new com.qq.e.comm.plugin.ab.b.e(new d(null, null, str, null), e.a.OK, jSONObject));
    }

    private void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2) {
        for (Map.Entry<String, String> entry : this.f11780b.entrySet()) {
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String remove = this.f11780b.remove(str);
        if (!TextUtils.isEmpty(remove)) {
            a(eVar, remove);
        }
        this.f11780b.put(str, str2);
    }

    public int a(Context context, JSONObject jSONObject) {
        Intent launchIntentForPackage;
        Intent intent;
        ai.a("gdt_tag_download_apk", "openApp()");
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(optString)) {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(optString2);
            if (launchIntentForPackage == null) {
                return 12;
            }
            launchIntentForPackage.addFlags(268435456);
            if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) == null) {
                return 12;
            }
        } else {
            Uri parse = Uri.parse(optString);
            if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                return 11;
            }
            intent2.setData(parse);
            intent2.setAction("android.intent.action.VIEW");
            if (!StringUtil.isEmpty(optString2)) {
                intent2.setPackage(optString2);
            }
            if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                intent = intent2;
                context.startActivity(intent);
                return 0;
            }
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(optString2);
            if (launchIntentForPackage == null) {
                return 12;
            }
            launchIntentForPackage.addFlags(268435456);
            if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) == null) {
                return 12;
            }
        }
        intent = launchIntentForPackage;
        context.startActivity(intent);
        return 0;
    }

    public int a(JSONObject jSONObject) {
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        return a(l.a().a(optString));
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.c
    public com.qq.e.comm.plugin.ab.c.f<String> a(com.qq.e.comm.plugin.ab.f.e eVar, View view, String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        try {
            jSONObject = TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new com.qq.e.comm.plugin.ab.c.f<>(Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        }
        Context context = view.getContext();
        if ("openApp".equals(str2)) {
            return new com.qq.e.comm.plugin.ab.c.f<>(a(context, jSONObject) + "");
        }
        if ("isAppInstall".equals(str2)) {
            return new com.qq.e.comm.plugin.ab.c.f<>(b(context, jSONObject) + "");
        }
        if ("getDownloadStatus".equals(str2)) {
            return new com.qq.e.comm.plugin.ab.c.f<>(a(jSONObject) + "");
        }
        if ("pauseDownload".equals(str2)) {
            return new com.qq.e.comm.plugin.ab.c.f<>(b(jSONObject) + "");
        }
        if ("startDownload".equals(str2)) {
            a(context, eVar, jSONObject, str4);
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        } else if ("resumeDownload".equals(str2)) {
            a(eVar, jSONObject, str4);
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        } else if ("registerListener".equals(str2)) {
            b(eVar, jSONObject, str4);
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        } else if ("installApp".equals(str2)) {
            b(context, eVar, jSONObject, str4);
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        } else if ("type".equals(str2)) {
            return new com.qq.e.comm.plugin.ab.c.f<>(a(context));
        } else {
            if ("reportMsgByUrl".equals(str2)) {
                return new com.qq.e.comm.plugin.ab.c.f<>(c(jSONObject) + "");
            }
            GDTLogger.e("Unsupported action");
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        }
    }

    public String a(Context context) {
        if (ab.a(context)) {
            switch (GDTADManager.getInstance().getDeviceStatus().getNetworkType()) {
                case NET_4G:
                    return "4g";
                case NET_3G:
                    return "3g";
                case NET_2G:
                    return "2g";
                case WIFI:
                    return "wifi";
                default:
                    return "unknown";
            }
        }
        return "none";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, final com.qq.e.comm.plugin.ab.f.e eVar, JSONObject jSONObject, final String str) {
        ai.a("gdt_tag_download_apk", "startDownload(context, unJsBridge, option, callbackId)");
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString("url");
        boolean z = jSONObject.optInt("autoInstall", 1) == 1;
        if (TextUtils.isEmpty(optString)) {
            a(eVar, str, 10);
        } else if (TextUtils.isEmpty(optString2)) {
            a(eVar, str, 16);
        } else {
            String optString3 = jSONObject.optString("launchUrl");
            String optString4 = jSONObject.optString("appName");
            String optString5 = jSONObject.optString("appIcon");
            if (TextUtils.isEmpty(optString5)) {
                optString5 = "unknown";
            }
            String optString6 = jSONObject.optString("adInfo");
            String str2 = null;
            String str3 = null;
            String str4 = null;
            if (!TextUtils.isEmpty(optString6)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString6);
                    str2 = jSONObject2.optString("clickId");
                    try {
                        str3 = jSONObject2.optString("productId");
                    } catch (JSONException e) {
                        e = e;
                        str3 = null;
                    }
                    try {
                        str4 = jSONObject2.optString("adId");
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        a(eVar, optString, str);
                        a(eVar);
                        String str5 = null;
                        String str6 = null;
                        if (this.e != null) {
                        }
                        final com.qq.e.comm.plugin.a.c cVar = new com.qq.e.comm.plugin.a.c(r3, str3, r5, optString5, optString2, optString4, optString, 0, str5, str6);
                        cVar.a(!TextUtils.isEmpty(optString3) ? com.qq.e.comm.plugin.util.b.e(this.e) : optString3, a(), z);
                        if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) {
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str2 = null;
                    str3 = null;
                }
            }
            String str7 = !TextUtils.isEmpty(str2) ? "unknown" : str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "unknown";
            }
            String str8 = !TextUtils.isEmpty(str4) ? "unknown" : str4;
            a(eVar, optString, str);
            a(eVar);
            String str52 = null;
            String str62 = null;
            if (this.e != null) {
                str52 = this.e.optString(DocumentOpenUtil.TXT);
                str62 = this.e.optString("desc");
            }
            final com.qq.e.comm.plugin.a.c cVar2 = new com.qq.e.comm.plugin.a.c(str8, str3, str7, optString5, optString2, optString4, optString, 0, str52, str62);
            cVar2.a(!TextUtils.isEmpty(optString3) ? com.qq.e.comm.plugin.util.b.e(this.e) : optString3, a(), z);
            if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) {
                com.qq.e.comm.plugin.w.a.f.a(context, new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ab.f.a.a.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        l.a().a(cVar2);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ab.f.a.a.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        a.this.a(eVar, str, 20);
                    }
                });
            } else {
                l.a().a(cVar2);
            }
        }
    }

    public void a(com.qq.e.comm.plugin.ab.f.e eVar, JSONObject jSONObject, String str) {
        ai.a("gdt_tag_download_apk", "resumeDownload()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(eVar, str, 10);
        } else if (!l.a().b(optString)) {
            a(eVar, str, 15);
        } else {
            a(eVar, optString, str);
            a(eVar);
        }
    }

    public int b(Context context, JSONObject jSONObject) {
        ai.a("gdt_tag_download_apk", "isAppInstall(context, option)");
        return com.qq.e.comm.plugin.a.e.a.a(context, jSONObject.optString("packageName")) ? 1 : 0;
    }

    public int b(JSONObject jSONObject) {
        ai.a("gdt_tag_download_apk", "pauseDownload(option)");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            return 10;
        }
        return l.a().a(optString, 1) ? 0 : 15;
    }

    public void b(Context context, com.qq.e.comm.plugin.ab.f.e eVar, JSONObject jSONObject, String str) {
        ai.a("gdt_tag_download_apk", "installApp()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(eVar, str, 10);
            return;
        }
        int a2 = l.a().a(optString);
        if (!com.qq.e.comm.plugin.a.d.d.c(a2)) {
            GDTLogger.d(String.format("install call failed(%s,%s)", Integer.valueOf(a2), optString));
            a(eVar, str, 17);
            return;
        }
        File h = ah.h();
        if (h == null || !h.exists()) {
            a(eVar, str, 18);
            return;
        }
        File file = new File(h, optString + ".apk");
        if (!file.exists()) {
            a(eVar, str, 18);
        } else if (!new p(context).b(file)) {
            a(eVar, str, 19);
        } else {
            a(eVar, optString, str);
            a(eVar);
            p.a.f11644a.a(new C1191a(this.c.get(2)), optString);
        }
    }

    public void b(com.qq.e.comm.plugin.ab.f.e eVar, JSONObject jSONObject, String str) {
        ai.a("gdt_tag_download_apk", "registerListener()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(eVar, str, 10);
            return;
        }
        a(eVar, optString, str);
        a(eVar);
    }

    public int c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 21;
        }
        int optInt = jSONObject.optInt("type");
        this.c.put(Integer.valueOf(optInt), jSONObject.optString("reportUrl"));
        return 0;
    }
}
