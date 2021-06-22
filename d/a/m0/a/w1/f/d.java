package d.a.m0.a.w1.f;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.v2.w;
import d.a.m0.a.z1.b.b.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.w1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49353a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49354b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49355c;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f49353a = callbackHandler;
            this.f49354b = unitedSchemeEntity;
            this.f49355c = str;
        }

        @Override // d.a.m0.a.w1.a
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                UnitedSchemeUtility.safeCallback(this.f49353a, this.f49354b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.f49355c);
            } else {
                UnitedSchemeUtility.safeCallback(this.f49353a, this.f49354b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f49355c);
            }
        }

        @Override // d.a.m0.a.w1.a
        public void onCancel() {
            UnitedSchemeUtility.safeCallback(this.f49353a, this.f49354b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.f49355c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public b(d dVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public d(e eVar) {
        super(eVar, "/swanAPI/community/openReplyEditor");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
            return false;
        } else if (eVar.d0()) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a aVar = new a(this, callbackHandler, unitedSchemeEntity, optString);
            ReplyEditorParams a2 = ReplyEditorParams.a(d2);
            if (a2 == null) {
                j(context);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params info");
                return false;
            }
            d.a.m0.a.w1.e.c().e(eVar, a2, aVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public final void j(Context context) {
        h.a aVar = new h.a(context);
        aVar.m(false);
        aVar.U(d.a.m0.a.h.swanapp_publisher_error_title);
        aVar.v(d.a.m0.a.h.swanapp_publisher_params_error);
        aVar.O(d.a.m0.a.h.aiapps_confirm, new b(this));
        aVar.X();
    }
}
