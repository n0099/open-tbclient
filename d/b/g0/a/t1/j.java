package d.b.g0.a.t1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import d.b.g0.a.a2.e.l;
import d.b.g0.a.a2.e.m;
import d.b.g0.a.a2.e.n;
import d.b.g0.a.a2.e.o;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.t1.k.b0;
import d.b.g0.a.t1.k.c0;
import d.b.g0.a.t1.k.d0;
import d.b.g0.a.t1.k.k;
import d.b.g0.a.t1.k.p;
import d.b.g0.a.t1.k.q;
import d.b.g0.a.t1.k.r;
import d.b.g0.a.t1.k.t;
import d.b.g0.a.t1.k.u;
import d.b.g0.a.t1.k.x;
import d.b.g0.a.t1.k.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class j extends UnitedSchemeBaseDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a0> f46286a = new HashMap();

    public j() {
        a();
    }

    public void a() {
        this.f46286a.clear();
        b(new u(this));
        b(new d.b.g0.a.g1.i(this));
        b(new d0(this));
        b(new d.b.g0.a.t1.k.g(this));
        b(new d.b.g0.a.g1.b(this));
        b(new p(this));
        b(new l(this));
        b(new m(this));
        b(new d.b.g0.a.a2.e.f(this));
        b(new d.b.g0.a.a2.e.g(this));
        b(new n(this));
        b(new o(this));
        b(new d.b.g0.a.a2.e.i(this));
        b(new d.b.g0.a.a2.e.j(this));
        b(new d.b.g0.a.a2.e.a(this));
        b(new d.b.g0.a.a2.e.b(this));
        b(new d.b.g0.a.v1.b.g(this));
        b(new d.b.g0.a.v1.b.f(this));
        b(new d.b.g0.a.v1.b.e(this));
        b(new d.b.g0.a.v1.b.c(this));
        b(new d.b.g0.a.v1.b.b(this));
        b(new d.b.g0.a.v1.b.a(this));
        b(new d.b.g0.a.v1.b.d(this));
        b(new d.b.g0.a.v1.b.i(this));
        b(new d.b.g0.a.t1.k.j(this));
        b(new y(this));
        b(new d.b.g0.a.f0.a.a(this));
        b(new c0(this));
        b(new r(this));
        b(new q(this));
        b(new d.b.g0.a.c2.e.b.a(this));
        b(new d.b.g0.a.c2.e.b.b(this));
        b(new d.b.g0.a.c2.a.b.a(this));
        b(new d.b.g0.a.c2.a.b.b(this));
        b(new d.b.g0.a.b1.f.c.a(this));
        b(new t(this));
        b(new d.b.g0.a.b1.g.d.a(this));
        b(new d.b.g0.a.g1.l(this));
        b(new k(this));
        b(new d.b.g0.a.t1.k.j0.e(this));
        b(new d.b.g0.a.t1.k.j0.b(this));
        b(new d.b.g0.g.b0.a.a.c(this));
        b(new d.b.g0.g.b0.a.a.b(this));
        b(new d.b.g0.a.w.a(this));
        b(new x(this));
        b(new SwanAppDownloadAction(this));
        b(new b0(this));
        b(new d.b.g0.a.t1.k.j0.c(this));
        b(new d.b.g0.a.t1.k.i0.b.b(this));
        b(new d.b.g0.a.t1.k.i0.b.a(this));
        b(new d.b.g0.a.c2.g.b.a(this));
        b(new d.b.g0.a.c2.g.b.b(this));
        b(new d.b.g0.a.c2.c.b.c(this));
        b(new d.b.g0.a.c2.c.b.a(this));
        b(new d.b.g0.a.c2.b.a(this));
        b(new d.b.g0.a.c2.i.a(this));
        b(new d.b.g0.a.c2.b.b(this));
        b(new d.b.g0.a.c2.b.c(this));
        b(new d.b.g0.a.c2.h.a(this));
        b(new d.b.g0.a.r.a.j.a(this));
        b(new d.b.g0.a.v1.b.h(this));
        b(new d.b.g0.a.s0.h.d(this));
        b(new d.b.g0.a.r.a.k.a.a(this));
    }

    public void b(a0 a0Var) {
        this.f46286a.put(a0Var.f46289a, a0Var);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "swanAPI";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
            return false;
        } else if (uri.getPathSegments() != null && !uri.getPathSegments().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("swanAPI");
            arrayList.addAll(uri.getPathSegments());
            String str = "/swanAPI" + uri.getPath();
            if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
                for (int size = arrayList.size(); size > 0; size--) {
                    String str2 = "/" + ((String) arrayList.get(size - 1));
                    if (str.isEmpty() || str.length() < str2.length()) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                        return false;
                    }
                    a0 a0Var = this.f46286a.get(str);
                    if (a0Var != null) {
                        if (unitedSchemeEntity.isOnlyVerify()) {
                            return true;
                        }
                        return a0Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                    }
                    str = str.substring(0, str.length() - str2.length());
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
            return false;
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
            return false;
        }
    }
}
