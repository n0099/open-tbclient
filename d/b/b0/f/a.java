package d.b.b0.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import d.b.b0.d;
import d.b.g0.a.n1.c.c;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements d.b.b0.g.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42480a = SchemeConfig.getSchemeHead() + "://swan/";

    @Override // d.b.b0.g.a
    public void a(Context context, JSONObject jSONObject, d.b.b0.e.a aVar) {
        d.b.g0.a.w0.a.D().a(context, jSONObject, aVar);
    }

    @Override // d.b.b0.g.a
    public boolean b(Context context) {
        return d.b.g0.a.w0.a.D().b(context);
    }

    @Override // d.b.b0.g.a
    public void c(Activity activity, String str, d.b.b0.e.a aVar) {
        d.b.g0.a.w0.a.D().c(activity, str, aVar);
    }

    @Override // d.b.b0.g.a
    public void d(Activity activity, String str, d.b.b0.e.a aVar) {
        d.b.g0.a.w0.a.D().d(activity, str, aVar);
    }

    @Override // d.b.b0.g.a
    public String e(Context context) {
        return d.b.g0.a.w0.a.g0().a(context);
    }

    @Override // d.b.b0.g.a
    public void f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            d.b.b0.a.h(3, "支付信息不能为空");
            return;
        }
        String optString = jSONObject.optString("appKey");
        String optString2 = jSONObject.optString("redirectUrl");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            SchemeRouter.invoke(context, f42480a + optString + optString2);
            return;
        }
        d.b.b0.a.h(3, "支付信息不能为空");
    }

    @Override // d.b.b0.g.a
    public void g(Activity activity, JSONObject jSONObject, d.b.b0.e.a aVar) {
    }

    @Override // d.b.b0.g.a
    public void h(Bundle bundle) {
        String str = d.b.g0.a.i1.a.b().f44619a;
        if (TextUtils.isEmpty(str)) {
            d.a(bundle);
            return;
        }
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        c cVar = new c(119, bundle);
        cVar.c(str);
        cVar.p(true);
        e2.h(cVar);
    }

    @Override // d.b.b0.g.a
    public void i(String str) {
        d.b.g0.a.i1.a.b().f44619a = str;
    }
}
