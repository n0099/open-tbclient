package d.a.m0.a.i1.d.a;

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
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f46550c;

    /* renamed from: d  reason: collision with root package name */
    public String f46551d;

    /* renamed from: e  reason: collision with root package name */
    public String f46552e;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46555g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46556h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.m0.a.a2.e eVar) {
            this.f46553e = callbackHandler;
            this.f46554f = unitedSchemeEntity;
            this.f46555g = context;
            this.f46556h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                b.this.v(this.f46555g, this.f46554f, this.f46553e, this.f46556h);
                return;
            }
            d.a.m0.a.e2.c.d.o(iVar, this.f46553e, this.f46554f);
            d.a.m0.a.e0.d.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.a.m0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0767b implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46558a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46560c;

        public C0767b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
            this.f46558a = unitedSchemeEntity;
            this.f46559b = callbackHandler;
            this.f46560c = eVar;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f46558a, this.f46559b, this.f46560c);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46559b, this.f46558a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f46552e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46563b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46564c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46565d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46566e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, boolean z) {
            this.f46562a = context;
            this.f46563b = unitedSchemeEntity;
            this.f46564c = callbackHandler;
            this.f46565d = eVar;
            this.f46566e = z;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f46562a, this.f46563b, this.f46564c, this.f46565d, this.f46566e);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46564c, this.f46563b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f46552e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46568a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46569b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46570c;

        public d(d.a.m0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46568a = eVar;
            this.f46569b = callbackHandler;
            this.f46570c = unitedSchemeEntity;
        }

        @Override // d.a.m0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44733b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.m0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46569b, this.f46570c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.m0.a.i1.d.c.d.m(arrayList, this.f46568a, "Image"), 0).toString(), b.this.f46552e);
            }
            d.a.m0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.d.d f46573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46575d;

        public e(d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46572a = eVar;
            this.f46573b = dVar;
            this.f46574c = callbackHandler;
            this.f46575d = unitedSchemeEntity;
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void a(File file) {
            d.a.m0.a.e0.d.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.m0.a.i1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f46551d, "compressed"));
            bundle.putString("swanAppId", this.f46572a.f44533f);
            bundle.putParcelableArrayList("mediaModels", d.a.m0.a.i1.d.c.e.e());
            d.a.m0.a.i1.d.c.d.h(this.f46572a.x(), bundle, this.f46573b);
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f46574c, this.f46575d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f46552e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46577e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46578f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46579g;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.a2.e eVar) {
            this.f46577e = callbackHandler;
            this.f46578f = unitedSchemeEntity;
            this.f46579g = eVar;
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void e(String str) {
            d.a.m0.a.e0.d.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f46577e, this.f46578f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f46552e);
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.m0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46577e, this.f46578f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.m0.a.i1.d.c.d.m(list, this.f46579g, "Image"), 0).toString(), b.this.f46552e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f46577e, this.f46578f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f46552e);
        }
    }

    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseImage");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
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
            this.f46552e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.m0.a.e0.d.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(d2.optString("count"));
                this.f46550c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f46550c = 9;
                }
            } catch (NumberFormatException unused) {
                d.a.m0.a.e0.d.b("chooseImage", "count format error");
                this.f46550c = 9;
            }
            this.f46551d = r(d2.optJSONArray("sizeType"));
            JSONArray optJSONArray = d2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.a.m0.a.e0.d.g("chooseImage", "sizeType: " + this.f46551d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.m0.a.e0.d.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.i1.d.c.b.f(eVar.x(), eVar.f44533f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, boolean z) {
        d.a.m0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0767b(unitedSchemeEntity, callbackHandler, eVar));
    }

    public final boolean w(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (TextUtils.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONArray.optString(i2))) {
                return true;
            }
        }
        return false;
    }

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f46550c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f46551d, "compressed"));
        bundle.putString("swanAppId", eVar.f44533f);
        bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
        d.a.m0.a.i1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
