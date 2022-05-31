package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.tail.AdVideoTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ts0 extends ls0 implements AdVideoTailFrameView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoTailFrameView b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts0(vt0 vt0Var, Object obj) {
        super(vt0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vt0Var, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vt0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = this.c instanceof xm0;
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void b() {
        vt0 vt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object obj = this.c;
            if (obj instanceof xm0) {
                if ("ad_full_video".equals(((xm0) obj).n)) {
                    if (this.a != null && h() && this.a.M()) {
                        if (this.a.v().V0()) {
                            this.a.G(vq0.w(PlayerEvent.ACTION_ON_COMPLETE));
                        } else {
                            this.a.v().y().G(0);
                        }
                    }
                } else if ("ad_append_video".equals(((xm0) this.c).n) && (vt0Var = this.a) != null && vt0Var.M()) {
                    this.b.v(ClogBuilder.LogType.CLOSE.type, "", "");
                    this.a.P(8);
                    this.a.N();
                    this.a.G(uq0.w("layer_event_ad_finish"));
                    if (this.a.v().a0()) {
                        return;
                    }
                    this.a.G(vq0.w(PlayerEvent.ACTION_ON_COMPLETE));
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null || this.c == null) {
            return;
        }
        g();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        if (this.b == null) {
            AdVideoTailFrameView adVideoTailFrameView = new AdVideoTailFrameView(this.a.getContentView().getContext(), this.a, d());
            this.b = adVideoTailFrameView;
            this.a.L(adVideoTailFrameView);
        }
        this.b.n(d());
        this.b.setCallBack(this);
        Object obj = this.c;
        if (obj != null) {
            this.b.setData(obj);
            this.b.w();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vt0 vt0Var = this.a;
            return (vt0Var == null || vt0Var.v().o1() == null || this.a.v().o1().getVideoAd() == null || this.a.v().o1().getVideoAd().fullItemAdData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdVideoTailFrameView adVideoTailFrameView = this.b;
            return adVideoTailFrameView != null && adVideoTailFrameView.r();
        }
        return invokeV.booleanValue;
    }

    public void j(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.t(z);
    }

    public void k(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.n(z);
    }

    public void l() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.x();
    }

    public void m() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (adVideoTailFrameView = this.b) == null) {
            return;
        }
        adVideoTailFrameView.u();
    }
}
