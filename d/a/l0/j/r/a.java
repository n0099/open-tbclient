package d.a.l0.j.r;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f47931b;

    /* renamed from: a  reason: collision with root package name */
    public RoutePlanSearch f47932a;

    public static a b() {
        if (f47931b == null) {
            synchronized (a.class) {
                if (f47931b == null) {
                    f47931b = new a();
                }
            }
        }
        return f47931b;
    }

    public void a() {
        RoutePlanSearch routePlanSearch = this.f47932a;
        if (routePlanSearch != null) {
            routePlanSearch.destroy();
        }
    }

    public void c(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng == null || latLng2 == null || onGetRoutePlanResultListener == null) {
            return;
        }
        RoutePlanSearch newInstance = RoutePlanSearch.newInstance();
        this.f47932a = newInstance;
        newInstance.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
        PlanNode withLocation = PlanNode.withLocation(latLng);
        this.f47932a.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
    }
}
