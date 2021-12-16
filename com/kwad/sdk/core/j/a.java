package com.kwad.sdk.core.j;

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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class a implements c, bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bc a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f58065b;

    /* renamed from: c  reason: collision with root package name */
    public Set<d> f58066c;

    /* renamed from: d  reason: collision with root package name */
    public final View f58067d;

    /* renamed from: e  reason: collision with root package name */
    public final int f58068e;

    public a(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58065b = new AtomicBoolean(false);
        this.f58067d = view;
        this.f58068e = i2;
        this.a = new bc(this);
    }

    private void a(boolean z) {
        Set<d> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65537, this, z) == null) || (set = this.f58066c) == null) {
            return;
        }
        for (d dVar : set) {
            if (dVar != null) {
                if (z) {
                    dVar.e();
                } else {
                    dVar.f();
                }
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
            this.a.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 666) {
            if (c()) {
                e();
            } else {
                f();
            }
            this.a.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            ae.a();
            if (dVar == null) {
                return;
            }
            if (c()) {
                dVar.e();
            } else {
                dVar.f();
            }
            if (this.f58066c == null) {
                this.f58066c = new HashSet();
            }
            this.f58066c.add(dVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void b(d dVar) {
        Set<d> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            ae.a();
            if (dVar == null || (set = this.f58066c) == null) {
                return;
            }
            set.remove(dVar);
        }
    }

    public abstract boolean c();

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? bb.a(this.f58067d, this.f58068e, false) : invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f58065b.getAndSet(true)) {
            return;
        }
        a(true);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f58065b.getAndSet(false)) {
            a(false);
        }
    }

    @CallSuper
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b();
            Set<d> set = this.f58066c;
            if (set != null) {
                set.clear();
            }
        }
    }
}
