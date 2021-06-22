package d.a.m0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.a.m0.a.v2.q0;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public h f50907a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f50908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f50911h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f50912i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f50908e = activity;
            this.f50909f = str;
            this.f50910g = str2;
            this.f50911h = z;
            this.f50912i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f50907a != null && c.this.f50907a.isShowing()) {
                c.this.f50907a.dismiss();
            }
            Activity activity = this.f50908e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            h.a d2 = c.this.d(this.f50908e, this.f50909f, this.f50910g, this.f50911h, this.f50912i);
            c.this.f50907a = d2.X();
        }
    }

    public final h.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        h.a aVar = new h.a(activity);
        aVar.x(str);
        aVar.a();
        aVar.n(new d.a.m0.a.w2.h.a());
        aVar.m(z);
        aVar.Q(d.a.m0.f.b.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        h hVar = this.f50907a;
        if (hVar != null) {
            if (hVar.isShowing()) {
                this.f50907a.dismiss();
            }
            this.f50907a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        q0.X(new a(activity, str, str2, z, onClickListener));
    }
}
