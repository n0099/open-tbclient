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
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public final class a extends KSFrameLayout implements bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View Kr;
    public final bg Ks;
    public final int OA;
    public InterfaceC0620a Ot;
    public boolean Ou;
    public boolean Ov;
    public int Ow;
    public boolean Ox;
    public long Oy;
    public final float Oz;

    /* renamed from: com.kwad.components.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0620a {
        void em();
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
        this.Ks = new bg(this);
        this.Ow = 5;
        this.Kr = view2;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float sk = com.kwad.sdk.core.config.d.sk();
        this.Oz = sk;
        setVisiblePercent(sk);
        float sl = com.kwad.sdk.core.config.d.sl();
        this.OA = (int) ((sl < 0.0f ? 1.0f : sl) * 1000.0f);
    }

    private void pT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Message obtainMessage = this.Ks.obtainMessage();
            obtainMessage.what = 2;
            this.Ks.sendMessageDelayed(obtainMessage, this.OA);
        }
    }

    private void pU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.Ks.removeCallbacksAndMessages(null);
            this.Ov = false;
        }
    }

    private void pV() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.Ov) {
            return;
        }
        this.Ov = true;
        this.Ks.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.Ou) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.Kr, (int) (this.Oz * 100.0f), false)) {
                this.Ow = 5;
                this.Ks.sendEmptyMessage(1);
                return;
            }
            InterfaceC0620a interfaceC0620a = this.Ot;
            if (interfaceC0620a != null) {
                interfaceC0620a.em();
                return;
            }
            return;
        }
        com.kwad.sdk.core.e.b.d("AdExposureView", "handleMsg MSG_CHECKING");
        if (!com.kwad.sdk.b.kwai.a.a(this.Kr, (int) (this.Oz * 100.0f), false)) {
            bg bgVar = this.Ks;
            int i2 = this.Ow;
            this.Ow = i2 - 1;
            bgVar.sendEmptyMessageDelayed(1, i2 > 0 ? 100L : 500L);
            return;
        }
        pU();
        if (this.OA != 0 && !this.Ox) {
            this.Ox = true;
            this.Oy = System.currentTimeMillis();
            pT();
            return;
        }
        InterfaceC0620a interfaceC0620a2 = this.Ot;
        if (interfaceC0620a2 != null) {
            interfaceC0620a2.em();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.am();
            this.Ow = 5;
            this.Ou = false;
            this.Ox = false;
            pV();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.an();
            pU();
            this.Ow = 0;
            this.Oy = 0L;
            this.Ou = true;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        InterfaceC0620a interfaceC0620a;
        InterfaceC0620a interfaceC0620a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.k(view2);
            if (this.OA == 0 && (interfaceC0620a2 = this.Ot) != null) {
                interfaceC0620a2.em();
            } else if (!this.Ox) {
                this.Ox = true;
                this.Oy = System.currentTimeMillis();
                pU();
                pT();
            } else if (System.currentTimeMillis() - this.Oy <= this.OA || (interfaceC0620a = this.Ot) == null) {
            } else {
                interfaceC0620a.em();
                pU();
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.e.b.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        }
    }

    public final void pW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pV();
        }
    }

    public final void setViewCallback(InterfaceC0620a interfaceC0620a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0620a) == null) {
            this.Ot = interfaceC0620a;
        }
    }
}
