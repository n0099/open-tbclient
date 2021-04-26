package d.a.h0.h.a.f.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k1.c;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f46955e;

        public a(c cVar) {
            this.f46955e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                d.c(this.f46955e);
            } else {
                this.f46955e.onFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f46956a;

        public b(c cVar) {
            this.f46956a = cVar;
        }

        @Override // d.a.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 0) {
                this.f46956a.onFail();
                return;
            }
            for (int i3 : iArr) {
                if (i3 == -1) {
                    this.f46956a.onFail();
                    return;
                }
            }
            this.f46956a.onSuccess();
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
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 != null) {
            h2.R().g((Activity) context, "mapp_location", new a(cVar));
        }
    }

    public static void c(c cVar) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (k0.I() && O != null) {
            cVar.onSuccess();
        } else {
            O.v().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new b(cVar));
        }
    }
}
