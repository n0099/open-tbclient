package d.a.l0.j.q;

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
    public BaiduMap f47928e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f47929f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f47930g;

    public c(BaiduMap baiduMap) {
        this.f47928e = null;
        this.f47929f = null;
        this.f47930g = null;
        this.f47928e = baiduMap;
        if (0 == 0) {
            this.f47929f = new ArrayList();
        }
        if (this.f47930g == null) {
            this.f47930g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f47928e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f47929f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f47929f) {
            this.f47930g.add(this.f47928e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f47928e == null) {
            return;
        }
        for (Overlay overlay : this.f47930g) {
            overlay.remove();
        }
        this.f47929f.clear();
        this.f47930g.clear();
    }

    public void d() {
        if (this.f47928e != null && this.f47930g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f47930g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f47928e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
