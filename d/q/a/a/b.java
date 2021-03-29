package d.q.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import d.q.a.a.c.a.a;
import d.q.a.a.c.a.c;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static int f67361g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static String f67362h = "KWE_NS";

    /* renamed from: a  reason: collision with root package name */
    public Context f67363a;

    /* renamed from: b  reason: collision with root package name */
    public String f67364b;

    /* renamed from: c  reason: collision with root package name */
    public String f67365c;

    /* renamed from: d  reason: collision with root package name */
    public String f67366d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67367e;

    /* renamed from: f  reason: collision with root package name */
    public d f67368f;

    public b() {
        this.f67364b = "";
        this.f67365c = "";
        this.f67366d = "";
        this.f67367e = false;
    }

    public /* synthetic */ b(e eVar) {
        this();
    }

    public static final b c() {
        return g.a();
    }

    public static String n(Context context, String str) {
        return Orange.a().b(context, str.getBytes(), 20);
    }

    public String d(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.f67365c)) {
            return null;
        }
        return this.f67365c;
    }

    public final void f(Context context) {
        try {
            d.q.a.a.a.a.b.c().f(context, new f(this, context));
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public void g(Context context, boolean z, d dVar) {
        try {
            this.f67368f = dVar;
            this.f67363a = context;
            this.f67367e = z;
            Thread thread = new Thread(new e(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String d2 = d.q.a.a.c.b.e.d(th);
            if (dVar != null) {
                dVar.a(-1, d2);
            }
        }
    }

    public final void i(d dVar) {
        try {
            boolean b2 = new d.q.a.a.c.a.e(this.f67363a).b();
            f(this.f67363a);
            j(b2);
            this.f67366d = a.a().c(this.f67363a, this.f67367e, TextUtils.isEmpty(this.f67365c));
            if (dVar != null) {
                if (TextUtils.isEmpty(this.f67365c) && TextUtils.isEmpty(this.f67366d)) {
                    dVar.a(-2, "need check");
                    return;
                }
                try {
                    dVar.a(this.f67365c, this.f67366d);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            if (dVar != null) {
                try {
                    dVar.a(-1, d.q.a.a.c.b.e.d(th));
                } catch (Throwable unused2) {
                    d.q.a.a.c.b.b.c(th);
                }
            }
        }
    }

    public final void j(boolean z) {
        try {
            Pair a2 = c.b(this.f67363a).a();
            if (a2 != null && a2.second != null) {
                String str = (String) ((ConcurrentHashMap) a2.second).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.f67365c = str;
                }
            }
            if (TextUtils.isEmpty(this.f67365c)) {
                String c2 = Build.VERSION.SDK_INT < 29 ? d.q.a.a.c.a.d.c(this.f67363a, "k_w_o_d_out_dtt") : null;
                String str2 = "";
                if (TextUtils.isEmpty(c2)) {
                    d.q.a.a.c.b.a.b();
                    if (d.q.a.a.c.b.e.g(this.f67363a, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                        str2 = c.b(this.f67363a).g("Lm91a2R0ZnQ=");
                    }
                }
                if (TextUtils.isEmpty(c2) && TextUtils.isEmpty(str2)) {
                    return;
                }
                LinkedHashMap d2 = c.b(this.f67363a).d(c2);
                if (d2 == null || d2.size() == 0) {
                    d2 = c.b(this.f67363a).d(str2);
                }
                if (d2 == null || d2.size() <= 0) {
                    return;
                }
                String str3 = (String) d2.get(a.a().e());
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                this.f67365c = str3;
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public boolean k(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
            c.b(context).f(str, "");
            return true;
        }
        return false;
    }
}
