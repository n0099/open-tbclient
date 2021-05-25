package d.a.j0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40388f;

        public a(int i2) {
            this.f40388f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                j.this.a(this.f40388f);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f40388f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40381c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40390f;

        public b(int i2) {
            this.f40390f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                j.this.f(this.f40390f, j.this.f40381c, j.this.f40386h);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f40390f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40381c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.a.j0.e.i
    public void h(Context context, int i2, long j) {
        super.h(context, i2, j);
        b(i2, 2);
        d.a.j0.k.e.c().b(new a(i2));
    }

    @Override // d.a.j0.e.i
    public boolean j() {
        if (TextUtils.isEmpty(this.f40383e)) {
            this.f40385g = null;
            this.f40384f = 0L;
            return true;
        }
        if (this.f40384f - System.currentTimeMillis() < d.a.j0.l.b.f40465a) {
            this.f40385g = null;
            this.f40384f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.a.j0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        b(i2, 4);
        d.a.j0.k.e.c().b(new b(i2));
    }

    @Override // d.a.j0.e.i
    public boolean p() {
        if (TextUtils.isEmpty(this.f40386h)) {
            this.f40387i = 0L;
            return true;
        }
        if (this.f40387i - System.currentTimeMillis() < d.a.j0.l.b.f40465a) {
            this.f40387i = 0L;
            return true;
        }
        return false;
    }
}
