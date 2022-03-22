package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.s;
/* loaded from: classes7.dex */
public class b implements s.a, s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f41596b;

    /* renamed from: c  reason: collision with root package name */
    public long f41597c;

    /* renamed from: d  reason: collision with root package name */
    public long f41598d;

    /* renamed from: e  reason: collision with root package name */
    public int f41599e;

    /* renamed from: f  reason: collision with root package name */
    public int f41600f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41600f = 1000;
    }

    @Override // com.kwai.filedownloader.s.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41599e = 0;
            this.a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f41598d = SystemClock.uptimeMillis();
            this.f41597c = j;
        }
    }

    @Override // com.kwai.filedownloader.s.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41599e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.s.b
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f41598d <= 0) {
            return;
        }
        long j2 = j - this.f41597c;
        this.a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f41598d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f41599e = (int) j2;
    }

    @Override // com.kwai.filedownloader.s.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f41600f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f41600f || (this.f41599e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.f41596b) / uptimeMillis);
                this.f41599e = i;
                this.f41599e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f41596b = j;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
