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
    public BaiduMap f51602e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f51603f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f51604g;

    public c(BaiduMap baiduMap) {
        this.f51602e = null;
        this.f51603f = null;
        this.f51604g = null;
        this.f51602e = baiduMap;
        if (0 == 0) {
            this.f51603f = new ArrayList();
        }
        if (this.f51604g == null) {
            this.f51604g = new ArrayList();
        }
    }

    public final void a() {
        if (this.f51602e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f51603f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f51603f) {
            this.f51604g.add(this.f51602e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        if (this.f51602e == null) {
            return;
        }
        for (Overlay overlay : this.f51604g) {
            overlay.remove();
        }
        this.f51603f.clear();
        this.f51604g.clear();
    }

    public void d() {
        if (this.f51602e != null && this.f51604g.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : this.f51604g) {
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            this.f51602e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
        }
    }
}
