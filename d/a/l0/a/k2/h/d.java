package d.a.l0.a.k2.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.Pair;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import d.a.l0.t.j;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43278a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f43279b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    public static int f43280c = 0;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43282f;

        public a(String str, int i2) {
            this.f43281e = str;
            this.f43282f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10010);
            bVar.l(String.valueOf(d.f43280c));
            bVar.k(this.f43281e);
            bVar.j(String.valueOf(this.f43282f));
            bVar.h(d.a.l0.a.a2.e.V());
            bVar.m();
            if (this.f43282f == 3) {
                int unused = d.f43280c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.d.i.a<Pair<String, File>> {
        public b(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.d.i.a
        /* renamed from: b */
        public void a(@NonNull Pair<String, File> pair) {
            if (d.f43279b != null && pair.first != null && d.f43279b.contains(pair.first)) {
                new d.a.l0.a.k2.h.c(d.a.l0.a.c1.a.b(), pair.first).f();
                return;
            }
            File file = pair.second;
            if (file != null) {
                d.a.l0.t.d.K(file);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Callable<SharedPreferences> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.h.c f43283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43284f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43285g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43286h;

        public c(d.a.l0.a.k2.h.c cVar, long j, Context context, String str) {
            this.f43283e = cVar;
            this.f43284f = j;
            this.f43285g = context;
            this.f43286h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() throws Exception {
            if (this.f43283e.setCustomMeta(this.f43284f | 1)) {
                String l = d.this.l(this.f43285g, this.f43286h);
                if (d.f43278a) {
                    Log.i("SwanExtensionApiImpl", String.format("customMeta=%d, name=%s, spName=%s", Long.valueOf(this.f43284f), this.f43286h, l));
                }
                if (l == null) {
                    return null;
                }
                return this.f43285g.getSharedPreferences(l, 0);
            }
            return null;
        }
    }

    /* renamed from: d.a.l0.a.k2.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0730d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f43288a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    @AnyThread
    public static void i(int i2, @NonNull String str) {
        q.e().execute(new a(str, i2));
    }

    public static d j() {
        return C0730d.f43288a;
    }

    public final d.a.l0.t.b f(String str) {
        return new j(str);
    }

    public void g(@NonNull String str, Set<String> set, boolean z) {
        h(str, set, z);
        d.a.l0.a.n0.e.c(new File(d.a.l0.a.k2.h.c.A()), str, ".kv", set, z, new b(this));
    }

    public void h(@NonNull String str, Set<String> set, boolean z) {
        d.a.l0.a.n0.e.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
    }

    @NonNull
    @AnyThread
    public d.a.l0.t.b k(Context context, String str, boolean z) {
        try {
            d.a.l0.a.k2.h.c cVar = new d.a.l0.a.k2.h.c(context, str, z ? 2 : 1);
            f43279b.add(str);
            m(context, str, cVar);
            if (f43280c > 0) {
                i(3, str);
            }
            return cVar;
        } catch (NoClassDefFoundError | UnsatisfiedLinkError e2) {
            if (f43278a) {
                Log.e("SwanExtensionApiImpl", "getSharedPrefsImpl", e2);
            }
            f43280c++;
            i(2, str);
            return f(str);
        }
    }

    @Nullable
    public final String l(Context context, String str) {
        if (str == null) {
            str = context.getPackageName() + "_preferences";
        }
        if ("default".equals(str)) {
            if (j.f(context, str).exists()) {
                return str;
            }
            str = context.getPackageName() + "_preferences";
        }
        if (j.f(context, str).exists()) {
            return str;
        }
        return null;
    }

    public final void m(Context context, String str, @NonNull d.a.l0.a.k2.h.c cVar) {
        long customMeta = cVar.getCustomMeta();
        if ((customMeta & 1) == 1) {
            return;
        }
        cVar.z(new c(cVar, customMeta, context, str));
    }

    public d() {
    }
}
