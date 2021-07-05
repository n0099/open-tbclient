package com.kwad.sdk.glide.b;

import androidx.annotation.ColorInt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    public int[] f37604a;

    /* renamed from: b  reason: collision with root package name */
    public int f37605b;

    /* renamed from: c  reason: collision with root package name */
    public int f37606c;

    /* renamed from: d  reason: collision with root package name */
    public b f37607d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f37608e;

    /* renamed from: f  reason: collision with root package name */
    public int f37609f;

    /* renamed from: g  reason: collision with root package name */
    public int f37610g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37611h;

    /* renamed from: i  reason: collision with root package name */
    public int f37612i;
    public int j;
    public int k;
    @ColorInt
    public int l;
    public int m;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37604a = null;
        this.f37605b = 0;
        this.f37606c = 0;
        this.f37608e = new ArrayList();
        this.m = -1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37610g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37609f : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37606c : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37605b : invokeV.intValue;
    }
}
