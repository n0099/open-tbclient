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
/* loaded from: classes6.dex */
public class a extends View implements aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0422a f34991a;

    /* renamed from: b  reason: collision with root package name */
    public View f34992b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34993c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34994d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34995e;

    /* renamed from: f  reason: collision with root package name */
    public final aw f34996f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f34997g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0422a {
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
        this.f34996f = new aw(this);
        this.f34997g = new AtomicBoolean(true);
        this.f34992b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0422a interfaceC0422a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f34997g.getAndSet(false) && (interfaceC0422a = this.f34991a) != null) {
            interfaceC0422a.a();
        }
    }

    private void b() {
        InterfaceC0422a interfaceC0422a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f34997g.getAndSet(true) || (interfaceC0422a = this.f34991a) == null) {
            return;
        }
        interfaceC0422a.b();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f34994d) {
            this.f34996f.removeCallbacksAndMessages(null);
            this.f34994d = false;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f34995e && !this.f34994d) {
            this.f34994d = true;
            this.f34996f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        InterfaceC0422a interfaceC0422a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
                if (this.f34994d) {
                    if (!av.a(this.f34992b, 30, false)) {
                        this.f34996f.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    c();
                    Message obtainMessage = this.f34996f.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 1000;
                    this.f34996f.sendMessageDelayed(obtainMessage, 1000L);
                }
            } else if (i2 != 2) {
            } else {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
                if (!av.a(this.f34992b, 30, false)) {
                    if (this.f34993c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (interfaceC0422a = this.f34991a) != null) {
                    interfaceC0422a.a(this.f34992b);
                }
                this.f34996f.sendEmptyMessageDelayed(2, 500L);
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
            this.f34993c = false;
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
            this.f34993c = true;
            b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f34992b.getParent());
            a();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f34992b.getParent());
            b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
            InterfaceC0422a interfaceC0422a = this.f34991a;
            if (interfaceC0422a != null) {
                interfaceC0422a.a(z);
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
            this.f34995e = z;
            if (!z && this.f34994d) {
                c();
            } else if (!z || this.f34994d) {
            } else {
                d();
            }
        }
    }

    public void setViewCallback(InterfaceC0422a interfaceC0422a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC0422a) == null) {
            this.f34991a = interfaceC0422a;
        }
    }
}
