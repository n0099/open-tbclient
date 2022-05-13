package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx9;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class vy9<T> implements wx9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xx9<? super T> a;
    public final wx9<T> b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends cy9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cy9<? super T> e;
        public final xx9<? super T> f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cy9<? super T> cy9Var, xx9<? super T> xx9Var) {
            super(cy9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy9Var, xx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cy9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cy9Var;
            this.f = xx9Var;
        }

        @Override // com.repackage.xx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.g) {
                return;
            }
            try {
                this.f.onCompleted();
                this.g = true;
                this.e.onCompleted();
            } catch (Throwable th) {
                iy9.f(th, this);
            }
        }

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g) {
                    d2a.j(th);
                    return;
                }
                this.g = true;
                try {
                    this.f.onError(th);
                    this.e.onError(th);
                } catch (Throwable th2) {
                    iy9.e(th2);
                    this.e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // com.repackage.xx9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.g) {
                return;
            }
            try {
                this.f.onNext(t);
                this.e.onNext(t);
            } catch (Throwable th) {
                iy9.g(th, this, t);
            }
        }
    }

    public vy9(wx9<T> wx9Var, xx9<? super T> xx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wx9Var, xx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = wx9Var;
        this.a = xx9Var;
    }

    @Override // com.repackage.wx9.a, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cy9) ((cy9) obj));
    }

    public void call(cy9<? super T> cy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
            this.b.B(new a(cy9Var, this.a));
        }
    }
}
