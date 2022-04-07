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
public abstract class wv0 implements yv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<st0>> a;
    @Nullable
    public tt0 b;
    @Nullable
    public List<tt0> c;
    @Nullable
    public List<vt0> d;

    public wv0() {
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

    @Override // com.repackage.yv0
    @Deprecated
    public void a(@Nullable tt0 tt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tt0Var) == null) {
            this.b = tt0Var;
        }
    }

    @Override // com.repackage.yv0
    public void b(@NonNull vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vt0Var) == null) {
            j(vt0Var);
        }
    }

    @Override // com.repackage.yv0
    public void c(int i, @NonNull st0 st0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, st0Var) == null) {
            CopyOnWriteArrayList<st0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(st0Var)) {
                int expectOrder = st0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(st0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, st0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), st0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.repackage.yv0
    public void d(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rs0Var) == null) {
            String type = getType();
            ay0.i(type, System.identityHashCode(this) + " notifyEvent " + rs0Var);
            if (rs0Var.j() == 1) {
                if (i(rs0Var)) {
                    return;
                }
                g(rs0Var);
                rs0Var.o();
                return;
            }
            l(rs0Var);
        }
    }

    @Override // com.repackage.yv0
    public void e(st0 st0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, st0Var) == null) {
            for (CopyOnWriteArrayList<st0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(st0Var);
            }
        }
    }

    @Override // com.repackage.yv0
    public void f(@NonNull vt0 vt0Var) {
        List<vt0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vt0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(vt0Var);
    }

    public void g(rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rs0Var) == null) {
            k(rs0Var);
            h(rs0Var);
            CopyOnWriteArrayList<st0> copyOnWriteArrayList = this.a.get(Integer.valueOf(rs0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<st0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                st0 next = it.next();
                if (!rs0Var.b(next)) {
                    switch (rs0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(rs0Var);
                            continue;
                        case 1:
                            next.n(rs0Var);
                            continue;
                        case 2:
                            next.r(rs0Var);
                            continue;
                        case 3:
                            next.k(rs0Var);
                            continue;
                        case 4:
                            next.d(rs0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) rs0Var.f(2), (PlayerStatus) rs0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof ax0) {
                                ((ax0) next).g(rs0Var);
                                break;
                            } else {
                                next.a(rs0Var);
                                continue;
                            }
                        case 8:
                            next.j(rs0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(rs0 rs0Var) {
        List<vt0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rs0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (vt0 vt0Var : list) {
            vt0Var.a(rs0Var);
        }
    }

    public boolean i(rs0 rs0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rs0Var)) == null) {
            tt0 tt0Var = this.b;
            if (tt0Var != null && tt0Var.getInterceptorLayer() != rs0Var.k() && this.b.e(rs0Var)) {
                ay0.b("AbsMessenger", "isNeedIntercept() = true, event = " + rs0Var);
                rs0Var.o();
                return true;
            }
            List<tt0> list = this.c;
            if (list != null) {
                for (tt0 tt0Var2 : list) {
                    if (tt0Var2.getInterceptorLayer() != rs0Var.k() && tt0Var2.e(rs0Var)) {
                        ay0.b("AbsMessenger", "isNeedIntercept() = true, event = " + rs0Var);
                        rs0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vt0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(vt0Var)) {
                return;
            }
            int expectOrder = vt0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(vt0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, vt0Var);
            } else if (expectOrder != 2) {
            } else {
                List<vt0> list = this.d;
                list.add(list.size(), vt0Var);
            }
        }
    }

    public final void k(rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rs0Var) == null) {
            if (rs0Var.i() == 0) {
                String type = getType();
                ay0.b(type, System.identityHashCode(this) + ": dispatch event :" + rs0Var);
                return;
            }
            String type2 = getType();
            ay0.i(type2, System.identityHashCode(this) + ": dispatch event :" + rs0Var);
        }
    }

    public abstract void l(@NonNull rs0 rs0Var);

    @Override // com.repackage.yv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<vt0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<tt0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
