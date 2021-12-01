package com.vivo.identifier;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class IdentifierManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IdentifierManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getAAID();
        }
        return (String) invokeL.objValue;
    }

    public static String getAAID(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getAAID(str);
        }
        return (String) invokeLL.objValue;
    }

    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getOAID();
        }
        return (String) invokeL.objValue;
    }

    public static String getOAIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getOAIDSTATUS();
        }
        return (String) invokeL.objValue;
    }

    public static String getVAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getVAID();
        }
        return (String) invokeL.objValue;
    }

    public static String getVAID(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            IdentifierIdClient identifierIdClient = IdentifierIdClient.getInstance(context);
            if (identifierIdClient == null) {
                return null;
            }
            return identifierIdClient.getVAID(str);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (IdentifierIdClient.getInstance(context) == null) {
                return false;
            }
            return IdentifierIdClient.isSupported();
        }
        return invokeL.booleanValue;
    }

    public static boolean setDebuggable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) ? IdentifierIdLog.setDebug(z) : invokeZ.booleanValue;
    }
}
