package d.a.i0.a.c0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.a.i0.a.e0.d;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    static {
        boolean z = k.f43025a;
    }

    @Nullable
    public static <C extends d.a.i0.a.c0.b.a> C a(d.a.i0.a.c0.b.b bVar) {
        C c2;
        if (bVar == null) {
            d.a.i0.a.c0.g.a.a("Component-Finder", "find a null component: null model");
            return null;
        }
        String d2 = bVar.d();
        String str = bVar.f40672g;
        if (TextUtils.isEmpty(str)) {
            d.b("Component-Finder", "find a null " + d2 + " : slaveId is empty");
            return null;
        }
        d.a.i0.a.c0.e.a d3 = d(str);
        if (d3 == null) {
            d.b("Component-Finder", "find a null " + d2 + " : null component context");
            return null;
        }
        String str2 = bVar.f40671f;
        if (TextUtils.isEmpty(str2)) {
            d.l("Component-Finder", "find " + d2 + " with a empty componentId");
            List<d.a.i0.a.c0.b.a> list = d3.a().f40739c.get(bVar.f40670e);
            if (list == null) {
                d.b("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are null ");
                return null;
            } else if (list.size() <= 0) {
                d.b("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are empty ");
                return null;
            } else {
                d.l("Component-Finder", "find " + d2 + " with a empty componentId: fina a fallback component");
                c2 = (C) list.get(0);
            }
        } else {
            c2 = (C) d3.a().f40738b.get(str2);
        }
        if (c2 == null) {
            d.b("Component-Finder", "find a null " + d2 + " : not exist");
            return null;
        }
        return c2;
    }

    @Nullable
    public static <C extends d.a.i0.a.c0.b.a> C b(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.a.i0.a.c0.e.a d2 = d(str);
        if (d2 == null) {
            d.b("Component-Finder", "find a null " + str2 + " : null component context");
            return null;
        }
        C c2 = (C) d2.a().f40738b.get(str2);
        if (c2 == null) {
            d.b("Component-Finder", "find a null " + str2 + " : not exist");
            return null;
        }
        return c2;
    }

    @Nullable
    public static d.a.i0.a.c0.e.a c(d.a.i0.a.c0.b.b bVar) {
        if (bVar == null) {
            d.a.i0.a.c0.g.a.a("Component-Finder", "find component context with a null model");
            return null;
        }
        return d(bVar.f40672g);
    }

    @Nullable
    public static d.a.i0.a.c0.e.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            d.b("Component-Finder", "find component context with a null slave id");
            return null;
        }
        d.a.i0.a.p.e.d B = f.V().B(str);
        if (B instanceof d.a.i0.a.p.e.b) {
            return ((d.a.i0.a.p.e.b) B).d0();
        }
        return null;
    }
}
