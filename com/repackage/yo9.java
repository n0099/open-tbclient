package com.repackage;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yo9 implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ up9 a;
    public final /* synthetic */ xp9 b;

    public yo9(xp9 xp9Var, up9 up9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xp9Var, up9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xp9Var;
        this.a = up9Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.b.b || !this.b.b(this.b.a)) {
                    return;
                }
                this.b.e.removeMessages(1101);
                this.b.a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.a != null) {
                    this.a.a();
                }
                this.b.b = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
