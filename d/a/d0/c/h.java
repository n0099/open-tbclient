package d.a.d0.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class h extends e {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f39675a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, e> f39676b = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final h f39677a = new h();
    }

    public static h e() {
        return b.f39677a;
    }

    @Override // d.a.d0.c.e
    public boolean b(Context context, g gVar, d.a.d0.c.a aVar) {
        e eVar;
        String c2 = gVar.c();
        if (f39675a.get(c2) != null) {
            gVar.h(c2, f39675a.get(c2));
        }
        String e2 = gVar.e(true);
        if (TextUtils.isEmpty(e2) || (eVar = f39676b.get(e2)) == null) {
            return false;
        }
        return eVar.b(context, gVar, aVar);
    }

    @Override // d.a.d0.c.e
    public boolean c(Context context, g gVar, d.a.d0.c.a aVar) {
        gVar.m = j.h(302);
        return false;
    }

    public void f(String str, e eVar) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        f39676b.put(str, eVar);
    }

    public void g(e eVar) {
        if (eVar != null) {
            eVar.a(f39675a);
        }
    }

    public h() {
    }
}
