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
    public static String f69331d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f69332e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f69333f = "";

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f69334g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f69335a;

    /* renamed from: b  reason: collision with root package name */
    public final List<InterfaceC2005a> f69336b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f69337c;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69338h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69339i;
    public volatile boolean j;
    public Context k;
    public final List<Pair<b, d>> l;
    public final ServiceConnection m;
    public String n;

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2005a {
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
        this.f69338h = true;
        this.f69339i = false;
        this.j = false;
        this.l = new ArrayList();
        this.f69336b = new ArrayList();
        this.m = new ServiceConnection(this) { // from class: com.ss.android.downloadlib.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f69340a;

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
                this.f69340a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    synchronized (this.f69340a.f69337c) {
                        this.f69340a.a(false);
                        this.f69340a.f69335a = c.a.a(iBinder);
                        this.f69340a.c();
                        for (InterfaceC2005a interfaceC2005a : this.f69340a.f69336b) {
                            interfaceC2005a.a();
                        }
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    synchronized (this.f69340a.f69337c) {
                        this.f69340a.a(false);
                        this.f69340a.f69335a = null;
                        for (InterfaceC2005a interfaceC2005a : this.f69340a.f69336b) {
                            interfaceC2005a.b();
                        }
                    }
                }
            }
        };
        this.n = "";
        this.f69337c = new Object();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f69334g == null) {
                synchronized (a.class) {
                    if (f69334g == null) {
                        f69334g = new a();
                    }
                }
            }
            return f69334g;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f69335a != null) {
                this.k.unbindService(this.m);
                this.f69335a = null;
            }
            this.f69336b.clear();
            this.l.clear();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<b, d> pair : this.l) {
                try {
                    this.f69335a.a((b) pair.first, (d) pair.second);
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
            if (TextUtils.isEmpty(f69331d)) {
                JSONObject i2 = j.i();
                String optString = i2.optString("s");
                f69331d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(IAdRequestParam.COST_NAME), optString);
                f69332e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("u"), optString);
                f69333f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("w"), optString);
            }
            this.f69339i = z;
            if (context != null) {
                this.k = context.getApplicationContext();
                if (TextUtils.isEmpty(f69333f)) {
                    f69333f = this.k.getPackageName();
                }
                if (this.f69335a != null || d()) {
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
            intent.setAction(f69331d);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (f69332e.equals(str)) {
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
            synchronized (this.f69337c) {
                bVar.f69345e = f69333f;
                if (TextUtils.isEmpty(bVar.f69346f)) {
                    bVar.f69346f = this.n;
                }
                if (this.f69335a != null) {
                    try {
                        this.f69335a.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (d() || a(this.k, this.f69339i)) {
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
