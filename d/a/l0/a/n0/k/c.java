package d.a.l0.a.n0.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.n.h.i;
import d.a.l0.n.l.b;
import d.a.l0.n.o.g;
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
    public static final c f43645d = new c();

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43642a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43643b = "swan" + File.separator + "libs" + File.separator + "so";

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, e> f43644c = new LinkedHashMap();

    /* loaded from: classes2.dex */
    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f43647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function1 f43648c;

        public a(String str, Ref.ObjectRef objectRef, Function1 function1) {
            this.f43646a = str;
            this.f43647b = objectRef;
            this.f43648c = function1;
        }

        @Override // d.a.l0.n.l.b.a
        public final void a(boolean z) {
            c cVar = c.f43645d;
            if (c.f43642a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.f43646a);
            }
            if (z) {
                c.f43645d.A(this.f43646a, ((i) this.f43647b.element).f48014i);
                c cVar2 = c.f43645d;
                String str = this.f43646a;
                String str2 = ((i) this.f43647b.element).j;
                Intrinsics.checkNotNullExpressionValue(str2, "soPkg.versionName");
                cVar2.B(str, str2);
                c cVar3 = c.f43645d;
                String str3 = this.f43646a;
                AbiType abiType = ((i) this.f43647b.element).q;
                Intrinsics.checkNotNullExpressionValue(abiType, "soPkg.abi");
                cVar3.y(str3, abiType);
                c.f43645d.z(this.f43646a, true);
                this.f43648c.invoke(null);
                return;
            }
            c.f43645d.z(this.f43646a, false);
            this.f43648c.invoke(null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<MsgType> implements d.a.l0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f43649e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(Exception exc) {
            c cVar = c.f43645d;
            if (c.f43642a) {
                StringBuilder sb = new StringBuilder();
                sb.append("main updatePmsPkg pmsUpdateSo end with e: ");
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

    public final void A(String str, long j) {
        h.a().putLong(o(str), j);
    }

    public final void B(String str, String str2) {
        h.a().putString(p(str), str2);
    }

    public final void C(d config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (f43642a) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + config);
        }
        config.e(b.f43649e);
        f fVar = new f(new d.a.l0.n.i.m.h(5), config);
        if (f43642a) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        d.a.l0.n.b.m(fVar);
    }

    public final void f(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        f43644c.remove(libName);
    }

    public final String g(i iVar) {
        if ((iVar != null ? iVar.q : null) == null) {
            return "";
        }
        String str = iVar.p;
        Intrinsics.checkNotNullExpressionValue(str, "so.libName");
        AbiType abiType = iVar.q;
        Intrinsics.checkNotNullExpressionValue(abiType, "so.abi");
        return h(str, abiType, iVar.f48014i);
    }

    public final String h(String libName, AbiType abi, long j) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        Intrinsics.checkNotNullParameter(abi, "abi");
        if (TextUtils.isEmpty(libName) || j < 1) {
            return "";
        }
        File i2 = i();
        File file = new File(i2, libName + File.separator + j + File.separator + abi.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final File i() {
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), f43643b);
    }

    public final e j(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        return f43644c.get(libName);
    }

    public final boolean k(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        return l(libName, s(libName));
    }

    public final boolean l(String libName, long j) {
        AbiType q;
        Intrinsics.checkNotNullParameter(libName, "libName");
        d.a.l0.a.n0.k.a a2 = d.a.l0.a.n0.k.b.a(libName);
        if (a2 != null) {
            if (a2.f()) {
                return true;
            }
            long s = s(libName);
            if (s > 0 && j <= s && (q = q(libName)) != null) {
                return AbiType.currentAbi().compat(q);
            }
        }
        return false;
    }

    public final String m(String str) {
        return "swan_so_installed_abi_" + str;
    }

    public final String n(String str) {
        return "swan_so_installed_result_" + str;
    }

    public final String o(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    public final String p(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    public final AbiType q(String str) {
        return AbiType.findById(h.a().getString(m(str), ""));
    }

    public final boolean r(String str) {
        return h.a().getBoolean(n(str), true);
    }

    public final long s(String str) {
        return h.a().getLong(o(str), 0L);
    }

    public final e t(f updater, String libName) {
        Intrinsics.checkNotNullParameter(updater, "updater");
        Intrinsics.checkNotNullParameter(libName, "libName");
        e j = j(libName);
        if (j == null) {
            e eVar = new e(updater, libName);
            f43644c.put(libName, eVar);
            return eVar;
        }
        return j;
    }

    public final void u() {
        z(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, true);
    }

    public final void v(String libName, long j) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        SharedPreferences.Editor edit = g.a().edit();
        edit.putLong("swan_so_latest_update_time_" + libName, j).apply();
    }

    public final boolean w() {
        return !r(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, d.a.l0.n.h.i] */
    public final void x(String libName, Function1<? super d.a.l0.a.q2.a, Unit> callback) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (f43642a) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + libName);
        }
        d.a.l0.a.n0.k.a a2 = d.a.l0.a.n0.k.b.a(libName);
        if (a2 == null) {
            if (f43642a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + libName);
            }
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(16);
            aVar.b(2900);
            aVar.e("not available: so=" + a2);
            callback.invoke(aVar);
        } else if (a2.f()) {
            if (f43642a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2);
            }
            callback.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r = d.a.l0.n.g.a.h().r(libName);
            objectRef.element = r;
            if (((i) r) != null && ((i) r).a() && AbiType.currentAbi().compat(((i) objectRef.element).q)) {
                AbiType q = q(libName);
                if (l(libName, ((i) objectRef.element).f48014i) && q != null && q.compat(((i) objectRef.element).q)) {
                    if (f43642a) {
                        Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + libName + " soPkg=" + ((i) objectRef.element));
                    }
                    callback.invoke(null);
                    return;
                }
                a2.a(((i) objectRef.element).f48006a, new a(libName, objectRef, callback));
                return;
            }
            if (f43642a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + libName + " soPkg=" + ((i) objectRef.element));
            }
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(16);
            aVar2.b(2900);
            aVar2.e("invalid: pkg=" + ((i) objectRef.element));
            callback.invoke(aVar2);
        }
    }

    public final void y(String str, AbiType abiType) {
        h.a().putString(m(str), abiType.id);
    }

    public final void z(String str, boolean z) {
        h.a().putBoolean(n(str), z);
    }
}
