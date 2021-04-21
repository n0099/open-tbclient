package d.b.h0.h.a.j.f;

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
import d.b.h0.a.a1.c.g;
import d.b.h0.a.k;
import d.b.h0.a.k1.c;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.w0.c.d;
import d.b.h0.a.z0.f;
import d.b.h0.h.a.f.f.d;
import d.b.h0.h.a.j.h.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.h0.h.a.f.a<g> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49518d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<d.b.h0.a.e0.l.e> f49519a;

    /* renamed from: b  reason: collision with root package name */
    public String f49520b;

    /* renamed from: c  reason: collision with root package name */
    public String f49521c;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49522a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49524c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f49525d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49526e;

        /* renamed from: d.b.h0.h.a.j.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1043a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> {
            public C1043a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.h0.a.v1.c.e eVar) {
                if (eVar != null && (eVar.f47492d || !eVar.a())) {
                    a aVar = a.this;
                    aVar.f49524c.b(aVar.f49526e, 1009, "location is not authorized");
                    return;
                }
                a aVar2 = a.this;
                aVar2.f49524c.b(aVar2.f49526e, 1010, "no location permission");
            }
        }

        public a(Context context, g gVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, String str) {
            this.f49522a = context;
            this.f49523b = gVar;
            this.f49524c = bVar;
            this.f49525d = eVar;
            this.f49526e = str;
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onFail() {
            d.b.h0.a.c0.c.l("map", "location permission fail");
            this.f49525d.R().e("mapp_location", new C1043a());
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onSuccess() {
            d.b.h0.a.c0.c.l("map", "location permission success");
            b.this.k(this.f49522a, this.f49523b, this.f49524c, this.f49525d, this.f49526e);
        }
    }

    /* renamed from: d.b.h0.h.a.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1044b implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49530f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49531g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f49532h;
        public final /* synthetic */ d.b.h0.a.a1.c.c i;

        public C1044b(d.b.h0.a.a1.b bVar, String str, Context context, d.b.h0.a.r1.e eVar, d.b.h0.a.a1.c.c cVar) {
            this.f49529e = bVar;
            this.f49530f = str;
            this.f49531g = context;
            this.f49532h = eVar;
            this.i = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                b.this.n(this.f49531g, this.f49529e, this.f49532h, (g) this.i);
                return;
            }
            d.b.h0.a.c0.c.l("map", "camera permission fail");
            this.f49529e.b(this.f49530f, 1011, "camera is not authorized");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f49535c;

        public c(d.b.h0.a.a1.b bVar, g gVar, Context context) {
            this.f49533a = bVar;
            this.f49534b = gVar;
            this.f49535c = context;
        }

        @Override // d.b.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            boolean z = true;
            if (i != 1) {
                this.f49533a.b(this.f49534b.E, 1001, "no camera permission");
                d.b.h0.a.c0.c.b("map", "handleAuthorized camera end, failure");
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
                this.f49533a.b(this.f49534b.E, 1012, "no camera permission");
                d.b.h0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            d.b.h0.a.c0.c.b("map", "has camera authorize");
            b.this.p(this.f49535c, this.f49534b, this.f49533a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49537a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49538b;

        public d(d.b.h0.a.a1.b bVar, g gVar) {
            this.f49537a = bVar;
            this.f49538b = gVar;
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void a(d.b.h0.a.t1.k.k0.b bVar) {
            d.b.h0.a.c0.c.g("map", "get location ok ");
            b.this.o(d.b.h0.a.r1.e.y().A(), new LatLng(bVar.f47173c, bVar.f47172b), this.f49537a, this.f49538b);
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void onFailed(int i) {
            d.b.h0.a.c0.c.g("map", "get location error " + i);
            this.f49537a.b(this.f49538b.E, 1007, "get location fail");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49541b;

        public e(d.b.h0.a.a1.b bVar, g gVar) {
            this.f49540a = bVar;
            this.f49541b = gVar;
        }

        @Override // d.b.h0.h.a.j.h.b.c
        public void a() {
            Bundle bundle;
            d.b.h0.a.c0.c.g("map", "walk navigation onPrepareSuccess ");
            d.b.h0.a.e0.l.e A = f.V().A();
            if (b.this.f49519a != null && A == b.this.f49519a.get()) {
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.f49520b) && TextUtils.isEmpty(b.this.f49521c)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.f49520b);
                    bundle.putString("guideIcon", b.this.f49521c);
                }
                d.b.h0.h.a.j.h.a.I2(bundle).J2();
                this.f49540a.c(this.f49541b.E, null);
                return;
            }
            this.f49540a.b(this.f49541b.E, 1001, "open navigation canceled on another page");
        }

        @Override // d.b.h0.h.a.j.h.b.c
        public void b() {
            d.b.h0.a.c0.c.g("map", "walk navigation onPrepareStart ");
            SDKInitializer.setCoordType(CoordType.BD09LL);
        }

        @Override // d.b.h0.h.a.j.h.b.c
        public void c(String str) {
            d.b.h0.a.c0.c.g("map", "walk navigation onPrepareFailed ");
            SDKInitializer.setCoordType(CoordType.GCJ02);
            if (str.contains("the distance is less than 30 meters")) {
                this.f49540a.b(this.f49541b.E, 1005, "the distance is less than 30 meters");
            } else if (str.contains("the distance is longer than 50 kilometers")) {
                this.f49540a.b(this.f49541b.E, 1006, "the distance is longer than 50 kilometers");
            } else {
                this.f49540a.b(this.f49541b.E, 1004, "prepare route error");
            }
        }
    }

    public static b m() {
        return new b();
    }

    public final void k(Context context, d.b.h0.a.a1.c.c cVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, String str) {
        eVar.R().g((Activity) context, PermissionProxy.SCOPE_ID_CAMERA, new C1044b(bVar, str, context, eVar, cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.h.a.f.a
    /* renamed from: l */
    public boolean b(Context context, g gVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, JSONObject jSONObject) {
        return q(context, gVar, bVar, eVar);
    }

    public final void n(Context context, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, g gVar) {
        d.b.h0.a.c0.c.g("map", "handleAuthorized camera start");
        if (d.b.h0.a.x.a.b().c(context)) {
            d.b.h0.a.c0.c.b("map", "has camera authorize");
            p(context, gVar, bVar);
            return;
        }
        eVar.n().requestPermissionsExt(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new c(bVar, gVar, context));
    }

    public final void o(Activity activity, LatLng latLng, d.b.h0.a.a1.b bVar, g gVar) {
        d.b.h0.a.a1.c.h.c cVar = gVar.D;
        d.b.h0.h.a.j.h.b.f(activity, latLng, new LatLng(cVar.f43912e, cVar.f43913f), new e(bVar, gVar));
    }

    public final void p(Context context, g gVar, d.b.h0.a.a1.b bVar) {
        d.b.h0.a.w0.a.w().d("gcj02", true, true, new d(bVar, gVar));
    }

    public final boolean q(Context context, g gVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("map", "WalkNavigationAction start");
        if (!gVar.isValid()) {
            d.b.h0.a.c0.c.b("map", "model is invalid");
            return false;
        }
        String str = gVar.E;
        if (TextUtils.isEmpty(str)) {
            d.b.h0.a.c0.c.b("map", "cb is empty");
            return false;
        }
        this.f49520b = gVar.F;
        if (f49518d) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.f49520b);
        }
        this.f49521c = gVar.G;
        if (f49518d) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.f49521c);
        }
        if (d.b.h0.a.a2.b.c(this.f49521c) == PathType.BD_FILE) {
            this.f49521c = d.b.h0.a.a2.b.u(this.f49521c, d.b.h0.a.r1.e.T());
        }
        if (!SwanAppNetworkUtils.h(context)) {
            d.b.h0.a.c0.c.l("map", "no network");
            bVar.b(str, 1003, "no network");
            return false;
        }
        this.f49519a = new WeakReference<>(f.V().A());
        d.b.h0.h.a.f.f.d.b(context, new a(context, gVar, bVar, eVar, str));
        d.b.h0.a.c0.c.g("map", "WalkNavigationAction end");
        return true;
    }
}
