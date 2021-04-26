package d.a.h0.a.t1.k;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.h0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends a0 {

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p.d.c f44691e;

        public a(s sVar, d.a.h0.a.p.d.c cVar) {
            this.f44691e = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f44691e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public s(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/pageScrollTo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar != null && context != null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.h0.a.c0.c.g("PageScrollToAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            int optInt = a2.optInt("scrollTop", -1);
            int optInt2 = a2.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                d.a.h0.a.p.d.c j = d.a.h0.a.z0.f.V().j();
                if (j != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(j.getWebViewScrollY(), d.a.h0.a.t.c.f.d.r(j, h0.e(context, optInt)));
                    ofInt.setDuration(optInt2);
                    ofInt.addUpdateListener(new a(this, j));
                    ofInt.start();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.h0.a.c0.c.b("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        d.a.h0.a.c0.c.b("PageScrollToAction", "swanApp is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
        return false;
    }
}
