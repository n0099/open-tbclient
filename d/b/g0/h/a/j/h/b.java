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
        public final /* synthetic */ LatLng f48830a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LatLng f48831b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WalkNavigateHelper f48832c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f48833d;

        public a(LatLng latLng, LatLng latLng2, WalkNavigateHelper walkNavigateHelper, c cVar) {
            this.f48830a = latLng;
            this.f48831b = latLng2;
            this.f48832c = walkNavigateHelper;
            this.f48833d = cVar;
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
        public void engineInitFail() {
            this.f48832c.quit();
            c cVar = this.f48833d;
            if (cVar != null) {
                cVar.c("engineInitFail");
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
        public void engineInitSuccess() {
            b.g(this.f48832c, b.d(this.f48830a, this.f48831b), this.f48833d);
        }
    }

    /* renamed from: d.b.g0.h.a.j.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1016b implements IWRoutePlanListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f48834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WalkNavigateHelper f48835b;

        public C1016b(c cVar, WalkNavigateHelper walkNavigateHelper) {
            this.f48834a = cVar;
            this.f48835b = walkNavigateHelper;
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError) {
            this.f48835b.quit();
            c cVar = this.f48834a;
            if (cVar != null) {
                cVar.c(walkRoutePlanError.toString());
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanStart() {
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
        public void onRoutePlanSuccess() {
            c cVar = this.f48834a;
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
            walkNavigateHelper.routePlanWithParams(walkNaviLaunchParam, new C1016b(cVar, walkNavigateHelper));
        } catch (Exception e2) {
            d.b.g0.a.c0.c.b("map", "routePlanWithParams fail");
            walkNavigateHelper.quit();
            if (cVar != null) {
                cVar.c(e2.getMessage());
            }
        }
    }
}
