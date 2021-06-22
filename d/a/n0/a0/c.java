package d.a.n0.a0;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f52587g = new c();

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.k.d.a> f52588a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.k.d.a> f52589b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<String, Bitmap> f52590c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.k.d.a> f52591d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.n0.b1.i.a.a> f52592e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.i.c.b f52593f;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.e.k.a<String, d.a.c.k.d.a> {
        public a(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.c.k.d.a aVar, d.a.c.k.d.a aVar2) {
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.e.k.a<String, d.a.c.k.d.a> {
        public b(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.c.k.d.a aVar, d.a.c.k.d.a aVar2) {
            if (aVar != null) {
                BdLog.isDebugMode();
                aVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(String str, d.a.c.k.d.a aVar) {
            if (aVar != null) {
                return aVar.B();
            }
            return 0;
        }
    }

    /* renamed from: d.a.n0.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1159c extends d.a.c.e.k.a<String, Bitmap> {
        public C1159c(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public c() {
        this.f52588a = null;
        this.f52589b = null;
        this.f52590c = null;
        this.f52591d = null;
        this.f52588a = new a(this, 0);
        this.f52589b = new b(this, 0);
        this.f52590c = new C1159c(this, 0);
        this.f52591d = new d.a.c.e.k.a<>(Integer.MAX_VALUE);
    }

    public static c k() {
        return f52587g;
    }

    public void a(String str, Bitmap bitmap) {
        if (StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f52590c.h(str, bitmap);
    }

    public void b(String str, d.a.c.k.d.a aVar) {
        c(str, aVar, false);
    }

    public void c(String str, d.a.c.k.d.a aVar, boolean z) {
        d.a.c.e.k.a<String, d.a.c.k.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f52588a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.a.c.k.d.a aVar) {
        e(str, aVar, false);
    }

    public void e(String str, d.a.c.k.d.a aVar, boolean z) {
        if (aVar == null || this.f52589b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f52589b.h(str, aVar);
    }

    public void f(String str, d.a.c.k.d.a aVar) {
        d.a.c.e.k.a<String, d.a.c.k.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f52591d) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void g(String str) {
        this.f52588a.i(str);
    }

    public void h(String str) {
        this.f52589b.i(str);
    }

    public boolean i(int i2) {
        return this.f52589b.e(i2);
    }

    public Bitmap j(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f52590c.f(str);
    }

    public d.a.c.k.d.a l(String str) {
        return this.f52588a.f(str);
    }

    public d.a.c.k.d.a m(String str) {
        return this.f52589b.f(str);
    }

    public int n() {
        return this.f52589b.g();
    }

    public d.a.c.k.d.a o(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f52591d.f(str);
    }

    public d.a.c.e.k.b<d.a.n0.b1.i.a.a> p(int i2) {
        d.a.n0.b1.i.c.b bVar;
        if (this.f52592e != null && (bVar = this.f52593f) != null) {
            if (bVar.g() == i2) {
                return this.f52592e;
            }
            this.f52593f.j(i2);
            this.f52592e.c();
        }
        if (this.f52593f == null) {
            this.f52593f = new d.a.n0.b1.i.c.b(i2);
        }
        if (this.f52592e == null) {
            this.f52592e = new d.a.c.e.k.b<>(this.f52593f, 6, 0);
        }
        return this.f52592e;
    }

    public void q(int i2, int i3) {
        t(i2);
        u(i3);
        s(60);
    }

    public void r() {
        d.a.c.e.k.b<d.a.n0.b1.i.a.a> bVar = this.f52592e;
        if (bVar != null) {
            bVar.g(0);
            this.f52592e.f(0);
            this.f52592e.c();
            this.f52592e = null;
        }
    }

    public void s(int i2) {
        this.f52590c.k(i2);
    }

    public void t(int i2) {
        this.f52588a.k(i2);
    }

    public String toString() {
        return "pic:" + this.f52589b.toString() + "  photo:" + this.f52588a.toString();
    }

    public void u(int i2) {
        this.f52589b.k(i2);
    }

    public String v() {
        return this.f52589b.l() + "/" + this.f52589b.g() + "/" + this.f52589b.d() + "_" + this.f52588a.l() + "/" + this.f52588a.g() + "/" + this.f52588a.d();
    }
}
