package d.a.h0.a.t.c.f;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t.b.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.h0.a.t.c.f.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0779a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44112e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f44113f;

            /* renamed from: d.a.h0.a.t.c.f.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0780a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d.a.h0.a.p.d.c f44115e;

                public C0780a(RunnableC0779a runnableC0779a, d.a.h0.a.p.d.c cVar) {
                    this.f44115e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f44115e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }

            public RunnableC0779a(int i2, int i3) {
                this.f44112e = i2;
                this.f44113f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.p.d.c j = d.a.h0.a.z0.f.V().j();
                if (j != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(j.getWebViewScrollY(), d.r(j, h0.e(d.this.h(), this.f44112e)));
                    ofInt.setDuration(this.f44113f);
                    ofInt.addUpdateListener(new C0780a(this, j));
                    ofInt.start();
                }
            }
        }

        public a() {
        }

        @Override // d.a.h0.a.t.b.d.b
        public d.a.h0.a.t.e.b a(d.a.h0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            int optInt = jSONObject.optInt("scrollTop", -1);
            int optInt2 = jSONObject.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                k0.X(new RunnableC0779a(optInt, optInt2));
                return new d.a.h0.a.t.e.b(0);
            }
            d.a.h0.a.c0.c.b("Api-PageScrollTo", "illegal scrollTop or duration");
            return new d.a.h0.a.t.e.b(1001, "illegal params");
        }
    }

    public d(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static int r(@NonNull d.a.h0.a.p.d.c cVar, int i2) {
        int contentHeight = ((int) (cVar.getContentHeight() * cVar.getScale())) - ((Integer) d.a.h0.a.z0.f.V().t().second).intValue();
        if (contentHeight <= 0) {
            return 0;
        }
        return i2 > contentHeight ? contentHeight : i2;
    }

    public d.a.h0.a.t.e.b s(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-PageScrollTo", "page scroll to");
        }
        return i(str, false, new a());
    }
}
