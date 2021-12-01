package com.ss.android.downloadlib.addownload.b;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f61200b;

    /* renamed from: c  reason: collision with root package name */
    public String f61201c;

    /* renamed from: d  reason: collision with root package name */
    public String f61202d;

    /* renamed from: e  reason: collision with root package name */
    public String f61203e;

    /* renamed from: f  reason: collision with root package name */
    public String f61204f;

    /* renamed from: g  reason: collision with root package name */
    public String f61205g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Pair<String, String>> f61206h;

    /* renamed from: i  reason: collision with root package name */
    public String f61207i;

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
        this.f61206h = new ArrayList();
    }

    public static long a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 0 ? j2 : j3 : invokeCommon.longValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a(this.a, this.f61200b) : invokeV.longValue;
    }
}
