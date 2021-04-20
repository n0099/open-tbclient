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
    public final n f66446c;

    /* renamed from: d  reason: collision with root package name */
    public Context f66447d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f66445b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f66444a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1824b f66448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f66449f;

        public a(b bVar, InterfaceC1824b interfaceC1824b, File file) {
            this.f66448e = interfaceC1824b;
            this.f66449f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66448e.a(this.f66449f.length(), this.f66449f.length());
            this.f66448e.a(o.c(this.f66449f, null));
        }
    }

    /* renamed from: d.c.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1824b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f66447d = context;
        this.f66446c = nVar;
    }

    public final String a() {
        File file = new File(d.c.c.b.a.h(this.f66447d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f66444a.put(cVar.f66450a, cVar);
    }

    public void d(String str, InterfaceC1824b interfaceC1824b) {
        e(str, interfaceC1824b, true);
    }

    public void e(String str, InterfaceC1824b interfaceC1824b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f66444a.get(str)) != null) {
            cVar.b(interfaceC1824b);
            return;
        }
        File a2 = interfaceC1824b.a(str);
        if (a2 != null && interfaceC1824b != null) {
            this.f66445b.post(new a(this, interfaceC1824b, a2));
        } else {
            c(g(str, interfaceC1824b, z));
        }
    }

    public final boolean f(String str) {
        return this.f66444a.containsKey(str);
    }

    public final c g(String str, InterfaceC1824b interfaceC1824b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1824b != null ? interfaceC1824b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1824b, z);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f66450a;

        /* renamed from: b  reason: collision with root package name */
        public String f66451b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1824b> f66452c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.b.b.c f66453d;

        public c(String str, String str2, InterfaceC1824b interfaceC1824b, boolean z) {
            this.f66450a = str;
            this.f66451b = str2;
            b(interfaceC1824b);
        }

        public void a() {
            d.c.c.b.b.c cVar = new d.c.c.b.b.c(this.f66451b, this.f66450a, new a());
            this.f66453d = cVar;
            cVar.setTag("FileLoader#" + this.f66450a);
            b.this.f66446c.a(this.f66453d);
        }

        public void b(InterfaceC1824b interfaceC1824b) {
            if (interfaceC1824b == null) {
                return;
            }
            if (this.f66452c == null) {
                this.f66452c = Collections.synchronizedList(new ArrayList());
            }
            this.f66452c.add(interfaceC1824b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f66450a.equals(this.f66450a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.c.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1824b> list = c.this.f66452c;
                if (list != null) {
                    for (InterfaceC1824b interfaceC1824b : list) {
                        try {
                            interfaceC1824b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1824b> list = c.this.f66452c;
                if (list != null) {
                    for (InterfaceC1824b interfaceC1824b : list) {
                        try {
                            interfaceC1824b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f66452c.clear();
                }
                b.this.f66444a.remove(c.this.f66450a);
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1824b> list = c.this.f66452c;
                if (list != null) {
                    for (InterfaceC1824b interfaceC1824b : list) {
                        try {
                            interfaceC1824b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1824b.a(c.this.f66450a, oVar.f66584a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f66452c.clear();
                }
                b.this.f66444a.remove(c.this.f66450a);
            }
        }
    }
}
