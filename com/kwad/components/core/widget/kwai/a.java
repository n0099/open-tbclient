package com.kwad.components.core.widget.kwai;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bc;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class a implements com.kwad.sdk.core.g.a, bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bc a;
    public final AtomicBoolean b;
    public Set<com.kwad.sdk.core.g.b> c;
    public final View d;
    public final int e;

    public a(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new AtomicBoolean(false);
        this.d = view2;
        this.e = i;
        this.a = new bc(this);
    }

    private void a(boolean z) {
        Set<com.kwad.sdk.core.g.b> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65537, this, z) == null) || (set = this.c) == null) {
            return;
        }
        for (com.kwad.sdk.core.g.b bVar : set) {
            if (bVar != null) {
                if (z) {
                    bVar.m_();
                } else {
                    bVar.b();
                }
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.b.getAndSet(true)) {
            return;
        }
        a(true);
    }

    private void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.b.getAndSet(false)) {
            a(false);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 666) {
            if (a()) {
                g();
            } else {
                h();
            }
            this.a.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final void a(com.kwad.sdk.core.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            ad.a();
            if (bVar == null) {
                return;
            }
            if (a()) {
                bVar.m_();
            } else {
                bVar.b();
            }
            if (this.c == null) {
                this.c = new HashSet();
            }
            this.c.add(bVar);
        }
    }

    public abstract boolean a();

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
            this.a.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final void b(com.kwad.sdk.core.g.b bVar) {
        Set<com.kwad.sdk.core.g.b> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            ad.a();
            if (bVar == null || (set = this.c) == null) {
                return;
            }
            set.remove(bVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.b.kwai.a.a(this.d, this.e, false) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.g.a
    @MainThread
    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b.get() : invokeV.booleanValue;
    }

    @CallSuper
    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            Set<com.kwad.sdk.core.g.b> set = this.c;
            if (set != null) {
                set.clear();
            }
        }
    }
}
