package d.a.i0.a0;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f47956g = new c();

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f47957a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f47958b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<String, Bitmap> f47959c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.a<String, d.a.c.j.d.a> f47960d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.i0.b1.i.a.a> f47961e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.b1.i.c.b f47962f;

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

    /* renamed from: d.a.i0.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1017c extends d.a.c.e.k.a<String, Bitmap> {
        public C1017c(c cVar, int i2) {
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
        this.f47957a = null;
        this.f47958b = null;
        this.f47959c = null;
        this.f47960d = null;
        this.f47957a = new a(this, 0);
        this.f47958b = new b(this, 0);
        this.f47959c = new C1017c(this, 0);
        this.f47960d = new d.a.c.e.k.a<>(Integer.MAX_VALUE);
    }

    public static c k() {
        return f47956g;
    }

    public void a(String str, Bitmap bitmap) {
        if (StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f47959c.h(str, bitmap);
    }

    public void b(String str, d.a.c.j.d.a aVar) {
        c(str, aVar, false);
    }

    public void c(String str, d.a.c.j.d.a aVar, boolean z) {
        d.a.c.e.k.a<String, d.a.c.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f47957a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.a.c.j.d.a aVar) {
        e(str, aVar, false);
    }

    public void e(String str, d.a.c.j.d.a aVar, boolean z) {
        if (aVar == null || this.f47958b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f47958b.h(str, aVar);
    }

    public void f(String str, d.a.c.j.d.a aVar) {
        d.a.c.e.k.a<String, d.a.c.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f47960d) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void g(String str) {
        this.f47957a.i(str);
    }

    public void h(String str) {
        this.f47958b.i(str);
    }

    public boolean i(int i2) {
        return this.f47958b.e(i2);
    }

    public Bitmap j(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f47959c.f(str);
    }

    public d.a.c.j.d.a l(String str) {
        return this.f47957a.f(str);
    }

    public d.a.c.j.d.a m(String str) {
        return this.f47958b.f(str);
    }

    public int n() {
        return this.f47958b.g();
    }

    public d.a.c.j.d.a o(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f47960d.f(str);
    }

    public d.a.c.e.k.b<d.a.i0.b1.i.a.a> p(int i2) {
        d.a.i0.b1.i.c.b bVar;
        if (this.f47961e != null && (bVar = this.f47962f) != null) {
            if (bVar.g() == i2) {
                return this.f47961e;
            }
            this.f47962f.j(i2);
            this.f47961e.c();
        }
        if (this.f47962f == null) {
            this.f47962f = new d.a.i0.b1.i.c.b(i2);
        }
        if (this.f47961e == null) {
            this.f47961e = new d.a.c.e.k.b<>(this.f47962f, 6, 0);
        }
        return this.f47961e;
    }

    public void q(int i2, int i3) {
        t(i2);
        u(i3);
        s(60);
    }

    public void r() {
        d.a.c.e.k.b<d.a.i0.b1.i.a.a> bVar = this.f47961e;
        if (bVar != null) {
            bVar.g(0);
            this.f47961e.f(0);
            this.f47961e.c();
            this.f47961e = null;
        }
    }

    public void s(int i2) {
        this.f47959c.k(i2);
    }

    public void t(int i2) {
        this.f47957a.k(i2);
    }

    public String toString() {
        return "pic:" + this.f47958b.toString() + "  photo:" + this.f47957a.toString();
    }

    public void u(int i2) {
        this.f47958b.k(i2);
    }

    public String v() {
        return this.f47958b.l() + "/" + this.f47958b.g() + "/" + this.f47958b.d() + "_" + this.f47957a.l() + "/" + this.f47957a.g() + "/" + this.f47957a.d();
    }
}
