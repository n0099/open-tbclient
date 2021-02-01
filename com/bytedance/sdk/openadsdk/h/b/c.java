package com.bytedance.sdk.openadsdk.h.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.bytedance.sdk.openadsdk.h.b.a {

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f7182b = Collections.synchronizedList(new LinkedList());

    /* renamed from: a  reason: collision with root package name */
    private final b f7181a = b.a();

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a() {
        com.bytedance.sdk.openadsdk.k.a.a().d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> d = c.this.f7181a.d();
                if (d != null) {
                    c.this.f7182b.addAll(d);
                }
                c.this.f7181a.c();
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a(com.bytedance.sdk.openadsdk.h.a.b bVar) {
        a(bVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a(com.bytedance.sdk.openadsdk.h.a.b bVar, boolean z) {
        if (bVar != null && j.a()) {
            a aVar = new a(UUID.randomUUID().toString(), bVar.a());
            if (z) {
                p.e().a(aVar);
            } else {
                p.d().a(aVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void b() {
    }

    /* loaded from: classes6.dex */
    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final String f7184a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f7185b;

        public a(String str, JSONObject jSONObject) {
            this.f7184a = str;
            this.f7185b = jSONObject;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject("event");
                if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                    return null;
                }
                return new a(optString, optJSONObject);
            } catch (Throwable th) {
                return null;
            }
        }

        public String a() {
            if (TextUtils.isEmpty(this.f7184a) || this.f7185b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f7184a);
                jSONObject.put("event", this.f7185b);
            } catch (Throwable th) {
            }
            return jSONObject.toString();
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.f7184a;
        }
    }

    public static com.bytedance.sdk.openadsdk.h.b.a c() {
        return e.c();
    }
}
