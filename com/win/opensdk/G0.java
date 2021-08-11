package com.win.opensdk;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class G0 implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N0 f76415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ O0 f76416b;

    public G0(O0 o0, N0 n0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o0, n0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76416b = o0;
        this.f76415a = n0;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f76416b.f76445b || !this.f76416b.a(this.f76416b.f76444a)) {
                    return;
                }
                this.f76416b.f76448e.removeMessages(1101);
                this.f76416b.f76444a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.f76415a != null) {
                    this.f76415a.a();
                }
                this.f76416b.f76445b = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
