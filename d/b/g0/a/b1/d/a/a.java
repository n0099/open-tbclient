package d.b.g0.a.b1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.g0.a.b1.d.c.d;
import d.b.g0.a.i2.v;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.z0.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f43318c;

    /* renamed from: d  reason: collision with root package name */
    public String f43319d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43320e;

    /* renamed from: f  reason: collision with root package name */
    public String f43321f;

    /* renamed from: d.b.g0.a.b1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0603a implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43324c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f43325d;

        public C0603a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f43322a = context;
            this.f43323b = unitedSchemeEntity;
            this.f43324c = callbackHandler;
            this.f43325d = eVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46288b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f43322a, this.f43323b, this.f43324c, this.f43325d);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43324c, this.f43323b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f43321f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43327a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f43329c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f43327a = callbackHandler;
            this.f43328b = unitedSchemeEntity;
            this.f43329c = eVar;
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void a(String str) {
            d.b.g0.a.c0.c.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f43327a, this.f43328b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f43321f);
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.g0.a.c0.c.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43327a, this.f43328b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.m(list, this.f43329c, "album"), 0).toString(), a.this.f43321f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f43327a, this.f43328b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f43321f);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.n() != null) {
            if (eVar.Z()) {
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
            String optString = b2.optString("cb");
            this.f43321f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f43318c = b2.optInt("count");
            this.f43319d = b2.optString("mode");
            this.f43320e = b2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0603a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f43318c);
        bundle.putString("mode", this.f43319d);
        bundle.putBoolean("compressed", this.f43320e);
        bundle.putString("swanAppId", eVar.f45740f);
        bundle.putString("swanTmpPath", f.V().y().j());
        d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
