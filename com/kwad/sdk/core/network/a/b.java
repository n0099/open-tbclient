package com.kwad.sdk.core.network.a;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f57499b;

    /* renamed from: c  reason: collision with root package name */
    public long f57500c;

    /* renamed from: d  reason: collision with root package name */
    public long f57501d;

    /* renamed from: e  reason: collision with root package name */
    public String f57502e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f57503f;

    /* renamed from: g  reason: collision with root package name */
    public String f57504g;

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
        this.f57504g = "";
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = SystemClock.uptimeMillis();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f57504g = str;
        }
    }

    public void a(String str, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sceneImpl) == null) {
            this.f57502e = str;
            this.f57503f = sceneImpl;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57499b = SystemClock.uptimeMillis();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f57500c = SystemClock.uptimeMillis();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f57501d = SystemClock.uptimeMillis();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a();
            aVar.f57498g = this.f57502e;
            long uptimeMillis = SystemClock.uptimeMillis();
            long j7 = this.a;
            aVar.a = j7 != 0 ? uptimeMillis - j7 : 0L;
            long j8 = this.f57499b;
            if (j8 != 0) {
                long j9 = this.a;
                if (j9 != 0) {
                    j2 = j8 - j9;
                    aVar.f57493b = j2;
                    j3 = this.f57500c;
                    if (j3 != 0) {
                        long j10 = this.f57499b;
                        if (j10 != 0) {
                            j4 = j3 - j10;
                            aVar.f57494c = j4;
                            j5 = this.f57501d;
                            if (j5 != 0) {
                                long j11 = this.f57500c;
                                if (j11 != 0) {
                                    j6 = j5 - j11;
                                    aVar.f57495d = j6;
                                    long j12 = this.f57501d;
                                    aVar.f57496e = j12 != 0 ? uptimeMillis - j12 : 0L;
                                    aVar.f57497f = this.f57504g;
                                    d.a(this.f57503f, aVar);
                                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                                }
                            }
                            j6 = 0;
                            aVar.f57495d = j6;
                            long j122 = this.f57501d;
                            aVar.f57496e = j122 != 0 ? uptimeMillis - j122 : 0L;
                            aVar.f57497f = this.f57504g;
                            d.a(this.f57503f, aVar);
                            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                        }
                    }
                    j4 = 0;
                    aVar.f57494c = j4;
                    j5 = this.f57501d;
                    if (j5 != 0) {
                    }
                    j6 = 0;
                    aVar.f57495d = j6;
                    long j1222 = this.f57501d;
                    aVar.f57496e = j1222 != 0 ? uptimeMillis - j1222 : 0L;
                    aVar.f57497f = this.f57504g;
                    d.a(this.f57503f, aVar);
                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                }
            }
            j2 = 0;
            aVar.f57493b = j2;
            j3 = this.f57500c;
            if (j3 != 0) {
            }
            j4 = 0;
            aVar.f57494c = j4;
            j5 = this.f57501d;
            if (j5 != 0) {
            }
            j6 = 0;
            aVar.f57495d = j6;
            long j12222 = this.f57501d;
            aVar.f57496e = j12222 != 0 ? uptimeMillis - j12222 : 0L;
            aVar.f57497f = this.f57504g;
            d.a(this.f57503f, aVar);
            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
        }
    }
}
