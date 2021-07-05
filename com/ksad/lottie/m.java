package com.ksad.lottie;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f33840a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33841b;

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f33841b && this.f33840a.containsKey(str)) {
                return this.f33840a.get(str);
            }
            String b2 = b(str);
            if (this.f33841b) {
                this.f33840a.put(str, b2);
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }
}
