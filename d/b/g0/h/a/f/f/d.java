package d.b.g0.h.a.f.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k1.c;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f49126e;

        public a(c cVar) {
            this.f49126e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                d.c(this.f49126e);
            } else {
                this.f49126e.onFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f49127a;

        public b(c cVar) {
            this.f49127a = cVar;
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != 0) {
                this.f49127a.onFail();
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.f49127a.onFail();
                    return;
                }
            }
            this.f49127a.onSuccess();
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
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y != null) {
            y.R().g((Activity) context, "mapp_location", new a(cVar));
        }
    }

    public static void c(c cVar) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (k0.I() && O != null) {
            cVar.onSuccess();
        } else {
            O.n().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new b(cVar));
        }
    }
}
