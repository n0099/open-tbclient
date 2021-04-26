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
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public final n f64947b;

    /* renamed from: d  reason: collision with root package name */
    public final h f64949d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f64946a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f64948c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f64950e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f64951f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f64952g = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f64954f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f64955g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f64956h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f64957i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
            this.f64953e = str;
            this.f64954f = kVar;
            this.f64955g = jVar;
            this.f64956h = i2;
            this.f64957i = i3;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f64953e, this.f64954f, this.f64955g, this.f64956h, this.f64957i, this.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f64958e;

        public b(d dVar, k kVar) {
            this.f64958e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64958e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f64959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f64960f;

        public c(d dVar, k kVar, i iVar) {
            this.f64959e = kVar;
            this.f64960f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64959e.a(this.f64960f, true);
            this.f64959e.b();
        }
    }

    /* renamed from: d.b.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1768d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f64962f;

        /* renamed from: d.b.c.b.b.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f64964e;

            public a(o oVar) {
                this.f64964e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1768d c1768d = C1768d.this;
                d.this.j(c1768d.f64961e, this.f64964e, c1768d.f64962f);
            }
        }

        /* renamed from: d.b.c.b.b.d$d$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f64966e;

            public b(o oVar) {
                this.f64966e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1768d c1768d = C1768d.this;
                d.this.i(c1768d.f64961e, this.f64966e);
            }
        }

        public C1768d(String str, k kVar) {
            this.f64961e = str;
            this.f64962f = kVar;
        }

        @Override // d.b.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f64946a.execute(new a(oVar));
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f64946a.execute(new b(oVar));
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64968e;

        public f(String str) {
            this.f64968e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f64951f.get(this.f64968e);
            if (gVar != null) {
                for (i iVar : gVar.f64973d) {
                    if (iVar.f64975b != null) {
                        if (gVar.b() == null) {
                            iVar.f64976c = gVar.f64970a.f65081b.f65105b;
                            iVar.f64974a = gVar.f64971b;
                            iVar.f64975b.a(iVar, false);
                        } else {
                            iVar.f64975b.b(gVar.g());
                        }
                        iVar.f64975b.b();
                    }
                }
            }
            d.this.f64951f.remove(this.f64968e);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f64970a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f64971b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f64972c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f64973d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f64973d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f64972c;
        }

        public void d(i iVar) {
            this.f64973d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f64970a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f64972c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f64970a;
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        String a(String str, int i2, int i3, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap, byte[] bArr);

        byte[] a(String str);

        Bitmap b(String str);
    }

    /* loaded from: classes5.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f64974a;

        /* renamed from: b  reason: collision with root package name */
        public final k f64975b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f64976c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f64974a = bitmap;
            this.f64975b = kVar;
        }

        public Bitmap a() {
            return this.f64974a;
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
        this.f64947b = nVar;
        this.f64949d = hVar == null ? new d.b.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1768d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f64949d.a(str, i2, i3, scaleType);
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
        this.f64951f.put(str, gVar);
        this.f64952g.postDelayed(new f(str), this.f64948c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f64946a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f64950e.remove(str);
        if (remove != null) {
            remove.f(oVar.f65082c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f65081b;
        this.f64949d.a(str, oVar.f65080a, (aVar == null || !kVar.a(aVar.f65105b)) ? new byte[0] : oVar.f65081b.f65105b);
        g remove = this.f64950e.remove(str);
        if (remove != null) {
            remove.f64971b = oVar.f65080a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f64952g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f64949d.b(b2);
        byte[] a2 = this.f64949d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f64950e.get(b2);
            if (gVar == null) {
                gVar = this.f64951f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f64947b.a(a3);
            this.f64950e.put(b2, new g(a3, iVar));
            return;
        }
        this.f64952g.post(new c(this, kVar, new i(this, this.f64949d.a(b2), b3, str, null, null)));
    }
}
