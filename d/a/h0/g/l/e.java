package d.a.h0.g.l;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.l.f f46547a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.g.i.a f46548b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.g.l.i f46549c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f46551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46552g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46553h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46554i;

        /* renamed from: d.a.h0.g.l.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0951a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46555e;

            public RunnableC0951a(d.a.h0.g.l.c cVar) {
                this.f46555e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f46552g), "dirPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46555e, "mkdir:", a.this.f46553h);
                a aVar = a.this;
                if (d.a.h0.g.l.n.a(t, aVar.f46554i, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.b bVar = a.this.f46554i;
                    bVar.errMsg = "mkdir:" + this.f46555e.f46540b;
                    a aVar2 = a.this;
                    d.a.h0.g.l.n.b(aVar2.f46554i, aVar2.f46553h);
                }
            }
        }

        public a(String str, Boolean bool, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46550e = str;
            this.f46551f = bool;
            this.f46552g = i2;
            this.f46553h = map;
            this.f46554i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new RunnableC0951a(e.this.f46547a.o(this.f46550e, this.f46551f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46558f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46559g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46560h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46561i;
        public final /* synthetic */ d.a.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46562e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46562e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f46559g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f46560h), "destPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46562e, "copyFile:", b.this.f46561i);
                b bVar = b.this;
                if (d.a.h0.g.l.n.a(t, bVar.j, hashMap, e.this.f46548b)) {
                    b bVar2 = b.this;
                    d.a.h0.g.l.n.b(bVar2.j, bVar2.f46561i);
                }
            }
        }

        public b(String str, String str2, int i2, int i3, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46557e = str;
            this.f46558f = str2;
            this.f46559g = i2;
            this.f46560h = i3;
            this.f46561i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.c(this.f46557e, this.f46558f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46565f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f46566g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46567h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46568i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.h0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46569e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46569e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46569e, "appendFile:", c.this.f46567h);
                c cVar = c.this;
                if (d.a.h0.g.l.n.a(t, cVar.l, hashMap, e.this.f46548b)) {
                    c cVar2 = c.this;
                    d.a.h0.g.l.n.b(cVar2.l, cVar2.f46567h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.h0.g.l.o.b bVar) {
            this.f46564e = str;
            this.f46565f = str2;
            this.f46566g = bArr;
            this.f46567h = map;
            this.f46568i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.g.l.c b2 = e.this.f46547a.b(this.f46564e, TextUtils.isEmpty(this.f46565f) ? this.f46566g : this.f46565f, d.a.h0.g.l.n.F("encoding", this.f46567h), false);
            if (!TextUtils.isEmpty(this.f46568i)) {
                b2.f46540b = this.f46568i;
                b2.f46539a = -2;
                d.a.h0.g.l.n.d(e.this.f46548b, this.f46568i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    b2.f46540b = "fail encoding must be a string";
                    b2.f46539a = -2;
                    d.a.h0.g.l.n.d(e.this.f46548b, b2.f46540b);
                }
            }
            e.this.f46548b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46572f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46573g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46574h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46576e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46576e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f46572f), "path");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46576e, "access:", d.this.f46573g);
                d dVar = d.this;
                if (d.a.h0.g.l.n.a(t, dVar.f46574h, hashMap, e.this.f46548b)) {
                    d dVar2 = d.this;
                    d.a.h0.g.l.n.b(dVar2.f46574h, dVar2.f46573g);
                }
            }
        }

        public d(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46571e = str;
            this.f46572f = i2;
            this.f46573g = map;
            this.f46574h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.a(this.f46571e, false)));
        }
    }

    /* renamed from: d.a.h0.g.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0952e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46579f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46580g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46581h;

        /* renamed from: d.a.h0.g.l.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46583e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46583e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0952e.this.f46579f), "path");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46583e, "stat:", RunnableC0952e.this.f46580g);
                RunnableC0952e runnableC0952e = RunnableC0952e.this;
                if (d.a.h0.g.l.n.a(t, runnableC0952e.f46581h, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.h hVar = new d.a.h0.g.l.o.h();
                    d.a.h0.g.l.c cVar = this.f46583e;
                    hVar.stats = cVar.f46542d;
                    hVar.errMsg = cVar.f46540b;
                    d.a.h0.g.l.n.b(hVar, RunnableC0952e.this.f46580g);
                }
            }
        }

        public RunnableC0952e(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46578e = str;
            this.f46579f = i2;
            this.f46580g = map;
            this.f46581h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.y(this.f46578e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46586f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46587g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46588h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46590e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46590e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f46586f), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46590e, "getFileInfo:", f.this.f46587g);
                f fVar = f.this;
                if (d.a.h0.g.l.n.a(t, fVar.f46588h, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.c cVar = new d.a.h0.g.l.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f46590e.f46540b;
                    d.a.h0.g.l.c cVar2 = this.f46590e;
                    cVar.digest = cVar2.f46545g;
                    cVar.size = (int) cVar2.f46543e;
                    d.a.h0.g.l.n.b(cVar, f.this.f46587g);
                }
            }
        }

        public f(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46585e = str;
            this.f46586f = i2;
            this.f46587g = map;
            this.f46588h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.e(this.f46585e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f46592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46593f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46595e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46595e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46595e, "getSavedFileList:", g.this.f46592e);
                g gVar = g.this;
                if (d.a.h0.g.l.n.a(t, gVar.f46593f, null, e.this.f46548b)) {
                    d.a.h0.g.l.o.d dVar = new d.a.h0.g.l.o.d();
                    List<d.a.h0.g.l.d> list = this.f46595e.f46544f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.a.h0.g.l.d[0] : (d.a.h0.g.l.d[]) this.f46595e.f46544f.toArray(new d.a.h0.g.l.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f46593f.errMsg;
                    d.a.h0.g.l.n.b(dVar, gVar2.f46592e);
                }
            }
        }

        public g(Map map, d.a.h0.g.l.o.b bVar) {
            this.f46592e = map;
            this.f46593f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46598f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46599g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46600h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46602e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46602e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f46598f), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46602e, "removeSavedFile:", h.this.f46599g);
                h hVar = h.this;
                if (d.a.h0.g.l.n.a(t, hVar.f46600h, hashMap, e.this.f46548b)) {
                    h hVar2 = h.this;
                    d.a.h0.g.l.n.b(hVar2.f46600h, hVar2.f46599g);
                }
            }
        }

        public h(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46597e = str;
            this.f46598f = i2;
            this.f46599g = map;
            this.f46600h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.t(this.f46597e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46605f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f46606g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46607h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46608i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.h0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46609e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46609e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46609e, "writeFile:", i.this.f46607h);
                i iVar = i.this;
                if (d.a.h0.g.l.n.a(t, iVar.l, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f46609e.f46540b;
                    i iVar2 = i.this;
                    d.a.h0.g.l.n.b(iVar2.l, iVar2.f46607h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.h0.g.l.o.b bVar) {
            this.f46604e = str;
            this.f46605f = str2;
            this.f46606g = bArr;
            this.f46607h = map;
            this.f46608i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.g.l.c C = e.this.f46547a.C(false, this.f46604e, TextUtils.isEmpty(this.f46605f) ? this.f46606g : this.f46605f, d.a.h0.g.l.n.F("encoding", this.f46607h));
            if (!TextUtils.isEmpty(this.f46608i)) {
                C.f46540b = this.f46608i;
                C.f46539a = -2;
                d.a.h0.g.l.n.d(e.this.f46548b, this.f46608i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    C.f46540b = "fail encoding must be a string";
                    C.f46539a = -2;
                    d.a.h0.g.l.n.d(e.this.f46548b, C.f46540b);
                }
            }
            e.this.f46548b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46613g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46614h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46616e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46616e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f46612f), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46616e, "unlink:", j.this.f46613g);
                j jVar = j.this;
                if (d.a.h0.g.l.n.a(t, jVar.f46614h, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.b bVar = j.this.f46614h;
                    bVar.errMsg = "unlink:" + this.f46616e.f46540b;
                    j jVar2 = j.this;
                    d.a.h0.g.l.n.b(jVar2.f46614h, jVar2.f46613g);
                }
            }
        }

        public j(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46611e = str;
            this.f46612f = i2;
            this.f46613g = map;
            this.f46614h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.z(this.f46611e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46618e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46619f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46620g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46621h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46622i;
        public final /* synthetic */ d.a.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46623e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46623e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f46620g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f46621h), "targetPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46623e, "unzip:", k.this.f46622i);
                k kVar = k.this;
                if (d.a.h0.g.l.n.a(t, kVar.j, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f46623e.f46540b;
                    k kVar2 = k.this;
                    d.a.h0.g.l.n.b(kVar2.j, kVar2.f46622i);
                }
            }
        }

        public k(String str, String str2, int i2, int i3, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46618e = str;
            this.f46619f = str2;
            this.f46620g = i2;
            this.f46621h = i3;
            this.f46622i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.A(this.f46618e, this.f46619f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46626f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46627g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46628h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46629i;
        public final /* synthetic */ d.a.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46630e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46630e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f46627g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f46628h), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46630e, "saveFile:", l.this.f46629i);
                l lVar = l.this;
                if (d.a.h0.g.l.n.a(t, lVar.j, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.g gVar = new d.a.h0.g.l.o.g();
                    List<String> list = this.f46630e.f46541c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f46630e.f46540b;
                    d.a.h0.g.l.n.b(gVar, l.this.f46629i);
                }
            }
        }

        public l(String str, String str2, int i2, int i3, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46625e = str;
            this.f46626f = str2;
            this.f46627g = i2;
            this.f46628h = i3;
            this.f46629i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.x(this.f46625e, this.f46626f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46634g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46635h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46637e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46637e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f46633f), "dirPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46637e, "readdir:", m.this.f46634g);
                m mVar = m.this;
                if (d.a.h0.g.l.n.a(t, mVar.f46635h, hashMap, e.this.f46548b)) {
                    d.a.h0.g.l.o.e eVar = new d.a.h0.g.l.o.e();
                    List<String> list = this.f46637e.f46541c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f46637e.f46541c.toArray(new String[size]);
                    eVar.errMsg = this.f46637e.f46540b;
                    d.a.h0.g.l.n.b(eVar, m.this.f46634g);
                }
            }
        }

        public m(String str, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46632e = str;
            this.f46633f = i2;
            this.f46634g = map;
            this.f46635h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.s(this.f46632e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f46640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46641g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46642h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.l.o.b f46643i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46644e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46644e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f46641g), "dirPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46644e, "rmdir:", n.this.f46642h);
                n nVar = n.this;
                if (d.a.h0.g.l.n.a(t, nVar.f46643i, hashMap, e.this.f46548b)) {
                    n nVar2 = n.this;
                    d.a.h0.g.l.n.b(nVar2.f46643i, nVar2.f46642h);
                }
            }
        }

        public n(String str, Boolean bool, int i2, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46639e = str;
            this.f46640f = bool;
            this.f46641g = i2;
            this.f46642h = map;
            this.f46643i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.v(this.f46639e, this.f46640f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46648g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46649h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46650i;
        public final /* synthetic */ d.a.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46651e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46651e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f46649h), "filePath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46651e, "readFile:", o.this.f46650i);
                o oVar = o.this;
                if (d.a.h0.g.l.n.a(t, oVar.j, hashMap, e.this.f46548b)) {
                    if (TextUtils.isEmpty(o.this.f46647f)) {
                        d.a.h0.g.l.o.a aVar = new d.a.h0.g.l.o.a();
                        d.a.h0.g.l.c cVar = this.f46651e;
                        if (cVar.f46546h == null) {
                            cVar.f46546h = new byte[0];
                        }
                        byte[] bArr = this.f46651e.f46546h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f46651e.f46540b;
                        d.a.h0.g.l.n.b(aVar, o.this.f46650i);
                        return;
                    }
                    List<String> list = this.f46651e.f46541c;
                    String str = list != null ? list.get(0) : null;
                    d.a.h0.g.l.o.f fVar = new d.a.h0.g.l.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f46651e.f46540b;
                    d.a.h0.g.l.n.b(fVar, o.this.f46650i);
                }
            }
        }

        public o(String str, String str2, int i2, int i3, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46646e = str;
            this.f46647f = str2;
            this.f46648g = i2;
            this.f46649h = i3;
            this.f46650i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.g.l.c q = e.this.f46547a.q(this.f46646e, this.f46647f, false);
            int i2 = this.f46648g;
            if (i2 != 7 && i2 != 12) {
                q.f46540b = "fail encoding must be a string";
                q.f46539a = -2;
                d.a.h0.g.l.n.d(e.this.f46548b, q.f46540b);
            }
            e.this.f46548b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46654f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46655g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46656h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46657i;
        public final /* synthetic */ d.a.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.l.c f46658e;

            public a(d.a.h0.g.l.c cVar) {
                this.f46658e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f46655g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f46656h), "newPath");
                d.a.h0.g.l.b t = d.a.h0.g.l.n.t(this.f46658e, "rename:", p.this.f46657i);
                p pVar = p.this;
                if (d.a.h0.g.l.n.a(t, pVar.j, hashMap, e.this.f46548b)) {
                    p pVar2 = p.this;
                    d.a.h0.g.l.n.b(pVar2.j, pVar2.f46657i);
                }
            }
        }

        public p(String str, String str2, int i2, int i3, Map map, d.a.h0.g.l.o.b bVar) {
            this.f46653e = str;
            this.f46654f = str2;
            this.f46655g = i2;
            this.f46656h = i3;
            this.f46657i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46548b.runOnJSThread(new a(e.this.f46547a.u(this.f46653e, this.f46654f, false)));
        }
    }

    public e(d.a.h0.g.i.a aVar) {
        this.f46548b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("path", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("path", G);
            this.f46549c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("encoding", jsObject);
            int L2 = d.a.h0.g.l.n.L("filePath", jsObject);
            int L3 = d.a.h0.g.l.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.h0.g.l.n.u(L3);
            byte[] p2 = d.a.h0.g.l.n.p(jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("data", G);
            String F2 = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.h0.a.a2.f.c lVar;
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O != null) {
            lVar = O.U();
        } else {
            lVar = new d.a.h0.g.l.l();
        }
        this.f46547a = new d.a.h0.g.l.f(AppRuntime.getAppContext(), d.a.h0.a.z0.f.V().A(), lVar);
        this.f46549c = d.a.h0.g.l.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("srcPath", jsObject);
            int L2 = d.a.h0.g.l.n.L("destPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("srcPath", G);
            String F2 = d.a.h0.g.l.n.F("destPath", G);
            this.f46549c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str, str2);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("filePath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.h0.g.l.o.b bVar;
        Map<String, Object> G;
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.h0.g.l.n.G(this.f46547a, jsObject, (bVar = new d.a.h0.g.l.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f46549c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("dirPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("dirPath", G);
            this.f46549c.h(new a(F, (Boolean) d.a.h0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("filePath", jsObject);
            int L2 = d.a.h0.g.l.n.L("encoding", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("encoding", G);
            String F2 = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.c q = this.f46547a.q(str, str2, true);
            d.a.h0.g.l.n.Z(this.f46548b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f46539a != 0 || (list = q.f46541c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("dirPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("dirPath", G);
            this.f46549c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.c s = this.f46547a.s(str, true);
            d.a.h0.g.l.n.Z(this.f46548b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f46539a != 0) {
                return new String[0];
            }
            List<String> list = s.f46541c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f46541c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("filePath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f46549c.h(new h(d.a.h0.g.l.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("oldPath", jsObject);
            int L2 = d.a.h0.g.l.n.L("newPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("oldPath", G);
            String F2 = d.a.h0.g.l.n.F("newPath", G);
            this.f46549c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str, str2);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("dirPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("dirPath", G);
            this.f46549c.h(new n(F, (Boolean) d.a.h0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("tempFilePath", jsObject);
            int L2 = d.a.h0.g.l.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("tempFilePath", G);
            String F2 = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.a.h0.g.l.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("path", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("path", G);
            this.f46549c.h(new RunnableC0952e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.h0.g.l.j statSync(String str) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.c y = this.f46547a.y(str, true);
            d.a.h0.g.l.n.Z(this.f46548b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f46539a != 0) {
                return null;
            }
            return y.f46542d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("filePath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("zipFilePath", jsObject);
            int L2 = d.a.h0.g.l.n.L("targetPath", jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("zipFilePath", G);
            String F2 = d.a.h0.g.l.n.F("targetPath", G);
            this.f46549c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.h0.g.l.n.L("filePath", jsObject);
            String u = d.a.h0.g.l.n.u(d.a.h0.g.l.n.L("data", jsObject));
            int L2 = d.a.h0.g.l.n.L("encoding", jsObject);
            byte[] p2 = d.a.h0.g.l.n.p(jsObject);
            d.a.h0.g.l.o.b bVar = new d.a.h0.g.l.o.b();
            Map<String, Object> G = d.a.h0.g.l.n.G(this.f46547a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.h0.g.l.n.F("data", G);
            String F2 = d.a.h0.g.l.n.F("filePath", G);
            this.f46549c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str, str2);
            d.a.h0.g.l.c x = this.f46547a.x(str, str2, true);
            d.a.h0.g.l.n.Z(this.f46548b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f46539a != 0 || (list = x.f46541c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        appendFileSync(str, str2, (String) null);
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.n.Z(this.f46548b, this.f46547a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.a.h0.g.l.n.P(this.f46547a, this.f46548b, null, null)) {
            this.f46549c.k(str);
            d.a.h0.g.l.c q = this.f46547a.q(str, null, true);
            d.a.h0.g.l.n.Z(this.f46548b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f46546h == null) {
                q.f46546h = new byte[0];
            }
            byte[] bArr = q.f46546h;
            return new JsArrayBuffer(bArr, bArr.length);
        }
        return null;
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        appendFileSync(str, jsArrayBuffer, (String) null);
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }
}
