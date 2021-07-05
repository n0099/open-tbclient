package d.a.q0.a.k2.g;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class g implements d.a.q0.t.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d.a.q0.t.b f49209a;

    public g(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49209a = d.a.q0.a.k2.h.d.j().k(d.a.q0.a.c1.a.b(), str, z);
    }

    @Override // d.a.q0.t.b
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49209a.a() : (Set) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49209a.apply();
        }
    }

    @Override // d.a.q0.t.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49209a.b() : invokeV.booleanValue;
    }

    @Override // d.a.q0.t.b
    @NonNull
    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49209a.c() : (File) invokeV.objValue;
    }

    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49209a.clear() : (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49209a.commit() : invokeV.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f49209a.contains(str) : invokeL.booleanValue;
    }

    @Override // d.a.q0.t.b
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49209a.d() : invokeV.longValue;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f49209a.edit() : (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // d.a.q0.t.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f49209a.getAll() : (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) ? this.f49209a.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048587, this, str, f2)) == null) ? this.f49209a.getFloat(str, f2) : invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) ? this.f49209a.getInt(str, i2) : invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, str, j)) == null) ? this.f49209a.getLong(str, j) : invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) ? this.f49209a.getString(str, str2) : (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, set)) == null) ? this.f49209a.getStringSet(str, set) : (Set) invokeLL.objValue;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) ? this.f49209a.putBoolean(str, z) : (SharedPreferences.Editor) invokeLZ.objValue;
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048593, this, str, f2)) == null) ? this.f49209a.putFloat(str, f2) : (SharedPreferences.Editor) invokeLF.objValue;
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, str, i2)) == null) ? this.f49209a.putInt(str, i2) : (SharedPreferences.Editor) invokeLI.objValue;
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048595, this, str, j)) == null) ? this.f49209a.putLong(str, j) : (SharedPreferences.Editor) invokeLJ.objValue;
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? this.f49209a.putString(str, str2) : (SharedPreferences.Editor) invokeLL.objValue;
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, set)) == null) ? this.f49209a.putStringSet(str, set) : (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // d.a.q0.t.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onSharedPreferenceChangeListener) == null) {
            this.f49209a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? this.f49209a.remove(str) : (SharedPreferences.Editor) invokeL.objValue;
    }

    @Override // d.a.q0.t.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onSharedPreferenceChangeListener) == null) {
            this.f49209a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this(str, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
