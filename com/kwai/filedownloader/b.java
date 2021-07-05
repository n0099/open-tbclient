package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.r;
/* loaded from: classes7.dex */
public class b implements r.a, r.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f39473a;

    /* renamed from: b  reason: collision with root package name */
    public long f39474b;

    /* renamed from: c  reason: collision with root package name */
    public long f39475c;

    /* renamed from: d  reason: collision with root package name */
    public long f39476d;

    /* renamed from: e  reason: collision with root package name */
    public int f39477e;

    /* renamed from: f  reason: collision with root package name */
    public int f39478f;

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
        this.f39478f = 1000;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39477e = 0;
            this.f39473a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f39476d = SystemClock.uptimeMillis();
            this.f39475c = j;
        }
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39477e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f39476d <= 0) {
            return;
        }
        long j2 = j - this.f39475c;
        this.f39473a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f39476d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f39477e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f39478f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f39473a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f39473a;
            if (uptimeMillis >= this.f39478f || (this.f39477e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f39474b) / uptimeMillis);
                this.f39477e = i2;
                this.f39477e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f39474b = j;
            this.f39473a = SystemClock.uptimeMillis();
        }
    }
}
