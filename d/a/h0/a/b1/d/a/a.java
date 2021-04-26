package d.a.h0.a.b1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.h0.a.b1.d.c.d;
import d.a.h0.a.i2.v;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.z0.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f41312c;

    /* renamed from: d  reason: collision with root package name */
    public String f41313d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41314e;

    /* renamed from: f  reason: collision with root package name */
    public String f41315f;

    /* renamed from: d.a.h0.a.b1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0574a implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41316a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41318c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f41319d;

        public C0574a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f41316a = context;
            this.f41317b = unitedSchemeEntity;
            this.f41318c = callbackHandler;
            this.f41319d = eVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f41316a, this.f41317b, this.f41318c, this.f41319d);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f41318c, this.f41317b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f41315f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41321a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41322b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f41323c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f41321a = callbackHandler;
            this.f41322b = unitedSchemeEntity;
            this.f41323c = eVar;
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void a(String str) {
            d.a.h0.a.c0.c.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f41321a, this.f41322b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f41315f);
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.a.h0.a.c0.c.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f41321a, this.f41322b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.m(list, this.f41323c, "album"), 0).toString(), a.this.f41315f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f41321a, this.f41322b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f41315f);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.v() != null) {
            if (eVar.Z()) {
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
            String optString = b2.optString("cb");
            this.f41315f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f41312c = b2.optInt("count");
            this.f41313d = b2.optString("mode");
            this.f41314e = b2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0574a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f41312c);
        bundle.putString("mode", this.f41313d);
        bundle.putBoolean("compressed", this.f41314e);
        bundle.putString("swanAppId", eVar.f43823f);
        bundle.putString("swanTmpPath", f.V().I().k());
        d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
