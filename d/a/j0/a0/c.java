package d.a.j0.a0;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f48784g = new c();

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f48785a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f48786b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<String, Bitmap> f48787c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f48788d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.j0.b1.i.a.a> f48789e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.b1.i.c.b f48790f;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.e.k.a<String, d.a.c.j.d.a> {
        public a(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.c.j.d.a aVar, d.a.c.j.d.a aVar2) {
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.e.k.a<String, d.a.c.j.d.a> {
        public b(c cVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.a.c.j.d.a aVar, d.a.c.j.d.a aVar2) {
            if (aVar != null) {
                BdLog.isDebugMode();
                aVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(String str, d.a.c.j.d.a aVar) {
            if (aVar != null) {
                return aVar.B();
            }
            return 0;
        }
    }

    /* renamed from: d.a.j0.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1093c extends d.a.c.e.k.a<String, Bitmap> {
        public C1093c(c cVar, int i2) {
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
        this.f48785a = null;
        this.f48786b = null;
        this.f48787c = null;
        this.f48788d = null;
        this.f48785a = new a(this, 0);
        this.f48786b = new b(this, 0);
        this.f48787c = new C1093c(this, 0);
        this.f48788d = new d.a.c.e.k.a<>(Integer.MAX_VALUE);
    }

    public static c k() {
        return f48784g;
    }

    public void a(String str, Bitmap bitmap) {
        if (StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f48787c.h(str, bitmap);
    }

    public void b(String str, d.a.c.j.d.a aVar) {
        c(str, aVar, false);
    }

    public void c(String str, d.a.c.j.d.a aVar, boolean z) {
        d.a.c.e.k.a<String, d.a.c.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f48785a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.a.c.j.d.a aVar) {
        e(str, aVar, false);
    }

    public void e(String str, d.a.c.j.d.a aVar, boolean z) {
        if (aVar == null || this.f48786b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f48786b.h(str, aVar);
    }

    public void f(String str, d.a.c.j.d.a aVar) {
        d.a.c.e.k.a<String, d.a.c.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f48788d) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void g(String str) {
        this.f48785a.i(str);
    }

    public void h(String str) {
        this.f48786b.i(str);
    }

    public boolean i(int i2) {
        return this.f48786b.e(i2);
    }

    public Bitmap j(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f48787c.f(str);
    }

    public d.a.c.j.d.a l(String str) {
        return this.f48785a.f(str);
    }

    public d.a.c.j.d.a m(String str) {
        return this.f48786b.f(str);
    }

    public int n() {
        return this.f48786b.g();
    }

    public d.a.c.j.d.a o(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f48788d.f(str);
    }

    public d.a.c.e.k.b<d.a.j0.b1.i.a.a> p(int i2) {
        d.a.j0.b1.i.c.b bVar;
        if (this.f48789e != null && (bVar = this.f48790f) != null) {
            if (bVar.g() == i2) {
                return this.f48789e;
            }
            this.f48790f.j(i2);
            this.f48789e.c();
        }
        if (this.f48790f == null) {
            this.f48790f = new d.a.j0.b1.i.c.b(i2);
        }
        if (this.f48789e == null) {
            this.f48789e = new d.a.c.e.k.b<>(this.f48790f, 6, 0);
        }
        return this.f48789e;
    }

    public void q(int i2, int i3) {
        t(i2);
        u(i3);
        s(60);
    }

    public void r() {
        d.a.c.e.k.b<d.a.j0.b1.i.a.a> bVar = this.f48789e;
        if (bVar != null) {
            bVar.g(0);
            this.f48789e.f(0);
            this.f48789e.c();
            this.f48789e = null;
        }
    }

    public void s(int i2) {
        this.f48787c.k(i2);
    }

    public void t(int i2) {
        this.f48785a.k(i2);
    }

    public String toString() {
        return "pic:" + this.f48786b.toString() + "  photo:" + this.f48785a.toString();
    }

    public void u(int i2) {
        this.f48786b.k(i2);
    }

    public String v() {
        return this.f48786b.l() + "/" + this.f48786b.g() + "/" + this.f48786b.d() + "_" + this.f48785a.l() + "/" + this.f48785a.g() + "/" + this.f48785a.d();
    }
}
