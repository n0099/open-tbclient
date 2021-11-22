package com.kwad.sdk.c.b;

import android.app.Activity;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ar;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65022a;

    /* renamed from: b  reason: collision with root package name */
    public long f65023b;

    /* renamed from: c  reason: collision with root package name */
    public long f65024c;

    /* renamed from: d  reason: collision with root package name */
    public long f65025d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65026e;

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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b();
            bVar.f65028a = this.f65022a;
            long j = this.f65023b;
            bVar.f65030c = j != 0 ? this.f65024c - j : 0L;
            long j2 = this.f65024c;
            bVar.f65031d = j2 != 0 ? this.f65025d - j2 : 0L;
            long j3 = this.f65023b;
            bVar.f65029b = j3 != 0 ? this.f65025d - j3 : 0L;
            d.a(bVar);
            com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f65023b = j;
            this.f65024c = SystemClock.uptimeMillis();
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || this.f65026e) {
            return;
        }
        this.f65026e = true;
        ar.a(new Runnable(this) { // from class: com.kwad.sdk.c.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65027a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65027a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65027a.f65025d = SystemClock.uptimeMillis();
                    this.f65027a.a();
                }
            }
        });
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f65022a = str;
        }
    }
}
