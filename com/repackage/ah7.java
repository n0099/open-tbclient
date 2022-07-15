package com.repackage;

import android.location.Address;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.location.LocationCallback;
import com.baidu.searchbox.live.interfaces.location.LocationInfo;
import com.baidu.searchbox.live.interfaces.service.LiveLocationService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jf;
/* loaded from: classes5.dex */
public class ah7 implements LiveLocationService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements jf.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationCallback a;
        public final /* synthetic */ ah7 b;

        public a(ah7 ah7Var, LocationCallback locationCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, locationCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah7Var;
            this.a = locationCallback;
        }

        @Override // com.repackage.jf.c
        public void a(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                try {
                    if (this.a == null || address == null) {
                        return;
                    }
                    this.a.onReceiveLocation(this.b.b(address));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ah7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final LocationInfo b(Address address) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, address)) == null) {
            LocationInfo locationInfo = new LocationInfo();
            if (address != null) {
                locationInfo.setCity(address.getLocality());
                locationInfo.setLatitude(address.getLatitude());
                locationInfo.setLongitude(address.getLongitude());
                locationInfo.setProvince(address.getAdminArea());
                locationInfo.setCounty(address.getCountryName());
            }
            return locationInfo;
        }
        return (LocationInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public LocationInfo getLocationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b(jf.n().k(false, null)) : (LocationInfo) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public void requestLocate(LocationCallback locationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locationCallback) == null) {
            jf.n().k(false, new a(this, locationCallback));
        }
    }
}
