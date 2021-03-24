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
    public final n f65611b;

    /* renamed from: d  reason: collision with root package name */
    public final h f65613d;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f65610a = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public int f65612c = 50;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, g> f65614e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f65615f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    public final Handler f65616g = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65618f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f65619g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65620h;
        public final /* synthetic */ int i;
        public final /* synthetic */ ImageView.ScaleType j;

        public a(String str, k kVar, j jVar, int i, int i2, ImageView.ScaleType scaleType) {
            this.f65617e = str;
            this.f65618f = kVar;
            this.f65619g = jVar;
            this.f65620h = i;
            this.i = i2;
            this.j = scaleType;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l(this.f65617e, this.f65618f, this.f65619g, this.f65620h, this.i, this.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65621e;

        public b(d dVar, k kVar) {
            this.f65621e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65621e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f65622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f65623f;

        public c(d dVar, k kVar, i iVar) {
            this.f65622e = kVar;
            this.f65623f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65622e.a(this.f65623f, true);
            this.f65622e.b();
        }
    }

    /* renamed from: d.c.c.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1796d implements o.a<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65624e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f65625f;

        /* renamed from: d.c.c.b.b.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65627e;

            public a(o oVar) {
                this.f65627e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1796d c1796d = C1796d.this;
                d.this.j(c1796d.f65624e, this.f65627e, c1796d.f65625f);
            }
        }

        /* renamed from: d.c.c.b.b.d$d$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f65629e;

            public b(o oVar) {
                this.f65629e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1796d c1796d = C1796d.this;
                d.this.i(c1796d.f65624e, this.f65629e);
            }
        }

        public C1796d(String str, k kVar) {
            this.f65624e = str;
            this.f65625f = kVar;
        }

        @Override // d.c.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
            d.this.f65610a.execute(new a(oVar));
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            d.this.f65610a.execute(new b(oVar));
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
        public final /* synthetic */ String f65631e;

        public f(String str) {
            this.f65631e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) d.this.f65615f.get(this.f65631e);
            if (gVar != null) {
                for (i iVar : gVar.f65636d) {
                    if (iVar.f65638b != null) {
                        if (gVar.b() == null) {
                            iVar.f65639c = gVar.f65633a.f65739b.f65763b;
                            iVar.f65637a = gVar.f65634b;
                            iVar.f65638b.a(iVar, false);
                        } else {
                            iVar.f65638b.b(gVar.g());
                        }
                        iVar.f65638b.b();
                    }
                }
            }
            d.this.f65615f.remove(this.f65631e);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public o<Bitmap> f65633a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f65634b;

        /* renamed from: c  reason: collision with root package name */
        public VAdError f65635c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f65636d;

        public g(Request<?> request, i iVar) {
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f65636d = synchronizedList;
            synchronizedList.add(iVar);
        }

        public VAdError b() {
            return this.f65635c;
        }

        public void d(i iVar) {
            this.f65636d.add(iVar);
        }

        public void e(o<Bitmap> oVar) {
            this.f65633a = oVar;
        }

        public void f(VAdError vAdError) {
            this.f65635c = vAdError;
        }

        public o<Bitmap> g() {
            return this.f65633a;
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
        public Bitmap f65637a;

        /* renamed from: b  reason: collision with root package name */
        public final k f65638b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f65639c;

        public i(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, k kVar) {
            this.f65637a = bitmap;
            this.f65638b = kVar;
        }

        public Bitmap a() {
            return this.f65637a;
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
        this.f65611b = nVar;
        this.f65613d = hVar == null ? new d.c.c.b.b.a() : hVar;
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, j jVar, k kVar) {
        return new e(this, str, new C1796d(str2, kVar), i2, i3, scaleType, Bitmap.Config.ARGB_4444, jVar);
    }

    public final String b(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f65613d.a(str, i2, i3, scaleType);
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
        this.f65615f.put(str, gVar);
        this.f65616g.postDelayed(new f(str), this.f65612c);
    }

    public void f(String str, k kVar) {
        g(str, kVar, 0, 0);
    }

    public void g(String str, k kVar, int i2, int i3) {
        h(str, kVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void h(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65610a.execute(new a(str, kVar, jVar, i2, i3, scaleType));
    }

    public void i(String str, o<Bitmap> oVar) {
        g remove = this.f65614e.remove(str);
        if (remove != null) {
            remove.f(oVar.f65740c);
            remove.e(oVar);
            e(str, remove);
        }
    }

    public void j(String str, o<Bitmap> oVar, k kVar) {
        b.a aVar = oVar.f65739b;
        this.f65613d.a(str, oVar.f65738a, (aVar == null || !kVar.a(aVar.f65763b)) ? new byte[0] : oVar.f65739b.f65763b);
        g remove = this.f65614e.remove(str);
        if (remove != null) {
            remove.f65634b = oVar.f65738a;
            remove.e(oVar);
            e(str, remove);
        }
    }

    public final void l(String str, k kVar, j jVar, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f65616g.post(new b(this, kVar));
        String b2 = b(str, i2, i3, scaleType);
        Bitmap b3 = this.f65613d.b(b2);
        byte[] a2 = this.f65613d.a(b2);
        if (b3 == null && a2.length <= 0) {
            i iVar = new i(this, new byte[0], null, str, b2, kVar);
            g gVar = this.f65614e.get(b2);
            if (gVar == null) {
                gVar = this.f65615f.get(b2);
            }
            if (gVar != null) {
                gVar.d(iVar);
                return;
            }
            Request<Bitmap> a3 = a(str, i2, i3, scaleType, b2, jVar, kVar);
            this.f65611b.a(a3);
            this.f65614e.put(b2, new g(a3, iVar));
            return;
        }
        this.f65616g.post(new c(this, kVar, new i(this, this.f65613d.a(b2), b3, str, null, null)));
    }
}
