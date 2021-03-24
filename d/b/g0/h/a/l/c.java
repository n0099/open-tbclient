package d.b.g0.h.a.l;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BaiduMap f48839e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f48840f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f48841g;

    public c(BaiduMap baiduMap) {
        this.f48839e = null;
        this.f48840f = null;
        this.f48841g = null;
        this.f48839e = baiduMap;
        if (0 == 0) {
            this.f48840f = new ArrayList();
        }
        if (this.f48841g == null) {
            this.f48841g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f48839e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f48840f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f48840f) {
            this.f48841g.add(this.f48839e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f48839e == null) {
            return;
        }
        for (Overlay overlay : this.f48841g) {
            overlay.remove();
        }
        this.f48840f.clear();
        this.f48841g.clear();
    }

    public void d() {
        if (this.f48839e != null && this.f48841g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f48841g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f48839e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
