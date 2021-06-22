package d.a.m0.a.u.e.g;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.u.c.d;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.m0.a.u.e.g.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0904a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48722e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f48723f;

            /* renamed from: d.a.m0.a.u.e.g.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0905a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d.a.m0.a.p.e.c f48725e;

                public C0905a(RunnableC0904a runnableC0904a, d.a.m0.a.p.e.c cVar) {
                    this.f48725e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f48725e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }

            public RunnableC0904a(int i2, int i3) {
                this.f48722e = i2;
                this.f48723f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.p.e.c h2 = d.a.m0.a.g1.f.V().h();
                if (h2 != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(h2.getWebViewScrollY(), d.s(h2, n0.f(d.this.i(), this.f48722e)));
                    ofInt.setDuration(this.f48723f);
                    ofInt.addUpdateListener(new C0905a(this, h2));
                    ofInt.start();
                }
            }
        }

        public a() {
        }

        @Override // d.a.m0.a.u.c.d.b
        public d.a.m0.a.u.h.b a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            int optInt = jSONObject.optInt("scrollTop", -1);
            int optInt2 = jSONObject.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                q0.b0(new RunnableC0904a(optInt, optInt2));
                return new d.a.m0.a.u.h.b(0);
            }
            d.a.m0.a.e0.d.b("Api-PageScrollTo", "illegal scrollTop or duration");
            return new d.a.m0.a.u.h.b(1001, "illegal params");
        }
    }

    public d(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public static int s(@NonNull d.a.m0.a.p.e.c cVar, int i2) {
        int contentHeight = ((int) (cVar.getContentHeight() * cVar.getScale())) - ((Integer) d.a.m0.a.g1.f.V().r().second).intValue();
        if (contentHeight <= 0) {
            return 0;
        }
        return i2 > contentHeight ? contentHeight : i2;
    }

    public d.a.m0.a.u.h.b t(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-PageScrollTo", "page scroll to");
        }
        return j(str, false, new a());
    }
}
