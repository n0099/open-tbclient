package com.kwad.sdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ay {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ay l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f59619b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f59620c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f59621d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f59622e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f59623f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f59624g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59625h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f59626i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f59627j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f59628k;

    public ay() {
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
        this.a = false;
        this.f59619b = false;
        this.f59620c = false;
        this.f59621d = false;
        this.f59622e = false;
        this.f59623f = false;
        this.f59624g = 0L;
        this.f59625h = 0L;
        this.f59626i = 0L;
        this.f59627j = -1L;
        this.f59628k = false;
    }

    public static ay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (l == null) {
                synchronized (ay.class) {
                    if (l == null) {
                        l = new ay();
                    }
                }
            }
            return l;
        }
        return (ay) invokeV.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f59627j = j2;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59623f : invokeV.booleanValue;
    }
}
