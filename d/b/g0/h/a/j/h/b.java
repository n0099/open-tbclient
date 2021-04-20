package d.b.g0.h.a.j.h;

import android.app.Activity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements IWEngineInitListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LatLng f49222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LatLng f49223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WalkNavigateHelper f49224c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f49225d;

        public a(LatLng latLng, LatLng latLng2, WalkNavigateHelper walkNavigateHelper, c cVar) {
            this.f49222a = latLng;
            this.f49223b = latLng2;
            this.f49224c = walkNavigateHelper;
            this.f49225d = cVar;
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
        public void engineInitFail() {
            this.f49224c.quit();
            c cVar = this.f49225d;
            if (cVar != null) {
                cVar.c("engineInitFail");
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
        public void engineInitSuccess() {
            b.g(this.f49224c, b.d(this.f49222a, this.f49223b), this.f49225d);
        }
    }

    /* renamed from: d.b.g0.h.a.j.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1028b implements IWRoutePlanListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f49226a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WalkNavigateHelper f49227b;

        public C1028b(c cVar, WalkNavigateHelper walkNavigateHelper) {
            this.f49226a = cVar;
            this.f49227b = walkNavigateHelper;
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError) {
            this.f49227b.quit();
            c cVar = this.f49226a;
            if (cVar != null) {
                cVar.c(walkRoutePlanError.toString());
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanStart() {
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanSuccess() {
            c cVar = this.f49226a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b();

        void c(String str);
    }

    public static LatLng c(LatLng latLng) {
        CoordinateConverter coordinateConverter = new CoordinateConverter();
        coordinateConverter.from(CoordinateConverter.CoordType.COMMON);
        coordinateConverter.coord(latLng);
        return coordinateConverter.convert();
    }

    public static WalkNaviLaunchParam d(LatLng latLng, LatLng latLng2) {
        LatLng c2 = c(latLng);
        return new WalkNaviLaunchParam().stPt(c2).endPt(c(latLng2));
    }

    public static void e(Activity activity, LatLng latLng, LatLng latLng2, c cVar) {
        WalkNavigateHelper walkNavigateHelper = WalkNavigateHelper.getInstance();
        if (cVar != null) {
            try {
                cVar.b();
            } catch (Exception e2) {
                d.b.g0.a.c0.c.b("map", "initNaviEngine fail");
                walkNavigateHelper.quit();
                if (cVar != null) {
                    cVar.c(e2.getMessage());
                    return;
                }
                return;
            }
        }
        walkNavigateHelper.initNaviEngine(activity, new a(latLng, latLng2, walkNavigateHelper, cVar));
    }

    public static void f(Activity activity, LatLng latLng, LatLng latLng2, c cVar) {
        d.b.g0.h.a.a.a();
        e(activity, latLng, latLng2, cVar);
    }

    public static void g(WalkNavigateHelper walkNavigateHelper, WalkNaviLaunchParam walkNaviLaunchParam, c cVar) {
        try {
            walkNavigateHelper.routePlanWithParams(walkNaviLaunchParam, new C1028b(cVar, walkNavigateHelper));
        } catch (Exception e2) {
            d.b.g0.a.c0.c.b("map", "routePlanWithParams fail");
            walkNavigateHelper.quit();
            if (cVar != null) {
                cVar.c(e2.getMessage());
            }
        }
    }
}
