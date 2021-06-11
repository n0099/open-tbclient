package d.a.j0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44067f;

        public a(int i2) {
            this.f44067f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                j.this.b(this.f44067f);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                j jVar = j.this;
                jVar.d(this.f44067f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f44060c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44069f;

        public b(int i2) {
            this.f44069f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                j.this.g(this.f44069f, j.this.f44060c, j.this.f44065h);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                j jVar = j.this;
                jVar.m(this.f44069f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f44060c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.a.j0.e.i
    public void i(Context context, int i2, long j) {
        super.i(context, i2, j);
        c(i2, 2);
        d.a.j0.k.e.c().b(new a(i2));
    }

    @Override // d.a.j0.e.i
    public boolean k() {
        if (TextUtils.isEmpty(this.f44062e)) {
            this.f44064g = null;
            this.f44063f = 0L;
            return true;
        }
        if (this.f44063f - System.currentTimeMillis() < d.a.j0.l.b.f44144a) {
            this.f44064g = null;
            this.f44063f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.a.j0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
        c(i2, 4);
        d.a.j0.k.e.c().b(new b(i2));
    }

    @Override // d.a.j0.e.i
    public boolean q() {
        if (TextUtils.isEmpty(this.f44065h)) {
            this.f44066i = 0L;
            return true;
        }
        if (this.f44066i - System.currentTimeMillis() < d.a.j0.l.b.f44144a) {
            this.f44066i = 0L;
            return true;
        }
        return false;
    }
}
