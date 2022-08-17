package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sp9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class ad9 extends zc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements sp9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ ad9 c;

        public a(ad9 ad9Var, AtomicBoolean atomicBoolean, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad9Var, atomicBoolean, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ad9Var;
            this.a = atomicBoolean;
            this.b = obj;
        }

        @Override // com.repackage.sp9.c
        public void a(int i, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, exc) == null) {
                this.c.g = i;
                this.a.set(true);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.repackage.sp9.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.c.d = str;
                this.c.b = z;
                this.c.c = true;
                this.c.g = 0;
                this.a.set(true);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad9(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.b = false;
        this.c = false;
        this.g = -200;
    }

    @Override // com.repackage.yc9
    public yc9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n();
            return this;
        }
        return (yc9) invokeV.objValue;
    }

    public yc9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            sp9.d(this.a, new a(this, atomicBoolean, obj));
            synchronized (obj) {
                if (!atomicBoolean.get()) {
                    try {
                        obj.wait(4000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            return this;
        }
        return (yc9) invokeV.objValue;
    }
}
