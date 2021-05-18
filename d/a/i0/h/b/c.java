package d.a.i0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public h f46949a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46952g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f46953h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f46954i;

        public a(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            this.f46950e = activity;
            this.f46951f = str;
            this.f46952g = str2;
            this.f46953h = z;
            this.f46954i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f46949a != null && c.this.f46949a.isShowing()) {
                c.this.f46949a.dismiss();
            }
            Activity activity = this.f46950e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            h.a d2 = c.this.d(this.f46950e, this.f46951f, this.f46952g, this.f46953h, this.f46954i);
            c.this.f46949a = d2.X();
        }
    }

    public final h.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        h.a aVar = new h.a(activity);
        aVar.x(str);
        aVar.a();
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.m(z);
        aVar.Q(d.a.i0.f.b.swan_games_antiaddiction_positive);
        aVar.f(true);
        aVar.P(str2, onClickListener);
        return aVar;
    }

    public void e() {
        h hVar = this.f46949a;
        if (hVar != null) {
            if (hVar.isShowing()) {
                this.f46949a.dismiss();
            }
            this.f46949a = null;
        }
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        q0.X(new a(activity, str, str2, z, onClickListener));
    }
}
