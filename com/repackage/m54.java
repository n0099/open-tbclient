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
import com.repackage.k54;
/* loaded from: classes6.dex */
public class m54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements k54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r44 a;

        public a(r44 r44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r44Var;
        }

        @Override // com.repackage.k54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jx1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.k54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                jx1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, t54 t54Var, vm2 vm2Var, r44 r44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, t54Var, vm2Var, r44Var) == null) {
            b(context, t54Var, vm2Var, r44Var, false);
        }
    }

    public static void b(Context context, t54 t54Var, vm2 vm2Var, r44 r44Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, t54Var, vm2Var, r44Var, Boolean.valueOf(z)}) == null) {
            if (t54Var != null && vm2Var != null && vm2Var.isValid()) {
                BaiduMap map = t54Var.l.getMap();
                p54 p54Var = new p54(t54Var);
                map.setOnMapClickListener(p54Var);
                map.setOnMarkerClickListener(p54Var);
                map.setOnMapLoadedCallback(p54Var);
                map.setOnMapRenderCallbadk(p54Var);
                map.setOnMapStatusChangeListener(p54Var);
                map.setOnMyLocationClickListener(p54Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(vm2Var.t);
                uiSettings.setRotateGesturesEnabled(vm2Var.u);
                uiSettings.setZoomGesturesEnabled(vm2Var.s);
                t54Var.l.showZoomControls(false);
                t54Var.l.showScaleControl(false);
                map.setBuildingsEnabled(vm2Var.x);
                uiSettings.setOverlookingGesturesEnabled(vm2Var.w);
                cn2 cn2Var = vm2Var.j;
                if (cn2Var != null && cn2Var.isValid()) {
                    jx1.i("map", "initMapView coordinate is " + vm2Var.j);
                    cn2 cn2Var2 = vm2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cn2Var2.a, cn2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) vm2Var.k));
                jx1.i("map", "initMapView scale is " + vm2Var.k);
                boolean z2 = vm2Var.r;
                t54Var.k = z2;
                if (z2) {
                    c(context, r44Var);
                } else {
                    r44Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(vm2Var.v);
                n54.e(AppRuntime.getAppContext(), vm2Var, t54Var);
                n54.d(vm2Var, t54Var, p54Var);
                return;
            }
            jx1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, r44 r44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, r44Var) == null) {
            k54.b(context, new a(r44Var));
        }
    }
}
