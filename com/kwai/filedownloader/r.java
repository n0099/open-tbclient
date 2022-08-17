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
    public static final Object atE;
    public static final Object atG;
    public transient /* synthetic */ FieldHolder $fh;
    public w atF;
    public volatile v atH;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final r atI;
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
            atI = new r();
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
        atE = new Object();
        atG = new Object();
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

    public static r CZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.atI : (r) invokeV.objValue;
    }

    public static boolean Db() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? n.CR().isConnected() : invokeV.booleanValue;
    }

    public static void a(Context context, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, aVar) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(r.class, "init Downloader with params: %s %s", context, aVar);
            }
            if (context == null) {
                throw new IllegalArgumentException("the provided context must not be null!");
            }
            com.kwai.filedownloader.e.c.D(context.getApplicationContext());
            com.kwai.filedownloader.download.b.Dp().a(aVar);
        }
    }

    public static void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, eVar) == null) {
            f.CE().a("event.service.connect.changed", eVar);
        }
    }

    private int bZ(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            List<a.InterfaceC0405a> bU = h.CG().bU(i);
            if (bU.isEmpty()) {
                com.kwai.filedownloader.e.d.f(this, "request pause but not exist %d", Integer.valueOf(i));
                return 0;
            }
            for (a.InterfaceC0405a interfaceC0405a : bU) {
                interfaceC0405a.Ci().pause();
            }
            return bU.size();
        }
        return invokeI.intValue;
    }

    public static void dD(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            com.kwai.filedownloader.e.c.D(context.getApplicationContext());
        }
    }

    public static com.kwai.filedownloader.a eq(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? new c(str) : (com.kwai.filedownloader.a) invokeL.objValue;
    }

    public final void Da() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Db()) {
            return;
        }
        n.CR().dC(com.kwai.filedownloader.e.c.EJ());
    }

    public final w Dc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.atF == null) {
                synchronized (atE) {
                    if (this.atF == null) {
                        this.atF = new ab();
                    }
                }
            }
            return this.atF;
        }
        return (w) invokeV.objValue;
    }

    public final v Dd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.atH == null) {
                synchronized (atG) {
                    if (this.atH == null) {
                        this.atH = new z();
                        a((e) this.atH);
                    }
                }
            }
            return this.atH;
        }
        return (v) invokeV.objValue;
    }

    public final boolean k(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            bZ(i);
            if (n.CR().bY(i)) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                File file = new File(com.kwai.filedownloader.e.f.eF(str));
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
}
