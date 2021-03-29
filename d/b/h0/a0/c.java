package d.b.h0.a0;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static c f49674f = new c();

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.k.a<String, d.b.b.j.d.a> f49675a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.e.k.a<String, d.b.b.j.d.a> f49676b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.e.k.a<String, Bitmap> f49677c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> f49678d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.i.c.b f49679e;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.e.k.a<String, d.b.b.j.d.a> {
        public a(c cVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.b.b.j.d.a aVar, d.b.b.j.d.a aVar2) {
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.b.e.k.a<String, d.b.b.j.d.a> {
        public b(c cVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, d.b.b.j.d.a aVar, d.b.b.j.d.a aVar2) {
            if (aVar != null) {
                BdLog.isDebugMode();
                aVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: p */
        public int m(String str, d.b.b.j.d.a aVar) {
            if (aVar != null) {
                return aVar.B();
            }
            return 0;
        }
    }

    /* renamed from: d.b.h0.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1044c extends d.b.b.e.k.a<String, Bitmap> {
        public C1044c(c cVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public c() {
        this.f49675a = null;
        this.f49676b = null;
        this.f49677c = null;
        this.f49675a = new a(this, 0);
        this.f49676b = new b(this, 0);
        this.f49677c = new C1044c(this, 0);
    }

    public static c j() {
        return f49674f;
    }

    public void a(String str, Bitmap bitmap) {
        if (StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f49677c.h(str, bitmap);
    }

    public void b(String str, d.b.b.j.d.a aVar) {
        c(str, aVar, false);
    }

    public void c(String str, d.b.b.j.d.a aVar, boolean z) {
        d.b.b.e.k.a<String, d.b.b.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f49675a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.b.b.j.d.a aVar) {
        e(str, aVar, false);
    }

    public void e(String str, d.b.b.j.d.a aVar, boolean z) {
        if (aVar == null || this.f49676b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f49676b.h(str, aVar);
    }

    public void f(String str) {
        this.f49675a.i(str);
    }

    public void g(String str) {
        this.f49676b.i(str);
    }

    public boolean h(int i) {
        return this.f49676b.e(i);
    }

    public Bitmap i(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f49677c.f(str);
    }

    public d.b.b.j.d.a k(String str) {
        return this.f49675a.f(str);
    }

    public d.b.b.j.d.a l(String str) {
        return this.f49676b.f(str);
    }

    public int m() {
        return this.f49676b.g();
    }

    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> n(int i) {
        d.b.h0.b1.i.c.b bVar;
        if (this.f49678d != null && (bVar = this.f49679e) != null) {
            if (bVar.g() == i) {
                return this.f49678d;
            }
            this.f49679e.j(i);
            this.f49678d.c();
        }
        if (this.f49679e == null) {
            this.f49679e = new d.b.h0.b1.i.c.b(i);
        }
        if (this.f49678d == null) {
            this.f49678d = new d.b.b.e.k.b<>(this.f49679e, 6, 0);
        }
        return this.f49678d;
    }

    public void o(int i, int i2) {
        r(i);
        s(i2);
        q(60);
    }

    public void p() {
        d.b.b.e.k.b<d.b.h0.b1.i.a.a> bVar = this.f49678d;
        if (bVar != null) {
            bVar.g(0);
            this.f49678d.f(0);
            this.f49678d.c();
            this.f49678d = null;
        }
    }

    public void q(int i) {
        this.f49677c.k(i);
    }

    public void r(int i) {
        this.f49675a.k(i);
    }

    public void s(int i) {
        this.f49676b.k(i);
    }

    public String t() {
        return this.f49676b.l() + "/" + this.f49676b.g() + "/" + this.f49676b.d() + "_" + this.f49675a.l() + "/" + this.f49675a.g() + "/" + this.f49675a.d();
    }

    public String toString() {
        return "pic:" + this.f49676b.toString() + "  photo:" + this.f49675a.toString();
    }
}
