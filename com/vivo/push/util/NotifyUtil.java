package com.vivo.push.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NotifyUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static BaseNotifyDataAdapter sNotifyData = null;
    public static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    public static BaseNotifyLayoutAdapter sNotifyLayout = null;
    public static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1845177807, "Lcom/vivo/push/util/NotifyUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1845177807, "Lcom/vivo/push/util/NotifyUtil;");
        }
    }

    public NotifyUtil() {
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

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            initAdapter(context);
            return sNotifyData;
        }
        return (BaseNotifyDataAdapter) invokeL.objValue;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            initAdapter(context);
            return sNotifyLayout;
        }
        return (BaseNotifyLayoutAdapter) invokeL.objValue;
    }

    public static Object getObjectByReflect(String str, Object obj) {
        InterceptResult invokeLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj)) == null) {
            Object obj2 = null;
            try {
                cls = Class.forName(str);
            } catch (Exception unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    obj2 = cls.newInstance();
                } catch (Exception unused2) {
                }
            }
            return obj2 == null ? obj : obj2;
        }
        return invokeLL.objValue;
    }

    public static synchronized void initAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            synchronized (NotifyUtil.class) {
                if (sNotifyData == null) {
                    BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new i());
                    sNotifyData = baseNotifyDataAdapter;
                    baseNotifyDataAdapter.init(context);
                }
                if (sNotifyLayout == null) {
                    BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new j());
                    sNotifyLayout = baseNotifyLayoutAdapter;
                    baseNotifyLayoutAdapter.init(context);
                }
            }
        }
    }
}
