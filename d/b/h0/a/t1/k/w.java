package d.b.h0.a.t1.k;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47288e;

        public a(w wVar, Context context) {
            this.f47288e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "5");
            d.b.h0.a.n1.c.f.b.i(this.f47288e, bundle);
        }
    }

    public w(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/preloadSwanCore");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("PreloadSwanCoreAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!ProcessUtils.isMainProcess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal process");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        int optInt = a2 == null ? 0 : a2.optInt("delay", 0);
        if (optInt < 0) {
            optInt = 0;
        }
        if (a0.f47009b) {
            Log.d("PreloadSwanCoreAction", "delay: " + optInt);
        }
        k0.U(new a(this, context), optInt);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
