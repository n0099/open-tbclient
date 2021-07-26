package d.l.a.e.b.p;

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
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72532a;

    /* renamed from: b  reason: collision with root package name */
    public long f72533b;

    /* renamed from: c  reason: collision with root package name */
    public long f72534c;

    /* renamed from: d  reason: collision with root package name */
    public String f72535d;

    /* renamed from: e  reason: collision with root package name */
    public int f72536e;

    /* renamed from: f  reason: collision with root package name */
    public long f72537f;

    /* renamed from: g  reason: collision with root package name */
    public int f72538g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72539h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f72540i;

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
        this.f72536e = 0;
        this.f72532a = i2;
        this.f72535d = str;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72532a : invokeV.intValue;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z)}) == null) {
            c(i2, baseException, z, false);
        }
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 || this.f72536e != i2) {
                this.f72536e = i2;
                g(baseException, z);
            }
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f72533b = j;
        }
    }

    public void e(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72533b = j;
            this.f72534c = j2;
            this.f72536e = 4;
            g(null, false);
        }
    }

    public void f(Notification notification) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, notification) == null) || this.f72532a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f72532a, this.f72536e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f72532a = downloadInfo.getId();
        this.f72535d = downloadInfo.getTitle();
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f72539h = z;
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f72533b : invokeV.longValue;
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f72534c = j;
        }
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f72534c : invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f72535d : (String) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f72536e : invokeV.intValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f72537f == 0) {
                this.f72537f = System.currentTimeMillis();
            }
            return this.f72537f;
        }
        return invokeV.longValue;
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.f72538g++;
            }
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f72538g : invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f72539h : invokeV.booleanValue;
    }
}
