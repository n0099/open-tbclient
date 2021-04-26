package d.a.h0.b.i;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import d.a.h0.a.t.c.a.b;
@Service
/* loaded from: classes3.dex */
public class u implements d.a.h0.a.p.c.i {

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.p.c.c {
        public b(u uVar) {
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.a a(Activity activity, boolean z, String str, String str2) {
            return new n(activity, z, str, str2);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.f b(Activity activity, b.c cVar, Bundle bundle) {
            return new s(activity, cVar, bundle);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.g c(Activity activity, String str, String str2, boolean z, boolean z2) {
            return new t(activity, str, str2, z, z2);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.b d(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            return new o(context, z, z2, strArr, str, z3);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.e e(Context context) {
            return new r(context);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.d f(Context context) {
            return new q(context);
        }

        @Override // d.a.h0.a.p.c.c
        @NonNull
        public d.a.h0.a.v1.c.i.c g(Context context, String str) {
            return new p(context, str);
        }
    }

    static {
        boolean z = d.a.h0.a.k.f43101a;
    }

    @Override // d.a.h0.a.p.c.i
    public d.a.h0.a.p.c.b a() {
        return new m();
    }

    @Override // d.a.h0.a.p.c.i
    public d.a.h0.a.p.c.c b() {
        return new b();
    }
}
