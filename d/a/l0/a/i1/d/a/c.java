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
        public final /* synthetic */ UnitedSchemeEntity f42797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42798b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42799c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f42800d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
            this.f42797a = unitedSchemeEntity;
            this.f42798b = callbackHandler;
            this.f42799c = eVar;
            this.f42800d = fVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f42797a, this.f42798b, this.f42799c, this.f42800d);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42798b, this.f42797a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f42800d.f42881c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42804c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42805d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f42806e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
            this.f42802a = context;
            this.f42803b = unitedSchemeEntity;
            this.f42804c = callbackHandler;
            this.f42805d = eVar;
            this.f42806e = fVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f42802a, this.f42803b, this.f42804c, this.f42805d, this.f42806e);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42804c, this.f42803b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f42806e.f42881c);
        }
    }

    /* renamed from: d.a.l0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0709c implements d.a.l0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42809b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42810c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f42811d;

        public C0709c(c cVar, d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.i1.d.c.f fVar) {
            this.f42808a = eVar;
            this.f42809b = callbackHandler;
            this.f42810c = unitedSchemeEntity;
            this.f42811d = fVar;
        }

        @Override // d.a.l0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f40949b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.l0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42809b, this.f42810c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.n(arrayList, this.f42808a), 0).toString(), this.f42811d.f42881c);
            }
            d.a.l0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f42812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42813b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.d.d f42814c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42815d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42816e;

        public d(c cVar, d.a.l0.a.i1.d.c.f fVar, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42812a = fVar;
            this.f42813b = eVar;
            this.f42814c = dVar;
            this.f42815d = callbackHandler;
            this.f42816e = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void a(File file) {
            d.a.l0.a.e0.d.g("chooseVideo", "capture success");
            d.a.l0.a.i1.d.c.e.i(d.a.l0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", this.f42812a.f42880b);
            bundle.putString("swanAppId", this.f42813b.f40749f);
            bundle.putParcelableArrayList("mediaModels", d.a.l0.a.i1.d.c.e.e());
            d.a.l0.a.i1.d.c.d.h(this.f42813b.x(), bundle, this.f42814c);
        }

        @Override // d.a.l0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f42815d, this.f42816e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f42812a.f42881c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42818f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.f f42819g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42820h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.i1.d.c.f fVar, d.a.l0.a.a2.e eVar) {
            this.f42817e = callbackHandler;
            this.f42818f = unitedSchemeEntity;
            this.f42819g = fVar;
            this.f42820h = eVar;
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void e(String str) {
            d.a.l0.a.e0.d.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f42817e, this.f42818f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f42819g.f42881c);
        }

        @Override // d.a.l0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.l0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42817e, this.f42818f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.l0.a.i1.d.c.d.n(list, this.f42820h), 0).toString(), this.f42819g.f42881c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f42817e, this.f42818f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f42819g.f42881c);
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        d.a.l0.a.i1.d.c.f a2 = d.a.l0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f42879a == 2) {
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
        d dVar = new d(this, fVar, eVar, new C0709c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.a.l0.a.i1.d.c.b.e(eVar.x(), eVar.f40749f, fVar.f42883e, TextUtils.equals(fVar.f42882d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.i1.d.c.f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f42879a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f42882d, "front"));
        bundle.putInt("maxDuration", fVar.f42883e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f42880b);
        bundle.putString("swanAppId", eVar.f40749f);
        bundle.putString("swanTmpPath", d.a.l0.a.g1.f.V().I().k());
        d.a.l0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
