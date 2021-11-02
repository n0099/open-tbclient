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
/* loaded from: classes2.dex */
public class a extends View implements aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1909a f64930a;

    /* renamed from: b  reason: collision with root package name */
    public View f64931b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64932c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64933d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64934e;

    /* renamed from: f  reason: collision with root package name */
    public final aw f64935f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f64936g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1909a {
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
        this.f64935f = new aw(this);
        this.f64936g = new AtomicBoolean(true);
        this.f64931b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC1909a interfaceC1909a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f64936g.getAndSet(false) && (interfaceC1909a = this.f64930a) != null) {
            interfaceC1909a.a();
        }
    }

    private void b() {
        InterfaceC1909a interfaceC1909a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f64936g.getAndSet(true) || (interfaceC1909a = this.f64930a) == null) {
            return;
        }
        interfaceC1909a.b();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f64933d) {
            this.f64935f.removeCallbacksAndMessages(null);
            this.f64933d = false;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f64934e && !this.f64933d) {
            this.f64933d = true;
            this.f64935f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        InterfaceC1909a interfaceC1909a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
                if (this.f64933d) {
                    if (!av.a(this.f64931b, 30, false)) {
                        this.f64935f.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    c();
                    Message obtainMessage = this.f64935f.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 1000;
                    this.f64935f.sendMessageDelayed(obtainMessage, 1000L);
                }
            } else if (i2 != 2) {
            } else {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
                if (!av.a(this.f64931b, 30, false)) {
                    if (this.f64932c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (interfaceC1909a = this.f64930a) != null) {
                    interfaceC1909a.a(this.f64931b);
                }
                this.f64935f.sendEmptyMessageDelayed(2, 500L);
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
            this.f64932c = false;
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
            this.f64932c = true;
            b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f64931b.getParent());
            a();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f64931b.getParent());
            b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
            InterfaceC1909a interfaceC1909a = this.f64930a;
            if (interfaceC1909a != null) {
                interfaceC1909a.a(z);
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
            this.f64934e = z;
            if (!z && this.f64933d) {
                c();
            } else if (!z || this.f64933d) {
            } else {
                d();
            }
        }
    }

    public void setViewCallback(InterfaceC1909a interfaceC1909a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1909a) == null) {
            this.f64930a = interfaceC1909a;
        }
    }
}
