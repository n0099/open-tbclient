package com.kwad.components.core.widget.kwai;

import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bg;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class a implements com.kwad.sdk.core.h.a, bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bg Ks;
    public final AtomicBoolean PG;
    public Set PH;
    public final int PI;
    public final View mRootView;

    public a(View view2, int i) {
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
        this.PG = new AtomicBoolean(false);
        this.mRootView = view2;
        this.PI = i;
        this.Ks = new bg(this);
    }

    private void aH(boolean z) {
        Set<com.kwad.sdk.core.h.b> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65537, this, z) == null) || (set = this.PH) == null) {
            return;
        }
        for (com.kwad.sdk.core.h.b bVar : set) {
            if (bVar != null) {
                if (z) {
                    bVar.aR();
                } else {
                    bVar.aS();
                }
            }
        }
    }

    private void qk() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.PG.getAndSet(true)) {
            return;
        }
        aH(true);
    }

    private void ql() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.PG.getAndSet(false)) {
            aH(false);
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 666) {
            if (dK()) {
                qk();
            } else {
                ql();
            }
            this.Ks.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    public final void a(com.kwad.sdk.core.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            af.checkUiThread();
            if (bVar == null) {
                return;
            }
            if (dK()) {
                bVar.aR();
            } else {
                bVar.aS();
            }
            if (this.PH == null) {
                this.PH = new HashSet();
            }
            this.PH.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    public final void b(com.kwad.sdk.core.h.b bVar) {
        Set set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            af.checkUiThread();
            if (bVar == null || (set = this.PH) == null) {
                return;
            }
            set.remove(bVar);
        }
    }

    public abstract boolean dK();

    public final void qi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.Ks.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
            this.Ks.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        }
    }

    public final void qj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.Ks.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    public final boolean qm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.PG.get() : invokeV.booleanValue;
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            qj();
            Set set = this.PH;
            if (set != null) {
                set.clear();
            }
        }
    }
}
