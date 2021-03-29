package d.b.g0.g.l;

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
    public d.b.g0.g.l.f f48349a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.i.a f48350b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.l.i f48351c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48353f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48354g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48355h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* renamed from: d.b.g0.g.l.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0980a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48356e;

            public RunnableC0980a(d.b.g0.g.l.c cVar) {
                this.f48356e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f48354g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48356e, "mkdir:", a.this.f48355h);
                a aVar = a.this;
                if (d.b.g0.g.l.n.a(t, aVar.i, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.b bVar = a.this.i;
                    bVar.errMsg = "mkdir:" + this.f48356e.f48342b;
                    a aVar2 = a.this;
                    d.b.g0.g.l.n.b(aVar2.i, aVar2.f48355h);
                }
            }
        }

        public a(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48352e = str;
            this.f48353f = bool;
            this.f48354g = i;
            this.f48355h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new RunnableC0980a(e.this.f48349a.o(this.f48352e, this.f48353f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48359f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48360g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48361h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48362e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48362e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f48360g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f48361h), "destPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48362e, "copyFile:", b.this.i);
                b bVar = b.this;
                if (d.b.g0.g.l.n.a(t, bVar.j, hashMap, e.this.f48350b)) {
                    b bVar2 = b.this;
                    d.b.g0.g.l.n.b(bVar2.j, bVar2.i);
                }
            }
        }

        public b(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48358e = str;
            this.f48359f = str2;
            this.f48360g = i;
            this.f48361h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.c(this.f48358e, this.f48359f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48365f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48366g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48367h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48368e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48368e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48368e, "appendFile:", c.this.f48367h);
                c cVar = c.this;
                if (d.b.g0.g.l.n.a(t, cVar.l, hashMap, e.this.f48350b)) {
                    c cVar2 = c.this;
                    d.b.g0.g.l.n.b(cVar2.l, cVar2.f48367h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48364e = str;
            this.f48365f = str2;
            this.f48366g = bArr;
            this.f48367h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c b2 = e.this.f48349a.b(this.f48364e, TextUtils.isEmpty(this.f48365f) ? this.f48366g : this.f48365f, d.b.g0.g.l.n.F("encoding", this.f48367h), false);
            if (!TextUtils.isEmpty(this.i)) {
                b2.f48342b = this.i;
                b2.f48341a = -2;
                d.b.g0.g.l.n.d(e.this.f48350b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    b2.f48342b = "fail encoding must be a string";
                    b2.f48341a = -2;
                    d.b.g0.g.l.n.d(e.this.f48350b, b2.f48342b);
                }
            }
            e.this.f48350b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48372g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48373h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48374e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48374e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f48371f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48374e, "access:", d.this.f48372g);
                d dVar = d.this;
                if (d.b.g0.g.l.n.a(t, dVar.f48373h, hashMap, e.this.f48350b)) {
                    d dVar2 = d.this;
                    d.b.g0.g.l.n.b(dVar2.f48373h, dVar2.f48372g);
                }
            }
        }

        public d(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48370e = str;
            this.f48371f = i;
            this.f48372g = map;
            this.f48373h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.a(this.f48370e, false)));
        }
    }

    /* renamed from: d.b.g0.g.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0981e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48377f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48378g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48379h;

        /* renamed from: d.b.g0.g.l.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48380e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48380e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0981e.this.f48377f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48380e, "stat:", RunnableC0981e.this.f48378g);
                RunnableC0981e runnableC0981e = RunnableC0981e.this;
                if (d.b.g0.g.l.n.a(t, runnableC0981e.f48379h, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.h hVar = new d.b.g0.g.l.o.h();
                    d.b.g0.g.l.c cVar = this.f48380e;
                    hVar.stats = cVar.f48344d;
                    hVar.errMsg = cVar.f48342b;
                    d.b.g0.g.l.n.b(hVar, RunnableC0981e.this.f48378g);
                }
            }
        }

        public RunnableC0981e(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48376e = str;
            this.f48377f = i;
            this.f48378g = map;
            this.f48379h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.y(this.f48376e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48384g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48385h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48386e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48386e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f48383f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48386e, "getFileInfo:", f.this.f48384g);
                f fVar = f.this;
                if (d.b.g0.g.l.n.a(t, fVar.f48385h, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.c cVar = new d.b.g0.g.l.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f48386e.f48342b;
                    d.b.g0.g.l.c cVar2 = this.f48386e;
                    cVar.digest = cVar2.f48347g;
                    cVar.size = (int) cVar2.f48345e;
                    d.b.g0.g.l.n.b(cVar, f.this.f48384g);
                }
            }
        }

        public f(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48382e = str;
            this.f48383f = i;
            this.f48384g = map;
            this.f48385h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.e(this.f48382e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f48388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48389f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48391e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48391e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48391e, "getSavedFileList:", g.this.f48388e);
                g gVar = g.this;
                if (d.b.g0.g.l.n.a(t, gVar.f48389f, null, e.this.f48350b)) {
                    d.b.g0.g.l.o.d dVar = new d.b.g0.g.l.o.d();
                    List<d.b.g0.g.l.d> list = this.f48391e.f48346f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.b.g0.g.l.d[0] : (d.b.g0.g.l.d[]) this.f48391e.f48346f.toArray(new d.b.g0.g.l.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f48389f.errMsg;
                    d.b.g0.g.l.n.b(dVar, gVar2.f48388e);
                }
            }
        }

        public g(Map map, d.b.g0.g.l.o.b bVar) {
            this.f48388e = map;
            this.f48389f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48396h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48397e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48397e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f48394f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48397e, "removeSavedFile:", h.this.f48395g);
                h hVar = h.this;
                if (d.b.g0.g.l.n.a(t, hVar.f48396h, hashMap, e.this.f48350b)) {
                    h hVar2 = h.this;
                    d.b.g0.g.l.n.b(hVar2.f48396h, hVar2.f48395g);
                }
            }
        }

        public h(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48393e = str;
            this.f48394f = i;
            this.f48395g = map;
            this.f48396h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.t(this.f48393e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48400f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48401g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48402h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48403e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48403e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48403e, "writeFile:", i.this.f48402h);
                i iVar = i.this;
                if (d.b.g0.g.l.n.a(t, iVar.l, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f48403e.f48342b;
                    i iVar2 = i.this;
                    d.b.g0.g.l.n.b(iVar2.l, iVar2.f48402h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48399e = str;
            this.f48400f = str2;
            this.f48401g = bArr;
            this.f48402h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c C = e.this.f48349a.C(false, this.f48399e, TextUtils.isEmpty(this.f48400f) ? this.f48401g : this.f48400f, d.b.g0.g.l.n.F("encoding", this.f48402h));
            if (!TextUtils.isEmpty(this.i)) {
                C.f48342b = this.i;
                C.f48341a = -2;
                d.b.g0.g.l.n.d(e.this.f48350b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    C.f48342b = "fail encoding must be a string";
                    C.f48341a = -2;
                    d.b.g0.g.l.n.d(e.this.f48350b, C.f48342b);
                }
            }
            e.this.f48350b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48406f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48407g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48408h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48409e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48409e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f48406f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48409e, "unlink:", j.this.f48407g);
                j jVar = j.this;
                if (d.b.g0.g.l.n.a(t, jVar.f48408h, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.b bVar = j.this.f48408h;
                    bVar.errMsg = "unlink:" + this.f48409e.f48342b;
                    j jVar2 = j.this;
                    d.b.g0.g.l.n.b(jVar2.f48408h, jVar2.f48407g);
                }
            }
        }

        public j(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48405e = str;
            this.f48406f = i;
            this.f48407g = map;
            this.f48408h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.z(this.f48405e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48413g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48414h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48415e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48415e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f48413g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f48414h), "targetPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48415e, "unzip:", k.this.i);
                k kVar = k.this;
                if (d.b.g0.g.l.n.a(t, kVar.j, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f48415e.f48342b;
                    k kVar2 = k.this;
                    d.b.g0.g.l.n.b(kVar2.j, kVar2.i);
                }
            }
        }

        public k(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48411e = str;
            this.f48412f = str2;
            this.f48413g = i;
            this.f48414h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.A(this.f48411e, this.f48412f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48418f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48419g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48420h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48421e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48421e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f48419g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f48420h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48421e, "saveFile:", l.this.i);
                l lVar = l.this;
                if (d.b.g0.g.l.n.a(t, lVar.j, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.g gVar = new d.b.g0.g.l.o.g();
                    List<String> list = this.f48421e.f48343c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f48421e.f48342b;
                    d.b.g0.g.l.n.b(gVar, l.this.i);
                }
            }
        }

        public l(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48417e = str;
            this.f48418f = str2;
            this.f48419g = i;
            this.f48420h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.x(this.f48417e, this.f48418f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48426h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48427e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48427e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f48424f), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48427e, "readdir:", m.this.f48425g);
                m mVar = m.this;
                if (d.b.g0.g.l.n.a(t, mVar.f48426h, hashMap, e.this.f48350b)) {
                    d.b.g0.g.l.o.e eVar = new d.b.g0.g.l.o.e();
                    List<String> list = this.f48427e.f48343c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f48427e.f48343c.toArray(new String[size]);
                    eVar.errMsg = this.f48427e.f48342b;
                    d.b.g0.g.l.n.b(eVar, m.this.f48425g);
                }
            }
        }

        public m(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48423e = str;
            this.f48424f = i;
            this.f48425g = map;
            this.f48426h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.s(this.f48423e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48432h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48433e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48433e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f48431g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48433e, "rmdir:", n.this.f48432h);
                n nVar = n.this;
                if (d.b.g0.g.l.n.a(t, nVar.i, hashMap, e.this.f48350b)) {
                    n nVar2 = n.this;
                    d.b.g0.g.l.n.b(nVar2.i, nVar2.f48432h);
                }
            }
        }

        public n(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48429e = str;
            this.f48430f = bool;
            this.f48431g = i;
            this.f48432h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.v(this.f48429e, this.f48430f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48438h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48439e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48439e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f48438h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48439e, "readFile:", o.this.i);
                o oVar = o.this;
                if (d.b.g0.g.l.n.a(t, oVar.j, hashMap, e.this.f48350b)) {
                    if (TextUtils.isEmpty(o.this.f48436f)) {
                        d.b.g0.g.l.o.a aVar = new d.b.g0.g.l.o.a();
                        d.b.g0.g.l.c cVar = this.f48439e;
                        if (cVar.f48348h == null) {
                            cVar.f48348h = new byte[0];
                        }
                        byte[] bArr = this.f48439e.f48348h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f48439e.f48342b;
                        d.b.g0.g.l.n.b(aVar, o.this.i);
                        return;
                    }
                    List<String> list = this.f48439e.f48343c;
                    String str = list != null ? list.get(0) : null;
                    d.b.g0.g.l.o.f fVar = new d.b.g0.g.l.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f48439e.f48342b;
                    d.b.g0.g.l.n.b(fVar, o.this.i);
                }
            }
        }

        public o(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48435e = str;
            this.f48436f = str2;
            this.f48437g = i;
            this.f48438h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c q = e.this.f48349a.q(this.f48435e, this.f48436f, false);
            int i = this.f48437g;
            if (i != 7 && i != 12) {
                q.f48342b = "fail encoding must be a string";
                q.f48341a = -2;
                d.b.g0.g.l.n.d(e.this.f48350b, q.f48342b);
            }
            e.this.f48350b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48443g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48444h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48445e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48445e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f48443g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f48444h), "newPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48445e, "rename:", p.this.i);
                p pVar = p.this;
                if (d.b.g0.g.l.n.a(t, pVar.j, hashMap, e.this.f48350b)) {
                    p pVar2 = p.this;
                    d.b.g0.g.l.n.b(pVar2.j, pVar2.i);
                }
            }
        }

        public p(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48441e = str;
            this.f48442f = str2;
            this.f48443g = i;
            this.f48444h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48350b.runOnJSThread(new a(e.this.f48349a.u(this.f48441e, this.f48442f, false)));
        }
    }

    public e(d.b.g0.g.i.a aVar) {
        this.f48350b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48351c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("encoding", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int L3 = d.b.g0.g.l.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.b.g0.g.l.n.u(L3);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.b.g0.a.a2.f.c lVar;
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null) {
            lVar = O.U();
        } else {
            lVar = new d.b.g0.g.l.l();
        }
        this.f48349a = new d.b.g0.g.l.f(AppRuntime.getAppContext(), d.b.g0.a.z0.f.V().h(), lVar);
        this.f48351c = d.b.g0.g.l.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("srcPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("destPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("srcPath", G);
            String F2 = d.b.g0.g.l.n.F("destPath", G);
            this.f48351c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.b.g0.g.l.o.b bVar;
        Map<String, Object> G;
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.b.g0.g.l.n.G(this.f48349a, jsObject, (bVar = new d.b.g0.g.l.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f48351c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48351c.h(new a(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("encoding", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.c q = this.f48349a.q(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48350b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f48341a != 0 || (list = q.f48343c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48351c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.c s = this.f48349a.s(str, true);
            d.b.g0.g.l.n.Z(this.f48350b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f48341a != 0) {
                return new String[0];
            }
            List<String> list = s.f48343c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f48343c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f48351c.h(new h(d.b.g0.g.l.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("oldPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("newPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("oldPath", G);
            String F2 = d.b.g0.g.l.n.F("newPath", G);
            this.f48351c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48351c.h(new n(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("tempFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("tempFilePath", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.b.g0.g.l.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48351c.h(new RunnableC0981e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.b.g0.g.l.j statSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.c y = this.f48349a.y(str, true);
            d.b.g0.g.l.n.Z(this.f48350b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f48341a != 0) {
                return null;
            }
            return y.f48344d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("zipFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("targetPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("zipFilePath", G);
            String F2 = d.b.g0.g.l.n.F("targetPath", G);
            this.f48351c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            String u = d.b.g0.g.l.n.u(d.b.g0.g.l.n.L("data", jsObject));
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48349a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48351c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str, str2);
            d.b.g0.g.l.c x = this.f48349a.x(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48350b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f48341a != 0 || (list = x.f48343c) == null) {
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
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.n.Z(this.f48350b, this.f48349a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48349a, this.f48350b, null, null)) {
            this.f48351c.k(str);
            d.b.g0.g.l.c q = this.f48349a.q(str, null, true);
            d.b.g0.g.l.n.Z(this.f48350b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f48348h == null) {
                q.f48348h = new byte[0];
            }
            byte[] bArr = q.f48348h;
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
