package com.repackage;

import android.animation.TypeEvaluator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i67 implements TypeEvaluator<k67> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k67 a;

    public i67(k67 k67Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k67Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k67Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public k67 evaluate(float f, k67 k67Var, k67 k67Var2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), k67Var, k67Var2})) == null) {
            float f2 = 1.0f - f;
            float f3 = f2 * f2;
            float f4 = 2.0f * f * f2;
            k67 k67Var3 = this.a;
            float f5 = f * f;
            return new k67((int) ((k67Var.a * f3) + (k67Var3.a * f4) + (k67Var2.a * f5)), (int) ((f3 * k67Var.b) + (f4 * k67Var3.b) + (f5 * k67Var2.b)));
        }
        return (k67) invokeCommon.objValue;
    }
}
