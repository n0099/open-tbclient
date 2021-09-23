package com.kwad.sdk.collector.c;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.c.c;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile Message f71642a;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f71643d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HandlerC1983a f71644b;

    /* renamed from: c  reason: collision with root package name */
    public Messenger f71645c;

    /* renamed from: com.kwad.sdk.collector.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC1983a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Service> f71647a;

        public HandlerC1983a() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
                String a2 = ah.a(context);
                if (a2 == null) {
                    return false;
                }
                return !context.getPackageName().equals(a2);
            }
            return invokeL.booleanValue;
        }

        public void a(@Nullable Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, service) == null) {
                if (service != null) {
                    this.f71647a = new WeakReference<>(service);
                } else {
                    this.f71647a = null;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage");
                WeakReference<Service> weakReference = this.f71647a;
                Service service = weakReference != null ? weakReference.get() : null;
                if (service == null) {
                    return;
                }
                if (!a.a().get()) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "save buffered message");
                    a.f71642a = Message.obtain(message);
                    return;
                }
                Messenger messenger = message.replyTo;
                int i2 = message.what;
                com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage what: " + i2);
                if (i2 != 100) {
                    return;
                }
                f.a(service, new f.b(this, messenger, service) { // from class: com.kwad.sdk.collector.c.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Messenger f71648a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Service f71649b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ HandlerC1983a f71650c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messenger, service};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71650c = this;
                        this.f71648a = messenger;
                        this.f71649b = service;
                    }

                    @Override // com.kwad.sdk.utils.f.b
                    public void a(List<b> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                            com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                            if (list != null) {
                                com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                                JSONArray a2 = f.a.a(list);
                                String jSONArray = a2 != null ? a2.toString() : null;
                                if (jSONArray != null) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 101;
                                    AppStatusRules a3 = f.a();
                                    ArrayList<AppStatusRules.Strategy> allStrategy = a3 != null ? a3.getAllStrategy() : null;
                                    String jSONArray2 = allStrategy != null ? q.b(allStrategy).toString() : null;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("resultJson", jSONArray);
                                    bundle.putString("allStrategyJson", jSONArray2);
                                    obtain.setData(bundle);
                                    try {
                                        this.f71648a.send(obtain);
                                    } catch (RemoteException unused) {
                                    }
                                    for (b bVar : list) {
                                        bVar.destroy();
                                    }
                                }
                            }
                            this.f71649b.stopSelf();
                            if (this.f71650c.a((Context) this.f71649b)) {
                                com.kwad.sdk.core.d.a.a("RemoteService", "gotta kill myself");
                                Process.killProcess(Process.myPid());
                            }
                        }
                    }
                });
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039798019, "Lcom/kwad/sdk/collector/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039798019, "Lcom/kwad/sdk/collector/c/a;");
                return;
            }
        }
        f71643d = new AtomicBoolean(false);
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
        this.f71644b = new HandlerC1983a();
        this.f71645c = new Messenger(this.f71644b);
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (context == null) {
                return "ksad_remote";
            }
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "ksad_remote";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "ksad_remote";
            }
        }
        return (String) invokeL.objValue;
    }

    public static AtomicBoolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f71643d : (AtomicBoolean) invokeV.objValue;
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, serviceConnection) == null) {
            context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
        }
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, serviceConnection) == null) {
            try {
                context.unbindService(serviceConnection);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.c.c, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, service, intent)) == null) ? this.f71645c.getBinder() : (IBinder) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.c.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, service) == null) {
            super.onCreate(service);
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(a(service.getApplicationContext()));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "WebView has already been initialized " + e2.getMessage());
                }
            }
            com.kwad.sdk.core.d.a.a("RemoteService", "onCreate processName:" + ah.a(service));
            if (SystemUtil.b(service)) {
                f71643d.set(true);
            } else {
                d.a(service, new d.a(this) { // from class: com.kwad.sdk.collector.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f71646a;

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
                        this.f71646a = this;
                    }

                    @Override // com.kwad.sdk.collector.d.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.a("RemoteService", "onLoaded");
                            a.f71643d.set(true);
                            if (a.f71642a != null) {
                                this.f71646a.f71644b.handleMessage(a.f71642a);
                                a.f71642a = null;
                            }
                        }
                    }

                    @Override // com.kwad.sdk.collector.d.a
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            com.kwad.sdk.core.d.a.e("RemoteService", "onLoadError: " + str);
                            a.f71643d.set(false);
                        }
                    }
                });
            }
            this.f71644b.a(service);
        }
    }

    @Override // com.kwad.sdk.c.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, service) == null) {
            super.onDestroy(service);
            this.f71644b.a((Service) null);
        }
    }
}
