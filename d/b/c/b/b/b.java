package d.b.c.b.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import d.b.c.b.b.c;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
import d.b.c.b.d.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final n f65665c;

    /* renamed from: d  reason: collision with root package name */
    public Context f65666d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f65664b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f65663a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1835b f65667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f65668f;

        public a(b bVar, InterfaceC1835b interfaceC1835b, File file) {
            this.f65667e = interfaceC1835b;
            this.f65668f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65667e.a(this.f65668f.length(), this.f65668f.length());
            this.f65667e.a(o.c(this.f65668f, null));
        }
    }

    /* renamed from: d.b.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1835b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f65666d = context;
        this.f65665c = nVar;
    }

    public final String a() {
        File file = new File(d.b.c.b.a.h(this.f65666d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f65663a.put(cVar.f65669a, cVar);
    }

    public void d(String str, InterfaceC1835b interfaceC1835b) {
        e(str, interfaceC1835b, true);
    }

    public void e(String str, InterfaceC1835b interfaceC1835b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f65663a.get(str)) != null) {
            cVar.b(interfaceC1835b);
            return;
        }
        File a2 = interfaceC1835b.a(str);
        if (a2 != null && interfaceC1835b != null) {
            this.f65664b.post(new a(this, interfaceC1835b, a2));
        } else {
            c(g(str, interfaceC1835b, z));
        }
    }

    public final boolean f(String str) {
        return this.f65663a.containsKey(str);
    }

    public final c g(String str, InterfaceC1835b interfaceC1835b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1835b != null ? interfaceC1835b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1835b, z);
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f65669a;

        /* renamed from: b  reason: collision with root package name */
        public String f65670b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1835b> f65671c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.b.b.c f65672d;

        public c(String str, String str2, InterfaceC1835b interfaceC1835b, boolean z) {
            this.f65669a = str;
            this.f65670b = str2;
            b(interfaceC1835b);
        }

        public void a() {
            d.b.c.b.b.c cVar = new d.b.c.b.b.c(this.f65670b, this.f65669a, new a());
            this.f65672d = cVar;
            cVar.setTag("FileLoader#" + this.f65669a);
            b.this.f65665c.a(this.f65672d);
        }

        public void b(InterfaceC1835b interfaceC1835b) {
            if (interfaceC1835b == null) {
                return;
            }
            if (this.f65671c == null) {
                this.f65671c = Collections.synchronizedList(new ArrayList());
            }
            this.f65671c.add(interfaceC1835b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f65669a.equals(this.f65669a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes6.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.b.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1835b> list = c.this.f65671c;
                if (list != null) {
                    for (InterfaceC1835b interfaceC1835b : list) {
                        try {
                            interfaceC1835b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1835b> list = c.this.f65671c;
                if (list != null) {
                    for (InterfaceC1835b interfaceC1835b : list) {
                        try {
                            interfaceC1835b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f65671c.clear();
                }
                b.this.f65663a.remove(c.this.f65669a);
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1835b> list = c.this.f65671c;
                if (list != null) {
                    for (InterfaceC1835b interfaceC1835b : list) {
                        try {
                            interfaceC1835b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1835b.a(c.this.f65669a, oVar.f65809a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f65671c.clear();
                }
                b.this.f65663a.remove(c.this.f65669a);
            }
        }
    }
}
