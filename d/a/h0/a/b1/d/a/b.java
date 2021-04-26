package d.a.h0.a.b1.d.a;

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
import d.a.h0.a.i2.v;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f41325c;

    /* renamed from: d  reason: collision with root package name */
    public String f41326d;

    /* renamed from: e  reason: collision with root package name */
    public String f41327e;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41331h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.h0.a.r1.e eVar) {
            this.f41328e = callbackHandler;
            this.f41329f = unitedSchemeEntity;
            this.f41330g = context;
            this.f41331h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                b.this.v(this.f41330g, this.f41329f, this.f41328e, this.f41331h);
                return;
            }
            d.a.h0.a.v1.c.c.n(hVar, this.f41328e, this.f41329f);
            d.a.h0.a.c0.c.b("chooseImage", "camera authorize failure");
        }
    }

    /* renamed from: d.a.h0.a.b1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0575b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41333a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41335c;

        public C0575b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
            this.f41333a = unitedSchemeEntity;
            this.f41334b = callbackHandler;
            this.f41335c = eVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.t(this.f41333a, this.f41334b, this.f41335c);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f41334b, this.f41333a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f41327e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41337a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41339c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41340d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41341e;

        public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, boolean z) {
            this.f41337a = context;
            this.f41338b = unitedSchemeEntity;
            this.f41339c = callbackHandler;
            this.f41340d = eVar;
            this.f41341e = z;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", str + "");
            }
            b.this.x(this.f41337a, this.f41338b, this.f41339c, this.f41340d, this.f41341e);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f41339c, this.f41338b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), b.this.f41327e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41343a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41344b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41345c;

        public d(d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f41343a = eVar;
            this.f41344b = callbackHandler;
            this.f41345c = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44398b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.h0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f41344b, this.f41345c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.h0.a.b1.d.c.d.m(arrayList, this.f41343a, "Image"), 0).toString(), b.this.f41327e);
            }
            d.a.h0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.d.d.d f41348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41350d;

        public e(d.a.h0.a.r1.e eVar, d.a.h0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f41347a = eVar;
            this.f41348b = dVar;
            this.f41349c = callbackHandler;
            this.f41350d = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void a(File file) {
            d.a.h0.a.c0.c.g("chooseImage", "capture success");
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.h0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.h0.a.z0.f.V().I().k());
            bundle.putBoolean("compressed", TextUtils.equals(b.this.f41326d, "compressed"));
            bundle.putString("swanAppId", this.f41347a.f43823f);
            bundle.putParcelableArrayList("mediaModels", d.a.h0.a.b1.d.c.e.e());
            d.a.h0.a.b1.d.c.d.h(this.f41347a.v(), bundle, this.f41348b);
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f41349c, this.f41350d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), b.this.f41327e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41352a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41354c;

        public f(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.h0.a.r1.e eVar) {
            this.f41352a = callbackHandler;
            this.f41353b = unitedSchemeEntity;
            this.f41354c = eVar;
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void a(String str) {
            d.a.h0.a.c0.c.g("chooseImage", str);
            UnitedSchemeUtility.safeCallback(this.f41352a, this.f41353b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), b.this.f41327e);
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.a.h0.a.c0.c.g("chooseImage", "choose success");
                UnitedSchemeUtility.safeCallback(this.f41352a, this.f41353b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.h0.a.b1.d.c.d.m(list, this.f41354c, "Image"), 0).toString(), b.this.f41327e);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f41352a, this.f41353b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), b.this.f41327e);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/chooseImage");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
            this.f41327e = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.b("chooseImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                int parseInt = Integer.parseInt(b2.optString("count"));
                this.f41325c = parseInt;
                if (parseInt < 1 || parseInt > 9) {
                    this.f41325c = 9;
                }
            } catch (NumberFormatException unused) {
                d.a.h0.a.c0.c.b("chooseImage", "count format error");
                this.f41325c = 9;
            }
            this.f41326d = r(b2.optJSONArray("sizeType"));
            JSONArray optJSONArray = b2.optJSONArray("sourceType");
            String s = s(optJSONArray);
            d.a.h0.a.c0.c.g("chooseImage", "sizeType: " + this.f41326d + ",sourceType: " + s);
            if (TextUtils.equals(s, "album")) {
                u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
            } else {
                eVar.R().g(eVar.v(), PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        d.a.h0.a.c0.c.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.b1.d.c.b.f(eVar.v(), eVar.f43823f, new e(eVar, new d(eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, boolean z) {
        d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new c(context, unitedSchemeEntity, callbackHandler, eVar, z));
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0575b(unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "Image");
        bundle.putBoolean("isShowCamera", z);
        bundle.putInt("count", this.f41325c);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", TextUtils.equals(this.f41326d, "compressed"));
        bundle.putString("swanAppId", eVar.f43823f);
        bundle.putString("swanTmpPath", d.a.h0.a.z0.f.V().I().k());
        d.a.h0.a.b1.d.c.d.l(context, bundle, new f(callbackHandler, unitedSchemeEntity, eVar));
    }
}
