package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface r16 {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static float a(r16 r16Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r16Var)) == null) {
                Intrinsics.checkNotNullParameter(r16Var, "this");
                return 1 / (r16Var.b() - 0.6f);
            }
            return invokeL.floatValue;
        }
    }

    int a();

    float b();

    int c();

    float d();

    float e();

    int getHeight();

    int getWidth();

    void setHeight(int i);

    void setWidth(int i);
}
