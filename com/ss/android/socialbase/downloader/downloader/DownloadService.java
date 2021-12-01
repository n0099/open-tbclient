package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
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
/* loaded from: classes2.dex */
public class DownloadService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61709b;
    public transient /* synthetic */ FieldHolder $fh;
    public o a;

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
        f61709b = DownloadService.class.getSimpleName();
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
            String str = f61709b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBind downloadServiceHandler != null:");
            sb.append(this.a != null);
            com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
            o oVar = this.a;
            if (oVar != null) {
                return oVar.a(intent);
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
            c.a(this);
            o y = c.y();
            this.a = y;
            y.a(new WeakReference(this));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f61709b, "Service onDestroy");
            }
            o oVar = this.a;
            if (oVar != null) {
                oVar.d();
                this.a = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f61709b, "DownloadService onStartCommand");
            }
            this.a.c();
            ExecutorService l = c.l();
            if (l != null) {
                l.execute(new Runnable(this, intent, i2, i3) { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Intent a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f61710b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f61711c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ DownloadService f61712d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, intent, Integer.valueOf(i2), Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61712d = this;
                        this.a = intent;
                        this.f61710b = i2;
                        this.f61711c = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        o oVar;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (oVar = this.f61712d.a) == null) {
                            return;
                        }
                        oVar.a(this.a, this.f61710b, this.f61711c);
                    }
                });
            }
            return c.j() ? 2 : 3;
        }
        return invokeLII.intValue;
    }
}
