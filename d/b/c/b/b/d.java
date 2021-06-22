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
    public final n f69511b;

    /* renamed from: d  reason: collision with root package name */
    public final h f69513d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f69510a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f69512c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f69514e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f69515f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f69516g = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f69518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f69519g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f69520h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f69521i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
            this.f69517e = str;
            this.f69518f = kVar;
            this.f69519g = jVar;
            this.f69520h = i2;
            this.f69521i = i3;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f69517e, this.f69518f, this.f69519g, this.f69520h, this.f69521i, this.j);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f69522e;

        public b(d dVar, k kVar) {
            this.f69522e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69522e.a();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f69523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f69524f;

        public c(d dVar, k kVar, i iVar) {
            this.f69523e = kVar;
            this.f69524f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f69523e.a(this.f69524f, true);
            this.f69523e.b();
        }
    }

    /* renamed from: d.b.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1898d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f69526f;

        /* renamed from: d.b.c.b.b.d$d$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f69528e;

            public a(o oVar) {
                this.f69528e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1898d c1898d = C1898d.this;
                d.this.j(c1898d.f69525e, this.f69528e, c1898d.f69526f);
            }
        }

        /* renamed from: d.b.c.b.b.d$d$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f69530e;

            public b(o oVar) {
                this.f69530e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1898d c1898d = C1898d.this;
                d.this.i(c1898d.f69525e, this.f69530e);
            }
        }

        public C1898d(String str, k kVar) {
            this.f69525e = str;
            this.f69526f = kVar;
        }

        @Override // d.b.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f69510a.execute(new a(oVar));
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f69510a.execute(new b(oVar));
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
        public final /* synthetic */ String f69532e;

        public f(String str) {
            this.f69532e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f69515f.get(this.f69532e);
            if (gVar != null) {
                for (i iVar : gVar.f69537d) {
                    if (iVar.f69539b != null) {
                        if (gVar.b() == null) {
                            iVar.f69540c = gVar.f69534a.f69645b.f69669b;
                            iVar.f69538a = gVar.f69535b;
                            iVar.f69539b.a(iVar, false);
                        } else {
                            iVar.f69539b.b(gVar.g());
                        }
                        iVar.f69539b.b();
                    }
                }
            }
            d.this.f69515f.remove(this.f69532e);
        }
    }

    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f69534a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f69535b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f69536c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f69537d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f69537d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f69536c;
        }

        public void d(i iVar) {
            this.f69537d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f69534a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f69536c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f69534a;
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
        public Bitmap f69538a;

        /* renamed from: b  reason: collision with root package name */
        public final k f69539b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f69540c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f69538a = bitmap;
            this.f69539b = kVar;
        }

        public Bitmap a() {
            return this.f69538a;
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
        this.f69511b = nVar;
        this.f69513d = hVar == null ? new d.b.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1898d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f69513d.a(str, i2, i3, scaleType);
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
        this.f69515f.put(str, gVar);
        this.f69516g.postDelayed(new f(str), this.f69512c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f69510a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f69514e.remove(str);
        if (remove != null) {
            remove.f(oVar.f69646c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f69645b;
        this.f69513d.a(str, oVar.f69644a, (aVar == null || !kVar.a(aVar.f69669b)) ? new byte[0] : oVar.f69645b.f69669b);
        g remove = this.f69514e.remove(str);
        if (remove != null) {
            remove.f69535b = oVar.f69644a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f69516g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f69513d.b(b2);
        byte[] a2 = this.f69513d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f69514e.get(b2);
            if (gVar == null) {
                gVar = this.f69515f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f69511b.a(a3);
            this.f69514e.put(b2, new g(a3, iVar));
            return;
        }
        this.f69516g.post(new c(this, kVar, new i(this, this.f69513d.a(b2), b3, str, null, null)));
    }
}
