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
import com.repackage.i54;
/* loaded from: classes6.dex */
public class k54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements i54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p44 a;

        public a(p44 p44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p44Var;
        }

        @Override // com.repackage.i54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ix1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.i54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                ix1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, r54 r54Var, um2 um2Var, p44 p44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, r54Var, um2Var, p44Var) == null) {
            b(context, r54Var, um2Var, p44Var, false);
        }
    }

    public static void b(Context context, r54 r54Var, um2 um2Var, p44 p44Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, r54Var, um2Var, p44Var, Boolean.valueOf(z)}) == null) {
            if (r54Var != null && um2Var != null && um2Var.isValid()) {
                BaiduMap map = r54Var.l.getMap();
                n54 n54Var = new n54(r54Var);
                map.setOnMapClickListener(n54Var);
                map.setOnMarkerClickListener(n54Var);
                map.setOnMapLoadedCallback(n54Var);
                map.setOnMapRenderCallbadk(n54Var);
                map.setOnMapStatusChangeListener(n54Var);
                map.setOnMyLocationClickListener(n54Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(um2Var.t);
                uiSettings.setRotateGesturesEnabled(um2Var.u);
                uiSettings.setZoomGesturesEnabled(um2Var.s);
                r54Var.l.showZoomControls(false);
                r54Var.l.showScaleControl(false);
                map.setBuildingsEnabled(um2Var.x);
                uiSettings.setOverlookingGesturesEnabled(um2Var.w);
                bn2 bn2Var = um2Var.j;
                if (bn2Var != null && bn2Var.isValid()) {
                    ix1.i("map", "initMapView coordinate is " + um2Var.j);
                    bn2 bn2Var2 = um2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bn2Var2.a, bn2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) um2Var.k));
                ix1.i("map", "initMapView scale is " + um2Var.k);
                boolean z2 = um2Var.r;
                r54Var.k = z2;
                if (z2) {
                    c(context, p44Var);
                } else {
                    p44Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(um2Var.v);
                l54.e(AppRuntime.getAppContext(), um2Var, r54Var);
                l54.d(um2Var, r54Var, n54Var);
                return;
            }
            ix1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, p44 p44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, p44Var) == null) {
            i54.b(context, new a(p44Var));
        }
    }
}
