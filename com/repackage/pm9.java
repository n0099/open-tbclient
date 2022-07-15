package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class pm9 extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ mm9 a;
    public final /* synthetic */ lm9 b;

    public pm9(lm9 lm9Var, mm9 mm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lm9Var, mm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = lm9Var;
        this.a = mm9Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
                this.b.p();
                int i = extras.getInt("install.status");
                if (i == 1 || i == 2 || i == 3) {
                    this.a.a(com.google.ar.core.p.a);
                } else if (i == 4) {
                    this.a.a(com.google.ar.core.p.c);
                } else if (i != 6) {
                } else {
                    this.a.a(com.google.ar.core.p.b);
                }
            }
        }
    }
}
