package d.b.c.b.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
import d.b.c.b.f.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public final n f69407b;

    /* renamed from: d  reason: collision with root package name */
    public final h f69409d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f69406a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f69408c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f69410e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f69411f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f69412g = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f69414f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f69415g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f69416h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f69417i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
            this.f69413e = str;
            this.f69414f = kVar;
            this.f69415g = jVar;
            this.f69416h = i2;
            this.f69417i = i3;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f69413e, this.f69414f, this.f69415g, this.f69416h, this.f69417i, this.j);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f69418e;

        public b(d dVar, k kVar) {
            this.f69418e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69418e.a();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f69419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f69420f;

        public c(d dVar, k kVar, i iVar) {
            this.f69419e = kVar;
            this.f69420f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69419e.a(this.f69420f, true);
            this.f69419e.b();
        }
    }

    /* renamed from: d.b.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1895d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f69422f;

        /* renamed from: d.b.c.b.b.d$d$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f69424e;

            public a(o oVar) {
                this.f69424e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1895d c1895d = C1895d.this;
                d.this.j(c1895d.f69421e, this.f69424e, c1895d.f69422f);
            }
        }

        /* renamed from: d.b.c.b.b.d$d$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f69426e;

            public b(o oVar) {
                this.f69426e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1895d c1895d = C1895d.this;
                d.this.i(c1895d.f69421e, this.f69426e);
            }
        }

        public C1895d(String str, k kVar) {
            this.f69421e = str;
            this.f69422f = kVar;
        }

        @Override // d.b.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f69406a.execute(new a(oVar));
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f69406a.execute(new b(oVar));
        }
    }

    /* loaded from: classes6.dex */
    public class e extends d.b.c.b.b.e {
        public final /* synthetic */ j B;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, String str, o.a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config, j jVar) {
            super(str, aVar, i2, i3, scaleType, config);
            this.B = jVar;
        }

        @Override // d.b.c.b.b.e
        public Bitmap f(byte[] bArr) {
            j jVar = this.B;
            return jVar != null ? jVar.a(bArr) : super.f(bArr);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69428e;

        public f(String str) {
            this.f69428e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f69411f.get(this.f69428e);
            if (gVar != null) {
                for (i iVar : gVar.f69433d) {
                    if (iVar.f69435b != null) {
                        if (gVar.b() == null) {
                            iVar.f69436c = gVar.f69430a.f69541b.f69565b;
                            iVar.f69434a = gVar.f69431b;
                            iVar.f69435b.a(iVar, false);
                        } else {
                            iVar.f69435b.b(gVar.g());
                        }
                        iVar.f69435b.b();
                    }
                }
            }
            d.this.f69411f.remove(this.f69428e);
        }
    }

    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f69430a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f69431b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f69432c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f69433d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f69433d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f69432c;
        }

        public void d(i iVar) {
            this.f69433d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f69430a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f69432c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f69430a;
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        String a(String str, int i2, int i3, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap, byte[] bArr);

        byte[] a(String str);

        Bitmap b(String str);
    }

    /* loaded from: classes6.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f69434a;

        /* renamed from: b  reason: collision with root package name */
        public final k f69435b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f69436c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f69434a = bitmap;
            this.f69435b = kVar;
        }

        public Bitmap a() {
            return this.f69434a;
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        Bitmap a(byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface k extends o.a<Bitmap> {
        void a();

        void a(i iVar, boolean z);

        boolean a(byte[] bArr);

        void b();
    }

    public d(n nVar, h hVar) {
        this.f69407b = nVar;
        this.f69409d = hVar == null ? new d.b.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1895d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f69409d.a(str, i2, i3, scaleType);
        if (TextUtils.isEmpty(a2)) {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("#W");
            sb.append(i2);
            sb.append("#H");
            sb.append(i3);
            sb.append("#S");
            sb.append(scaleType.ordinal());
            sb.append(str);
            return sb.toString();
        }
        return a2;
    }

    public final void e(String str, g gVar) {
        this.f69411f.put(str, gVar);
        this.f69412g.postDelayed(new f(str), this.f69408c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f69406a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f69410e.remove(str);
        if (remove != null) {
            remove.f(oVar.f69542c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f69541b;
        this.f69409d.a(str, oVar.f69540a, (aVar == null || !kVar.a(aVar.f69565b)) ? new byte[0] : oVar.f69541b.f69565b);
        g remove = this.f69410e.remove(str);
        if (remove != null) {
            remove.f69431b = oVar.f69540a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f69412g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f69409d.b(b2);
        byte[] a2 = this.f69409d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f69410e.get(b2);
            if (gVar == null) {
                gVar = this.f69411f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f69407b.a(a3);
            this.f69410e.put(b2, new g(a3, iVar));
            return;
        }
        this.f69412g.post(new c(this, kVar, new i(this, this.f69409d.a(b2), b3, str, null, null)));
    }
}
