package d.b.g0.g.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import d.b.g0.a.i2.j;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.u0.d;
import java.io.File;
import java.util.Date;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48110b = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static d f48111c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48112a;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f48113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f48115c;

        public a(File file, e eVar, boolean z) {
            this.f48113a = file;
            this.f48114b = eVar;
            this.f48115c = z;
        }

        @Override // d.b.g0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.g0.a.u0.d.c
        public void onFailed() {
            this.f48114b.a(false);
            d.this.f48112a = this.f48115c;
        }

        @Override // d.b.g0.a.u0.d.c
        public void onSuccess() {
            File k = d.this.k();
            if (k.exists()) {
                d.b.g0.p.d.f(k);
            }
            boolean F = d.b.g0.p.d.F(this.f48113a.getAbsolutePath(), k.getAbsolutePath());
            if (F) {
                d.this.r();
                d.this.q(j.e(new Date(), "'debug'-HH:mm:ss"));
            }
            d.b.g0.p.d.f(this.f48113a);
            this.f48114b.a(F);
            d.this.f48112a = this.f48115c;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f48117e;

        public b(e eVar) {
            this.f48117e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48117e.a(d.this.n());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.g0.g.f.k.a {
        public c(d dVar) {
        }

        @Override // d.b.g0.g.f.k.a
        @NonNull
        public File a() {
            return d.m().k();
        }

        @Override // d.b.g0.g.f.k.a
        public void b(@NonNull String str) {
            d.m().q(str);
        }
    }

    /* renamed from: d.b.g0.g.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0961d implements d.b.g0.g.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f48119a;

        /* renamed from: d.b.g0.g.f.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0961d c0961d = C0961d.this;
                c0961d.f48119a.a(d.this.n());
            }
        }

        public C0961d(e eVar) {
            this.f48119a = eVar;
        }

        @Override // d.b.g0.g.f.b
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
        this.f48112a = f48110b && d.b.g0.a.m1.a.a.s();
    }

    public static d m() {
        if (f48111c == null) {
            synchronized (d.class) {
                if (f48111c == null) {
                    f48111c = new d();
                }
            }
        }
        return f48111c;
    }

    public void c(String str, e eVar) {
        if (f48110b) {
            boolean z = this.f48112a;
            this.f48112a = true;
            d.C0848d c0848d = new d.C0848d();
            c0848d.f46598a = str;
            File g2 = g();
            new d.b.g0.a.h0.a().e(c0848d, g2.getAbsolutePath(), new a(g2, eVar, z));
        }
    }

    public File d() {
        return new File(d.b.g0.a.u0.d.j(), "sConsole-core");
    }

    public String e() {
        return d.b.g0.p.d.r(l());
    }

    public final File f() {
        File file = new File(d.b.g0.g.q.a.d(), "game_core_console");
        if (f48110b && this.f48112a) {
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
            if (f48110b) {
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
        if (f48110b && this.f48112a) {
            k0.X(new b(eVar));
        } else {
            d.b.g0.l.c.c(new d.b.g0.l.l.k.a(e()), new d.b.g0.g.f.j.a(new c(this), new C0961d(eVar)));
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.U(d.b.g0.a.h.aiapps_debug_switch_title);
        aVar.w(d.b.g0.a.h.aiapps_sconsole_load_error);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(false);
        aVar.O(d.b.g0.a.h.aiapps_ok, onClickListener);
        aVar.X();
    }

    public void q(String str) {
        File l = l();
        if (l.exists()) {
            d.b.g0.p.d.f(l);
        }
        d.b.g0.p.d.y(str, l);
    }

    public final void r() {
        File j = j();
        File h2 = h();
        if (h2.exists() || !j.exists()) {
            return;
        }
        String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
        String q = d.b.g0.p.d.q(d.b.g0.a.w0.a.c(), "aigames/sConsole.html");
        if (q != null) {
            d.b.g0.p.d.y(String.format(q, format), h2);
        }
    }
}
