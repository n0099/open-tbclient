package com.kwad.sdk.core.i;

import android.os.Message;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.w;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a implements b, ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f36341a;

    /* renamed from: b  reason: collision with root package name */
    public final ap f36342b;

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f36343c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f36344d;

    /* renamed from: e  reason: collision with root package name */
    public View f36345e;

    /* renamed from: f  reason: collision with root package name */
    public int f36346f;

    /* renamed from: g  reason: collision with root package name */
    public String f36347g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36341a = new AtomicBoolean(false);
        this.f36344d = ksFragment;
        this.f36345e = view;
        this.f36346f = i2;
        this.f36342b = new ap(this);
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, ksFragment)) == null) ? (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true : invokeL.booleanValue;
    }

    private void c(boolean z) {
        Set<c> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (set = this.f36343c) == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.c_();
                } else {
                    cVar.b();
                }
            }
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? ao.a(this.f36345e, this.f36346f, false) : invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || this.f36341a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.f36347g);
        c(true);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.f36341a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.f36347g);
            c(false);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36342b.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 666) {
            KsFragment ksFragment = this.f36344d;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f36347g = "message fragment";
            } else {
                this.f36347g = "message view";
                if (g()) {
                    h();
                    this.f36342b.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
                }
            }
            i();
            this.f36342b.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            w.a();
            if (cVar == null) {
                return;
            }
            if (this.f36343c == null) {
                this.f36343c = new HashSet();
            }
            if (this.f36341a.get()) {
                cVar.c_();
            } else {
                cVar.b();
            }
            this.f36343c.add(cVar);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f36342b.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        Set<c> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            w.a();
            if (cVar == null || (set = this.f36343c) == null) {
                return;
            }
            set.remove(cVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "onFragmentPause");
            this.f36347g = "onFragmentPause";
            i();
        }
    }

    @MainThread
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36341a.get() : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b();
            Set<c> set = this.f36343c;
            if (set != null) {
                set.clear();
            }
            this.f36344d = null;
        }
    }
}
