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
/* loaded from: classes5.dex */
public class b {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final n f64936c;

    /* renamed from: d  reason: collision with root package name */
    public Context f64937d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f64935b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f64934a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1767b f64938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f64939f;

        public a(b bVar, InterfaceC1767b interfaceC1767b, File file) {
            this.f64938e = interfaceC1767b;
            this.f64939f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64938e.a(this.f64939f.length(), this.f64939f.length());
            this.f64938e.a(o.c(this.f64939f, null));
        }
    }

    /* renamed from: d.b.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1767b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f64937d = context;
        this.f64936c = nVar;
    }

    public final String a() {
        File file = new File(d.b.c.b.a.h(this.f64937d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f64934a.put(cVar.f64940a, cVar);
    }

    public void d(String str, InterfaceC1767b interfaceC1767b) {
        e(str, interfaceC1767b, true);
    }

    public void e(String str, InterfaceC1767b interfaceC1767b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f64934a.get(str)) != null) {
            cVar.b(interfaceC1767b);
            return;
        }
        File a2 = interfaceC1767b.a(str);
        if (a2 != null && interfaceC1767b != null) {
            this.f64935b.post(new a(this, interfaceC1767b, a2));
        } else {
            c(g(str, interfaceC1767b, z));
        }
    }

    public final boolean f(String str) {
        return this.f64934a.containsKey(str);
    }

    public final c g(String str, InterfaceC1767b interfaceC1767b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1767b != null ? interfaceC1767b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1767b, z);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f64940a;

        /* renamed from: b  reason: collision with root package name */
        public String f64941b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1767b> f64942c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.b.b.c f64943d;

        public c(String str, String str2, InterfaceC1767b interfaceC1767b, boolean z) {
            this.f64940a = str;
            this.f64941b = str2;
            b(interfaceC1767b);
        }

        public void a() {
            d.b.c.b.b.c cVar = new d.b.c.b.b.c(this.f64941b, this.f64940a, new a());
            this.f64943d = cVar;
            cVar.setTag("FileLoader#" + this.f64940a);
            b.this.f64936c.a(this.f64943d);
        }

        public void b(InterfaceC1767b interfaceC1767b) {
            if (interfaceC1767b == null) {
                return;
            }
            if (this.f64942c == null) {
                this.f64942c = Collections.synchronizedList(new ArrayList());
            }
            this.f64942c.add(interfaceC1767b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f64940a.equals(this.f64940a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.b.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1767b> list = c.this.f64942c;
                if (list != null) {
                    for (InterfaceC1767b interfaceC1767b : list) {
                        try {
                            interfaceC1767b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1767b> list = c.this.f64942c;
                if (list != null) {
                    for (InterfaceC1767b interfaceC1767b : list) {
                        try {
                            interfaceC1767b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f64942c.clear();
                }
                b.this.f64934a.remove(c.this.f64940a);
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1767b> list = c.this.f64942c;
                if (list != null) {
                    for (InterfaceC1767b interfaceC1767b : list) {
                        try {
                            interfaceC1767b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1767b.a(c.this.f64940a, oVar.f65080a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f64942c.clear();
                }
                b.this.f64934a.remove(c.this.f64940a);
            }
        }
    }
}
