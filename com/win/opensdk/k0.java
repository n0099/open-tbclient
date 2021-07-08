package com.win.opensdk;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f39615a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f39616b;

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
        this.f39616b = m0Var;
        this.f39615a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f39616b.f39620b || !this.f39616b.a(this.f39616b.f39619a)) {
                    return;
                }
                this.f39616b.f39623e.removeMessages(1101);
                this.f39616b.f39619a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.f39615a != null) {
                    this.f39615a.a();
                }
                this.f39616b.f39620b = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
