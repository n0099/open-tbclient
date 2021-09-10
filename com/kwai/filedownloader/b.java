package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.r;
/* loaded from: classes10.dex */
public class b implements r.a, r.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f74073a;

    /* renamed from: b  reason: collision with root package name */
    public long f74074b;

    /* renamed from: c  reason: collision with root package name */
    public long f74075c;

    /* renamed from: d  reason: collision with root package name */
    public long f74076d;

    /* renamed from: e  reason: collision with root package name */
    public int f74077e;

    /* renamed from: f  reason: collision with root package name */
    public int f74078f;

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
        this.f74078f = 1000;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f74077e = 0;
            this.f74073a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f74076d = SystemClock.uptimeMillis();
            this.f74075c = j2;
        }
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f74077e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f74076d <= 0) {
            return;
        }
        long j3 = j2 - this.f74075c;
        this.f74073a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f74076d;
        if (uptimeMillis > 0) {
            j3 /= uptimeMillis;
        }
        this.f74077e = (int) j3;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f74078f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f74073a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f74073a;
            if (uptimeMillis >= this.f74078f || (this.f74077e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.f74074b) / uptimeMillis);
                this.f74077e = i2;
                this.f74077e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f74074b = j2;
            this.f74073a = SystemClock.uptimeMillis();
        }
    }
}
