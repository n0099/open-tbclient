package com.yy.hiidostatis.message.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.NumberUtil;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class KVIO {
    public static /* synthetic */ Interceptable $ic;
    public static KVIO kvio;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences cache;
    public SharedPreferences.Editor editor;

    public KVIO(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(ProcessUtil.getFileNameBindProcess(context, "hiido_kv.dat"), 0);
        this.cache = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static KVIO get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? kvio : (KVIO) invokeV.objValue;
    }

    public static synchronized void initialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (KVIO.class) {
                if (kvio != null) {
                    return;
                }
                kvio = new KVIO(context);
            }
        }
    }

    public boolean commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.editor.commit() : invokeV.booleanValue;
    }

    public boolean decodeBool(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? decodeBool(str, false) : invokeL.booleanValue;
    }

    public byte[] decodeBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? decodeBytes(str, null) : (byte[]) invokeL.objValue;
    }

    public double decodeDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? decodeDouble(str, 0.0d) : invokeL.doubleValue;
    }

    public float decodeFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? decodeFloat(str, 0.0f) : invokeL.floatValue;
    }

    public int decodeInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? decodeInt(str, 0) : invokeL.intValue;
    }

    public long decodeLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? decodeLong(str, 0L) : invokeL.longValue;
    }

    public String decodeString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? decodeString(str, null) : (String) invokeL.objValue;
    }

    public Set<String> decodeStringSet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? decodeStringSet(str, null) : (Set) invokeL.objValue;
    }

    public boolean encode(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, str, z)) == null) {
            this.editor.putBoolean(str, z).apply();
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public boolean decodeBool(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) ? this.cache.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public byte[] decodeBytes(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bArr)) == null) {
            String string = this.cache.getString(str, null);
            if (string == null) {
                return bArr;
            }
            try {
                return NumberUtil.toBytes(string);
            } catch (Throwable unused) {
                return bArr;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public double decodeDouble(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Double.valueOf(d2)})) == null) ? this.cache.getLong(str, (long) d2) : invokeCommon.doubleValue;
    }

    public float decodeFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f2)) == null) ? this.cache.getFloat(str, f2) : invokeLF.floatValue;
    }

    public int decodeInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) ? this.cache.getInt(str, i2) : invokeLI.intValue;
    }

    public long decodeLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048588, this, str, j2)) == null) ? this.cache.getLong(str, j2) : invokeLJ.longValue;
    }

    public String decodeString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) ? this.cache.getString(str, str2) : (String) invokeLL.objValue;
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, set)) == null) ? decodeStringSet(str, set, HashSet.class) : (Set) invokeLL.objValue;
    }

    public boolean encode(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, str, i2)) == null) {
            this.editor.putInt(str, i2).apply();
            return true;
        }
        return invokeLI.booleanValue;
    }

    private Set<String> decodeStringSet(String str, Set<String> set, Class<? extends Set> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, set, cls)) == null) ? this.cache.getStringSet(str, set) : (Set) invokeLLL.objValue;
    }

    public boolean encode(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048596, this, str, j2)) == null) {
            this.editor.putLong(str, j2).apply();
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public boolean encode(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048594, this, str, f2)) == null) {
            this.editor.putFloat(str, f2).apply();
            return true;
        }
        return invokeLF.booleanValue;
    }

    public boolean encode(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            this.editor.putLong(str, (long) d2).apply();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean encode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            this.editor.putString(str, str2).apply();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean encode(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, set)) == null) {
            this.editor.putStringSet(str, set);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean encode(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, bArr)) == null) {
            this.editor.putString(str, NumberUtil.toHex(bArr)).apply();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
