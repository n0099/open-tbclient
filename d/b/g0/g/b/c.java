package d.b.g0.g.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.q1.b.b.g f47882a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47885g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f47886h;
        public final /* synthetic */ DialogInterface.OnClickListener i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f47883e = activity;
            this.f47884f = str;
            this.f47885g = str2;
            this.f47886h = z;
            this.i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f47882a != null && c.this.f47882a.isShowing()) {
                c.this.f47882a.dismiss();
            }
            Activity activity = this.f47883e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            g.a d2 = c.this.d(this.f47883e, this.f47884f, this.f47885g, this.f47886h, this.i);
            c.this.f47882a = d2.X();
        }
    }

    public final g.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.y(str);
        aVar.a();
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(z);
        aVar.Q(d.b.g0.a.c.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        d.b.g0.a.q1.b.b.g gVar = this.f47882a;
        if (gVar != null) {
            if (gVar.isShowing()) {
                this.f47882a.dismiss();
            }
            this.f47882a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        k0.T(new a(activity, str, str2, z, onClickListener));
    }
}
