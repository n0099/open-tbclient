package d.a.n0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c1.d.d;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes7.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50440c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f50441d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f50442e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f50443a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f50444b;

    /* renamed from: d.a.n0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1133a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50445e;

        public RunnableC1133a(a aVar) {
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
            this.f50445e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50445e.f50443a.requestLocation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f50448a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f50449b;

        /* renamed from: c  reason: collision with root package name */
        public String f50450c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f50451d;

        public c(LocationClient locationClient, d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationClient, aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50448a = locationClient;
            this.f50449b = aVar;
            this.f50450c = str;
            this.f50451d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.f50448a.unRegisterLocationListener(this);
                int locType = bDLocation.getLocType();
                if (a.p(locType)) {
                    a.f50442e.e(bDLocation);
                    if (this.f50451d) {
                        return;
                    }
                    this.f50449b.a(a.n(bDLocation, this.f50450c));
                } else if (this.f50451d) {
                } else {
                    this.f50449b.onFailed(locType);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1687103384, "Ld/a/n0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1687103384, "Ld/a/n0/i/a;");
                return;
            }
        }
        f50440c = k.f45831a;
        f50441d = TimeUnit.MINUTES.toMillis(3L);
        f50442e = new b(null);
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
            }
        }
    }

    public static BDLocation l(double d2, double d3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str})) == null) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d3);
            bDLocation.setLatitude(d2);
            if (TextUtils.equals(str, "gcj02")) {
                return bDLocation;
            }
            if (TextUtils.equals(str, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                return LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
            }
            if (TextUtils.equals(str, "bd09ll")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            }
            return TextUtils.equals(str, CoordinateType.WGS84) ? LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs") : bDLocation;
        }
        return (BDLocation) invokeCommon.objValue;
    }

    public static d.a.n0.a.c2.f.k0.b n(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bDLocation, str)) == null) {
            double longitude = bDLocation.getLongitude();
            double latitude = bDLocation.getLatitude();
            if (!TextUtils.equals(str, bDLocation.getCoorType())) {
                BDLocation l = l(latitude, longitude, str);
                longitude = l.getLongitude();
                latitude = l.getLatitude();
            }
            return new d.a.n0.a.c2.f.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
        }
        return (d.a.n0.a.c2.f.k0.b) invokeLL.objValue;
    }

    public static boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68 : invokeI.booleanValue;
    }

    @Override // d.a.n0.a.c1.d.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.d
    public void b(String str, boolean z, boolean z2, d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            BDLocation c2 = f50442e.c(o());
            boolean z3 = c2 != null;
            if (z3) {
                aVar.a(n(c2, str));
            }
            if (this.f50443a == null) {
                this.f50443a = new LocationClient(AppRuntime.getAppContext());
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setCoorType("gcj02");
                locationClientOption.setScanSpan(0);
                locationClientOption.setIgnoreKillProcess(true);
                locationClientOption.setIsNeedAddress(true);
                this.f50443a.setLocOption(locationClientOption);
                this.f50444b = locationClientOption;
                this.f50443a.start();
            }
            this.f50443a.registerLocationListener(new c(this.f50443a, aVar, str, z3));
            this.f50444b.setIsNeedAltitude(z2);
            this.f50443a.setLocOption(this.f50444b);
            q0.X(new RunnableC1133a(this));
        }
    }

    @Override // d.a.n0.a.c1.d.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.d
    public void e(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.d
    public double[] f(@NonNull d.a.n0.a.c2.f.k0.b bVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, str)) == null) ? m(bVar.f43760b, bVar.f43761c, bVar.f43759a, str) : (double[]) invokeLL.objValue;
    }

    @Override // d.a.n0.a.c1.d.d
    public d.a.n0.a.c2.f.k0.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BDLocation bDLocation = f50442e.f50447b;
            if (bDLocation == null) {
                return null;
            }
            return n(bDLocation, bDLocation.getCoorType());
        }
        return (d.a.n0.a.c2.f.k0.b) invokeV.objValue;
    }

    public final double[] m(double d2, double d3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str, str2})) == null) {
            double[] dArr = new double[2];
            if (TextUtils.equals(str2, "gcj02")) {
                return dArr;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d2);
            bDLocation.setLatitude(d3);
            if (TextUtils.equals(str2, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
            } else if (TextUtils.equals(str2, "bd09ll")) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            } else if (TextUtils.equals(str2, CoordinateType.WGS84)) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
            }
            dArr[0] = bDLocation.getLongitude();
            dArr[1] = bDLocation.getLatitude();
            return dArr;
        }
        return (double[]) invokeCommon.objValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f50441d : invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f50446a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f50447b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50446a = 0L;
        }

        public synchronized BDLocation c(long j) {
            InterceptResult invokeJ;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                synchronized (this) {
                    bDLocation = d(j) ? this.f50447b : null;
                }
                return bDLocation;
            }
            return (BDLocation) invokeJ.objValue;
        }

        public synchronized boolean d(long j) {
            InterceptResult invokeJ;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                synchronized (this) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f50446a;
                    boolean z2 = this.f50447b != null;
                    boolean z3 = currentTimeMillis < j;
                    z = z2 && z3;
                    if (a.f50440c) {
                        Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
                    }
                }
                return z;
            }
            return invokeJ.booleanValue;
        }

        public final synchronized void e(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bDLocation) == null) {
                synchronized (this) {
                    this.f50447b = bDLocation;
                    this.f50446a = System.currentTimeMillis();
                }
            }
        }

        public /* synthetic */ b(RunnableC1133a runnableC1133a) {
            this();
        }
    }
}
