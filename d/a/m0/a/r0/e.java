package d.a.m0.a.r0;

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
    public d.a.m0.a.r0.f f48058a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.l0.a f48059b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.r0.i f48060c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48063g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48064h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48065i;

        /* renamed from: d.a.m0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0863a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48066e;

            public RunnableC0863a(d.a.m0.a.r0.c cVar) {
                this.f48066e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f48063g), "dirPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48066e, "mkdir:", a.this.f48064h);
                a aVar = a.this;
                if (d.a.m0.a.r0.n.a(t, aVar.f48065i, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.b bVar = a.this.f48065i;
                    bVar.errMsg = "mkdir:" + this.f48066e.f48051b;
                    a aVar2 = a.this;
                    d.a.m0.a.r0.n.b(aVar2.f48065i, aVar2.f48064h);
                }
            }
        }

        public a(String str, Boolean bool, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48061e = str;
            this.f48062f = bool;
            this.f48063g = i2;
            this.f48064h = map;
            this.f48065i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new RunnableC0863a(e.this.f48058a.o(this.f48061e, this.f48062f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48069f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48070g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48071h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48072i;
        public final /* synthetic */ d.a.m0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48073e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48073e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f48070g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f48071h), "destPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48073e, "copyFile:", b.this.f48072i);
                b bVar = b.this;
                if (d.a.m0.a.r0.n.a(t, bVar.j, hashMap, e.this.f48059b)) {
                    b bVar2 = b.this;
                    d.a.m0.a.r0.n.b(bVar2.j, bVar2.f48072i);
                }
            }
        }

        public b(String str, String str2, int i2, int i3, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48068e = str;
            this.f48069f = str2;
            this.f48070g = i2;
            this.f48071h = i3;
            this.f48072i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.c(this.f48068e, this.f48069f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48077g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48078h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f48079i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.m0.a.r0.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48080e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48080e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48080e, "appendFile:", c.this.f48078h);
                c cVar = c.this;
                if (d.a.m0.a.r0.n.a(t, cVar.l, hashMap, e.this.f48059b)) {
                    c cVar2 = c.this;
                    d.a.m0.a.r0.n.b(cVar2.l, cVar2.f48078h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.m0.a.r0.o.b bVar) {
            this.f48075e = str;
            this.f48076f = str2;
            this.f48077g = bArr;
            this.f48078h = map;
            this.f48079i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.r0.c b2 = e.this.f48058a.b(this.f48075e, TextUtils.isEmpty(this.f48076f) ? this.f48077g : this.f48076f, d.a.m0.a.r0.n.F("encoding", this.f48078h), false);
            if (!TextUtils.isEmpty(this.f48079i)) {
                b2.f48051b = this.f48079i;
                b2.f48050a = -2;
                d.a.m0.a.r0.n.d(e.this.f48059b, this.f48079i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    b2.f48051b = "fail encoding must be a string";
                    b2.f48050a = -2;
                    d.a.m0.a.r0.n.d(e.this.f48059b, b2.f48051b);
                }
            }
            e.this.f48059b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48082e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48083f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48084g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48085h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48087e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48087e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f48083f), "path");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48087e, "access:", d.this.f48084g);
                d dVar = d.this;
                if (d.a.m0.a.r0.n.a(t, dVar.f48085h, hashMap, e.this.f48059b)) {
                    d dVar2 = d.this;
                    d.a.m0.a.r0.n.b(dVar2.f48085h, dVar2.f48084g);
                }
            }
        }

        public d(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48082e = str;
            this.f48083f = i2;
            this.f48084g = map;
            this.f48085h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.a(this.f48082e, false)));
        }
    }

    /* renamed from: d.a.m0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0864e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48091g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48092h;

        /* renamed from: d.a.m0.a.r0.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48094e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48094e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0864e.this.f48090f), "path");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48094e, "stat:", RunnableC0864e.this.f48091g);
                RunnableC0864e runnableC0864e = RunnableC0864e.this;
                if (d.a.m0.a.r0.n.a(t, runnableC0864e.f48092h, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.h hVar = new d.a.m0.a.r0.o.h();
                    d.a.m0.a.r0.c cVar = this.f48094e;
                    hVar.stats = cVar.f48053d;
                    hVar.errMsg = cVar.f48051b;
                    d.a.m0.a.r0.n.b(hVar, RunnableC0864e.this.f48091g);
                }
            }
        }

        public RunnableC0864e(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48089e = str;
            this.f48090f = i2;
            this.f48091g = map;
            this.f48092h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.y(this.f48089e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48098g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48099h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48101e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48101e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f48097f), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48101e, "getFileInfo:", f.this.f48098g);
                f fVar = f.this;
                if (d.a.m0.a.r0.n.a(t, fVar.f48099h, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.c cVar = new d.a.m0.a.r0.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f48101e.f48051b;
                    d.a.m0.a.r0.c cVar2 = this.f48101e;
                    cVar.digest = cVar2.f48056g;
                    cVar.size = (int) cVar2.f48054e;
                    d.a.m0.a.r0.n.b(cVar, f.this.f48098g);
                }
            }
        }

        public f(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48096e = str;
            this.f48097f = i2;
            this.f48098g = map;
            this.f48099h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.e(this.f48096e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f48103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48104f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48106e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48106e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48106e, "getSavedFileList:", g.this.f48103e);
                g gVar = g.this;
                if (d.a.m0.a.r0.n.a(t, gVar.f48104f, null, e.this.f48059b)) {
                    d.a.m0.a.r0.o.d dVar = new d.a.m0.a.r0.o.d();
                    List<d.a.m0.a.r0.d> list = this.f48106e.f48055f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.a.m0.a.r0.d[0] : (d.a.m0.a.r0.d[]) this.f48106e.f48055f.toArray(new d.a.m0.a.r0.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f48104f.errMsg;
                    d.a.m0.a.r0.n.b(dVar, gVar2.f48103e);
                }
            }
        }

        public g(Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48103e = map;
            this.f48104f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48110g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48111h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48113e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48113e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f48109f), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48113e, "removeSavedFile:", h.this.f48110g);
                h hVar = h.this;
                if (d.a.m0.a.r0.n.a(t, hVar.f48111h, hashMap, e.this.f48059b)) {
                    h hVar2 = h.this;
                    d.a.m0.a.r0.n.b(hVar2.f48111h, hVar2.f48110g);
                }
            }
        }

        public h(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48108e = str;
            this.f48109f = i2;
            this.f48110g = map;
            this.f48111h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.t(this.f48108e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48118h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f48119i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.m0.a.r0.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48120e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48120e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48120e, "writeFile:", i.this.f48118h);
                i iVar = i.this;
                if (d.a.m0.a.r0.n.a(t, iVar.l, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f48120e.f48051b;
                    i iVar2 = i.this;
                    d.a.m0.a.r0.n.b(iVar2.l, iVar2.f48118h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.m0.a.r0.o.b bVar) {
            this.f48115e = str;
            this.f48116f = str2;
            this.f48117g = bArr;
            this.f48118h = map;
            this.f48119i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.r0.c C = e.this.f48058a.C(false, this.f48115e, TextUtils.isEmpty(this.f48116f) ? this.f48117g : this.f48116f, d.a.m0.a.r0.n.F("encoding", this.f48118h));
            if (!TextUtils.isEmpty(this.f48119i)) {
                C.f48051b = this.f48119i;
                C.f48050a = -2;
                d.a.m0.a.r0.n.d(e.this.f48059b, this.f48119i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    C.f48051b = "fail encoding must be a string";
                    C.f48050a = -2;
                    d.a.m0.a.r0.n.d(e.this.f48059b, C.f48051b);
                }
            }
            e.this.f48059b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48125h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48127e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48127e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f48123f), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48127e, "unlink:", j.this.f48124g);
                j jVar = j.this;
                if (d.a.m0.a.r0.n.a(t, jVar.f48125h, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.b bVar = j.this.f48125h;
                    bVar.errMsg = "unlink:" + this.f48127e.f48051b;
                    j jVar2 = j.this;
                    d.a.m0.a.r0.n.b(jVar2.f48125h, jVar2.f48124g);
                }
            }
        }

        public j(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48122e = str;
            this.f48123f = i2;
            this.f48124g = map;
            this.f48125h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.z(this.f48122e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48130f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48131g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48132h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48133i;
        public final /* synthetic */ d.a.m0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48134e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48134e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f48131g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f48132h), "targetPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48134e, "unzip:", k.this.f48133i);
                k kVar = k.this;
                if (d.a.m0.a.r0.n.a(t, kVar.j, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f48134e.f48051b;
                    k kVar2 = k.this;
                    d.a.m0.a.r0.n.b(kVar2.j, kVar2.f48133i);
                }
            }
        }

        public k(String str, String str2, int i2, int i3, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48129e = str;
            this.f48130f = str2;
            this.f48131g = i2;
            this.f48132h = i3;
            this.f48133i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.A(this.f48129e, this.f48130f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48137f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48138g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48139h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48140i;
        public final /* synthetic */ d.a.m0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48141e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48141e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f48138g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f48139h), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48141e, "saveFile:", l.this.f48140i);
                l lVar = l.this;
                if (d.a.m0.a.r0.n.a(t, lVar.j, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.g gVar = new d.a.m0.a.r0.o.g();
                    List<String> list = this.f48141e.f48052c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f48141e.f48051b;
                    d.a.m0.a.r0.n.b(gVar, l.this.f48140i);
                }
            }
        }

        public l(String str, String str2, int i2, int i3, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48136e = str;
            this.f48137f = str2;
            this.f48138g = i2;
            this.f48139h = i3;
            this.f48140i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.x(this.f48136e, this.f48137f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48144f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48145g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48146h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48148e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48148e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f48144f), "dirPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48148e, "readdir:", m.this.f48145g);
                m mVar = m.this;
                if (d.a.m0.a.r0.n.a(t, mVar.f48146h, hashMap, e.this.f48059b)) {
                    d.a.m0.a.r0.o.e eVar = new d.a.m0.a.r0.o.e();
                    List<String> list = this.f48148e.f48052c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f48148e.f48052c.toArray(new String[size]);
                    eVar.errMsg = this.f48148e.f48051b;
                    d.a.m0.a.r0.n.b(eVar, m.this.f48145g);
                }
            }
        }

        public m(String str, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48143e = str;
            this.f48144f = i2;
            this.f48145g = map;
            this.f48146h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.s(this.f48143e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48151f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48152g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48153h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.r0.o.b f48154i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48155e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48155e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f48152g), "dirPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48155e, "rmdir:", n.this.f48153h);
                n nVar = n.this;
                if (d.a.m0.a.r0.n.a(t, nVar.f48154i, hashMap, e.this.f48059b)) {
                    n nVar2 = n.this;
                    d.a.m0.a.r0.n.b(nVar2.f48154i, nVar2.f48153h);
                }
            }
        }

        public n(String str, Boolean bool, int i2, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48150e = str;
            this.f48151f = bool;
            this.f48152g = i2;
            this.f48153h = map;
            this.f48154i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.v(this.f48150e, this.f48151f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48159g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48160h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48161i;
        public final /* synthetic */ d.a.m0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48162e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48162e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f48160h), "filePath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48162e, "readFile:", o.this.f48161i);
                o oVar = o.this;
                if (d.a.m0.a.r0.n.a(t, oVar.j, hashMap, e.this.f48059b)) {
                    if (TextUtils.isEmpty(o.this.f48158f)) {
                        d.a.m0.a.r0.o.a aVar = new d.a.m0.a.r0.o.a();
                        d.a.m0.a.r0.c cVar = this.f48162e;
                        if (cVar.f48057h == null) {
                            cVar.f48057h = new byte[0];
                        }
                        byte[] bArr = this.f48162e.f48057h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f48162e.f48051b;
                        d.a.m0.a.r0.n.b(aVar, o.this.f48161i);
                        return;
                    }
                    List<String> list = this.f48162e.f48052c;
                    String str = list != null ? list.get(0) : null;
                    d.a.m0.a.r0.o.f fVar = new d.a.m0.a.r0.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f48162e.f48051b;
                    d.a.m0.a.r0.n.b(fVar, o.this.f48161i);
                }
            }
        }

        public o(String str, String str2, int i2, int i3, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48157e = str;
            this.f48158f = str2;
            this.f48159g = i2;
            this.f48160h = i3;
            this.f48161i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.r0.c q = e.this.f48058a.q(this.f48157e, this.f48158f, false);
            int i2 = this.f48159g;
            if (i2 != 7 && i2 != 12) {
                q.f48051b = "fail encoding must be a string";
                q.f48050a = -2;
                d.a.m0.a.r0.n.d(e.this.f48059b, q.f48051b);
            }
            e.this.f48059b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48167h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48168i;
        public final /* synthetic */ d.a.m0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.r0.c f48169e;

            public a(d.a.m0.a.r0.c cVar) {
                this.f48169e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f48166g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f48167h), "newPath");
                d.a.m0.a.r0.b t = d.a.m0.a.r0.n.t(this.f48169e, "rename:", p.this.f48168i);
                p pVar = p.this;
                if (d.a.m0.a.r0.n.a(t, pVar.j, hashMap, e.this.f48059b)) {
                    p pVar2 = p.this;
                    d.a.m0.a.r0.n.b(pVar2.j, pVar2.f48168i);
                }
            }
        }

        public p(String str, String str2, int i2, int i3, Map map, d.a.m0.a.r0.o.b bVar) {
            this.f48164e = str;
            this.f48165f = str2;
            this.f48166g = i2;
            this.f48167h = i3;
            this.f48168i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48059b.runOnJSThread(new a(e.this.f48058a.u(this.f48164e, this.f48165f, false)));
        }
    }

    public e(d.a.m0.a.l0.a aVar) {
        this.f48059b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("path", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("path", G);
            this.f48060c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.m0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.m0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.m0.a.r0.n.u(L3);
            byte[] p2 = d.a.m0.a.r0.n.p(jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("data", G);
            String F2 = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.m0.a.k2.f.d lVar;
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q != null) {
            lVar = Q.W();
        } else {
            lVar = new d.a.m0.a.r0.l();
        }
        this.f48058a = new d.a.m0.a.r0.f(AppRuntime.getAppContext(), d.a.m0.a.g1.f.V().A(), lVar);
        this.f48060c = d.a.m0.a.r0.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.m0.a.r0.n.L("destPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("srcPath", G);
            String F2 = d.a.m0.a.r0.n.F("destPath", G);
            this.f48060c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str, str2);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("filePath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.m0.a.r0.o.b bVar;
        Map<String, Object> G;
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, (bVar = new d.a.m0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f48060c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("dirPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("dirPath", G);
            this.f48060c.h(new a(F, (Boolean) d.a.m0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.m0.a.r0.n.L("encoding", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("encoding", G);
            String F2 = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.c q = this.f48058a.q(str, str2, true);
            d.a.m0.a.r0.n.Z(this.f48059b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f48050a != 0 || (list = q.f48052c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("dirPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("dirPath", G);
            this.f48060c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.c s = this.f48058a.s(str, true);
            d.a.m0.a.r0.n.Z(this.f48059b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f48050a != 0) {
                return new String[0];
            }
            List<String> list = s.f48052c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f48052c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("filePath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f48060c.h(new h(d.a.m0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.m0.a.r0.n.L("newPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("oldPath", G);
            String F2 = d.a.m0.a.r0.n.F("newPath", G);
            this.f48060c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str, str2);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("dirPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("dirPath", G);
            this.f48060c.h(new n(F, (Boolean) d.a.m0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.m0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.a.m0.a.r0.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("path", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("path", G);
            this.f48060c.h(new RunnableC0864e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.m0.a.r0.j statSync(String str) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.c y = this.f48058a.y(str, true);
            d.a.m0.a.r0.n.Z(this.f48059b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f48050a != 0) {
                return null;
            }
            return y.f48053d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("filePath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.m0.a.r0.n.L("targetPath", jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.m0.a.r0.n.F("targetPath", G);
            this.f48060c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.m0.a.r0.n.L("filePath", jsObject);
            String u = d.a.m0.a.r0.n.u(d.a.m0.a.r0.n.L("data", jsObject));
            int L2 = d.a.m0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.m0.a.r0.n.p(jsObject);
            d.a.m0.a.r0.o.b bVar = new d.a.m0.a.r0.o.b();
            Map<String, Object> G = d.a.m0.a.r0.n.G(this.f48058a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.m0.a.r0.n.F("data", G);
            String F2 = d.a.m0.a.r0.n.F("filePath", G);
            this.f48060c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str, str2);
            d.a.m0.a.r0.c x = this.f48058a.x(str, str2, true);
            d.a.m0.a.r0.n.Z(this.f48059b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f48050a != 0 || (list = x.f48052c) == null) {
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
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.n.Z(this.f48059b, this.f48058a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.a.m0.a.r0.n.P(this.f48058a, this.f48059b, null, null)) {
            this.f48060c.k(str);
            d.a.m0.a.r0.c q = this.f48058a.q(str, null, true);
            d.a.m0.a.r0.n.Z(this.f48059b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f48057h == null) {
                q.f48057h = new byte[0];
            }
            byte[] bArr = q.f48057h;
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
