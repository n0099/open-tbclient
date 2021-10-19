package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public class DownloadService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f76246b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f76247a;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f76248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f76249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f76250g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DownloadService f76251h;

        public a(DownloadService downloadService, Intent intent, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadService, intent, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76251h = downloadService;
            this.f76248e = intent;
            this.f76249f = i2;
            this.f76250g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pVar = this.f76251h.f76247a) == null) {
                return;
            }
            pVar.a(this.f76248e, this.f76249f, this.f76250g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2008717398, "Lcom/ss/android/socialbase/downloader/downloader/DownloadService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2008717398, "Lcom/ss/android/socialbase/downloader/downloader/DownloadService;");
                return;
            }
        }
        f76246b = DownloadService.class.getSimpleName();
    }

    public DownloadService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String str = f76246b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBind downloadServiceHandler != null:");
            sb.append(this.f76247a != null);
            c.p.a.e.b.c.a.g(str, sb.toString());
            p pVar = this.f76247a;
            if (pVar != null) {
                return pVar.a(intent);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            e.C(this);
            p N0 = e.N0();
            this.f76247a = N0;
            N0.c(new WeakReference(this));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.g(f76246b, "Service onDestroy");
            }
            p pVar = this.f76247a;
            if (pVar != null) {
                pVar.d();
                this.f76247a = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.g(f76246b, "DownloadService onStartCommand");
            }
            this.f76247a.c();
            ExecutorService A0 = e.A0();
            if (A0 != null) {
                A0.execute(new a(this, intent, i2, i3));
            }
            return e.y0() ? 2 : 3;
        }
        return invokeLII.intValue;
    }
}
