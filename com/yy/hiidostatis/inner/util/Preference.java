package com.yy.hiidostatis.inner.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class Preference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences cacheSp;
    public boolean isBindProcess;
    public String name;
    public Object obj;

    public Preference(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isBindProcess = false;
        this.obj = new Object();
        this.cacheSp = null;
        this.name = str;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            SharedPreferences sharedPreferences = this.cacheSp;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            synchronized (this.obj) {
                if (this.cacheSp != null) {
                    return this.cacheSp;
                }
                if (this.isBindProcess) {
                    str = ProcessUtil.getFileNameBindProcess(context, this.name);
                } else {
                    str = this.name;
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
                this.cacheSp = sharedPreferences2;
                return sharedPreferences2;
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public Preference(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isBindProcess = false;
        this.obj = new Object();
        this.cacheSp = null;
        this.name = str;
        this.isBindProcess = z;
    }

    public void clearKey(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.remove(str);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public boolean hasKey(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str)) == null) {
            return getSharedPreferences(context).contains(str);
        }
        return invokeLL.booleanValue;
    }

    public void clearPreference(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.clear();
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public Map getAll(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return getSharedPreferences(context).getAll();
        }
        return (Map) invokeL.objValue;
    }

    public boolean getPrefBoolean(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, str, z)) == null) {
            return getSharedPreferences(context).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public float getPrefFloat(Context context, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, str, Float.valueOf(f)})) == null) {
            return getSharedPreferences(context).getFloat(str, f);
        }
        return invokeCommon.floatValue;
    }

    public int getPrefInt(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, context, str, i)) == null) {
            return getSharedPreferences(context).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public long getPrefLong(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, str, Long.valueOf(j)})) == null) {
            return getSharedPreferences(context).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public String getPrefString(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, str, str2)) == null) {
            return getSharedPreferences(context).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public void setPrefBoolean(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, context, str, z) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (Build.VERSION.SDK_INT >= 9) {
                sharedPreferences.edit().putBoolean(str, z).apply();
            } else {
                sharedPreferences.edit().putBoolean(str, z).commit();
            }
        }
    }

    public void setPrefInt(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, context, str, i) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (Build.VERSION.SDK_INT >= 9) {
                sharedPreferences.edit().putInt(str, i).apply();
            } else {
                sharedPreferences.edit().putInt(str, i).commit();
            }
        }
    }

    public void setPrefString(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (Build.VERSION.SDK_INT >= 9) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
        }
    }

    public void setPrefFloat(Context context, String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, Float.valueOf(f)}) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (Build.VERSION.SDK_INT >= 9) {
                sharedPreferences.edit().putFloat(str, f).apply();
            } else {
                sharedPreferences.edit().putFloat(str, f).commit();
            }
        }
    }

    public void setPrefLong(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, Long.valueOf(j)}) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (Build.VERSION.SDK_INT >= 9) {
                sharedPreferences.edit().putLong(str, j).apply();
            } else {
                sharedPreferences.edit().putLong(str, j).commit();
            }
        }
    }
}
