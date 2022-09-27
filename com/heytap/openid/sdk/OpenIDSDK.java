package com.heytap.openid.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.bean.OpenIDInfo;
import java.util.HashMap;
@Keep
/* loaded from: classes7.dex */
public class OpenIDSDK {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenIDSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            m_h.m_a(context.getPackageName() + " 2007");
        }
    }

    @Deprecated
    public static String getAAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            m_h.m_a("2005");
            return m_g.m_a(context, 2, "AUID");
        }
        return (String) invokeL.objValue;
    }

    @Keep
    public static native OpenIDInfo getIds(Context context, int i);

    @Deprecated
    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            m_h.m_a("2003");
            return m_g.m_a(context, 8, "OUID");
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static boolean getOAIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            m_h.m_a("2002");
            HashMap<String, String> m_a = m_d.m_a(context, 32);
            return "TRUE".equalsIgnoreCase(m_a.get("OUID_STATUS") == null ? "FALSE" : m_a.get("OUID_STATUS"));
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static String getUDID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            m_h.m_a("2001");
            return m_g.m_a(context, 16, "GUID");
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getVAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            m_h.m_a("2004");
            return m_g.m_a(context, 4, "DUID");
        }
        return (String) invokeL.objValue;
    }

    @Keep
    public static native void init(Context context);

    @Keep
    public static native boolean isSupported();

    @Keep
    public static native void setLoggable(boolean z);
}
