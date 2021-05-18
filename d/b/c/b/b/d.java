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
    public final n f65633b;

    /* renamed from: d  reason: collision with root package name */
    public final h f65635d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f65632a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f65634c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f65636e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f65637f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f65638g = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f65641g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65642h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f65643i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
            this.f65639e = str;
            this.f65640f = kVar;
            this.f65641g = jVar;
            this.f65642h = i2;
            this.f65643i = i3;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f65639e, this.f65640f, this.f65641g, this.f65642h, this.f65643i, this.j);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65644e;

        public b(d dVar, k kVar) {
            this.f65644e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65644e.a();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f65646f;

        public c(d dVar, k kVar, i iVar) {
            this.f65645e = kVar;
            this.f65646f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65645e.a(this.f65646f, true);
            this.f65645e.b();
        }
    }

    /* renamed from: d.b.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1832d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65648f;

        /* renamed from: d.b.c.b.b.d$d$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65650e;

            public a(o oVar) {
                this.f65650e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1832d c1832d = C1832d.this;
                d.this.j(c1832d.f65647e, this.f65650e, c1832d.f65648f);
            }
        }

        /* renamed from: d.b.c.b.b.d$d$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65652e;

            public b(o oVar) {
                this.f65652e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1832d c1832d = C1832d.this;
                d.this.i(c1832d.f65647e, this.f65652e);
            }
        }

        public C1832d(String str, k kVar) {
            this.f65647e = str;
            this.f65648f = kVar;
        }

        @Override // d.b.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f65632a.execute(new a(oVar));
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f65632a.execute(new b(oVar));
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
        public final /* synthetic */ String f65654e;

        public f(String str) {
            this.f65654e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f65637f.get(this.f65654e);
            if (gVar != null) {
                for (i iVar : gVar.f65659d) {
                    if (iVar.f65661b != null) {
                        if (gVar.b() == null) {
                            iVar.f65662c = gVar.f65656a.f65767b.f65791b;
                            iVar.f65660a = gVar.f65657b;
                            iVar.f65661b.a(iVar, false);
                        } else {
                            iVar.f65661b.b(gVar.g());
                        }
                        iVar.f65661b.b();
                    }
                }
            }
            d.this.f65637f.remove(this.f65654e);
        }
    }

    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f65656a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f65657b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f65658c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f65659d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f65659d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f65658c;
        }

        public void d(i iVar) {
            this.f65659d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f65656a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f65658c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f65656a;
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
        public Bitmap f65660a;

        /* renamed from: b  reason: collision with root package name */
        public final k f65661b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f65662c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f65660a = bitmap;
            this.f65661b = kVar;
        }

        public Bitmap a() {
            return this.f65660a;
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
        this.f65633b = nVar;
        this.f65635d = hVar == null ? new d.b.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1832d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f65635d.a(str, i2, i3, scaleType);
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
        this.f65637f.put(str, gVar);
        this.f65638g.postDelayed(new f(str), this.f65634c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65632a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f65636e.remove(str);
        if (remove != null) {
            remove.f(oVar.f65768c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f65767b;
        this.f65635d.a(str, oVar.f65766a, (aVar == null || !kVar.a(aVar.f65791b)) ? new byte[0] : oVar.f65767b.f65791b);
        g remove = this.f65636e.remove(str);
        if (remove != null) {
            remove.f65657b = oVar.f65766a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65638g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f65635d.b(b2);
        byte[] a2 = this.f65635d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f65636e.get(b2);
            if (gVar == null) {
                gVar = this.f65637f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f65633b.a(a3);
            this.f65636e.put(b2, new g(a3, iVar));
            return;
        }
        this.f65638g.post(new c(this, kVar, new i(this, this.f65635d.a(b2), b3, str, null, null)));
    }
}
