package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class c extends View implements bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public a OO;
    public boolean OP;
    public final int OQ;
    public boolean Ou;
    public boolean Ov;

    /* loaded from: classes5.dex */
    public interface a {
        void em();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Ks = new bg(this);
        this.Kt = new AtomicBoolean(true);
        this.OQ = (int) (com.kwad.sdk.core.config.d.sk() * 100.0f);
        this.Kr = view2;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void pU() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.Ov) {
            this.Ks.removeCallbacksAndMessages(null);
            this.Ov = false;
        }
    }

    private void pV() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.OP && !this.Ov) {
            this.Ov = true;
            this.Ks.sendEmptyMessage(1);
        }
    }

    private void pY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.Kt.getAndSet(false);
        }
    }

    private void pZ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.Kt.getAndSet(true);
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                if (!com.kwad.sdk.b.kwai.a.a(this.Kr, this.OQ, false)) {
                    if (this.Ou) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (aVar = this.OO) != null) {
                    aVar.em();
                }
                this.Ks.sendEmptyMessageDelayed(2, 500L);
                return;
            }
            com.kwad.sdk.core.e.b.d("EmptyView", "handleMsg MSG_CHECKING");
            if (this.Ov) {
                if (!com.kwad.sdk.b.kwai.a.a(this.Kr, this.OQ, false)) {
                    this.Ks.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                pU();
                Message obtainMessage = this.Ks.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.Ks.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.e.b.d("EmptyView", "onAttachedToWindow:" + this);
            pV();
            this.Ou = false;
            pY();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.e.b.d("EmptyView", "onDetachedFromWindow" + this);
            pU();
            this.Ou = true;
            pZ();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.e.b.d("EmptyView", "onFinishTemporaryDetach:" + this.Kr.getParent());
            pY();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.e.b.d("EmptyView", "onStartTemporaryDetach:" + this.Kr.getParent());
            pZ();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.e.b.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            com.kwad.sdk.core.e.b.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
        }
    }

    public final void setNeedCheckingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.OP = z;
            if (!z && this.Ov) {
                pU();
            } else if (!z || this.Ov) {
            } else {
                pV();
            }
        }
    }

    public final void setViewCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.OO = aVar;
        }
    }
}
