package com.kwad.sdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class as {
    public static /* synthetic */ Interceptable $ic;
    public static volatile as l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f36518a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36519b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36520c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f36521d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f36522e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f36523f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f36524g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f36525h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f36526i;
    public volatile long j;
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
        this.f36518a = false;
        this.f36519b = false;
        this.f36520c = false;
        this.f36521d = false;
        this.f36522e = false;
        this.f36523f = false;
        this.f36524g = 0L;
        this.f36525h = 0L;
        this.f36526i = 0L;
        this.j = -1L;
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

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.j = j;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36523f : invokeV.booleanValue;
    }
}
