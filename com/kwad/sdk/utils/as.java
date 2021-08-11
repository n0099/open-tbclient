package com.kwad.sdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class as {
    public static /* synthetic */ Interceptable $ic;
    public static volatile as l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f73529a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f73530b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f73531c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f73532d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f73533e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f73534f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f73535g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f73536h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f73537i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f73538j;
    public volatile boolean k;

    public as() {
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
        this.f73529a = false;
        this.f73530b = false;
        this.f73531c = false;
        this.f73532d = false;
        this.f73533e = false;
        this.f73534f = false;
        this.f73535g = 0L;
        this.f73536h = 0L;
        this.f73537i = 0L;
        this.f73538j = -1L;
        this.k = false;
    }

    public static as a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (l == null) {
                synchronized (as.class) {
                    if (l == null) {
                        l = new as();
                    }
                }
            }
            return l;
        }
        return (as) invokeV.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f73538j = j2;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73534f : invokeV.booleanValue;
    }
}
