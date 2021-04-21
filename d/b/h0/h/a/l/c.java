package d.b.h0.h.a.l;

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
    public BaiduMap f49561e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f49562f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f49563g;

    public c(BaiduMap baiduMap) {
        this.f49561e = null;
        this.f49562f = null;
        this.f49563g = null;
        this.f49561e = baiduMap;
        if (0 == 0) {
            this.f49562f = new ArrayList();
        }
        if (this.f49563g == null) {
            this.f49563g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f49561e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f49562f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f49562f) {
            this.f49563g.add(this.f49561e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f49561e == null) {
            return;
        }
        for (Overlay overlay : this.f49563g) {
            overlay.remove();
        }
        this.f49562f.clear();
        this.f49563g.clear();
    }

    public void d() {
        if (this.f49561e != null && this.f49563g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f49563g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f49561e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
