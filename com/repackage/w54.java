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
import com.repackage.u54;
/* loaded from: classes7.dex */
public class w54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements u54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b54 a;

        public a(b54 b54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b54Var;
        }

        @Override // com.repackage.u54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.u54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                ux1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, d64 d64Var, gn2 gn2Var, b54 b54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, d64Var, gn2Var, b54Var) == null) {
            b(context, d64Var, gn2Var, b54Var, false);
        }
    }

    public static void b(Context context, d64 d64Var, gn2 gn2Var, b54 b54Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, d64Var, gn2Var, b54Var, Boolean.valueOf(z)}) == null) {
            if (d64Var != null && gn2Var != null && gn2Var.isValid()) {
                BaiduMap map = d64Var.l.getMap();
                z54 z54Var = new z54(d64Var);
                map.setOnMapClickListener(z54Var);
                map.setOnMarkerClickListener(z54Var);
                map.setOnMapLoadedCallback(z54Var);
                map.setOnMapRenderCallbadk(z54Var);
                map.setOnMapStatusChangeListener(z54Var);
                map.setOnMyLocationClickListener(z54Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(gn2Var.t);
                uiSettings.setRotateGesturesEnabled(gn2Var.u);
                uiSettings.setZoomGesturesEnabled(gn2Var.s);
                d64Var.l.showZoomControls(false);
                d64Var.l.showScaleControl(false);
                map.setBuildingsEnabled(gn2Var.x);
                uiSettings.setOverlookingGesturesEnabled(gn2Var.w);
                nn2 nn2Var = gn2Var.j;
                if (nn2Var != null && nn2Var.isValid()) {
                    ux1.i("map", "initMapView coordinate is " + gn2Var.j);
                    nn2 nn2Var2 = gn2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(nn2Var2.a, nn2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) gn2Var.k));
                ux1.i("map", "initMapView scale is " + gn2Var.k);
                boolean z2 = gn2Var.r;
                d64Var.k = z2;
                if (z2) {
                    c(context, b54Var);
                } else {
                    b54Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(gn2Var.v);
                x54.e(AppRuntime.getAppContext(), gn2Var, d64Var);
                x54.d(gn2Var, d64Var, z54Var);
                return;
            }
            ux1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, b54 b54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, b54Var) == null) {
            u54.b(context, new a(b54Var));
        }
    }
}
