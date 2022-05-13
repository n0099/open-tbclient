package com.repackage;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vt9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zt9 a;

    public vt9(zt9 zt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zt9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zt9Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                View rootView = this.a.a.getRootView();
                if (rootView != null && rootView.getVisibility() == 0 && rootView.isShown()) {
                    tq9 a = xq9.a(this.a.b.a);
                    a.d(new br9(this.a.b.c), this.a.a.getWidth(), this.a.a.getHeight());
                    a.m();
                    ro9.n(this.a.b.c);
                    if (this.a.b.f != null) {
                        this.a.b.f.onDisplayed();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
