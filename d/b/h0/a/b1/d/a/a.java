package d.b.h0.a.b1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.a.b1.d.c.d;
import d.b.h0.a.i2.v;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.z0.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f44039c;

    /* renamed from: d  reason: collision with root package name */
    public String f44040d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44041e;

    /* renamed from: f  reason: collision with root package name */
    public String f44042f;

    /* renamed from: d.b.h0.a.b1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0635a implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44043a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44044b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44045c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f44046d;

        public C0635a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f44043a = context;
            this.f44044b = unitedSchemeEntity;
            this.f44045c = callbackHandler;
            this.f44046d = eVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.n(this.f44043a, this.f44044b, this.f44045c, this.f44046d);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f44045c, this.f44044b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), a.this.f44042f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44049b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f44050c;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f44048a = callbackHandler;
            this.f44049b = unitedSchemeEntity;
            this.f44050c = eVar;
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void a(String str) {
            d.b.h0.a.c0.c.b("chooseAlbum", str);
            UnitedSchemeUtility.safeCallback(this.f44048a, this.f44049b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), a.this.f44042f);
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.h0.a.c0.c.g("chooseAlbum", "choose success");
                UnitedSchemeUtility.safeCallback(this.f44048a, this.f44049b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.m(list, this.f44050c, "album"), 0).toString(), a.this.f44042f);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f44048a, this.f44049b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), a.this.f44042f);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAlbum");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.n() != null) {
            if (eVar.Z()) {
                if (a0.f47009b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
            String optString = b2.optString("cb");
            this.f44042f = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.b("chooseAlbum", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                return false;
            }
            this.f44039c = b2.optInt("count");
            this.f44040d = b2.optString("mode");
            this.f44041e = b2.optBoolean("compressed");
            m(context, unitedSchemeEntity, callbackHandler, eVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.h0.a.c0.c.b("chooseAlbum", "runtime exception");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
        return false;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.b.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0635a(context, unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "album");
        bundle.putBoolean("isShowCamera", false);
        bundle.putInt("count", this.f44039c);
        bundle.putString("mode", this.f44040d);
        bundle.putBoolean("compressed", this.f44041e);
        bundle.putString("swanAppId", eVar.f46461f);
        bundle.putString("swanTmpPath", f.V().y().j());
        d.l(context, bundle, new b(callbackHandler, unitedSchemeEntity, eVar));
    }
}
