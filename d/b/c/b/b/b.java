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
    public final n f65622c;

    /* renamed from: d  reason: collision with root package name */
    public Context f65623d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f65621b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f65620a = Collections.synchronizedMap(new LinkedHashMap());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1831b f65624e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f65625f;

        public a(b bVar, InterfaceC1831b interfaceC1831b, File file) {
            this.f65624e = interfaceC1831b;
            this.f65625f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65624e.a(this.f65625f.length(), this.f65625f.length());
            this.f65624e.a(o.c(this.f65625f, null));
        }
    }

    /* renamed from: d.b.c.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1831b extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull n nVar) {
        this.f65623d = context;
        this.f65622c = nVar;
    }

    public final String a() {
        File file = new File(d.b.c.b.a.h(this.f65623d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public final void c(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.f65620a.put(cVar.f65626a, cVar);
    }

    public void d(String str, InterfaceC1831b interfaceC1831b) {
        e(str, interfaceC1831b, true);
    }

    public void e(String str, InterfaceC1831b interfaceC1831b, boolean z) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f(str) && (cVar = this.f65620a.get(str)) != null) {
            cVar.b(interfaceC1831b);
            return;
        }
        File a2 = interfaceC1831b.a(str);
        if (a2 != null && interfaceC1831b != null) {
            this.f65621b.post(new a(this, interfaceC1831b, a2));
        } else {
            c(g(str, interfaceC1831b, z));
        }
    }

    public final boolean f(String str) {
        return this.f65620a.containsKey(str);
    }

    public final c g(String str, InterfaceC1831b interfaceC1831b, boolean z) {
        String absolutePath;
        File b2 = interfaceC1831b != null ? interfaceC1831b.b(str) : null;
        if (b2 == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b2.getAbsolutePath();
        }
        return new c(str, absolutePath, interfaceC1831b, z);
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f65626a;

        /* renamed from: b  reason: collision with root package name */
        public String f65627b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC1831b> f65628c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.b.b.c f65629d;

        public c(String str, String str2, InterfaceC1831b interfaceC1831b, boolean z) {
            this.f65626a = str;
            this.f65627b = str2;
            b(interfaceC1831b);
        }

        public void a() {
            d.b.c.b.b.c cVar = new d.b.c.b.b.c(this.f65627b, this.f65626a, new a());
            this.f65629d = cVar;
            cVar.setTag("FileLoader#" + this.f65626a);
            b.this.f65622c.a(this.f65629d);
        }

        public void b(InterfaceC1831b interfaceC1831b) {
            if (interfaceC1831b == null) {
                return;
            }
            if (this.f65628c == null) {
                this.f65628c = Collections.synchronizedList(new ArrayList());
            }
            this.f65628c.add(interfaceC1831b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f65626a.equals(this.f65626a);
            }
            return super.equals(obj);
        }

        /* loaded from: classes6.dex */
        public class a implements c.a {
            public a() {
            }

            @Override // d.b.c.b.b.c.a
            public void a(long j, long j2) {
                List<InterfaceC1831b> list = c.this.f65628c;
                if (list != null) {
                    for (InterfaceC1831b interfaceC1831b : list) {
                        try {
                            interfaceC1831b.a(j, j2);
                        } catch (Throwable th) {
                            q.b(th, "file loader onDownloadProgress error", new Object[0]);
                        }
                    }
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<File> oVar) {
                List<InterfaceC1831b> list = c.this.f65628c;
                if (list != null) {
                    for (InterfaceC1831b interfaceC1831b : list) {
                        try {
                            interfaceC1831b.b(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onErrorResponse error", new Object[0]);
                        }
                    }
                    c.this.f65628c.clear();
                }
                b.this.f65620a.remove(c.this.f65626a);
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<File> oVar) {
                List<InterfaceC1831b> list = c.this.f65628c;
                if (list != null) {
                    for (InterfaceC1831b interfaceC1831b : list) {
                        try {
                            interfaceC1831b.a(oVar);
                        } catch (Throwable th) {
                            q.b(th, "file loader onResponse error", new Object[0]);
                        }
                        try {
                            interfaceC1831b.a(c.this.f65626a, oVar.f65766a);
                        } catch (Throwable th2) {
                            q.b(th2, "file loader putFile error", new Object[0]);
                        }
                    }
                    c.this.f65628c.clear();
                }
                b.this.f65620a.remove(c.this.f65626a);
            }
        }
    }
}
