package d.a.s0.r1;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.PathUtils;
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
import d.a.c.e.i.a;
import java.util.Locale;
/* loaded from: classes9.dex */
public class a implements d.a.c.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f65022a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65023b;

    /* renamed from: c  reason: collision with root package name */
    public String f65024c;

    /* renamed from: d  reason: collision with root package name */
    public a.d f65025d;

    /* renamed from: e  reason: collision with root package name */
    public b f65026e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f65027f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f65028g;

    /* renamed from: h  reason: collision with root package name */
    public Address f65029h;

    /* renamed from: i  reason: collision with root package name */
    public long f65030i;
    public boolean j;

    /* renamed from: d.a.s0.r1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1654a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1654a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                        d.a.c.e.i.a.l().p(a.j());
                    } else {
                        d.a.c.e.i.a.l().t(a.j());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65031a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65031a = aVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                    return;
                }
                this.f65031a.c();
                this.f65031a.f65029h = new Address(Locale.getDefault());
                this.f65031a.f65029h.setLatitude(bDLocation.getLatitude());
                this.f65031a.f65029h.setLongitude(bDLocation.getLongitude());
                d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
                j.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                this.f65031a.f65029h.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                this.f65031a.f65029h.setExtras(bundle);
                this.f65031a.f65030i = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    this.f65031a.f65029h.setAddressLine(0, stringBuffer.toString());
                }
                if (this.f65031a.f65025d != null) {
                    this.f65031a.f65025d.a(0, "", this.f65031a.f65029h, this.f65031a.f65030i, this.f65031a.j);
                    d.a.s0.w2.g0.a.e().i(String.valueOf(this.f65031a.f65029h.getLatitude()));
                    d.a.s0.w2.g0.a.e().j(String.valueOf(this.f65031a.f65029h.getLongitude()));
                    d.a.s0.w2.g0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        public /* synthetic */ b(a aVar, C1654a c1654a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-628155811, "Ld/a/s0/r1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-628155811, "Ld/a/s0/r1/a;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new C1654a(2001330));
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65023b = true;
        this.f65024c = "";
        this.f65025d = null;
        this.f65030i = 0L;
        this.j = false;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (a.class) {
                    if (k == null) {
                        k = new a();
                    }
                }
            }
            return k;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.c.e.i.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f65023b && this.f65027f != null) {
                try {
                    this.j = z;
                    if (z) {
                        this.f65028g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f65027f.setLocOption(this.f65028g);
                    if (!this.f65027f.isStarted()) {
                        this.f65027f.start();
                    }
                    this.f65027f.requestLocation();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    c();
                    a.d dVar = this.f65025d;
                    if (dVar != null) {
                        dVar.a(5, "", this.f65029h, this.f65030i, this.j);
                    }
                }
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f65022a = context;
            this.f65025d = dVar;
            this.f65024c = PathUtils.DIRCTORY_BAIDU;
            if (this.f65023b) {
                try {
                    this.f65027f = new LocationClient(context);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.f65028g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.f65028g.setIgnoreKillProcess(true);
                    this.f65028g.setProdName(this.f65024c);
                    this.f65028g.setAddrType("all");
                    this.f65028g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.f65026e = bVar;
                    this.f65027f.registerLocationListener(bVar);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f65027f) != null && locationClient.isStarted()) {
            try {
                this.f65027f.stop();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }
}
