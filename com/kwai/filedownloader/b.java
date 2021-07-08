package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f36680a;

    /* renamed from: b  reason: collision with root package name */
    public long f36681b;

    /* renamed from: c  reason: collision with root package name */
    public long f36682c;

    /* renamed from: d  reason: collision with root package name */
    public long f36683d;

    /* renamed from: e  reason: collision with root package name */
    public int f36684e;

    /* renamed from: f  reason: collision with root package name */
    public int f36685f;

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
        this.f36685f = 1000;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36684e = 0;
            this.f36680a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f36683d = SystemClock.uptimeMillis();
            this.f36682c = j;
        }
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36684e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f36683d <= 0) {
            return;
        }
        long j2 = j - this.f36682c;
        this.f36680a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f36683d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f36684e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f36685f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f36680a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f36680a;
            if (uptimeMillis >= this.f36685f || (this.f36684e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f36681b) / uptimeMillis);
                this.f36684e = i2;
                this.f36684e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f36681b = j;
            this.f36680a = SystemClock.uptimeMillis();
        }
    }
}
