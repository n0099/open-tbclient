package com.win.opensdk;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class G0 implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N0 f39579a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ O0 f39580b;

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
        this.f39580b = o0;
        this.f39579a = n0;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f39580b.f39609b || !this.f39580b.a(this.f39580b.f39608a)) {
                    return;
                }
                this.f39580b.f39612e.removeMessages(1101);
                this.f39580b.f39608a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.f39579a != null) {
                    this.f39579a.a();
                }
                this.f39580b.f39609b = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
