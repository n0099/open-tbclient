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
import com.repackage.s44;
/* loaded from: classes7.dex */
public class u44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements s44.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z34 a;

        public a(z34 z34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z34Var;
        }

        @Override // com.repackage.s44.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sw1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.s44.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                sw1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, b54 b54Var, em2 em2Var, z34 z34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, b54Var, em2Var, z34Var) == null) {
            b(context, b54Var, em2Var, z34Var, false);
        }
    }

    public static void b(Context context, b54 b54Var, em2 em2Var, z34 z34Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, b54Var, em2Var, z34Var, Boolean.valueOf(z)}) == null) {
            if (b54Var != null && em2Var != null && em2Var.isValid()) {
                BaiduMap map = b54Var.l.getMap();
                x44 x44Var = new x44(b54Var);
                map.setOnMapClickListener(x44Var);
                map.setOnMarkerClickListener(x44Var);
                map.setOnMapLoadedCallback(x44Var);
                map.setOnMapRenderCallbadk(x44Var);
                map.setOnMapStatusChangeListener(x44Var);
                map.setOnMyLocationClickListener(x44Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(em2Var.t);
                uiSettings.setRotateGesturesEnabled(em2Var.u);
                uiSettings.setZoomGesturesEnabled(em2Var.s);
                b54Var.l.showZoomControls(false);
                b54Var.l.showScaleControl(false);
                map.setBuildingsEnabled(em2Var.x);
                uiSettings.setOverlookingGesturesEnabled(em2Var.w);
                lm2 lm2Var = em2Var.j;
                if (lm2Var != null && lm2Var.isValid()) {
                    sw1.i("map", "initMapView coordinate is " + em2Var.j);
                    lm2 lm2Var2 = em2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(lm2Var2.a, lm2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) em2Var.k));
                sw1.i("map", "initMapView scale is " + em2Var.k);
                boolean z2 = em2Var.r;
                b54Var.k = z2;
                if (z2) {
                    c(context, z34Var);
                } else {
                    z34Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(em2Var.v);
                v44.e(AppRuntime.getAppContext(), em2Var, b54Var);
                v44.d(em2Var, b54Var, x44Var);
                return;
            }
            sw1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, z34 z34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, z34Var) == null) {
            s44.b(context, new a(z34Var));
        }
    }
}
