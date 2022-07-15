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
import com.repackage.xw2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class hx2 implements xw2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Deque<Message>> a;

    public hx2() {
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

    @Override // com.repackage.xw2.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.a.keySet()) {
                c(str);
            }
        }
    }

    @Override // com.repackage.xw2.c
    public void b(@NonNull zw2 zw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zw2Var) == null) {
            Message h = zw2Var.h();
            if (zw2Var.m()) {
                h(h);
            }
            Set<SwanAppProcessInfo> l = zw2Var.l();
            Set<String> k = zw2Var.k();
            if (zw2Var.n()) {
                Iterator<gx2> it = ix2.k().q().iterator();
                while (it.hasNext()) {
                    gx2 next = it.next();
                    boolean g = g(next, k);
                    if (l.contains(next.b) || g) {
                        next.g0(h);
                        if (g) {
                            k.remove(next.getAppId());
                        }
                    }
                }
                f(k, h);
                return;
            }
            Iterator<gx2> it2 = ix2.k().q().iterator();
            while (it2.hasNext()) {
                gx2 next2 = it2.next();
                if (next2 != null && next2.T() && (l.contains(next2.b) || g(next2, k))) {
                    next2.g0(h);
                }
            }
        }
    }

    @Override // com.repackage.xw2.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Deque<Message> deque = this.a.get(str);
            xw2.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
            if (deque == null || deque.isEmpty()) {
                return;
            }
            List<gx2> j = ix2.k().j(str);
            xw2.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j.size());
            if (j.isEmpty()) {
                return;
            }
            for (gx2 gx2Var : j) {
                gx2Var.i0(deque);
            }
            deque.clear();
        }
    }

    @Override // com.repackage.xw2.c
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

    public boolean g(@NonNull gx2 gx2Var, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gx2Var, set)) == null) ? gx2Var.E() && set.contains(gx2Var.getAppId()) : invokeLL.booleanValue;
    }

    public final void h(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            try {
                ix2.k().e.send(message);
            } catch (RemoteException e) {
                xw2.f(Log.getStackTraceString(e));
            }
        }
    }
}
