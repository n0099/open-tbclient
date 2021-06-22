package d.a.m0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.m0.a.a2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import d.a.m0.a.s1.f;
import d.a.m0.a.v2.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f46537c;

    /* renamed from: d  reason: collision with root package name */
    public String f46538d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46539e;

    /* renamed from: f  reason: collision with root package name */
    public String f46540f;

    /* renamed from: d.a.m0.a.i1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0766a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46542b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46543c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f46544d;

        public C0766a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f46541a = context;
            this.f46542b = unitedSchemeEntity;
            this.f46543c = callbackHandler;
            this.f46544d = eVar;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f46541a, this.f46542b, this.f46543c, this.f46544d);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46543c, this.f46542b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f46540f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46547f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46548g;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f46546e = callbackHandler;
            this.f46547f = unitedSchemeEntity;
            this.f46548g = eVar;
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void e(String str) {
            d.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f46546e, this.f46547f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f46540f);
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46546e, this.f46547f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.m0.a.i1.d.c.d.m(list, this.f46548g, "album"), 0).toString(), a.this.f46540f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f46546e, this.f46547f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f46540f);
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.x() != null) {
            if (eVar.d0()) {
                if (a0.f44733b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            this.f46540f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f46537c = d2.optInt("count");
            this.f46538d = d2.optString("mode");
            this.f46539e = d2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.m0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0766a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f46537c);
        bundle.putString("mode", this.f46538d);
        bundle.putBoolean("compressed", this.f46539e);
        bundle.putString("swanAppId", eVar.f44533f);
        bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
        d.a.m0.a.i1.d.c.d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
