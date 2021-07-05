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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class a extends View implements ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0437a f36450a;

    /* renamed from: b  reason: collision with root package name */
    public View f36451b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36452c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36453d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36454e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f36455f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f36456g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0437a {
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
        this.f36455f = new ap(this);
        this.f36456g = new AtomicBoolean(true);
        this.f36451b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0437a interfaceC0437a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f36456g.getAndSet(false) && (interfaceC0437a = this.f36450a) != null) {
            interfaceC0437a.a();
        }
    }

    private void b() {
        InterfaceC0437a interfaceC0437a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f36456g.getAndSet(true) || (interfaceC0437a = this.f36450a) == null) {
            return;
        }
        interfaceC0437a.b();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f36453d) {
            this.f36455f.removeCallbacksAndMessages(null);
            this.f36453d = false;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, this) == null) && this.f36454e && !this.f36453d) {
            this.f36453d = true;
            this.f36455f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0437a interfaceC0437a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
                if (this.f36453d) {
                    if (!ao.a(this.f36451b, 30, false)) {
                        this.f36455f.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    c();
                    Message obtainMessage = this.f36455f.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 1000;
                    this.f36455f.sendMessageDelayed(obtainMessage, 1000L);
                }
            } else if (i2 != 2) {
            } else {
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
                if (!ao.a(this.f36451b, 30, false)) {
                    if (this.f36452c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && (interfaceC0437a = this.f36450a) != null) {
                    interfaceC0437a.a(this.f36451b);
                }
                this.f36455f.sendEmptyMessageDelayed(2, 500L);
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
            this.f36452c = false;
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
            this.f36452c = true;
            b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f36451b.getParent());
            a();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f36451b.getParent());
            b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
            InterfaceC0437a interfaceC0437a = this.f36450a;
            if (interfaceC0437a != null) {
                interfaceC0437a.a(z);
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
            this.f36454e = z;
            if (!z && this.f36453d) {
                c();
            } else if (!z || this.f36453d) {
            } else {
                d();
            }
        }
    }

    public void setViewCallback(InterfaceC0437a interfaceC0437a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC0437a) == null) {
            this.f36450a = interfaceC0437a;
        }
    }
}
