package com.repackage;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kf;
import java.util.Locale;
/* loaded from: classes7.dex */
public class og7 implements lf {
    public static /* synthetic */ Interceptable $ic;
    public static og7 k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public String c;
    public kf.d d;
    public b e;
    public LocationClient f;
    public LocationClientOption g;
    public Address h;
    public long i;
    public boolean j;

    /* loaded from: classes7.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        kf.n().r(og7.j());
                    } else {
                        kf.n().v(og7.j());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og7 a;

        public b(og7 og7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og7Var;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.a.c();
                this.a.h = new Address(Locale.getDefault());
                this.a.h.setLatitude(bDLocation.getLatitude());
                this.a.h.setLongitude(bDLocation.getLongitude());
                ru4 k = ru4.k();
                k.y("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.a.h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.a.h.setExtras(bundle);
                this.a.i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.a.h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.a.d != null) {
                    this.a.d.a(0, "", this.a.h, this.a.i, this.a.j);
                    hd8.e().i(String.valueOf(this.a.h.getLatitude()));
                    hd8.e().j(String.valueOf(this.a.h.getLongitude()));
                    hd8.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(og7 og7Var, a aVar) {
            this(og7Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755440590, "Lcom/repackage/og7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755440590, "Lcom/repackage/og7;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001330));
    }

    public og7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = "";
        this.d = null;
        this.i = 0L;
        this.j = false;
    }

    public static og7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (og7.class) {
                    if (k == null) {
                        k = new og7();
                    }
                }
            }
            return k;
        }
        return (og7) invokeV.objValue;
    }

    @Override // com.repackage.lf
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.b && this.f != null) {
                try {
                    this.j = z;
                    if (z) {
                        this.g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f.setLocOption(this.g);
                    if (!this.f.isStarted()) {
                        this.f.start();
                    }
                    this.f.requestLocation();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    c();
                    kf.d dVar = this.d;
                    if (dVar != null) {
                        dVar.a(5, "", this.h, this.i, this.j);
                    }
                }
            }
        }
    }

    @Override // com.repackage.lf
    public void b(kf.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.a = context;
            this.d = dVar;
            this.c = "baidu";
            if (this.b) {
                try {
                    this.f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.g.setIgnoreKillProcess(true);
                    this.g.setProdName(this.c);
                    this.g.setAddrType("all");
                    this.g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.e = bVar;
                    this.f.registerLocationListener(bVar);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    @Override // com.repackage.lf
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f) != null && locationClient.isStarted()) {
            try {
                this.f.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.repackage.lf
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }
}
