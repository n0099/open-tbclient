package com.win.opensdk;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f42601a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f42602b;

    public k0(m0 m0Var, l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0Var, l0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42602b = m0Var;
        this.f42601a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f42602b.f42606b || !this.f42602b.a(this.f42602b.f42605a)) {
                    return;
                }
                this.f42602b.f42609e.removeMessages(1101);
                this.f42602b.f42605a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.f42601a != null) {
                    this.f42601a.a();
                }
                this.f42602b.f42606b = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
