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
    public BaiduMap f49232e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f49233f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f49234g;

    public c(BaiduMap baiduMap) {
        this.f49232e = null;
        this.f49233f = null;
        this.f49234g = null;
        this.f49232e = baiduMap;
        if (0 == 0) {
            this.f49233f = new ArrayList();
        }
        if (this.f49234g == null) {
            this.f49234g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f49232e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f49233f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f49233f) {
            this.f49234g.add(this.f49232e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f49232e == null) {
            return;
        }
        for (Overlay overlay : this.f49234g) {
            overlay.remove();
        }
        this.f49233f.clear();
        this.f49234g.clear();
    }

    public void d() {
        if (this.f49232e != null && this.f49234g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f49234g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f49232e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
