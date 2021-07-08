package d.a.p0.r1;

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
/* loaded from: classes8.dex */
public class b implements d.a.c.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static b n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f61810a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61811b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f61812c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f61813d;

    /* renamed from: e  reason: collision with root package name */
    public Address f61814e;

    /* renamed from: f  reason: collision with root package name */
    public long f61815f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f61816g;

    /* renamed from: h  reason: collision with root package name */
    public int f61817h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61818i;
    public Runnable j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes8.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61819a;

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
            this.f61819a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f61819a.f61816g.hasMessages(0)) {
                    this.f61819a.f61816g.removeMessages(0);
                }
                this.f61819a.f61816g.removeCallbacks(this.f61819a.k);
                this.f61819a.f61816g.removeCallbacks(this.f61819a.j);
                if (this.f61819a.f61810a != null) {
                    return;
                }
                this.f61819a.f61810a = new f(this.f61819a, null);
                this.f61819a.f61810a.setSelfExecute(true);
                this.f61819a.f61810a.execute(location);
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

    /* renamed from: d.a.p0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1613b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61820a;

        public C1613b(b bVar) {
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
            this.f61820a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f61820a.f61816g.hasMessages(0)) {
                    this.f61820a.f61816g.removeMessages(0);
                }
                this.f61820a.f61816g.removeCallbacks(this.f61820a.k);
                this.f61820a.f61816g.removeCallbacks(this.f61820a.j);
                if (this.f61820a.f61810a != null) {
                    return;
                }
                this.f61820a.f61810a = new f(this.f61820a, null);
                this.f61820a.f61810a.setSelfExecute(true);
                this.f61820a.f61810a.execute(location);
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

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61821e;

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
            this.f61821e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61821e.f61813d != null && PermissionUtil.checkLocationForGoogle(this.f61821e.f61811b)) {
                try {
                    this.f61821e.f61813d.requestLocationUpdates("network", 10000L, 100.0f, this.f61821e.l);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61822e;

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
            this.f61822e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61822e.f61813d != null && PermissionUtil.checkLocationForGoogle(this.f61822e.f61811b)) {
                try {
                    this.f61822e.f61813d.requestLocationUpdates("gps", 10000L, 100.0f, this.f61822e.m);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61823e;

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
            this.f61823e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f61823e.c();
                this.f61823e.f61812c.a(this.f61823e.f61817h, "", null, this.f61823e.f61815f, this.f61823e.f61818i);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<Location, Void, Address> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61824a;

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
            this.f61824a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f61824a.f61811b, Locale.getDefault());
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
                this.f61824a.f61810a = null;
                if (address != null) {
                    this.f61824a.c();
                    this.f61824a.f61815f = System.currentTimeMillis();
                    this.f61824a.f61814e = address;
                    this.f61824a.f61812c.a(0, "", this.f61824a.f61814e, this.f61824a.f61815f, this.f61824a.f61818i);
                    d.a.p0.w2.g0.a.e().i(String.valueOf(address.getLatitude()));
                    d.a.p0.w2.g0.a.e().j(String.valueOf(address.getLongitude()));
                    d.a.p0.w2.g0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f61824a.f61810a = null;
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
        this.f61810a = null;
        this.f61812c = null;
        this.f61814e = null;
        this.f61815f = 0L;
        this.f61816g = null;
        this.f61818i = false;
        this.j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1613b(this);
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
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f61812c == null || (locationManager = this.f61813d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f61817h = 4;
                this.f61818i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f61817h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f61811b) && (this.f61813d.isProviderEnabled("gps") || this.f61813d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f61811b) && this.f61813d.isProviderEnabled("gps")) {
                    this.f61816g.post(this.k);
                } else {
                    this.f61817h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f61811b) && this.f61813d.isProviderEnabled("network")) {
                        this.f61816g.post(this.j);
                    } else {
                        this.f61817h = 2;
                    }
                }
                return;
            }
            this.f61817h = 3;
            this.f61816g.sendMessageDelayed(this.f61816g.obtainMessage(0), d.a.c.e.i.a.l().m());
        } finally {
            Handler handler = this.f61816g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.a.c.e.i.a.l().m());
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f61811b = context;
            this.f61812c = dVar;
            try {
                this.f61813d = (LocationManager) context.getSystemService("location");
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
            if (this.f61816g.hasMessages(0)) {
                this.f61816g.removeMessages(0);
            }
            this.f61816g.removeCallbacks(this.k);
            this.f61816g.removeCallbacks(this.j);
            LocationManager locationManager = this.f61813d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f61813d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f61810a;
            if (fVar != null) {
                fVar.cancel();
                this.f61810a = null;
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f61816g.hasMessages(0)) {
                this.f61816g.removeMessages(0);
            }
            this.f61816g.removeCallbacks(this.k);
            this.f61816g.removeCallbacks(this.j);
            LocationManager locationManager = this.f61813d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f61813d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f61810a;
            if (fVar != null) {
                fVar.cancel();
                this.f61810a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f61816g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
