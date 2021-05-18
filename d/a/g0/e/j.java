package d.a.g0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40127f;

        public a(int i2) {
            this.f40127f = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                j.this.a(this.f40127f);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f40127f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40120c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40129f;

        public b(int i2) {
            this.f40129f = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                j.this.f(this.f40129f, j.this.f40120c, j.this.f40125h);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f40129f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40120c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.a.g0.e.i
    public void h(Context context, int i2, long j) {
        super.h(context, i2, j);
        b(i2, 2);
        d.a.g0.k.e.c().b(new a(i2));
    }

    @Override // d.a.g0.e.i
    public boolean j() {
        if (TextUtils.isEmpty(this.f40122e)) {
            this.f40124g = null;
            this.f40123f = 0L;
            return true;
        }
        if (this.f40123f - System.currentTimeMillis() < d.a.g0.l.b.f40204a) {
            this.f40124g = null;
            this.f40123f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.a.g0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        b(i2, 4);
        d.a.g0.k.e.c().b(new b(i2));
    }

    @Override // d.a.g0.e.i
    public boolean p() {
        if (TextUtils.isEmpty(this.f40125h)) {
            this.f40126i = 0L;
            return true;
        }
        if (this.f40126i - System.currentTimeMillis() < d.a.g0.l.b.f40204a) {
            this.f40126i = 0L;
            return true;
        }
        return false;
    }
}
