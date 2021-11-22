package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Notification f70655a;

    /* renamed from: b  reason: collision with root package name */
    public int f70656b;

    /* renamed from: c  reason: collision with root package name */
    public long f70657c;

    /* renamed from: d  reason: collision with root package name */
    public long f70658d;

    /* renamed from: e  reason: collision with root package name */
    public String f70659e;

    /* renamed from: f  reason: collision with root package name */
    public int f70660f;

    /* renamed from: g  reason: collision with root package name */
    public long f70661g;

    /* renamed from: h  reason: collision with root package name */
    public int f70662h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70663i;

    public a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70660f = 0;
        this.f70656b = i2;
        this.f70659e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f70656b = downloadInfo.getId();
        this.f70659e = downloadInfo.getTitle();
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70657c : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f70658d : invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f70659e : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f70660f : invokeV.intValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f70661g == 0) {
                this.f70661g = System.currentTimeMillis();
            }
            return this.f70661g;
        }
        return invokeV.longValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.f70662h++;
            }
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f70662h : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f70663i : invokeV.booleanValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f70658d = j;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70656b : invokeV.intValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f70657c = j;
        }
    }

    public void a(int i2, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z)}) == null) {
            a(i2, baseException, z, false);
        }
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 || this.f70660f != i2) {
                this.f70660f = i2;
                a(baseException, z);
            }
        }
    }

    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f70657c = j;
            this.f70658d = j2;
            this.f70660f = 4;
            a((BaseException) null, false);
        }
    }

    public void a(Notification notification) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, notification) == null) || this.f70656b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f70656b, this.f70660f, notification);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f70663i = z;
        }
    }
}
