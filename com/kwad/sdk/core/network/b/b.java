package com.kwad.sdk.core.network.b;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f34852a;

    /* renamed from: b  reason: collision with root package name */
    public long f34853b;

    /* renamed from: c  reason: collision with root package name */
    public long f34854c;

    /* renamed from: d  reason: collision with root package name */
    public long f34855d;

    /* renamed from: e  reason: collision with root package name */
    public String f34856e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f34857f;

    /* renamed from: g  reason: collision with root package name */
    public String f34858g;

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
        this.f34858g = "";
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34852a = SystemClock.uptimeMillis();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f34858g = str;
        }
    }

    public void a(String str, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sceneImpl) == null) {
            this.f34856e = str;
            this.f34857f = sceneImpl;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f34853b = SystemClock.uptimeMillis();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f34854c = SystemClock.uptimeMillis();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f34855d = SystemClock.uptimeMillis();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a();
            aVar.f34851g = this.f34856e;
            long uptimeMillis = SystemClock.uptimeMillis();
            long j6 = this.f34852a;
            aVar.f34845a = j6 != 0 ? uptimeMillis - j6 : 0L;
            long j7 = this.f34853b;
            if (j7 != 0) {
                long j8 = this.f34852a;
                if (j8 != 0) {
                    j = j7 - j8;
                    aVar.f34846b = j;
                    j2 = this.f34854c;
                    if (j2 != 0) {
                        long j9 = this.f34853b;
                        if (j9 != 0) {
                            j3 = j2 - j9;
                            aVar.f34847c = j3;
                            j4 = this.f34855d;
                            if (j4 != 0) {
                                long j10 = this.f34854c;
                                if (j10 != 0) {
                                    j5 = j4 - j10;
                                    aVar.f34848d = j5;
                                    long j11 = this.f34855d;
                                    aVar.f34849e = j11 != 0 ? uptimeMillis - j11 : 0L;
                                    aVar.f34850f = this.f34858g;
                                    d.a(this.f34857f, aVar);
                                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                                }
                            }
                            j5 = 0;
                            aVar.f34848d = j5;
                            long j112 = this.f34855d;
                            aVar.f34849e = j112 != 0 ? uptimeMillis - j112 : 0L;
                            aVar.f34850f = this.f34858g;
                            d.a(this.f34857f, aVar);
                            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                        }
                    }
                    j3 = 0;
                    aVar.f34847c = j3;
                    j4 = this.f34855d;
                    if (j4 != 0) {
                    }
                    j5 = 0;
                    aVar.f34848d = j5;
                    long j1122 = this.f34855d;
                    aVar.f34849e = j1122 != 0 ? uptimeMillis - j1122 : 0L;
                    aVar.f34850f = this.f34858g;
                    d.a(this.f34857f, aVar);
                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                }
            }
            j = 0;
            aVar.f34846b = j;
            j2 = this.f34854c;
            if (j2 != 0) {
            }
            j3 = 0;
            aVar.f34847c = j3;
            j4 = this.f34855d;
            if (j4 != 0) {
            }
            j5 = 0;
            aVar.f34848d = j5;
            long j11222 = this.f34855d;
            aVar.f34849e = j11222 != 0 ? uptimeMillis - j11222 : 0L;
            aVar.f34850f = this.f34858g;
            d.a(this.f34857f, aVar);
            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
        }
    }
}
