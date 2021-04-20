package d.b.a0.b.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.prologue.service.network.Als;
import d.b.a0.a.c.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final g f41852a;

    public b(g gVar) {
        this.f41852a = gVar;
    }

    public static void f(int i) {
        String d2 = j.d("empty_ext_info", "");
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.f(String.valueOf(i));
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
        cVar.j(this.f41852a.f41875d);
        cVar.e(area);
        if (!TextUtils.isEmpty(str)) {
            cVar.h(str);
        }
        Als.e(cVar);
    }

    public void d(String str, long j) {
        Als.c cVar = new Als.c(Als.Type.CLOSE);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f41852a.f41875d);
        cVar.g(String.valueOf(j));
        if (d.b.a0.a.b.a.f41817a.get().n()) {
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
        cVar.j(this.f41852a.f41875d);
        cVar.f("10");
        cVar.g(str);
        cVar.h(str2);
        Als.e(cVar);
    }

    public void g() {
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f41852a.f41875d);
        Als.e(cVar);
    }

    public void h() {
        String[] strArr = this.f41852a.q;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.b.a0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void i() {
        String[] strArr = this.f41852a.p;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.b.a0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
