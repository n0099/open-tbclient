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
import com.repackage.h44;
/* loaded from: classes6.dex */
public class j44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements h44.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o34 a;

        public a(o34 o34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o34Var;
        }

        @Override // com.repackage.h44.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hw1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.h44.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                hw1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, q44 q44Var, tl2 tl2Var, o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, q44Var, tl2Var, o34Var) == null) {
            b(context, q44Var, tl2Var, o34Var, false);
        }
    }

    public static void b(Context context, q44 q44Var, tl2 tl2Var, o34 o34Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, q44Var, tl2Var, o34Var, Boolean.valueOf(z)}) == null) {
            if (q44Var != null && tl2Var != null && tl2Var.isValid()) {
                BaiduMap map = q44Var.l.getMap();
                m44 m44Var = new m44(q44Var);
                map.setOnMapClickListener(m44Var);
                map.setOnMarkerClickListener(m44Var);
                map.setOnMapLoadedCallback(m44Var);
                map.setOnMapRenderCallbadk(m44Var);
                map.setOnMapStatusChangeListener(m44Var);
                map.setOnMyLocationClickListener(m44Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(tl2Var.t);
                uiSettings.setRotateGesturesEnabled(tl2Var.u);
                uiSettings.setZoomGesturesEnabled(tl2Var.s);
                q44Var.l.showZoomControls(false);
                q44Var.l.showScaleControl(false);
                map.setBuildingsEnabled(tl2Var.x);
                uiSettings.setOverlookingGesturesEnabled(tl2Var.w);
                am2 am2Var = tl2Var.j;
                if (am2Var != null && am2Var.isValid()) {
                    hw1.i("map", "initMapView coordinate is " + tl2Var.j);
                    am2 am2Var2 = tl2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(am2Var2.a, am2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) tl2Var.k));
                hw1.i("map", "initMapView scale is " + tl2Var.k);
                boolean z2 = tl2Var.r;
                q44Var.k = z2;
                if (z2) {
                    c(context, o34Var);
                } else {
                    o34Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(tl2Var.v);
                k44.e(AppRuntime.getAppContext(), tl2Var, q44Var);
                k44.d(tl2Var, q44Var, m44Var);
                return;
            }
            hw1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, o34Var) == null) {
            h44.b(context, new a(o34Var));
        }
    }
}
