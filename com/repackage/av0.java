package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public abstract class av0 implements cv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<ws0>> a;
    @Nullable
    public xs0 b;
    @Nullable
    public List<xs0> c;
    @Nullable
    public List<zs0> d;

    public av0() {
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
        this.a = new ConcurrentHashMap<>();
    }

    @Override // com.repackage.cv0
    @Deprecated
    public void a(@Nullable xs0 xs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xs0Var) == null) {
            this.b = xs0Var;
        }
    }

    @Override // com.repackage.cv0
    public void b(@NonNull zs0 zs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zs0Var) == null) {
            j(zs0Var);
        }
    }

    @Override // com.repackage.cv0
    public void c(int i, @NonNull ws0 ws0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ws0Var) == null) {
            CopyOnWriteArrayList<ws0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(ws0Var)) {
                int expectOrder = ws0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(ws0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, ws0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), ws0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.repackage.cv0
    public void d(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vr0Var) == null) {
            String type = getType();
            ex0.i(type, System.identityHashCode(this) + " notifyEvent " + vr0Var);
            if (vr0Var.j() == 1) {
                if (i(vr0Var)) {
                    return;
                }
                g(vr0Var);
                vr0Var.o();
                return;
            }
            l(vr0Var);
        }
    }

    @Override // com.repackage.cv0
    public void e(ws0 ws0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ws0Var) == null) {
            for (CopyOnWriteArrayList<ws0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(ws0Var);
            }
        }
    }

    @Override // com.repackage.cv0
    public void f(@NonNull zs0 zs0Var) {
        List<zs0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, zs0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(zs0Var);
    }

    public void g(vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vr0Var) == null) {
            k(vr0Var);
            h(vr0Var);
            CopyOnWriteArrayList<ws0> copyOnWriteArrayList = this.a.get(Integer.valueOf(vr0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<ws0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ws0 next = it.next();
                if (!vr0Var.b(next)) {
                    switch (vr0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(vr0Var);
                            continue;
                        case 1:
                            next.n(vr0Var);
                            continue;
                        case 2:
                            next.q(vr0Var);
                            continue;
                        case 3:
                            next.k(vr0Var);
                            continue;
                        case 4:
                            next.d(vr0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) vr0Var.f(2), (PlayerStatus) vr0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof ew0) {
                                ((ew0) next).g(vr0Var);
                                break;
                            } else {
                                next.a(vr0Var);
                                continue;
                            }
                        case 8:
                            next.j(vr0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(vr0 vr0Var) {
        List<zs0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vr0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (zs0 zs0Var : list) {
            zs0Var.a(vr0Var);
        }
    }

    public boolean i(vr0 vr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vr0Var)) == null) {
            xs0 xs0Var = this.b;
            if (xs0Var != null && xs0Var.getInterceptorLayer() != vr0Var.k() && this.b.e(vr0Var)) {
                ex0.b("AbsMessenger", "isNeedIntercept() = true, event = " + vr0Var);
                vr0Var.o();
                return true;
            }
            List<xs0> list = this.c;
            if (list != null) {
                for (xs0 xs0Var2 : list) {
                    if (xs0Var2.getInterceptorLayer() != vr0Var.k() && xs0Var2.e(vr0Var)) {
                        ex0.b("AbsMessenger", "isNeedIntercept() = true, event = " + vr0Var);
                        vr0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(zs0 zs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zs0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(zs0Var)) {
                return;
            }
            int expectOrder = zs0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(zs0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, zs0Var);
            } else if (expectOrder != 2) {
            } else {
                List<zs0> list = this.d;
                list.add(list.size(), zs0Var);
            }
        }
    }

    public final void k(vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vr0Var) == null) {
            if (vr0Var.i() == 0) {
                String type = getType();
                ex0.b(type, System.identityHashCode(this) + ": dispatch event :" + vr0Var);
                return;
            }
            String type2 = getType();
            ex0.i(type2, System.identityHashCode(this) + ": dispatch event :" + vr0Var);
        }
    }

    public abstract void l(@NonNull vr0 vr0Var);

    @Override // com.repackage.cv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<zs0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<xs0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
