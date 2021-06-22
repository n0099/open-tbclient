package d.a.m0.j.q;

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
    public BaiduMap f51710e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f51711f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f51712g;

    public c(BaiduMap baiduMap) {
        this.f51710e = null;
        this.f51711f = null;
        this.f51712g = null;
        this.f51710e = baiduMap;
        if (0 == 0) {
            this.f51711f = new ArrayList();
        }
        if (this.f51712g == null) {
            this.f51712g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f51710e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f51711f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f51711f) {
            this.f51712g.add(this.f51710e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f51710e == null) {
            return;
        }
        for (Overlay overlay : this.f51712g) {
            overlay.remove();
        }
        this.f51711f.clear();
        this.f51712g.clear();
    }

    public void d() {
        if (this.f51710e != null && this.f51712g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f51712g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f51710e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
