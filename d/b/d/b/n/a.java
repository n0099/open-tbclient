package d.b.d.b.n;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.d.b.l;
import d.b.d.b.m;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f69708b;

    /* renamed from: a  reason: collision with root package name */
    public volatile Context f69709a;

    public a(@NonNull Context context) {
        this.f69709a = context;
    }

    public static a a() {
        if (f69708b == null) {
            f69708b = new a(m.e());
        }
        return f69708b;
    }

    @Nullable
    public String b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return l.e.b(l.i.a(this.f69709a), l.i.b(), com.bytedance.tea.crash.upload.b.f(m.a().a()), jSONObject, com.bytedance.tea.crash.upload.b.g());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String f2 = com.bytedance.tea.crash.upload.b.f(m.a().a());
                String b2 = l.e.b(l.i.a(this.f69709a), l.i.d(), f2, jSONObject, com.bytedance.tea.crash.upload.b.k());
                jSONObject.put("upload_scene", "direct");
                if (!com.bytedance.tea.crash.upload.b.j(f2, jSONObject.toString()).a()) {
                    return;
                }
                l.e.h(b2);
            } catch (Throwable unused) {
            }
        }
    }
}
