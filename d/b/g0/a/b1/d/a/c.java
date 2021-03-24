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
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43362c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43363d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43360a = unitedSchemeEntity;
            this.f43361b = callbackHandler;
            this.f43362c = eVar;
            this.f43363d = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46287b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f43360a, this.f43361b, this.f43362c, this.f43363d);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43361b, this.f43360a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43363d.f43442c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43365a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43367c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43368d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f43369e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43365a = context;
            this.f43366b = unitedSchemeEntity;
            this.f43367c = callbackHandler;
            this.f43368d = eVar;
            this.f43369e = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46287b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f43365a, this.f43366b, this.f43367c, this.f43368d, this.f43369e);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43367c, this.f43366b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43369e.f43442c);
        }
    }

    /* renamed from: d.b.g0.a.b1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0604c implements d.b.g0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43372b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43373c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43374d;

        public C0604c(c cVar, d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar) {
            this.f43371a = eVar;
            this.f43372b = callbackHandler;
            this.f43373c = unitedSchemeEntity;
            this.f43374d = fVar;
        }

        @Override // d.b.g0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f46287b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43372b, this.f43373c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(arrayList, this.f43371a), 0).toString(), this.f43374d.f43442c);
            }
            d.b.g0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43375a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43376b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.d f43377c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43378d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43379e;

        public d(c cVar, f fVar, d.b.g0.a.r1.e eVar, d.b.g0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43375a = fVar;
            this.f43376b = eVar;
            this.f43377c = dVar;
            this.f43378d = callbackHandler;
            this.f43379e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            d.b.g0.a.c0.c.g("chooseVideo", "capture success");
            d.b.g0.a.b1.d.c.e.i(d.b.g0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", this.f43375a.f43441b);
            bundle.putString("swanAppId", this.f43376b.f45739f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            d.b.g0.a.b1.d.c.d.h(this.f43376b.n(), bundle, this.f43377c);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f43378d, this.f43379e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f43375a.f43442c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43381b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f43382c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43383d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar, d.b.g0.a.r1.e eVar) {
            this.f43380a = callbackHandler;
            this.f43381b = unitedSchemeEntity;
            this.f43382c = fVar;
            this.f43383d = eVar;
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void a(String str) {
            d.b.g0.a.c0.c.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f43380a, this.f43381b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f43382c.f43442c);
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43380a, this.f43381b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(list, this.f43383d), 0).toString(), this.f43382c.f43442c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f43380a, this.f43381b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f43382c.f43442c);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f46287b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f a2 = f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f43440a == 2) {
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
        d dVar = new d(this, fVar, eVar, new C0604c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.b.g0.a.b1.d.c.b.e(eVar.n(), eVar.f45739f, fVar.f43444e, TextUtils.equals(fVar.f43443d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f43440a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f43443d, "front"));
        bundle.putInt("maxDuration", fVar.f43444e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f43441b);
        bundle.putString("swanAppId", eVar.f45739f);
        bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
        d.b.g0.a.b1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
