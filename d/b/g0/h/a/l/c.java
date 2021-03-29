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
    public BaiduMap f48840e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f48841f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f48842g;

    public c(BaiduMap baiduMap) {
        this.f48840e = null;
        this.f48841f = null;
        this.f48842g = null;
        this.f48840e = baiduMap;
        if (0 == 0) {
            this.f48841f = new ArrayList();
        }
        if (this.f48842g == null) {
            this.f48842g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f48840e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f48841f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f48841f) {
            this.f48842g.add(this.f48840e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f48840e == null) {
            return;
        }
        for (Overlay overlay : this.f48842g) {
            overlay.remove();
        }
        this.f48841f.clear();
        this.f48842g.clear();
    }

    public void d() {
        if (this.f48840e != null && this.f48842g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f48842g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f48840e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
