package d.a.i0.a.i1.d.a;

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
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.s1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42623a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42624b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42625c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.c.f f42626d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
            this.f42623a = unitedSchemeEntity;
            this.f42624b = callbackHandler;
            this.f42625c = eVar;
            this.f42626d = fVar;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f42623a, this.f42624b, this.f42625c, this.f42626d);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42624b, this.f42623a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f42626d.f42707c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42628a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42629b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42630c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42631d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.c.f f42632e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
            this.f42628a = context;
            this.f42629b = unitedSchemeEntity;
            this.f42630c = callbackHandler;
            this.f42631d = eVar;
            this.f42632e = fVar;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f42628a, this.f42629b, this.f42630c, this.f42631d, this.f42632e);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42630c, this.f42629b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f42632e.f42707c);
        }
    }

    /* renamed from: d.a.i0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0698c implements d.a.i0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42635b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42636c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.c.f f42637d;

        public C0698c(c cVar, d.a.i0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.i0.a.i1.d.c.f fVar) {
            this.f42634a = eVar;
            this.f42635b = callbackHandler;
            this.f42636c = unitedSchemeEntity;
            this.f42637d = fVar;
        }

        @Override // d.a.i0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f40775b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.i0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42635b, this.f42636c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.i0.a.i1.d.c.d.n(arrayList, this.f42634a), 0).toString(), this.f42637d.f42707c);
            }
            d.a.i0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.c.f f42638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.d.d f42640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42641d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42642e;

        public d(c cVar, d.a.i0.a.i1.d.c.f fVar, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42638a = fVar;
            this.f42639b = eVar;
            this.f42640c = dVar;
            this.f42641d = callbackHandler;
            this.f42642e = unitedSchemeEntity;
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void a(File file) {
            d.a.i0.a.e0.d.g("chooseVideo", "capture success");
            d.a.i0.a.i1.d.c.e.i(d.a.i0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", this.f42638a.f42706b);
            bundle.putString("swanAppId", this.f42639b.f40575f);
            bundle.putParcelableArrayList("mediaModels", d.a.i0.a.i1.d.c.e.e());
            d.a.i0.a.i1.d.c.d.h(this.f42639b.x(), bundle, this.f42640c);
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f42641d, this.f42642e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f42638a.f42707c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.i0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42644f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.c.f f42645g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f42646h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.i0.a.i1.d.c.f fVar, d.a.i0.a.a2.e eVar) {
            this.f42643e = callbackHandler;
            this.f42644f = unitedSchemeEntity;
            this.f42645g = fVar;
            this.f42646h = eVar;
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void e(String str) {
            d.a.i0.a.e0.d.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f42643e, this.f42644f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f42645g.f42707c);
        }

        @Override // d.a.i0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.i0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f42643e, this.f42644f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.i0.a.i1.d.c.d.n(list, this.f42646h), 0).toString(), this.f42645g.f42707c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f42643e, this.f42644f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f42645g.f42707c);
        }
    }

    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        d.a.i0.a.i1.d.c.f a2 = d.a.i0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f42705a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
        d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
        d dVar = new d(this, fVar, eVar, new C0698c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.a.i0.a.i1.d.c.b.e(eVar.x(), eVar.f40575f, fVar.f42709e, TextUtils.equals(fVar.f42708d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.i1.d.c.f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f42705a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f42708d, "front"));
        bundle.putInt("maxDuration", fVar.f42709e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f42706b);
        bundle.putString("swanAppId", eVar.f40575f);
        bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
        d.a.i0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
