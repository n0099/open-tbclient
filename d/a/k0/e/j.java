package d.a.k0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44207f;

        public a(int i2) {
            this.f44207f = i2;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                j.this.b(this.f44207f);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
                j jVar = j.this;
                jVar.d(this.f44207f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f44200c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44209f;

        public b(int i2) {
            this.f44209f = i2;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                j.this.g(this.f44209f, j.this.f44200c, j.this.f44205h);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
                j jVar = j.this;
                jVar.m(this.f44209f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f44200c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.a.k0.e.i
    public void i(Context context, int i2, long j) {
        super.i(context, i2, j);
        c(i2, 2);
        d.a.k0.k.e.c().b(new a(i2));
    }

    @Override // d.a.k0.e.i
    public boolean k() {
        if (TextUtils.isEmpty(this.f44202e)) {
            this.f44204g = null;
            this.f44203f = 0L;
            return true;
        }
        if (this.f44203f - System.currentTimeMillis() < d.a.k0.l.b.f44284a) {
            this.f44204g = null;
            this.f44203f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.a.k0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
        c(i2, 4);
        d.a.k0.k.e.c().b(new b(i2));
    }

    @Override // d.a.k0.e.i
    public boolean q() {
        if (TextUtils.isEmpty(this.f44205h)) {
            this.f44206i = 0L;
            return true;
        }
        if (this.f44206i - System.currentTimeMillis() < d.a.k0.l.b.f44284a) {
            this.f44206i = 0L;
            return true;
        }
        return false;
    }
}
