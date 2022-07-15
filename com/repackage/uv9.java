package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes7.dex */
public final class uv9 implements tr9, bs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tr9 a;
    public bs9 b;
    public boolean c;

    public uv9(tr9 tr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tr9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tr9Var;
    }

    @Override // com.repackage.bs9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c || this.b.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.repackage.tr9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        this.c = true;
        try {
            this.a.onCompleted();
        } catch (Throwable th) {
            gs9.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // com.repackage.tr9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            bw9.j(th);
            if (this.c) {
                return;
            }
            this.c = true;
            try {
                this.a.onError(th);
            } catch (Throwable th2) {
                gs9.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }

    @Override // com.repackage.tr9
    public void onSubscribe(bs9 bs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bs9Var) == null) {
            this.b = bs9Var;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                gs9.e(th);
                bs9Var.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // com.repackage.bs9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.unsubscribe();
        }
    }
}
