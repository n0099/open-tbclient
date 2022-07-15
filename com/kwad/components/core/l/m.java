package com.kwad.components.core.l;

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
import com.kwad.sdk.core.config.item.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "m";
    public static final String b = "com.kwad.components.core.l.m";
    public static volatile m c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public m.a e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1273811534, "Lcom/kwad/components/core/l/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1273811534, "Lcom/kwad/components/core/l/m;");
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
        this.d = false;
    }

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (m.class) {
                    if (c == null) {
                        c = new m();
                    }
                }
            }
            return c;
        }
        return (m) invokeV.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j) == null) {
            String str = a;
            com.kwad.sdk.core.d.b.a(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (str.startsWith("android") || str.startsWith(ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA) || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(b) || !str.startsWith(MediaConstants.MEDIA_URI_SCHEME)) ? false : true : invokeL.booleanValue;
    }

    public static boolean a(List<String> list, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, cls)) == null) {
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

    private boolean a(List<String> list, List<String> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, list, list2)) == null) {
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

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, list, stackTraceElementArr)) == null) {
            if (list != null && !list.isEmpty()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.b.a(a, "checkBySuper begin:" + elapsedRealtime);
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && a(className) && b(className)) {
                        try {
                            if (a(list, Class.forName(className).getSuperclass())) {
                                a(elapsedRealtime);
                                return true;
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                                a(elapsedRealtime);
                                return true;
                            }
                        } catch (Throwable unused2) {
                            continue;
                        }
                    }
                }
                a(elapsedRealtime);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? !str.startsWith("com.kwad") : invokeL.booleanValue;
    }

    private void c() {
        m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (aVar = this.e) == null) {
            return;
        }
        if (!this.d && aVar.d.size() > 0) {
            for (String str : this.e.d) {
                boolean c2 = c(str);
                this.d = c2;
                if (c2) {
                    break;
                }
            }
        }
        if (this.d) {
            ArrayList arrayList = new ArrayList();
            if (this.e.a.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.e.a.entrySet()) {
                    if (c(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            m.a aVar2 = this.e;
            com.kwad.components.core.i.a.a().a(a(aVar2.b, aVar2.c), arrayList);
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Class.forName(str) != null;
        }
        return invokeL.booleanValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
        if (sharedPreferences != null) {
            com.kwad.sdk.core.config.c.L.a(sharedPreferences);
            this.e = com.kwad.sdk.core.config.c.L.b();
        }
        if (this.e != null) {
            c();
        }
    }

    public final boolean a(KsScene ksScene, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene, str)) == null) {
            if (this.d) {
                m.a aVar = this.e;
                z = a(aVar.b, aVar.c);
            } else {
                z = false;
            }
            com.kwad.components.core.i.a.a().a(ksScene, z, str);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m.a aVar = this.e;
            if (aVar != null) {
                return aVar.e;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
