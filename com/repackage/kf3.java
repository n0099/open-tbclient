package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes6.dex */
public class kf3 implements jf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<if3> a;
    public if3 b;

    public kf3() {
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
        this.a = new ArrayDeque();
    }

    @Override // com.repackage.jf3
    public void a(if3 if3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, if3Var) == null) {
            synchronized (this.a) {
                if (if3Var == this.b) {
                    e();
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                if (this.b != null) {
                    return;
                }
                e();
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.b != null) {
                    this.b.a();
                    this.b = null;
                }
                this.a.clear();
            }
        }
    }

    public void d(if3 if3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, if3Var) == null) {
            if (if3Var != null) {
                synchronized (this.a) {
                    Queue<if3> queue = this.a;
                    if3Var.b(this);
                    queue.offer(if3Var);
                }
            }
            b();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.a) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                if3 poll = this.a.poll();
                this.b = poll;
                if (poll == null) {
                    e();
                } else {
                    oe3.a0(poll);
                }
            }
        }
    }
}
