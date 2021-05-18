package d.a.i0.a.i1.d.a;

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
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f42592c;

    /* renamed from: d  reason: collision with root package name */
    public String f42593d;

    /* renamed from: e  reason: collision with root package name */
    public String f42594e;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f42597g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42598h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.i0.a.a2.e eVar) {
            this.f42595e = callbackHandler;
            this.f42596f = unitedSchemeEntity;
            this.f42597g = context;
            this.f42598h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                b.this.v(this.f42597g, this.f42596f, this.f42595e, this.f42598h);
                return;
            }
            d.a.i0.a.e2.c.d.o(iVar, this.f42595e, this.f42596f);
            d.a.i0.a.e0.d.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.a.i0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0697b implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42600a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42602c;

        public C0697b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
            this.f42600a = unitedSchemeEntity;
            this.f42601b = callbackHandler;
            this.f42602c = eVar;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f42600a, this.f42601b, this.f42602c);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42601b, this.f42600a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f42594e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42604a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42605b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42606c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42607d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f42608e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, boolean z) {
            this.f42604a = context;
            this.f42605b = unitedSchemeEntity;
            this.f42606c = callbackHandler;
            this.f42607d = eVar;
            this.f42608e = z;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f42604a, this.f42605b, this.f42606c, this.f42607d, this.f42608e);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42606c, this.f42605b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f42594e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42610a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42611b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42612c;

        public d(d.a.i0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42610a = eVar;
            this.f42611b = callbackHandler;
            this.f42612c = unitedSchemeEntity;
        }

        @Override // d.a.i0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f40775b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.i0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42611b, this.f42612c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.i0.a.i1.d.c.d.m(arrayList, this.f42610a, "Image"), 0).toString(), b.this.f42594e);
            }
            d.a.i0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.i0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.d.d f42615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42616c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42617d;

        public e(d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42614a = eVar;
            this.f42615b = dVar;
            this.f42616c = callbackHandler;
            this.f42617d = unitedSchemeEntity;
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void a(File file) {
            d.a.i0.a.e0.d.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.i0.a.i1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f42593d, "compressed"));
            bundle.putString("swanAppId", this.f42614a.f40575f);
            bundle.putParcelableArrayList("mediaModels", d.a.i0.a.i1.d.c.e.e());
            d.a.i0.a.i1.d.c.d.h(this.f42614a.x(), bundle, this.f42615b);
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f42616c, this.f42617d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f42594e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.i0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42620f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42621g;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.i0.a.a2.e eVar) {
            this.f42619e = callbackHandler;
            this.f42620f = unitedSchemeEntity;
            this.f42621g = eVar;
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void e(String str) {
            d.a.i0.a.e0.d.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f42619e, this.f42620f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f42594e);
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.i0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42619e, this.f42620f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.i0.a.i1.d.c.d.m(list, this.f42621g, "Image"), 0).toString(), b.this.f42594e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f42619e, this.f42620f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f42594e);
        }
    }

    public b(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseImage");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
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
            this.f42594e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.i0.a.e0.d.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(d2.optString("count"));
                this.f42592c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f42592c = 9;
                }
            } catch (NumberFormatException unused) {
                d.a.i0.a.e0.d.b("chooseImage", "count format error");
                this.f42592c = 9;
            }
            this.f42593d = r(d2.optJSONArray("sizeType"));
            JSONArray optJSONArray = d2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.a.i0.a.e0.d.g("chooseImage", "sizeType: " + this.f42593d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.i0.a.e0.d.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.i1.d.c.b.f(eVar.x(), eVar.f40575f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, boolean z) {
        d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0697b(unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f42592c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f42593d, "compressed"));
        bundle.putString("swanAppId", eVar.f40575f);
        bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
        d.a.i0.a.i1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
