package com.kuaishou.weapon.p0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.a3;
import com.kuaishou.weapon.p0.b3;
import com.kuaishou.weapon.p0.c3;
import com.kuaishou.weapon.p0.d3;
import com.kuaishou.weapon.p0.e3;
import com.kuaishou.weapon.p0.o;
import com.kuaishou.weapon.p0.q1;
import com.kuaishou.weapon.p0.y2;
import com.kuaishou.weapon.p0.z2;
/* loaded from: classes9.dex */
public class WeaponRECE extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ WeaponRECE c;

        public a(WeaponRECE weaponRECE, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weaponRECE, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = weaponRECE;
            this.a = intent;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String action = this.a.getAction();
                if (!TextUtils.isEmpty(action) && action.equals(q1.f)) {
                    b3.a(this.b).a(0, 0);
                    d3.a(this.b).a(0);
                    z2.a(this.b).a(0);
                    a3.a(this.b).a();
                    e3.a(this.b).a();
                    y2.a(this.b).a(0);
                    c3.a(this.b).a(0);
                }
            }
        }
    }

    public WeaponRECE() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            try {
                o.a().a(new a(this, intent, context));
            } catch (Throwable unused) {
            }
        }
    }
}
