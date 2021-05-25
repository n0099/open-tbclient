package d.a.l0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public h f47125a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f47129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f47130i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f47126e = activity;
            this.f47127f = str;
            this.f47128g = str2;
            this.f47129h = z;
            this.f47130i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f47125a != null && c.this.f47125a.isShowing()) {
                c.this.f47125a.dismiss();
            }
            Activity activity = this.f47126e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            h.a d2 = c.this.d(this.f47126e, this.f47127f, this.f47128g, this.f47129h, this.f47130i);
            c.this.f47125a = d2.X();
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
        h hVar = this.f47125a;
        if (hVar != null) {
            if (hVar.isShowing()) {
                this.f47125a.dismiss();
            }
            this.f47125a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        q0.X(new a(activity, str, str2, z, onClickListener));
    }
}
