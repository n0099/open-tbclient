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
    public d.b.g0.g.l.f f48741a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.i.a f48742b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.l.i f48743c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48747h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* renamed from: d.b.g0.g.l.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0992a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48748e;

            public RunnableC0992a(d.b.g0.g.l.c cVar) {
                this.f48748e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f48746g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48748e, "mkdir:", a.this.f48747h);
                a aVar = a.this;
                if (d.b.g0.g.l.n.a(t, aVar.i, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.b bVar = a.this.i;
                    bVar.errMsg = "mkdir:" + this.f48748e.f48734b;
                    a aVar2 = a.this;
                    d.b.g0.g.l.n.b(aVar2.i, aVar2.f48747h);
                }
            }
        }

        public a(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48744e = str;
            this.f48745f = bool;
            this.f48746g = i;
            this.f48747h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new RunnableC0992a(e.this.f48741a.o(this.f48744e, this.f48745f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48751f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48752g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48753h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48754e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48754e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f48752g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f48753h), "destPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48754e, "copyFile:", b.this.i);
                b bVar = b.this;
                if (d.b.g0.g.l.n.a(t, bVar.j, hashMap, e.this.f48742b)) {
                    b bVar2 = b.this;
                    d.b.g0.g.l.n.b(bVar2.j, bVar2.i);
                }
            }
        }

        public b(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48750e = str;
            this.f48751f = str2;
            this.f48752g = i;
            this.f48753h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.c(this.f48750e, this.f48751f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48758g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48759h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48760e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48760e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48760e, "appendFile:", c.this.f48759h);
                c cVar = c.this;
                if (d.b.g0.g.l.n.a(t, cVar.l, hashMap, e.this.f48742b)) {
                    c cVar2 = c.this;
                    d.b.g0.g.l.n.b(cVar2.l, cVar2.f48759h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48756e = str;
            this.f48757f = str2;
            this.f48758g = bArr;
            this.f48759h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c b2 = e.this.f48741a.b(this.f48756e, TextUtils.isEmpty(this.f48757f) ? this.f48758g : this.f48757f, d.b.g0.g.l.n.F("encoding", this.f48759h), false);
            if (!TextUtils.isEmpty(this.i)) {
                b2.f48734b = this.i;
                b2.f48733a = -2;
                d.b.g0.g.l.n.d(e.this.f48742b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    b2.f48734b = "fail encoding must be a string";
                    b2.f48733a = -2;
                    d.b.g0.g.l.n.d(e.this.f48742b, b2.f48734b);
                }
            }
            e.this.f48742b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48764g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48765h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48766e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48766e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f48763f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48766e, "access:", d.this.f48764g);
                d dVar = d.this;
                if (d.b.g0.g.l.n.a(t, dVar.f48765h, hashMap, e.this.f48742b)) {
                    d dVar2 = d.this;
                    d.b.g0.g.l.n.b(dVar2.f48765h, dVar2.f48764g);
                }
            }
        }

        public d(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48762e = str;
            this.f48763f = i;
            this.f48764g = map;
            this.f48765h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.a(this.f48762e, false)));
        }
    }

    /* renamed from: d.b.g0.g.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0993e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48770g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48771h;

        /* renamed from: d.b.g0.g.l.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48772e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48772e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0993e.this.f48769f), "path");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48772e, "stat:", RunnableC0993e.this.f48770g);
                RunnableC0993e runnableC0993e = RunnableC0993e.this;
                if (d.b.g0.g.l.n.a(t, runnableC0993e.f48771h, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.h hVar = new d.b.g0.g.l.o.h();
                    d.b.g0.g.l.c cVar = this.f48772e;
                    hVar.stats = cVar.f48736d;
                    hVar.errMsg = cVar.f48734b;
                    d.b.g0.g.l.n.b(hVar, RunnableC0993e.this.f48770g);
                }
            }
        }

        public RunnableC0993e(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48768e = str;
            this.f48769f = i;
            this.f48770g = map;
            this.f48771h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.y(this.f48768e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48776g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48777h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48778e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48778e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f48775f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48778e, "getFileInfo:", f.this.f48776g);
                f fVar = f.this;
                if (d.b.g0.g.l.n.a(t, fVar.f48777h, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.c cVar = new d.b.g0.g.l.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f48778e.f48734b;
                    d.b.g0.g.l.c cVar2 = this.f48778e;
                    cVar.digest = cVar2.f48739g;
                    cVar.size = (int) cVar2.f48737e;
                    d.b.g0.g.l.n.b(cVar, f.this.f48776g);
                }
            }
        }

        public f(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48774e = str;
            this.f48775f = i;
            this.f48776g = map;
            this.f48777h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.e(this.f48774e)));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f48780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48781f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48783e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48783e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48783e, "getSavedFileList:", g.this.f48780e);
                g gVar = g.this;
                if (d.b.g0.g.l.n.a(t, gVar.f48781f, null, e.this.f48742b)) {
                    d.b.g0.g.l.o.d dVar = new d.b.g0.g.l.o.d();
                    List<d.b.g0.g.l.d> list = this.f48783e.f48738f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.b.g0.g.l.d[0] : (d.b.g0.g.l.d[]) this.f48783e.f48738f.toArray(new d.b.g0.g.l.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f48781f.errMsg;
                    d.b.g0.g.l.n.b(dVar, gVar2.f48780e);
                }
            }
        }

        public g(Map map, d.b.g0.g.l.o.b bVar) {
            this.f48780e = map;
            this.f48781f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.i()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48786f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48787g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48788h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48789e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48789e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f48786f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48789e, "removeSavedFile:", h.this.f48787g);
                h hVar = h.this;
                if (d.b.g0.g.l.n.a(t, hVar.f48788h, hashMap, e.this.f48742b)) {
                    h hVar2 = h.this;
                    d.b.g0.g.l.n.b(hVar2.f48788h, hVar2.f48787g);
                }
            }
        }

        public h(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48785e = str;
            this.f48786f = i;
            this.f48787g = map;
            this.f48788h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.t(this.f48785e)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48792f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f48793g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48794h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.b.g0.g.l.o.b l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48795e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48795e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48795e, "writeFile:", i.this.f48794h);
                i iVar = i.this;
                if (d.b.g0.g.l.n.a(t, iVar.l, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f48795e.f48734b;
                    i iVar2 = i.this;
                    d.b.g0.g.l.n.b(iVar2.l, iVar2.f48794h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, d.b.g0.g.l.o.b bVar) {
            this.f48791e = str;
            this.f48792f = str2;
            this.f48793g = bArr;
            this.f48794h = map;
            this.i = str3;
            this.j = i;
            this.k = i2;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c C = e.this.f48741a.C(false, this.f48791e, TextUtils.isEmpty(this.f48792f) ? this.f48793g : this.f48792f, d.b.g0.g.l.n.F("encoding", this.f48794h));
            if (!TextUtils.isEmpty(this.i)) {
                C.f48734b = this.i;
                C.f48733a = -2;
                d.b.g0.g.l.n.d(e.this.f48742b, this.i);
            } else {
                int i = this.j;
                if (i != 7 && i != 12) {
                    C.f48734b = "fail encoding must be a string";
                    C.f48733a = -2;
                    d.b.g0.g.l.n.d(e.this.f48742b, C.f48734b);
                }
            }
            e.this.f48742b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48800h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48801e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48801e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f48798f), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48801e, "unlink:", j.this.f48799g);
                j jVar = j.this;
                if (d.b.g0.g.l.n.a(t, jVar.f48800h, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.b bVar = j.this.f48800h;
                    bVar.errMsg = "unlink:" + this.f48801e.f48734b;
                    j jVar2 = j.this;
                    d.b.g0.g.l.n.b(jVar2.f48800h, jVar2.f48799g);
                }
            }
        }

        public j(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48797e = str;
            this.f48798f = i;
            this.f48799g = map;
            this.f48800h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.z(this.f48797e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48804f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48805g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48806h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48807e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48807e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f48805g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f48806h), "targetPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48807e, "unzip:", k.this.i);
                k kVar = k.this;
                if (d.b.g0.g.l.n.a(t, kVar.j, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f48807e.f48734b;
                    k kVar2 = k.this;
                    d.b.g0.g.l.n.b(kVar2.j, kVar2.i);
                }
            }
        }

        public k(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48803e = str;
            this.f48804f = str2;
            this.f48805g = i;
            this.f48806h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.A(this.f48803e, this.f48804f)));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48810f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48811g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48812h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48813e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48813e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f48811g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f48812h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48813e, "saveFile:", l.this.i);
                l lVar = l.this;
                if (d.b.g0.g.l.n.a(t, lVar.j, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.g gVar = new d.b.g0.g.l.o.g();
                    List<String> list = this.f48813e.f48735c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f48813e.f48734b;
                    d.b.g0.g.l.n.b(gVar, l.this.i);
                }
            }
        }

        public l(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48809e = str;
            this.f48810f = str2;
            this.f48811g = i;
            this.f48812h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.x(this.f48809e, this.f48810f, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48816f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f48817g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.l.o.b f48818h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48819e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48819e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f48816f), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48819e, "readdir:", m.this.f48817g);
                m mVar = m.this;
                if (d.b.g0.g.l.n.a(t, mVar.f48818h, hashMap, e.this.f48742b)) {
                    d.b.g0.g.l.o.e eVar = new d.b.g0.g.l.o.e();
                    List<String> list = this.f48819e.f48735c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f48819e.f48735c.toArray(new String[size]);
                    eVar.errMsg = this.f48819e.f48734b;
                    d.b.g0.g.l.n.b(eVar, m.this.f48817g);
                }
            }
        }

        public m(String str, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48815e = str;
            this.f48816f = i;
            this.f48817g = map;
            this.f48818h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.s(this.f48815e, false)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f48822f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48823g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f48824h;
        public final /* synthetic */ d.b.g0.g.l.o.b i;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48825e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48825e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f48823g), "dirPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48825e, "rmdir:", n.this.f48824h);
                n nVar = n.this;
                if (d.b.g0.g.l.n.a(t, nVar.i, hashMap, e.this.f48742b)) {
                    n nVar2 = n.this;
                    d.b.g0.g.l.n.b(nVar2.i, nVar2.f48824h);
                }
            }
        }

        public n(String str, Boolean bool, int i, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48821e = str;
            this.f48822f = bool;
            this.f48823g = i;
            this.f48824h = map;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.v(this.f48821e, this.f48822f.booleanValue(), false)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48827e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48828f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48829g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48830h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48831e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48831e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f48830h), "filePath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48831e, "readFile:", o.this.i);
                o oVar = o.this;
                if (d.b.g0.g.l.n.a(t, oVar.j, hashMap, e.this.f48742b)) {
                    if (TextUtils.isEmpty(o.this.f48828f)) {
                        d.b.g0.g.l.o.a aVar = new d.b.g0.g.l.o.a();
                        d.b.g0.g.l.c cVar = this.f48831e;
                        if (cVar.f48740h == null) {
                            cVar.f48740h = new byte[0];
                        }
                        byte[] bArr = this.f48831e.f48740h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f48831e.f48734b;
                        d.b.g0.g.l.n.b(aVar, o.this.i);
                        return;
                    }
                    List<String> list = this.f48831e.f48735c;
                    String str = list != null ? list.get(0) : null;
                    d.b.g0.g.l.o.f fVar = new d.b.g0.g.l.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f48831e.f48734b;
                    d.b.g0.g.l.n.b(fVar, o.this.i);
                }
            }
        }

        public o(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48827e = str;
            this.f48828f = str2;
            this.f48829g = i;
            this.f48830h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.l.c q = e.this.f48741a.q(this.f48827e, this.f48828f, false);
            int i = this.f48829g;
            if (i != 7 && i != 12) {
                q.f48734b = "fail encoding must be a string";
                q.f48733a = -2;
                d.b.g0.g.l.n.d(e.this.f48742b, q.f48734b);
            }
            e.this.f48742b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48833e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48834f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48835g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48836h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ d.b.g0.g.l.o.b j;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.l.c f48837e;

            public a(d.b.g0.g.l.c cVar) {
                this.f48837e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f48835g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f48836h), "newPath");
                d.b.g0.g.l.b t = d.b.g0.g.l.n.t(this.f48837e, "rename:", p.this.i);
                p pVar = p.this;
                if (d.b.g0.g.l.n.a(t, pVar.j, hashMap, e.this.f48742b)) {
                    p pVar2 = p.this;
                    d.b.g0.g.l.n.b(pVar2.j, pVar2.i);
                }
            }
        }

        public p(String str, String str2, int i, int i2, Map map, d.b.g0.g.l.o.b bVar) {
            this.f48833e = str;
            this.f48834f = str2;
            this.f48835g = i;
            this.f48836h = i2;
            this.i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f48742b.runOnJSThread(new a(e.this.f48741a.u(this.f48833e, this.f48834f, false)));
        }
    }

    public e(d.b.g0.g.i.a aVar) {
        this.f48742b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48743c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("encoding", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int L3 = d.b.g0.g.l.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.b.g0.g.l.n.u(L3);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        this.f48741a = new d.b.g0.g.l.f(AppRuntime.getAppContext(), d.b.g0.a.z0.f.V().h(), lVar);
        this.f48743c = d.b.g0.g.l.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("srcPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("destPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("srcPath", G);
            String F2 = d.b.g0.g.l.n.F("destPath", G);
            this.f48743c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.b.g0.g.l.o.b bVar;
        Map<String, Object> G;
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.b.g0.g.l.n.G(this.f48741a, jsObject, (bVar = new d.b.g0.g.l.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f48743c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48743c.h(new a(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("encoding", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.c q = this.f48741a.q(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48742b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f48733a != 0 || (list = q.f48735c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48743c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.c s = this.f48741a.s(str, true);
            d.b.g0.g.l.n.Z(this.f48742b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f48733a != 0) {
                return new String[0];
            }
            List<String> list = s.f48735c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f48735c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f48743c.h(new h(d.b.g0.g.l.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("oldPath", jsObject);
            int L2 = d.b.g0.g.l.n.L("newPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("oldPath", G);
            String F2 = d.b.g0.g.l.n.F("newPath", G);
            this.f48743c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str, str2);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("dirPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("dirPath", G);
            this.f48743c.h(new n(F, (Boolean) d.b.g0.g.l.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("tempFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("tempFilePath", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.b.g0.g.l.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("path", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("path", G);
            this.f48743c.h(new RunnableC0993e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.b.g0.g.l.j statSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.c y = this.f48741a.y(str, true);
            d.b.g0.g.l.n.Z(this.f48742b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f48733a != 0) {
                return null;
            }
            return y.f48736d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("zipFilePath", jsObject);
            int L2 = d.b.g0.g.l.n.L("targetPath", jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("zipFilePath", G);
            String F2 = d.b.g0.g.l.n.F("targetPath", G);
            this.f48743c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.b.g0.g.l.n.L("filePath", jsObject);
            String u = d.b.g0.g.l.n.u(d.b.g0.g.l.n.L("data", jsObject));
            int L2 = d.b.g0.g.l.n.L("encoding", jsObject);
            byte[] p2 = d.b.g0.g.l.n.p(jsObject);
            d.b.g0.g.l.o.b bVar = new d.b.g0.g.l.o.b();
            Map<String, Object> G = d.b.g0.g.l.n.G(this.f48741a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.b.g0.g.l.n.F("data", G);
            String F2 = d.b.g0.g.l.n.F("filePath", G);
            this.f48743c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str, str2);
            d.b.g0.g.l.c x = this.f48741a.x(str, str2, true);
            d.b.g0.g.l.n.Z(this.f48742b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f48733a != 0 || (list = x.f48735c) == null) {
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
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.n.Z(this.f48742b, this.f48741a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.b.g0.g.l.n.P(this.f48741a, this.f48742b, null, null)) {
            this.f48743c.k(str);
            d.b.g0.g.l.c q = this.f48741a.q(str, null, true);
            d.b.g0.g.l.n.Z(this.f48742b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f48740h == null) {
                q.f48740h = new byte[0];
            }
            byte[] bArr = q.f48740h;
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
