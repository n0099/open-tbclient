package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m54 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapClickListener, BaiduMap.OnMapRenderCallback, BaiduMap.OnMarkerClickListener, View.OnClickListener, BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMyLocationClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public q54 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755548315, "Lcom/repackage/m54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755548315, "Lcom/repackage/m54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public m54(@NonNull q54 q54Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q54Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = q54Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            l54.b(view2, this.b);
            hx1.i("map", "Control View click");
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng) == null) {
            l54.d(this.b, latLng);
            hx1.i("map", "onMapClick LatLng " + latLng);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hx1.i("map", "onMapLoaded");
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public boolean onMapPoiClick(MapPoi mapPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mapPoi)) == null) {
            l54.c(this.b, mapPoi);
            hx1.i("map", "onMapPoiClick MapPoi " + mapPoi.getPosition());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapRenderCallback
    public void onMapRenderFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l54.e(this.b);
            hx1.i("map", "onMapRenderFinished");
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mapStatus) == null) {
            hx1.i("map", "onMapStatusChange");
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mapStatus) == null) {
            l54.g(this.b, mapStatus, this.a);
            hx1.i("map", "onMapStatusChangeFinish");
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapStatus, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, marker)) == null) {
            p54 H = this.b.H(marker);
            if (H != null) {
                l54.f(marker, this.b);
                H.b(this.b);
                hx1.i("map", "onMarkerClick marker id " + marker.getId());
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMyLocationClickListener
    public boolean onMyLocationClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
