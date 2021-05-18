package d.a.i0.a.c2.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends a0 {

    /* loaded from: classes3.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f40971a;

        public a(o oVar, Activity activity, Uri uri, String str, CallbackHandler callbackHandler, String str2) {
            this.f40971a = activity;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    public o(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/openDocument");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else if (eVar.d0()) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("filePath");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
                return false;
            }
            String V = d.a.i0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String M = d.a.i0.a.k2.b.M(optString, V);
            if (TextUtils.isEmpty(M)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                return false;
            }
            String optString2 = a2.optString("fileType");
            String s = d.a.i0.t.d.s(M);
            if (!TextUtils.isEmpty(s)) {
                optString2 = s;
            } else if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                return false;
            }
            String b2 = d.a.i0.a.v2.n.b(optString2);
            if (TextUtils.isEmpty(b2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                return false;
            }
            Uri parse = Uri.parse(M);
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                return false;
            }
            Uri fromFile = parse.getScheme() == null ? Uri.fromFile(new File(M)) : parse;
            SwanAppActivity x = eVar.x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                return false;
            } else if (!d.a.i0.a.v2.n.a(b2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + b2);
                return false;
            } else {
                String optString3 = a2.optString("cb");
                d.a.i0.a.p.d.d0 r = d.a.i0.a.c1.a.r();
                if (!r.b(x, b2)) {
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + b2);
                        return false;
                    }
                    j(x, b2, fromFile, optString3, callbackHandler);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                r.c(x, fromFile, b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return true;
            }
        }
    }

    public final void j(Activity activity, String str, Uri uri, String str2, CallbackHandler callbackHandler) {
        d.a.i0.a.c1.a.r().a(activity, str, new a(this, activity, uri, str, callbackHandler, str2));
    }
}
