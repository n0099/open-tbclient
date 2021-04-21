package d.b.h0.g.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.b.h0.a.i2.k0;
import d.b.h0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.q1.b.b.g f48604a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f48605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48606f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48607g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f48608h;
        public final /* synthetic */ DialogInterface.OnClickListener i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f48605e = activity;
            this.f48606f = str;
            this.f48607g = str2;
            this.f48608h = z;
            this.i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f48604a != null && c.this.f48604a.isShowing()) {
                c.this.f48604a.dismiss();
            }
            Activity activity = this.f48605e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            g.a d2 = c.this.d(this.f48605e, this.f48606f, this.f48607g, this.f48608h, this.i);
            c.this.f48604a = d2.X();
        }
    }

    public final g.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.y(str);
        aVar.a();
        aVar.n(new d.b.h0.a.j2.g.a());
        aVar.m(z);
        aVar.Q(d.b.h0.a.c.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        d.b.h0.a.q1.b.b.g gVar = this.f48604a;
        if (gVar != null) {
            if (gVar.isShowing()) {
                this.f48604a.dismiss();
            }
            this.f48604a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        k0.T(new a(activity, str, str2, z, onClickListener));
    }
}
