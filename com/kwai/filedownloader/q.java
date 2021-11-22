package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f67966a;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f67967c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public v f67968b;

    /* renamed from: d  reason: collision with root package name */
    public u f67969d;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final q f67970a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185333814, "Lcom/kwai/filedownloader/q$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1185333814, "Lcom/kwai/filedownloader/q$a;");
                    return;
                }
            }
            f67970a = new q();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224696857, "Lcom/kwai/filedownloader/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-224696857, "Lcom/kwai/filedownloader/q;");
                return;
            }
        }
        f67966a = new Object();
        f67967c = new Object();
    }

    public q() {
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

    public static q a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f67970a : (q) invokeV.objValue;
    }

    public static void a(Context context, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, aVar) == null) {
            if (com.kwai.filedownloader.f.d.f67886a) {
                com.kwai.filedownloader.f.d.c(q.class, "init Downloader with params: %s %s", context, aVar);
            }
            if (context == null) {
                throw new IllegalArgumentException("the provided context must not be null!");
            }
            com.kwai.filedownloader.f.c.a(context.getApplicationContext());
            com.kwai.filedownloader.download.b.a().a(aVar);
        }
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<a.b> c2 = h.a().c(i2);
            if (c2 == null || c2.isEmpty()) {
                com.kwai.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i2));
                return 0;
            }
            for (a.b bVar : c2) {
                bVar.F().f();
            }
            return c2.size();
        }
        return invokeI.intValue;
    }

    public com.kwai.filedownloader.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new c(str) : (com.kwai.filedownloader.a) invokeL.objValue;
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            f.a().a("event.service.connect.changed", eVar);
        }
    }

    public boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, str)) == null) {
            a(i2);
            if (m.a().c(i2)) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                File file = new File(com.kwai.filedownloader.f.f.d(str));
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || c()) {
            return;
        }
        m.a().a(com.kwai.filedownloader.f.c.a());
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m.a().c() : invokeV.booleanValue;
    }

    public v d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f67968b == null) {
                synchronized (f67966a) {
                    if (this.f67968b == null) {
                        this.f67968b = new aa();
                    }
                }
            }
            return this.f67968b;
        }
        return (v) invokeV.objValue;
    }

    public u e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f67969d == null) {
                synchronized (f67967c) {
                    if (this.f67969d == null) {
                        y yVar = new y();
                        this.f67969d = yVar;
                        a(yVar);
                    }
                }
            }
            return this.f67969d;
        }
        return (u) invokeV.objValue;
    }
}
