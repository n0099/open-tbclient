package com.repackage;

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
import com.repackage.h54;
/* loaded from: classes6.dex */
public class j54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements h54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o44 a;

        public a(o44 o44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o44Var;
        }

        @Override // com.repackage.h54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.h54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                hx1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, q54 q54Var, tm2 tm2Var, o44 o44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, q54Var, tm2Var, o44Var) == null) {
            b(context, q54Var, tm2Var, o44Var, false);
        }
    }

    public static void b(Context context, q54 q54Var, tm2 tm2Var, o44 o44Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, q54Var, tm2Var, o44Var, Boolean.valueOf(z)}) == null) {
            if (q54Var != null && tm2Var != null && tm2Var.isValid()) {
                BaiduMap map = q54Var.l.getMap();
                m54 m54Var = new m54(q54Var);
                map.setOnMapClickListener(m54Var);
                map.setOnMarkerClickListener(m54Var);
                map.setOnMapLoadedCallback(m54Var);
                map.setOnMapRenderCallbadk(m54Var);
                map.setOnMapStatusChangeListener(m54Var);
                map.setOnMyLocationClickListener(m54Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(tm2Var.t);
                uiSettings.setRotateGesturesEnabled(tm2Var.u);
                uiSettings.setZoomGesturesEnabled(tm2Var.s);
                q54Var.l.showZoomControls(false);
                q54Var.l.showScaleControl(false);
                map.setBuildingsEnabled(tm2Var.x);
                uiSettings.setOverlookingGesturesEnabled(tm2Var.w);
                an2 an2Var = tm2Var.j;
                if (an2Var != null && an2Var.isValid()) {
                    hx1.i("map", "initMapView coordinate is " + tm2Var.j);
                    an2 an2Var2 = tm2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(an2Var2.a, an2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) tm2Var.k));
                hx1.i("map", "initMapView scale is " + tm2Var.k);
                boolean z2 = tm2Var.r;
                q54Var.k = z2;
                if (z2) {
                    c(context, o44Var);
                } else {
                    o44Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(tm2Var.v);
                k54.e(AppRuntime.getAppContext(), tm2Var, q54Var);
                k54.d(tm2Var, q54Var, m54Var);
                return;
            }
            hx1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, o44 o44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, o44Var) == null) {
            h54.b(context, new a(o44Var));
        }
    }
}
