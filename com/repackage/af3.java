package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public abstract class af3<OuT> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final df3<OuT> a;
    public OuT b;

    /* loaded from: classes5.dex */
    public static class a extends af3<OuT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(df3 df3Var, CountDownLatch countDownLatch) {
            super(df3Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df3Var, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((df3) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = countDownLatch;
        }

        @Override // com.repackage.af3
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.countDown();
            }
        }
    }

    public /* synthetic */ af3(df3 df3Var, a aVar) {
        this(df3Var);
    }

    public static <OuT> OuT a(Looper looper, df3<OuT> df3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, df3Var)) == null) {
            if (df3Var == null) {
                return null;
            }
            if (looper != null && Thread.currentThread() != looper.getThread()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                a aVar = new a(df3Var, countDownLatch);
                new Handler(looper).post(aVar);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    jx1.o("Awaiting", "callOnLooper: Thread=" + Thread.currentThread().getName() + " ret by InterruptedException " + e);
                    e.printStackTrace();
                }
                return aVar.b;
            }
            return df3Var.create();
        }
        return (OuT) invokeLL.objValue;
    }

    public static <OuT> OuT b(df3<OuT> df3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, df3Var)) == null) ? (OuT) a(Looper.getMainLooper(), df3Var) : (OuT) invokeL.objValue;
    }

    public abstract void c();

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                    this.b = this.a.create();
                } catch (Exception e) {
                    jx1.o("Awaiting", "catch: " + e + "\n" + Log.getStackTraceString(e));
                }
            } finally {
                c();
            }
        }
    }

    public af3(df3<OuT> df3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {df3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = df3Var;
    }
}
