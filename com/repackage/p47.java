package com.repackage;

import android.animation.TypeEvaluator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p47 implements TypeEvaluator<r47> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r47 a;

    public p47(r47 r47Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r47Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r47Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public r47 evaluate(float f, r47 r47Var, r47 r47Var2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), r47Var, r47Var2})) == null) {
            float f2 = 1.0f - f;
            float f3 = f2 * f2;
            float f4 = 2.0f * f * f2;
            r47 r47Var3 = this.a;
            float f5 = f * f;
            return new r47((int) ((r47Var.a * f3) + (r47Var3.a * f4) + (r47Var2.a * f5)), (int) ((f3 * r47Var.b) + (f4 * r47Var3.b) + (f5 * r47Var2.b)));
        }
        return (r47) invokeCommon.objValue;
    }
}
