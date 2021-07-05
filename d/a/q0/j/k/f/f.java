package d.a.q0.j.k.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.j.k.f.d;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.b f53783a;

        public a(d.a.q0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53783a = bVar;
        }

        @Override // d.a.q0.j.k.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e0.d.g("map", "location permission fail");
            }
        }

        @Override // d.a.q0.j.k.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53783a.q(true);
                d.a.q0.a.e0.d.g("map", "location permission success");
            }
        }
    }

    public static void a(Context context, d.a.q0.j.n.c cVar, d.a.q0.a.h1.c.c cVar2, d.a.q0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, cVar, cVar2, bVar) == null) {
            b(context, cVar, cVar2, bVar, false);
        }
    }

    public static void b(Context context, d.a.q0.j.n.c cVar, d.a.q0.a.h1.c.c cVar2, d.a.q0.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, cVar, cVar2, bVar, Boolean.valueOf(z)}) == null) {
            if (cVar != null && cVar2 != null && cVar2.isValid()) {
                BaiduMap map = cVar.l.getMap();
                d.a.q0.j.l.b bVar2 = new d.a.q0.j.l.b(cVar);
                map.setOnMapClickListener(bVar2);
                map.setOnMarkerClickListener(bVar2);
                map.setOnMapLoadedCallback(bVar2);
                map.setOnMapRenderCallbadk(bVar2);
                map.setOnMapStatusChangeListener(bVar2);
                map.setOnMyLocationClickListener(bVar2);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(cVar2.x);
                uiSettings.setRotateGesturesEnabled(cVar2.y);
                uiSettings.setZoomGesturesEnabled(cVar2.w);
                cVar.l.showZoomControls(false);
                cVar.l.showScaleControl(false);
                map.setBuildingsEnabled(cVar2.B);
                uiSettings.setOverlookingGesturesEnabled(cVar2.A);
                d.a.q0.a.h1.c.h.c cVar3 = cVar2.n;
                if (cVar3 != null && cVar3.isValid()) {
                    d.a.q0.a.e0.d.g("map", "initMapView coordinate is " + cVar2.n);
                    d.a.q0.a.h1.c.h.c cVar4 = cVar2.n;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cVar4.f48607e, cVar4.f48608f)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) cVar2.o));
                d.a.q0.a.e0.d.g("map", "initMapView scale is " + cVar2.o);
                boolean z2 = cVar2.v;
                cVar.k = z2;
                if (z2) {
                    c(context, bVar);
                } else {
                    bVar.q(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(cVar2.z);
                g.e(AppRuntime.getAppContext(), cVar2, cVar);
                g.d(cVar2, cVar, bVar2);
                return;
            }
            d.a.q0.a.e0.d.b("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, d.a.q0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, bVar) == null) {
            d.b(context, new a(bVar));
        }
    }
}
