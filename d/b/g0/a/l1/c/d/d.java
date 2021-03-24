package d.b.g0.a.l1.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45215e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45216f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f45217g;

        public a(d dVar, String str, d.b.g0.a.l1.c.b.b bVar, f fVar) {
            this.f45215e = str;
            this.f45216f = bVar;
            this.f45217g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e1.b bVar = new d.b.g0.a.e1.b();
            bVar.f44363c = this.f45215e;
            bVar.f44362b = d.b.g0.a.l1.c.c.a.a(this.f45216f);
            f.b i = this.f45217g.i("navigateTo");
            i.n(f.f44012g, f.i);
            i.k("pluginFunPage", bVar).a();
        }
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new d.b.g0.a.t.e.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new d.b.g0.a.t.e.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new d.b.g0.a.t.e.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.l1.c.b.a f(d.b.g0.a.l1.c.b.b bVar) {
        String[] list;
        int i;
        File file = null;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f45186a;
        String str2 = bVar.f45188c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.b.g0.a.l1.c.b.a aVar = new d.b.g0.a.l1.c.b.a();
        aVar.f45180a = str;
        aVar.f45181b = str2;
        if (d.b.g0.a.c0.d.d.e.d()) {
            file = d.f.d();
        } else if (d.b.g0.a.m1.a.a.C()) {
            file = d.b.d();
        } else {
            if (TextUtils.equals(bVar.f45189d, "develop")) {
                String a2 = d.b.g0.a.u.a.a(str);
                File d2 = d.b.g0.a.u0.d.d();
                String[] list2 = d2.list();
                if (list2 == null || d2.length() == 0) {
                    return aVar;
                }
                String str3 = a2 + "_dev";
                int i2 = -1;
                for (String str4 : list2) {
                    if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                        try {
                            int parseInt = Integer.parseInt(str4.substring(str3.length()));
                            if (parseInt > i2) {
                                i2 = parseInt;
                            }
                        } catch (NumberFormatException e2) {
                            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                }
                if (i2 > -1) {
                    aVar.f45180a = str3 + i2;
                    aVar.f45184e = true;
                    File file2 = new File(d2, aVar.f45180a + File.separator + i2);
                    aVar.f45182c = file2.getAbsolutePath();
                    aVar.f45183d = i2;
                    file = file2;
                } else {
                    aVar.f45184e = false;
                    aVar.f45182c = null;
                }
            } else {
                File file3 = new File(d.b.g0.a.u0.d.d(), str);
                if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                    String str5 = null;
                    int i3 = -1;
                    for (String str6 : list) {
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                i = Integer.parseInt(str6);
                            } catch (NumberFormatException e3) {
                                d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e3));
                                i = -1;
                            }
                            if (i > i3) {
                                str5 = str6;
                                i3 = i;
                            }
                        }
                    }
                    if (i3 != -1) {
                        aVar.f45183d = i3;
                        aVar.f45184e = true;
                        file = new File(file3, str5);
                        aVar.f45182c = file.getAbsolutePath();
                    }
                }
                return aVar;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (m(file4)) {
            aVar.f45185f = true;
            aVar.f45182c = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public String g() {
        return null;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b i(String str, d.b.g0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return new d.b.g0.a.t.e.b(201, "pay args is null");
        }
        SwanAppActivity n = d.b.g0.a.r1.d.e().n();
        if (n == null) {
            return new d.b.g0.a.t.e.b(1001, "runtime exception, try reopen this app");
        }
        f swanAppFragmentManager = n.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return new d.b.g0.a.t.e.b(1001, "runtime exception, page manager breakdown");
        }
        d.b.g0.a.l1.d.a.a("jump to fun page");
        d.b.g0.a.r1.d.g().post(new a(this, str, bVar, swanAppFragmentManager));
        return new d.b.g0.a.t.e.b(0);
    }

    @Override // d.b.g0.a.l1.c.d.b
    public boolean j() {
        return true;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b l(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        return null;
    }

    public final boolean m(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
