package com.repackage;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xv2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class hw2 implements xv2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Deque<Message>> a;

    public hw2() {
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
        this.a = new HashMap();
    }

    @Override // com.repackage.xv2.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.a.keySet()) {
                c(str);
            }
        }
    }

    @Override // com.repackage.xv2.c
    public void b(@NonNull zv2 zv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zv2Var) == null) {
            Message h = zv2Var.h();
            if (zv2Var.m()) {
                h(h);
            }
            Set<SwanAppProcessInfo> l = zv2Var.l();
            Set<String> k = zv2Var.k();
            if (zv2Var.n()) {
                Iterator<gw2> it = iw2.k().q().iterator();
                while (it.hasNext()) {
                    gw2 next = it.next();
                    boolean g = g(next, k);
                    if (l.contains(next.b) || g) {
                        next.f0(h);
                        if (g) {
                            k.remove(next.getAppId());
                        }
                    }
                }
                f(k, h);
                return;
            }
            Iterator<gw2> it2 = iw2.k().q().iterator();
            while (it2.hasNext()) {
                gw2 next2 = it2.next();
                if (next2 != null && next2.S() && (l.contains(next2.b) || g(next2, k))) {
                    next2.f0(h);
                }
            }
        }
    }

    @Override // com.repackage.xv2.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Deque<Message> deque = this.a.get(str);
            xv2.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
            if (deque == null || deque.isEmpty()) {
                return;
            }
            List<gw2> j = iw2.k().j(str);
            xv2.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j.size());
            if (j.isEmpty()) {
                return;
            }
            for (gw2 gw2Var : j) {
                gw2Var.h0(deque);
            }
            deque.clear();
        }
    }

    @Override // com.repackage.xv2.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public final void e(String str, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, message) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Deque<Message> deque = this.a.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set<String> set, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, set, message) == null) {
            for (String str : set) {
                e(str, message);
            }
        }
    }

    public boolean g(@NonNull gw2 gw2Var, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gw2Var, set)) == null) ? gw2Var.D() && set.contains(gw2Var.getAppId()) : invokeLL.booleanValue;
    }

    public final void h(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            try {
                iw2.k().e.send(message);
            } catch (RemoteException e) {
                xv2.f(Log.getStackTraceString(e));
            }
        }
    }
}
