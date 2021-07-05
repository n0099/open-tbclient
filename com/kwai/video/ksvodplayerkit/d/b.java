package com.kwai.video.ksvodplayerkit.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.HttpDns.d f39924a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f39925b;

    /* renamed from: c  reason: collision with root package name */
    public int f39926c;

    /* renamed from: d  reason: collision with root package name */
    public String f39927d;

    /* renamed from: e  reason: collision with root package name */
    public AbstractHodorPreloadTask f39928e;

    /* renamed from: f  reason: collision with root package name */
    public d f39929f;

    /* renamed from: g  reason: collision with root package name */
    public String f39930g;

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
                return;
            }
        }
        this.f39925b = new AtomicInteger();
    }

    public abstract AbstractHodorPreloadTask a();

    public abstract AbstractHodorPreloadTask b();

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39926c : invokeV.intValue;
    }

    public AtomicInteger d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39925b : (AtomicInteger) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39930g : (String) invokeV.objValue;
    }
}
