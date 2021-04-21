package d.b.h0.a.l1.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.b.b f45938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f45939g;

        public a(d dVar, String str, d.b.h0.a.l1.c.b.b bVar, f fVar) {
            this.f45937e = str;
            this.f45938f = bVar;
            this.f45939g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e1.b bVar = new d.b.h0.a.e1.b();
            bVar.f45085c = this.f45937e;
            bVar.f45084b = d.b.h0.a.l1.c.c.a.a(this.f45938f);
            f.b i = this.f45939g.i("navigateTo");
            i.n(f.f44734g, f.i);
            i.k("pluginFunPage", bVar).a();
        }
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new d.b.h0.a.t.e.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new d.b.h0.a.t.e.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new d.b.h0.a.t.e.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.l1.c.b.a f(d.b.h0.a.l1.c.b.b bVar) {
        String[] list;
        int i;
        File file = null;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f45908a;
        String str2 = bVar.f45910c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.b.h0.a.l1.c.b.a aVar = new d.b.h0.a.l1.c.b.a();
        aVar.f45902a = str;
        aVar.f45903b = str2;
        if (d.b.h0.a.c0.d.d.e.d()) {
            file = d.f.d();
        } else if (d.b.h0.a.m1.a.a.C()) {
            file = d.b.d();
        } else {
            if (TextUtils.equals(bVar.f45911d, "develop")) {
                String a2 = d.b.h0.a.u.a.a(str);
                File d2 = d.b.h0.a.u0.d.d();
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
                            d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                }
                if (i2 > -1) {
                    aVar.f45902a = str3 + i2;
                    aVar.f45906e = true;
                    File file2 = new File(d2, aVar.f45902a + File.separator + i2);
                    aVar.f45904c = file2.getAbsolutePath();
                    aVar.f45905d = i2;
                    file = file2;
                } else {
                    aVar.f45906e = false;
                    aVar.f45904c = null;
                }
            } else {
                File file3 = new File(d.b.h0.a.u0.d.d(), str);
                if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                    String str5 = null;
                    int i3 = -1;
                    for (String str6 : list) {
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                i = Integer.parseInt(str6);
                            } catch (NumberFormatException e3) {
                                d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e3));
                                i = -1;
                            }
                            if (i > i3) {
                                str5 = str6;
                                i3 = i;
                            }
                        }
                    }
                    if (i3 != -1) {
                        aVar.f45905d = i3;
                        aVar.f45906e = true;
                        file = new File(file3, str5);
                        aVar.f45904c = file.getAbsolutePath();
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
            aVar.f45907f = true;
            aVar.f45904c = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public String g() {
        return null;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b i(String str, d.b.h0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return new d.b.h0.a.t.e.b(201, "pay args is null");
        }
        SwanAppActivity n = d.b.h0.a.r1.d.e().n();
        if (n == null) {
            return new d.b.h0.a.t.e.b(1001, "runtime exception, try reopen this app");
        }
        f swanAppFragmentManager = n.getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            return new d.b.h0.a.t.e.b(1001, "runtime exception, page manager breakdown");
        }
        d.b.h0.a.l1.d.a.a("jump to fun page");
        d.b.h0.a.r1.d.g().post(new a(this, str, bVar, swanAppFragmentManager));
        return new d.b.h0.a.t.e.b(0);
    }

    @Override // d.b.h0.a.l1.c.d.b
    public boolean j() {
        return true;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b l(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        return null;
    }

    public final boolean m(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
