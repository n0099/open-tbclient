package com.repackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class q80 implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    @JvmOverloads
    public q80(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getSharedPreferences(str, 0);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.contains(str);
        }
        return invokeL.booleanValue;
    }

    public final void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.edit().remove(str).apply();
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getAll();
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, set)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            return sharedPreferences.getStringSet(str, set);
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSharedPreferenceChangeListener) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onSharedPreferenceChangeListener) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                Intrinsics.throwNpe();
            }
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
