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
/* loaded from: classes7.dex */
public abstract class zu0 implements bv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<vs0>> a;
    @Nullable
    public ws0 b;
    @Nullable
    public List<ws0> c;
    @Nullable
    public List<ys0> d;

    public zu0() {
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

    @Override // com.repackage.bv0
    @Deprecated
    public void a(@Nullable ws0 ws0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ws0Var) == null) {
            this.b = ws0Var;
        }
    }

    @Override // com.repackage.bv0
    public void b(@NonNull ys0 ys0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ys0Var) == null) {
            j(ys0Var);
        }
    }

    @Override // com.repackage.bv0
    public void c(int i, @NonNull vs0 vs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, vs0Var) == null) {
            CopyOnWriteArrayList<vs0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(vs0Var)) {
                int expectOrder = vs0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(vs0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, vs0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), vs0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.repackage.bv0
    public void d(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ur0Var) == null) {
            String type = getType();
            dx0.i(type, System.identityHashCode(this) + " notifyEvent " + ur0Var);
            if (ur0Var.j() == 1) {
                if (i(ur0Var)) {
                    return;
                }
                g(ur0Var);
                ur0Var.o();
                return;
            }
            l(ur0Var);
        }
    }

    @Override // com.repackage.bv0
    public void e(vs0 vs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vs0Var) == null) {
            for (CopyOnWriteArrayList<vs0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(vs0Var);
            }
        }
    }

    @Override // com.repackage.bv0
    public void f(@NonNull ys0 ys0Var) {
        List<ys0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ys0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(ys0Var);
    }

    public void g(ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ur0Var) == null) {
            k(ur0Var);
            h(ur0Var);
            CopyOnWriteArrayList<vs0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ur0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<vs0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                vs0 next = it.next();
                if (!ur0Var.b(next)) {
                    switch (ur0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(ur0Var);
                            continue;
                        case 1:
                            next.n(ur0Var);
                            continue;
                        case 2:
                            next.q(ur0Var);
                            continue;
                        case 3:
                            next.k(ur0Var);
                            continue;
                        case 4:
                            next.d(ur0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) ur0Var.f(2), (PlayerStatus) ur0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof dw0) {
                                ((dw0) next).g(ur0Var);
                                break;
                            } else {
                                next.a(ur0Var);
                                continue;
                            }
                        case 8:
                            next.j(ur0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(ur0 ur0Var) {
        List<ys0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ur0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (ys0 ys0Var : list) {
            ys0Var.a(ur0Var);
        }
    }

    public boolean i(ur0 ur0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ur0Var)) == null) {
            ws0 ws0Var = this.b;
            if (ws0Var != null && ws0Var.getInterceptorLayer() != ur0Var.k() && this.b.e(ur0Var)) {
                dx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ur0Var);
                ur0Var.o();
                return true;
            }
            List<ws0> list = this.c;
            if (list != null) {
                for (ws0 ws0Var2 : list) {
                    if (ws0Var2.getInterceptorLayer() != ur0Var.k() && ws0Var2.e(ur0Var)) {
                        dx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ur0Var);
                        ur0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(ys0 ys0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ys0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(ys0Var)) {
                return;
            }
            int expectOrder = ys0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(ys0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, ys0Var);
            } else if (expectOrder != 2) {
            } else {
                List<ys0> list = this.d;
                list.add(list.size(), ys0Var);
            }
        }
    }

    public final void k(ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ur0Var) == null) {
            if (ur0Var.i() == 0) {
                String type = getType();
                dx0.b(type, System.identityHashCode(this) + ": dispatch event :" + ur0Var);
                return;
            }
            String type2 = getType();
            dx0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ur0Var);
        }
    }

    public abstract void l(@NonNull ur0 ur0Var);

    @Override // com.repackage.bv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<ys0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ws0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
