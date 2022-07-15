package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class a extends KSFrameLayout implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0527a a;
    public final View b;
    public boolean c;
    public boolean d;
    public final bc e;
    public int f;
    public boolean g;
    public long h;
    public final float i;
    public final int j;

    /* renamed from: com.kwad.components.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0527a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new bc(this);
        this.f = 5;
        this.b = view2;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float W = com.kwad.sdk.core.config.d.W();
        this.i = W;
        setVisiblePercent(W);
        float X = com.kwad.sdk.core.config.d.X();
        this.j = (int) ((X < 0.0f ? 1.0f : X) * 1000.0f);
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.what = 2;
            this.e.sendMessageDelayed(obtainMessage, this.j);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.e.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.d) {
            return;
        }
        this.d = true;
        this.e.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.c) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.b, (int) (this.i * 100.0f), false)) {
                this.f = 5;
                this.e.sendEmptyMessage(1);
                return;
            }
            InterfaceC0527a interfaceC0527a = this.a;
            if (interfaceC0527a != null) {
                interfaceC0527a.a();
                return;
            }
            return;
        }
        com.kwad.sdk.core.d.b.a("AdExposureView", "handleMsg MSG_CHECKING");
        if (!com.kwad.sdk.b.kwai.a.a(this.b, (int) (this.i * 100.0f), false)) {
            bc bcVar = this.e;
            int i2 = this.f;
            this.f = i2 - 1;
            bcVar.sendEmptyMessageDelayed(1, i2 > 0 ? 100L : 500L);
            return;
        }
        e();
        if (this.j != 0 && !this.g) {
            this.g = true;
            this.h = System.currentTimeMillis();
            d();
            return;
        }
        InterfaceC0527a interfaceC0527a2 = this.a;
        if (interfaceC0527a2 != null) {
            interfaceC0527a2.a();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void a(View view2) {
        InterfaceC0527a interfaceC0527a;
        InterfaceC0527a interfaceC0527a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.a(view2);
            if (this.j == 0 && (interfaceC0527a2 = this.a) != null) {
                interfaceC0527a2.a();
            } else if (!this.g) {
                this.g = true;
                this.h = System.currentTimeMillis();
                e();
                d();
            } else if (System.currentTimeMillis() - this.h <= this.j || (interfaceC0527a = this.a) == null) {
            } else {
                interfaceC0527a.a();
                e();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a_();
            e();
            this.f = 0;
            this.h = 0L;
            this.c = true;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b_();
            this.f = 5;
            this.c = false;
            this.g = false;
            f();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.b.a("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        }
    }

    public final void setViewCallback(InterfaceC0527a interfaceC0527a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0527a) == null) {
            this.a = interfaceC0527a;
        }
    }
}
