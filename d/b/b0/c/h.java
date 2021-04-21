package d.b.b0.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class h extends e {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f42176a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, e> f42177b = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final h f42178a = new h();
    }

    public static h e() {
        return b.f42178a;
    }

    @Override // d.b.b0.c.e
    public boolean b(Context context, g gVar, d.b.b0.c.a aVar) {
        e eVar;
        String c2 = gVar.c();
        if (f42176a.get(c2) != null) {
            gVar.h(c2, f42176a.get(c2));
        }
        String e2 = gVar.e(true);
        if (TextUtils.isEmpty(e2) || (eVar = f42177b.get(e2)) == null) {
            return false;
        }
        return eVar.b(context, gVar, aVar);
    }

    @Override // d.b.b0.c.e
    public boolean c(Context context, g gVar, d.b.b0.c.a aVar) {
        gVar.m = j.h(302);
        return false;
    }

    public void f(String str, e eVar) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        f42177b.put(str, eVar);
    }

    public void g(e eVar) {
        if (eVar != null) {
            eVar.a(f42176a);
        }
    }

    public h() {
    }
}
