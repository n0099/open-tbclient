package d.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.LongSparseArray;
import com.baidu.browser.core.BdCore;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f43767b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, d.b.h.a.k.e<String, Integer>> f43768c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Context f43769a;

    public g() {
        new LongSparseArray();
    }

    public static void a(String str, String str2) {
    }

    public static synchronized g c() {
        g gVar;
        synchronized (g.class) {
            if (f43767b == null) {
                f43767b = new g();
            }
            gVar = f43767b;
        }
        return gVar;
    }

    @Deprecated
    public static int d(String str, String str2) {
        a(str2, str);
        d.b.h.a.k.e<String, Integer> eVar = f43768c.get(str);
        if (eVar == null) {
            eVar = new d.b.h.a.k.e<>(100);
            f43768c.put(str, eVar);
        }
        Integer c2 = eVar.c(str2);
        if (c2 == null) {
            try {
                int identifier = c().b().getResources().getIdentifier(str2, str, c().b().getPackageName());
                eVar.d(str2, Integer.valueOf(identifier));
                return identifier;
            } catch (Error e2) {
                e2.printStackTrace();
                return 0;
            } catch (Exception e3) {
                e3.printStackTrace();
                return 0;
            }
        }
        return c2.intValue();
    }

    public final Context b() {
        if (this.f43769a == null) {
            this.f43769a = BdCore.b().a();
        }
        Context context = this.f43769a;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("context is null!");
    }
}
