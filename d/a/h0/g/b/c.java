package d.a.h0.g.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.q1.b.b.g f46066a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46068f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46069g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f46070h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f46071i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f46067e = activity;
            this.f46068f = str;
            this.f46069g = str2;
            this.f46070h = z;
            this.f46071i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f46066a != null && c.this.f46066a.isShowing()) {
                c.this.f46066a.dismiss();
            }
            Activity activity = this.f46067e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            g.a d2 = c.this.d(this.f46067e, this.f46068f, this.f46069g, this.f46070h, this.f46071i);
            c.this.f46066a = d2.X();
        }
    }

    public final g.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.y(str);
        aVar.a();
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(z);
        aVar.Q(d.a.h0.a.c.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        d.a.h0.a.q1.b.b.g gVar = this.f46066a;
        if (gVar != null) {
            if (gVar.isShowing()) {
                this.f46066a.dismiss();
            }
            this.f46066a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        k0.T(new a(activity, str, str2, z, onClickListener));
    }
}
