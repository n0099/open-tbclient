package d.a.l0.a.w1.f;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.publisher.PublishParams;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import d.a.l0.a.z1.b.b.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45565c = k.f43199a;

    /* loaded from: classes3.dex */
    public static final class a implements d.a.l0.a.w1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45566a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45567b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45568c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f45569d;

        public a(String str, c cVar, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            this.f45566a = str;
            this.f45567b = unitedSchemeEntity;
            this.f45568c = callbackHandler;
            this.f45569d = context;
        }

        @Override // d.a.l0.a.w1.a
        public void a(JSONObject jSONObject) {
            if (jSONObject != null) {
                UnitedSchemeUtility.safeCallback(this.f45568c, this.f45567b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f45566a);
            } else {
                UnitedSchemeUtility.safeCallback(this.f45568c, this.f45567b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.f45566a);
            }
        }

        @Override // d.a.l0.a.w1.a
        public void onCancel() {
            UnitedSchemeUtility.safeCallback(this.f45568c, this.f45567b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.f45566a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public static final b f45570e = new b();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.l0.a.c2.e dispatcher) {
        super(dispatcher, "/swanAPI/community/openCommunityEditor");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, e eVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (eVar != null) {
            if (eVar.d0()) {
                if (f45565c) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            f V = f.V();
            Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
            g W = V.W();
            if (W != null && (W.m() instanceof d.a.l0.a.w1.c)) {
                entity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            JSONObject d2 = w.d(entity.getParam("params"));
            Intrinsics.checkNotNullExpressionValue(d2, "SwanAppJSONUtils.parseString(params)");
            String optString = d2.optString("cb");
            if (optString == null || optString.length() == 0) {
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (f45565c) {
                Log.d("OpenPublisherAction", "调起参数:" + d2);
            }
            a aVar = new a(optString, this, eVar, entity, callbackHandler, context);
            PublishParams a2 = d.a.l0.a.w1.b.a(d2);
            if (a2 != null) {
                d.a.l0.a.w1.c cVar = new d.a.l0.a.w1.c();
                cVar.q3(aVar);
                Bundle bundle = new Bundle();
                bundle.putParcelable("params", a2);
                cVar.j1(bundle);
                f controller = f.V();
                Intrinsics.checkNotNullExpressionValue(controller, "controller");
                g W2 = controller.W();
                if (W2 != null) {
                    g.b i2 = W2.i("navigateTo");
                    i2.n(g.f42076g, g.f42078i);
                    i2.j(cVar);
                    i2.a();
                    UnitedSchemeUtility.callCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(1, "can get fragment manager").toString(), optString);
                return false;
            }
            if (f45565c) {
                Log.d("OpenPublisherAction", "解析调起参数失败");
            }
            j(context);
            return false;
        }
        entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
        return false;
    }

    public final void j(Context context) {
        h.a aVar = new h.a(context);
        aVar.m(false);
        aVar.U(d.a.l0.a.h.swanapp_publisher_error_title);
        aVar.v(d.a.l0.a.h.swanapp_publisher_params_error);
        aVar.O(d.a.l0.a.h.aiapps_confirm, b.f45570e);
        aVar.X();
    }
}
