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
/* loaded from: classes6.dex */
public abstract class nu0 implements pu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<js0>> a;
    @Nullable
    public ks0 b;
    @Nullable
    public List<ks0> c;
    @Nullable
    public List<ms0> d;

    public nu0() {
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

    @Override // com.repackage.pu0
    @Deprecated
    public void a(@Nullable ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ks0Var) == null) {
            this.b = ks0Var;
        }
    }

    @Override // com.repackage.pu0
    public void b(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms0Var) == null) {
            j(ms0Var);
        }
    }

    @Override // com.repackage.pu0
    public void c(int i, @NonNull js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, js0Var) == null) {
            CopyOnWriteArrayList<js0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(js0Var)) {
                int expectOrder = js0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(js0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, js0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), js0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.repackage.pu0
    public void d(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ir0Var) == null) {
            String type = getType();
            rw0.i(type, System.identityHashCode(this) + " notifyEvent " + ir0Var);
            if (ir0Var.j() == 1) {
                if (i(ir0Var)) {
                    return;
                }
                g(ir0Var);
                ir0Var.o();
                return;
            }
            l(ir0Var);
        }
    }

    @Override // com.repackage.pu0
    public void e(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, js0Var) == null) {
            for (CopyOnWriteArrayList<js0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(js0Var);
            }
        }
    }

    @Override // com.repackage.pu0
    public void f(@NonNull ms0 ms0Var) {
        List<ms0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ms0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(ms0Var);
    }

    public void g(ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ir0Var) == null) {
            k(ir0Var);
            h(ir0Var);
            CopyOnWriteArrayList<js0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ir0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<js0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                js0 next = it.next();
                if (!ir0Var.b(next)) {
                    switch (ir0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(ir0Var);
                            continue;
                        case 1:
                            next.n(ir0Var);
                            continue;
                        case 2:
                            next.q(ir0Var);
                            continue;
                        case 3:
                            next.k(ir0Var);
                            continue;
                        case 4:
                            next.d(ir0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) ir0Var.f(2), (PlayerStatus) ir0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof rv0) {
                                ((rv0) next).g(ir0Var);
                                break;
                            } else {
                                next.a(ir0Var);
                                continue;
                            }
                        case 8:
                            next.j(ir0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(ir0 ir0Var) {
        List<ms0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ir0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (ms0 ms0Var : list) {
            ms0Var.a(ir0Var);
        }
    }

    public boolean i(ir0 ir0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ir0Var)) == null) {
            ks0 ks0Var = this.b;
            if (ks0Var != null && ks0Var.getInterceptorLayer() != ir0Var.k() && this.b.e(ir0Var)) {
                rw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ir0Var);
                ir0Var.o();
                return true;
            }
            List<ks0> list = this.c;
            if (list != null) {
                for (ks0 ks0Var2 : list) {
                    if (ks0Var2.getInterceptorLayer() != ir0Var.k() && ks0Var2.e(ir0Var)) {
                        rw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ir0Var);
                        ir0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ms0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(ms0Var)) {
                return;
            }
            int expectOrder = ms0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(ms0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, ms0Var);
            } else if (expectOrder != 2) {
            } else {
                List<ms0> list = this.d;
                list.add(list.size(), ms0Var);
            }
        }
    }

    public final void k(ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ir0Var) == null) {
            if (ir0Var.i() == 0) {
                String type = getType();
                rw0.b(type, System.identityHashCode(this) + ": dispatch event :" + ir0Var);
                return;
            }
            String type2 = getType();
            rw0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ir0Var);
        }
    }

    public abstract void l(@NonNull ir0 ir0Var);

    @Override // com.repackage.pu0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<ms0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ks0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
