package com.bytedance.sdk.openadsdk.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f31678a;

    /* renamed from: b  reason: collision with root package name */
    public final long f31679b;

    /* renamed from: c  reason: collision with root package name */
    public final long f31680c;

    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return this.f31678a;
            }
            return Math.min(this.f31678a + (this.f31679b * i2), this.f31680c);
        }
        return invokeI.longValue;
    }
}
