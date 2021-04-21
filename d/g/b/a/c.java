package d.g.b.a;

import android.os.Environment;
import android.os.Looper;
import d.g.b.a.g;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f66995e;

    /* renamed from: f  reason: collision with root package name */
    public static d.g.b.a.b f66996f;

    /* renamed from: a  reason: collision with root package name */
    public g f66997a;

    /* renamed from: d  reason: collision with root package name */
    public List<d> f67000d = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public i f66998b = new i(Looper.getMainLooper().getThread(), f66996f.provideDumpInterval());

    /* renamed from: c  reason: collision with root package name */
    public h f66999c = new h(f66996f.provideDumpInterval());

    /* loaded from: classes6.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // d.g.b.a.g.b
        public void a(long j, long j2, long j3, long j4) {
            ArrayList<String> e2 = c.this.f66998b.e(j, j2);
            if (e2.isEmpty()) {
                return;
            }
            d.g.b.a.j.a b2 = d.g.b.a.j.a.b();
            b2.c(j, j2, j3, j4);
            b2.d(c.this.f66999c.e());
            b2.e(e2);
            b2.a();
            if (c.d().displayNotification()) {
                f.c(b2.toString());
            }
            if (c.this.f67000d.size() != 0) {
                for (d dVar : c.this.f67000d) {
                    dVar.onBlock(c.d().provideContext(), b2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public String f67002a = ".log";

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f67002a);
        }
    }

    public c() {
        m(new g(new a(), d().provideBlockThreshold(), d().stopWhenDebugging()));
        f.b();
    }

    public static File c() {
        File file = new File(i());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d.g.b.a.b d() {
        return f66996f;
    }

    public static c f() {
        if (f66995e == null) {
            synchronized (c.class) {
                if (f66995e == null) {
                    f66995e = new c();
                }
            }
        }
        return f66995e;
    }

    public static File[] g() {
        File c2 = c();
        if (c2.exists() && c2.isDirectory()) {
            return c2.listFiles(new b());
        }
        return null;
    }

    public static String i() {
        String externalStorageState = Environment.getExternalStorageState();
        String providePath = d() == null ? "" : d().providePath();
        if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath() + providePath;
        }
        return d().provideContext().getFilesDir() + d().providePath();
    }

    public static void l(d.g.b.a.b bVar) {
        f66996f = bVar;
    }

    public void b(d dVar) {
        this.f67000d.add(dVar);
    }

    public h e() {
        return this.f66999c;
    }

    public g h() {
        return this.f66997a;
    }

    public long j() {
        return d().provideBlockThreshold() * 0.8f;
    }

    public i k() {
        return this.f66998b;
    }

    public final void m(g gVar) {
        this.f66997a = gVar;
    }
}
