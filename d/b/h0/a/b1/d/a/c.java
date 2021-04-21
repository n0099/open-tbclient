package d.b.h0.a.b1.d.a;

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
import d.b.h0.a.b1.d.c.f;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f44085d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
            this.f44082a = unitedSchemeEntity;
            this.f44083b = callbackHandler;
            this.f44084c = eVar;
            this.f44085d = fVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f44082a, this.f44083b, this.f44084c, this.f44085d);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f44083b, this.f44082a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f44085d.f44164c);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44087a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44088b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44089c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44090d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44091e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
            this.f44087a = context;
            this.f44088b = unitedSchemeEntity;
            this.f44089c = callbackHandler;
            this.f44090d = eVar;
            this.f44091e = fVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f44087a, this.f44088b, this.f44089c, this.f44090d, this.f44091e);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f44089c, this.f44088b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f44091e.f44164c);
        }
    }

    /* renamed from: d.b.h0.a.b1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0637c implements d.b.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44093a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44094b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44095c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f44096d;

        public C0637c(c cVar, d.b.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar) {
            this.f44093a = eVar;
            this.f44094b = callbackHandler;
            this.f44095c = unitedSchemeEntity;
            this.f44096d = fVar;
        }

        @Override // d.b.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f47009b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.b.h0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f44094b, this.f44095c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.h0.a.b1.d.c.d.n(arrayList, this.f44093a), 0).toString(), this.f44096d.f44164c);
            }
            d.b.h0.a.b1.d.c.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.h0.a.b1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f44097a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44098b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.d.d.d f44099c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44100d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44101e;

        public d(c cVar, f fVar, d.b.h0.a.r1.e eVar, d.b.h0.a.b1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44097a = fVar;
            this.f44098b = eVar;
            this.f44099c = dVar;
            this.f44100d = callbackHandler;
            this.f44101e = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void a(File file) {
            d.b.h0.a.c0.c.g("chooseVideo", "capture success");
            d.b.h0.a.b1.d.c.e.i(d.b.h0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.b.h0.a.z0.f.V().y().j());
            bundle.putBoolean("compressed", this.f44097a.f44163b);
            bundle.putString("swanAppId", this.f44098b.f46461f);
            bundle.putParcelableArrayList("mediaModels", d.b.h0.a.b1.d.c.e.e());
            d.b.h0.a.b1.d.c.d.h(this.f44098b.n(), bundle, this.f44099c);
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f44100d, this.f44101e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f44097a.f44164c);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.h0.a.b1.d.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44103b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f44104c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44105d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f fVar, d.b.h0.a.r1.e eVar) {
            this.f44102a = callbackHandler;
            this.f44103b = unitedSchemeEntity;
            this.f44104c = fVar;
            this.f44105d = eVar;
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void a(String str) {
            d.b.h0.a.c0.c.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f44102a, this.f44103b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f44104c.f44164c);
        }

        @Override // d.b.h0.a.b1.d.d.c
        public void b(List list) {
            if (list != null && list.size() > 0) {
                d.b.h0.a.c0.c.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f44102a, this.f44103b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.b.h0.a.b1.d.c.d.n(list, this.f44105d), 0).toString(), this.f44104c.f44164c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f44102a, this.f44103b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f44104c.f44164c);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/chooseVideo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        f a2 = f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f44162a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
        d.b.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
        d dVar = new d(this, fVar, eVar, new C0637c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.b.h0.a.b1.d.c.b.e(eVar.n(), eVar.f46461f, fVar.f44166e, TextUtils.equals(fVar.f44165d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f44162a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f44165d, "front"));
        bundle.putInt("maxDuration", fVar.f44166e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f44163b);
        bundle.putString("swanAppId", eVar.f46461f);
        bundle.putString("swanTmpPath", d.b.h0.a.z0.f.V().y().j());
        d.b.h0.a.b1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
