package d.a.h0.a.b1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.h0.a.b1.d.c.f;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41356a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41357b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41358c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f41359d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
            this.f41356a = unitedSchemeEntity;
            this.f41357b = callbackHandler;
            this.f41358c = eVar;
            this.f41359d = fVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f41356a, this.f41357b, this.f41358c, this.f41359d);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f41357b, this.f41356a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f41359d.f41440c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41361a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41362b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41363c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41364d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f41365e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
            this.f41361a = context;
            this.f41362b = unitedSchemeEntity;
            this.f41363c = callbackHandler;
            this.f41364d = eVar;
            this.f41365e = fVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f41361a, this.f41362b, this.f41363c, this.f41364d, this.f41365e);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f41363c, this.f41362b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f41365e.f41440c);
        }
    }

    /* renamed from: d.a.h0.a.b1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0576c implements d.a.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41368b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41369c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f41370d;

        public C0576c(c cVar, d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar) {
            this.f41367a = eVar;
            this.f41368b = callbackHandler;
            this.f41369c = unitedSchemeEntity;
            this.f41370d = fVar;
        }

        @Override // d.a.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44398b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.h0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f41368b, this.f41369c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.h0.a.b1.d.c.d.n(arrayList, this.f41367a), 0).toString(), this.f41370d.f41440c);
            }
            d.a.h0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f41371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41372b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.d.d.d f41373c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41374d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41375e;

        public d(c cVar, f fVar, d.a.h0.a.r1.e eVar, d.a.h0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f41371a = fVar;
            this.f41372b = eVar;
            this.f41373c = dVar;
            this.f41374d = callbackHandler;
            this.f41375e = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void a(File file) {
            d.a.h0.a.c0.c.g("chooseVideo", "capture success");
            d.a.h0.a.b1.d.c.e.i(d.a.h0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.h0.a.z0.f.V().I().k());
            bundle.putBoolean("compressed", this.f41371a.f41439b);
            bundle.putString("swanAppId", this.f41372b.f43823f);
            bundle.putParcelableArrayList("mediaModels", d.a.h0.a.b1.d.c.e.e());
            d.a.h0.a.b1.d.c.d.h(this.f41372b.v(), bundle, this.f41373c);
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f41374d, this.f41375e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f41371a.f41440c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41376a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41377b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f41378c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f41379d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar, d.a.h0.a.r1.e eVar) {
            this.f41376a = callbackHandler;
            this.f41377b = unitedSchemeEntity;
            this.f41378c = fVar;
            this.f41379d = eVar;
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void a(String str) {
            d.a.h0.a.c0.c.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f41376a, this.f41377b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f41378c.f41440c);
        }

        @Override // d.a.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.a.h0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f41376a, this.f41377b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.h0.a.b1.d.c.d.n(list, this.f41379d), 0).toString(), this.f41378c.f41440c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f41376a, this.f41377b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f41378c.f41440c);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f a2 = f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f41438a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
        d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
        d dVar = new d(this, fVar, eVar, new C0576c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.a.h0.a.b1.d.c.b.e(eVar.v(), eVar.f43823f, fVar.f41442e, TextUtils.equals(fVar.f41441d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f41438a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f41441d, "front"));
        bundle.putInt("maxDuration", fVar.f41442e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f41439b);
        bundle.putString("swanAppId", eVar.f43823f);
        bundle.putString("swanTmpPath", d.a.h0.a.z0.f.V().I().k());
        d.a.h0.a.b1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
