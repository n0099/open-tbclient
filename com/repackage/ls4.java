package com.repackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ls4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public String c;
    public boolean d;
    public Handler e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageQueue.IdleHandler a;
        public final /* synthetic */ ls4 b;

        public a(ls4 ls4Var, MessageQueue.IdleHandler idleHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls4Var, idleHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ls4Var;
            this.a = idleHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.e(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ls4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-203847546, "Lcom/repackage/ls4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-203847546, "Lcom/repackage/ls4$b;");
                    return;
                }
            }
            a = new ls4();
        }
    }

    public ls4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.d = false;
    }

    public static ls4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b.a : (ls4) invokeV.objValue;
    }

    public final Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e == null) {
                this.e = new Handler(Looper.getMainLooper());
            }
            return this.e;
        }
        return (Handler) invokeV.objValue;
    }

    public void c(ActivityManager.AppTask appTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appTask) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false) || Build.VERSION.SDK_INT < 23 || appTask == null || appTask.getTaskInfo() == null || appTask.getTaskInfo().baseActivity == null || appTask.getTaskInfo().topActivity == null || appTask.getTaskInfo().baseIntent == null) {
                return;
            }
            String dataString = appTask.getTaskInfo().baseIntent.getDataString();
            if (SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) && SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
                this.b = !ni.isEmpty(dataString) ? 1 : 0;
                this.c = dataString;
            } else if ("com.baidu.tieba.yunpush.YunPushProxyActivity".equals(appTask.getTaskInfo().baseActivity.getClassName()) && "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(appTask.getTaskInfo().topActivity.getClassName())) {
                this.b = ni.isEmpty(dataString) ? 0 : 2;
                this.c = dataString;
            } else {
                this.b = 0;
            }
            this.a = this.b != 0;
        }
    }

    public void d(Intent intent) {
        ComponentName component;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false) || intent == null || (component = intent.getComponent()) == null) {
                return;
            }
            String dataString = intent.getDataString();
            if (SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(component.getClassName())) {
                this.b = !ni.isEmpty(dataString) ? 1 : 0;
                this.c = dataString;
            } else if ("com.baidu.tieba.yunpush.YunPushProxyActivity".equals(component.getClassName())) {
                this.b = ni.isEmpty(dataString) ? 0 : 2;
                this.c = dataString;
            } else {
                this.b = 0;
            }
            this.a = this.b != 0;
        }
    }

    public void e(MessageQueue.IdleHandler idleHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, idleHandler) == null) || idleHandler == null || this.d) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            b().post(new a(this, idleHandler));
            return;
        }
        Looper.myQueue().addIdleHandler(idleHandler);
        this.d = true;
    }
}
