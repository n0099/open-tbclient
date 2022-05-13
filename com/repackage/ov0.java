package com.repackage;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mr0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class ov0<T extends ViewGroup, S extends mr0> extends ev0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T e;
    public final ArrayList<S> f;

    public ov0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList<>();
    }

    @Override // com.repackage.ev0
    public void A(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.A(message);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().h(message);
            }
        }
    }

    @Override // com.repackage.ev0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            P();
            R();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                S next = it.next();
                next.q(this);
                next.i();
                if (next.d()) {
                    L(next);
                }
            }
            Q(this.e);
        }
    }

    @Override // com.repackage.ev0
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
        }
    }

    public void K(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, s) == null) || this.f.contains(s)) {
            return;
        }
        ty0.b(this.f, s);
    }

    public void L(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s) == null) {
            cy0.k(s.getContentView());
            if (M(s.f())) {
                this.e.addView(s.getContentView(), s.f());
            } else {
                this.e.addView(s.getContentView());
            }
        }
    }

    public boolean M(@Nullable ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) {
            if (getContentView() instanceof FrameLayout) {
                return layoutParams instanceof FrameLayout.LayoutParams;
            }
            if (getContentView() instanceof LinearLayout) {
                return layoutParams instanceof LinearLayout.LayoutParams;
            }
            if (getContentView() instanceof RelativeLayout) {
                return layoutParams instanceof RelativeLayout.LayoutParams;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void N(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rs0Var) == null) {
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().k(rs0Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rv0
    @NonNull
    /* renamed from: O */
    public T getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (T) invokeV.objValue;
    }

    public abstract void P();

    public void Q(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
        }
    }

    public abstract void R();

    @Override // com.repackage.ev0, com.repackage.st0
    public void d(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rs0Var) == null) {
            super.d(rs0Var);
            N(rs0Var);
        }
    }

    @Override // com.repackage.st0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new int[]{4, 5, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().n(playerStatus, playerStatus2);
            }
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void j(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rs0Var) == null) {
            super.j(rs0Var);
            N(rs0Var);
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void k(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rs0Var) == null) {
            super.k(rs0Var);
            N(rs0Var);
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void n(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rs0Var) == null) {
            super.n(rs0Var);
            N(rs0Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
        }
    }

    @Override // com.repackage.ev0, com.repackage.rv0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onContainerDetach();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    @Override // com.repackage.ev0, com.repackage.rv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().m();
            }
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void r(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rs0Var) == null) {
            super.r(rs0Var);
            N(rs0Var);
        }
    }
}
