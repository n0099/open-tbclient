package d.b.h0.g.l;

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
    public d.b.h0.g.l.f f49070a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.g.i.a f49071b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.g.l.i f49072c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f49074f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49075g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f49076h;
        public final /* synthetic */ d.b.h0.g.l.o.b i;

        /* renamed from: d.b.h0.g.l.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1012a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49077e;

            public RunnableC1012a(d.b.h0.g.l.c cVar) {
                this.f49077e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f49075g), "dirPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49077e, "mkdir:", a.this.f49076h);
                a aVar = a.this;
                if (d.b.h0.g.l.n.a(t, aVar.i, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.b bVar = a.this.i;
                    bVar.errMsg = "mkdir:" + this.f49077e.f49063b;
                    a aVar2 = a.this;
                    d.b.h0.g.l.n.b(aVar2.i, aVar2.f49076h);
                }
            }
        }

        public a(String str, Boolean bool, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49073e = str;
            this.f49074f = bool;
            this.f49075g = i;
            this.f49076h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new RunnableC1012a(e.this.f49070a.o(this.f49073e, this.f49074f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49081g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49082h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49083e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49083e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f49081g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f49082h), "destPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49083e, "copyFile:", b.this.i);
                b bVar = b.this;
                if (d.b.h0.g.l.n.a(t, bVar.j, hashMap, e.this.f49071b)) {
                    b bVar2 = b.this;
                    d.b.h0.g.l.n.b(bVar2.j, bVar2.i);
                }
            }
        }

        public b(String str, String str2, int i, int i2, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49079e = str;
            this.f49080f = str2;
            this.f49081g = i;
            this.f49082h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.c(this.f49079e, this.f49080f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f49087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f49088h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.h0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49089e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49089e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49089e, "appendFile:", c.this.f49088h);
                c cVar = c.this;
                if (d.b.h0.g.l.n.a(t, cVar.l, hashMap, e.this.f49071b)) {
                    c cVar2 = c.this;
                    d.b.h0.g.l.n.b(cVar2.l, cVar2.f49088h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.h0.g.l.o.b bVar) {
            this.f49085e = str;
            this.f49086f = str2;
            this.f49087g = bArr;
            this.f49088h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.l.c b2 = e.this.f49070a.b(this.f49085e, TextUtils.isEmpty(this.f49086f) ? this.f49087g : this.f49086f, d.b.h0.g.l.n.F("encoding", this.f49088h), false);
            if (!TextUtils.isEmpty(this.i)) {
                b2.f49063b = this.i;
                b2.f49062a = -2;
                d.b.h0.g.l.n.d(e.this.f49071b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    b2.f49063b = "fail encoding must be a string";
                    b2.f49062a = -2;
                    d.b.h0.g.l.n.d(e.this.f49071b, b2.f49063b);
                }
            }
            e.this.f49071b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49091e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49092f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49093g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49094h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49095e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49095e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f49092f), "path");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49095e, "access:", d.this.f49093g);
                d dVar = d.this;
                if (d.b.h0.g.l.n.a(t, dVar.f49094h, hashMap, e.this.f49071b)) {
                    d dVar2 = d.this;
                    d.b.h0.g.l.n.b(dVar2.f49094h, dVar2.f49093g);
                }
            }
        }

        public d(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49091e = str;
            this.f49092f = i;
            this.f49093g = map;
            this.f49094h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.a(this.f49091e, false)));
        }
    }

    /* renamed from: d.b.h0.g.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1013e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49099g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49100h;

        /* renamed from: d.b.h0.g.l.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49101e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49101e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC1013e.this.f49098f), "path");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49101e, "stat:", RunnableC1013e.this.f49099g);
                RunnableC1013e runnableC1013e = RunnableC1013e.this;
                if (d.b.h0.g.l.n.a(t, runnableC1013e.f49100h, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.h hVar = new d.b.h0.g.l.o.h();
                    d.b.h0.g.l.c cVar = this.f49101e;
                    hVar.stats = cVar.f49065d;
                    hVar.errMsg = cVar.f49063b;
                    d.b.h0.g.l.n.b(hVar, RunnableC1013e.this.f49099g);
                }
            }
        }

        public RunnableC1013e(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49097e = str;
            this.f49098f = i;
            this.f49099g = map;
            this.f49100h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.y(this.f49097e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49106h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49107e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49107e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f49104f), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49107e, "getFileInfo:", f.this.f49105g);
                f fVar = f.this;
                if (d.b.h0.g.l.n.a(t, fVar.f49106h, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.c cVar = new d.b.h0.g.l.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f49107e.f49063b;
                    d.b.h0.g.l.c cVar2 = this.f49107e;
                    cVar.digest = cVar2.f49068g;
                    cVar.size = (int) cVar2.f49066e;
                    d.b.h0.g.l.n.b(cVar, f.this.f49105g);
                }
            }
        }

        public f(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49103e = str;
            this.f49104f = i;
            this.f49105g = map;
            this.f49106h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.e(this.f49103e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f49109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49110f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49112e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49112e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49112e, "getSavedFileList:", g.this.f49109e);
                g gVar = g.this;
                if (d.b.h0.g.l.n.a(t, gVar.f49110f, null, e.this.f49071b)) {
                    d.b.h0.g.l.o.d dVar = new d.b.h0.g.l.o.d();
                    List<d.b.h0.g.l.d> list = this.f49112e.f49067f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.b.h0.g.l.d[0] : (d.b.h0.g.l.d[]) this.f49112e.f49067f.toArray(new d.b.h0.g.l.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f49110f.errMsg;
                    d.b.h0.g.l.n.b(dVar, gVar2.f49109e);
                }
            }
        }

        public g(Map map, d.b.h0.g.l.o.b bVar) {
            this.f49109e = map;
            this.f49110f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49115f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49116g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49117h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49118e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49118e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f49115f), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49118e, "removeSavedFile:", h.this.f49116g);
                h hVar = h.this;
                if (d.b.h0.g.l.n.a(t, hVar.f49117h, hashMap, e.this.f49071b)) {
                    h hVar2 = h.this;
                    d.b.h0.g.l.n.b(hVar2.f49117h, hVar2.f49116g);
                }
            }
        }

        public h(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49114e = str;
            this.f49115f = i;
            this.f49116g = map;
            this.f49117h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.t(this.f49114e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f49122g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f49123h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.h0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49124e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49124e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49124e, "writeFile:", i.this.f49123h);
                i iVar = i.this;
                if (d.b.h0.g.l.n.a(t, iVar.l, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f49124e.f49063b;
                    i iVar2 = i.this;
                    d.b.h0.g.l.n.b(iVar2.l, iVar2.f49123h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.h0.g.l.o.b bVar) {
            this.f49120e = str;
            this.f49121f = str2;
            this.f49122g = bArr;
            this.f49123h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.l.c C = e.this.f49070a.C(false, this.f49120e, TextUtils.isEmpty(this.f49121f) ? this.f49122g : this.f49121f, d.b.h0.g.l.n.F("encoding", this.f49123h));
            if (!TextUtils.isEmpty(this.i)) {
                C.f49063b = this.i;
                C.f49062a = -2;
                d.b.h0.g.l.n.d(e.this.f49071b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    C.f49063b = "fail encoding must be a string";
                    C.f49062a = -2;
                    d.b.h0.g.l.n.d(e.this.f49071b, C.f49063b);
                }
            }
            e.this.f49071b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49129h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49130e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49130e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f49127f), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49130e, "unlink:", j.this.f49128g);
                j jVar = j.this;
                if (d.b.h0.g.l.n.a(t, jVar.f49129h, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.b bVar = j.this.f49129h;
                    bVar.errMsg = "unlink:" + this.f49130e.f49063b;
                    j jVar2 = j.this;
                    d.b.h0.g.l.n.b(jVar2.f49129h, jVar2.f49128g);
                }
            }
        }

        public j(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49126e = str;
            this.f49127f = i;
            this.f49128g = map;
            this.f49129h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.z(this.f49126e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49133f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49134g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49135h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49136e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49136e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f49134g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f49135h), "targetPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49136e, "unzip:", k.this.i);
                k kVar = k.this;
                if (d.b.h0.g.l.n.a(t, kVar.j, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f49136e.f49063b;
                    k kVar2 = k.this;
                    d.b.h0.g.l.n.b(kVar2.j, kVar2.i);
                }
            }
        }

        public k(String str, String str2, int i, int i2, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49132e = str;
            this.f49133f = str2;
            this.f49134g = i;
            this.f49135h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.A(this.f49132e, this.f49133f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49139f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49140g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49141h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49142e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49142e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f49140g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f49141h), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49142e, "saveFile:", l.this.i);
                l lVar = l.this;
                if (d.b.h0.g.l.n.a(t, lVar.j, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.g gVar = new d.b.h0.g.l.o.g();
                    List<String> list = this.f49142e.f49064c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f49142e.f49063b;
                    d.b.h0.g.l.n.b(gVar, l.this.i);
                }
            }
        }

        public l(String str, String str2, int i, int i2, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49138e = str;
            this.f49139f = str2;
            this.f49140g = i;
            this.f49141h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.x(this.f49138e, this.f49139f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49145f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f49146g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.l.o.b f49147h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49148e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49148e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f49145f), "dirPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49148e, "readdir:", m.this.f49146g);
                m mVar = m.this;
                if (d.b.h0.g.l.n.a(t, mVar.f49147h, hashMap, e.this.f49071b)) {
                    d.b.h0.g.l.o.e eVar = new d.b.h0.g.l.o.e();
                    List<String> list = this.f49148e.f49064c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f49148e.f49064c.toArray(new String[size]);
                    eVar.errMsg = this.f49148e.f49063b;
                    d.b.h0.g.l.n.b(eVar, m.this.f49146g);
                }
            }
        }

        public m(String str, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49144e = str;
            this.f49145f = i;
            this.f49146g = map;
            this.f49147h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.s(this.f49144e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f49151f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49152g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f49153h;
        public final /* synthetic */ d.b.h0.g.l.o.b i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49154e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49154e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f49152g), "dirPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49154e, "rmdir:", n.this.f49153h);
                n nVar = n.this;
                if (d.b.h0.g.l.n.a(t, nVar.i, hashMap, e.this.f49071b)) {
                    n nVar2 = n.this;
                    d.b.h0.g.l.n.b(nVar2.i, nVar2.f49153h);
                }
            }
        }

        public n(String str, Boolean bool, int i, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49150e = str;
            this.f49151f = bool;
            this.f49152g = i;
            this.f49153h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.v(this.f49150e, this.f49151f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49158g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49159h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49160e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49160e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f49159h), "filePath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49160e, "readFile:", o.this.i);
                o oVar = o.this;
                if (d.b.h0.g.l.n.a(t, oVar.j, hashMap, e.this.f49071b)) {
                    if (TextUtils.isEmpty(o.this.f49157f)) {
                        d.b.h0.g.l.o.a aVar = new d.b.h0.g.l.o.a();
                        d.b.h0.g.l.c cVar = this.f49160e;
                        if (cVar.f49069h == null) {
                            cVar.f49069h = new byte[0];
                        }
                        byte[] bArr = this.f49160e.f49069h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f49160e.f49063b;
                        d.b.h0.g.l.n.b(aVar, o.this.i);
                        return;
                    }
                    List<String> list = this.f49160e.f49064c;
                    String str = list != null ? list.get(0) : null;
                    d.b.h0.g.l.o.f fVar = new d.b.h0.g.l.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f49160e.f49063b;
                    d.b.h0.g.l.n.b(fVar, o.this.i);
                }
            }
        }

        public o(String str, String str2, int i, int i2, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49156e = str;
            this.f49157f = str2;
            this.f49158g = i;
            this.f49159h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.l.c q = e.this.f49070a.q(this.f49156e, this.f49157f, false);
            int i = this.f49158g;
            if (i != 7 && i != 12) {
                q.f49063b = "fail encoding must be a string";
                q.f49062a = -2;
                d.b.h0.g.l.n.d(e.this.f49071b, q.f49063b);
            }
            e.this.f49071b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49163f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49164g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49165h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.h0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.l.c f49166e;

            public a(d.b.h0.g.l.c cVar) {
                this.f49166e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f49164g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f49165h), "newPath");
                d.b.h0.g.l.b t = d.b.h0.g.l.n.t(this.f49166e, "rename:", p.this.i);
                p pVar = p.this;
                if (d.b.h0.g.l.n.a(t, pVar.j, hashMap, e.this.f49071b)) {
                    p pVar2 = p.this;
                    d.b.h0.g.l.n.b(pVar2.j, pVar2.i);
                }
            }
        }

        public p(String str, String str2, int i, int i2, Map map, d.b.h0.g.l.o.b bVar) {
            this.f49162e = str;
            this.f49163f = str2;
            this.f49164g = i;
            this.f49165h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f49071b.runOnJSThread(new a(e.this.f49070a.u(this.f49162e, this.f49163f, false)));
        }
    }

    public e(d.b.h0.g.i.a aVar) {
        this.f49071b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("path", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("path", G);
            this.f49072c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("encoding", jsObject);
            int L2 = d.b.h0.g.l.n.L("filePath", jsObject);
            int L3 = d.b.h0.g.l.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.b.h0.g.l.n.u(L3);
            byte[] p2 = d.b.h0.g.l.n.p(jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("data", G);
            String F2 = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.b.h0.a.a2.f.c lVar;
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O != null) {
            lVar = O.U();
        } else {
            lVar = new d.b.h0.g.l.l();
        }
        this.f49070a = new d.b.h0.g.l.f(AppRuntime.getAppContext(), d.b.h0.a.z0.f.V().h(), lVar);
        this.f49072c = d.b.h0.g.l.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("srcPath", jsObject);
            int L2 = d.b.h0.g.l.n.L("destPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("srcPath", G);
            String F2 = d.b.h0.g.l.n.F("destPath", G);
            this.f49072c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str, str2);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("filePath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.b.h0.g.l.o.b bVar;
        Map<String, Object> G;
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.b.h0.g.l.n.G(this.f49070a, jsObject, (bVar = new d.b.h0.g.l.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f49072c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("dirPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("dirPath", G);
            this.f49072c.h(new a(F, (Boolean) d.b.h0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("filePath", jsObject);
            int L2 = d.b.h0.g.l.n.L("encoding", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("encoding", G);
            String F2 = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.c q = this.f49070a.q(str, str2, true);
            d.b.h0.g.l.n.Z(this.f49071b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f49062a != 0 || (list = q.f49064c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("dirPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("dirPath", G);
            this.f49072c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.c s = this.f49070a.s(str, true);
            d.b.h0.g.l.n.Z(this.f49071b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f49062a != 0) {
                return new String[0];
            }
            List<String> list = s.f49064c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f49064c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("filePath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f49072c.h(new h(d.b.h0.g.l.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("oldPath", jsObject);
            int L2 = d.b.h0.g.l.n.L("newPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("oldPath", G);
            String F2 = d.b.h0.g.l.n.F("newPath", G);
            this.f49072c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str, str2);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("dirPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("dirPath", G);
            this.f49072c.h(new n(F, (Boolean) d.b.h0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("tempFilePath", jsObject);
            int L2 = d.b.h0.g.l.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("tempFilePath", G);
            String F2 = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.b.h0.g.l.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("path", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("path", G);
            this.f49072c.h(new RunnableC1013e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.b.h0.g.l.j statSync(String str) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.c y = this.f49070a.y(str, true);
            d.b.h0.g.l.n.Z(this.f49071b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f49062a != 0) {
                return null;
            }
            return y.f49065d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("filePath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("zipFilePath", jsObject);
            int L2 = d.b.h0.g.l.n.L("targetPath", jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("zipFilePath", G);
            String F2 = d.b.h0.g.l.n.F("targetPath", G);
            this.f49072c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.h0.g.l.n.L("filePath", jsObject);
            String u = d.b.h0.g.l.n.u(d.b.h0.g.l.n.L("data", jsObject));
            int L2 = d.b.h0.g.l.n.L("encoding", jsObject);
            byte[] p2 = d.b.h0.g.l.n.p(jsObject);
            d.b.h0.g.l.o.b bVar = new d.b.h0.g.l.o.b();
            Map<String, Object> G = d.b.h0.g.l.n.G(this.f49070a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.h0.g.l.n.F("data", G);
            String F2 = d.b.h0.g.l.n.F("filePath", G);
            this.f49072c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str, str2);
            d.b.h0.g.l.c x = this.f49070a.x(str, str2, true);
            d.b.h0.g.l.n.Z(this.f49071b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f49062a != 0 || (list = x.f49064c) == null) {
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
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.n.Z(this.f49071b, this.f49070a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.b.h0.g.l.n.P(this.f49070a, this.f49071b, null, null)) {
            this.f49072c.k(str);
            d.b.h0.g.l.c q = this.f49070a.q(str, null, true);
            d.b.h0.g.l.n.Z(this.f49071b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f49069h == null) {
                q.f49069h = new byte[0];
            }
            byte[] bArr = q.f49069h;
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
