package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
@Keep
/* loaded from: classes6.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean HAS_REGISTER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1410211780, "Lcom/kwad/sdk/api/loader/DynamicInstallReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1410211780, "Lcom/kwad/sdk/api/loader/DynamicInstallReceiver;");
                return;
            }
        }
        HAS_REGISTER = new AtomicBoolean(false);
    }

    public DynamicInstallReceiver() {
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

    @Keep
    public static void registerToApp(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null || HAS_REGISTER.get() || context.getApplicationContext() == null) {
            return;
        }
        context.getApplicationContext().registerReceiver(new DynamicInstallReceiver(), new IntentFilter(context.getPackageName() + ".loader.install.DynamicApk"));
        HAS_REGISTER.set(true);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        String stringExtra2 = intent.getStringExtra(CommandMessage.SDK_VERSION);
        File file = new File(stringExtra);
        if (file.exists()) {
            AsyncTask.execute(new Runnable(this, context, file, stringExtra2) { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f33957a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ File f33958b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f33959c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DynamicInstallReceiver f33960d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, file, stringExtra2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33960d = this;
                    this.f33957a = context;
                    this.f33958b = file;
                    this.f33959c = stringExtra2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (b.a(this.f33957a, this.f33958b.getPath(), this.f33959c)) {
                                f.a(this.f33957a, f.f33998a, this.f33959c);
                                g.a(this.f33958b);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
