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
    public static c f69972e;

    /* renamed from: f  reason: collision with root package name */
    public static d.f.b.a.b f69973f;

    /* renamed from: a  reason: collision with root package name */
    public g f69974a;

    /* renamed from: d  reason: collision with root package name */
    public List<d> f69977d = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public i f69975b = new i(Looper.getMainLooper().getThread(), f69973f.provideDumpInterval());

    /* renamed from: c  reason: collision with root package name */
    public h f69976c = new h(f69973f.provideDumpInterval());

    /* loaded from: classes6.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // d.f.b.a.g.b
        public void a(long j, long j2, long j3, long j4) {
            ArrayList<String> e2 = c.this.f69975b.e(j, j2);
            if (e2.isEmpty()) {
                return;
            }
            d.f.b.a.j.a b2 = d.f.b.a.j.a.b();
            b2.c(j, j2, j3, j4);
            b2.d(c.this.f69976c.e());
            b2.e(e2);
            b2.a();
            if (c.d().displayNotification()) {
                f.c(b2.toString());
            }
            if (c.this.f69977d.size() != 0) {
                for (d dVar : c.this.f69977d) {
                    dVar.onBlock(c.d().provideContext(), b2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public String f69979a = ".log";

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f69979a);
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
        return f69973f;
    }

    public static c f() {
        if (f69972e == null) {
            synchronized (c.class) {
                if (f69972e == null) {
                    f69972e = new c();
                }
            }
        }
        return f69972e;
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
        f69973f = bVar;
    }

    public void b(d dVar) {
        this.f69977d.add(dVar);
    }

    public h e() {
        return this.f69976c;
    }

    public g h() {
        return this.f69974a;
    }

    public long j() {
        return d().provideBlockThreshold() * 0.8f;
    }

    public i k() {
        return this.f69975b;
    }

    public final void m(g gVar) {
        this.f69974a = gVar;
    }
}
