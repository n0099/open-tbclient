package d.a.l0.b.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.u.e.a.c;
@Service
/* loaded from: classes3.dex */
public class u implements d.a.l0.a.p.d.q {

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.p.d.j {
        public b(u uVar) {
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.a a(Activity activity, boolean z, String str, String str2) {
            return new n(activity, z, str, str2);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.f b(Activity activity, c.C0832c c0832c, Bundle bundle) {
            return new s(activity, c0832c, bundle);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.g c(Activity activity, String str, String str2, boolean z, boolean z2) {
            return new t(activity, str, str2, z, z2);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.b d(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            return new o(context, z, z2, strArr, str, z3);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.e e(Context context) {
            return new r(context);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.d f(Context context) {
            return new q(context);
        }

        @Override // d.a.l0.a.p.d.j
        @NonNull
        public d.a.l0.a.e2.c.j.c g(Context context, String str) {
            return new p(context, str);
        }
    }

    static {
        boolean z = d.a.l0.a.k.f43199a;
    }

    @Override // d.a.l0.a.p.d.q
    public d.a.l0.a.p.d.b a() {
        return new m();
    }

    @Override // d.a.l0.a.p.d.q
    public d.a.l0.a.p.d.j b() {
        return new b();
    }
}
