package com.kwad.components.core.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.MediaConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.config.item.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String Je = "com.kwad.components.core.m.m";
    public static volatile m Jf = null;
    public static final String TAG = "m";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean Jg;
    public n.a Jh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1273841325, "Lcom/kwad/components/core/m/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1273841325, "Lcom/kwad/components/core/m/m;");
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Jg = false;
    }

    public static boolean a(List<String> list, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, cls)) == null) {
            int i = 0;
            while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
                for (String str : list) {
                    if (cls.getName().contains(str)) {
                        return true;
                    }
                }
                cls = cls.getSuperclass();
                i++;
                if (i >= 4) {
                    break;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, list, stackTraceElementArr)) == null) {
            if (list != null && !list.isEmpty()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.e.b.d(TAG, "checkBySuper begin:" + elapsedRealtime);
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && ax(className) && ay(className)) {
                        try {
                            if (a(list, Class.forName(className).getSuperclass())) {
                                q(elapsedRealtime);
                                return true;
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                                q(elapsedRealtime);
                                return true;
                            }
                        } catch (Throwable unused2) {
                            continue;
                        }
                    }
                }
                q(elapsedRealtime);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean ax(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (str.startsWith("android") || str.startsWith(ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA) || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(Je) || !str.startsWith(MediaConstants.MEDIA_URI_SCHEME)) ? false : true : invokeL.booleanValue;
    }

    public static boolean ay(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? !str.startsWith("com.kwad") : invokeL.booleanValue;
    }

    public static boolean az(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Class.forName(str) != null;
        }
        return invokeL.booleanValue;
    }

    private boolean c(List<String> list, List<String> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, list, list2)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className != null) {
                    for (String str : list) {
                        if (className.contains(str)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return a(list2, stackTrace);
        }
        return invokeLL.booleanValue;
    }

    public static m oF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Jf == null) {
                synchronized (m.class) {
                    if (Jf == null) {
                        Jf = new m();
                    }
                }
            }
            return Jf;
        }
        return (m) invokeV.objValue;
    }

    private void oH() {
        n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (aVar = this.Jh) == null) {
            return;
        }
        if (!this.Jg && aVar.VL.size() > 0) {
            for (String str : this.Jh.VL) {
                boolean az = az(str);
                this.Jg = az;
                if (az) {
                    break;
                }
            }
        }
        if (this.Jg) {
            ArrayList arrayList = new ArrayList();
            if (this.Jh.VI.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Jh.VI.entrySet()) {
                    if (az(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            n.a aVar2 = this.Jh;
            com.kwad.components.core.j.a.og().a(c(aVar2.VJ, aVar2.VK), arrayList);
        }
    }

    public static void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j) == null) {
            String str = TAG;
            com.kwad.sdk.core.e.b.d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
        }
    }

    public final boolean a(KsScene ksScene, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ksScene, str)) == null) {
            if (this.Jg) {
                n.a aVar = this.Jh;
                z = c(aVar.VJ, aVar.VK);
            } else {
                z = false;
            }
            com.kwad.components.core.j.a.og().a(ksScene, z, str);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
        if (sharedPreferences != null) {
            com.kwad.sdk.core.config.c.Uj.a(sharedPreferences);
            this.Jh = com.kwad.sdk.core.config.c.Uj.getValue();
        }
        if (this.Jh != null) {
            oH();
        }
    }

    public final int oG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n.a aVar = this.Jh;
            if (aVar != null) {
                return aVar.VM;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
