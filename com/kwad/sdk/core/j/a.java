package com.kwad.sdk.core.j;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a implements c, aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final aw f34830a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f34831b;

    /* renamed from: c  reason: collision with root package name */
    public Set<d> f34832c;

    /* renamed from: d  reason: collision with root package name */
    public final View f34833d;

    /* renamed from: e  reason: collision with root package name */
    public final int f34834e;

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
        this.f34831b = new AtomicBoolean(false);
        this.f34833d = view;
        this.f34834e = i2;
        this.f34830a = new aw(this);
    }

    private void a(boolean z) {
        Set<d> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65537, this, z) == null) || (set = this.f34832c) == null) {
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
            this.f34830a.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
            this.f34830a.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            aa.a();
            if (dVar == null) {
                return;
            }
            if (this.f34832c == null) {
                this.f34832c = new HashSet();
            }
            if (this.f34831b.get()) {
                dVar.e();
            } else {
                dVar.f();
            }
            this.f34832c.add(dVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f34830a.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void b(d dVar) {
        Set<d> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            aa.a();
            if (dVar == null || (set = this.f34832c) == null) {
                return;
            }
            set.remove(dVar);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? av.a(this.f34833d, this.f34834e, false) : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f34831b.getAndSet(true)) {
            return;
        }
        a(true);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f34831b.getAndSet(false)) {
            a(false);
        }
    }

    @CallSuper
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            Set<d> set = this.f34832c;
            if (set != null) {
                set.clear();
            }
        }
    }
}
