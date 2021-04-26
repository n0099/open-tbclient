package d.a.h0.h.a.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import d.a.h0.a.k;
import d.a.h0.h.a.i.c;
/* loaded from: classes3.dex */
public class b implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapClickListener, BaiduMap.OnMapRenderCallback, BaiduMap.OnMarkerClickListener, View.OnClickListener, BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMyLocationClickListener {

    /* renamed from: e  reason: collision with root package name */
    public c f46970e;

    static {
        boolean z = k.f43101a;
    }

    public b(@NonNull c cVar) {
        this.f46970e = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.b(view, this.f46970e);
        d.a.h0.a.c0.c.g("map", "Control View click");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        a.d(this.f46970e, latLng);
        d.a.h0.a.c0.c.g("map", "onMapClick LatLng " + latLng);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        d.a.h0.a.c0.c.g("map", "onMapLoaded");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public boolean onMapPoiClick(MapPoi mapPoi) {
        a.c(this.f46970e, mapPoi);
        d.a.h0.a.c0.c.g("map", "onMapPoiClick MapPoi " + mapPoi.getPosition());
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapRenderCallback
    public void onMapRenderFinished() {
        a.e(this.f46970e);
        d.a.h0.a.c0.c.g("map", "onMapRenderFinished");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        d.a.h0.a.c0.c.g("map", "onMapStatusChange");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        a.g(this.f46970e, mapStatus);
        d.a.h0.a.c0.c.g("map", "onMapStatusChangeFinish");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        d.a.h0.h.a.i.b J = this.f46970e.J(marker);
        if (J != null) {
            a.f(marker, this.f46970e);
            J.b(this.f46970e);
            d.a.h0.a.c0.c.g("map", "onMarkerClick marker id " + marker.getId());
            return true;
        }
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMyLocationClickListener
    public boolean onMyLocationClick() {
        return false;
    }
}
