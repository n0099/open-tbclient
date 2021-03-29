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
    public final n f65612b;

    /* renamed from: d  reason: collision with root package name */
    public final h f65614d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f65611a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f65613c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f65615e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f65616f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f65617g = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65618e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65619f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f65620g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65621h;
        public final /* synthetic */ int i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i, int i2, ImageView.ScaleType scaleType) {
            this.f65618e = str;
            this.f65619f = kVar;
            this.f65620g = jVar;
            this.f65621h = i;
            this.i = i2;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f65618e, this.f65619f, this.f65620g, this.f65621h, this.i, this.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65622e;

        public b(d dVar, k kVar) {
            this.f65622e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65622e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f65624f;

        public c(d dVar, k kVar, i iVar) {
            this.f65623e = kVar;
            this.f65624f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65623e.a(this.f65624f, true);
            this.f65623e.b();
        }
    }

    /* renamed from: d.c.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1797d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65626f;

        /* renamed from: d.c.c.b.b.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65628e;

            public a(o oVar) {
                this.f65628e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1797d c1797d = C1797d.this;
                d.this.j(c1797d.f65625e, this.f65628e, c1797d.f65626f);
            }
        }

        /* renamed from: d.c.c.b.b.d$d$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65630e;

            public b(o oVar) {
                this.f65630e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1797d c1797d = C1797d.this;
                d.this.i(c1797d.f65625e, this.f65630e);
            }
        }

        public C1797d(String str, k kVar) {
            this.f65625e = str;
            this.f65626f = kVar;
        }

        @Override // d.c.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f65611a.execute(new a(oVar));
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f65611a.execute(new b(oVar));
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
        public final /* synthetic */ String f65632e;

        public f(String str) {
            this.f65632e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f65616f.get(this.f65632e);
            if (gVar != null) {
                for (i iVar : gVar.f65637d) {
                    if (iVar.f65639b != null) {
                        if (gVar.b() == null) {
                            iVar.f65640c = gVar.f65634a.f65740b.f65764b;
                            iVar.f65638a = gVar.f65635b;
                            iVar.f65639b.a(iVar, false);
                        } else {
                            iVar.f65639b.b(gVar.g());
                        }
                        iVar.f65639b.b();
                    }
                }
            }
            d.this.f65616f.remove(this.f65632e);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f65634a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f65635b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f65636c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f65637d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f65637d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f65636c;
        }

        public void d(i iVar) {
            this.f65637d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f65634a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f65636c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f65634a;
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
        public Bitmap f65638a;

        /* renamed from: b  reason: collision with root package name */
        public final k f65639b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f65640c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f65638a = bitmap;
            this.f65639b = kVar;
        }

        public Bitmap a() {
            return this.f65638a;
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
        this.f65612b = nVar;
        this.f65614d = hVar == null ? new d.c.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1797d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f65614d.a(str, i2, i3, scaleType);
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
        this.f65616f.put(str, gVar);
        this.f65617g.postDelayed(new f(str), this.f65613c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65611a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f65615e.remove(str);
        if (remove != null) {
            remove.f(oVar.f65741c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f65740b;
        this.f65614d.a(str, oVar.f65739a, (aVar == null || !kVar.a(aVar.f65764b)) ? new byte[0] : oVar.f65740b.f65764b);
        g remove = this.f65615e.remove(str);
        if (remove != null) {
            remove.f65635b = oVar.f65739a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65617g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f65614d.b(b2);
        byte[] a2 = this.f65614d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f65615e.get(b2);
            if (gVar == null) {
                gVar = this.f65616f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f65612b.a(a3);
            this.f65615e.put(b2, new g(a3, iVar));
            return;
        }
        this.f65617g.post(new c(this, kVar, new i(this, this.f65614d.a(b2), b3, str, null, null)));
    }
}
