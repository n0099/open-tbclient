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
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class c extends View implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public View b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final bc f;
    public final AtomicBoolean g;
    public final int h;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
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
        this.f = new bc(this);
        this.g = new AtomicBoolean(true);
        this.h = (int) (com.kwad.sdk.core.config.d.W() * 100.0f);
        this.b = view2;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.g.getAndSet(false);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.g.getAndSet(true);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.d) {
            this.f.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.e && !this.d) {
            this.d = true;
            this.f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public final void a(Message message) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                if (!com.kwad.sdk.b.kwai.a.a(this.b, this.h, false)) {
                    if (this.c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (aVar = this.a) != null) {
                    aVar.a();
                }
                this.f.sendEmptyMessageDelayed(2, 500L);
                return;
            }
            com.kwad.sdk.core.d.b.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.d) {
                if (!com.kwad.sdk.b.kwai.a.a(this.b, this.h, false)) {
                    this.f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.b.a("EmptyView", "onAttachedToWindow:" + this);
            d();
            this.c = false;
            a();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.b.a("EmptyView", "onDetachedFromWindow" + this);
            c();
            this.c = true;
            b();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.b.a("EmptyView", "onFinishTemporaryDetach:" + this.b.getParent());
            a();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.b.a("EmptyView", "onStartTemporaryDetach:" + this.b.getParent());
            b();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.b.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            com.kwad.sdk.core.d.b.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
        }
    }

    public final void setNeedCheckingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
            if (!z && this.d) {
                c();
            } else if (!z || this.d) {
            } else {
                d();
            }
        }
    }

    public final void setViewCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
