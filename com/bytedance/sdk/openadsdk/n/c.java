package com.bytedance.sdk.openadsdk.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f67812a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67813b;

    /* renamed from: c  reason: collision with root package name */
    public final long f67814c;

    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return this.f67812a;
            }
            return Math.min(this.f67812a + (this.f67813b * i2), this.f67814c);
        }
        return invokeI.longValue;
    }
}
