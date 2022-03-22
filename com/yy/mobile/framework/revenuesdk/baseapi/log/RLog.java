package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class RLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HEADER = "MidPay:";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, iRLogDelegate) == null) || logDelegates.contains(iRLogDelegate)) {
            return;
        }
        logDelegates.add(iRLogDelegate);
    }

    public static void debug(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().debug(tagWithHeader(obj), str, objArr);
                }
                return;
            }
            try {
                Log.d(tagWithHeader(obj), String.format(str, objArr));
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
                    it.next().error(tagWithHeader(obj), str, objArr);
                }
            } else {
                try {
                    Log.e(tagWithHeader(obj), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
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
                    it.next().info(tagWithHeader(obj), str, objArr);
                }
            } else {
                try {
                    Log.i(tagWithHeader(obj), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static String tagWithHeader(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) {
            return HEADER + obj;
        }
        return (String) invokeL.objValue;
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().verbose(tagWithHeader(obj), str, objArr);
                }
            } else {
                try {
                    Log.v(tagWithHeader(obj), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused2) {
            }
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, obj, str, objArr) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().warn(tagWithHeader(obj), str, objArr);
                }
            } else {
                try {
                    Log.w(tagWithHeader(obj), String.format(str, objArr));
                } catch (Exception unused) {
                }
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
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
                    it.next().debug(tagWithHeader(obj), str);
                }
                return;
            }
            Log.d(tagWithHeader(obj), str);
        }
    }

    public static void error(Object obj, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, obj, str, th) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().error(tagWithHeader(obj), str, th);
                }
            } else {
                Log.e(tagWithHeader(obj), str, th);
            }
            try {
                String tagWithHeader = tagWithHeader(obj);
                CloudLogUtil.addLogContent(tagWithHeader, str + ":" + th.getLocalizedMessage());
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
                    it.next().info(tagWithHeader(obj), str);
                }
            } else {
                Log.i(tagWithHeader(obj), str);
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), str);
            } catch (Exception unused) {
            }
        }
    }

    public static void verbose(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().verbose(tagWithHeader(obj), str);
                }
            } else {
                Log.v(tagWithHeader(obj), str);
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), str);
            } catch (Exception unused) {
            }
        }
    }

    public static void warn(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, obj, str) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().warn(tagWithHeader(obj), str);
                }
            } else {
                Log.w(tagWithHeader(obj), str);
            }
            try {
                CloudLogUtil.addLogContent(tagWithHeader(obj), str);
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
                    it.next().debug(tagWithHeader(obj), str, th);
                }
                return;
            }
            Log.d(tagWithHeader(obj), str, th);
        }
    }
}
