package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes6.dex */
public class hp9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;
    public final /* synthetic */ pp9 b;

    public hp9(pp9 pp9Var, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pp9Var, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pp9Var;
        this.a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pp9 pp9Var = this.b;
            if (pp9Var.g != null) {
                Context context = pp9Var.a;
                Info info = this.a;
                if (pm9.c(info)) {
                    try {
                        dk9 a = dk9.a();
                        if (a.a == null) {
                            a.a = new AdvancedWebView(context.getApplicationContext());
                        }
                        a.a.loadUrl(info.getOpen());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.b.g.a(this.a);
            }
        }
    }
}
