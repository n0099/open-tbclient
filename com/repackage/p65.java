package com.repackage;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p65 implements o65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public n65 b;
    public Application c;
    public String d;
    public final u65 e;
    public final v65 f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p65 this$0;

        public b(p65 p65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = p65Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l65 a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            if (!q65.i()) {
                String c = q65.c();
                q65.m(c + " Process Not In WhiteList，No Receive");
            } else if ("intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (a = this.this$0.e.a(intent)) != null) {
                int myPid = Process.myPid();
                int pid = a.getPid();
                if (a == null || a.getType() != 1) {
                    if (a.getType() == 2) {
                        if (myPid != pid) {
                            return;
                        }
                    } else if (a.getType() == 3 && !q65.l()) {
                        return;
                    }
                } else if (myPid == pid) {
                    return;
                }
                if (this.this$0.b != null) {
                    this.this$0.b.a(a);
                }
            }
        }

        public /* synthetic */ b(p65 p65Var, a aVar) {
            this(p65Var);
        }
    }

    public p65(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new u65();
        this.f = new v65();
        this.c = application;
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                unregisterReceiver();
                this.a = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.setPriority(1000);
                intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.c.registerReceiver(this.a, intentFilter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.a == null || this.c == null) {
                    return;
                }
                this.c.unregisterReceiver(this.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.o65
    public void a(l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l65Var) == null) {
            f(l65Var);
        }
    }

    @Override // com.repackage.o65
    public void b(n65 n65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n65Var) == null) {
            this.b = n65Var;
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null && (application = this.c) != null) {
                this.d = application.getPackageName();
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final void f(l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l65Var) == null) {
            if (l65Var != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(e());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f.a(intent, l65Var);
                    this.c.sendBroadcast(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            throw new NullPointerException("send multi-process message is null");
        }
    }

    @Override // com.repackage.o65
    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerReceiver();
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            unregisterReceiver();
        }
    }
}
