package d.a.m0.a.i1.d.a;

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
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.s1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46582b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46583c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.c.f f46584d;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
            this.f46581a = unitedSchemeEntity;
            this.f46582b = callbackHandler;
            this.f46583c = eVar;
            this.f46584d = fVar;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.p(this.f46581a, this.f46582b, this.f46583c, this.f46584d);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46582b, this.f46581a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46584d.f46665c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46586a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46588c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46589d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.c.f f46590e;

        public b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
            this.f46586a = context;
            this.f46587b = unitedSchemeEntity;
            this.f46588c = callbackHandler;
            this.f46589d = eVar;
            this.f46590e = fVar;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", str + "");
            }
            c.this.r(this.f46586a, this.f46587b, this.f46588c, this.f46589d, this.f46590e);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f46588c, this.f46587b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46590e.f46665c);
        }
    }

    /* renamed from: d.a.m0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0768c implements d.a.m0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46594c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.c.f f46595d;

        public C0768c(c cVar, d.a.m0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.i1.d.c.f fVar) {
            this.f46592a = eVar;
            this.f46593b = callbackHandler;
            this.f46594c = unitedSchemeEntity;
            this.f46595d = fVar;
        }

        @Override // d.a.m0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                if (a0.f44733b) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                d.a.m0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46593b, this.f46594c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.m0.a.i1.d.c.d.n(arrayList, this.f46592a), 0).toString(), this.f46595d.f46665c);
            }
            d.a.m0.a.i1.d.c.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.i1.d.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.c.f f46596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.d.d f46598c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46599d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46600e;

        public d(c cVar, d.a.m0.a.i1.d.c.f fVar, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46596a = fVar;
            this.f46597b = eVar;
            this.f46598c = dVar;
            this.f46599d = callbackHandler;
            this.f46600e = unitedSchemeEntity;
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void a(File file) {
            d.a.m0.a.e0.d.g("chooseVideo", "capture success");
            d.a.m0.a.i1.d.c.e.i(d.a.m0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
            bundle.putBoolean("compressed", this.f46596a.f46664b);
            bundle.putString("swanAppId", this.f46597b.f44533f);
            bundle.putParcelableArrayList("mediaModels", d.a.m0.a.i1.d.c.e.e());
            d.a.m0.a.i1.d.c.d.h(this.f46597b.x(), bundle, this.f46598c);
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void b(String str) {
            UnitedSchemeUtility.safeCallback(this.f46599d, this.f46600e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f46596a.f46665c);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.i1.d.d.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.c.f f46603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f46604h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.m0.a.i1.d.c.f fVar, d.a.m0.a.a2.e eVar) {
            this.f46601e = callbackHandler;
            this.f46602f = unitedSchemeEntity;
            this.f46603g = fVar;
            this.f46604h = eVar;
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void e(String str) {
            d.a.m0.a.e0.d.g("chooseVideo", str);
            UnitedSchemeUtility.safeCallback(this.f46601e, this.f46602f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f46603g.f46665c);
        }

        @Override // d.a.m0.a.i1.d.d.c
        public void f(List list) {
            if (list != null && list.size() > 0) {
                d.a.m0.a.e0.d.g("chooseVideo", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46601e, this.f46602f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(d.a.m0.a.i1.d.c.d.n(list, this.f46604h), 0).toString(), this.f46603g.f46665c);
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f46601e, this.f46602f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f46603g.f46665c);
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f44733b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        d.a.m0.a.i1.d.c.f a2 = d.a.m0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (a2.f46663a == 2) {
            q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        } else {
            o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
        d.a.m0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
        d dVar = new d(this, fVar, eVar, new C0768c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
        d.a.m0.a.i1.d.c.b.e(eVar.x(), eVar.f44533f, fVar.f46667e, TextUtils.equals(fVar.f46666d, "front"), dVar);
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(unitedSchemeEntity, callbackHandler, eVar, fVar));
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.i1.d.c.f fVar) {
        Bundle bundle = new Bundle();
        bundle.putString("launchType", "video");
        bundle.putBoolean("isShowCamera", fVar.f46663a == 3);
        bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f46666d, "front"));
        bundle.putInt("maxDuration", fVar.f46667e);
        bundle.putInt("count", 1);
        bundle.putString("mode", "single");
        bundle.putBoolean("compressed", fVar.f46664b);
        bundle.putString("swanAppId", eVar.f44533f);
        bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
        d.a.m0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
    }
}
