package d.c.c.b.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import d.c.c.b.b.c;
import d.c.c.b.d.n;
import d.c.c.b.d.o;
import d.c.c.b.d.q;
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
    public final n f65601c;

    /* renamed from: d  reason: collision with root package name */
    public Context f65602d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f65600b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f65599a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1796b f65603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f65604f;

        public a(b bVar, InterfaceC1796b interfaceC1796b, File file) {
            this.f65603e = interfaceC1796b;
            this.f65604f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65603e.a(this.f65604f.length(), this.f65604f.length());
            this.f65603e.a(o.c(this.f65604f, null));
        }
    }

    /* renamed from: d.c.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1796b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f65602d = context;
        this.f65601c = nVar;
    }

    public final String a() {
        File file = new File(d.c.c.b.a.h(this.f65602d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f65599a.put(cVar.f65605a, cVar);
    }

    public void d(String str, InterfaceC1796b interfaceC1796b) {
        e(str, interfaceC1796b, true);
    }

    public void e(String str, InterfaceC1796b interfaceC1796b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f65599a.get(str)) != null) {
            cVar.b(interfaceC1796b);
            return;
        }
        File a2 = interfaceC1796b.a(str);
        if (a2 != null && interfaceC1796b != null) {
            this.f65600b.post(new a(this, interfaceC1796b, a2));
        } else {
            c(g(str, interfaceC1796b, z));
        }
    }

    public final boolean f(String str) {
        return this.f65599a.containsKey(str);
    }

    public final c g(String str, InterfaceC1796b interfaceC1796b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1796b != null ? interfaceC1796b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1796b, z);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f65605a;

        /* renamed from: b  reason: collision with root package name */
        public String f65606b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1796b> f65607c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.b.b.c f65608d;

        public c(String str, String str2, InterfaceC1796b interfaceC1796b, boolean z) {
            this.f65605a = str;
            this.f65606b = str2;
            b(interfaceC1796b);
        }

        public void a() {
            d.c.c.b.b.c cVar = new d.c.c.b.b.c(this.f65606b, this.f65605a, new a());
            this.f65608d = cVar;
            cVar.setTag("FileLoader#" + this.f65605a);
            b.this.f65601c.a(this.f65608d);
        }

        public void b(InterfaceC1796b interfaceC1796b) {
            if (interfaceC1796b == null) {
                return;
            }
            if (this.f65607c == null) {
                this.f65607c = Collections.synchronizedList(new ArrayList());
            }
            this.f65607c.add(interfaceC1796b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f65605a.equals(this.f65605a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.c.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1796b> list = c.this.f65607c;
                if (list != null) {
                    for (InterfaceC1796b interfaceC1796b : list) {
                        try {
                            interfaceC1796b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1796b> list = c.this.f65607c;
                if (list != null) {
                    for (InterfaceC1796b interfaceC1796b : list) {
                        try {
                            interfaceC1796b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f65607c.clear();
                }
                b.this.f65599a.remove(c.this.f65605a);
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1796b> list = c.this.f65607c;
                if (list != null) {
                    for (InterfaceC1796b interfaceC1796b : list) {
                        try {
                            interfaceC1796b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1796b.a(c.this.f65605a, oVar.f65739a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f65607c.clear();
                }
                b.this.f65599a.remove(c.this.f65605a);
            }
        }
    }
}
