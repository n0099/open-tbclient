package d.a.h0.a.a0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.a.h0.a.k;
import d.a.h0.a.p.d.d;
import d.a.h0.a.z0.f;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    static {
        boolean z = k.f43101a;
    }

    @Nullable
    public static <C extends d.a.h0.a.a0.b.a> C a(d.a.h0.a.a0.b.b bVar) {
        C c2;
        if (bVar == null) {
            d.a.h0.a.a0.g.a.a("Component-Finder", "find a null component: null model");
            return null;
        }
        String d2 = bVar.d();
        String str = bVar.f41093g;
        if (TextUtils.isEmpty(str)) {
            d.a.h0.a.c0.c.b("Component-Finder", "find a null " + d2 + " : slaveId is empty");
            return null;
        }
        d.a.h0.a.a0.e.a d3 = d(str);
        if (d3 == null) {
            d.a.h0.a.c0.c.b("Component-Finder", "find a null " + d2 + " : null component context");
            return null;
        }
        String str2 = bVar.f41092f;
        if (TextUtils.isEmpty(str2)) {
            d.a.h0.a.c0.c.l("Component-Finder", "find " + d2 + " with a empty componentId");
            List<d.a.h0.a.a0.b.a> list = d3.a().f41159c.get(bVar.f41091e);
            if (list == null) {
                d.a.h0.a.c0.c.b("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are null ");
                return null;
            } else if (list.size() <= 0) {
                d.a.h0.a.c0.c.b("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are empty ");
                return null;
            } else {
                d.a.h0.a.c0.c.l("Component-Finder", "find " + d2 + " with a empty componentId: fina a fallback component");
                c2 = (C) list.get(0);
            }
        } else {
            c2 = (C) d3.a().f41158b.get(str2);
        }
        if (c2 == null) {
            d.a.h0.a.c0.c.b("Component-Finder", "find a null " + d2 + " : not exist");
            return null;
        }
        return c2;
    }

    @Nullable
    public static <C extends d.a.h0.a.a0.b.a> C b(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.a.h0.a.a0.e.a d2 = d(str);
        if (d2 == null) {
            d.a.h0.a.c0.c.b("Component-Finder", "find a null " + str2 + " : null component context");
            return null;
        }
        C c2 = (C) d2.a().f41158b.get(str2);
        if (c2 == null) {
            d.a.h0.a.c0.c.b("Component-Finder", "find a null " + str2 + " : not exist");
            return null;
        }
        return c2;
    }

    @Nullable
    public static d.a.h0.a.a0.e.a c(d.a.h0.a.a0.b.b bVar) {
        if (bVar == null) {
            d.a.h0.a.a0.g.a.a("Component-Finder", "find component context with a null model");
            return null;
        }
        return d(bVar.f41093g);
    }

    @Nullable
    public static d.a.h0.a.a0.e.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            d.a.h0.a.c0.c.b("Component-Finder", "find component context with a null slave id");
            return null;
        }
        d B = f.V().B(str);
        if (B instanceof d.a.h0.a.p.d.b) {
            return ((d.a.h0.a.p.d.b) B).b0();
        }
        return null;
    }
}
