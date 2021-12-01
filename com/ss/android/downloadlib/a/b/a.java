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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.x;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.addownload.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f61144d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f61145e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f61146f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f61147g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2096a> f61148b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f61149c;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61150h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61151i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f61152j;

    /* renamed from: k  reason: collision with root package name */
    public Context f61153k;
    public final List<Pair<b, d>> l;
    public final ServiceConnection m;
    public String n;

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2096a {
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
        this.f61150h = true;
        this.f61151i = false;
        this.f61152j = false;
        this.l = new ArrayList();
        this.f61148b = new ArrayList();
        this.m = new ServiceConnection(this) { // from class: com.ss.android.downloadlib.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    synchronized (this.a.f61149c) {
                        this.a.a(false);
                        this.a.a = c.a.a(iBinder);
                        this.a.c();
                        for (InterfaceC2096a interfaceC2096a : this.a.f61148b) {
                            interfaceC2096a.a();
                        }
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    synchronized (this.a.f61149c) {
                        this.a.a(false);
                        this.a.a = null;
                        for (InterfaceC2096a interfaceC2096a : this.a.f61148b) {
                            interfaceC2096a.b();
                        }
                    }
                }
            }
        };
        this.n = "";
        this.f61149c = new Object();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61147g == null) {
                synchronized (a.class) {
                    if (f61147g == null) {
                        f61147g = new a();
                    }
                }
            }
            return f61147g;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a != null) {
                this.f61153k.unbindService(this.m);
                this.a = null;
            }
            this.f61148b.clear();
            this.l.clear();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<b, d> pair : this.l) {
                try {
                    this.a.a((b) pair.first, (d) pair.second);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61152j : invokeV.booleanValue;
    }

    public boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            if (TextUtils.isEmpty(f61144d)) {
                JSONObject i2 = j.i();
                String optString = i2.optString("s");
                f61144d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("q"), optString);
                f61145e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(x.o), optString);
                f61146f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
            }
            this.f61151i = z;
            if (context != null) {
                this.f61153k = context.getApplicationContext();
                if (TextUtils.isEmpty(f61146f)) {
                    f61146f = this.f61153k.getPackageName();
                }
                if (this.a != null || d()) {
                    return true;
                }
                return this.f61153k.bindService(a(context), this.m, 33);
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
            intent.setAction(f61144d);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (f61145e.equals(str)) {
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
            synchronized (this.f61149c) {
                bVar.f61157e = f61146f;
                if (TextUtils.isEmpty(bVar.f61158f)) {
                    bVar.f61158f = this.n;
                }
                if (this.a != null) {
                    try {
                        this.a.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (d() || a(this.f61153k, this.f61151i)) {
                    this.l.add(Pair.create(bVar, dVar));
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f61152j = z;
        }
    }
}
