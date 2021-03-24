package d.b.g0.a.c0.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(j jVar) {
        super(jVar, "/swanAPI/remoteDebug");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
        return false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("RemoteDebugAction", "handleSubAction subAction: " + str);
        if (!e.d()) {
            d.b.g0.a.c0.c.b("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppActivity n = d.b.g0.a.r1.d.e().n();
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
            d.b.g0.a.c0.c.g("RemoteDebugAction", "Remote Debug reload");
            if (n != null) {
                Intent intent = n.getIntent();
                e.f();
                d.b.g0.a.r1.d.e().m(new String[0]);
                d.b.g0.a.r1.d.e().j(intent.getExtras(), "update_tag_by_remote_debug");
            }
            return true;
        } else if (c2 != 1) {
            return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else {
            if (n != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    n.finishAndRemoveTask();
                } else {
                    n.finish();
                }
                System.exit(0);
            }
            return true;
        }
    }
}
