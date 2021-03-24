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
    public d.b.g0.g.l.f f48348a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.i.a f48349b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.l.i f48350c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48351e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48352f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48353g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48354h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* renamed from: d.b.g0.g.l.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0979a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48355e;

            public RunnableC0979a(d.b.g0.g.l.c cVar) {
                this.f48355e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f48353g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48355e, "mkdir:", a.this.f48354h);
                a aVar = a.this;
                if (d.b.g0.g.l.n.a(t, aVar.i, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.b bVar = a.this.i;
                    bVar.errMsg = "mkdir:" + this.f48355e.f48341b;
                    a aVar2 = a.this;
                    d.b.g0.g.l.n.b(aVar2.i, aVar2.f48354h);
                }
            }
        }

        public a(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48351e = str;
            this.f48352f = bool;
            this.f48353g = i;
            this.f48354h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new RunnableC0979a(e.this.f48348a.o(this.f48351e, this.f48352f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48359g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48360h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48361e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48361e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f48359g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f48360h), "destPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48361e, "copyFile:", b.this.i);
                b bVar = b.this;
                if (d.b.g0.g.l.n.a(t, bVar.j, hashMap, e.this.f48349b)) {
                    b bVar2 = b.this;
                    d.b.g0.g.l.n.b(bVar2.j, bVar2.i);
                }
            }
        }

        public b(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48357e = str;
            this.f48358f = str2;
            this.f48359g = i;
            this.f48360h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.c(this.f48357e, this.f48358f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48364f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48365g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48366h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48367e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48367e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48367e, "appendFile:", c.this.f48366h);
                c cVar = c.this;
                if (d.b.g0.g.l.n.a(t, cVar.l, hashMap, e.this.f48349b)) {
                    c cVar2 = c.this;
                    d.b.g0.g.l.n.b(cVar2.l, cVar2.f48366h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48363e = str;
            this.f48364f = str2;
            this.f48365g = bArr;
            this.f48366h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c b2 = e.this.f48348a.b(this.f48363e, TextUtils.isEmpty(this.f48364f) ? this.f48365g : this.f48364f, d.b.g0.g.l.n.F("encoding", this.f48366h), false);
            if (!TextUtils.isEmpty(this.i)) {
                b2.f48341b = this.i;
                b2.f48340a = -2;
                d.b.g0.g.l.n.d(e.this.f48349b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    b2.f48341b = "fail encoding must be a string";
                    b2.f48340a = -2;
                    d.b.g0.g.l.n.d(e.this.f48349b, b2.f48341b);
                }
            }
            e.this.f48349b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48369e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48370f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48371g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48372h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48373e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48373e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f48370f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48373e, "access:", d.this.f48371g);
                d dVar = d.this;
                if (d.b.g0.g.l.n.a(t, dVar.f48372h, hashMap, e.this.f48349b)) {
                    d dVar2 = d.this;
                    d.b.g0.g.l.n.b(dVar2.f48372h, dVar2.f48371g);
                }
            }
        }

        public d(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48369e = str;
            this.f48370f = i;
            this.f48371g = map;
            this.f48372h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.a(this.f48369e, false)));
        }
    }

    /* renamed from: d.b.g0.g.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0980e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48378h;

        /* renamed from: d.b.g0.g.l.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48379e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48379e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0980e.this.f48376f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48379e, "stat:", RunnableC0980e.this.f48377g);
                RunnableC0980e runnableC0980e = RunnableC0980e.this;
                if (d.b.g0.g.l.n.a(t, runnableC0980e.f48378h, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.h hVar = new d.b.g0.g.l.o.h();
                    d.b.g0.g.l.c cVar = this.f48379e;
                    hVar.stats = cVar.f48343d;
                    hVar.errMsg = cVar.f48341b;
                    d.b.g0.g.l.n.b(hVar, RunnableC0980e.this.f48377g);
                }
            }
        }

        public RunnableC0980e(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48375e = str;
            this.f48376f = i;
            this.f48377g = map;
            this.f48378h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.y(this.f48375e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48382f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48383g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48384h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48385e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48385e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f48382f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48385e, "getFileInfo:", f.this.f48383g);
                f fVar = f.this;
                if (d.b.g0.g.l.n.a(t, fVar.f48384h, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.c cVar = new d.b.g0.g.l.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f48385e.f48341b;
                    d.b.g0.g.l.c cVar2 = this.f48385e;
                    cVar.digest = cVar2.f48346g;
                    cVar.size = (int) cVar2.f48344e;
                    d.b.g0.g.l.n.b(cVar, f.this.f48383g);
                }
            }
        }

        public f(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48381e = str;
            this.f48382f = i;
            this.f48383g = map;
            this.f48384h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.e(this.f48381e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f48387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48388f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48390e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48390e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48390e, "getSavedFileList:", g.this.f48387e);
                g gVar = g.this;
                if (d.b.g0.g.l.n.a(t, gVar.f48388f, null, e.this.f48349b)) {
                    d.b.g0.g.l.o.d dVar = new d.b.g0.g.l.o.d();
                    List<d.b.g0.g.l.d> list = this.f48390e.f48345f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.b.g0.g.l.d[0] : (d.b.g0.g.l.d[]) this.f48390e.f48345f.toArray(new d.b.g0.g.l.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f48388f.errMsg;
                    d.b.g0.g.l.n.b(dVar, gVar2.f48387e);
                }
            }
        }

        public g(Map map, d.b.g0.g.l.o.b bVar) {
            this.f48387e = map;
            this.f48388f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48393f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48394g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48395h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48396e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48396e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f48393f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48396e, "removeSavedFile:", h.this.f48394g);
                h hVar = h.this;
                if (d.b.g0.g.l.n.a(t, hVar.f48395h, hashMap, e.this.f48349b)) {
                    h hVar2 = h.this;
                    d.b.g0.g.l.n.b(hVar2.f48395h, hVar2.f48394g);
                }
            }
        }

        public h(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48392e = str;
            this.f48393f = i;
            this.f48394g = map;
            this.f48395h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.t(this.f48392e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48399f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48400g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48401h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48402e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48402e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48402e, "writeFile:", i.this.f48401h);
                i iVar = i.this;
                if (d.b.g0.g.l.n.a(t, iVar.l, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f48402e.f48341b;
                    i iVar2 = i.this;
                    d.b.g0.g.l.n.b(iVar2.l, iVar2.f48401h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48398e = str;
            this.f48399f = str2;
            this.f48400g = bArr;
            this.f48401h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c C = e.this.f48348a.C(false, this.f48398e, TextUtils.isEmpty(this.f48399f) ? this.f48400g : this.f48399f, d.b.g0.g.l.n.F("encoding", this.f48401h));
            if (!TextUtils.isEmpty(this.i)) {
                C.f48341b = this.i;
                C.f48340a = -2;
                d.b.g0.g.l.n.d(e.this.f48349b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    C.f48341b = "fail encoding must be a string";
                    C.f48340a = -2;
                    d.b.g0.g.l.n.d(e.this.f48349b, C.f48341b);
                }
            }
            e.this.f48349b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48405f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48406g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48407h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48408e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48408e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f48405f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48408e, "unlink:", j.this.f48406g);
                j jVar = j.this;
                if (d.b.g0.g.l.n.a(t, jVar.f48407h, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.b bVar = j.this.f48407h;
                    bVar.errMsg = "unlink:" + this.f48408e.f48341b;
                    j jVar2 = j.this;
                    d.b.g0.g.l.n.b(jVar2.f48407h, jVar2.f48406g);
                }
            }
        }

        public j(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48404e = str;
            this.f48405f = i;
            this.f48406g = map;
            this.f48407h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.z(this.f48404e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48412g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48413h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48414e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48414e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f48412g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f48413h), "targetPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48414e, "unzip:", k.this.i);
                k kVar = k.this;
                if (d.b.g0.g.l.n.a(t, kVar.j, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f48414e.f48341b;
                    k kVar2 = k.this;
                    d.b.g0.g.l.n.b(kVar2.j, kVar2.i);
                }
            }
        }

        public k(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48410e = str;
            this.f48411f = str2;
            this.f48412g = i;
            this.f48413h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.A(this.f48410e, this.f48411f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48418g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48419h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48420e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48420e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f48418g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f48419h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48420e, "saveFile:", l.this.i);
                l lVar = l.this;
                if (d.b.g0.g.l.n.a(t, lVar.j, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.g gVar = new d.b.g0.g.l.o.g();
                    List<String> list = this.f48420e.f48342c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f48420e.f48341b;
                    d.b.g0.g.l.n.b(gVar, l.this.i);
                }
            }
        }

        public l(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48416e = str;
            this.f48417f = str2;
            this.f48418g = i;
            this.f48419h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.x(this.f48416e, this.f48417f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48424g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48425h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48426e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48426e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f48423f), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48426e, "readdir:", m.this.f48424g);
                m mVar = m.this;
                if (d.b.g0.g.l.n.a(t, mVar.f48425h, hashMap, e.this.f48349b)) {
                    d.b.g0.g.l.o.e eVar = new d.b.g0.g.l.o.e();
                    List<String> list = this.f48426e.f48342c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f48426e.f48342c.toArray(new String[size]);
                    eVar.errMsg = this.f48426e.f48341b;
                    d.b.g0.g.l.n.b(eVar, m.this.f48424g);
                }
            }
        }

        public m(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48422e = str;
            this.f48423f = i;
            this.f48424g = map;
            this.f48425h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.s(this.f48422e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48429f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48430g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48431h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48432e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48432e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f48430g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48432e, "rmdir:", n.this.f48431h);
                n nVar = n.this;
                if (d.b.g0.g.l.n.a(t, nVar.i, hashMap, e.this.f48349b)) {
                    n nVar2 = n.this;
                    d.b.g0.g.l.n.b(nVar2.i, nVar2.f48431h);
                }
            }
        }

        public n(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48428e = str;
            this.f48429f = bool;
            this.f48430g = i;
            this.f48431h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.v(this.f48428e, this.f48429f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48436g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48437h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48438e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48438e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f48437h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48438e, "readFile:", o.this.i);
                o oVar = o.this;
                if (d.b.g0.g.l.n.a(t, oVar.j, hashMap, e.this.f48349b)) {
                    if (TextUtils.isEmpty(o.this.f48435f)) {
                        d.b.g0.g.l.o.a aVar = new d.b.g0.g.l.o.a();
                        d.b.g0.g.l.c cVar = this.f48438e;
                        if (cVar.f48347h == null) {
                            cVar.f48347h = new byte[0];
                        }
                        byte[] bArr = this.f48438e.f48347h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f48438e.f48341b;
                        d.b.g0.g.l.n.b(aVar, o.this.i);
                        return;
                    }
                    List<String> list = this.f48438e.f48342c;
                    String str = list != null ? list.get(0) : null;
                    d.b.g0.g.l.o.f fVar = new d.b.g0.g.l.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f48438e.f48341b;
                    d.b.g0.g.l.n.b(fVar, o.this.i);
                }
            }
        }

        public o(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48434e = str;
            this.f48435f = str2;
            this.f48436g = i;
            this.f48437h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c q = e.this.f48348a.q(this.f48434e, this.f48435f, false);
            int i = this.f48436g;
            if (i != 7 && i != 12) {
                q.f48341b = "fail encoding must be a string";
                q.f48340a = -2;
                d.b.g0.g.l.n.d(e.this.f48349b, q.f48341b);
            }
            e.this.f48349b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48441f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48442g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48443h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48444e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48444e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f48442g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f48443h), "newPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48444e, "rename:", p.this.i);
                p pVar = p.this;
                if (d.b.g0.g.l.n.a(t, pVar.j, hashMap, e.this.f48349b)) {
                    p pVar2 = p.this;
                    d.b.g0.g.l.n.b(pVar2.j, pVar2.i);
                }
            }
        }

        public p(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48440e = str;
            this.f48441f = str2;
            this.f48442g = i;
            this.f48443h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48349b.runOnJSThread(new a(e.this.f48348a.u(this.f48440e, this.f48441f, false)));
        }
    }

    public e(d.b.g0.g.i.a aVar) {
        this.f48349b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48350c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("encoding", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int L3 = d.b.g0.g.l.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.b.g0.g.l.n.u(L3);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        this.f48348a = new d.b.g0.g.l.f(AppRuntime.getAppContext(), d.b.g0.a.z0.f.V().h(), lVar);
        this.f48350c = d.b.g0.g.l.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("srcPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("destPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("srcPath", G);
            String F2 = d.b.g0.g.l.n.F("destPath", G);
            this.f48350c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.b.g0.g.l.o.b bVar;
        Map<String, Object> G;
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.b.g0.g.l.n.G(this.f48348a, jsObject, (bVar = new d.b.g0.g.l.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f48350c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48350c.h(new a(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("encoding", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.c q = this.f48348a.q(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48349b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f48340a != 0 || (list = q.f48342c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48350c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.c s = this.f48348a.s(str, true);
            d.b.g0.g.l.n.Z(this.f48349b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f48340a != 0) {
                return new String[0];
            }
            List<String> list = s.f48342c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f48342c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f48350c.h(new h(d.b.g0.g.l.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("oldPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("newPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("oldPath", G);
            String F2 = d.b.g0.g.l.n.F("newPath", G);
            this.f48350c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48350c.h(new n(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("tempFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("tempFilePath", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.b.g0.g.l.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48350c.h(new RunnableC0980e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.b.g0.g.l.j statSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.c y = this.f48348a.y(str, true);
            d.b.g0.g.l.n.Z(this.f48349b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f48340a != 0) {
                return null;
            }
            return y.f48343d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("zipFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("targetPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("zipFilePath", G);
            String F2 = d.b.g0.g.l.n.F("targetPath", G);
            this.f48350c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            String u = d.b.g0.g.l.n.u(d.b.g0.g.l.n.L("data", jsObject));
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48348a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48350c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str, str2);
            d.b.g0.g.l.c x = this.f48348a.x(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48349b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f48340a != 0 || (list = x.f48342c) == null) {
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
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.n.Z(this.f48349b, this.f48348a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48348a, this.f48349b, null, null)) {
            this.f48350c.k(str);
            d.b.g0.g.l.c q = this.f48348a.q(str, null, true);
            d.b.g0.g.l.n.Z(this.f48349b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f48347h == null) {
                q.f48347h = new byte[0];
            }
            byte[] bArr = q.f48347h;
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
