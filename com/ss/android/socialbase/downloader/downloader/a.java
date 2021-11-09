package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f69246e = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<List<DownloadTask>> f69247a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f69248b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f69249c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f69250d;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Service> f69251f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f69252g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f69253h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(326251446, "Lcom/ss/android/socialbase/downloader/downloader/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(326251446, "Lcom/ss/android/socialbase/downloader/downloader/a;");
        }
    }

    public a() {
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
        this.f69247a = new SparseArray<>();
        this.f69248b = false;
        this.f69250d = false;
        this.f69252g = new Handler(Looper.getMainLooper());
        this.f69253h = new Runnable(this) { // from class: com.ss.android.socialbase.downloader.downloader.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f69254a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69254a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(a.f69246e, "tryDownload: 2 try");
                    }
                    if (this.f69254a.f69248b) {
                        return;
                    }
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(a.f69246e, "tryDownload: 2 error");
                    }
                    this.f69254a.startService(c.N(), null);
                }
            }
        };
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, intent, i2, i3) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(WeakReference weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, weakReference) == null) {
            this.f69251f = weakReference;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = f69246e;
            com.ss.android.socialbase.downloader.c.a.c(str, "isServiceForeground = " + this.f69249c);
            return this.f69249c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadTask) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f69248b = false;
        }
    }

    public void e() {
        SparseArray<List<DownloadTask>> clone;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f69247a) {
                String str = f69246e;
                com.ss.android.socialbase.downloader.c.a.b(str, "resumePendingTask pendingTasks.size:" + this.f69247a.size());
                clone = this.f69247a.clone();
                this.f69247a.clear();
            }
            com.ss.android.socialbase.downloader.impls.a C = c.C();
            if (C != null) {
                for (int i2 = 0; i2 < clone.size(); i2++) {
                    List<DownloadTask> list = clone.get(clone.keyAt(i2));
                    if (list != null) {
                        for (DownloadTask downloadTask : list) {
                            String str2 = f69246e;
                            com.ss.android.socialbase.downloader.c.a.b(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                            C.a(downloadTask);
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f69248b) {
            return;
        }
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f69246e, "startService");
        }
        startService(c.N(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, serviceConnection) == null) {
        }
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, serviceConnection) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69248b : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69246e, "onBind Abs");
            return new Binder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, downloadTask) == null) || downloadTask == null) {
            return;
        }
        if (!this.f69248b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f69246e, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
                a(downloadTask);
                if (!this.f69250d) {
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(f69246e, "tryDownload: 1");
                    }
                    startService(c.N(), null);
                    this.f69250d = true;
                    return;
                }
                this.f69252g.removeCallbacks(this.f69253h);
                this.f69252g.postDelayed(this.f69253h, 10L);
                return;
            }
            a(downloadTask);
            startService(c.N(), null);
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(f69246e, "tryDownload when isServiceAlive");
        e();
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            String str = f69246e;
            com.ss.android.socialbase.downloader.c.a.b(str, "tryDownload current task: " + downloadTask.getDownloadId());
            C.a(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, notification) == null) {
            WeakReference<Service> weakReference = this.f69251f;
            if (weakReference != null && weakReference.get() != null) {
                String str = f69246e;
                com.ss.android.socialbase.downloader.c.a.c(str, "startForeground  id = " + i2 + ", service = " + this.f69251f.get() + ",  isServiceAlive = " + this.f69248b);
                try {
                    this.f69251f.get().startForeground(i2, notification);
                    this.f69249c = true;
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            com.ss.android.socialbase.downloader.c.a.d(f69246e, "startForeground: downloadService is null, do nothing!");
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(boolean z) {
        WeakReference<Service> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (weakReference = this.f69251f) == null || weakReference.get() == null) {
            return;
        }
        String str = f69246e;
        com.ss.android.socialbase.downloader.c.a.c(str, "stopForeground  service = " + this.f69251f.get() + ",  isServiceAlive = " + this.f69248b);
        try {
            this.f69249c = false;
            this.f69251f.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadTask) == null) || downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.f69247a) {
            String str = f69246e;
            com.ss.android.socialbase.downloader.c.a.b(str, "pendDownloadTask pendingTasks.size:" + this.f69247a.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.f69247a.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.f69247a.put(downloadId, list);
            }
            String str2 = f69246e;
            com.ss.android.socialbase.downloader.c.a.b(str2, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            String str3 = f69246e;
            com.ss.android.socialbase.downloader.c.a.b(str3, "after pendDownloadTask pendingTasks.size:" + this.f69247a.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.ss.android.socialbase.downloader.c.a.a(i2);
        }
    }
}
