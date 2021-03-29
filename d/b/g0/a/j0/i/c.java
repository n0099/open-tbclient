package d.b.g0.a.j0.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.utils.AbiType;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.k;
import d.b.g0.l.k.i;
import d.b.g0.l.o.b;
import d.b.g0.l.r.g;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final c f44832d = new c();

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44829a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44830b = "swan" + File.separator + "libs" + File.separator + "so";

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, e> f44831c = new LinkedHashMap();

    /* loaded from: classes2.dex */
    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f44834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function1 f44835c;

        public a(String str, Ref.ObjectRef objectRef, Function1 function1) {
            this.f44833a = str;
            this.f44834b = objectRef;
            this.f44835c = function1;
        }

        @Override // d.b.g0.l.o.b.a
        public final void a(boolean z) {
            c cVar = c.f44832d;
            if (c.f44829a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.f44833a);
            }
            if (z) {
                c.f44832d.u(this.f44833a, ((i) this.f44834b.element).i);
                c cVar2 = c.f44832d;
                String str = this.f44833a;
                String str2 = ((i) this.f44834b.element).j;
                Intrinsics.checkExpressionValueIsNotNull(str2, "soPkg.versionName");
                cVar2.v(str, str2);
                c cVar3 = c.f44832d;
                String str3 = this.f44833a;
                AbiType abiType = ((i) this.f44834b.element).q;
                Intrinsics.checkExpressionValueIsNotNull(abiType, "soPkg.abi");
                cVar3.t(str3, abiType);
                this.f44835c.invoke(null);
                return;
            }
            Function1 function1 = this.f44835c;
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(16);
            aVar.b(2900);
            aVar.e("install error: pkg=" + ((i) this.f44834b.element));
            function1.invoke(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<MsgType> implements d.b.g0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f44836e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public final void onCallback(Exception exc) {
            c cVar = c.f44832d;
            if (c.f44829a) {
                StringBuilder sb = new StringBuilder();
                sb.append("main updatePmsPkg pmsUpdateSo end with e: ");
                sb.append("");
                sb.append(exc);
                sb.append(" trace=");
                if (exc == null) {
                    exc = new Exception();
                }
                sb.append(Log.getStackTraceString(exc));
                Log.i("SoLibManager", sb.toString());
            }
        }
    }

    public final void e(String str) {
        f44831c.remove(str);
    }

    public final String f(i iVar) {
        if ((iVar != null ? iVar.q : null) == null) {
            return "";
        }
        String str = iVar.p;
        Intrinsics.checkExpressionValueIsNotNull(str, "so.libName");
        AbiType abiType = iVar.q;
        Intrinsics.checkExpressionValueIsNotNull(abiType, "so.abi");
        return g(str, abiType, iVar.i);
    }

    public final String g(String str, AbiType abiType, long j) {
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File h2 = h();
        File file = new File(h2, "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final File h() {
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), f44830b);
    }

    public final e i(String str) {
        return f44831c.get(str);
    }

    public final boolean j(String str) {
        return k(str, p(str));
    }

    public final boolean k(String str, long j) {
        AbiType o;
        d.b.g0.a.j0.i.a a2 = d.b.g0.a.j0.i.b.a(str);
        if (a2 != null) {
            if (a2.f()) {
                return true;
            }
            long p = p(str);
            if (p > 0 && j <= p && (o = o(str)) != null) {
                return AbiType.currentAbi().compat(o);
            }
        }
        return false;
    }

    public final String l(String str) {
        return "swan_so_installed_abi_" + str;
    }

    public final String m(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    public final String n(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    public final AbiType o(String str) {
        return AbiType.findById(h.a().getString(l(str), ""));
    }

    public final long p(String str) {
        return h.a().getLong(m(str), 0L);
    }

    public final e q(f fVar, String str) {
        e i = i(str);
        if (i == null) {
            e eVar = new e(fVar, str);
            f44831c.put(str, eVar);
            return eVar;
        }
        return i;
    }

    public final void r(String str, long j) {
        SharedPreferences.Editor edit = g.a().edit();
        edit.putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [d.b.g0.l.k.i, T] */
    public final void s(String str, Function1<? super d.b.g0.a.f2.a, Unit> function1) {
        if (f44829a) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        d.b.g0.a.j0.i.a a2 = d.b.g0.a.j0.i.b.a(str);
        if (a2 == null) {
            if (f44829a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(16);
            aVar.b(2900);
            aVar.e("not available: so=" + a2);
            function1.invoke(aVar);
        } else if (a2.f()) {
            if (f44829a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2);
            }
            function1.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? q = d.b.g0.l.i.a.h().q(str);
            objectRef.element = q;
            if (((i) q) != null && ((i) q).a() && AbiType.currentAbi().compat(((i) objectRef.element).q)) {
                AbiType o = o(str);
                if (k(str, ((i) objectRef.element).i) && o != null && o.compat(((i) objectRef.element).q)) {
                    if (f44829a) {
                        Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                    }
                    function1.invoke(null);
                    return;
                }
                a2.a(((i) objectRef.element).f48917a, new a(str, objectRef, function1));
                return;
            }
            if (f44829a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
            }
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(16);
            aVar2.b(2900);
            aVar2.e("invalid: pkg=" + ((i) objectRef.element));
            function1.invoke(aVar2);
        }
    }

    public final void t(String str, AbiType abiType) {
        h.a().putString(l(str), abiType.id);
    }

    public final void u(String str, long j) {
        h.a().putLong(m(str), j);
    }

    public final void v(String str, String str2) {
        h.a().putString(n(str), str2);
    }

    public final void w(d dVar) {
        if (f44829a) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.e(b.f44836e);
        f fVar = new f(new d.b.g0.l.l.k.h(5), dVar);
        if (f44829a) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        d.b.g0.l.c.k(fVar);
    }
}
