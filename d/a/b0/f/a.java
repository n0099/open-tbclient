package d.a.b0.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import d.a.b0.d;
import d.a.l0.a.v1.c.c;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements d.a.b0.g.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38294a = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // d.a.b0.g.a
    public boolean a(Context context) {
        return d.a.l0.a.c1.a.N().a(context);
    }

    @Override // d.a.b0.g.a
    public void b(Activity activity, String str, d.a.b0.e.a aVar) {
        d.a.l0.a.c1.a.N().b(activity, str, aVar);
    }

    @Override // d.a.b0.g.a
    public void c(Context context, JSONObject jSONObject, d.a.b0.e.a aVar) {
        d.a.l0.a.c1.a.N().c(context, jSONObject, aVar);
    }

    @Override // d.a.b0.g.a
    public void d(Activity activity, String str, d.a.b0.e.a aVar) {
        d.a.l0.a.c1.a.N().d(activity, str, aVar);
    }

    @Override // d.a.b0.g.a
    public String e(Context context) {
        return d.a.l0.a.c1.a.u0().a(context);
    }

    @Override // d.a.b0.g.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            d.a.b0.a.h(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            SchemeRouter.invoke(context, f38294a + optString + optString2);
            return;
        }
        d.a.b0.a.h(3, "支付信息不能为空");
    }

    @Override // d.a.b0.g.a
    public void g(Bundle bundle) {
        String str = d.a.l0.a.q1.a.b().f44168a;
        if (TextUtils.isEmpty(str)) {
            d.a(bundle);
            return;
        }
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        c cVar = new c(119, bundle);
        cVar.c(str);
        cVar.p(true);
        e2.h(cVar);
    }

    @Override // d.a.b0.g.a
    public void h(String str) {
        d.a.l0.a.q1.a.b().f44168a = str;
    }
}
