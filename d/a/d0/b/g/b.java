package d.a.d0.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.prologue.service.network.Als;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final h f43319a;

    public b(h hVar) {
        this.f43319a = hVar;
    }

    public static void f(int i2) {
        g(i2, "");
    }

    public static void g(int i2, String str) {
        String f2 = d.a.d0.a.c.j.f("empty_ext_info", "");
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.f(String.valueOf(i2));
        cVar.j(f2);
        if (!TextUtils.isEmpty(str)) {
            cVar.g(str);
        }
        Als.e(cVar);
    }

    public void a(@NonNull Als.Area area, String str) {
        c(area, str);
        i();
    }

    public void b() {
        h();
        j();
    }

    public void c(@NonNull Als.Area area, String str) {
        Als.c cVar = new Als.c(Als.Type.CLICK);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f43319a.f43342d);
        cVar.e(area);
        if (!TextUtils.isEmpty(str)) {
            cVar.h(str);
        }
        Als.e(cVar);
    }

    public void d(String str, long j) {
        Als.c cVar = new Als.c(Als.Type.CLOSE);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f43319a.f43342d);
        cVar.g(String.valueOf(j));
        if (d.a.d0.a.b.a.f43271a.get().z()) {
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
        cVar.j(this.f43319a.f43342d);
        cVar.f("10");
        cVar.g(str);
        cVar.h(str2);
        Als.e(cVar);
    }

    public void h() {
        Als.c cVar = new Als.c(Als.Type.SHOW);
        cVar.i(Als.Page.NA_SPLASH);
        cVar.j(this.f43319a.f43342d);
        Als.e(cVar);
    }

    public void i() {
        String[] strArr = this.f43319a.q;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a.d0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j() {
        String[] strArr = this.f43319a.p;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a.d0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
