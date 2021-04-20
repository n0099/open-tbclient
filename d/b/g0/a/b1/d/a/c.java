package d.b.g0.a.b1.d.a;

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
import d.b.g0.a.b1.d.c.f;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43753a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43754b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43755c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43756d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43753a = unitedSchemeEntity;
            this.f43754b = callbackHandler;
            this.f43755c = eVar;
            this.f43756d = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f43753a, this.f43754b, this.f43755c, this.f43756d);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43754b, this.f43753a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43756d.f43835c);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43759b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43760c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43761d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f43762e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43758a = context;
            this.f43759b = unitedSchemeEntity;
            this.f43760c = callbackHandler;
            this.f43761d = eVar;
            this.f43762e = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f43758a, this.f43759b, this.f43760c, this.f43761d, this.f43762e);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43760c, this.f43759b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43762e.f43835c);
        }
    }

    /* renamed from: d.b.g0.a.b1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0617c implements d.b.g0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43764a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43765b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43766c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43767d;

        public C0617c(c cVar, d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar) {
            this.f43764a = eVar;
            this.f43765b = callbackHandler;
            this.f43766c = unitedSchemeEntity;
            this.f43767d = fVar;
        }

        @Override // d.b.g0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f46680b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43765b, this.f43766c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(arrayList, this.f43764a), 0).toString(), this.f43767d.f43835c);
            }
            d.b.g0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43768a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43769b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.d f43770c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43771d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43772e;

        public d(c cVar, f fVar, d.b.g0.a.r1.e eVar, d.b.g0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43768a = fVar;
            this.f43769b = eVar;
            this.f43770c = dVar;
            this.f43771d = callbackHandler;
            this.f43772e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            d.b.g0.a.c0.c.g("chooseVideo", "capture success");
            d.b.g0.a.b1.d.c.e.i(d.b.g0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", this.f43768a.f43834b);
            bundle.putString("swanAppId", this.f43769b.f46132f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            d.b.g0.a.b1.d.c.d.h(this.f43769b.n(), bundle, this.f43770c);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f43771d, this.f43772e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f43768a.f43835c);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f43775c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43776d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar, d.b.g0.a.r1.e eVar) {
            this.f43773a = callbackHandler;
            this.f43774b = unitedSchemeEntity;
            this.f43775c = fVar;
            this.f43776d = eVar;
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void a(String str) {
            d.b.g0.a.c0.c.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f43773a, this.f43774b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f43775c.f43835c);
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43773a, this.f43774b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(list, this.f43776d), 0).toString(), this.f43775c.f43835c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f43773a, this.f43774b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f43775c.f43835c);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f a2 = f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f43833a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        d dVar = new d(this, fVar, eVar, new C0617c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.b.g0.a.b1.d.c.b.e(eVar.n(), eVar.f46132f, fVar.f43837e, TextUtils.equals(fVar.f43836d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f43833a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f43836d, "front"));
        bundle.putInt("maxDuration", fVar.f43837e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f43834b);
        bundle.putString("swanAppId", eVar.f46132f);
        bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
        d.b.g0.a.b1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
