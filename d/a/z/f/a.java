package d.a.z.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import d.a.h0.a.n1.c.c;
import d.a.z.d;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements d.a.z.g.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f64225a = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // d.a.z.g.a
    public boolean a(Context context) {
        return d.a.h0.a.w0.a.D().a(context);
    }

    @Override // d.a.z.g.a
    public void b(Activity activity, String str, d.a.z.e.a aVar) {
        d.a.h0.a.w0.a.D().b(activity, str, aVar);
    }

    @Override // d.a.z.g.a
    public void c(Context context, JSONObject jSONObject, d.a.z.e.a aVar) {
        d.a.h0.a.w0.a.D().c(context, jSONObject, aVar);
    }

    @Override // d.a.z.g.a
    public void d(Activity activity, String str, d.a.z.e.a aVar) {
        d.a.h0.a.w0.a.D().d(activity, str, aVar);
    }

    @Override // d.a.z.g.a
    public String e(Context context) {
        return d.a.h0.a.w0.a.g0().a(context);
    }

    @Override // d.a.z.g.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            d.a.z.a.h(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            SchemeRouter.invoke(context, f64225a + optString + optString2);
            return;
        }
        d.a.z.a.h(3, "支付信息不能为空");
    }

    @Override // d.a.z.g.a
    public void g(Bundle bundle) {
        String str = d.a.h0.a.i1.a.b().f42655a;
        if (TextUtils.isEmpty(str)) {
            d.a(bundle);
            return;
        }
        d.a.h0.a.n1.c.a e2 = d.a.h0.a.n1.c.a.e();
        c cVar = new c(119, bundle);
        cVar.c(str);
        cVar.p(true);
        e2.h(cVar);
    }

    @Override // d.a.z.g.a
    public void h(String str) {
        d.a.h0.a.i1.a.b().f42655a = str;
    }

    @Override // d.a.z.g.a
    public void i(Activity activity, JSONObject jSONObject, d.a.z.e.a aVar) {
    }
}
