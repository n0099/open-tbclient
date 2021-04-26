package d.a.g0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40882f;

        public a(int i2) {
            this.f40882f = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                j.this.a(this.f40882f);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f40882f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40875c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40884f;

        public b(int i2) {
            this.f40884f = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                j.this.f(this.f40884f, j.this.f40875c, j.this.f40880h);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f40884f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f40875c, "cu on getToken unknown error.");
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
        if (TextUtils.isEmpty(this.f40877e)) {
            this.f40879g = null;
            this.f40878f = 0L;
            return true;
        }
        if (this.f40878f - System.currentTimeMillis() < d.a.g0.l.b.f40959a) {
            this.f40879g = null;
            this.f40878f = 0L;
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
        if (TextUtils.isEmpty(this.f40880h)) {
            this.f40881i = 0L;
            return true;
        }
        if (this.f40881i - System.currentTimeMillis() < d.a.g0.l.b.f40959a) {
            this.f40881i = 0L;
            return true;
        }
        return false;
    }
}
