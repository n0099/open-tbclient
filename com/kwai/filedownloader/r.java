package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes5.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final Object c;
    public transient /* synthetic */ FieldHolder $fh;
    public w b;
    public v d;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final r a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185304023, "Lcom/kwai/filedownloader/r$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1185304023, "Lcom/kwai/filedownloader/r$a;");
                    return;
                }
            }
            a = new r();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224696826, "Lcom/kwai/filedownloader/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-224696826, "Lcom/kwai/filedownloader/r;");
                return;
            }
        }
        a = new Object();
        c = new Object();
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            List<a.InterfaceC0555a> c2 = h.a().c(i);
            if (c2.isEmpty()) {
                com.kwai.filedownloader.e.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
                return 0;
            }
            for (a.InterfaceC0555a interfaceC0555a : c2) {
                interfaceC0555a.F().f();
            }
            return c2.size();
        }
        return invokeI.intValue;
    }

    public static com.kwai.filedownloader.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? new c(str) : (com.kwai.filedownloader.a) invokeL.objValue;
    }

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (r) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            com.kwai.filedownloader.e.c.a(context.getApplicationContext());
        }
    }

    public static void a(Context context, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, aVar) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(r.class, "init Downloader with params: %s %s", context, aVar);
            }
            if (context == null) {
                throw new IllegalArgumentException("the provided context must not be null!");
            }
            com.kwai.filedownloader.e.c.a(context.getApplicationContext());
            com.kwai.filedownloader.download.b.a().a(aVar);
        }
    }

    public static void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, eVar) == null) {
            f.a().a("event.service.connect.changed", eVar);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? n.a().c() : invokeV.booleanValue;
    }

    public final boolean a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            a(i);
            if (n.a().c(i)) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                File file = new File(com.kwai.filedownloader.e.f.b(str));
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c()) {
            return;
        }
        n.a().a(com.kwai.filedownloader.e.c.a());
    }

    public final w d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == null) {
                synchronized (a) {
                    if (this.b == null) {
                        this.b = new ab();
                    }
                }
            }
            return this.b;
        }
        return (w) invokeV.objValue;
    }

    public final v e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d == null) {
                synchronized (c) {
                    if (this.d == null) {
                        z zVar = new z();
                        this.d = zVar;
                        a(zVar);
                    }
                }
            }
            return this.d;
        }
        return (v) invokeV.objValue;
    }
}
