package d.a.o0.j.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class c implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaiduMap f51056e;

    /* renamed from: f  reason: collision with root package name */
    public List<OverlayOptions> f51057f;

    /* renamed from: g  reason: collision with root package name */
    public List<Overlay> f51058g;

    public c(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51056e = null;
        this.f51057f = null;
        this.f51058g = null;
        this.f51056e = baiduMap;
        if (0 == 0) {
            this.f51057f = new ArrayList();
        }
        if (this.f51058g == null) {
            this.f51058g = new ArrayList();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51056e == null) {
            return;
        }
        c();
        if (b() != null) {
            this.f51057f.addAll(b());
        }
        for (OverlayOptions overlayOptions : this.f51057f) {
            this.f51058g.add(this.f51056e.addOverlay(overlayOptions));
        }
    }

    public abstract List<OverlayOptions> b();

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f51056e == null) {
            return;
        }
        for (Overlay overlay : this.f51058g) {
            overlay.remove();
        }
        this.f51057f.clear();
        this.f51058g.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f51056e == null || this.f51058g.size() <= 0) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Overlay overlay : this.f51058g) {
            if (overlay instanceof Marker) {
                builder.include(((Marker) overlay).getPosition());
            }
        }
        this.f51056e.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
    }
}
