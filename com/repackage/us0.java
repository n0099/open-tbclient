package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class us0 extends ms0 implements as0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ts0 b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us0(Map<String, String> map, Object obj) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.repackage.wr0
    public void a(boolean z) {
        ts0 ts0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (ts0Var = this.b) == null) {
            return;
        }
        ts0Var.k(z);
    }

    @Override // com.repackage.xr0
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null && PlayerEvent.ACTION_ON_COMPLETE.equals(str)) {
                this.a.P(0);
                ts0 ts0Var = new ts0(this.a, this.c);
                this.b = ts0Var;
                ts0Var.e();
                if (k()) {
                    if (this.b.i()) {
                        this.a.P(0);
                        this.a.v().y().y(true);
                        return true;
                    }
                    this.a.P(8);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.as0
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.c = obj;
        }
    }

    @Override // com.repackage.ms0
    public void f(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, er0Var) == null) {
        }
    }

    @Override // com.repackage.ms0
    public void g(er0 er0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, er0Var) == null) {
            String c2 = er0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == -552621273) {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == 851534116 && c2.equals(LayerEvent.ACTION_NIGHT_MODEL_CHANGED)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                a(false);
            } else if (c == 1) {
                a(true);
            } else if (c != 2) {
            } else {
                l(er0Var.d(17));
            }
        }
    }

    @Override // com.repackage.ms0
    public void h(er0 er0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, er0Var) == null) {
            String c2 = er0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -1759675333) {
                if (hashCode == -882902390 && c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1 && this.a.M() && this.b != null) {
                    if (!er0Var.d(4)) {
                        this.b.m();
                        return;
                    } else {
                        this.b.l();
                        return;
                    }
                }
                return;
            }
            this.a.P(8);
        }
    }

    @Override // com.repackage.ms0
    public void i(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            vt0 vt0Var = this.a;
            return (vt0Var == null || (o1 = vt0Var.v().o1()) == null || o1.getVideoAd() == null || o1.getVideoAd().fullItemAdData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(boolean z) {
        ts0 ts0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (ts0Var = this.b) == null) {
            return;
        }
        ts0Var.j(z);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.b == null) {
            return;
        }
        this.b = null;
    }

    @Override // com.repackage.wr0
    public void onDestroy() {
        vt0 vt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.b != null && (vt0Var = this.a) != null && vt0Var.M()) {
                this.b.f();
            }
            ts0 ts0Var = this.b;
            if (ts0Var != null) {
                ts0Var.c();
                m();
            }
            this.a = null;
        }
    }

    @Override // com.repackage.wr0
    public void onLayerRelease() {
        ts0 ts0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (ts0Var = this.b) == null) {
            return;
        }
        ts0Var.f();
    }
}
