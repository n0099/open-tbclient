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
import com.repackage.zp0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class bu0<T extends ViewGroup, S extends zp0> extends rt0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T e;
    public final ArrayList<S> f;

    public bu0() {
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

    @Override // com.repackage.rt0
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

    @Override // com.repackage.rt0
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

    @Override // com.repackage.rt0
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
        gx0.b(this.f, s);
    }

    public void L(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s) == null) {
            pw0.k(s.getContentView());
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

    public void N(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
            Iterator<S> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().k(er0Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eu0
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

    @Override // com.repackage.rt0, com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, er0Var) == null) {
            super.d(er0Var);
            N(er0Var);
        }
    }

    @Override // com.repackage.fs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new int[]{4, 5, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.rt0, com.repackage.fs0
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

    @Override // com.repackage.rt0, com.repackage.fs0
    public void j(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, er0Var) == null) {
            super.j(er0Var);
            N(er0Var);
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void k(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, er0Var) == null) {
            super.k(er0Var);
            N(er0Var);
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void n(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, er0Var) == null) {
            super.n(er0Var);
            N(er0Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
        }
    }

    @Override // com.repackage.rt0, com.repackage.eu0
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

    @Override // com.repackage.rt0, com.repackage.eu0
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

    @Override // com.repackage.rt0, com.repackage.fs0
    public void r(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, er0Var) == null) {
            super.r(er0Var);
            N(er0Var);
        }
    }
}
