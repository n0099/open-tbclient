package com.bytedance.sdk.openadsdk.g.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.bytedance.sdk.openadsdk.g.c.a {
    private final List<a> b = Collections.synchronizedList(new LinkedList());

    /* renamed from: a  reason: collision with root package name */
    private final b f4777a = b.a();

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a() {
        com.bytedance.sdk.openadsdk.j.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> d = c.this.f4777a.d();
                if (d != null) {
                    c.this.b.addAll(d);
                }
                c.this.f4777a.c();
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar, boolean z) {
        if (aVar != null && g.a()) {
            a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
            if (z) {
                p.e().a(aVar2);
            } else {
                p.d().a(aVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void b() {
    }

    /* loaded from: classes6.dex */
    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final String f4779a;
        public final JSONObject b;

        public a(String str, JSONObject jSONObject) {
            this.f4779a = str;
            this.b = jSONObject;
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
            if (TextUtils.isEmpty(this.f4779a) || this.b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f4779a);
                jSONObject.put("event", this.b);
            } catch (Throwable th) {
            }
            return jSONObject.toString();
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.f4779a;
        }
    }

    public static com.bytedance.sdk.openadsdk.g.c.a c() {
        return e.c();
    }
}
