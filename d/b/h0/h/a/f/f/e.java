package d.b.h0.h.a.f.f;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.h.a.f.f.d;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.h.a.b f49457a;

        public a(d.b.h0.h.a.b bVar) {
            this.f49457a = bVar;
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onFail() {
            d.b.h0.a.c0.c.g("map", "location permission fail");
        }

        @Override // d.b.h0.h.a.f.f.d.c
        public void onSuccess() {
            this.f49457a.q(true);
            d.b.h0.a.c0.c.g("map", "location permission success");
        }
    }

    public static void a(Context context, d.b.h0.h.a.i.c cVar, d.b.h0.a.a1.c.c cVar2, d.b.h0.h.a.b bVar) {
        b(context, cVar, cVar2, bVar, false);
    }

    public static void b(Context context, d.b.h0.h.a.i.c cVar, d.b.h0.a.a1.c.c cVar2, d.b.h0.h.a.b bVar, boolean z) {
        if (cVar != null && cVar2 != null && cVar2.isValid()) {
            BaiduMap map = cVar.l.getMap();
            d.b.h0.h.a.g.b bVar2 = new d.b.h0.h.a.g.b(cVar);
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
            cVar.l.showZoomControls(cVar2.w);
            map.setBuildingsEnabled(cVar2.B);
            uiSettings.setOverlookingGesturesEnabled(cVar2.A);
            d.b.h0.a.a1.c.h.c cVar3 = cVar2.n;
            if (cVar3 != null && cVar3.isValid()) {
                d.b.h0.a.c0.c.g("map", "initMapView coordinate is " + cVar2.n);
                d.b.h0.a.a1.c.h.c cVar4 = cVar2.n;
                map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cVar4.f43912e, cVar4.f43913f)));
            }
            MapStatus mapStatus = map.getMapStatus();
            float f2 = mapStatus != null ? mapStatus.zoom : (float) cVar2.o;
            if (!z) {
                f2 = (float) cVar2.o;
            }
            map.setMapStatus(MapStatusUpdateFactory.zoomTo(f2));
            d.b.h0.a.c0.c.g("map", "initMapView scale is " + cVar2.o);
            boolean z2 = cVar2.v;
            cVar.k = z2;
            if (z2) {
                c(context, bVar);
            } else {
                bVar.q(false);
            }
            uiSettings.setCompassEnabled(cVar2.z);
            f.e(AppRuntime.getAppContext(), cVar2, cVar);
            f.d(cVar2, cVar, bVar2);
            return;
        }
        d.b.h0.a.c0.c.b("map", "initMapView model is invalid");
    }

    public static void c(Context context, d.b.h0.h.a.b bVar) {
        d.b(context, new a(bVar));
    }
}
