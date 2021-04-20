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
    public final n f66457b;

    /* renamed from: d  reason: collision with root package name */
    public final h f66459d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f66456a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f66458c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f66460e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f66461f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f66462g = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f66465g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f66466h;
        public final /* synthetic */ int i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i, int i2, ImageView.ScaleType scaleType) {
            this.f66463e = str;
            this.f66464f = kVar;
            this.f66465g = jVar;
            this.f66466h = i;
            this.i = i2;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f66463e, this.f66464f, this.f66465g, this.f66466h, this.i, this.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f66467e;

        public b(d dVar, k kVar) {
            this.f66467e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66467e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f66468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f66469f;

        public c(d dVar, k kVar, i iVar) {
            this.f66468e = kVar;
            this.f66469f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66468e.a(this.f66469f, true);
            this.f66468e.b();
        }
    }

    /* renamed from: d.c.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1825d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66471f;

        /* renamed from: d.c.c.b.b.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f66473e;

            public a(o oVar) {
                this.f66473e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1825d c1825d = C1825d.this;
                d.this.j(c1825d.f66470e, this.f66473e, c1825d.f66471f);
            }
        }

        /* renamed from: d.c.c.b.b.d$d$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f66475e;

            public b(o oVar) {
                this.f66475e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1825d c1825d = C1825d.this;
                d.this.i(c1825d.f66470e, this.f66475e);
            }
        }

        public C1825d(String str, k kVar) {
            this.f66470e = str;
            this.f66471f = kVar;
        }

        @Override // d.c.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f66456a.execute(new a(oVar));
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f66456a.execute(new b(oVar));
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
        public final /* synthetic */ String f66477e;

        public f(String str) {
            this.f66477e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f66461f.get(this.f66477e);
            if (gVar != null) {
                for (i iVar : gVar.f66482d) {
                    if (iVar.f66484b != null) {
                        if (gVar.b() == null) {
                            iVar.f66485c = gVar.f66479a.f66585b.f66609b;
                            iVar.f66483a = gVar.f66480b;
                            iVar.f66484b.a(iVar, false);
                        } else {
                            iVar.f66484b.b(gVar.g());
                        }
                        iVar.f66484b.b();
                    }
                }
            }
            d.this.f66461f.remove(this.f66477e);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f66479a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f66480b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f66481c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f66482d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f66482d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f66481c;
        }

        public void d(i iVar) {
            this.f66482d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f66479a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f66481c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f66479a;
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
        public Bitmap f66483a;

        /* renamed from: b  reason: collision with root package name */
        public final k f66484b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f66485c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f66483a = bitmap;
            this.f66484b = kVar;
        }

        public Bitmap a() {
            return this.f66483a;
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
        this.f66457b = nVar;
        this.f66459d = hVar == null ? new d.c.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1825d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f66459d.a(str, i2, i3, scaleType);
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
        this.f66461f.put(str, gVar);
        this.f66462g.postDelayed(new f(str), this.f66458c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f66456a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f66460e.remove(str);
        if (remove != null) {
            remove.f(oVar.f66586c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f66585b;
        this.f66459d.a(str, oVar.f66584a, (aVar == null || !kVar.a(aVar.f66609b)) ? new byte[0] : oVar.f66585b.f66609b);
        g remove = this.f66460e.remove(str);
        if (remove != null) {
            remove.f66480b = oVar.f66584a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f66462g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f66459d.b(b2);
        byte[] a2 = this.f66459d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f66460e.get(b2);
            if (gVar == null) {
                gVar = this.f66461f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f66457b.a(a3);
            this.f66460e.put(b2, new g(a3, iVar));
            return;
        }
        this.f66462g.post(new c(this, kVar, new i(this, this.f66459d.a(b2), b3, str, null, null)));
    }
}
