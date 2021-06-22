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
    public final n f69500c;

    /* renamed from: d  reason: collision with root package name */
    public Context f69501d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f69499b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f69498a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1897b f69502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f69503f;

        public a(b bVar, InterfaceC1897b interfaceC1897b, File file) {
            this.f69502e = interfaceC1897b;
            this.f69503f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69502e.a(this.f69503f.length(), this.f69503f.length());
            this.f69502e.a(o.c(this.f69503f, null));
        }
    }

    /* renamed from: d.b.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1897b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f69501d = context;
        this.f69500c = nVar;
    }

    public final String a() {
        File file = new File(d.b.c.b.a.h(this.f69501d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f69498a.put(cVar.f69504a, cVar);
    }

    public void d(String str, InterfaceC1897b interfaceC1897b) {
        e(str, interfaceC1897b, true);
    }

    public void e(String str, InterfaceC1897b interfaceC1897b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f69498a.get(str)) != null) {
            cVar.b(interfaceC1897b);
            return;
        }
        File a2 = interfaceC1897b.a(str);
        if (a2 != null && interfaceC1897b != null) {
            this.f69499b.post(new a(this, interfaceC1897b, a2));
        } else {
            c(g(str, interfaceC1897b, z));
        }
    }

    public final boolean f(String str) {
        return this.f69498a.containsKey(str);
    }

    public final c g(String str, InterfaceC1897b interfaceC1897b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1897b != null ? interfaceC1897b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1897b, z);
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f69504a;

        /* renamed from: b  reason: collision with root package name */
        public String f69505b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1897b> f69506c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.b.b.c f69507d;

        public c(String str, String str2, InterfaceC1897b interfaceC1897b, boolean z) {
            this.f69504a = str;
            this.f69505b = str2;
            b(interfaceC1897b);
        }

        public void a() {
            d.b.c.b.b.c cVar = new d.b.c.b.b.c(this.f69505b, this.f69504a, new a());
            this.f69507d = cVar;
            cVar.setTag("FileLoader#" + this.f69504a);
            b.this.f69500c.a(this.f69507d);
        }

        public void b(InterfaceC1897b interfaceC1897b) {
            if (interfaceC1897b == null) {
                return;
            }
            if (this.f69506c == null) {
                this.f69506c = Collections.synchronizedList(new ArrayList());
            }
            this.f69506c.add(interfaceC1897b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f69504a.equals(this.f69504a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes6.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.b.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1897b> list = c.this.f69506c;
                if (list != null) {
                    for (InterfaceC1897b interfaceC1897b : list) {
                        try {
                            interfaceC1897b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1897b> list = c.this.f69506c;
                if (list != null) {
                    for (InterfaceC1897b interfaceC1897b : list) {
                        try {
                            interfaceC1897b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f69506c.clear();
                }
                b.this.f69498a.remove(c.this.f69504a);
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1897b> list = c.this.f69506c;
                if (list != null) {
                    for (InterfaceC1897b interfaceC1897b : list) {
                        try {
                            interfaceC1897b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1897b.a(c.this.f69504a, oVar.f69644a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f69506c.clear();
                }
                b.this.f69498a.remove(c.this.f69504a);
            }
        }
    }
}
