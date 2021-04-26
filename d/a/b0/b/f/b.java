package d.a.b0.b.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.prologue.service.network.Als;
import d.a.b0.a.c.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final g f39324a;

    public b(g gVar) {
        this.f39324a = gVar;
    }

    public static void f(int i2) {
        String d2 = j.d("empty_ext_info", "");
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.f(String.valueOf(i2));
        cVar.j(d2);
        Als.e(cVar);
    }

    public void a(@NonNull Als.Area area, String str) {
        c(area, str);
        h();
    }

    public void b() {
        g();
        i();
    }

    public void c(@NonNull Als.Area area, String str) {
        Als.c cVar = new Als.c(Als.Type.CLICK);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f39324a.f39347d);
        cVar.e(area);
        if (!TextUtils.isEmpty(str)) {
            cVar.h(str);
        }
        Als.e(cVar);
    }

    public void d(String str, long j) {
        Als.c cVar = new Als.c(Als.Type.CLOSE);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f39324a.f39347d);
        cVar.g(String.valueOf(j));
        if (d.a.b0.a.b.a.f39288a.get().z()) {
            cVar.f("1");
        } else {
            cVar.f("0");
        }
        cVar.h(str);
        Als.e(cVar);
    }

    public void e(String str, String str2) {
        Als.c cVar = new Als.c(Als.Type.DISCARD);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f39324a.f39347d);
        cVar.f("10");
        cVar.g(str);
        cVar.h(str2);
        Als.e(cVar);
    }

    public void g() {
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f39324a.f39347d);
        Als.e(cVar);
    }

    public void h() {
        String[] strArr = this.f39324a.q;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a.b0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void i() {
        String[] strArr = this.f39324a.p;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a.b0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
