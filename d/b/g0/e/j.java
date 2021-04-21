package d.b.g0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes2.dex */
public class j extends i {

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43631f;

        public a(int i) {
            this.f43631f = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                j.this.a(this.f43631f);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                j jVar = j.this;
                jVar.c(this.f43631f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43625c, "cu on getToken unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43633f;

        public b(int i) {
            this.f43633f = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                j.this.f(this.f43633f, j.this.f43625c, j.this.f43630h);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                j jVar = j.this;
                jVar.l(this.f43633f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43625c, "cu on getToken unknown error.");
            }
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // d.b.g0.e.i
    public void h(Context context, int i, long j) {
        super.h(context, i, j);
        b(i, 2);
        d.b.g0.k.e.c().b(new a(i));
    }

    @Override // d.b.g0.e.i
    public boolean j() {
        if (TextUtils.isEmpty(this.f43627e)) {
            this.f43629g = null;
            this.f43628f = 0L;
            return true;
        }
        if (this.f43628f - System.currentTimeMillis() < d.b.g0.l.b.f43702a) {
            this.f43629g = null;
            this.f43628f = 0L;
            return true;
        }
        return false;
    }

    @Override // d.b.g0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
        b(i, 4);
        d.b.g0.k.e.c().b(new b(i));
    }

    @Override // d.b.g0.e.i
    public boolean p() {
        if (TextUtils.isEmpty(this.f43630h)) {
            this.i = 0L;
            return true;
        }
        if (this.i - System.currentTimeMillis() < d.b.g0.l.b.f43702a) {
            this.i = 0L;
            return true;
        }
        return false;
    }
}
