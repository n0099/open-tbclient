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
    public final n f66541c;

    /* renamed from: d  reason: collision with root package name */
    public Context f66542d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f66540b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f66539a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1827b f66543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f66544f;

        public a(b bVar, InterfaceC1827b interfaceC1827b, File file) {
            this.f66543e = interfaceC1827b;
            this.f66544f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66543e.a(this.f66544f.length(), this.f66544f.length());
            this.f66543e.a(o.c(this.f66544f, null));
        }
    }

    /* renamed from: d.c.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1827b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f66542d = context;
        this.f66541c = nVar;
    }

    public final String a() {
        File file = new File(d.c.c.b.a.h(this.f66542d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f66539a.put(cVar.f66545a, cVar);
    }

    public void d(String str, InterfaceC1827b interfaceC1827b) {
        e(str, interfaceC1827b, true);
    }

    public void e(String str, InterfaceC1827b interfaceC1827b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f66539a.get(str)) != null) {
            cVar.b(interfaceC1827b);
            return;
        }
        File a2 = interfaceC1827b.a(str);
        if (a2 != null && interfaceC1827b != null) {
            this.f66540b.post(new a(this, interfaceC1827b, a2));
        } else {
            c(g(str, interfaceC1827b, z));
        }
    }

    public final boolean f(String str) {
        return this.f66539a.containsKey(str);
    }

    public final c g(String str, InterfaceC1827b interfaceC1827b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1827b != null ? interfaceC1827b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1827b, z);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f66545a;

        /* renamed from: b  reason: collision with root package name */
        public String f66546b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1827b> f66547c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.b.b.c f66548d;

        public c(String str, String str2, InterfaceC1827b interfaceC1827b, boolean z) {
            this.f66545a = str;
            this.f66546b = str2;
            b(interfaceC1827b);
        }

        public void a() {
            d.c.c.b.b.c cVar = new d.c.c.b.b.c(this.f66546b, this.f66545a, new a());
            this.f66548d = cVar;
            cVar.setTag("FileLoader#" + this.f66545a);
            b.this.f66541c.a(this.f66548d);
        }

        public void b(InterfaceC1827b interfaceC1827b) {
            if (interfaceC1827b == null) {
                return;
            }
            if (this.f66547c == null) {
                this.f66547c = Collections.synchronizedList(new ArrayList());
            }
            this.f66547c.add(interfaceC1827b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f66545a.equals(this.f66545a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.c.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1827b> list = c.this.f66547c;
                if (list != null) {
                    for (InterfaceC1827b interfaceC1827b : list) {
                        try {
                            interfaceC1827b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1827b> list = c.this.f66547c;
                if (list != null) {
                    for (InterfaceC1827b interfaceC1827b : list) {
                        try {
                            interfaceC1827b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f66547c.clear();
                }
                b.this.f66539a.remove(c.this.f66545a);
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1827b> list = c.this.f66547c;
                if (list != null) {
                    for (InterfaceC1827b interfaceC1827b : list) {
                        try {
                            interfaceC1827b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1827b.a(c.this.f66545a, oVar.f66679a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f66547c.clear();
                }
                b.this.f66539a.remove(c.this.f66545a);
            }
        }
    }
}
