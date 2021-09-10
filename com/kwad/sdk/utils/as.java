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
    public volatile boolean f73909a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f73910b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f73911c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f73912d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f73913e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f73914f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f73915g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f73916h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f73917i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f73918j;
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
        this.f73909a = false;
        this.f73910b = false;
        this.f73911c = false;
        this.f73912d = false;
        this.f73913e = false;
        this.f73914f = false;
        this.f73915g = 0L;
        this.f73916h = 0L;
        this.f73917i = 0L;
        this.f73918j = -1L;
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
            this.f73918j = j2;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73914f : invokeV.booleanValue;
    }
}
