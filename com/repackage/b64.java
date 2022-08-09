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
import com.repackage.z54;
/* loaded from: classes5.dex */
public class b64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements z54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g54 a;

        public a(g54 g54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g54Var;
        }

        @Override // com.repackage.z54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zx1.i("map", "location permission fail");
            }
        }

        @Override // com.repackage.z54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                zx1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, i64 i64Var, ln2 ln2Var, g54 g54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, i64Var, ln2Var, g54Var) == null) {
            b(context, i64Var, ln2Var, g54Var, false);
        }
    }

    public static void b(Context context, i64 i64Var, ln2 ln2Var, g54 g54Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, i64Var, ln2Var, g54Var, Boolean.valueOf(z)}) == null) {
            if (i64Var != null && ln2Var != null && ln2Var.isValid()) {
                BaiduMap map = i64Var.l.getMap();
                e64 e64Var = new e64(i64Var);
                map.setOnMapClickListener(e64Var);
                map.setOnMarkerClickListener(e64Var);
                map.setOnMapLoadedCallback(e64Var);
                map.setOnMapRenderCallbadk(e64Var);
                map.setOnMapStatusChangeListener(e64Var);
                map.setOnMyLocationClickListener(e64Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ln2Var.t);
                uiSettings.setRotateGesturesEnabled(ln2Var.u);
                uiSettings.setZoomGesturesEnabled(ln2Var.s);
                i64Var.l.showZoomControls(false);
                i64Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ln2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ln2Var.w);
                sn2 sn2Var = ln2Var.j;
                if (sn2Var != null && sn2Var.isValid()) {
                    zx1.i("map", "initMapView coordinate is " + ln2Var.j);
                    sn2 sn2Var2 = ln2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(sn2Var2.a, sn2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ln2Var.k));
                zx1.i("map", "initMapView scale is " + ln2Var.k);
                boolean z2 = ln2Var.r;
                i64Var.k = z2;
                if (z2) {
                    c(context, g54Var);
                } else {
                    g54Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ln2Var.v);
                c64.e(AppRuntime.getAppContext(), ln2Var, i64Var);
                c64.d(ln2Var, i64Var, e64Var);
                return;
            }
            zx1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, g54 g54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, g54Var) == null) {
            z54.b(context, new a(g54Var));
        }
    }
}
