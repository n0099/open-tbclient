package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.s;
/* loaded from: classes2.dex */
public class b implements s.a, s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f59867b;

    /* renamed from: c  reason: collision with root package name */
    public long f59868c;

    /* renamed from: d  reason: collision with root package name */
    public long f59869d;

    /* renamed from: e  reason: collision with root package name */
    public int f59870e;

    /* renamed from: f  reason: collision with root package name */
    public int f59871f;

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
        this.f59871f = 1000;
    }

    @Override // com.kwai.filedownloader.s.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59870e = 0;
            this.a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f59869d = SystemClock.uptimeMillis();
            this.f59868c = j2;
        }
    }

    @Override // com.kwai.filedownloader.s.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59870e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.s.b
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f59869d <= 0) {
            return;
        }
        long j3 = j2 - this.f59868c;
        this.a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f59869d;
        if (uptimeMillis > 0) {
            j3 /= uptimeMillis;
        }
        this.f59870e = (int) j3;
    }

    @Override // com.kwai.filedownloader.s.b
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f59871f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f59871f || (this.f59870e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.f59867b) / uptimeMillis);
                this.f59870e = i2;
                this.f59870e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f59867b = j2;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
