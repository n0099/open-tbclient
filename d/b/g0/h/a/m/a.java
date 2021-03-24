package d.b.g0.h.a.m;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f48842b;

    /* renamed from: a  reason: collision with root package name */
    public RoutePlanSearch f48843a;

    public static a b() {
        if (f48842b == null) {
            synchronized (a.class) {
                if (f48842b == null) {
                    f48842b = new a();
                }
            }
        }
        return f48842b;
    }

    public void a() {
        RoutePlanSearch routePlanSearch = this.f48843a;
        if (routePlanSearch != null) {
            routePlanSearch.destroy();
        }
    }

    public void c(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng == null || latLng2 == null || onGetRoutePlanResultListener == null) {
            return;
        }
        RoutePlanSearch newInstance = RoutePlanSearch.newInstance();
        this.f48843a = newInstance;
        newInstance.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
        PlanNode withLocation = PlanNode.withLocation(latLng);
        this.f48843a.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
    }
}
