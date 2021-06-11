package d.a.l0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public h f50799a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f50800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50801f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50802g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f50803h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f50804i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f50800e = activity;
            this.f50801f = str;
            this.f50802g = str2;
            this.f50803h = z;
            this.f50804i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f50799a != null && c.this.f50799a.isShowing()) {
                c.this.f50799a.dismiss();
            }
            Activity activity = this.f50800e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            h.a d2 = c.this.d(this.f50800e, this.f50801f, this.f50802g, this.f50803h, this.f50804i);
            c.this.f50799a = d2.X();
        }
    }

    public final h.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        h.a aVar = new h.a(activity);
        aVar.x(str);
        aVar.a();
        aVar.n(new d.a.l0.a.w2.h.a());
        aVar.m(z);
        aVar.Q(d.a.l0.f.b.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        h hVar = this.f50799a;
        if (hVar != null) {
            if (hVar.isShowing()) {
                this.f50799a.dismiss();
            }
            this.f50799a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        q0.X(new a(activity, str, str2, z, onClickListener));
    }
}
