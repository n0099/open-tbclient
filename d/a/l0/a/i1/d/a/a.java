package d.a.l0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.s1.f;
import d.a.l0.a.v2.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f42753c;

    /* renamed from: d  reason: collision with root package name */
    public String f42754d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42755e;

    /* renamed from: f  reason: collision with root package name */
    public String f42756f;

    /* renamed from: d.a.l0.a.i1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0707a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42758b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42759c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f42760d;

        public C0707a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f42757a = context;
            this.f42758b = unitedSchemeEntity;
            this.f42759c = callbackHandler;
            this.f42760d = eVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f42757a, this.f42758b, this.f42759c, this.f42760d);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42759c, this.f42758b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f42756f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f42764g;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f42762e = callbackHandler;
            this.f42763f = unitedSchemeEntity;
            this.f42764g = eVar;
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void e(String str) {
            d.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f42762e, this.f42763f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f42756f);
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42762e, this.f42763f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.m(list, this.f42764g, "album"), 0).toString(), a.this.f42756f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f42762e, this.f42763f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f42756f);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.x() != null) {
            if (eVar.d0()) {
                if (a0.f40949b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            this.f42756f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f42753c = d2.optInt("count");
            this.f42754d = d2.optString("mode");
            this.f42755e = d2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.l0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0707a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f42753c);
        bundle.putString("mode", this.f42754d);
        bundle.putBoolean("compressed", this.f42755e);
        bundle.putString("swanAppId", eVar.f40749f);
        bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
        d.a.l0.a.i1.d.c.d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
