package d.b.g0.a.r0.a.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.p;
import d.b.g0.a.r0.a.c;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {

    /* renamed from: d.b.g0.a.r0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0776a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45720f;

        public RunnableC0776a(a aVar, Context context, String str) {
            this.f45719e = context;
            this.f45720f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.r0.a.a.n().f(this.f45719e, this.f45720f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45721e;

        public b(a aVar, String str) {
            this.f45721e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean i = c.c().i(this.f45721e);
            d.b.g0.a.r0.a.a n = d.b.g0.a.r0.a.a.n();
            n.p("cloneResult = " + i);
        }
    }

    public final String a(UnitedSchemeEntity unitedSchemeEntity) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            return null;
        }
        return optParamsAsJo.optString("appKey");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri != null && TextUtils.equals(uri.getHost(), "swanAPI")) {
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return false;
            }
            if (TextUtils.equals(path, "/clone")) {
                String a2 = a(unitedSchemeEntity);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                p.k(new RunnableC0776a(this, context, a2), "cloneSwanAppRunnable");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            } else if (TextUtils.equals(path, "/install")) {
                String a3 = a(unitedSchemeEntity);
                if (TextUtils.isEmpty(a3)) {
                    return false;
                }
                p.k(new b(this, a3), "installSwanAppRunnable");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
