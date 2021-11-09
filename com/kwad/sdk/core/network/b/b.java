package com.kwad.sdk.core.network.b;

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

    /* renamed from: a  reason: collision with root package name */
    public long f64790a;

    /* renamed from: b  reason: collision with root package name */
    public long f64791b;

    /* renamed from: c  reason: collision with root package name */
    public long f64792c;

    /* renamed from: d  reason: collision with root package name */
    public long f64793d;

    /* renamed from: e  reason: collision with root package name */
    public String f64794e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f64795f;

    /* renamed from: g  reason: collision with root package name */
    public String f64796g;

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
        this.f64796g = "";
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64790a = SystemClock.uptimeMillis();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f64796g = str;
        }
    }

    public void a(String str, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sceneImpl) == null) {
            this.f64794e = str;
            this.f64795f = sceneImpl;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64791b = SystemClock.uptimeMillis();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f64792c = SystemClock.uptimeMillis();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64793d = SystemClock.uptimeMillis();
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
            aVar.f64789g = this.f64794e;
            long uptimeMillis = SystemClock.uptimeMillis();
            long j6 = this.f64790a;
            aVar.f64783a = j6 != 0 ? uptimeMillis - j6 : 0L;
            long j7 = this.f64791b;
            if (j7 != 0) {
                long j8 = this.f64790a;
                if (j8 != 0) {
                    j = j7 - j8;
                    aVar.f64784b = j;
                    j2 = this.f64792c;
                    if (j2 != 0) {
                        long j9 = this.f64791b;
                        if (j9 != 0) {
                            j3 = j2 - j9;
                            aVar.f64785c = j3;
                            j4 = this.f64793d;
                            if (j4 != 0) {
                                long j10 = this.f64792c;
                                if (j10 != 0) {
                                    j5 = j4 - j10;
                                    aVar.f64786d = j5;
                                    long j11 = this.f64793d;
                                    aVar.f64787e = j11 != 0 ? uptimeMillis - j11 : 0L;
                                    aVar.f64788f = this.f64796g;
                                    d.a(this.f64795f, aVar);
                                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                                }
                            }
                            j5 = 0;
                            aVar.f64786d = j5;
                            long j112 = this.f64793d;
                            aVar.f64787e = j112 != 0 ? uptimeMillis - j112 : 0L;
                            aVar.f64788f = this.f64796g;
                            d.a(this.f64795f, aVar);
                            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                        }
                    }
                    j3 = 0;
                    aVar.f64785c = j3;
                    j4 = this.f64793d;
                    if (j4 != 0) {
                    }
                    j5 = 0;
                    aVar.f64786d = j5;
                    long j1122 = this.f64793d;
                    aVar.f64787e = j1122 != 0 ? uptimeMillis - j1122 : 0L;
                    aVar.f64788f = this.f64796g;
                    d.a(this.f64795f, aVar);
                    com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                }
            }
            j = 0;
            aVar.f64784b = j;
            j2 = this.f64792c;
            if (j2 != 0) {
            }
            j3 = 0;
            aVar.f64785c = j3;
            j4 = this.f64793d;
            if (j4 != 0) {
            }
            j5 = 0;
            aVar.f64786d = j5;
            long j11222 = this.f64793d;
            aVar.f64787e = j11222 != 0 ? uptimeMillis - j11222 : 0L;
            aVar.f64788f = this.f64796g;
            d.a(this.f64795f, aVar);
            com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
        }
    }
}
