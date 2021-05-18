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
    public static String f67567g = "KWE_NS";

    /* renamed from: a  reason: collision with root package name */
    public Context f67568a;

    /* renamed from: b  reason: collision with root package name */
    public String f67569b;

    /* renamed from: c  reason: collision with root package name */
    public String f67570c;

    /* renamed from: d  reason: collision with root package name */
    public String f67571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67572e;

    /* renamed from: f  reason: collision with root package name */
    public d f67573f;

    public b() {
        this.f67569b = "";
        this.f67570c = "";
        this.f67571d = "";
        this.f67572e = false;
    }

    public /* synthetic */ b(e eVar) {
        this();
    }

    public static final b b() {
        return g.a();
    }

    public static String l(Context context, String str) {
        return Orange.a().b(context, str.getBytes(), 20);
    }

    public String c(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.f67570c)) {
            return null;
        }
        return this.f67570c;
    }

    public final void e(Context context) {
        try {
            d.q.a.a.a.a.b.c().f(context, new f(this, context));
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public void f(Context context, boolean z, d dVar) {
        try {
            this.f67573f = dVar;
            this.f67568a = context;
            this.f67572e = z;
            Thread thread = new Thread(new e(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String b2 = d.q.a.a.c.b.e.b(th);
            if (dVar != null) {
                dVar.a(-1, b2);
            }
        }
    }

    public final void h(d dVar) {
        try {
            boolean b2 = new d.q.a.a.c.a.e(this.f67568a).b();
            e(this.f67568a);
            i(b2);
            this.f67571d = a.a().c(this.f67568a, this.f67572e, TextUtils.isEmpty(this.f67570c));
            if (dVar != null) {
                if (TextUtils.isEmpty(this.f67570c) && TextUtils.isEmpty(this.f67571d)) {
                    dVar.a(-2, "need check");
                    return;
                }
                try {
                    dVar.a(this.f67570c, this.f67571d);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            if (dVar != null) {
                try {
                    dVar.a(-1, d.q.a.a.c.b.e.b(th));
                } catch (Throwable unused2) {
                    d.q.a.a.c.b.b.c(th);
                }
            }
        }
    }

    public final void i(boolean z) {
        try {
            Pair a2 = c.b(this.f67568a).a();
            if (a2 != null && a2.second != null) {
                String str = (String) ((ConcurrentHashMap) a2.second).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.f67570c = str;
                }
            }
            if (TextUtils.isEmpty(this.f67570c)) {
                String c2 = Build.VERSION.SDK_INT < 29 ? d.q.a.a.c.a.d.c(this.f67568a, "k_w_o_d_out_dtt") : null;
                String str2 = "";
                if (TextUtils.isEmpty(c2)) {
                    d.q.a.a.c.b.a.b();
                    if (d.q.a.a.c.b.e.e(this.f67568a, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                        str2 = c.b(this.f67568a).g("Lm91a2R0ZnQ=");
                    }
                }
                if (TextUtils.isEmpty(c2) && TextUtils.isEmpty(str2)) {
                    return;
                }
                LinkedHashMap d2 = c.b(this.f67568a).d(c2);
                if (d2 == null || d2.size() == 0) {
                    d2 = c.b(this.f67568a).d(str2);
                }
                if (d2 == null || d2.size() <= 0) {
                    return;
                }
                String str3 = (String) d2.get(a.a().e());
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                this.f67570c = str3;
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public boolean j(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
            c.b(context).f(str, "");
            return true;
        }
        return false;
    }
}
