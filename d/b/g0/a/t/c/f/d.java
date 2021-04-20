package d.b.g0.a.t.c.f;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t.b.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.b.g0.a.t.c.f.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0820a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46406e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f46407f;

            /* renamed from: d.b.g0.a.t.c.f.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0821a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d.b.g0.a.p.d.c f46409e;

                public C0821a(RunnableC0820a runnableC0820a, d.b.g0.a.p.d.c cVar) {
                    this.f46409e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f46409e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }

            public RunnableC0820a(int i, int i2) {
                this.f46406e = i;
                this.f46407f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
                if (o != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(o.getWebViewScrollY(), d.r(o, h0.e(d.this.h(), this.f46406e)));
                    ofInt.setDuration(this.f46407f);
                    ofInt.addUpdateListener(new C0821a(this, o));
                    ofInt.start();
                }
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            int optInt = jSONObject.optInt("scrollTop", -1);
            int optInt2 = jSONObject.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                k0.X(new RunnableC0820a(optInt, optInt2));
                return new d.b.g0.a.t.e.b(0);
            }
            d.b.g0.a.c0.c.b("Api-PageScrollTo", "illegal scrollTop or duration");
            return new d.b.g0.a.t.e.b(1001, "illegal params");
        }
    }

    public d(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static int r(@NonNull d.b.g0.a.p.d.c cVar, int i) {
        int contentHeight = ((int) (cVar.getContentHeight() * cVar.getScale())) - ((Integer) d.b.g0.a.z0.f.V().G().second).intValue();
        if (contentHeight <= 0) {
            return 0;
        }
        return i > contentHeight ? contentHeight : i;
    }

    public d.b.g0.a.t.e.b s(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-PageScrollTo", "page scroll to");
        }
        return i(str, false, new a());
    }
}
