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
public abstract class ju0 implements lu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<fs0>> a;
    @Nullable
    public gs0 b;
    @Nullable
    public List<gs0> c;
    @Nullable
    public List<is0> d;

    public ju0() {
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

    @Override // com.repackage.lu0
    @Deprecated
    public void a(@Nullable gs0 gs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gs0Var) == null) {
            this.b = gs0Var;
        }
    }

    @Override // com.repackage.lu0
    public void b(@NonNull is0 is0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, is0Var) == null) {
            j(is0Var);
        }
    }

    @Override // com.repackage.lu0
    public void c(int i, @NonNull fs0 fs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, fs0Var) == null) {
            CopyOnWriteArrayList<fs0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(fs0Var)) {
                int expectOrder = fs0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(fs0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, fs0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), fs0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.repackage.lu0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, er0Var) == null) {
            String type = getType();
            nw0.i(type, System.identityHashCode(this) + " notifyEvent " + er0Var);
            if (er0Var.j() == 1) {
                if (i(er0Var)) {
                    return;
                }
                g(er0Var);
                er0Var.o();
                return;
            }
            l(er0Var);
        }
    }

    @Override // com.repackage.lu0
    public void e(fs0 fs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fs0Var) == null) {
            for (CopyOnWriteArrayList<fs0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(fs0Var);
            }
        }
    }

    @Override // com.repackage.lu0
    public void f(@NonNull is0 is0Var) {
        List<is0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, is0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(is0Var);
    }

    public void g(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
            k(er0Var);
            h(er0Var);
            CopyOnWriteArrayList<fs0> copyOnWriteArrayList = this.a.get(Integer.valueOf(er0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<fs0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                fs0 next = it.next();
                if (!er0Var.b(next)) {
                    switch (er0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(er0Var);
                            continue;
                        case 1:
                            next.n(er0Var);
                            continue;
                        case 2:
                            next.r(er0Var);
                            continue;
                        case 3:
                            next.k(er0Var);
                            continue;
                        case 4:
                            next.d(er0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) er0Var.f(2), (PlayerStatus) er0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof nv0) {
                                ((nv0) next).g(er0Var);
                                break;
                            } else {
                                next.a(er0Var);
                                continue;
                            }
                        case 8:
                            next.j(er0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(er0 er0Var) {
        List<is0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, er0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (is0 is0Var : list) {
            is0Var.a(er0Var);
        }
    }

    public boolean i(er0 er0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, er0Var)) == null) {
            gs0 gs0Var = this.b;
            if (gs0Var != null && gs0Var.getInterceptorLayer() != er0Var.k() && this.b.e(er0Var)) {
                nw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + er0Var);
                er0Var.o();
                return true;
            }
            List<gs0> list = this.c;
            if (list != null) {
                for (gs0 gs0Var2 : list) {
                    if (gs0Var2.getInterceptorLayer() != er0Var.k() && gs0Var2.e(er0Var)) {
                        nw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + er0Var);
                        er0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(is0 is0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, is0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(is0Var)) {
                return;
            }
            int expectOrder = is0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(is0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, is0Var);
            } else if (expectOrder != 2) {
            } else {
                List<is0> list = this.d;
                list.add(list.size(), is0Var);
            }
        }
    }

    public final void k(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, er0Var) == null) {
            if (er0Var.i() == 0) {
                String type = getType();
                nw0.b(type, System.identityHashCode(this) + ": dispatch event :" + er0Var);
                return;
            }
            String type2 = getType();
            nw0.i(type2, System.identityHashCode(this) + ": dispatch event :" + er0Var);
        }
    }

    public abstract void l(@NonNull er0 er0Var);

    @Override // com.repackage.lu0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<is0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<gs0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
