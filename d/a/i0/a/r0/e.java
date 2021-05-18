package d.a.i0.a.r0;

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
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.r0.f f44100a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.l0.a f44101b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.r0.i f44102c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f44104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44106h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44107i;

        /* renamed from: d.a.i0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0793a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44108e;

            public RunnableC0793a(d.a.i0.a.r0.c cVar) {
                this.f44108e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f44105g), "dirPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44108e, "mkdir:", a.this.f44106h);
                a aVar = a.this;
                if (d.a.i0.a.r0.n.a(t, aVar.f44107i, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.b bVar = a.this.f44107i;
                    bVar.errMsg = "mkdir:" + this.f44108e.f44093b;
                    a aVar2 = a.this;
                    d.a.i0.a.r0.n.b(aVar2.f44107i, aVar2.f44106h);
                }
            }
        }

        public a(String str, Boolean bool, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44103e = str;
            this.f44104f = bool;
            this.f44105g = i2;
            this.f44106h = map;
            this.f44107i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new RunnableC0793a(e.this.f44100a.o(this.f44103e, this.f44104f.booleanValue(), false)));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44111f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44112g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44113h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44114i;
        public final /* synthetic */ d.a.i0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44115e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44115e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f44112g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f44113h), "destPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44115e, "copyFile:", b.this.f44114i);
                b bVar = b.this;
                if (d.a.i0.a.r0.n.a(t, bVar.j, hashMap, e.this.f44101b)) {
                    b bVar2 = b.this;
                    d.a.i0.a.r0.n.b(bVar2.j, bVar2.f44114i);
                }
            }
        }

        public b(String str, String str2, int i2, int i3, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44110e = str;
            this.f44111f = str2;
            this.f44112g = i2;
            this.f44113h = i3;
            this.f44114i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.c(this.f44110e, this.f44111f, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f44119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44120h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44121i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.i0.a.r0.o.b l;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44122e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44122e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44122e, "appendFile:", c.this.f44120h);
                c cVar = c.this;
                if (d.a.i0.a.r0.n.a(t, cVar.l, hashMap, e.this.f44101b)) {
                    c cVar2 = c.this;
                    d.a.i0.a.r0.n.b(cVar2.l, cVar2.f44120h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.i0.a.r0.o.b bVar) {
            this.f44117e = str;
            this.f44118f = str2;
            this.f44119g = bArr;
            this.f44120h = map;
            this.f44121i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.r0.c b2 = e.this.f44100a.b(this.f44117e, TextUtils.isEmpty(this.f44118f) ? this.f44119g : this.f44118f, d.a.i0.a.r0.n.F("encoding", this.f44120h), false);
            if (!TextUtils.isEmpty(this.f44121i)) {
                b2.f44093b = this.f44121i;
                b2.f44092a = -2;
                d.a.i0.a.r0.n.d(e.this.f44101b, this.f44121i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    b2.f44093b = "fail encoding must be a string";
                    b2.f44092a = -2;
                    d.a.i0.a.r0.n.d(e.this.f44101b, b2.f44093b);
                }
            }
            e.this.f44101b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44126g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44127h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44129e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44129e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f44125f), "path");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44129e, "access:", d.this.f44126g);
                d dVar = d.this;
                if (d.a.i0.a.r0.n.a(t, dVar.f44127h, hashMap, e.this.f44101b)) {
                    d dVar2 = d.this;
                    d.a.i0.a.r0.n.b(dVar2.f44127h, dVar2.f44126g);
                }
            }
        }

        public d(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44124e = str;
            this.f44125f = i2;
            this.f44126g = map;
            this.f44127h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.a(this.f44124e, false)));
        }
    }

    /* renamed from: d.a.i0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0794e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44131e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44132f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44133g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44134h;

        /* renamed from: d.a.i0.a.r0.e$e$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44136e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44136e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0794e.this.f44132f), "path");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44136e, "stat:", RunnableC0794e.this.f44133g);
                RunnableC0794e runnableC0794e = RunnableC0794e.this;
                if (d.a.i0.a.r0.n.a(t, runnableC0794e.f44134h, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.h hVar = new d.a.i0.a.r0.o.h();
                    d.a.i0.a.r0.c cVar = this.f44136e;
                    hVar.stats = cVar.f44095d;
                    hVar.errMsg = cVar.f44093b;
                    d.a.i0.a.r0.n.b(hVar, RunnableC0794e.this.f44133g);
                }
            }
        }

        public RunnableC0794e(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44131e = str;
            this.f44132f = i2;
            this.f44133g = map;
            this.f44134h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.y(this.f44131e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44139f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44140g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44141h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44143e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44143e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f44139f), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44143e, "getFileInfo:", f.this.f44140g);
                f fVar = f.this;
                if (d.a.i0.a.r0.n.a(t, fVar.f44141h, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.c cVar = new d.a.i0.a.r0.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f44143e.f44093b;
                    d.a.i0.a.r0.c cVar2 = this.f44143e;
                    cVar.digest = cVar2.f44098g;
                    cVar.size = (int) cVar2.f44096e;
                    d.a.i0.a.r0.n.b(cVar, f.this.f44140g);
                }
            }
        }

        public f(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44138e = str;
            this.f44139f = i2;
            this.f44140g = map;
            this.f44141h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.e(this.f44138e)));
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f44145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44146f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44148e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44148e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44148e, "getSavedFileList:", g.this.f44145e);
                g gVar = g.this;
                if (d.a.i0.a.r0.n.a(t, gVar.f44146f, null, e.this.f44101b)) {
                    d.a.i0.a.r0.o.d dVar = new d.a.i0.a.r0.o.d();
                    List<d.a.i0.a.r0.d> list = this.f44148e.f44097f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.a.i0.a.r0.d[0] : (d.a.i0.a.r0.d[]) this.f44148e.f44097f.toArray(new d.a.i0.a.r0.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f44146f.errMsg;
                    d.a.i0.a.r0.n.b(dVar, gVar2.f44145e);
                }
            }
        }

        public g(Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44145e = map;
            this.f44146f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.i()));
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44151f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44152g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44153h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44155e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44155e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f44151f), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44155e, "removeSavedFile:", h.this.f44152g);
                h hVar = h.this;
                if (d.a.i0.a.r0.n.a(t, hVar.f44153h, hashMap, e.this.f44101b)) {
                    h hVar2 = h.this;
                    d.a.i0.a.r0.n.b(hVar2.f44153h, hVar2.f44152g);
                }
            }
        }

        public h(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44150e = str;
            this.f44151f = i2;
            this.f44152g = map;
            this.f44153h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.t(this.f44150e)));
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f44159g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44160h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44161i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.i0.a.r0.o.b l;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44162e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44162e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44162e, "writeFile:", i.this.f44160h);
                i iVar = i.this;
                if (d.a.i0.a.r0.n.a(t, iVar.l, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f44162e.f44093b;
                    i iVar2 = i.this;
                    d.a.i0.a.r0.n.b(iVar2.l, iVar2.f44160h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.i0.a.r0.o.b bVar) {
            this.f44157e = str;
            this.f44158f = str2;
            this.f44159g = bArr;
            this.f44160h = map;
            this.f44161i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.r0.c C = e.this.f44100a.C(false, this.f44157e, TextUtils.isEmpty(this.f44158f) ? this.f44159g : this.f44158f, d.a.i0.a.r0.n.F("encoding", this.f44160h));
            if (!TextUtils.isEmpty(this.f44161i)) {
                C.f44093b = this.f44161i;
                C.f44092a = -2;
                d.a.i0.a.r0.n.d(e.this.f44101b, this.f44161i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    C.f44093b = "fail encoding must be a string";
                    C.f44092a = -2;
                    d.a.i0.a.r0.n.d(e.this.f44101b, C.f44093b);
                }
            }
            e.this.f44101b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44167h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44169e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44169e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f44165f), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44169e, "unlink:", j.this.f44166g);
                j jVar = j.this;
                if (d.a.i0.a.r0.n.a(t, jVar.f44167h, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.b bVar = j.this.f44167h;
                    bVar.errMsg = "unlink:" + this.f44169e.f44093b;
                    j jVar2 = j.this;
                    d.a.i0.a.r0.n.b(jVar2.f44167h, jVar2.f44166g);
                }
            }
        }

        public j(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44164e = str;
            this.f44165f = i2;
            this.f44166g = map;
            this.f44167h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.z(this.f44164e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44172f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44173g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44174h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44175i;
        public final /* synthetic */ d.a.i0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44176e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44176e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f44173g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f44174h), "targetPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44176e, "unzip:", k.this.f44175i);
                k kVar = k.this;
                if (d.a.i0.a.r0.n.a(t, kVar.j, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f44176e.f44093b;
                    k kVar2 = k.this;
                    d.a.i0.a.r0.n.b(kVar2.j, kVar2.f44175i);
                }
            }
        }

        public k(String str, String str2, int i2, int i3, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44171e = str;
            this.f44172f = str2;
            this.f44173g = i2;
            this.f44174h = i3;
            this.f44175i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.A(this.f44171e, this.f44172f)));
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44178e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44179f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44180g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44181h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44182i;
        public final /* synthetic */ d.a.i0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44183e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44183e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f44180g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f44181h), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44183e, "saveFile:", l.this.f44182i);
                l lVar = l.this;
                if (d.a.i0.a.r0.n.a(t, lVar.j, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.g gVar = new d.a.i0.a.r0.o.g();
                    List<String> list = this.f44183e.f44094c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f44183e.f44093b;
                    d.a.i0.a.r0.n.b(gVar, l.this.f44182i);
                }
            }
        }

        public l(String str, String str2, int i2, int i3, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44178e = str;
            this.f44179f = str2;
            this.f44180g = i2;
            this.f44181h = i3;
            this.f44182i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.x(this.f44178e, this.f44179f, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44185e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44186f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44187g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44188h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44190e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44190e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f44186f), "dirPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44190e, "readdir:", m.this.f44187g);
                m mVar = m.this;
                if (d.a.i0.a.r0.n.a(t, mVar.f44188h, hashMap, e.this.f44101b)) {
                    d.a.i0.a.r0.o.e eVar = new d.a.i0.a.r0.o.e();
                    List<String> list = this.f44190e.f44094c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f44190e.f44094c.toArray(new String[size]);
                    eVar.errMsg = this.f44190e.f44093b;
                    d.a.i0.a.r0.n.b(eVar, m.this.f44187g);
                }
            }
        }

        public m(String str, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44185e = str;
            this.f44186f = i2;
            this.f44187g = map;
            this.f44188h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.s(this.f44185e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f44193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44194g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44195h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.r0.o.b f44196i;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44197e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44197e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f44194g), "dirPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44197e, "rmdir:", n.this.f44195h);
                n nVar = n.this;
                if (d.a.i0.a.r0.n.a(t, nVar.f44196i, hashMap, e.this.f44101b)) {
                    n nVar2 = n.this;
                    d.a.i0.a.r0.n.b(nVar2.f44196i, nVar2.f44195h);
                }
            }
        }

        public n(String str, Boolean bool, int i2, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44192e = str;
            this.f44193f = bool;
            this.f44194g = i2;
            this.f44195h = map;
            this.f44196i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.v(this.f44192e, this.f44193f.booleanValue(), false)));
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44200f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44201g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44202h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44203i;
        public final /* synthetic */ d.a.i0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44204e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44204e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f44202h), "filePath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44204e, "readFile:", o.this.f44203i);
                o oVar = o.this;
                if (d.a.i0.a.r0.n.a(t, oVar.j, hashMap, e.this.f44101b)) {
                    if (TextUtils.isEmpty(o.this.f44200f)) {
                        d.a.i0.a.r0.o.a aVar = new d.a.i0.a.r0.o.a();
                        d.a.i0.a.r0.c cVar = this.f44204e;
                        if (cVar.f44099h == null) {
                            cVar.f44099h = new byte[0];
                        }
                        byte[] bArr = this.f44204e.f44099h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f44204e.f44093b;
                        d.a.i0.a.r0.n.b(aVar, o.this.f44203i);
                        return;
                    }
                    List<String> list = this.f44204e.f44094c;
                    String str = list != null ? list.get(0) : null;
                    d.a.i0.a.r0.o.f fVar = new d.a.i0.a.r0.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f44204e.f44093b;
                    d.a.i0.a.r0.n.b(fVar, o.this.f44203i);
                }
            }
        }

        public o(String str, String str2, int i2, int i3, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44199e = str;
            this.f44200f = str2;
            this.f44201g = i2;
            this.f44202h = i3;
            this.f44203i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.r0.c q = e.this.f44100a.q(this.f44199e, this.f44200f, false);
            int i2 = this.f44201g;
            if (i2 != 7 && i2 != 12) {
                q.f44093b = "fail encoding must be a string";
                q.f44092a = -2;
                d.a.i0.a.r0.n.d(e.this.f44101b, q.f44093b);
            }
            e.this.f44101b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes2.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44207f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44208g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44209h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44210i;
        public final /* synthetic */ d.a.i0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.r0.c f44211e;

            public a(d.a.i0.a.r0.c cVar) {
                this.f44211e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f44208g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f44209h), "newPath");
                d.a.i0.a.r0.b t = d.a.i0.a.r0.n.t(this.f44211e, "rename:", p.this.f44210i);
                p pVar = p.this;
                if (d.a.i0.a.r0.n.a(t, pVar.j, hashMap, e.this.f44101b)) {
                    p pVar2 = p.this;
                    d.a.i0.a.r0.n.b(pVar2.j, pVar2.f44210i);
                }
            }
        }

        public p(String str, String str2, int i2, int i3, Map map, d.a.i0.a.r0.o.b bVar) {
            this.f44206e = str;
            this.f44207f = str2;
            this.f44208g = i2;
            this.f44209h = i3;
            this.f44210i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44101b.runOnJSThread(new a(e.this.f44100a.u(this.f44206e, this.f44207f, false)));
        }
    }

    public e(d.a.i0.a.l0.a aVar) {
        this.f44101b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("path", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("path", G);
            this.f44102c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.i0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.i0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.i0.a.r0.n.u(L3);
            byte[] p2 = d.a.i0.a.r0.n.p(jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("data", G);
            String F2 = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.i0.a.k2.f.d lVar;
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q != null) {
            lVar = Q.W();
        } else {
            lVar = new d.a.i0.a.r0.l();
        }
        this.f44100a = new d.a.i0.a.r0.f(AppRuntime.getAppContext(), d.a.i0.a.g1.f.V().A(), lVar);
        this.f44102c = d.a.i0.a.r0.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.i0.a.r0.n.L("destPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("srcPath", G);
            String F2 = d.a.i0.a.r0.n.F("destPath", G);
            this.f44102c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str, str2);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("filePath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.i0.a.r0.o.b bVar;
        Map<String, Object> G;
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, (bVar = new d.a.i0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f44102c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("dirPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("dirPath", G);
            this.f44102c.h(new a(F, (Boolean) d.a.i0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.i0.a.r0.n.L("encoding", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("encoding", G);
            String F2 = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.c q = this.f44100a.q(str, str2, true);
            d.a.i0.a.r0.n.Z(this.f44101b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f44092a != 0 || (list = q.f44094c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("dirPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("dirPath", G);
            this.f44102c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.c s = this.f44100a.s(str, true);
            d.a.i0.a.r0.n.Z(this.f44101b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f44092a != 0) {
                return new String[0];
            }
            List<String> list = s.f44094c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f44094c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("filePath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f44102c.h(new h(d.a.i0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.i0.a.r0.n.L("newPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("oldPath", G);
            String F2 = d.a.i0.a.r0.n.F("newPath", G);
            this.f44102c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str, str2);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("dirPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("dirPath", G);
            this.f44102c.h(new n(F, (Boolean) d.a.i0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.i0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.a.i0.a.r0.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("path", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("path", G);
            this.f44102c.h(new RunnableC0794e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.i0.a.r0.j statSync(String str) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.c y = this.f44100a.y(str, true);
            d.a.i0.a.r0.n.Z(this.f44101b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f44092a != 0) {
                return null;
            }
            return y.f44095d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("filePath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.i0.a.r0.n.L("targetPath", jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.i0.a.r0.n.F("targetPath", G);
            this.f44102c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.i0.a.r0.n.L("filePath", jsObject);
            String u = d.a.i0.a.r0.n.u(d.a.i0.a.r0.n.L("data", jsObject));
            int L2 = d.a.i0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.i0.a.r0.n.p(jsObject);
            d.a.i0.a.r0.o.b bVar = new d.a.i0.a.r0.o.b();
            Map<String, Object> G = d.a.i0.a.r0.n.G(this.f44100a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.i0.a.r0.n.F("data", G);
            String F2 = d.a.i0.a.r0.n.F("filePath", G);
            this.f44102c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str, str2);
            d.a.i0.a.r0.c x = this.f44100a.x(str, str2, true);
            d.a.i0.a.r0.n.Z(this.f44101b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f44092a != 0 || (list = x.f44094c) == null) {
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
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.n.Z(this.f44101b, this.f44100a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.a.i0.a.r0.n.P(this.f44100a, this.f44101b, null, null)) {
            this.f44102c.k(str);
            d.a.i0.a.r0.c q = this.f44100a.q(str, null, true);
            d.a.i0.a.r0.n.Z(this.f44101b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f44099h == null) {
                q.f44099h = new byte[0];
            }
            byte[] bArr = q.f44099h;
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
