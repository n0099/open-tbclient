package d.f.b.a;

import android.os.Environment;
import android.os.Looper;
import d.f.b.a.g;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f66848e;

    /* renamed from: f  reason: collision with root package name */
    public static d.f.b.a.b f66849f;

    /* renamed from: a  reason: collision with root package name */
    public g f66850a;

    /* renamed from: d  reason: collision with root package name */
    public List<d> f66853d = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public i f66851b = new i(Looper.getMainLooper().getThread(), f66849f.provideDumpInterval());

    /* renamed from: c  reason: collision with root package name */
    public h f66852c = new h(f66849f.provideDumpInterval());

    /* loaded from: classes6.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // d.f.b.a.g.b
        public void a(long j, long j2, long j3, long j4) {
            ArrayList<String> e2 = c.this.f66851b.e(j, j2);
            if (e2.isEmpty()) {
                return;
            }
            d.f.b.a.j.a b2 = d.f.b.a.j.a.b();
            b2.c(j, j2, j3, j4);
            b2.d(c.this.f66852c.e());
            b2.e(e2);
            b2.a();
            if (c.d().displayNotification()) {
                f.c(b2.toString());
            }
            if (c.this.f66853d.size() != 0) {
                for (d dVar : c.this.f66853d) {
                    dVar.onBlock(c.d().provideContext(), b2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public String f66855a = ".log";

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f66855a);
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

    public static d.f.b.a.b d() {
        return f66849f;
    }

    public static c f() {
        if (f66848e == null) {
            synchronized (c.class) {
                if (f66848e == null) {
                    f66848e = new c();
                }
            }
        }
        return f66848e;
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

    public static void l(d.f.b.a.b bVar) {
        f66849f = bVar;
    }

    public void b(d dVar) {
        this.f66853d.add(dVar);
    }

    public h e() {
        return this.f66852c;
    }

    public g h() {
        return this.f66850a;
    }

    public long j() {
        return d().provideBlockThreshold() * 0.8f;
    }

    public i k() {
        return this.f66851b;
    }

    public final void m(g gVar) {
        this.f66850a = gVar;
    }
}
