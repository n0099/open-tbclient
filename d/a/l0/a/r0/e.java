package d.a.l0.a.r0;

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
    public d.a.l0.a.r0.f f47950a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.l0.a f47951b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.r0.i f47952c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f47954f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47955g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47956h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f47957i;

        /* renamed from: d.a.l0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0860a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47958e;

            public RunnableC0860a(d.a.l0.a.r0.c cVar) {
                this.f47958e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f47955g), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47958e, "mkdir:", a.this.f47956h);
                a aVar = a.this;
                if (d.a.l0.a.r0.n.a(t, aVar.f47957i, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.b bVar = a.this.f47957i;
                    bVar.errMsg = "mkdir:" + this.f47958e.f47943b;
                    a aVar2 = a.this;
                    d.a.l0.a.r0.n.b(aVar2.f47957i, aVar2.f47956h);
                }
            }
        }

        public a(String str, Boolean bool, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47953e = str;
            this.f47954f = bool;
            this.f47955g = i2;
            this.f47956h = map;
            this.f47957i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new RunnableC0860a(e.this.f47950a.o(this.f47953e, this.f47954f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47963h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47964i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47965e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47965e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f47962g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f47963h), "destPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47965e, "copyFile:", b.this.f47964i);
                b bVar = b.this;
                if (d.a.l0.a.r0.n.a(t, bVar.j, hashMap, e.this.f47951b)) {
                    b bVar2 = b.this;
                    d.a.l0.a.r0.n.b(bVar2.j, bVar2.f47964i);
                }
            }
        }

        public b(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47960e = str;
            this.f47961f = str2;
            this.f47962g = i2;
            this.f47963h = i3;
            this.f47964i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.c(this.f47960e, this.f47961f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f47969g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47970h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f47971i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.l0.a.r0.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47972e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47972e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47972e, "appendFile:", c.this.f47970h);
                c cVar = c.this;
                if (d.a.l0.a.r0.n.a(t, cVar.l, hashMap, e.this.f47951b)) {
                    c cVar2 = c.this;
                    d.a.l0.a.r0.n.b(cVar2.l, cVar2.f47970h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.l0.a.r0.o.b bVar) {
            this.f47967e = str;
            this.f47968f = str2;
            this.f47969g = bArr;
            this.f47970h = map;
            this.f47971i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c b2 = e.this.f47950a.b(this.f47967e, TextUtils.isEmpty(this.f47968f) ? this.f47969g : this.f47968f, d.a.l0.a.r0.n.F("encoding", this.f47970h), false);
            if (!TextUtils.isEmpty(this.f47971i)) {
                b2.f47943b = this.f47971i;
                b2.f47942a = -2;
                d.a.l0.a.r0.n.d(e.this.f47951b, this.f47971i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    b2.f47943b = "fail encoding must be a string";
                    b2.f47942a = -2;
                    d.a.l0.a.r0.n.d(e.this.f47951b, b2.f47943b);
                }
            }
            e.this.f47951b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47976g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f47977h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47979e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47979e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f47975f), "path");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47979e, "access:", d.this.f47976g);
                d dVar = d.this;
                if (d.a.l0.a.r0.n.a(t, dVar.f47977h, hashMap, e.this.f47951b)) {
                    d dVar2 = d.this;
                    d.a.l0.a.r0.n.b(dVar2.f47977h, dVar2.f47976g);
                }
            }
        }

        public d(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47974e = str;
            this.f47975f = i2;
            this.f47976g = map;
            this.f47977h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.a(this.f47974e, false)));
        }
    }

    /* renamed from: d.a.l0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0861e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47981e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47982f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47983g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f47984h;

        /* renamed from: d.a.l0.a.r0.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47986e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47986e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0861e.this.f47982f), "path");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47986e, "stat:", RunnableC0861e.this.f47983g);
                RunnableC0861e runnableC0861e = RunnableC0861e.this;
                if (d.a.l0.a.r0.n.a(t, runnableC0861e.f47984h, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.h hVar = new d.a.l0.a.r0.o.h();
                    d.a.l0.a.r0.c cVar = this.f47986e;
                    hVar.stats = cVar.f47945d;
                    hVar.errMsg = cVar.f47943b;
                    d.a.l0.a.r0.n.b(hVar, RunnableC0861e.this.f47983g);
                }
            }
        }

        public RunnableC0861e(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47981e = str;
            this.f47982f = i2;
            this.f47983g = map;
            this.f47984h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.y(this.f47981e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47989f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f47991h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47993e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47993e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f47989f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47993e, "getFileInfo:", f.this.f47990g);
                f fVar = f.this;
                if (d.a.l0.a.r0.n.a(t, fVar.f47991h, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.c cVar = new d.a.l0.a.r0.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f47993e.f47943b;
                    d.a.l0.a.r0.c cVar2 = this.f47993e;
                    cVar.digest = cVar2.f47948g;
                    cVar.size = (int) cVar2.f47946e;
                    d.a.l0.a.r0.n.b(cVar, f.this.f47990g);
                }
            }
        }

        public f(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47988e = str;
            this.f47989f = i2;
            this.f47990g = map;
            this.f47991h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.e(this.f47988e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f47995e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f47996f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f47998e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f47998e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f47998e, "getSavedFileList:", g.this.f47995e);
                g gVar = g.this;
                if (d.a.l0.a.r0.n.a(t, gVar.f47996f, null, e.this.f47951b)) {
                    d.a.l0.a.r0.o.d dVar = new d.a.l0.a.r0.o.d();
                    List<d.a.l0.a.r0.d> list = this.f47998e.f47947f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.a.l0.a.r0.d[0] : (d.a.l0.a.r0.d[]) this.f47998e.f47947f.toArray(new d.a.l0.a.r0.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f47996f.errMsg;
                    d.a.l0.a.r0.n.b(dVar, gVar2.f47995e);
                }
            }
        }

        public g(Map map, d.a.l0.a.r0.o.b bVar) {
            this.f47995e = map;
            this.f47996f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48001f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48002g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f48003h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48005e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48005e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f48001f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48005e, "removeSavedFile:", h.this.f48002g);
                h hVar = h.this;
                if (d.a.l0.a.r0.n.a(t, hVar.f48003h, hashMap, e.this.f47951b)) {
                    h hVar2 = h.this;
                    d.a.l0.a.r0.n.b(hVar2.f48003h, hVar2.f48002g);
                }
            }
        }

        public h(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48000e = str;
            this.f48001f = i2;
            this.f48002g = map;
            this.f48003h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.t(this.f48000e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48007e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48008f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48009g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48010h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f48011i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.l0.a.r0.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48012e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48012e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48012e, "writeFile:", i.this.f48010h);
                i iVar = i.this;
                if (d.a.l0.a.r0.n.a(t, iVar.l, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f48012e.f47943b;
                    i iVar2 = i.this;
                    d.a.l0.a.r0.n.b(iVar2.l, iVar2.f48010h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.l0.a.r0.o.b bVar) {
            this.f48007e = str;
            this.f48008f = str2;
            this.f48009g = bArr;
            this.f48010h = map;
            this.f48011i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c C = e.this.f47950a.C(false, this.f48007e, TextUtils.isEmpty(this.f48008f) ? this.f48009g : this.f48008f, d.a.l0.a.r0.n.F("encoding", this.f48010h));
            if (!TextUtils.isEmpty(this.f48011i)) {
                C.f47943b = this.f48011i;
                C.f47942a = -2;
                d.a.l0.a.r0.n.d(e.this.f47951b, this.f48011i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    C.f47943b = "fail encoding must be a string";
                    C.f47942a = -2;
                    d.a.l0.a.r0.n.d(e.this.f47951b, C.f47943b);
                }
            }
            e.this.f47951b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48015f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48016g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f48017h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48019e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48019e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f48015f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48019e, "unlink:", j.this.f48016g);
                j jVar = j.this;
                if (d.a.l0.a.r0.n.a(t, jVar.f48017h, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.b bVar = j.this.f48017h;
                    bVar.errMsg = "unlink:" + this.f48019e.f47943b;
                    j jVar2 = j.this;
                    d.a.l0.a.r0.n.b(jVar2.f48017h, jVar2.f48016g);
                }
            }
        }

        public j(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48014e = str;
            this.f48015f = i2;
            this.f48016g = map;
            this.f48017h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.z(this.f48014e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48022f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48023g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48024h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48025i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48026e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48026e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f48023g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f48024h), "targetPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48026e, "unzip:", k.this.f48025i);
                k kVar = k.this;
                if (d.a.l0.a.r0.n.a(t, kVar.j, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f48026e.f47943b;
                    k kVar2 = k.this;
                    d.a.l0.a.r0.n.b(kVar2.j, kVar2.f48025i);
                }
            }
        }

        public k(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48021e = str;
            this.f48022f = str2;
            this.f48023g = i2;
            this.f48024h = i3;
            this.f48025i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.A(this.f48021e, this.f48022f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48028e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48029f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48030g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48031h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48032i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48033e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48033e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f48030g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f48031h), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48033e, "saveFile:", l.this.f48032i);
                l lVar = l.this;
                if (d.a.l0.a.r0.n.a(t, lVar.j, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.g gVar = new d.a.l0.a.r0.o.g();
                    List<String> list = this.f48033e.f47944c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f48033e.f47943b;
                    d.a.l0.a.r0.n.b(gVar, l.this.f48032i);
                }
            }
        }

        public l(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48028e = str;
            this.f48029f = str2;
            this.f48030g = i2;
            this.f48031h = i3;
            this.f48032i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.x(this.f48028e, this.f48029f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48036f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48037g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f48038h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48040e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48040e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f48036f), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48040e, "readdir:", m.this.f48037g);
                m mVar = m.this;
                if (d.a.l0.a.r0.n.a(t, mVar.f48038h, hashMap, e.this.f47951b)) {
                    d.a.l0.a.r0.o.e eVar = new d.a.l0.a.r0.o.e();
                    List<String> list = this.f48040e.f47944c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f48040e.f47944c.toArray(new String[size]);
                    eVar.errMsg = this.f48040e.f47943b;
                    d.a.l0.a.r0.n.b(eVar, m.this.f48037g);
                }
            }
        }

        public m(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48035e = str;
            this.f48036f = i2;
            this.f48037g = map;
            this.f48038h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.s(this.f48035e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48043f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48044g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48045h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f48046i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48047e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48047e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f48044g), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48047e, "rmdir:", n.this.f48045h);
                n nVar = n.this;
                if (d.a.l0.a.r0.n.a(t, nVar.f48046i, hashMap, e.this.f47951b)) {
                    n nVar2 = n.this;
                    d.a.l0.a.r0.n.b(nVar2.f48046i, nVar2.f48045h);
                }
            }
        }

        public n(String str, Boolean bool, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48042e = str;
            this.f48043f = bool;
            this.f48044g = i2;
            this.f48045h = map;
            this.f48046i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.v(this.f48042e, this.f48043f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48051g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48052h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48053i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48054e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48054e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f48052h), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48054e, "readFile:", o.this.f48053i);
                o oVar = o.this;
                if (d.a.l0.a.r0.n.a(t, oVar.j, hashMap, e.this.f47951b)) {
                    if (TextUtils.isEmpty(o.this.f48050f)) {
                        d.a.l0.a.r0.o.a aVar = new d.a.l0.a.r0.o.a();
                        d.a.l0.a.r0.c cVar = this.f48054e;
                        if (cVar.f47949h == null) {
                            cVar.f47949h = new byte[0];
                        }
                        byte[] bArr = this.f48054e.f47949h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f48054e.f47943b;
                        d.a.l0.a.r0.n.b(aVar, o.this.f48053i);
                        return;
                    }
                    List<String> list = this.f48054e.f47944c;
                    String str = list != null ? list.get(0) : null;
                    d.a.l0.a.r0.o.f fVar = new d.a.l0.a.r0.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f48054e.f47943b;
                    d.a.l0.a.r0.n.b(fVar, o.this.f48053i);
                }
            }
        }

        public o(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48049e = str;
            this.f48050f = str2;
            this.f48051g = i2;
            this.f48052h = i3;
            this.f48053i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c q = e.this.f47950a.q(this.f48049e, this.f48050f, false);
            int i2 = this.f48051g;
            if (i2 != 7 && i2 != 12) {
                q.f47943b = "fail encoding must be a string";
                q.f47942a = -2;
                d.a.l0.a.r0.n.d(e.this.f47951b, q.f47943b);
            }
            e.this.f47951b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48057f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48058g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48059h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f48060i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f48061e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f48061e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f48058g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f48059h), "newPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f48061e, "rename:", p.this.f48060i);
                p pVar = p.this;
                if (d.a.l0.a.r0.n.a(t, pVar.j, hashMap, e.this.f47951b)) {
                    p pVar2 = p.this;
                    d.a.l0.a.r0.n.b(pVar2.j, pVar2.f48060i);
                }
            }
        }

        public p(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f48056e = str;
            this.f48057f = str2;
            this.f48058g = i2;
            this.f48059h = i3;
            this.f48060i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f47951b.runOnJSThread(new a(e.this.f47950a.u(this.f48056e, this.f48057f, false)));
        }
    }

    public e(d.a.l0.a.l0.a aVar) {
        this.f47951b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("path", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("path", G);
            this.f47952c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.l0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.l0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.l0.a.r0.n.u(L3);
            byte[] p2 = d.a.l0.a.r0.n.p(jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("data", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.l0.a.k2.f.d lVar;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q != null) {
            lVar = Q.W();
        } else {
            lVar = new d.a.l0.a.r0.l();
        }
        this.f47950a = new d.a.l0.a.r0.f(AppRuntime.getAppContext(), d.a.l0.a.g1.f.V().A(), lVar);
        this.f47952c = d.a.l0.a.r0.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("destPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("srcPath", G);
            String F2 = d.a.l0.a.r0.n.F("destPath", G);
            this.f47952c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str, str2);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.l0.a.r0.o.b bVar;
        Map<String, Object> G;
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, (bVar = new d.a.l0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f47952c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f47952c.h(new a(F, (Boolean) d.a.l0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("encoding", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("encoding", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.c q = this.f47950a.q(str, str2, true);
            d.a.l0.a.r0.n.Z(this.f47951b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f47942a != 0 || (list = q.f47944c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f47952c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.c s = this.f47950a.s(str, true);
            d.a.l0.a.r0.n.Z(this.f47951b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f47942a != 0) {
                return new String[0];
            }
            List<String> list = s.f47944c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f47944c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f47952c.h(new h(d.a.l0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("newPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("oldPath", G);
            String F2 = d.a.l0.a.r0.n.F("newPath", G);
            this.f47952c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str, str2);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f47952c.h(new n(F, (Boolean) d.a.l0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.a.l0.a.r0.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("path", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("path", G);
            this.f47952c.h(new RunnableC0861e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.l0.a.r0.j statSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.c y = this.f47950a.y(str, true);
            d.a.l0.a.r0.n.Z(this.f47951b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f47942a != 0) {
                return null;
            }
            return y.f47945d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("targetPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.l0.a.r0.n.F("targetPath", G);
            this.f47952c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            String u = d.a.l0.a.r0.n.u(d.a.l0.a.r0.n.L("data", jsObject));
            int L2 = d.a.l0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.l0.a.r0.n.p(jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f47950a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("data", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f47952c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str, str2);
            d.a.l0.a.r0.c x = this.f47950a.x(str, str2, true);
            d.a.l0.a.r0.n.Z(this.f47951b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f47942a != 0 || (list = x.f47944c) == null) {
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
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.n.Z(this.f47951b, this.f47950a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f47950a, this.f47951b, null, null)) {
            this.f47952c.k(str);
            d.a.l0.a.r0.c q = this.f47950a.q(str, null, true);
            d.a.l0.a.r0.n.Z(this.f47951b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f47949h == null) {
                q.f47949h = new byte[0];
            }
            byte[] bArr = q.f47949h;
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
