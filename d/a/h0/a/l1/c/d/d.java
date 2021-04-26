package d.a.h0.a.l1.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.b.b f43275f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f43276g;

        public a(d dVar, String str, d.a.h0.a.l1.c.b.b bVar, f fVar) {
            this.f43274e = str;
            this.f43275f = bVar;
            this.f43276g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.e1.b bVar = new d.a.h0.a.e1.b();
            bVar.f42394c = this.f43274e;
            bVar.f42393b = d.a.h0.a.l1.c.c.a.a(this.f43275f);
            f.b i2 = this.f43276g.i("navigateTo");
            i2.n(f.f42031g, f.f42033i);
            i2.k("pluginFunPage", bVar).a();
        }
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new d.a.h0.a.t.e.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new d.a.h0.a.t.e.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new d.a.h0.a.t.e.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.l1.c.b.a f(d.a.h0.a.l1.c.b.b bVar) {
        String[] list;
        int i2;
        File file = null;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f43243a;
        String str2 = bVar.f43245c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.a.h0.a.l1.c.b.a aVar = new d.a.h0.a.l1.c.b.a();
        aVar.f43237a = str;
        aVar.f43238b = str2;
        if (d.a.h0.a.c0.d.d.e.d()) {
            file = d.f.d();
        } else if (d.a.h0.a.m1.a.a.C()) {
            file = d.b.d();
        } else {
            if (TextUtils.equals(bVar.f43246d, "develop")) {
                String a2 = d.a.h0.a.u.a.a(str);
                File d2 = d.a.h0.a.u0.d.d();
                String[] list2 = d2.list();
                if (list2 == null || d2.length() == 0) {
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
                            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                }
                if (i3 > -1) {
                    aVar.f43237a = str3 + i3;
                    aVar.f43241e = true;
                    File file2 = new File(d2, aVar.f43237a + File.separator + i3);
                    aVar.f43239c = file2.getAbsolutePath();
                    aVar.f43240d = i3;
                    file = file2;
                } else {
                    aVar.f43241e = false;
                    aVar.f43239c = null;
                }
            } else {
                File file3 = new File(d.a.h0.a.u0.d.d(), str);
                if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                    String str5 = null;
                    int i4 = -1;
                    for (String str6 : list) {
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                i2 = Integer.parseInt(str6);
                            } catch (NumberFormatException e3) {
                                d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e3));
                                i2 = -1;
                            }
                            if (i2 > i4) {
                                str5 = str6;
                                i4 = i2;
                            }
                        }
                    }
                    if (i4 != -1) {
                        aVar.f43240d = i4;
                        aVar.f43241e = true;
                        file = new File(file3, str5);
                        aVar.f43239c = file.getAbsolutePath();
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
            aVar.f43242f = true;
            aVar.f43239c = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public String g() {
        return null;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b i(String str, d.a.h0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return new d.a.h0.a.t.e.b(201, "pay args is null");
        }
        SwanAppActivity v = d.a.h0.a.r1.d.e().v();
        if (v == null) {
            return new d.a.h0.a.t.e.b(1001, "runtime exception, try reopen this app");
        }
        f swanAppFragmentManager = v.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return new d.a.h0.a.t.e.b(1001, "runtime exception, page manager breakdown");
        }
        d.a.h0.a.l1.d.a.a("jump to fun page");
        d.a.h0.a.r1.d.g().post(new a(this, str, bVar, swanAppFragmentManager));
        return new d.a.h0.a.t.e.b(0);
    }

    @Override // d.a.h0.a.l1.c.d.b
    public boolean j() {
        return true;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b l(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        return null;
    }

    public final boolean m(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
