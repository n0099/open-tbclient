package d.a.h0.h.a.j.f;

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
import d.a.h0.a.a1.c.g;
import d.a.h0.a.k;
import d.a.h0.a.k1.c;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.w0.c.d;
import d.a.h0.a.z0.f;
import d.a.h0.h.a.f.f.d;
import d.a.h0.h.a.j.h.b;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.h0.h.a.f.a<g> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47020d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<d.a.h0.a.e0.l.e> f47021a;

    /* renamed from: b  reason: collision with root package name */
    public String f47022b;

    /* renamed from: c  reason: collision with root package name */
    public String f47023c;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47024a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f47025b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47026c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f47027d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47028e;

        /* renamed from: d.a.h0.h.a.j.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0982a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {
            public C0982a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.v1.c.e eVar) {
                if (eVar != null && (eVar.f44913d || !eVar.a())) {
                    a aVar = a.this;
                    aVar.f47026c.b(aVar.f47028e, 1009, "location is not authorized");
                    return;
                }
                a aVar2 = a.this;
                aVar2.f47026c.b(aVar2.f47028e, 1010, "no location permission");
            }
        }

        public a(Context context, g gVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, String str) {
            this.f47024a = context;
            this.f47025b = gVar;
            this.f47026c = bVar;
            this.f47027d = eVar;
            this.f47028e = str;
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onFail() {
            d.a.h0.a.c0.c.l("map", "location permission fail");
            this.f47027d.R().e("mapp_location", new C0982a());
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onSuccess() {
            d.a.h0.a.c0.c.l("map", "location permission success");
            b.this.k(this.f47024a, this.f47025b, this.f47026c, this.f47027d, this.f47028e);
        }
    }

    /* renamed from: d.a.h0.h.a.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0983b implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47031e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47032f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47033g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f47034h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.c.c f47035i;

        public C0983b(d.a.h0.a.a1.b bVar, String str, Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.a1.c.c cVar) {
            this.f47031e = bVar;
            this.f47032f = str;
            this.f47033g = context;
            this.f47034h = eVar;
            this.f47035i = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                b.this.n(this.f47033g, this.f47031e, this.f47034h, (g) this.f47035i);
                return;
            }
            d.a.h0.a.c0.c.l("map", "camera permission fail");
            this.f47031e.b(this.f47032f, 1011, "camera is not authorized");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f47037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f47038c;

        public c(d.a.h0.a.a1.b bVar, g gVar, Context context) {
            this.f47036a = bVar;
            this.f47037b = gVar;
            this.f47038c = context;
        }

        @Override // d.a.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            boolean z = true;
            if (i2 != 1) {
                this.f47036a.b(this.f47037b.E, 1001, "no camera permission");
                d.a.h0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == -1) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                this.f47036a.b(this.f47037b.E, 1012, "no camera permission");
                d.a.h0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            d.a.h0.a.c0.c.b("map", "has camera authorize");
            b.this.p(this.f47038c, this.f47037b, this.f47036a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f47041b;

        public d(d.a.h0.a.a1.b bVar, g gVar) {
            this.f47040a = bVar;
            this.f47041b = gVar;
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void a(d.a.h0.a.t1.k.k0.b bVar) {
            d.a.h0.a.c0.c.g("map", "get location ok ");
            b.this.o(d.a.h0.a.r1.e.h().A(), new LatLng(bVar.f44573c, bVar.f44572b), this.f47040a, this.f47041b);
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void onFailed(int i2) {
            d.a.h0.a.c0.c.g("map", "get location error " + i2);
            this.f47040a.b(this.f47041b.E, 1007, "get location fail");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f47043a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f47044b;

        public e(d.a.h0.a.a1.b bVar, g gVar) {
            this.f47043a = bVar;
            this.f47044b = gVar;
        }

        @Override // d.a.h0.h.a.j.h.b.c
        public void a() {
            Bundle bundle;
            d.a.h0.a.c0.c.g("map", "walk navigation onPrepareSuccess ");
            d.a.h0.a.e0.l.e J = f.V().J();
            if (b.this.f47021a != null && J == b.this.f47021a.get()) {
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.f47022b) && TextUtils.isEmpty(b.this.f47023c)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.f47022b);
                    bundle.putString("guideIcon", b.this.f47023c);
                }
                d.a.h0.h.a.j.h.a.H2(bundle).I2();
                this.f47043a.c(this.f47044b.E, null);
                return;
            }
            this.f47043a.b(this.f47044b.E, 1001, "open navigation canceled on another page");
        }

        @Override // d.a.h0.h.a.j.h.b.c
        public void b() {
            d.a.h0.a.c0.c.g("map", "walk navigation onPrepareStart ");
            SDKInitializer.setCoordType(CoordType.BD09LL);
        }

        @Override // d.a.h0.h.a.j.h.b.c
        public void c(String str) {
            d.a.h0.a.c0.c.g("map", "walk navigation onPrepareFailed ");
            SDKInitializer.setCoordType(CoordType.GCJ02);
            if (str.contains("the distance is less than 30 meters")) {
                this.f47043a.b(this.f47044b.E, 1005, "the distance is less than 30 meters");
            } else if (str.contains("the distance is longer than 50 kilometers")) {
                this.f47043a.b(this.f47044b.E, 1006, "the distance is longer than 50 kilometers");
            } else {
                this.f47043a.b(this.f47044b.E, 1004, "prepare route error");
            }
        }
    }

    public static b m() {
        return new b();
    }

    public final void k(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, String str) {
        eVar.R().g((Activity) context, PermissionProxy.SCOPE_ID_CAMERA, new C0983b(bVar, str, context, eVar, cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.h.a.f.a
    /* renamed from: l */
    public boolean b(Context context, g gVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, JSONObject jSONObject) {
        return q(context, gVar, bVar, eVar);
    }

    public final void n(Context context, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, g gVar) {
        d.a.h0.a.c0.c.g("map", "handleAuthorized camera start");
        if (d.a.h0.a.x.a.b().c(context)) {
            d.a.h0.a.c0.c.b("map", "has camera authorize");
            p(context, gVar, bVar);
            return;
        }
        eVar.v().requestPermissionsExt(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new c(bVar, gVar, context));
    }

    public final void o(Activity activity, LatLng latLng, d.a.h0.a.a1.b bVar, g gVar) {
        d.a.h0.a.a1.c.h.c cVar = gVar.D;
        d.a.h0.h.a.j.h.b.f(activity, latLng, new LatLng(cVar.f41178e, cVar.f41179f), new e(bVar, gVar));
    }

    public final void p(Context context, g gVar, d.a.h0.a.a1.b bVar) {
        d.a.h0.a.w0.a.w().b("gcj02", true, true, new d(bVar, gVar));
    }

    public final boolean q(Context context, g gVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("map", "WalkNavigationAction start");
        if (!gVar.isValid()) {
            d.a.h0.a.c0.c.b("map", "model is invalid");
            return false;
        }
        String str = gVar.E;
        if (TextUtils.isEmpty(str)) {
            d.a.h0.a.c0.c.b("map", "cb is empty");
            return false;
        }
        this.f47022b = gVar.F;
        if (f47020d) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.f47022b);
        }
        this.f47023c = gVar.G;
        if (f47020d) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.f47023c);
        }
        if (d.a.h0.a.a2.b.c(this.f47023c) == PathType.BD_FILE) {
            this.f47023c = d.a.h0.a.a2.b.u(this.f47023c, d.a.h0.a.r1.e.T());
        }
        if (!SwanAppNetworkUtils.h(context)) {
            d.a.h0.a.c0.c.l("map", "no network");
            bVar.b(str, 1003, "no network");
            return false;
        }
        this.f47021a = new WeakReference<>(f.V().J());
        d.a.h0.h.a.f.f.d.b(context, new a(context, gVar, bVar, eVar, str));
        d.a.h0.a.c0.c.g("map", "WalkNavigationAction end");
        return true;
    }
}
