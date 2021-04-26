package d.a.h0.a.t1.k;

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
public class p extends a0 {

    /* loaded from: classes3.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f44586a;

        public a(p pVar, Activity activity, Uri uri, String str, CallbackHandler callbackHandler, String str2) {
            this.f44586a = activity;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    public p(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/file/openDocument");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else if (eVar.Z()) {
            if (a0.f44398b) {
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
            String T = d.a.h0.a.r1.e.T();
            if (TextUtils.isEmpty(T)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String u = d.a.h0.a.a2.b.u(optString, T);
            if (TextUtils.isEmpty(u)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                return false;
            }
            String optString2 = a2.optString("fileType");
            String l = d.a.h0.p.d.l(u);
            if (!TextUtils.isEmpty(l)) {
                optString2 = l;
            } else if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                return false;
            }
            String b2 = d.a.h0.a.i2.m.b(optString2);
            if (TextUtils.isEmpty(b2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                return false;
            }
            Uri parse = Uri.parse(u);
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                return false;
            }
            Uri fromFile = parse.getScheme() == null ? Uri.fromFile(new File(u)) : parse;
            SwanAppActivity v = eVar.v();
            if (v == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                return false;
            } else if (!d.a.h0.a.i2.m.a(b2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + b2);
                return false;
            } else {
                String optString3 = a2.optString("cb");
                d.a.h0.a.p.c.u o = d.a.h0.a.w0.a.o();
                if (!o.b(v, b2)) {
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + b2);
                        return false;
                    }
                    j(v, b2, fromFile, optString3, callbackHandler);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                o.c(v, fromFile, b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return true;
            }
        }
    }

    public final void j(Activity activity, String str, Uri uri, String str2, CallbackHandler callbackHandler) {
        d.a.h0.a.w0.a.o().a(activity, str, new a(this, activity, uri, str, callbackHandler, str2));
    }
}
