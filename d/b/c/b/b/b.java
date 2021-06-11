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
    public final n f69396c;

    /* renamed from: d  reason: collision with root package name */
    public Context f69397d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f69395b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f69394a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1894b f69398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f69399f;

        public a(b bVar, InterfaceC1894b interfaceC1894b, File file) {
            this.f69398e = interfaceC1894b;
            this.f69399f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69398e.a(this.f69399f.length(), this.f69399f.length());
            this.f69398e.a(o.c(this.f69399f, null));
        }
    }

    /* renamed from: d.b.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1894b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f69397d = context;
        this.f69396c = nVar;
    }

    public final String a() {
        File file = new File(d.b.c.b.a.h(this.f69397d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f69394a.put(cVar.f69400a, cVar);
    }

    public void d(String str, InterfaceC1894b interfaceC1894b) {
        e(str, interfaceC1894b, true);
    }

    public void e(String str, InterfaceC1894b interfaceC1894b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f69394a.get(str)) != null) {
            cVar.b(interfaceC1894b);
            return;
        }
        File a2 = interfaceC1894b.a(str);
        if (a2 != null && interfaceC1894b != null) {
            this.f69395b.post(new a(this, interfaceC1894b, a2));
        } else {
            c(g(str, interfaceC1894b, z));
        }
    }

    public final boolean f(String str) {
        return this.f69394a.containsKey(str);
    }

    public final c g(String str, InterfaceC1894b interfaceC1894b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1894b != null ? interfaceC1894b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1894b, z);
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f69400a;

        /* renamed from: b  reason: collision with root package name */
        public String f69401b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1894b> f69402c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.b.b.c f69403d;

        public c(String str, String str2, InterfaceC1894b interfaceC1894b, boolean z) {
            this.f69400a = str;
            this.f69401b = str2;
            b(interfaceC1894b);
        }

        public void a() {
            d.b.c.b.b.c cVar = new d.b.c.b.b.c(this.f69401b, this.f69400a, new a());
            this.f69403d = cVar;
            cVar.setTag("FileLoader#" + this.f69400a);
            b.this.f69396c.a(this.f69403d);
        }

        public void b(InterfaceC1894b interfaceC1894b) {
            if (interfaceC1894b == null) {
                return;
            }
            if (this.f69402c == null) {
                this.f69402c = Collections.synchronizedList(new ArrayList());
            }
            this.f69402c.add(interfaceC1894b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f69400a.equals(this.f69400a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes6.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.b.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1894b> list = c.this.f69402c;
                if (list != null) {
                    for (InterfaceC1894b interfaceC1894b : list) {
                        try {
                            interfaceC1894b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1894b> list = c.this.f69402c;
                if (list != null) {
                    for (InterfaceC1894b interfaceC1894b : list) {
                        try {
                            interfaceC1894b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f69402c.clear();
                }
                b.this.f69394a.remove(c.this.f69400a);
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1894b> list = c.this.f69402c;
                if (list != null) {
                    for (InterfaceC1894b interfaceC1894b : list) {
                        try {
                            interfaceC1894b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1894b.a(c.this.f69400a, oVar.f69540a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f69402c.clear();
                }
                b.this.f69394a.remove(c.this.f69400a);
            }
        }
    }
}
