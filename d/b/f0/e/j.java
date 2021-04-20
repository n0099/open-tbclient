package d.b.f0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43334f;

        public a(int i) {
            this.f43334f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                j.this.a(this.f43334f);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f43334f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43328c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43336f;

        public b(int i) {
            this.f43336f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                j.this.f(this.f43336f, j.this.f43328c, j.this.f43333h);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f43336f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43328c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.b.f0.e.i
    public void h(Context context, int i, long j) {
        super.h(context, i, j);
        b(i, 2);
        d.b.f0.k.e.c().b(new a(i));
    }

    @Override // d.b.f0.e.i
    public boolean j() {
        if (TextUtils.isEmpty(this.f43330e)) {
            this.f43332g = null;
            this.f43331f = 0L;
            return true;
        }
        if (this.f43331f - System.currentTimeMillis() < d.b.f0.l.b.f43405a) {
            this.f43332g = null;
            this.f43331f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.b.f0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
        b(i, 4);
        d.b.f0.k.e.c().b(new b(i));
    }

    @Override // d.b.f0.e.i
    public boolean p() {
        if (TextUtils.isEmpty(this.f43333h)) {
            this.i = 0L;
            return true;
        }
        if (this.i - System.currentTimeMillis() < d.b.f0.l.b.f43405a) {
            this.i = 0L;
            return true;
        }
        return false;
    }
}
