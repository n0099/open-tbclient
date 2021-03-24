package d.b.f0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes3.dex */
public class j extends i {

    /* loaded from: classes3.dex */
    public class a extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42941f;

        public a(int i) {
            this.f42941f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                j.this.a(this.f42941f);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f42941f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f42935c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42943f;

        public b(int i) {
            this.f42943f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                j.this.f(this.f42943f, j.this.f42935c, j.this.f42940h);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f42943f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f42935c, "cu on getToken unknown error.");
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
        if (TextUtils.isEmpty(this.f42937e)) {
            this.f42939g = null;
            this.f42938f = 0L;
            return true;
        }
        if (this.f42938f - System.currentTimeMillis() < d.b.f0.l.b.f43012a) {
            this.f42939g = null;
            this.f42938f = 0L;
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
        if (TextUtils.isEmpty(this.f42940h)) {
            this.i = 0L;
            return true;
        }
        if (this.i - System.currentTimeMillis() < d.b.f0.l.b.f43012a) {
            this.i = 0L;
            return true;
        }
        return false;
    }
}
