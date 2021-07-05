package com.kwai.video.ksvodplayerkit;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f39905a;

    /* renamed from: b  reason: collision with root package name */
    public long f39906b;

    /* renamed from: c  reason: collision with root package name */
    public long f39907c;

    /* renamed from: d  reason: collision with root package name */
    public long f39908d;

    /* renamed from: e  reason: collision with root package name */
    public String f39909e;

    /* renamed from: f  reason: collision with root package name */
    public String f39910f;

    /* renamed from: g  reason: collision with root package name */
    public String f39911g;

    /* renamed from: h  reason: collision with root package name */
    public String f39912h;

    /* renamed from: i  reason: collision with root package name */
    public String f39913i;
    public int j;
    public long k;
    public long l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public long s;

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
        this.s = i.a().s();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.f39906b;
            if (j > 0) {
                long j2 = this.f39907c;
                if (j2 > 0 && (j >= j2 || j >= this.s)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
