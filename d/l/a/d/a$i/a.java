package d.l.a.d.a$i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.b.d;
import d.l.a.d.b.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f74138a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f74139b;

    /* renamed from: c  reason: collision with root package name */
    public Context f74140c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.b.b, d>> f74141d;

    /* renamed from: e  reason: collision with root package name */
    public c f74142e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f74143f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f74144g;

    /* renamed from: h  reason: collision with root package name */
    public String f74145h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f74146i;

    /* renamed from: d.l.a.d.a$i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC2046a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f74147e;

        public ServiceConnectionC2046a(a aVar) {
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
            this.f74147e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.f74147e.f74146i) {
                    this.f74147e.d(false);
                    this.f74147e.f74142e = c.a.a(iBinder);
                    this.f74147e.g();
                    for (b bVar : this.f74147e.f74143f) {
                        bVar.a();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                synchronized (this.f74147e.f74146i) {
                    this.f74147e.d(false);
                    this.f74147e.f74142e = null;
                    for (b bVar : this.f74147e.f74143f) {
                        bVar.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(18060374, "Ld/l/a/d/a$i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(18060374, "Ld/l/a/d/a$i/a;");
        }
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
        this.f74138a = false;
        this.f74139b = false;
        this.f74141d = new ArrayList();
        this.f74143f = new ArrayList();
        this.f74144g = new ServiceConnectionC2046a(this);
        this.f74145h = "";
        this.f74146i = new Object();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intent intent = new Intent();
            intent.setAction(j);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (k.equals(str)) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    return intent2;
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public void c(com.ss.android.downloadlib.a.b.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
            synchronized (this.f74146i) {
                bVar.f41294e = l;
                if (TextUtils.isEmpty(bVar.f41295f)) {
                    bVar.f41295f = this.f74145h;
                }
                if (this.f74142e != null) {
                    try {
                        this.f74142e.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (h() || e(this.f74140c, this.f74138a)) {
                    this.f74141d.add(Pair.create(bVar, dVar));
                }
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f74139b = z;
        }
    }

    public boolean e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            if (TextUtils.isEmpty(j)) {
                JSONObject v = l.v();
                String optString = v.optString("s");
                j = d.l.a.e.a.h.d.b(v.optString(IAdRequestParam.COST_NAME), optString);
                k = d.l.a.e.a.h.d.b(v.optString("u"), optString);
                l = d.l.a.e.a.h.d.b(v.optString("w"), optString);
            }
            this.f74138a = z;
            if (context != null) {
                this.f74140c = context.getApplicationContext();
                if (TextUtils.isEmpty(l)) {
                    l = this.f74140c.getPackageName();
                }
                if (this.f74142e != null || h()) {
                    return true;
                }
                return this.f74140c.bindService(a(context), this.f74144g, 33);
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f74142e != null) {
                this.f74140c.unbindService(this.f74144g);
                this.f74142e = null;
            }
            this.f74143f.clear();
            this.f74141d.clear();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<com.ss.android.downloadlib.a.b.b, d> pair : this.f74141d) {
                try {
                    this.f74142e.a((com.ss.android.downloadlib.a.b.b) pair.first, (d) pair.second);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f74141d.clear();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74139b : invokeV.booleanValue;
    }
}
