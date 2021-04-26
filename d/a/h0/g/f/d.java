package d.a.h0.g.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import d.a.h0.a.i2.j;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.u0.d;
import java.io.File;
import java.util.Date;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46303b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static d f46304c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46305a;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f46306a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f46307b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f46308c;

        public a(File file, e eVar, boolean z) {
            this.f46306a = file;
            this.f46307b = eVar;
            this.f46308c = z;
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            this.f46307b.a(false);
            d.this.f46305a = this.f46308c;
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            File k = d.this.k();
            if (k.exists()) {
                d.a.h0.p.d.f(k);
            }
            boolean F = d.a.h0.p.d.F(this.f46306a.getAbsolutePath(), k.getAbsolutePath());
            if (F) {
                d.this.r();
                d.this.q(j.e(new Date(), "'debug'-HH:mm:ss"));
            }
            d.a.h0.p.d.f(this.f46306a);
            this.f46307b.a(F);
            d.this.f46305a = this.f46308c;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46310e;

        public b(e eVar) {
            this.f46310e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46310e.a(d.this.n());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.h0.g.f.k.a {
        public c(d dVar) {
        }

        @Override // d.a.h0.g.f.k.a
        @NonNull
        public File a() {
            return d.m().k();
        }

        @Override // d.a.h0.g.f.k.a
        public void b(@NonNull String str) {
            d.m().q(str);
        }
    }

    /* renamed from: d.a.h0.g.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0933d implements d.a.h0.g.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46312a;

        /* renamed from: d.a.h0.g.f.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0933d c0933d = C0933d.this;
                c0933d.f46312a.a(d.this.n());
            }
        }

        public C0933d(e eVar) {
            this.f46312a = eVar;
        }

        @Override // d.a.h0.g.f.b
        public void a(boolean z) {
            d.this.r();
            k0.X(new a());
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(boolean z);
    }

    public d() {
        this.f46305a = f46303b && d.a.h0.a.m1.a.a.s();
    }

    public static d m() {
        if (f46304c == null) {
            synchronized (d.class) {
                if (f46304c == null) {
                    f46304c = new d();
                }
            }
        }
        return f46304c;
    }

    public void c(String str, e eVar) {
        if (f46303b) {
            boolean z = this.f46305a;
            this.f46305a = true;
            d.C0820d c0820d = new d.C0820d();
            c0820d.f44731a = str;
            File g2 = g();
            new d.a.h0.a.h0.a().e(c0820d, g2.getAbsolutePath(), new a(g2, eVar, z));
        }
    }

    public File d() {
        return new File(d.a.h0.a.u0.d.j(), "sConsole-core");
    }

    public String e() {
        return d.a.h0.p.d.r(l());
    }

    public final File f() {
        File file = new File(d.a.h0.g.q.a.d(), "game_core_console");
        if (f46303b && this.f46305a) {
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
            if (f46303b) {
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

    public void o(@NonNull e eVar) {
        if (f46303b && this.f46305a) {
            k0.X(new b(eVar));
        } else {
            d.a.h0.l.c.c(new d.a.h0.l.l.k.a(e()), new d.a.h0.g.f.j.a(new c(this), new C0933d(eVar)));
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.U(d.a.h0.a.h.aiapps_debug_switch_title);
        aVar.w(d.a.h0.a.h.aiapps_sconsole_load_error);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(false);
        aVar.O(d.a.h0.a.h.aiapps_ok, onClickListener);
        aVar.X();
    }

    public void q(String str) {
        File l = l();
        if (l.exists()) {
            d.a.h0.p.d.f(l);
        }
        d.a.h0.p.d.y(str, l);
    }

    public final void r() {
        File j = j();
        File h2 = h();
        if (h2.exists() || !j.exists()) {
            return;
        }
        String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
        String q = d.a.h0.p.d.q(d.a.h0.a.w0.a.c(), "aigames/sConsole.html");
        if (q != null) {
            d.a.h0.p.d.y(String.format(q, format), h2);
        }
    }
}
