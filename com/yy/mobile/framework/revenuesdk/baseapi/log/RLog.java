package com.yy.mobile.framework.revenuesdk.baseapi.log;

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
/* loaded from: classes10.dex */
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
                    it.next().debug(tagWithHeader(obj), str, objArr);
                }
                return;
            }
            try {
                tagWithHeader(obj);
                String.format(str, objArr);
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
                    tagWithHeader(obj);
                    String.format(str, objArr);
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
                    tagWithHeader(obj);
                    String.format(str, objArr);
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
                    tagWithHeader(obj);
                    String.format(str, objArr);
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
                    tagWithHeader(obj);
                    String.format(str, objArr);
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
            tagWithHeader(obj);
        }
    }

    public static void error(Object obj, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, str, th) == null) {
            if (!logDelegates.isEmpty()) {
                Iterator<IRLogDelegate> it = logDelegates.iterator();
                while (it.hasNext()) {
                    it.next().error(tagWithHeader(obj), str, th);
                }
            } else {
                tagWithHeader(obj);
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
                tagWithHeader(obj);
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
                tagWithHeader(obj);
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
                tagWithHeader(obj);
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
            tagWithHeader(obj);
        }
    }
}
