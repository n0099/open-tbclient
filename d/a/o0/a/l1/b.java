package d.a.o0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.p0.j;
import d.a.o0.a.v2.o0;
/* loaded from: classes7.dex */
public final class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f46493e;

    /* renamed from: f  reason: collision with root package name */
    public String f46494f;

    /* renamed from: g  reason: collision with root package name */
    public String f46495g;

    /* renamed from: h  reason: collision with root package name */
    public String f46496h;

    public b() {
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

    public static String e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f46493e)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f46494f)) {
                return bVar.f46493e;
            }
            return bVar.f46493e + "?" + bVar.f46494f;
        }
        return (String) invokeL.objValue;
    }

    public static String f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f46496h)) {
                return null;
            }
            if (TextUtils.isEmpty(bVar.f46494f)) {
                return bVar.f46496h;
            }
            return bVar.f46496h + "?" + bVar.f46494f;
        }
        return (String) invokeL.objValue;
    }

    public static b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            b bVar = new b();
            bVar.f46493e = o0.f(str);
            bVar.f46494f = o0.o(str);
            bVar.f46495g = str2;
            bVar.f46496h = j.b(bVar.f46493e);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    @Nullable
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e(this) : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46493e : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46494f : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f46496h : (String) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f46494f = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppPageParam{mPage='" + this.f46493e + "', mParams='" + this.f46494f + "', mBaseUrl='" + this.f46495g + "', mRoutePage='" + this.f46496h + "'}";
        }
        return (String) invokeV.objValue;
    }
}
