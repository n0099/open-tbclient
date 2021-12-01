package com.kwad.sdk.collector.b;

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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.h.c;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Message a;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f57089d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HandlerC2007a f57090b;

    /* renamed from: c  reason: collision with root package name */
    public Messenger f57091c;

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC2007a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Service> a;

        public HandlerC2007a() {
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

        public void a(@Nullable Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, service) == null) {
                if (service != null) {
                    this.a = new WeakReference<>(service);
                } else {
                    this.a = null;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage");
                WeakReference<Service> weakReference = this.a;
                Service service = weakReference != null ? weakReference.get() : null;
                if (service == null) {
                    return;
                }
                if (!a.a().get()) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "save buffered message");
                    a.a = Message.obtain(message);
                    return;
                }
                Messenger messenger = message.replyTo;
                int i2 = message.what;
                com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage what: " + i2);
                if (i2 != 100) {
                    return;
                }
                h.a(service, new h.b(this, new Bundle(), messenger) { // from class: com.kwad.sdk.collector.b.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Bundle a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Messenger f57092b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ HandlerC2007a f57093c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, messenger};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57093c = this;
                        this.a = r7;
                        this.f57092b = messenger;
                    }

                    @Override // com.kwad.sdk.utils.h.b
                    public void a(List<b> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                            com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                            if (list != null && !list.isEmpty()) {
                                com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                                JSONArray a = h.a.a(list);
                                String jSONArray = a != null ? a.toString() : null;
                                com.kwad.sdk.core.d.a.a("RemoteService", "resultJson :" + jSONArray);
                                if (jSONArray != null) {
                                    AppStatusRules a2 = h.a();
                                    ArrayList<AppStatusRules.Strategy> allStrategy = a2 != null ? a2.getAllStrategy() : null;
                                    String jSONArray2 = allStrategy != null ? t.b(allStrategy).toString() : null;
                                    this.a.putString("resultJson", jSONArray);
                                    this.a.putString("allStrategyJson", jSONArray2);
                                }
                            }
                            try {
                                Message obtain = Message.obtain();
                                obtain.what = 101;
                                obtain.setData(this.a);
                                this.f57092b.send(obtain);
                            } catch (RemoteException unused) {
                            }
                            if (list == null || list.isEmpty()) {
                                return;
                            }
                            for (b bVar : list) {
                                bVar.destroy();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039768228, "Lcom/kwad/sdk/collector/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039768228, "Lcom/kwad/sdk/collector/b/a;");
                return;
            }
        }
        f57089d = new AtomicBoolean(false);
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
        this.f57090b = new HandlerC2007a();
        this.f57091c = new Messenger(this.f57090b);
    }

    public static AtomicBoolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f57089d : (AtomicBoolean) invokeV.objValue;
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, serviceConnection) == null) {
            com.kwad.sdk.core.d.a.a("RemoteService", "bindASService");
            context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String a2 = al.a(context);
            if (a2 == null) {
                return false;
            }
            return !context.getPackageName().equals(a2);
        }
        return invokeL.booleanValue;
    }

    private String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
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

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, serviceConnection) == null) {
            com.kwad.sdk.core.d.a.a("RemoteService", "unbindASService");
            try {
                context.unbindService(serviceConnection);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, service, intent)) == null) ? this.f57091c.getBinder() : (IBinder) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, service) == null) {
            super.onCreate(service);
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(b(service.getApplicationContext()));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "WebView has already been initialized " + e2.getMessage());
                }
            }
            com.kwad.sdk.core.d.a.a("RemoteService", "onCreate processName:" + al.a(service));
            if (SystemUtil.b(service)) {
                f57089d.set(true);
            } else {
                d.a(service, new d.a(this) { // from class: com.kwad.sdk.collector.b.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.collector.d.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.a("RemoteService", "onLoaded");
                            a.f57089d.set(true);
                            if (a.a != null) {
                                this.a.f57090b.handleMessage(a.a);
                                a.a = null;
                            }
                        }
                    }

                    @Override // com.kwad.sdk.collector.d.a
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            com.kwad.sdk.core.d.a.e("RemoteService", "onLoadError: " + str);
                            a.f57089d.set(false);
                        }
                    }
                });
            }
            this.f57090b.a(service);
        }
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, service) == null) {
            super.onDestroy(service);
            com.kwad.sdk.core.d.a.a("RemoteService", MissionEvent.MESSAGE_DESTROY);
            this.f57090b.a(null);
            if (a(service)) {
                com.kwad.sdk.core.d.a.a("RemoteService", "goto kill myself");
                Process.killProcess(Process.myPid());
            }
        }
    }
}
