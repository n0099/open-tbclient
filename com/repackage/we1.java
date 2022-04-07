package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class we1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile we1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public HashSet<String> f;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we1 a;

        public a(we1 we1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we1Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String stringExtra = intent.getStringExtra("ss");
                if (this.a.b == 1) {
                    return;
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    this.a.b = 1;
                } else if ("LOADED".equals(stringExtra)) {
                    if (this.a.f.isEmpty()) {
                        return;
                    }
                    this.a.b = 1;
                } else {
                    this.a.b = 1;
                    this.a.f.add(stringExtra);
                }
            }
        }
    }

    public we1() {
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
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new HashSet<>();
    }

    public static we1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (g == null) {
                synchronized (we1.class) {
                    if (g == null) {
                        g = new we1();
                    }
                }
            }
            return g;
        }
        return (we1) invokeV.objValue;
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                if (this.a != null) {
                    return;
                }
                this.a = new a(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
                context.registerReceiver(this.a, intentFilter);
            } catch (Throwable th) {
                uf1.d(th);
            }
        }
    }

    public void e(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject) == null) {
            this.d = jSONObject.optInt("1", 0) == 1;
            this.c = jSONObject.optInt("2", 0) == 1;
            this.e = jSONObject.optInt("3", 0) == 1;
            if (this.c) {
                d(context);
            } else {
                h(context);
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c) {
                return this.b;
            }
            return -1000;
        }
        return invokeV.intValue;
    }

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            try {
                if (this.a == null) {
                    return;
                }
                context.unregisterReceiver(this.a);
                this.a = null;
            } catch (Throwable th) {
                uf1.d(th);
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d) {
                if (this.e) {
                    return this.c && this.b != 1;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = 0;
            this.f.clear();
        }
    }
}
