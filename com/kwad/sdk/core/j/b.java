package com.kwad.sdk.core.j;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f34835b;

    /* renamed from: c  reason: collision with root package name */
    public KsFragment f34836c;

    /* renamed from: d  reason: collision with root package name */
    public String f34837d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull KsFragment ksFragment, @NonNull View view, int i2) {
        super(view, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34835b = new AtomicBoolean(false);
        this.f34836c = ksFragment;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, ksFragment)) == null) ? (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 666) {
            KsFragment ksFragment = this.f34836c;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.d("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f34837d = "message fragment";
            } else {
                this.f34837d = "message view";
                if (c()) {
                    d();
                    this.f34830a.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
                }
            }
            e();
            this.f34830a.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.kwad.sdk.core.j.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
            this.f34836c = null;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
            this.f34837d = "onFragmentPause";
            e();
        }
    }
}
