package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public class q {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 3;
    public static q b = null;
    public static final String g = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean c;
    public dp d;
    public Context e;
    public t f;

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.e = context;
        this.d = dp.a(context);
        this.f = t.a(context);
    }

    public static synchronized q a(Context context) {
        InterceptResult invokeL;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (q.class) {
                try {
                    if (b == null) {
                        b = new q(context);
                    }
                    qVar = b;
                } catch (Exception unused) {
                    return null;
                }
            }
            return qVar;
        }
        return (q) invokeL.objValue;
    }

    public void b(String str) {
        r a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (a2 = r.a()) == null) {
                    return;
                }
                a2.b(str);
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    if (this.f.c(i) != 1) {
                        return false;
                    }
                }
                s a2 = this.f.a(i);
                if (a2 == null) {
                    this.f.b(i, -1);
                    return false;
                } else if (!dn.a(new File(a2.e))) {
                    this.f.b(i, -1);
                    return false;
                } else {
                    if (packageInfo != null) {
                        a2.r = packageInfo;
                    }
                    r a3 = r.a(this.e.getApplicationContext(), true);
                    if (!a3.a(a2, false)) {
                        this.f.b(i, -1);
                        a3.a(a2.e);
                        return false;
                    }
                    s c = a3.c(a2.e);
                    c.b = 1;
                    c.p = 1;
                    this.f.a(c);
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            try {
                dp a2 = dp.a();
                if (a2 != null) {
                    a2.b("W_S_V", "1");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            if (WeaponHI.isLoad) {
                b();
            } else {
                WeaponHI.iD();
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                n.a().a(new Runnable(this, str) { // from class: com.kuaishou.weapon.p0.q.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ q b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        r a2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (TextUtils.isEmpty(this.a) || (a2 = r.a(this.b.e.getApplicationContext(), true)) == null) {
                                    return;
                                }
                                s d = a2.d(this.a);
                                if (d == null) {
                                    s b2 = this.b.f.b(this.a);
                                    if (b2 != null) {
                                        this.b.a(this.a, b2.e);
                                        return;
                                    }
                                    return;
                                }
                                new Timer().schedule(new TimerTask(this, a2, d) { // from class: com.kuaishou.weapon.p0.q.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ r a;
                                    public final /* synthetic */ s b;
                                    public final /* synthetic */ AnonymousClass1 c;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, a2, d};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.c = this;
                                        this.a = a2;
                                        this.b = d;
                                    }

                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.a.b(this.c.a);
                                            this.c.b.f.a(this.c.a);
                                            File file = new File(this.b.e);
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                        }
                                    }
                                }, 600000L);
                                a2.b(this.a);
                                this.b.f.a(this.a);
                                File file = new File(d.e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f.a(str);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, str, packageInfo)) == null) {
            synchronized (this) {
                a2 = a(i, str, null, false, packageInfo);
            }
            return a2;
        }
        return invokeILL.booleanValue;
    }

    public boolean a(s sVar, String str, String str2) {
        InterceptResult invokeLLL;
        r a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, sVar, str, str2)) == null) {
            if (sVar == null) {
                return false;
            }
            File file = new File(sVar.e);
            if (!dn.a(file)) {
                return false;
            }
            try {
                if (!this.f.b(sVar.a)) {
                    this.f.a(sVar);
                }
                a2 = r.a(this.e.getApplicationContext(), true);
                this.f.a(sVar.a, 1);
                b(sVar.c);
            } catch (Throwable unused) {
            }
            if (!a2.a(sVar, true)) {
                file.delete();
                a(sVar.a, sVar.d, null, true, null);
                this.f.a(sVar.a, 0);
                return false;
            }
            sVar = a2.c(sVar.e);
            if (sVar == null) {
                this.f.a(sVar.a, 0);
                return false;
            }
            try {
                s a3 = this.f.a(sVar.a);
                File file2 = null;
                if (a3 != null && !a3.d.equals(sVar.d)) {
                    file2 = new File(a3.e);
                }
                sVar.b = 1;
                sVar.p = 1;
                if (this.f.a(sVar) > 0 && file2 != null && file2.exists()) {
                    file2.delete();
                }
                this.f.a(sVar.a, 0);
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                try {
                    if (this.c) {
                        return;
                    }
                    this.c = true;
                    for (s sVar : this.f.a()) {
                        String str = null;
                        try {
                            str = this.e.getFilesDir().getCanonicalPath();
                        } catch (Throwable unused) {
                        }
                        if (str != null) {
                            sVar.m = str + bi.j + sVar.a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(sVar.m);
                            sb.append("/lib");
                            dn.c(sb.toString());
                            dn.c(sVar.m);
                        }
                    }
                    this.f.b();
                    if (!this.d.b(dp.d)) {
                        this.d.a(dp.d, Boolean.TRUE, true);
                    } else {
                        this.f.c();
                    }
                    n.a().a(new u(this.e, 1, false));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (s sVar2 : this.f.a()) {
                r a2 = r.a();
                if (a2 != null) {
                    sVar = a2.d(sVar2.c);
                } else {
                    sVar = null;
                }
                if (sVar == null) {
                    a(sVar2.a, sVar2.d, (PackageInfo) null);
                }
            }
        }
    }
}
