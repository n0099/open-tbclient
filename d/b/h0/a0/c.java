package d.b.h0.a0;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static c f49673f = new c();

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.k.a<String, d.b.b.j.d.a> f49674a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.e.k.a<String, d.b.b.j.d.a> f49675b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.e.k.a<String, Bitmap> f49676c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> f49677d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.i.c.b f49678e;

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
    public class C1043c extends d.b.b.e.k.a<String, Bitmap> {
        public C1043c(c cVar, int i) {
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
        this.f49674a = null;
        this.f49675b = null;
        this.f49676c = null;
        this.f49674a = new a(this, 0);
        this.f49675b = new b(this, 0);
        this.f49676c = new C1043c(this, 0);
    }

    public static c j() {
        return f49673f;
    }

    public void a(String str, Bitmap bitmap) {
        if (StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.f49676c.h(str, bitmap);
    }

    public void b(String str, d.b.b.j.d.a aVar) {
        c(str, aVar, false);
    }

    public void c(String str, d.b.b.j.d.a aVar, boolean z) {
        d.b.b.e.k.a<String, d.b.b.j.d.a> aVar2;
        if (aVar == null || (aVar2 = this.f49674a) == null) {
            return;
        }
        aVar2.h(str, aVar);
    }

    public void d(String str, d.b.b.j.d.a aVar) {
        e(str, aVar, false);
    }

    public void e(String str, d.b.b.j.d.a aVar, boolean z) {
        if (aVar == null || this.f49675b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.f49675b.h(str, aVar);
    }

    public void f(String str) {
        this.f49674a.i(str);
    }

    public void g(String str) {
        this.f49675b.i(str);
    }

    public boolean h(int i) {
        return this.f49675b.e(i);
    }

    public Bitmap i(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.f49676c.f(str);
    }

    public d.b.b.j.d.a k(String str) {
        return this.f49674a.f(str);
    }

    public d.b.b.j.d.a l(String str) {
        return this.f49675b.f(str);
    }

    public int m() {
        return this.f49675b.g();
    }

    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> n(int i) {
        d.b.h0.b1.i.c.b bVar;
        if (this.f49677d != null && (bVar = this.f49678e) != null) {
            if (bVar.g() == i) {
                return this.f49677d;
            }
            this.f49678e.j(i);
            this.f49677d.c();
        }
        if (this.f49678e == null) {
            this.f49678e = new d.b.h0.b1.i.c.b(i);
        }
        if (this.f49677d == null) {
            this.f49677d = new d.b.b.e.k.b<>(this.f49678e, 6, 0);
        }
        return this.f49677d;
    }

    public void o(int i, int i2) {
        r(i);
        s(i2);
        q(60);
    }

    public void p() {
        d.b.b.e.k.b<d.b.h0.b1.i.a.a> bVar = this.f49677d;
        if (bVar != null) {
            bVar.g(0);
            this.f49677d.f(0);
            this.f49677d.c();
            this.f49677d = null;
        }
    }

    public void q(int i) {
        this.f49676c.k(i);
    }

    public void r(int i) {
        this.f49674a.k(i);
    }

    public void s(int i) {
        this.f49675b.k(i);
    }

    public String t() {
        return this.f49675b.l() + "/" + this.f49675b.g() + "/" + this.f49675b.d() + "_" + this.f49674a.l() + "/" + this.f49674a.g() + "/" + this.f49674a.d();
    }

    public String toString() {
        return "pic:" + this.f49675b.toString() + "  photo:" + this.f49674a.toString();
    }
}
