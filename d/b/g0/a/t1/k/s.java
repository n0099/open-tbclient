package d.b.g0.a.t1.k;

import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.h0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends a0 {

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p.d.c f46562e;

        public a(s sVar, d.b.g0.a.p.d.c cVar) {
            this.f46562e = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f46562e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public s(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/pageScrollTo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && context != null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.b.g0.a.c0.c.g("PageScrollToAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            int optInt = a2.optInt("scrollTop", -1);
            int optInt2 = a2.optInt("duration", -1);
            if (optInt > -1 && optInt2 > -1) {
                d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
                if (o != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(o.getWebViewScrollY(), d.b.g0.a.t.c.f.d.r(o, h0.e(context, optInt)));
                    ofInt.setDuration(optInt2);
                    ofInt.addUpdateListener(new a(this, o));
                    ofInt.start();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.b.g0.a.c0.c.b("PageScrollToAction", "illegal scrollTop or duration");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        d.b.g0.a.c0.c.b("PageScrollToAction", "swanApp is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
        return false;
    }
}
