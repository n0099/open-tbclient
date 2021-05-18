package d.a.i0.j.k.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.s1.g;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47678e;

        public a(c cVar) {
            this.f47678e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                d.c(this.f47678e);
            } else {
                this.f47678e.onFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f47679a;

        public b(c cVar) {
            this.f47679a = cVar;
        }

        @Override // d.a.i0.a.s1.g.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 0) {
                this.f47679a.onFail();
                return;
            }
            for (int i3 : iArr) {
                if (i3 == -1) {
                    this.f47679a.onFail();
                    return;
                }
            }
            this.f47679a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    public static void b(Context context, c cVar) {
        if (!(context instanceof Activity)) {
            cVar.onFail();
            return;
        }
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 != null) {
            i2.T().g((Activity) context, "mapp_location", new a(cVar));
        }
    }

    public static void c(c cVar) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (q0.L() && Q != null) {
            cVar.onSuccess();
        } else {
            Q.x().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new b(cVar));
        }
    }
}
