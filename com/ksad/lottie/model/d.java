package com.ksad.lottie.model;

import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f33948a;

    /* renamed from: b  reason: collision with root package name */
    public final char f33949b;

    /* renamed from: c  reason: collision with root package name */
    public final double f33950c;

    /* renamed from: d  reason: collision with root package name */
    public final double f33951d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33952e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33953f;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Character.valueOf(c2), Double.valueOf(d2), Double.valueOf(d3), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33948a = list;
        this.f33949b = c2;
        this.f33950c = d2;
        this.f33951d = d3;
        this.f33952e = str;
        this.f33953f = str2;
    }

    public static int a(char c2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2), str, str2})) == null) ? ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode() : invokeCommon.intValue;
    }

    public List<j> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33948a : (List) invokeV.objValue;
    }

    public double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33951d : invokeV.doubleValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(this.f33949b, this.f33953f, this.f33952e) : invokeV.intValue;
    }
}
