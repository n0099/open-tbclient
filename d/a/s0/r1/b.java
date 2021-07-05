package d.a.s0.r1;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.i.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class b implements d.a.c.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static b n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f65032a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65033b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f65034c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f65035d;

    /* renamed from: e  reason: collision with root package name */
    public Address f65036e;

    /* renamed from: f  reason: collision with root package name */
    public long f65037f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f65038g;

    /* renamed from: h  reason: collision with root package name */
    public int f65039h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65040i;
    public Runnable j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes9.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65041a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65041a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f65041a.f65038g.hasMessages(0)) {
                    this.f65041a.f65038g.removeMessages(0);
                }
                this.f65041a.f65038g.removeCallbacks(this.f65041a.k);
                this.f65041a.f65038g.removeCallbacks(this.f65041a.j);
                if (this.f65041a.f65032a != null) {
                    return;
                }
                this.f65041a.f65032a = new f(this.f65041a, null);
                this.f65041a.f65032a.setSelfExecute(true);
                this.f65041a.f65032a.execute(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    /* renamed from: d.a.s0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1655b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65042a;

        public C1655b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65042a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f65042a.f65038g.hasMessages(0)) {
                    this.f65042a.f65038g.removeMessages(0);
                }
                this.f65042a.f65038g.removeCallbacks(this.f65042a.k);
                this.f65042a.f65038g.removeCallbacks(this.f65042a.j);
                if (this.f65042a.f65032a != null) {
                    return;
                }
                this.f65042a.f65032a = new f(this.f65042a, null);
                this.f65042a.f65032a.setSelfExecute(true);
                this.f65042a.f65032a.execute(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65043e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65043e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f65043e.f65035d != null && PermissionUtil.checkLocationForGoogle(this.f65043e.f65033b)) {
                try {
                    this.f65043e.f65035d.requestLocationUpdates("network", 10000L, 100.0f, this.f65043e.l);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65044e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65044e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f65044e.f65035d != null && PermissionUtil.checkLocationForGoogle(this.f65044e.f65033b)) {
                try {
                    this.f65044e.f65035d.requestLocationUpdates("gps", 10000L, 100.0f, this.f65044e.m);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65045e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65045e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f65045e.c();
                this.f65045e.f65034c.a(this.f65045e.f65039h, "", null, this.f65045e.f65037f, this.f65045e.f65040i);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends BdAsyncTask<Location, Void, Address> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65046a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65046a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f65046a.f65033b, Locale.getDefault());
                if (locationArr != null && locationArr.length >= 1) {
                    Location location = locationArr[0];
                    try {
                        list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    } catch (IOException | IllegalArgumentException unused) {
                        list = null;
                    }
                    if (list != null && list.size() > 0) {
                        Address address = list.get(0);
                        StringBuffer stringBuffer = new StringBuffer();
                        if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                            stringBuffer.append(address.getLocality());
                        }
                        stringBuffer.append(address.getSubLocality());
                        stringBuffer.append(address.getThoroughfare());
                        address.setAddressLine(0, stringBuffer.toString());
                        return address;
                    }
                }
                return null;
            }
            return (Address) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, address) == null) {
                super.onPostExecute(address);
                this.f65046a.f65032a = null;
                if (address != null) {
                    this.f65046a.c();
                    this.f65046a.f65037f = System.currentTimeMillis();
                    this.f65046a.f65036e = address;
                    this.f65046a.f65034c.a(0, "", this.f65046a.f65036e, this.f65046a.f65037f, this.f65046a.f65040i);
                    d.a.s0.w2.g0.a.e().i(String.valueOf(address.getLatitude()));
                    d.a.s0.w2.g0.a.e().j(String.valueOf(address.getLongitude()));
                    d.a.s0.w2.g0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f65046a.f65032a = null;
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

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
        this.f65032a = null;
        this.f65034c = null;
        this.f65036e = null;
        this.f65037f = 0L;
        this.f65038g = null;
        this.f65040i = false;
        this.j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1655b(this);
    }

    public static b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (n == null) {
                synchronized (b.class) {
                    if (n == null) {
                        n = new b();
                    }
                }
            }
            return n;
        }
        return (b) invokeV.objValue;
    }

    @Override // d.a.c.e.i.b
    public void a(boolean z) {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f65034c == null || (locationManager = this.f65035d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f65039h = 4;
                this.f65040i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f65039h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f65033b) && (this.f65035d.isProviderEnabled("gps") || this.f65035d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f65033b) && this.f65035d.isProviderEnabled("gps")) {
                    this.f65038g.post(this.k);
                } else {
                    this.f65039h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f65033b) && this.f65035d.isProviderEnabled("network")) {
                        this.f65038g.post(this.j);
                    } else {
                        this.f65039h = 2;
                    }
                }
                return;
            }
            this.f65039h = 3;
            this.f65038g.sendMessageDelayed(this.f65038g.obtainMessage(0), d.a.c.e.i.a.l().m());
        } finally {
            Handler handler = this.f65038g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.a.c.e.i.a.l().m());
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f65033b = context;
            this.f65034c = dVar;
            try {
                this.f65035d = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.j = new c(this);
            this.k = new d(this);
            u();
        }
    }

    @Override // d.a.c.e.i.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f65038g.hasMessages(0)) {
                this.f65038g.removeMessages(0);
            }
            this.f65038g.removeCallbacks(this.k);
            this.f65038g.removeCallbacks(this.j);
            LocationManager locationManager = this.f65035d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f65035d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f65032a;
            if (fVar != null) {
                fVar.cancel();
                this.f65032a = null;
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f65038g.hasMessages(0)) {
                this.f65038g.removeMessages(0);
            }
            this.f65038g.removeCallbacks(this.k);
            this.f65038g.removeCallbacks(this.j);
            LocationManager locationManager = this.f65035d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f65035d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f65032a;
            if (fVar != null) {
                fVar.cancel();
                this.f65032a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f65038g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
