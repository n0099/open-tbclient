package d.a.i0.j.q;

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
    public BaiduMap f47752e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f47753f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f47754g;

    public c(BaiduMap baiduMap) {
        this.f47752e = null;
        this.f47753f = null;
        this.f47754g = null;
        this.f47752e = baiduMap;
        if (0 == 0) {
            this.f47753f = new ArrayList();
        }
        if (this.f47754g == null) {
            this.f47754g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f47752e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f47753f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f47753f) {
            this.f47754g.add(this.f47752e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f47752e == null) {
            return;
        }
        for (Overlay overlay : this.f47754g) {
            overlay.remove();
        }
        this.f47753f.clear();
        this.f47754g.clear();
    }

    public void d() {
        if (this.f47752e != null && this.f47754g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f47754g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f47752e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
