package com.bytedance.sdk.openadsdk.h.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c implements com.bytedance.sdk.openadsdk.h.c.a {

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f30018b = Collections.synchronizedList(new LinkedList());

    /* renamed from: a  reason: collision with root package name */
    public final b f30017a = b.a();

    public static com.bytedance.sdk.openadsdk.h.c.a c() {
        return e.c();
    }

    @Override // com.bytedance.sdk.openadsdk.h.c.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.h.c.a
    public void a() {
        com.bytedance.sdk.openadsdk.l.e.a(new g("init") { // from class: com.bytedance.sdk.openadsdk.h.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> d2 = c.this.f30017a.d();
                if (d2 != null) {
                    c.this.f30018b.addAll(d2);
                }
                c.this.f30017a.c();
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.h.c.a
    public void a(com.bytedance.sdk.openadsdk.h.a.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.h.c.a
    public void a(com.bytedance.sdk.openadsdk.h.a.a aVar, boolean z) {
        if (aVar == null || !com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return;
        }
        a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
        if (z) {
            p.e().a(aVar2);
        } else {
            p.d().a(aVar2);
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final String f30020a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f30021b;

        public a(String str, JSONObject jSONObject) {
            this.f30020a = str;
            this.f30021b = jSONObject;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject("event");
                if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                    return new a(optString, optJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.f30020a;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f30020a) || this.f30021b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f30020a);
                jSONObject.put("event", this.f30021b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
    }
}
