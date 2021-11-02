package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
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
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f69570e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.i f69571f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.n f69572g;

    /* renamed from: h  reason: collision with root package name */
    public int f69573h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292378905, "Lcom/ss/android/socialbase/downloader/impls/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-292378905, "Lcom/ss/android/socialbase/downloader/impls/n;");
                return;
            }
        }
        f69570e = n.class.getSimpleName();
    }

    public n() {
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
        this.f69573h = -1;
    }

    private void g() {
        SparseArray<List<DownloadTask>> clone;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                synchronized (this.f69248a) {
                    clone = this.f69248a.clone();
                    this.f69248a.clear();
                }
                if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.c.C() == null) {
                    return;
                }
                for (int i2 = 0; i2 < clone.size(); i2++) {
                    List<DownloadTask> list = clone.get(clone.keyAt(i2));
                    if (list != null) {
                        for (DownloadTask downloadTask : list) {
                            try {
                                this.f69571f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.a(f69570e, "resumePendingTaskForIndependent failed", th);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
                com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
            }
            com.ss.android.socialbase.downloader.c.a.b(f69570e, "onBind IndependentDownloadBinder");
            return new m();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadTask) == null) || downloadTask == null) {
            return;
        }
        String str = f69570e;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.f69571f == null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f69571f == null) {
            a(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
            return;
        }
        g();
        try {
            this.f69571f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadTask) == null) || downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.d.a().a(downloadTask.getDownloadId(), true);
        a C = com.ss.android.socialbase.downloader.downloader.c.C();
        if (C != null) {
            C.a(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, componentName) == null) {
            this.f69571f = null;
            com.ss.android.socialbase.downloader.downloader.n nVar = this.f69572g;
            if (nVar != null) {
                nVar.h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, componentName, iBinder) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69570e, "onServiceConnected ");
            this.f69571f = i.a.a(iBinder);
            com.ss.android.socialbase.downloader.downloader.n nVar = this.f69572g;
            if (nVar != null) {
                nVar.a(iBinder);
            }
            String str = f69570e;
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected aidlService!=null");
            sb.append(this.f69571f != null);
            sb.append(" pendingTasks.size:");
            sb.append(this.f69248a.size());
            com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
            if (this.f69571f != null) {
                com.ss.android.socialbase.downloader.downloader.d.a().b();
                this.f69249b = true;
                this.f69251d = false;
                int i2 = this.f69573h;
                if (i2 != -1) {
                    try {
                        this.f69571f.l(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f69571f != null) {
                    g();
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, componentName) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69570e, "onServiceDisconnected ");
            this.f69571f = null;
            this.f69249b = false;
            com.ss.android.socialbase.downloader.downloader.n nVar = this.f69572g;
            if (nVar != null) {
                nVar.h();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, serviceConnection) == null) {
            try {
                com.ss.android.socialbase.downloader.c.a.b(f69570e, "bindService");
                Intent intent = new Intent(context, IndependentProcessDownloadService.class);
                if (com.ss.android.socialbase.downloader.i.f.a()) {
                    intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db"));
                }
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, serviceConnection) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69570e, "stopService");
            this.f69249b = false;
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (serviceConnection != null) {
                context.unbindService(serviceConnection);
            }
            context.stopService(intent);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(com.ss.android.socialbase.downloader.downloader.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
            this.f69572g = nVar;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.ss.android.socialbase.downloader.downloader.i iVar = this.f69571f;
            if (iVar == null) {
                this.f69573h = i2;
                return;
            }
            try {
                iVar.l(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f69571f == null) {
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
        }
    }
}
