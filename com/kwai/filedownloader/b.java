package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.s;
/* loaded from: classes3.dex */
public class b implements s.a, s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f60448b;

    /* renamed from: c  reason: collision with root package name */
    public long f60449c;

    /* renamed from: d  reason: collision with root package name */
    public long f60450d;

    /* renamed from: e  reason: collision with root package name */
    public int f60451e;

    /* renamed from: f  reason: collision with root package name */
    public int f60452f;

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
        this.f60452f = 1000;
    }

    @Override // com.kwai.filedownloader.s.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60451e = 0;
            this.a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f60450d = SystemClock.uptimeMillis();
            this.f60449c = j2;
        }
    }

    @Override // com.kwai.filedownloader.s.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60451e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.s.b
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f60450d <= 0) {
            return;
        }
        long j3 = j2 - this.f60449c;
        this.a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f60450d;
        if (uptimeMillis > 0) {
            j3 /= uptimeMillis;
        }
        this.f60451e = (int) j3;
    }

    @Override // com.kwai.filedownloader.s.b
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f60452f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f60452f || (this.f60451e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.f60448b) / uptimeMillis);
                this.f60451e = i2;
                this.f60451e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f60448b = j2;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
