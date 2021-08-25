package com.kwad.sdk.core.page.widget;

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
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class a extends View implements aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1993a f71939a;

    /* renamed from: b  reason: collision with root package name */
    public View f71940b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71941c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71942d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71943e;

    /* renamed from: f  reason: collision with root package name */
    public final aw f71944f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f71945g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1993a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71944f = new aw(this);
        this.f71945g = new AtomicBoolean(true);
        this.f71940b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC1993a interfaceC1993a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f71945g.getAndSet(false) && (interfaceC1993a = this.f71939a) != null) {
            interfaceC1993a.a();
        }
    }

    private void b() {
        InterfaceC1993a interfaceC1993a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f71945g.getAndSet(true) || (interfaceC1993a = this.f71939a) == null) {
            return;
        }
        interfaceC1993a.b();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f71942d) {
            this.f71944f.removeCallbacksAndMessages(null);
            this.f71942d = false;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f71943e && !this.f71942d) {
            this.f71942d = true;
            this.f71944f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        InterfaceC1993a interfaceC1993a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
                if (this.f71942d) {
                    if (!av.a(this.f71940b, 30, false)) {
                        this.f71944f.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    c();
                    Message obtainMessage = this.f71944f.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 1000;
                    this.f71944f.sendMessageDelayed(obtainMessage, 1000L);
                }
            } else if (i2 != 2) {
            } else {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
                if (!av.a(this.f71940b, 30, false)) {
                    if (this.f71941c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (interfaceC1993a = this.f71939a) != null) {
                    interfaceC1993a.a(this.f71940b);
                }
                this.f71944f.sendEmptyMessageDelayed(2, 500L);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
            d();
            this.f71941c = false;
            a();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
            c();
            this.f71941c = true;
            b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f71940b.getParent());
            a();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f71940b.getParent());
            b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
            InterfaceC1993a interfaceC1993a = this.f71939a;
            if (interfaceC1993a != null) {
                interfaceC1993a.a(z);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
        }
    }

    public void setNeedCheckingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f71943e = z;
            if (!z && this.f71942d) {
                c();
            } else if (!z || this.f71942d) {
            } else {
                d();
            }
        }
    }

    public void setViewCallback(InterfaceC1993a interfaceC1993a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1993a) == null) {
            this.f71939a = interfaceC1993a;
        }
    }
}
