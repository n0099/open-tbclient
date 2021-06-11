package d.a.l0.a.c2.f;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r extends a0 {

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.c f44929e;

        public a(r rVar, d.a.l0.a.p.e.c cVar) {
            this.f44929e = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f44929e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public r(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/pageScrollTo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar != null && context != null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.l0.a.e0.d.g("PageScrollToAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            int optInt = a2.optInt("scrollTop", -1);
            int optInt2 = a2.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                d.a.l0.a.p.e.c h2 = d.a.l0.a.g1.f.V().h();
                if (h2 != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(h2.getWebViewScrollY(), d.a.l0.a.u.e.g.d.s(h2, n0.f(context, optInt)));
                    ofInt.setDuration(optInt2);
                    ofInt.addUpdateListener(new a(this, h2));
                    ofInt.start();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.l0.a.e0.d.b("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        d.a.l0.a.e0.d.b("PageScrollToAction", "swanApp is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
        return false;
    }
}
