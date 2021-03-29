package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.request.db.DownloadDataConstants;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final l f29270a;

    /* renamed from: b  reason: collision with root package name */
    public final b f29271b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.b> f29272c = new HashMap();

    public a(b bVar, l lVar) {
        this.f29271b = bVar;
        this.f29270a = lVar;
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void b() {
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f29272c.values()) {
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void c() {
        b();
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f29272c.values()) {
            if (bVar != null) {
                bVar.d();
            }
        }
        this.f29272c.clear();
    }

    public static a a(b bVar, l lVar) {
        return new a(bVar, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a() {
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f29272c.values()) {
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || this.f29271b == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.f29272c.get(a(optJSONObject, (String) null).an().b());
        if (bVar != null) {
            bVar.f();
        }
    }

    private l a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.c(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            lVar.m(str);
        }
        if (this.f29270a == null) {
            return lVar;
        }
        String b2 = lVar.an() != null ? lVar.an().b() : null;
        if (TextUtils.isEmpty(b2)) {
            return this.f29270a;
        }
        return (this.f29270a.an() == null || !b2.equals(this.f29270a.an().b())) ? lVar : this.f29270a;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0319a {

        /* renamed from: a  reason: collision with root package name */
        public static ConcurrentHashMap<String, JSONObject> f29283a = new ConcurrentHashMap<>();

        public static synchronized JSONObject a(String str) {
            synchronized (C0319a.class) {
                if (TextUtils.isEmpty(str)) {
                    return new JSONObject();
                } else if (f29283a == null) {
                    return new JSONObject();
                } else {
                    JSONObject jSONObject = f29283a.get(str);
                    if (jSONObject == null) {
                        return new JSONObject();
                    }
                    return jSONObject;
                }
            }
        }

        public static synchronized void a(String str, int i, int i2) {
            synchronized (C0319a.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f29283a == null) {
                    f29283a = new ConcurrentHashMap<>();
                }
                JSONObject jSONObject = f29283a.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    f29283a.put(str, jSONObject);
                }
                try {
                    jSONObject.put("downloadStatus", i);
                    jSONObject.put("downloadProcessRate", i2);
                    jSONObject.put("code", 0);
                    jSONObject.put("codeMsg", "get ad_down_load_id success");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, str), optJSONObject, i, z);
    }

    private void a(Context context, l lVar, JSONObject jSONObject, int i, boolean z) {
        if (context == null || lVar == null || lVar.an() == null || jSONObject == null || this.f29271b == null || this.f29272c.get(lVar.an().b()) != null) {
            return;
        }
        String a2 = ak.a(i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.f29272c.put(lVar.an().b(), a(context, lVar, jSONObject, a2, z));
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, (String) null));
    }

    private void a(Context context, l lVar) {
        if (context == null || lVar == null || lVar.an() == null) {
            return;
        }
        final String am = lVar.am();
        com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.f29272c.get(lVar.an().b());
        if (bVar != null) {
            bVar.g();
            bVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.e.a.1
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        C0319a.a(am, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        C0319a.a(am, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    C0319a.a(am, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        C0319a.a(am, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    C0319a.a(am, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    C0319a.a(am, 6, 100);
                }
            });
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.video.c.b) {
            ((com.bytedance.sdk.openadsdk.core.video.c.b) context).W();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(a(optJSONObject, (String) null), optJSONObject);
    }

    private void a(l lVar, JSONObject jSONObject) {
        if (this.f29271b == null || lVar == null || lVar.an() == null) {
            return;
        }
        String b2 = lVar.an().b();
        if (this.f29272c.containsKey(b2)) {
            this.f29272c.remove(b2);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.f29271b.a("app_ad_event", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.b a(@NonNull final Context context, @NonNull final l lVar, @NonNull final JSONObject jSONObject, @NonNull String str, final boolean z) {
        com.bytedance.sdk.openadsdk.downloadnew.core.b b2 = com.bytedance.sdk.openadsdk.downloadnew.a.b(context, lVar, str);
        b2.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.e.a.2
            private void a(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    a.this.f29271b.a("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                    u.b("JsAppAdDownloadManager", "JSONException");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str2, String str3) {
                a("status", "download_active", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str2, String str3) {
                a("status", "download_failed", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str2, String str3) {
                a("status", "download_finished", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str2, String str3) {
                a("status", "download_paused", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                a("status", "idle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str2, String str3) {
                a("status", "installed");
            }
        });
        b2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.e.a.3
        });
        b2.a(3, new a.InterfaceC0318a() { // from class: com.bytedance.sdk.openadsdk.e.a.4
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC0318a
            public boolean a(int i, l lVar2, String str2, String str3, Object obj) {
                if (i == 3 && lVar2 != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (!z) {
                        char c2 = 65535;
                        switch (str3.hashCode()) {
                            case -1297985154:
                                if (str3.equals("click_continue")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -777040223:
                                if (str3.equals("click_open")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 565370917:
                                if (str3.equals("click_start_detail")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 1682049151:
                                if (str3.equals("click_pause")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1685366507:
                                if (str3.equals("click_start")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                        }
                        return (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4) ? false : true;
                    } else if (str3.equals("click_start")) {
                        com.bytedance.sdk.openadsdk.c.d.a(context, lVar, str2, "click_start_detail", (JSONObject) null);
                    }
                }
                return true;
            }
        });
        return b2;
    }
}
