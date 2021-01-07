package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.request.db.DownloadDataConstants;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final l f7400a;

    /* renamed from: b  reason: collision with root package name */
    private final b f7401b;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.b> c = new HashMap();

    private a(b bVar, l lVar) {
        this.f7401b = bVar;
        this.f7400a = lVar;
    }

    public static a a(b bVar, l lVar) {
        return new a(bVar, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a() {
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void b() {
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void c() {
        b();
        for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.d();
            }
        }
        this.c.clear();
    }

    private l a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.b(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            lVar.l(str);
        }
        if (this.f7400a == null) {
            return lVar;
        }
        String b2 = lVar.U() != null ? lVar.U().b() : null;
        if (TextUtils.isEmpty(b2)) {
            return this.f7400a;
        }
        return (this.f7400a.U() == null || !b2.equals(this.f7400a.U().b())) ? lVar : this.f7400a;
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(context, a(optJSONObject, str), optJSONObject, i, z);
        }
    }

    private void a(Context context, l lVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && lVar != null && lVar.U() != null && jSONObject != null && this.f7401b != null && this.c.get(lVar.U().b()) == null) {
            String a2 = aj.a(i);
            if (!TextUtils.isEmpty(a2)) {
                this.c.put(lVar.U().b(), a(context, lVar, jSONObject, a2, z));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(context, a(optJSONObject, (String) null));
        }
    }

    private void a(Context context, l lVar) {
        if (context != null && lVar != null && lVar.U() != null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.c.get(lVar.U().b());
            if (bVar != null) {
                bVar.g();
            }
            if (context instanceof com.bytedance.sdk.openadsdk.core.video.b.b) {
                ((com.bytedance.sdk.openadsdk.core.video.b.b) context).S();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(a(optJSONObject, (String) null), optJSONObject);
        }
    }

    private void a(l lVar, JSONObject jSONObject) {
        if (this.f7401b != null && lVar != null && lVar.U() != null) {
            String b2 = lVar.U().b();
            if (this.c.containsKey(b2)) {
                this.c.remove(b2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("status", "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.f7401b.a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.c
    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && this.f7401b != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.c.get(a(optJSONObject, (String) null).U().b());
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.b a(@NonNull final Context context, @NonNull final l lVar, @NonNull final JSONObject jSONObject, @NonNull String str, final boolean z) {
        com.bytedance.sdk.openadsdk.downloadnew.core.b b2 = com.bytedance.sdk.openadsdk.downloadnew.a.b(context, lVar, str);
        b2.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.e.a.1
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                a("status", "idle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str2, String str3) {
                a("status", "download_active", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str2, String str3) {
                a("status", "download_paused", "total_bytes", String.valueOf(j), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
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
            public void onInstalled(String str2, String str3) {
                a("status", "installed");
            }

            private void a(String... strArr) {
                if (strArr != null && strArr.length % 2 == 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("message", "success");
                        jSONObject2.put("appad", jSONObject);
                        for (int i = 0; i < strArr.length; i += 2) {
                            jSONObject2.put(strArr[i], strArr[i + 1]);
                        }
                        a.this.f7401b.a("app_ad_event", jSONObject2);
                    } catch (JSONException e) {
                        u.b("JsAppAdDownloadManager", "JSONException");
                    }
                }
            }
        }, false);
        b2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.e.a.2
        });
        b2.a(3, new a.InterfaceC1030a() { // from class: com.bytedance.sdk.openadsdk.e.a.3
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1030a
            public boolean a(int i, l lVar2, String str2, String str3, Object obj) {
                boolean z2 = false;
                if (i != 3 || lVar2 == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    return true;
                }
                if (!z) {
                    char c = 65535;
                    switch (str3.hashCode()) {
                        case -1297985154:
                            if (str3.equals("click_continue")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -777040223:
                            if (str3.equals("click_open")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 565370917:
                            if (str3.equals("click_start_detail")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1682049151:
                            if (str3.equals("click_pause")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1685366507:
                            if (str3.equals("click_start")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                    return z2;
                } else if (str3.equals("click_start")) {
                    com.bytedance.sdk.openadsdk.c.d.a(context, lVar, str2, "click_start_detail", (JSONObject) null);
                    return true;
                } else {
                    return true;
                }
            }
        });
        return b2;
    }
}
