package d.a.l0.a.i1.d.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.c1.d.i;
import d.a.l0.a.g1.f;
import d.a.l0.a.h;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import d.a.l0.a.z1.b.e.b;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f46560a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.w2.j.a f46561b;

    /* renamed from: d.a.l0.a.i1.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0769a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46562a;

        public C0769a(String str) {
            this.f46562a = str;
        }

        @Override // d.a.l0.a.z1.b.e.b.a
        public void a(d.a.l0.a.z1.b.e.b bVar) {
            a.d(bVar.c(), a.this.f46560a, this.f46562a);
            a.this.f46561b.j();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements i.a {
        @Override // d.a.l0.a.c1.d.i.a
        public void a() {
        }

        @Override // d.a.l0.a.c1.d.i.a
        public void b() {
        }
    }

    public a(@NonNull Activity activity) {
        this.f46560a = activity;
    }

    public static void d(int i2, Activity activity, String str) {
        if (i2 == 5) {
            i(activity, str);
        } else if (i2 == 6) {
            g(activity, str);
        } else if (i2 == 7) {
            f(activity, str);
        } else if (i2 != 8) {
        } else {
            h(activity, str);
        }
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://") || str.startsWith("file://");
    }

    public static void f(Activity activity, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "swan");
            jSONObject.put("urls", new JSONArray(new String[]{str}));
            jSONObject.put("type", "0");
            jSONObject.put("index", "0");
        } catch (JSONException e2) {
            if (k.f46875a) {
                e2.printStackTrace();
            }
        }
        d.a.l0.a.c1.a.y().b(activity, jSONObject);
    }

    public static void g(Activity activity, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("imageUrl", str);
        d.a.l0.a.c1.a.y().f(activity, new JSONObject(hashMap));
    }

    public static void h(Activity activity, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("imageUrl", str);
        d.a.l0.a.c1.a.y().a(activity, new JSONObject(hashMap));
    }

    public static void i(Activity activity, String str) {
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "type", "3");
        w.f(jSONObject, "imageUrl", str);
        w.f(jSONObject, "iconUrl", str);
        w.f(jSONObject, "source", "swan");
        w.f(jSONObject, "path", f.V().U());
        e Q = e.Q();
        if (Q != null) {
            w.f(jSONObject, "title", Q.L().K());
            PMSAppInfo f0 = Q.L().f0();
            if (f0 != null) {
                w.f(jSONObject, "linkUrl", f0.webUrl);
            } else {
                w.f(jSONObject, "linkUrl", str);
            }
        }
        d.a.l0.a.c1.a.Y().a(activity, jSONObject, new b());
    }

    public final void c(String str) {
        if (!e(str)) {
            this.f46561b.e(6, h.swan_app_img_menu_save_image);
        }
        this.f46561b.e(5, h.swan_app_img_menu_share_image);
    }

    public void j(View view, String str) {
        d.a.l0.a.w2.j.a aVar = this.f46561b;
        if (aVar != null && aVar.n()) {
            this.f46561b.j();
        }
        d.a.l0.a.w2.j.a aVar2 = new d.a.l0.a.w2.j.a(view);
        this.f46561b = aVar2;
        aVar2.r(new C0769a(str));
        c(str);
        this.f46561b.t();
    }
}
