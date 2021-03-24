package d.b.g0.a.t.c.f;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t.b.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b {

        /* renamed from: d.b.g0.a.t.c.f.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0807a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46013e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f46014f;

            /* renamed from: d.b.g0.a.t.c.f.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0808a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d.b.g0.a.p.d.c f46016e;

                public C0808a(RunnableC0807a runnableC0807a, d.b.g0.a.p.d.c cVar) {
                    this.f46016e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f46016e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }

            public RunnableC0807a(int i, int i2) {
                this.f46013e = i;
                this.f46014f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
                if (o != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(o.getWebViewScrollY(), d.r(o, h0.e(d.this.h(), this.f46013e)));
                    ofInt.setDuration(this.f46014f);
                    ofInt.addUpdateListener(new C0808a(this, o));
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
                k0.X(new RunnableC0807a(optInt, optInt2));
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
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-PageScrollTo", "page scroll to");
        }
        return i(str, false, new a());
    }
}
