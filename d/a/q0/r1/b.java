package d.a.q0.r1;

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
import d.a.d.e.i.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class b implements d.a.d.e.i.b {
    public static /* synthetic */ Interceptable $ic;
    public static b n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f62424a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62425b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f62426c;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f62427d;

    /* renamed from: e  reason: collision with root package name */
    public Address f62428e;

    /* renamed from: f  reason: collision with root package name */
    public long f62429f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f62430g;

    /* renamed from: h  reason: collision with root package name */
    public int f62431h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62432i;
    public Runnable j;
    public Runnable k;
    public final LocationListener l;
    public final LocationListener m;

    /* loaded from: classes8.dex */
    public class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62433a;

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
            this.f62433a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f62433a.f62430g.hasMessages(0)) {
                    this.f62433a.f62430g.removeMessages(0);
                }
                this.f62433a.f62430g.removeCallbacks(this.f62433a.k);
                this.f62433a.f62430g.removeCallbacks(this.f62433a.j);
                if (this.f62433a.f62424a != null) {
                    return;
                }
                this.f62433a.f62424a = new f(this.f62433a, null);
                this.f62433a.f62424a.setSelfExecute(true);
                this.f62433a.f62424a.execute(location);
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

    /* renamed from: d.a.q0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1618b implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62434a;

        public C1618b(b bVar) {
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
            this.f62434a = bVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (this.f62434a.f62430g.hasMessages(0)) {
                    this.f62434a.f62430g.removeMessages(0);
                }
                this.f62434a.f62430g.removeCallbacks(this.f62434a.k);
                this.f62434a.f62430g.removeCallbacks(this.f62434a.j);
                if (this.f62434a.f62424a != null) {
                    return;
                }
                this.f62434a.f62424a = new f(this.f62434a, null);
                this.f62434a.f62424a.setSelfExecute(true);
                this.f62434a.f62424a.execute(location);
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
        public final /* synthetic */ b f62435e;

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
            this.f62435e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62435e.f62427d != null && PermissionUtil.checkLocationForGoogle(this.f62435e.f62425b)) {
                try {
                    this.f62435e.f62427d.requestLocationUpdates("network", 10000L, 100.0f, this.f62435e.l);
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
        public final /* synthetic */ b f62436e;

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
            this.f62436e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62436e.f62427d != null && PermissionUtil.checkLocationForGoogle(this.f62436e.f62425b)) {
                try {
                    this.f62436e.f62427d.requestLocationUpdates("gps", 10000L, 100.0f, this.f62436e.m);
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
        public final /* synthetic */ b f62437e;

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
            this.f62437e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.f62437e.c();
                this.f62437e.f62426c.a(this.f62437e.f62431h, "", null, this.f62437e.f62429f, this.f62437e.f62432i);
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
        public final /* synthetic */ b f62438a;

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
            this.f62438a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            InterceptResult invokeL;
            List<Address> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationArr)) == null) {
                Geocoder geocoder = new Geocoder(this.f62438a.f62425b, Locale.getDefault());
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
                this.f62438a.f62424a = null;
                if (address != null) {
                    this.f62438a.c();
                    this.f62438a.f62429f = System.currentTimeMillis();
                    this.f62438a.f62428e = address;
                    this.f62438a.f62426c.a(0, "", this.f62438a.f62428e, this.f62438a.f62429f, this.f62438a.f62432i);
                    d.a.q0.w2.g0.a.e().i(String.valueOf(address.getLatitude()));
                    d.a.q0.w2.g0.a.e().j(String.valueOf(address.getLongitude()));
                    d.a.q0.w2.g0.a.e().k(System.currentTimeMillis());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreCancel();
                this.f62438a.f62424a = null;
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
        this.f62424a = null;
        this.f62426c = null;
        this.f62428e = null;
        this.f62429f = 0L;
        this.f62430g = null;
        this.f62432i = false;
        this.j = null;
        this.k = null;
        this.l = new a(this);
        this.m = new C1618b(this);
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

    @Override // d.a.d.e.i.b
    public void a(boolean z) {
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f62426c == null || (locationManager = this.f62427d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f62431h = 4;
                this.f62432i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f62431h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f62425b) && (this.f62427d.isProviderEnabled("gps") || this.f62427d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f62425b) && this.f62427d.isProviderEnabled("gps")) {
                    this.f62430g.post(this.k);
                } else {
                    this.f62431h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f62425b) && this.f62427d.isProviderEnabled("network")) {
                        this.f62430g.post(this.j);
                    } else {
                        this.f62431h = 2;
                    }
                }
                return;
            }
            this.f62431h = 3;
            this.f62430g.sendMessageDelayed(this.f62430g.obtainMessage(0), d.a.d.e.i.a.l().m());
        } finally {
            Handler handler = this.f62430g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.a.d.e.i.a.l().m());
        }
    }

    @Override // d.a.d.e.i.b
    public void b(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            this.f62425b = context;
            this.f62426c = dVar;
            try {
                this.f62427d = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.j = new c(this);
            this.k = new d(this);
            u();
        }
    }

    @Override // d.a.d.e.i.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f62430g.hasMessages(0)) {
                this.f62430g.removeMessages(0);
            }
            this.f62430g.removeCallbacks(this.k);
            this.f62430g.removeCallbacks(this.j);
            LocationManager locationManager = this.f62427d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f62427d.removeUpdates(this.m);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            f fVar = this.f62424a;
            if (fVar != null) {
                fVar.cancel();
                this.f62424a = null;
            }
        }
    }

    @Override // d.a.d.e.i.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f62430g.hasMessages(0)) {
                this.f62430g.removeMessages(0);
            }
            this.f62430g.removeCallbacks(this.k);
            this.f62430g.removeCallbacks(this.j);
            LocationManager locationManager = this.f62427d;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this.l);
                    this.f62427d.removeUpdates(this.m);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            f fVar = this.f62424a;
            if (fVar != null) {
                fVar.cancel();
                this.f62424a = null;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f62430g = new Handler(Looper.getMainLooper(), new e(this));
        }
    }
}
