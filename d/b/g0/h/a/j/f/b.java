package d.b.g0.h.a.j.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.a1.c.g;
import d.b.g0.a.k;
import d.b.g0.a.k1.c;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.w0.c.d;
import d.b.g0.a.z0.f;
import d.b.g0.h.a.f.f.d;
import d.b.g0.h.a.j.h.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.h.a.f.a<g> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48797d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<d.b.g0.a.e0.l.e> f48798a;

    /* renamed from: b  reason: collision with root package name */
    public String f48799b;

    /* renamed from: c  reason: collision with root package name */
    public String f48800c;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f48802b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48803c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f48804d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48805e;

        /* renamed from: d.b.g0.h.a.j.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1011a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {
            public C1011a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.e eVar) {
                if (eVar != null && (eVar.f46771d || !eVar.a())) {
                    a aVar = a.this;
                    aVar.f48803c.b(aVar.f48805e, 1009, "location is not authorized");
                    return;
                }
                a aVar2 = a.this;
                aVar2.f48803c.b(aVar2.f48805e, 1010, "no location permission");
            }
        }

        public a(Context context, g gVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, String str) {
            this.f48801a = context;
            this.f48802b = gVar;
            this.f48803c = bVar;
            this.f48804d = eVar;
            this.f48805e = str;
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onFail() {
            d.b.g0.a.c0.c.l("map", "location permission fail");
            this.f48804d.R().e("mapp_location", new C1011a());
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onSuccess() {
            d.b.g0.a.c0.c.l("map", "location permission success");
            b.this.k(this.f48801a, this.f48802b, this.f48803c, this.f48804d, this.f48805e);
        }
    }

    /* renamed from: d.b.g0.h.a.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1012b implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f48810g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f48811h;
        public final /* synthetic */ d.b.g0.a.a1.c.c i;

        public C1012b(d.b.g0.a.a1.b bVar, String str, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.a1.c.c cVar) {
            this.f48808e = bVar;
            this.f48809f = str;
            this.f48810g = context;
            this.f48811h = eVar;
            this.i = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                b.this.n(this.f48810g, this.f48808e, this.f48811h, (g) this.i);
                return;
            }
            d.b.g0.a.c0.c.l("map", "camera permission fail");
            this.f48808e.b(this.f48809f, 1011, "camera is not authorized");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f48813b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f48814c;

        public c(d.b.g0.a.a1.b bVar, g gVar, Context context) {
            this.f48812a = bVar;
            this.f48813b = gVar;
            this.f48814c = context;
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            boolean z = true;
            if (i != 1) {
                this.f48812a.b(this.f48813b.E, 1001, "no camera permission");
                d.b.g0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (iArr[i2] == -1) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                this.f48812a.b(this.f48813b.E, 1012, "no camera permission");
                d.b.g0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            d.b.g0.a.c0.c.b("map", "has camera authorize");
            b.this.p(this.f48814c, this.f48813b, this.f48812a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f48817b;

        public d(d.b.g0.a.a1.b bVar, g gVar) {
            this.f48816a = bVar;
            this.f48817b = gVar;
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void a(d.b.g0.a.t1.k.k0.b bVar) {
            d.b.g0.a.c0.c.g("map", "get location ok ");
            b.this.o(d.b.g0.a.r1.e.y().A(), new LatLng(bVar.f46452c, bVar.f46451b), this.f48816a, this.f48817b);
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void onFailed(int i) {
            d.b.g0.a.c0.c.g("map", "get location error " + i);
            this.f48816a.b(this.f48817b.E, 1007, "get location fail");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f48820b;

        public e(d.b.g0.a.a1.b bVar, g gVar) {
            this.f48819a = bVar;
            this.f48820b = gVar;
        }

        @Override // d.b.g0.h.a.j.h.b.c
        public void a() {
            Bundle bundle;
            d.b.g0.a.c0.c.g("map", "walk navigation onPrepareSuccess ");
            d.b.g0.a.e0.l.e A = f.V().A();
            if (b.this.f48798a != null && A == b.this.f48798a.get()) {
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.f48799b) && TextUtils.isEmpty(b.this.f48800c)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.f48799b);
                    bundle.putString("guideIcon", b.this.f48800c);
                }
                d.b.g0.h.a.j.h.a.I2(bundle).J2();
                this.f48819a.c(this.f48820b.E, null);
                return;
            }
            this.f48819a.b(this.f48820b.E, 1001, "open navigation canceled on another page");
        }

        @Override // d.b.g0.h.a.j.h.b.c
        public void b() {
            d.b.g0.a.c0.c.g("map", "walk navigation onPrepareStart ");
            SDKInitializer.setCoordType(CoordType.BD09LL);
        }

        @Override // d.b.g0.h.a.j.h.b.c
        public void c(String str) {
            d.b.g0.a.c0.c.g("map", "walk navigation onPrepareFailed ");
            SDKInitializer.setCoordType(CoordType.GCJ02);
            if (str.contains("the distance is less than 30 meters")) {
                this.f48819a.b(this.f48820b.E, 1005, "the distance is less than 30 meters");
            } else if (str.contains("the distance is longer than 50 kilometers")) {
                this.f48819a.b(this.f48820b.E, 1006, "the distance is longer than 50 kilometers");
            } else {
                this.f48819a.b(this.f48820b.E, 1004, "prepare route error");
            }
        }
    }

    public static b m() {
        return new b();
    }

    public final void k(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, String str) {
        eVar.R().g((Activity) context, PermissionProxy.SCOPE_ID_CAMERA, new C1012b(bVar, str, context, eVar, cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.h.a.f.a
    /* renamed from: l */
    public boolean b(Context context, g gVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, JSONObject jSONObject) {
        return q(context, gVar, bVar, eVar);
    }

    public final void n(Context context, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, g gVar) {
        d.b.g0.a.c0.c.g("map", "handleAuthorized camera start");
        if (d.b.g0.a.x.a.b().c(context)) {
            d.b.g0.a.c0.c.b("map", "has camera authorize");
            p(context, gVar, bVar);
            return;
        }
        eVar.n().requestPermissionsExt(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new c(bVar, gVar, context));
    }

    public final void o(Activity activity, LatLng latLng, d.b.g0.a.a1.b bVar, g gVar) {
        d.b.g0.a.a1.c.h.c cVar = gVar.D;
        d.b.g0.h.a.j.h.b.f(activity, latLng, new LatLng(cVar.f43191e, cVar.f43192f), new e(bVar, gVar));
    }

    public final void p(Context context, g gVar, d.b.g0.a.a1.b bVar) {
        d.b.g0.a.w0.a.w().d("gcj02", true, true, new d(bVar, gVar));
    }

    public final boolean q(Context context, g gVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("map", "WalkNavigationAction start");
        if (!gVar.isValid()) {
            d.b.g0.a.c0.c.b("map", "model is invalid");
            return false;
        }
        String str = gVar.E;
        if (TextUtils.isEmpty(str)) {
            d.b.g0.a.c0.c.b("map", "cb is empty");
            return false;
        }
        this.f48799b = gVar.F;
        if (f48797d) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.f48799b);
        }
        this.f48800c = gVar.G;
        if (f48797d) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.f48800c);
        }
        if (d.b.g0.a.a2.b.c(this.f48800c) == PathType.BD_FILE) {
            this.f48800c = d.b.g0.a.a2.b.u(this.f48800c, d.b.g0.a.r1.e.T());
        }
        if (!SwanAppNetworkUtils.h(context)) {
            d.b.g0.a.c0.c.l("map", "no network");
            bVar.b(str, 1003, "no network");
            return false;
        }
        this.f48798a = new WeakReference<>(f.V().A());
        d.b.g0.h.a.f.f.d.b(context, new a(context, gVar, bVar, eVar, str));
        d.b.g0.a.c0.c.g("map", "WalkNavigationAction end");
        return true;
    }
}
