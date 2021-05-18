package d.a.i0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.i0.a.a2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.s1.f;
import d.a.i0.a.v2.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f42579c;

    /* renamed from: d  reason: collision with root package name */
    public String f42580d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42581e;

    /* renamed from: f  reason: collision with root package name */
    public String f42582f;

    /* renamed from: d.a.i0.a.i1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0696a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42585c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f42586d;

        public C0696a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f42583a = context;
            this.f42584b = unitedSchemeEntity;
            this.f42585c = callbackHandler;
            this.f42586d = eVar;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f42583a, this.f42584b, this.f42585c, this.f42586d);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42585c, this.f42584b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f42582f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42588e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42589f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f42590g;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f42588e = callbackHandler;
            this.f42589f = unitedSchemeEntity;
            this.f42590g = eVar;
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void e(String str) {
            d.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f42588e, this.f42589f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f42582f);
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42588e, this.f42589f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.i0.a.i1.d.c.d.m(list, this.f42590g, "album"), 0).toString(), a.this.f42582f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f42588e, this.f42589f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f42582f);
        }
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.x() != null) {
            if (eVar.d0()) {
                if (a0.f40775b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            this.f42582f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f42579c = d2.optInt("count");
            this.f42580d = d2.optString("mode");
            this.f42581e = d2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0696a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f42579c);
        bundle.putString("mode", this.f42580d);
        bundle.putBoolean("compressed", this.f42581e);
        bundle.putString("swanAppId", eVar.f40575f);
        bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
        d.a.i0.a.i1.d.c.d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
