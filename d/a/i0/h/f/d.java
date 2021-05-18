package d.a.i0.h.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import d.a.i0.a.a1.e;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.h;
import java.io.File;
import java.util.Date;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47162b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static d f47163c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47164a;

    /* loaded from: classes3.dex */
    public class a implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f47165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f47166b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f47167c;

        public a(File file, d.a.i0.a.v2.e1.b bVar, boolean z) {
            this.f47165a = file;
            this.f47166b = bVar;
            this.f47167c = z;
        }

        @Override // d.a.i0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.i0.a.a1.e.c
        public void onFailed() {
            this.f47166b.onCallback(Boolean.FALSE);
            d.this.f47164a = this.f47167c;
        }

        @Override // d.a.i0.a.a1.e.c
        public void onSuccess() {
            File k = d.this.k();
            if (k.exists()) {
                d.a.i0.t.d.i(k);
            }
            boolean T = d.a.i0.t.d.T(this.f47165a.getAbsolutePath(), k.getAbsolutePath());
            if (T) {
                d.this.r();
                Date date = new Date();
                d.this.q(d.a.i0.a.v2.k.e(date, "'debug'-HH:mm:ss"), date.getTime());
            }
            d.a.i0.t.d.i(this.f47165a);
            this.f47166b.onCallback(Boolean.valueOf(T));
            d.this.f47164a = this.f47167c;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f47169e;

        public b(d.a.i0.a.v2.e1.b bVar) {
            this.f47169e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47169e.onCallback(Boolean.valueOf(d.this.n()));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.i0.h.f.k.a {
        public c(d dVar) {
        }

        @Override // d.a.i0.h.f.k.a
        @NonNull
        public File a() {
            return d.m().k();
        }

        @Override // d.a.i0.h.f.k.a
        public void b(@NonNull String str, long j) {
            d.m().q(str, j);
        }
    }

    /* renamed from: d.a.i0.h.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1012d implements d.a.i0.h.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f47171a;

        /* renamed from: d.a.i0.h.f.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1012d c1012d = C1012d.this;
                c1012d.f47171a.onCallback(Boolean.valueOf(d.this.n()));
            }
        }

        public C1012d(d.a.i0.a.v2.e1.b bVar) {
            this.f47171a = bVar;
        }

        @Override // d.a.i0.h.f.b
        public void a(boolean z) {
            d.this.r();
            q0.b0(new a());
        }
    }

    public d() {
        this.f47164a = f47162b && d.a.i0.a.u1.a.a.u();
    }

    public static d m() {
        if (f47163c == null) {
            synchronized (d.class) {
                if (f47163c == null) {
                    f47163c = new d();
                }
            }
        }
        return f47163c;
    }

    public void c(String str, d.a.i0.a.v2.e1.b<Boolean> bVar) {
        if (f47162b) {
            boolean z = this.f47164a;
            this.f47164a = true;
            e.d dVar = new e.d();
            dVar.f40516a = str;
            File g2 = g();
            new d.a.i0.a.k0.a().e(dVar, g2.getAbsolutePath(), new a(g2, bVar, z));
        }
    }

    public long d() {
        return d.a.i0.a.k2.g.h.a().getLong("swan-game-sconsole-version-code", -1L);
    }

    public String e() {
        String string = d.a.i0.a.k2.g.h.a().getString("swan-game-sconsole-version-name", "");
        return !TextUtils.isEmpty(string) ? string : d.a.i0.t.d.D(l());
    }

    public final File f() {
        File file = new File(d.a.i0.h.s.a.d(), "game_core_console");
        if (f47162b && this.f47164a) {
            file = new File(file, "debug");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File g() {
        return new File(f(), "debugGameSconsole.zip");
    }

    public final File h() {
        return new File(f(), "swan-game-sconsole.html");
    }

    public String i() {
        try {
            return h().toURI().toURL().toString();
        } catch (Exception e2) {
            if (f47162b) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e2);
                return "";
            }
            return "";
        }
    }

    public final File j() {
        return new File(k(), "swan-game-sconsole.js");
    }

    public File k() {
        return new File(f(), UriUtil.LOCAL_RESOURCE_SCHEME);
    }

    public final File l() {
        return new File(k(), "swan-game-sconsole.version");
    }

    public boolean n() {
        return j().exists() && h().exists();
    }

    public void o(@NonNull d.a.i0.a.v2.e1.b<Boolean> bVar) {
        if (f47162b && this.f47164a) {
            q0.b0(new b(bVar));
        } else {
            d.a.i0.n.b.e(new d.a.i0.n.i.m.a(e(), d()), new d.a.i0.h.f.j.a(new c(this), new C1012d(bVar)));
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        h.a aVar = new h.a(activity);
        aVar.U(d.a.i0.a.h.aiapps_debug_switch_title);
        aVar.v(d.a.i0.f.g.aiapps_sconsole_load_error);
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.m(false);
        aVar.O(d.a.i0.f.g.aiapps_ok, onClickListener);
        aVar.X();
    }

    public void q(String str, long j) {
        File l = l();
        if (l.exists()) {
            d.a.i0.t.d.i(l);
        }
        d.a.i0.a.k2.g.h.a().putString("swan-game-sconsole-version-name", str);
        d.a.i0.a.k2.g.h.a().putLong("swan-game-sconsole-version-code", j);
    }

    public final void r() {
        File j = j();
        File h2 = h();
        if (h2.exists() || !j.exists()) {
            return;
        }
        String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
        String C = d.a.i0.t.d.C(d.a.i0.a.c1.a.b(), "aigames/sConsole.html");
        if (C != null) {
            d.a.i0.t.d.M(String.format(C, format), h2);
        }
    }
}
