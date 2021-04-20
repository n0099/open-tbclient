package d.b.g0.a.b1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f43723c;

    /* renamed from: d  reason: collision with root package name */
    public String f43724d;

    /* renamed from: e  reason: collision with root package name */
    public String f43725e;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43727f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43728g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43729h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar) {
            this.f43726e = callbackHandler;
            this.f43727f = unitedSchemeEntity;
            this.f43728g = context;
            this.f43729h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                b.this.v(this.f43728g, this.f43727f, this.f43726e, this.f43729h);
                return;
            }
            d.b.g0.a.v1.c.c.n(hVar, this.f43726e, this.f43727f);
            d.b.g0.a.c0.c.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.b.g0.a.b1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0616b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43730a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43732c;

        public C0616b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
            this.f43730a = unitedSchemeEntity;
            this.f43731b = callbackHandler;
            this.f43732c = eVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f43730a, this.f43731b, this.f43732c);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43731b, this.f43730a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f43725e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43736c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43737d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f43738e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, boolean z) {
            this.f43734a = context;
            this.f43735b = unitedSchemeEntity;
            this.f43736c = callbackHandler;
            this.f43737d = eVar;
            this.f43738e = z;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f43734a, this.f43735b, this.f43736c, this.f43737d, this.f43738e);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43736c, this.f43735b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f43725e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43740a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43741b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43742c;

        public d(d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43740a = eVar;
            this.f43741b = callbackHandler;
            this.f43742c = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f46680b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.g0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43741b, this.f43742c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.m(arrayList, this.f43740a, "Image"), 0).toString(), b.this.f43725e);
            }
            d.b.g0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.d f43745b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43746c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43747d;

        public e(d.b.g0.a.r1.e eVar, d.b.g0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43744a = eVar;
            this.f43745b = dVar;
            this.f43746c = callbackHandler;
            this.f43747d = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            d.b.g0.a.c0.c.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.b.g0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f43724d, "compressed"));
            bundle.putString("swanAppId", this.f43744a.f46132f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            d.b.g0.a.b1.d.c.d.h(this.f43744a.n(), bundle, this.f43745b);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f43746c, this.f43747d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f43725e);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.g0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43749a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43750b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43751c;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.r1.e eVar) {
            this.f43749a = callbackHandler;
            this.f43750b = unitedSchemeEntity;
            this.f43751c = eVar;
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void a(String str) {
            d.b.g0.a.c0.c.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f43749a, this.f43750b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f43725e);
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.g0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43749a, this.f43750b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.m(list, this.f43751c, "Image"), 0).toString(), b.this.f43725e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f43749a, this.f43750b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f43725e);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/chooseImage");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.n() != null) {
            if (eVar.Z()) {
                if (a0.f46680b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
            String optString = b2.optString("cb");
            this.f43725e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(b2.optString("count"));
                this.f43723c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f43723c = 9;
                }
            } catch (NumberFormatException unused) {
                d.b.g0.a.c0.c.b("chooseImage", "count format error");
                this.f43723c = 9;
            }
            this.f43724d = r(b2.optJSONArray("sizeType"));
            JSONArray optJSONArray = b2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.b.g0.a.c0.c.g("chooseImage", "sizeType: " + this.f43724d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.R().g(eVar.n(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.g0.a.c0.c.b("chooseImage", "illegal swanApp");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
        return false;
    }

    public final String r(JSONArray jSONArray) {
        boolean z = true;
        return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("original", jSONArray.optString(0))) ? false : false ? "original" : "compressed";
    }

    public final String s(JSONArray jSONArray) {
        boolean z = true;
        return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONArray.optString(0))) ? false : false ? BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA : "album";
    }

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.b1.d.c.b.f(eVar.n(), eVar.f46132f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, boolean z) {
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0616b(unitedSchemeEntity, callbackHandler, eVar));
    }

    public final boolean w(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (TextUtils.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONArray.optString(i))) {
                return true;
            }
        }
        return false;
    }

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f43723c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f43724d, "compressed"));
        bundle.putString("swanAppId", eVar.f46132f);
        bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
        d.b.g0.a.b1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
