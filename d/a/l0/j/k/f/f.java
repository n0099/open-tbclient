package d.a.l0.j.k.f;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.j.k.f.d;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.b f47857a;

        public a(d.a.l0.j.b bVar) {
            this.f47857a = bVar;
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onFail() {
            d.a.l0.a.e0.d.g("map", "location permission fail");
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onSuccess() {
            this.f47857a.q(true);
            d.a.l0.a.e0.d.g("map", "location permission success");
        }
    }

    public static void a(Context context, d.a.l0.j.n.c cVar, d.a.l0.a.h1.c.c cVar2, d.a.l0.j.b bVar) {
        b(context, cVar, cVar2, bVar, false);
    }

    public static void b(Context context, d.a.l0.j.n.c cVar, d.a.l0.a.h1.c.c cVar2, d.a.l0.j.b bVar, boolean z) {
        if (cVar != null && cVar2 != null && cVar2.isValid()) {
            BaiduMap map = cVar.l.getMap();
            d.a.l0.j.l.b bVar2 = new d.a.l0.j.l.b(cVar);
            map.setOnMapClickListener(bVar2);
            map.setOnMarkerClickListener(bVar2);
            map.setOnMapLoadedCallback(bVar2);
            map.setOnMapRenderCallbadk(bVar2);
            map.setOnMapStatusChangeListener(bVar2);
            map.setOnMyLocationClickListener(bVar2);
            UiSettings uiSettings = map.getUiSettings();
            uiSettings.setScrollGesturesEnabled(cVar2.x);
            uiSettings.setRotateGesturesEnabled(cVar2.y);
            uiSettings.setZoomGesturesEnabled(cVar2.w);
            cVar.l.showZoomControls(false);
            cVar.l.showScaleControl(false);
            map.setBuildingsEnabled(cVar2.B);
            uiSettings.setOverlookingGesturesEnabled(cVar2.A);
            d.a.l0.a.h1.c.h.c cVar3 = cVar2.n;
            if (cVar3 != null && cVar3.isValid()) {
                d.a.l0.a.e0.d.g("map", "initMapView coordinate is " + cVar2.n);
                d.a.l0.a.h1.c.h.c cVar4 = cVar2.n;
                map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cVar4.f42673e, cVar4.f42674f)));
            }
            map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) cVar2.o));
            d.a.l0.a.e0.d.g("map", "initMapView scale is " + cVar2.o);
            boolean z2 = cVar2.v;
            cVar.k = z2;
            if (z2) {
                c(context, bVar);
            } else {
                bVar.q(false);
                map.setMyLocationEnabled(false);
            }
            uiSettings.setCompassEnabled(cVar2.z);
            g.e(AppRuntime.getAppContext(), cVar2, cVar);
            g.d(cVar2, cVar, bVar2);
            return;
        }
        d.a.l0.a.e0.d.b("map", "initMapView model is invalid");
    }

    public static void c(Context context, d.a.l0.j.b bVar) {
        d.b(context, new a(bVar));
    }
}
