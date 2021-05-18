package d.a.i0.a.c2.g;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.k;
@Service
/* loaded from: classes3.dex */
public class c extends UnitedSchemeBaseInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41130a = k.f43025a;

    public final String a(UnitedSchemeEntity unitedSchemeEntity) {
        String[] paths;
        if (unitedSchemeEntity == null || (paths = UnitedSchemeUtility.getPaths(unitedSchemeEntity.getUri())) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : paths) {
            sb.append("/");
            sb.append(str);
        }
        return sb.substring(1);
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_websafe_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String a2 = a(unitedSchemeEntity);
        boolean b2 = d.a.i0.a.u.i.a.b(a2, callbackHandler);
        if (f41130a) {
            Log.d("SwanWebSafeInterceptor", "intercept: result=" + b2 + ", path=" + a2);
        }
        if (b2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
        }
        return b2;
    }
}
