package d.c.c.b.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.d.n;
import d.c.c.b.d.o;
import d.c.c.b.f.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public final n f66552b;

    /* renamed from: d  reason: collision with root package name */
    public final h f66554d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f66551a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f66553c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f66555e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f66556f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f66557g = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f66560g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f66561h;
        public final /* synthetic */ int i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i, int i2, ImageView.ScaleType scaleType) {
            this.f66558e = str;
            this.f66559f = kVar;
            this.f66560g = jVar;
            this.f66561h = i;
            this.i = i2;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f66558e, this.f66559f, this.f66560g, this.f66561h, this.i, this.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f66562e;

        public b(d dVar, k kVar) {
            this.f66562e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66562e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f66563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f66564f;

        public c(d dVar, k kVar, i iVar) {
            this.f66563e = kVar;
            this.f66564f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66563e.a(this.f66564f, true);
            this.f66563e.b();
        }
    }

    /* renamed from: d.c.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1828d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66566f;

        /* renamed from: d.c.c.b.b.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f66568e;

            public a(o oVar) {
                this.f66568e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1828d c1828d = C1828d.this;
                d.this.j(c1828d.f66565e, this.f66568e, c1828d.f66566f);
            }
        }

        /* renamed from: d.c.c.b.b.d$d$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f66570e;

            public b(o oVar) {
                this.f66570e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1828d c1828d = C1828d.this;
                d.this.i(c1828d.f66565e, this.f66570e);
            }
        }

        public C1828d(String str, k kVar) {
            this.f66565e = str;
            this.f66566f = kVar;
        }

        @Override // d.c.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f66551a.execute(new a(oVar));
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f66551a.execute(new b(oVar));
        }
    }

    /* loaded from: classes5.dex */
    public class e extends d.c.c.b.b.e {
        public final /* synthetic */ j B;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, String str, o.a aVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, j jVar) {
            super(str, aVar, i, i2, scaleType, config);
            this.B = jVar;
        }

        @Override // d.c.c.b.b.e
        public Bitmap f(byte[] bArr) {
            j jVar = this.B;
            return jVar != null ? jVar.a(bArr) : super.f(bArr);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66572e;

        public f(String str) {
            this.f66572e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f66556f.get(this.f66572e);
            if (gVar != null) {
                for (i iVar : gVar.f66577d) {
                    if (iVar.f66579b != null) {
                        if (gVar.b() == null) {
                            iVar.f66580c = gVar.f66574a.f66680b.f66704b;
                            iVar.f66578a = gVar.f66575b;
                            iVar.f66579b.a(iVar, false);
                        } else {
                            iVar.f66579b.b(gVar.g());
                        }
                        iVar.f66579b.b();
                    }
                }
            }
            d.this.f66556f.remove(this.f66572e);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f66574a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f66575b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f66576c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f66577d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f66577d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f66576c;
        }

        public void d(i iVar) {
            this.f66577d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f66574a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f66576c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f66574a;
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        String a(String str, int i, int i2, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap, byte[] bArr);

        byte[] a(String str);

        Bitmap b(String str);
    }

    /* loaded from: classes5.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f66578a;

        /* renamed from: b  reason: collision with root package name */
        public final k f66579b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f66580c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f66578a = bitmap;
            this.f66579b = kVar;
        }

        public Bitmap a() {
            return this.f66578a;
        }
    }

    /* loaded from: classes5.dex */
    public interface j {
        Bitmap a(byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public interface k extends o.a<Bitmap> {
        void a();

        void a(i iVar, boolean z);

        boolean a(byte[] bArr);

        void b();
    }

    public d(n nVar, h hVar) {
        this.f66552b = nVar;
        this.f66554d = hVar == null ? new d.c.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1828d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f66554d.a(str, i2, i3, scaleType);
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
        this.f66556f.put(str, gVar);
        this.f66557g.postDelayed(new f(str), this.f66553c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f66551a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f66555e.remove(str);
        if (remove != null) {
            remove.f(oVar.f66681c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f66680b;
        this.f66554d.a(str, oVar.f66679a, (aVar == null || !kVar.a(aVar.f66704b)) ? new byte[0] : oVar.f66680b.f66704b);
        g remove = this.f66555e.remove(str);
        if (remove != null) {
            remove.f66575b = oVar.f66679a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f66557g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f66554d.b(b2);
        byte[] a2 = this.f66554d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f66555e.get(b2);
            if (gVar == null) {
                gVar = this.f66556f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f66552b.a(a3);
            this.f66555e.put(b2, new g(a3, iVar));
            return;
        }
        this.f66557g.post(new c(this, kVar, new i(this, this.f66554d.a(b2), b3, str, null, null)));
    }
}
