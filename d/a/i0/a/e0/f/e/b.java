package d.a.i0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.c2.f.a0;
/* loaded from: classes2.dex */
public class b extends a0 {
    public b(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/remoteDebug");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.e0.d.g("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.e0.d.g("RemoteDebugAction", "handleSubAction subAction: " + str);
        if (!e.d()) {
            d.a.i0.a.e0.d.b("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -279631955) {
            if (hashCode == 1013845168 && str.equals("/swanAPI/remoteDebug/reload")) {
                c2 = 0;
            }
        } else if (str.equals("/swanAPI/remoteDebug/shutdown")) {
            c2 = 1;
        }
        if (c2 == 0) {
            d.a.i0.a.e0.d.g("RemoteDebugAction", "Remote Debug reload");
            if (x != null) {
                Intent intent = x.getIntent();
                e.f();
                d.a.i0.a.a2.d.g().o(new String[0]);
                d.a.i0.a.a2.d.g().m(intent.getExtras(), "update_tag_by_remote_debug");
            }
            return true;
        } else if (c2 != 1) {
            return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else {
            if (x != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    x.finishAndRemoveTask();
                } else {
                    x.finish();
                }
                System.exit(0);
            }
            return true;
        }
    }
}
