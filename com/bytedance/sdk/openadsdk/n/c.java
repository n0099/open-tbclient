package com.bytedance.sdk.openadsdk.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f68503a;

    /* renamed from: b  reason: collision with root package name */
    public final long f68504b;

    /* renamed from: c  reason: collision with root package name */
    public final long f68505c;

    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return this.f68503a;
            }
            return Math.min(this.f68503a + (this.f68504b * i2), this.f68505c);
        }
        return invokeI.longValue;
    }
}
