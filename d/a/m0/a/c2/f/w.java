package d.a.m0.a.c2.f;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.yy.gslbsdk.db.DelayTB;
import d.a.m0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45060e;

        public a(w wVar, Context context) {
            this.f45060e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "5");
            d.a.m0.a.v1.c.f.b.k(this.f45060e, bundle);
        }
    }

    public w(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/preloadSwanCore");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("PreloadSwanCoreAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!ProcessUtils.isMainProcess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal process");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        int optInt = a2 == null ? 0 : a2.optInt(DelayTB.DELAY, 0);
        if (optInt < 0) {
            optInt = 0;
        }
        if (a0.f44733b) {
            Log.d("PreloadSwanCoreAction", "delay: " + optInt);
        }
        q0.Y(new a(this, context), optInt);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
