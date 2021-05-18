package d.a.i0.a.t1.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.a1.e;
import d.a.i0.a.h0.g.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t1.c.b.b f44608f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f44609g;

        public a(d dVar, String str, d.a.i0.a.t1.c.b.b bVar, g gVar) {
            this.f44607e = str;
            this.f44608f = bVar;
            this.f44609g = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.l1.b bVar = new d.a.i0.a.l1.b();
            bVar.f43185g = this.f44607e;
            bVar.f43184f = d.a.i0.a.t1.c.c.a.a(this.f44608f);
            g.b i2 = this.f44609g.i("navigateTo");
            i2.n(g.f41902g, g.f41904i);
            i2.k("pluginFunPage", bVar).a();
        }
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new d.a.i0.a.u.h.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new d.a.i0.a.u.h.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new d.a.i0.a.u.h.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.t1.c.b.a f(d.a.i0.a.t1.c.b.b bVar) {
        String[] list;
        int i2;
        File file = null;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f44576a;
        String str2 = bVar.f44578c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.a.i0.a.t1.c.b.a aVar = new d.a.i0.a.t1.c.b.a();
        aVar.f44570a = str;
        aVar.f44571b = str2;
        if (d.a.i0.a.e0.f.e.e.d()) {
            file = e.f.e();
        } else if (d.a.i0.a.u1.a.a.G()) {
            file = e.b.e();
        } else if (d.a.i0.a.u1.a.a.C()) {
            file = d.a.i0.a.e0.f.d.b.d();
        } else {
            if (TextUtils.equals(bVar.f44579d, "develop")) {
                String a2 = d.a.i0.a.v.a.a(str);
                File g2 = d.a.i0.a.a1.e.g();
                String[] list2 = g2.list();
                if (list2 == null || g2.length() == 0) {
                    return aVar;
                }
                String str3 = a2 + "_dev";
                int i3 = -1;
                for (String str4 : list2) {
                    if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                        try {
                            int parseInt = Integer.parseInt(str4.substring(str3.length()));
                            if (parseInt > i3) {
                                i3 = parseInt;
                            }
                        } catch (NumberFormatException e2) {
                            d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                }
                if (i3 > -1) {
                    aVar.f44570a = str3 + i3;
                    aVar.f44574e = true;
                    File file2 = new File(g2, aVar.f44570a + File.separator + i3);
                    aVar.f44572c = file2.getAbsolutePath();
                    aVar.f44573d = i3;
                    file = file2;
                } else {
                    aVar.f44574e = false;
                    aVar.f44572c = null;
                }
            } else {
                File file3 = new File(d.a.i0.a.a1.e.g(), str);
                if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                    String str5 = null;
                    int i4 = -1;
                    for (String str6 : list) {
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                i2 = Integer.parseInt(str6);
                            } catch (NumberFormatException e3) {
                                d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e3));
                                i2 = -1;
                            }
                            if (i2 > i4) {
                                str5 = str6;
                                i4 = i2;
                            }
                        }
                    }
                    if (i4 != -1) {
                        aVar.f44573d = i4;
                        aVar.f44574e = true;
                        file = new File(file3, str5);
                        aVar.f44572c = file.getAbsolutePath();
                    }
                }
                return aVar;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (n(file4)) {
            aVar.f44575f = true;
            aVar.f44572c = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String g() {
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String h() {
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b j(String str, d.a.i0.a.t1.c.b.b bVar) {
        if (bVar == null) {
            return new d.a.i0.a.u.h.b(201, "pay args is null");
        }
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (x == null) {
            return new d.a.i0.a.u.h.b(1001, "runtime exception, try reopen this app");
        }
        g swanAppFragmentManager = x.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return new d.a.i0.a.u.h.b(1001, "runtime exception, page manager breakdown");
        }
        d.a.i0.a.t1.d.a.a("jump to fun page");
        d.a.i0.a.a2.d.i().post(new a(this, str, bVar, swanAppFragmentManager));
        return new d.a.i0.a.u.h.b(0);
    }

    @Override // d.a.i0.a.t1.c.d.b
    public boolean k() {
        return true;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b m(d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2) {
        return null;
    }

    public final boolean n(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
