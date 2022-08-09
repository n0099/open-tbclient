package com.repackage;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class sa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public eb9 b;
    public b c;
    public jb9 d;
    public boolean e;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa9 a;

        public b(sa9 sa9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa9Var;
        }

        public /* synthetic */ b(sa9 sa9Var, a aVar) {
            this(sa9Var);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.a.b = new eb9(-100);
                        if (this.a.b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(eb9.d);
                            this.a.b.c();
                            if (this.a.b.e() != 3) {
                                return;
                            }
                            while (!this.a.a) {
                                allocateDirect.clear();
                                int a = this.a.b.a(allocateDirect, eb9.d);
                                if (a > 0) {
                                    double a2 = lb9.a(allocateDirect, a);
                                    if (this.a.d != null && a2 > 0.0d) {
                                        this.a.d.a(a2);
                                    }
                                }
                            }
                        } else if (this.a.d != null) {
                            this.a.d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.a.d != null) {
                            this.a.d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.a.i();
                }
            }
        }
    }

    public sa9() {
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
        this.a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = true;
            this.a = false;
            b bVar = new b(this, null);
            this.c = bVar;
            bVar.start();
        }
    }

    public void d(jb9 jb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb9Var) == null) {
            this.d = jb9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = true;
            this.e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            this.e = false;
            eb9 eb9Var = this.b;
            if (eb9Var != null) {
                eb9Var.b();
            }
            if (this.c != null) {
                this.c = null;
            }
        }
    }
}
