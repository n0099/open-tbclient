package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class ml2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ol2 a;
    public final List<nl2> b;
    public Boolean c;
    public nl2 d;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ol2 a;
        public List<nl2> b;
        public RuntimeException c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @SuppressLint({"BDThrowableCheck"})
        public a a(@NonNull List<nl2> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                if (list.contains(null)) {
                    this.c = new IllegalArgumentException("branches contains null value");
                    if (!ml2.e) {
                        this.b = null;
                        return this;
                    }
                    throw this.c;
                }
                for (nl2 nl2Var : list) {
                    if (nl2Var.c() + 0 > 100) {
                        this.c = new IllegalArgumentException("The sum of all flow in the branch must be in [0,100]");
                        if (!ml2.e) {
                            this.b = null;
                            return this;
                        }
                        throw this.c;
                    }
                }
                this.b = Collections.unmodifiableList(list);
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public ml2 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.c != null) {
                    if (ml2.e) {
                        throw this.c;
                    }
                    return null;
                } else if (this.a == null) {
                    this.c = new IllegalStateException("testSwitch == null");
                    if (ml2.e) {
                        throw this.c;
                    }
                    return null;
                } else {
                    List<nl2> list = this.b;
                    if (list == null) {
                        this.c = new IllegalStateException("branches == null");
                        if (ml2.e) {
                            throw this.c;
                        }
                        return null;
                    }
                    for (nl2 nl2Var : list) {
                        if (!ol2.c(this.a.f(), nl2Var.e)) {
                            this.c = new IllegalStateException("branch valueType error");
                            if (ml2.e) {
                                throw this.c;
                            }
                            return null;
                        }
                    }
                    return new ml2(this);
                }
            }
            return (ml2) invokeV.objValue;
        }

        public a c(@NonNull ol2 ol2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ol2Var)) == null) {
                this.a = ol2Var;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755495522, "Lcom/repackage/ml2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755495522, "Lcom/repackage/ml2;");
                return;
            }
        }
        e = rf1.a;
    }

    public ml2(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = Boolean.FALSE;
        this.a = aVar.a;
        this.b = aVar.b;
    }

    @Nullable
    public synchronized nl2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c.booleanValue()) {
                    return this.d;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() % 100);
                this.c = Boolean.TRUE;
                for (int i = 0; i < this.b.size(); i++) {
                    nl2 nl2Var = this.b.get(i);
                    currentTimeMillis -= nl2Var.c();
                    if (currentTimeMillis < 0) {
                        this.d = nl2Var;
                        return nl2Var;
                    }
                }
                return null;
            }
        }
        return (nl2) invokeV.objValue;
    }

    @NonNull
    public ol2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ol2) invokeV.objValue;
    }
}
