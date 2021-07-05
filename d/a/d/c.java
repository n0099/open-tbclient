package d.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f45171a;

    /* renamed from: b  reason: collision with root package name */
    public final int f45172b;

    /* renamed from: c  reason: collision with root package name */
    public int f45173c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f45174d;

    public c(int i2, int i3, int i4, String str, String str2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45171a = i2;
        this.f45172b = i3;
        this.f45173c = i5;
    }

    public static h f(int i2, int i3, int i4, String str, String str2, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Integer.valueOf(i5)})) == null) ? new c(i2, i3, i4, str, str2, i5) : (h) invokeCommon.objValue;
    }

    @Override // d.a.d.h
    public void a(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            this.f45174d = hashMap;
            if (hashMap.containsKey("iadex")) {
                return;
            }
            hashMap.put("iadex", d.a.r0.z0.d.e());
        }
    }

    @Override // d.a.d.h
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45173c : invokeV.intValue;
    }

    @Override // d.a.d.h
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45171a : invokeV.intValue;
    }

    @Override // d.a.d.h
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45174d : (Map) invokeV.objValue;
    }

    @Override // d.a.d.h
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45172b : invokeV.intValue;
    }
}
