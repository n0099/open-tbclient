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
    public static final boolean f49189d = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<d.b.g0.a.e0.l.e> f49190a;

    /* renamed from: b  reason: collision with root package name */
    public String f49191b;

    /* renamed from: c  reason: collision with root package name */
    public String f49192c;

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49193a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49194b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f49195c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f49196d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49197e;

        /* renamed from: d.b.g0.h.a.j.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1023a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {
            public C1023a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.e eVar) {
                if (eVar != null && (eVar.f47163d || !eVar.a())) {
                    a aVar = a.this;
                    aVar.f49195c.b(aVar.f49197e, 1009, "location is not authorized");
                    return;
                }
                a aVar2 = a.this;
                aVar2.f49195c.b(aVar2.f49197e, 1010, "no location permission");
            }
        }

        public a(Context context, g gVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, String str) {
            this.f49193a = context;
            this.f49194b = gVar;
            this.f49195c = bVar;
            this.f49196d = eVar;
            this.f49197e = str;
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onFail() {
            d.b.g0.a.c0.c.l("map", "location permission fail");
            this.f49196d.R().e("mapp_location", new C1023a());
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onSuccess() {
            d.b.g0.a.c0.c.l("map", "location permission success");
            b.this.k(this.f49193a, this.f49194b, this.f49195c, this.f49196d, this.f49197e);
        }
    }

    /* renamed from: d.b.g0.h.a.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1024b implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f49200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49201f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49202g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f49203h;
        public final /* synthetic */ d.b.g0.a.a1.c.c i;

        public C1024b(d.b.g0.a.a1.b bVar, String str, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.a1.c.c cVar) {
            this.f49200e = bVar;
            this.f49201f = str;
            this.f49202g = context;
            this.f49203h = eVar;
            this.i = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                b.this.n(this.f49202g, this.f49200e, this.f49203h, (g) this.i);
                return;
            }
            d.b.g0.a.c0.c.l("map", "camera permission fail");
            this.f49200e.b(this.f49201f, 1011, "camera is not authorized");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f49204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49205b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f49206c;

        public c(d.b.g0.a.a1.b bVar, g gVar, Context context) {
            this.f49204a = bVar;
            this.f49205b = gVar;
            this.f49206c = context;
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            boolean z = true;
            if (i != 1) {
                this.f49204a.b(this.f49205b.E, 1001, "no camera permission");
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
                this.f49204a.b(this.f49205b.E, 1012, "no camera permission");
                d.b.g0.a.c0.c.b("map", "handleAuthorized camera end, failure");
                return;
            }
            d.b.g0.a.c0.c.b("map", "has camera authorize");
            b.this.p(this.f49206c, this.f49205b, this.f49204a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f49208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49209b;

        public d(d.b.g0.a.a1.b bVar, g gVar) {
            this.f49208a = bVar;
            this.f49209b = gVar;
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void a(d.b.g0.a.t1.k.k0.b bVar) {
            d.b.g0.a.c0.c.g("map", "get location ok ");
            b.this.o(d.b.g0.a.r1.e.y().A(), new LatLng(bVar.f46844c, bVar.f46843b), this.f49208a, this.f49209b);
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void onFailed(int i) {
            d.b.g0.a.c0.c.g("map", "get location error " + i);
            this.f49208a.b(this.f49209b.E, 1007, "get location fail");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f49211a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f49212b;

        public e(d.b.g0.a.a1.b bVar, g gVar) {
            this.f49211a = bVar;
            this.f49212b = gVar;
        }

        @Override // d.b.g0.h.a.j.h.b.c
        public void a() {
            Bundle bundle;
            d.b.g0.a.c0.c.g("map", "walk navigation onPrepareSuccess ");
            d.b.g0.a.e0.l.e A = f.V().A();
            if (b.this.f49190a != null && A == b.this.f49190a.get()) {
                SDKInitializer.setCoordType(CoordType.GCJ02);
                if (TextUtils.isEmpty(b.this.f49191b) && TextUtils.isEmpty(b.this.f49192c)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("guideKey", b.this.f49191b);
                    bundle.putString("guideIcon", b.this.f49192c);
                }
                d.b.g0.h.a.j.h.a.I2(bundle).J2();
                this.f49211a.c(this.f49212b.E, null);
                return;
            }
            this.f49211a.b(this.f49212b.E, 1001, "open navigation canceled on another page");
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
                this.f49211a.b(this.f49212b.E, 1005, "the distance is less than 30 meters");
            } else if (str.contains("the distance is longer than 50 kilometers")) {
                this.f49211a.b(this.f49212b.E, 1006, "the distance is longer than 50 kilometers");
            } else {
                this.f49211a.b(this.f49212b.E, 1004, "prepare route error");
            }
        }
    }

    public static b m() {
        return new b();
    }

    public final void k(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, String str) {
        eVar.R().g((Activity) context, PermissionProxy.SCOPE_ID_CAMERA, new C1024b(bVar, str, context, eVar, cVar));
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
        d.b.g0.h.a.j.h.b.f(activity, latLng, new LatLng(cVar.f43583e, cVar.f43584f), new e(bVar, gVar));
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
        this.f49191b = gVar.F;
        if (f49189d) {
            Log.e("WalkNavigationAction", "mGuideDownloadKey = " + this.f49191b);
        }
        this.f49192c = gVar.G;
        if (f49189d) {
            Log.e("WalkNavigationAction", "mGuideIconPath = " + this.f49192c);
        }
        if (d.b.g0.a.a2.b.c(this.f49192c) == PathType.BD_FILE) {
            this.f49192c = d.b.g0.a.a2.b.u(this.f49192c, d.b.g0.a.r1.e.T());
        }
        if (!SwanAppNetworkUtils.h(context)) {
            d.b.g0.a.c0.c.l("map", "no network");
            bVar.b(str, 1003, "no network");
            return false;
        }
        this.f49190a = new WeakReference<>(f.V().A());
        d.b.g0.h.a.f.f.d.b(context, new a(context, gVar, bVar, eVar, str));
        d.b.g0.a.c0.c.g("map", "WalkNavigationAction end");
        return true;
    }
}
