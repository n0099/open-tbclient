package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.model.InterestSelectionStyleAModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vm7<V> implements fn7<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterestSelectionStyleAModel a;
    public lm7 b;
    public BaseInterestSelectionFragment c;

    public vm7(BaseInterestSelectionFragment baseInterestSelectionFragment, lm7 lm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestSelectionFragment, lm7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = baseInterestSelectionFragment;
        this.b = lm7Var;
        this.a = new InterestSelectionStyleAModel(lm7Var, this);
    }

    @Override // com.repackage.fn7
    public void a(V v) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v) == null) || (baseInterestSelectionFragment = this.c) == null) {
            return;
        }
        baseInterestSelectionFragment.F0();
    }

    public void b() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (interestSelectionStyleAModel = this.a) == null) {
            return;
        }
        interestSelectionStyleAModel.onDestroy();
    }

    public void c() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interestSelectionStyleAModel = this.a) == null) {
            return;
        }
        interestSelectionStyleAModel.D();
    }

    @Override // com.repackage.fn7
    public void onError(int i, String str) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (baseInterestSelectionFragment = this.c) == null) {
            return;
        }
        baseInterestSelectionFragment.G0(str);
    }
}
