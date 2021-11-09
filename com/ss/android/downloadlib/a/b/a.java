package com.ss.android.downloadlib.a.b;

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
import com.ss.android.downloadlib.addownload.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f68411d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f68412e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f68413f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f68414g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f68415a;

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC1967a> f68416b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f68417c;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68418h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68419i;
    public volatile boolean j;
    public Context k;
    public final List<Pair<b, d>> l;
    public final ServiceConnection m;
    public String n;

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1967a {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-522774308, "Lcom/ss/android/downloadlib/a/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-522774308, "Lcom/ss/android/downloadlib/a/b/a;");
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
        this.f68418h = true;
        this.f68419i = false;
        this.j = false;
        this.l = new ArrayList();
        this.f68416b = new ArrayList();
        this.m = new ServiceConnection(this) { // from class: com.ss.android.downloadlib.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f68420a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f68420a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    synchronized (this.f68420a.f68417c) {
                        this.f68420a.a(false);
                        this.f68420a.f68415a = c.a.a(iBinder);
                        this.f68420a.c();
                        for (InterfaceC1967a interfaceC1967a : this.f68420a.f68416b) {
                            interfaceC1967a.a();
                        }
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    synchronized (this.f68420a.f68417c) {
                        this.f68420a.a(false);
                        this.f68420a.f68415a = null;
                        for (InterfaceC1967a interfaceC1967a : this.f68420a.f68416b) {
                            interfaceC1967a.b();
                        }
                    }
                }
            }
        };
        this.n = "";
        this.f68417c = new Object();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68414g == null) {
                synchronized (a.class) {
                    if (f68414g == null) {
                        f68414g = new a();
                    }
                }
            }
            return f68414g;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f68415a != null) {
                this.k.unbindService(this.m);
                this.f68415a = null;
            }
            this.f68416b.clear();
            this.l.clear();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<b, d> pair : this.l) {
                try {
                    this.f68415a.a((b) pair.first, (d) pair.second);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.l.clear();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            if (TextUtils.isEmpty(f68411d)) {
                JSONObject i2 = j.i();
                String optString = i2.optString("s");
                f68411d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(IAdRequestParam.COST_NAME), optString);
                f68412e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("u"), optString);
                f68413f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
            }
            this.f68419i = z;
            if (context != null) {
                this.k = context.getApplicationContext();
                if (TextUtils.isEmpty(f68413f)) {
                    f68413f = this.k.getPackageName();
                }
                if (this.f68415a != null || d()) {
                    return true;
                }
                return this.k.bindService(a(context), this.m, 33);
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intent intent = new Intent();
            intent.setAction(f68411d);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (f68412e.equals(str)) {
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

    public void a(b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
            synchronized (this.f68417c) {
                bVar.f68425e = f68413f;
                if (TextUtils.isEmpty(bVar.f68426f)) {
                    bVar.f68426f = this.n;
                }
                if (this.f68415a != null) {
                    try {
                        this.f68415a.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (d() || a(this.k, this.f68419i)) {
                    this.l.add(Pair.create(bVar, dVar));
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.j = z;
        }
    }
}
