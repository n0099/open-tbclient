package d.a.l0.a.i1.d.a;

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
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.s1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46475c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f46476d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
            this.f46473a = unitedSchemeEntity;
            this.f46474b = callbackHandler;
            this.f46475c = eVar;
            this.f46476d = fVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f46473a, this.f46474b, this.f46475c, this.f46476d);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46474b, this.f46473a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46476d.f46557c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46480c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46481d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f46482e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
            this.f46478a = context;
            this.f46479b = unitedSchemeEntity;
            this.f46480c = callbackHandler;
            this.f46481d = eVar;
            this.f46482e = fVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f46478a, this.f46479b, this.f46480c, this.f46481d, this.f46482e);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46480c, this.f46479b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46482e.f46557c);
        }
    }

    /* renamed from: d.a.l0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0765c implements d.a.l0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46486c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f46487d;

        public C0765c(c cVar, d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.i1.d.c.f fVar) {
            this.f46484a = eVar;
            this.f46485b = callbackHandler;
            this.f46486c = unitedSchemeEntity;
            this.f46487d = fVar;
        }

        @Override // d.a.l0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44625b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.l0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46485b, this.f46486c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.n(arrayList, this.f46484a), 0).toString(), this.f46487d.f46557c);
            }
            d.a.l0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f46488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46489b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.d.d f46490c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46491d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46492e;

        public d(c cVar, d.a.l0.a.i1.d.c.f fVar, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46488a = fVar;
            this.f46489b = eVar;
            this.f46490c = dVar;
            this.f46491d = callbackHandler;
            this.f46492e = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void a(File file) {
            d.a.l0.a.e0.d.g("chooseVideo", "capture success");
            d.a.l0.a.i1.d.c.e.i(d.a.l0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", this.f46488a.f46556b);
            bundle.putString("swanAppId", this.f46489b.f44425f);
            bundle.putParcelableArrayList("mediaModels", d.a.l0.a.i1.d.c.e.e());
            d.a.l0.a.i1.d.c.d.h(this.f46489b.x(), bundle, this.f46490c);
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f46491d, this.f46492e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f46488a.f46557c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46494f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f46495g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46496h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.i1.d.c.f fVar, d.a.l0.a.a2.e eVar) {
            this.f46493e = callbackHandler;
            this.f46494f = unitedSchemeEntity;
            this.f46495g = fVar;
            this.f46496h = eVar;
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void e(String str) {
            d.a.l0.a.e0.d.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f46493e, this.f46494f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f46495g.f46557c);
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.l0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46493e, this.f46494f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.n(list, this.f46496h), 0).toString(), this.f46495g.f46557c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f46493e, this.f46494f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f46495g.f46557c);
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        d.a.l0.a.i1.d.c.f a2 = d.a.l0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f46555a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        d.a.l0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        d dVar = new d(this, fVar, eVar, new C0765c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.a.l0.a.i1.d.c.b.e(eVar.x(), eVar.f44425f, fVar.f46559e, TextUtils.equals(fVar.f46558d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f46555a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f46558d, "front"));
        bundle.putInt("maxDuration", fVar.f46559e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f46556b);
        bundle.putString("swanAppId", eVar.f44425f);
        bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
        d.a.l0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
