package d.a.h0.h.a.l;

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
    public BaiduMap f47065e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f47066f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f47067g;

    public c(BaiduMap baiduMap) {
        this.f47065e = null;
        this.f47066f = null;
        this.f47067g = null;
        this.f47065e = baiduMap;
        if (0 == 0) {
            this.f47066f = new ArrayList();
        }
        if (this.f47067g == null) {
            this.f47067g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f47065e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f47066f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f47066f) {
            this.f47067g.add(this.f47065e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f47065e == null) {
            return;
        }
        for (Overlay overlay : this.f47067g) {
            overlay.remove();
        }
        this.f47066f.clear();
        this.f47067g.clear();
    }

    public void d() {
        if (this.f47065e != null && this.f47067g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f47067g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f47065e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
