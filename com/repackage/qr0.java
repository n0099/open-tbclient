package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class qr0 extends sr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public ViewGroup b;
    @JvmField
    public r41 c;
    @JvmField
    public boolean d;

    /* loaded from: classes7.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr0 a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(qr0 qr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr0Var;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = null;
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public qr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.mr0
    public void k(rs0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g = event.g(1);
                if ((g == 904 || g == 956) && x() != null) {
                    z();
                }
            }
        }
    }

    @Override // com.repackage.mr0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.m();
            this.b = null;
            r41 r41Var = this.c;
            if (r41Var != null) {
                r41Var.k();
            }
        }
    }

    public void w() {
        r41 r41Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (r41Var = this.c) == null) {
            return;
        }
        r41Var.c();
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0b48);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d && this.b != null) {
            if (!r().V0()) {
                s().X(true, true);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.obfuscated_res_0x7f06084a);
            n41 n41Var = (n41) BubbleManager.u(n41.class);
            n41Var.j(x(), this.b);
            n41Var.q(y());
            n41Var.r(-1, -1);
            n41Var.l(color, color);
            n41Var.m(1, 12.0f);
            n41Var.p(-2.0f);
            n41Var.n(BubblePosition.DOWN);
            n41Var.k(5000);
            n41Var.i(true);
            n41Var.o(new a(this));
            r41 h = n41Var.h();
            this.c = h;
            if (h != null) {
                h.p();
            }
            this.d = false;
            s().U(5000);
        }
    }
}
