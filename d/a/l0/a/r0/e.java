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
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.r0.f f44276a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.l0.a f44277b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.r0.i f44278c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f44280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44282h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44283i;

        /* renamed from: d.a.l0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0804a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44284e;

            public RunnableC0804a(d.a.l0.a.r0.c cVar) {
                this.f44284e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(a.this.f44281g), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44284e, "mkdir:", a.this.f44282h);
                a aVar = a.this;
                if (d.a.l0.a.r0.n.a(t, aVar.f44283i, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.b bVar = a.this.f44283i;
                    bVar.errMsg = "mkdir:" + this.f44284e.f44269b;
                    a aVar2 = a.this;
                    d.a.l0.a.r0.n.b(aVar2.f44283i, aVar2.f44282h);
                }
            }
        }

        public a(String str, Boolean bool, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44279e = str;
            this.f44280f = bool;
            this.f44281g = i2;
            this.f44282h = map;
            this.f44283i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new RunnableC0804a(e.this.f44276a.o(this.f44279e, this.f44280f.booleanValue(), false)));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44286e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44287f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44288g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44289h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44290i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44291e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44291e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(b.this.f44288g), "srcPath");
                hashMap.put(Integer.valueOf(b.this.f44289h), "destPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44291e, "copyFile:", b.this.f44290i);
                b bVar = b.this;
                if (d.a.l0.a.r0.n.a(t, bVar.j, hashMap, e.this.f44277b)) {
                    b bVar2 = b.this;
                    d.a.l0.a.r0.n.b(bVar2.j, bVar2.f44290i);
                }
            }
        }

        public b(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44286e = str;
            this.f44287f = str2;
            this.f44288g = i2;
            this.f44289h = i3;
            this.f44290i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.c(this.f44286e, this.f44287f, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44294f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f44295g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44296h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44297i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.l0.a.r0.o.b l;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44298e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44298e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(c.this.k), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44298e, "appendFile:", c.this.f44296h);
                c cVar = c.this;
                if (d.a.l0.a.r0.n.a(t, cVar.l, hashMap, e.this.f44277b)) {
                    c cVar2 = c.this;
                    d.a.l0.a.r0.n.b(cVar2.l, cVar2.f44296h);
                }
            }
        }

        public c(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.l0.a.r0.o.b bVar) {
            this.f44293e = str;
            this.f44294f = str2;
            this.f44295g = bArr;
            this.f44296h = map;
            this.f44297i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c b2 = e.this.f44276a.b(this.f44293e, TextUtils.isEmpty(this.f44294f) ? this.f44295g : this.f44294f, d.a.l0.a.r0.n.F("encoding", this.f44296h), false);
            if (!TextUtils.isEmpty(this.f44297i)) {
                b2.f44269b = this.f44297i;
                b2.f44268a = -2;
                d.a.l0.a.r0.n.d(e.this.f44277b, this.f44297i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    b2.f44269b = "fail encoding must be a string";
                    b2.f44268a = -2;
                    d.a.l0.a.r0.n.d(e.this.f44277b, b2.f44269b);
                }
            }
            e.this.f44277b.runOnJSThread(new a(b2));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44301f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44302g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44303h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44305e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44305e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(d.this.f44301f), "path");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44305e, "access:", d.this.f44302g);
                d dVar = d.this;
                if (d.a.l0.a.r0.n.a(t, dVar.f44303h, hashMap, e.this.f44277b)) {
                    d dVar2 = d.this;
                    d.a.l0.a.r0.n.b(dVar2.f44303h, dVar2.f44302g);
                }
            }
        }

        public d(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44300e = str;
            this.f44301f = i2;
            this.f44302g = map;
            this.f44303h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.a(this.f44300e, false)));
        }
    }

    /* renamed from: d.a.l0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0805e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44308f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44309g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44310h;

        /* renamed from: d.a.l0.a.r0.e$e$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44312e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44312e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(RunnableC0805e.this.f44308f), "path");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44312e, "stat:", RunnableC0805e.this.f44309g);
                RunnableC0805e runnableC0805e = RunnableC0805e.this;
                if (d.a.l0.a.r0.n.a(t, runnableC0805e.f44310h, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.h hVar = new d.a.l0.a.r0.o.h();
                    d.a.l0.a.r0.c cVar = this.f44312e;
                    hVar.stats = cVar.f44271d;
                    hVar.errMsg = cVar.f44269b;
                    d.a.l0.a.r0.n.b(hVar, RunnableC0805e.this.f44309g);
                }
            }
        }

        public RunnableC0805e(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44307e = str;
            this.f44308f = i2;
            this.f44309g = map;
            this.f44310h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.y(this.f44307e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44316g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44317h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44319e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44319e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(f.this.f44315f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44319e, "getFileInfo:", f.this.f44316g);
                f fVar = f.this;
                if (d.a.l0.a.r0.n.a(t, fVar.f44317h, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.c cVar = new d.a.l0.a.r0.o.c();
                    cVar.errMsg = "getFileInfo:" + this.f44319e.f44269b;
                    d.a.l0.a.r0.c cVar2 = this.f44319e;
                    cVar.digest = cVar2.f44274g;
                    cVar.size = (int) cVar2.f44272e;
                    d.a.l0.a.r0.n.b(cVar, f.this.f44316g);
                }
            }
        }

        public f(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44314e = str;
            this.f44315f = i2;
            this.f44316g = map;
            this.f44317h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.e(this.f44314e)));
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f44321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44322f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44324e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44324e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44324e, "getSavedFileList:", g.this.f44321e);
                g gVar = g.this;
                if (d.a.l0.a.r0.n.a(t, gVar.f44322f, null, e.this.f44277b)) {
                    d.a.l0.a.r0.o.d dVar = new d.a.l0.a.r0.o.d();
                    List<d.a.l0.a.r0.d> list = this.f44324e.f44273f;
                    int size = list == null ? 0 : list.size();
                    dVar.fileList = size == 0 ? new d.a.l0.a.r0.d[0] : (d.a.l0.a.r0.d[]) this.f44324e.f44273f.toArray(new d.a.l0.a.r0.d[size]);
                    g gVar2 = g.this;
                    dVar.errMsg = gVar2.f44322f.errMsg;
                    d.a.l0.a.r0.n.b(dVar, gVar2.f44321e);
                }
            }
        }

        public g(Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44321e = map;
            this.f44322f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.i()));
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44328g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44329h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44331e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44331e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(h.this.f44327f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44331e, "removeSavedFile:", h.this.f44328g);
                h hVar = h.this;
                if (d.a.l0.a.r0.n.a(t, hVar.f44329h, hashMap, e.this.f44277b)) {
                    h hVar2 = h.this;
                    d.a.l0.a.r0.n.b(hVar2.f44329h, hVar2.f44328g);
                }
            }
        }

        public h(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44326e = str;
            this.f44327f = i2;
            this.f44328g = map;
            this.f44329h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.t(this.f44326e)));
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f44335g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44336h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44337i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.l0.a.r0.o.b l;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44338e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44338e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i.this.k), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44338e, "writeFile:", i.this.f44336h);
                i iVar = i.this;
                if (d.a.l0.a.r0.n.a(t, iVar.l, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.b bVar = i.this.l;
                    bVar.errMsg = "writeFile:" + this.f44338e.f44269b;
                    i iVar2 = i.this;
                    d.a.l0.a.r0.n.b(iVar2.l, iVar2.f44336h);
                }
            }
        }

        public i(String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.l0.a.r0.o.b bVar) {
            this.f44333e = str;
            this.f44334f = str2;
            this.f44335g = bArr;
            this.f44336h = map;
            this.f44337i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c C = e.this.f44276a.C(false, this.f44333e, TextUtils.isEmpty(this.f44334f) ? this.f44335g : this.f44334f, d.a.l0.a.r0.n.F("encoding", this.f44336h));
            if (!TextUtils.isEmpty(this.f44337i)) {
                C.f44269b = this.f44337i;
                C.f44268a = -2;
                d.a.l0.a.r0.n.d(e.this.f44277b, this.f44337i);
            } else {
                int i2 = this.j;
                if (i2 != 7 && i2 != 12) {
                    C.f44269b = "fail encoding must be a string";
                    C.f44268a = -2;
                    d.a.l0.a.r0.n.d(e.this.f44277b, C.f44269b);
                }
            }
            e.this.f44277b.runOnJSThread(new a(C));
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44340e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44341f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44342g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44343h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44345e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44345e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(j.this.f44341f), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44345e, "unlink:", j.this.f44342g);
                j jVar = j.this;
                if (d.a.l0.a.r0.n.a(t, jVar.f44343h, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.b bVar = j.this.f44343h;
                    bVar.errMsg = "unlink:" + this.f44345e.f44269b;
                    j jVar2 = j.this;
                    d.a.l0.a.r0.n.b(jVar2.f44343h, jVar2.f44342g);
                }
            }
        }

        public j(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44340e = str;
            this.f44341f = i2;
            this.f44342g = map;
            this.f44343h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.z(this.f44340e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44348f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44349g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44350h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44351i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44352e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44352e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(k.this.f44349g), "zipFilePath");
                hashMap.put(Integer.valueOf(k.this.f44350h), "targetPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44352e, "unzip:", k.this.f44351i);
                k kVar = k.this;
                if (d.a.l0.a.r0.n.a(t, kVar.j, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.b bVar = k.this.j;
                    bVar.errMsg = "unzip:" + this.f44352e.f44269b;
                    k kVar2 = k.this;
                    d.a.l0.a.r0.n.b(kVar2.j, kVar2.f44351i);
                }
            }
        }

        public k(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44347e = str;
            this.f44348f = str2;
            this.f44349g = i2;
            this.f44350h = i3;
            this.f44351i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.A(this.f44347e, this.f44348f)));
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44356g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44357h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44358i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44359e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44359e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(l.this.f44356g), "tempFilePath");
                hashMap.put(Integer.valueOf(l.this.f44357h), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44359e, "saveFile:", l.this.f44358i);
                l lVar = l.this;
                if (d.a.l0.a.r0.n.a(t, lVar.j, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.g gVar = new d.a.l0.a.r0.o.g();
                    List<String> list = this.f44359e.f44270c;
                    gVar.savedFilePath = list != null ? list.get(0) : null;
                    gVar.errMsg = this.f44359e.f44269b;
                    d.a.l0.a.r0.n.b(gVar, l.this.f44358i);
                }
            }
        }

        public l(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44354e = str;
            this.f44355f = str2;
            this.f44356g = i2;
            this.f44357h = i3;
            this.f44358i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.x(this.f44354e, this.f44355f, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f44363g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44364h;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44366e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44366e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(m.this.f44362f), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44366e, "readdir:", m.this.f44363g);
                m mVar = m.this;
                if (d.a.l0.a.r0.n.a(t, mVar.f44364h, hashMap, e.this.f44277b)) {
                    d.a.l0.a.r0.o.e eVar = new d.a.l0.a.r0.o.e();
                    List<String> list = this.f44366e.f44270c;
                    int size = list == null ? 0 : list.size();
                    eVar.files = size == 0 ? new String[0] : (String[]) this.f44366e.f44270c.toArray(new String[size]);
                    eVar.errMsg = this.f44366e.f44269b;
                    d.a.l0.a.r0.n.b(eVar, m.this.f44363g);
                }
            }
        }

        public m(String str, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44361e = str;
            this.f44362f = i2;
            this.f44363g = map;
            this.f44364h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.s(this.f44361e, false)));
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f44369f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44370g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f44371h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.r0.o.b f44372i;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44373e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44373e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(n.this.f44370g), "dirPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44373e, "rmdir:", n.this.f44371h);
                n nVar = n.this;
                if (d.a.l0.a.r0.n.a(t, nVar.f44372i, hashMap, e.this.f44277b)) {
                    n nVar2 = n.this;
                    d.a.l0.a.r0.n.b(nVar2.f44372i, nVar2.f44371h);
                }
            }
        }

        public n(String str, Boolean bool, int i2, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44368e = str;
            this.f44369f = bool;
            this.f44370g = i2;
            this.f44371h = map;
            this.f44372i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.v(this.f44368e, this.f44369f.booleanValue(), false)));
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44378h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44379i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44380e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44380e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(o.this.f44378h), "filePath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44380e, "readFile:", o.this.f44379i);
                o oVar = o.this;
                if (d.a.l0.a.r0.n.a(t, oVar.j, hashMap, e.this.f44277b)) {
                    if (TextUtils.isEmpty(o.this.f44376f)) {
                        d.a.l0.a.r0.o.a aVar = new d.a.l0.a.r0.o.a();
                        d.a.l0.a.r0.c cVar = this.f44380e;
                        if (cVar.f44275h == null) {
                            cVar.f44275h = new byte[0];
                        }
                        byte[] bArr = this.f44380e.f44275h;
                        aVar.data = new JsArrayBuffer(bArr, bArr.length);
                        aVar.errMsg = this.f44380e.f44269b;
                        d.a.l0.a.r0.n.b(aVar, o.this.f44379i);
                        return;
                    }
                    List<String> list = this.f44380e.f44270c;
                    String str = list != null ? list.get(0) : null;
                    d.a.l0.a.r0.o.f fVar = new d.a.l0.a.r0.o.f();
                    fVar.data = str;
                    fVar.errMsg = this.f44380e.f44269b;
                    d.a.l0.a.r0.n.b(fVar, o.this.f44379i);
                }
            }
        }

        public o(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44375e = str;
            this.f44376f = str2;
            this.f44377g = i2;
            this.f44378h = i3;
            this.f44379i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.r0.c q = e.this.f44276a.q(this.f44375e, this.f44376f, false);
            int i2 = this.f44377g;
            if (i2 != 7 && i2 != 12) {
                q.f44269b = "fail encoding must be a string";
                q.f44268a = -2;
                d.a.l0.a.r0.n.d(e.this.f44277b, q.f44269b);
            }
            e.this.f44277b.runOnJSThread(new a(q));
        }
    }

    /* loaded from: classes2.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44384g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44385h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f44386i;
        public final /* synthetic */ d.a.l0.a.r0.o.b j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.r0.c f44387e;

            public a(d.a.l0.a.r0.c cVar) {
                this.f44387e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(p.this.f44384g), "oldPath");
                hashMap.put(Integer.valueOf(p.this.f44385h), "newPath");
                d.a.l0.a.r0.b t = d.a.l0.a.r0.n.t(this.f44387e, "rename:", p.this.f44386i);
                p pVar = p.this;
                if (d.a.l0.a.r0.n.a(t, pVar.j, hashMap, e.this.f44277b)) {
                    p pVar2 = p.this;
                    d.a.l0.a.r0.n.b(pVar2.j, pVar2.f44386i);
                }
            }
        }

        public p(String str, String str2, int i2, int i3, Map map, d.a.l0.a.r0.o.b bVar) {
            this.f44382e = str;
            this.f44383f = str2;
            this.f44384g = i2;
            this.f44385h = i3;
            this.f44386i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f44277b.runOnJSThread(new a(e.this.f44276a.u(this.f44382e, this.f44383f, false)));
        }
    }

    public e(d.a.l0.a.l0.a aVar) {
        this.f44277b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("path", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("path", G);
            this.f44278c.h(new d(F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.l0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.l0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.l0.a.r0.n.u(L3);
            byte[] p2 = d.a.l0.a.r0.n.p(jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("data", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new c(F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        this.f44276a = new d.a.l0.a.r0.f(AppRuntime.getAppContext(), d.a.l0.a.g1.f.V().A(), lVar);
        this.f44278c = d.a.l0.a.r0.i.d();
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("destPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("srcPath", G);
            String F2 = d.a.l0.a.r0.n.F("destPath", G);
            this.f44278c.h(new b(F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str, str2);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new f(F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.l0.a.r0.o.b bVar;
        Map<String, Object> G;
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, (bVar = new d.a.l0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f44278c.h(new g(G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f44278c.h(new a(F, (Boolean) d.a.l0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("encoding", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("encoding", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new o(F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        List<String> list;
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.c q = this.f44276a.q(str, str2, true);
            d.a.l0.a.r0.n.Z(this.f44277b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.f44268a != 0 || (list = q.f44270c) == null) {
                return null;
            }
            return list.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f44278c.h(new m(F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.c s = this.f44276a.s(str, true);
            d.a.l0.a.r0.n.Z(this.f44277b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s == null || s.f44268a != 0) {
                return new String[0];
            }
            List<String> list = s.f44270c;
            int size = list == null ? 0 : list.size();
            return size == 0 ? new String[0] : (String[]) s.f44270c.toArray(new String[size]);
        }
        return null;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f44278c.h(new h(d.a.l0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("newPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("oldPath", G);
            String F2 = d.a.l0.a.r0.n.F("newPath", G);
            this.f44278c.h(new p(F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str, str2);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("dirPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("dirPath", G);
            this.f44278c.h(new n(F, (Boolean) d.a.l0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new l(F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, d.a.l0.a.r0.a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("path", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("path", G);
            this.f44278c.h(new RunnableC0805e(F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.l0.a.r0.j statSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.c y = this.f44276a.y(str, true);
            d.a.l0.a.r0.n.Z(this.f44277b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.f44268a != 0) {
                return null;
            }
            return y.f44271d;
        }
        return null;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new j(F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.l0.a.r0.n.L("targetPath", jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.l0.a.r0.n.F("targetPath", G);
            this.f44278c.h(new k(F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.l0.a.r0.n.L("filePath", jsObject);
            String u = d.a.l0.a.r0.n.u(d.a.l0.a.r0.n.L("data", jsObject));
            int L2 = d.a.l0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.l0.a.r0.n.p(jsObject);
            d.a.l0.a.r0.o.b bVar = new d.a.l0.a.r0.o.b();
            Map<String, Object> G = d.a.l0.a.r0.n.G(this.f44276a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.l0.a.r0.n.F("data", G);
            String F2 = d.a.l0.a.r0.n.F("filePath", G);
            this.f44278c.h(new i(F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        List<String> list;
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str, str2);
            d.a.l0.a.r0.c x = this.f44276a.x(str, str2, true);
            d.a.l0.a.r0.n.Z(this.f44277b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.f44268a != 0 || (list = x.f44270c) == null) {
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
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.n.Z(this.f44277b, this.f44276a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (d.a.l0.a.r0.n.P(this.f44276a, this.f44277b, null, null)) {
            this.f44278c.k(str);
            d.a.l0.a.r0.c q = this.f44276a.q(str, null, true);
            d.a.l0.a.r0.n.Z(this.f44277b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.f44275h == null) {
                q.f44275h = new byte[0];
            }
            byte[] bArr = q.f44275h;
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
