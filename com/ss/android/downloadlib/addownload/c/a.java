package com.ss.android.downloadlib.addownload.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class a implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68540a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private long b(com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar)) == null) {
            long a2 = aVar.a("clear_space_sleep_time", 0L);
            if (a2 <= 0) {
                return 0L;
            }
            if (a2 > 5000) {
                a2 = 5000;
            }
            k.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + a2, null);
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
            return a2;
        }
        return invokeL.longValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f68540a = i2;
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j, long j2, q qVar) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), qVar})) == null) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(this.f68540a);
            if (a(a2)) {
                long currentTimeMillis = System.currentTimeMillis();
                d.a().c();
                long a3 = l.a(0L);
                a();
                long a4 = l.a(0L);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (a4 < j2) {
                    long b2 = b(a2);
                    if (b2 > 0) {
                        a4 = l.a(0L);
                    }
                    j3 = b2;
                } else {
                    j3 = 0;
                }
                k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + a4 + ", cleaned = " + (a4 - a3), null);
                a(a3, a4, j2, currentTimeMillis2, j3);
                if (a4 < j2) {
                    return false;
                }
                if (qVar != null) {
                    qVar.a();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
                return false;
            }
            return System.currentTimeMillis() - d.a().b() >= aVar.a("clear_space_min_time_interval", 600000L);
        }
        return invokeL.booleanValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            com.ss.android.download.api.config.e o = j.o();
            if (o != null) {
                o.a();
            }
            c.a();
            c.b();
        }
    }

    private void a(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f68540a)) == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
