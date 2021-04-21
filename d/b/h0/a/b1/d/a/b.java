package d.b.h0.a.b1.d.a;

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
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f44052c;

    /* renamed from: d  reason: collision with root package name */
    public String f44053d;

    /* renamed from: e  reason: collision with root package name */
    public String f44054e;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44056f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44057g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44058h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.h0.a.r1.e eVar) {
            this.f44055e = callbackHandler;
            this.f44056f = unitedSchemeEntity;
            this.f44057g = context;
            this.f44058h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                b.this.v(this.f44057g, this.f44056f, this.f44055e, this.f44058h);
                return;
            }
            d.b.h0.a.v1.c.c.n(hVar, this.f44055e, this.f44056f);
            d.b.h0.a.c0.c.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.b.h0.a.b1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0636b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44059a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44060b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44061c;

        public C0636b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
            this.f44059a = unitedSchemeEntity;
            this.f44060b = callbackHandler;
            this.f44061c = eVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f44059a, this.f44060b, this.f44061c);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f44060b, this.f44059a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f44054e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44063a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44064b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44065c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44066d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44067e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, boolean z) {
            this.f44063a = context;
            this.f44064b = unitedSchemeEntity;
            this.f44065c = callbackHandler;
            this.f44066d = eVar;
            this.f44067e = z;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f44063a, this.f44064b, this.f44065c, this.f44066d, this.f44067e);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f44065c, this.f44064b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f44054e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44071c;

        public d(d.b.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44069a = eVar;
            this.f44070b = callbackHandler;
            this.f44071c = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f47009b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.h0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f44070b, this.f44071c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.h0.a.b1.d.c.d.m(arrayList, this.f44069a, "Image"), 0).toString(), b.this.f44054e);
            }
            d.b.h0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.h0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44073a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.d.d.d f44074b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44075c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44076d;

        public e(d.b.h0.a.r1.e eVar, d.b.h0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44073a = eVar;
            this.f44074b = dVar;
            this.f44075c = callbackHandler;
            this.f44076d = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void a(File file) {
            d.b.h0.a.c0.c.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.b.h0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.h0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f44053d, "compressed"));
            bundle.putString("swanAppId", this.f44073a.f46461f);
            bundle.putParcelableArrayList("mediaModels", d.b.h0.a.b1.d.c.e.e());
            d.b.h0.a.b1.d.c.d.h(this.f44073a.n(), bundle, this.f44074b);
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f44075c, this.f44076d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f44054e);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44078a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44079b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44080c;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.h0.a.r1.e eVar) {
            this.f44078a = callbackHandler;
            this.f44079b = unitedSchemeEntity;
            this.f44080c = eVar;
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void a(String str) {
            d.b.h0.a.c0.c.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f44078a, this.f44079b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f44054e);
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.h0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f44078a, this.f44079b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.h0.a.b1.d.c.d.m(list, this.f44080c, "Image"), 0).toString(), b.this.f44054e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f44078a, this.f44079b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f44054e);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/chooseImage");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
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
            this.f44054e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(b2.optString("count"));
                this.f44052c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f44052c = 9;
                }
            } catch (NumberFormatException unused) {
                d.b.h0.a.c0.c.b("chooseImage", "count format error");
                this.f44052c = 9;
            }
            this.f44053d = r(b2.optJSONArray("sizeType"));
            JSONArray optJSONArray = b2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.b.h0.a.c0.c.g("chooseImage", "sizeType: " + this.f44053d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.R().g(eVar.n(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.b.h0.a.c0.c.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.b1.d.c.b.f(eVar.n(), eVar.f46461f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, boolean z) {
        d.b.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0636b(unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f44052c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f44053d, "compressed"));
        bundle.putString("swanAppId", eVar.f46461f);
        bundle.putString("swanTmpPath", d.b.h0.a.z0.f.V().y().j());
        d.b.h0.a.b1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
