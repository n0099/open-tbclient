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
    public final n f65600c;

    /* renamed from: d  reason: collision with root package name */
    public Context f65601d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f65599b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f65598a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1795b f65602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f65603f;

        public a(b bVar, InterfaceC1795b interfaceC1795b, File file) {
            this.f65602e = interfaceC1795b;
            this.f65603f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65602e.a(this.f65603f.length(), this.f65603f.length());
            this.f65602e.a(o.c(this.f65603f, null));
        }
    }

    /* renamed from: d.c.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1795b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f65601d = context;
        this.f65600c = nVar;
    }

    public final String a() {
        File file = new File(d.c.c.b.a.h(this.f65601d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f65598a.put(cVar.f65604a, cVar);
    }

    public void d(String str, InterfaceC1795b interfaceC1795b) {
        e(str, interfaceC1795b, true);
    }

    public void e(String str, InterfaceC1795b interfaceC1795b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f65598a.get(str)) != null) {
            cVar.b(interfaceC1795b);
            return;
        }
        File a2 = interfaceC1795b.a(str);
        if (a2 != null && interfaceC1795b != null) {
            this.f65599b.post(new a(this, interfaceC1795b, a2));
        } else {
            c(g(str, interfaceC1795b, z));
        }
    }

    public final boolean f(String str) {
        return this.f65598a.containsKey(str);
    }

    public final c g(String str, InterfaceC1795b interfaceC1795b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1795b != null ? interfaceC1795b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1795b, z);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f65604a;

        /* renamed from: b  reason: collision with root package name */
        public String f65605b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1795b> f65606c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.b.b.c f65607d;

        public c(String str, String str2, InterfaceC1795b interfaceC1795b, boolean z) {
            this.f65604a = str;
            this.f65605b = str2;
            b(interfaceC1795b);
        }

        public void a() {
            d.c.c.b.b.c cVar = new d.c.c.b.b.c(this.f65605b, this.f65604a, new a());
            this.f65607d = cVar;
            cVar.setTag("FileLoader#" + this.f65604a);
            b.this.f65600c.a(this.f65607d);
        }

        public void b(InterfaceC1795b interfaceC1795b) {
            if (interfaceC1795b == null) {
                return;
            }
            if (this.f65606c == null) {
                this.f65606c = Collections.synchronizedList(new ArrayList());
            }
            this.f65606c.add(interfaceC1795b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f65604a.equals(this.f65604a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.c.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1795b> list = c.this.f65606c;
                if (list != null) {
                    for (InterfaceC1795b interfaceC1795b : list) {
                        try {
                            interfaceC1795b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1795b> list = c.this.f65606c;
                if (list != null) {
                    for (InterfaceC1795b interfaceC1795b : list) {
                        try {
                            interfaceC1795b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f65606c.clear();
                }
                b.this.f65598a.remove(c.this.f65604a);
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1795b> list = c.this.f65606c;
                if (list != null) {
                    for (InterfaceC1795b interfaceC1795b : list) {
                        try {
                            interfaceC1795b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1795b.a(c.this.f65604a, oVar.f65738a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f65606c.clear();
                }
                b.this.f65598a.remove(c.this.f65604a);
            }
        }
    }
}
