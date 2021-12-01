package com.ss.android.downloadlib.addownload;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f61234b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f61235c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2001018347, "Lcom/ss/android/downloadlib/addownload/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2001018347, "Lcom/ss/android/downloadlib/addownload/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61235c = null;
        this.f61235c = new ConcurrentHashMap<>();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61234b == null) {
                synchronized (c.class) {
                    if (f61234b == null) {
                        f61234b = new c();
                    }
                }
            }
            return f61234b;
        }
        return (c) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? j.i().optLong("quick_app_check_internal", IMLikeRequest.TIME_INTERVAL) : invokeV.longValue;
    }

    public void a(e eVar, boolean z, int i2, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, Boolean.valueOf(z), Integer.valueOf(i2), downloadModel}) == null) {
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            long id = downloadModel.getId();
            if (i2 == 4) {
                if (!z) {
                    a(id, false, 2);
                    eVar.b(false);
                    return;
                }
                a(id, true, 2);
            } else if (i2 == 5) {
                if (!z) {
                    a(id, false, 1);
                    eVar.c(false);
                    return;
                }
                a(id, true, 1);
            } else if (i2 != 7) {
            } else {
                Runnable remove = this.f61235c.remove(Long.valueOf(id));
                if (z) {
                    com.ss.android.downloadlib.d.a.a().a(id, 1);
                    a(id, true, 1);
                    return;
                }
                if (remove != null) {
                    com.ss.android.downloadlib.f.a().b().post(remove);
                }
                a(id, false, 1);
            }
        }
    }

    private void a(long j2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            com.ss.android.downloadlib.d.a.a().a(j2, z, i2);
            if (z) {
                j.t().a(null, null, null, null, null, 3);
            }
        }
    }

    public void a(e eVar, int i2, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, eVar, i2, downloadModel) == null) {
            com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d(this, eVar, i2, downloadModel) { // from class: com.ss.android.downloadlib.addownload.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61236b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f61237c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ c f61238d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar, Integer.valueOf(i2), downloadModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61238d = this;
                    this.a = eVar;
                    this.f61236b = i2;
                    this.f61237c = downloadModel;
                }

                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.f61238d.a(this.a, z, this.f61236b, this.f61237c);
                    }
                }
            }, b());
        }
    }

    public static boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadInfo)) == null) ? downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4 : invokeL.booleanValue;
    }
}
