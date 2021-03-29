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
        public final /* synthetic */ UnitedSchemeEntity f43361a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43362b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43363c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43364d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43361a = unitedSchemeEntity;
            this.f43362b = callbackHandler;
            this.f43363c = eVar;
            this.f43364d = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46288b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f43361a, this.f43362b, this.f43363c, this.f43364d);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43362b, this.f43361a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43364d.f43443c);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43366a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43367b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43368c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43369d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f43370e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
            this.f43366a = context;
            this.f43367b = unitedSchemeEntity;
            this.f43368c = callbackHandler;
            this.f43369d = eVar;
            this.f43370e = fVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46288b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f43366a, this.f43367b, this.f43368c, this.f43369d, this.f43370e);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43368c, this.f43367b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43370e.f43443c);
        }
    }

    /* renamed from: d.b.g0.a.b1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0605c implements d.b.g0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43372a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43374c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f43375d;

        public C0605c(c cVar, d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar) {
            this.f43372a = eVar;
            this.f43373b = callbackHandler;
            this.f43374c = unitedSchemeEntity;
            this.f43375d = fVar;
        }

        @Override // d.b.g0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f46288b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43373b, this.f43374c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(arrayList, this.f43372a), 0).toString(), this.f43375d.f43443c);
            }
            d.b.g0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43376a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43377b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.d.d f43378c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43379d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43380e;

        public d(c cVar, f fVar, d.b.g0.a.r1.e eVar, d.b.g0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43376a = fVar;
            this.f43377b = eVar;
            this.f43378c = dVar;
            this.f43379d = callbackHandler;
            this.f43380e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            d.b.g0.a.c0.c.g("chooseVideo", "capture success");
            d.b.g0.a.b1.d.c.e.i(d.b.g0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", this.f43376a.f43442b);
            bundle.putString("swanAppId", this.f43377b.f45740f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            d.b.g0.a.b1.d.c.d.h(this.f43377b.n(), bundle, this.f43378c);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f43379d, this.f43380e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f43376a.f43443c);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f43383c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f43384d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar, d.b.g0.a.r1.e eVar) {
            this.f43381a = callbackHandler;
            this.f43382b = unitedSchemeEntity;
            this.f43383c = fVar;
            this.f43384d = eVar;
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void a(String str) {
            d.b.g0.a.c0.c.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f43381a, this.f43382b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f43383c.f43443c);
        }

        @Override // d.b.g0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.g0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f43381a, this.f43382b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.g0.a.b1.d.c.d.n(list, this.f43384d), 0).toString(), this.f43383c.f43443c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f43381a, this.f43382b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f43383c.f43443c);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f46288b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f a2 = f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f43441a == 2) {
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
        d dVar = new d(this, fVar, eVar, new C0605c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.b.g0.a.b1.d.c.b.e(eVar.n(), eVar.f45740f, fVar.f43445e, TextUtils.equals(fVar.f43444d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f43441a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f43444d, "front"));
        bundle.putInt("maxDuration", fVar.f43445e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f43442b);
        bundle.putString("swanAppId", eVar.f45740f);
        bundle.putString("swanTmpPath", d.b.g0.a.z0.f.V().y().j());
        d.b.g0.a.b1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
