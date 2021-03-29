package d.b.c0.k.h;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Long f42615a = 0L;

    /* renamed from: b  reason: collision with root package name */
    public static Long f42616b = 0L;

    public static final void a() {
        Long l = f42616b;
        if (l != null) {
            if (l == null) {
                Intrinsics.throwNpe();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = f42616b;
                    if (l2 == null) {
                        Intrinsics.throwNpe();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                b bVar = new b(Constants.DEFAULT_UIN);
                bVar.b(jSONObject);
                d.b(bVar);
                f42616b = 0L;
            }
        }
    }

    public static final void b() {
        Long l = f42615a;
        if (l != null) {
            if (l == null) {
                Intrinsics.throwNpe();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = f42615a;
                    if (l2 == null) {
                        Intrinsics.throwNpe();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                b bVar = new b(Constants.DEFAULT_UIN);
                bVar.b(jSONObject);
                d.b(bVar);
                f42615a = 0L;
            }
        }
    }

    public static final void c(Long l) {
        f42615a = l;
    }

    public static final void d(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("errno", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("errmsg", str3);
            }
        } catch (Exception unused) {
        }
        b bVar = new b(str);
        bVar.b(jSONObject);
        d.b(bVar);
    }

    public static final void e(Long l) {
        f42616b = l;
    }

    public static final void f(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception unused) {
        }
        b bVar = new b(str);
        bVar.b(jSONObject);
        d.b(bVar);
    }

    public static final void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception unused) {
        }
        b bVar = new b(str);
        bVar.b(jSONObject);
        d.b(bVar);
    }
}
