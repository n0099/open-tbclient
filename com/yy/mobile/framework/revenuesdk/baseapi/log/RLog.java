package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class RLog {
    public static /* synthetic */ Interceptable $ic;
    public static CopyOnWriteArrayList<IRLogDelegate> logDelegates;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1677722320, "Lcom/yy/mobile/framework/revenuesdk/baseapi/log/RLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1677722320, "Lcom/yy/mobile/framework/revenuesdk/baseapi/log/RLog;");
                return;
            }
        }
        logDelegates = new CopyOnWriteArrayList<>();
    }

    public RLog() {
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

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iRLogDelegate) == null) {
            logDelegates.add(iRLogDelegate);
        }
    }

    public static void debug(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().debug(obj, str, objArr);
                }
                return;
            }
            try {
                Log.d(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
    }

    public static void error(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().error(obj, str, objArr);
                }
            } else {
                try {
                    Log.e(obj.toString(), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static void info(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().info(obj, str, objArr);
                }
            } else {
                try {
                    Log.i(obj.toString(), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().verbose(obj, str, objArr);
                }
            } else {
                try {
                    Log.v(obj.toString(), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().warn(obj, str, objArr);
                }
            } else {
                try {
                    Log.w(obj.toString(), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static void debug(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().debug(obj, str);
                }
                return;
            }
            Log.d(obj.toString(), str);
        }
    }

    public static void error(Object obj, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, str, th) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().error(obj, str, th);
                }
            } else {
                Log.e(obj.toString(), str, th);
            }
            try {
                String obj2 = obj.toString();
                CloudLogUtil.addLogContent(obj2, str + ":" + th.getLocalizedMessage());
            } catch (Exception unused) {
            }
        }
    }

    public static void info(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().info(obj, str);
                }
            } else {
                Log.i(obj.toString(), str);
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), str);
            } catch (Exception unused) {
            }
        }
    }

    public static void verbose(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().verbose(obj, str);
                }
            } else {
                Log.v(obj.toString(), str);
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), str);
            } catch (Exception unused) {
            }
        }
    }

    public static void warn(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().warn(obj, str);
                }
            } else {
                Log.w(obj.toString(), str);
            }
            try {
                CloudLogUtil.addLogContent(obj.toString(), str);
            } catch (Exception unused) {
            }
        }
    }

    public static void debug(Object obj, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, th) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().debug(obj, str, th);
                }
                return;
            }
            Log.d(obj.toString(), str, th);
        }
    }
}
