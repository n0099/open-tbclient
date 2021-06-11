package d.a.l0.a.i1.d.a;

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
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f46442c;

    /* renamed from: d  reason: collision with root package name */
    public String f46443d;

    /* renamed from: e  reason: collision with root package name */
    public String f46444e;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46447g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46448h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.a2.e eVar) {
            this.f46445e = callbackHandler;
            this.f46446f = unitedSchemeEntity;
            this.f46447g = context;
            this.f46448h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                b.this.v(this.f46447g, this.f46446f, this.f46445e, this.f46448h);
                return;
            }
            d.a.l0.a.e2.c.d.o(iVar, this.f46445e, this.f46446f);
            d.a.l0.a.e0.d.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.a.l0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0764b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46450a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46451b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46452c;

        public C0764b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
            this.f46450a = unitedSchemeEntity;
            this.f46451b = callbackHandler;
            this.f46452c = eVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f46450a, this.f46451b, this.f46452c);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46451b, this.f46450a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f46444e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46454a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46455b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46456c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46457d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46458e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, boolean z) {
            this.f46454a = context;
            this.f46455b = unitedSchemeEntity;
            this.f46456c = callbackHandler;
            this.f46457d = eVar;
            this.f46458e = z;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f46454a, this.f46455b, this.f46456c, this.f46457d, this.f46458e);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46456c, this.f46455b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f46444e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46460a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46461b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46462c;

        public d(d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46460a = eVar;
            this.f46461b = callbackHandler;
            this.f46462c = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44625b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.l0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46461b, this.f46462c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.m(arrayList, this.f46460a, "Image"), 0).toString(), b.this.f46444e);
            }
            d.a.l0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.d.d f46465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46466c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46467d;

        public e(d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46464a = eVar;
            this.f46465b = dVar;
            this.f46466c = callbackHandler;
            this.f46467d = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void a(File file) {
            d.a.l0.a.e0.d.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.l0.a.i1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f46443d, "compressed"));
            bundle.putString("swanAppId", this.f46464a.f44425f);
            bundle.putParcelableArrayList("mediaModels", d.a.l0.a.i1.d.c.e.e());
            d.a.l0.a.i1.d.c.d.h(this.f46464a.x(), bundle, this.f46465b);
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f46466c, this.f46467d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f46444e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46471g;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.a2.e eVar) {
            this.f46469e = callbackHandler;
            this.f46470f = unitedSchemeEntity;
            this.f46471g = eVar;
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void e(String str) {
            d.a.l0.a.e0.d.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f46469e, this.f46470f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f46444e);
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.l0.a.e0.d.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46469e, this.f46470f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.m(list, this.f46471g, "Image"), 0).toString(), b.this.f46444e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f46469e, this.f46470f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f46444e);
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseImage");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar != null && eVar.x() != null) {
            if (eVar.d0()) {
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            this.f46444e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.e0.d.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(d2.optString("count"));
                this.f46442c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f46442c = 9;
                }
            } catch (NumberFormatException unused) {
                d.a.l0.a.e0.d.b("chooseImage", "count format error");
                this.f46442c = 9;
            }
            this.f46443d = r(d2.optJSONArray("sizeType"));
            JSONArray optJSONArray = d2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.a.l0.a.e0.d.g("chooseImage", "sizeType: " + this.f46443d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.l0.a.e0.d.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.i1.d.c.b.f(eVar.x(), eVar.f44425f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, boolean z) {
        d.a.l0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0764b(unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f46442c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f46443d, "compressed"));
        bundle.putString("swanAppId", eVar.f44425f);
        bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
        d.a.l0.a.i1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
