package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.s;
/* loaded from: classes2.dex */
public class q implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long[] f70502a;

    public q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70502a = a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            long[] jArr = this.f70502a;
            if (jArr == null || jArr.length <= 0) {
                return 0L;
            }
            int i4 = i2 - 1;
            if (i4 < 0) {
                i4 = 0;
            }
            long[] jArr2 = this.f70502a;
            if (i4 > jArr2.length - 1) {
                i4 = jArr2.length - 1;
            }
            return this.f70502a[i4];
        }
        return invokeII.longValue;
    }

    private long[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split(",");
                if (split.length == 0) {
                    return null;
                }
                long[] jArr = new long[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    jArr[i2] = Long.parseLong(split[i2]);
                }
                return jArr;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (long[]) invokeL.objValue;
    }
}
