package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lv2;
/* loaded from: classes6.dex */
public final class fv2 implements lv2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final kv2 b;

    public fv2(int i, @NonNull kv2 kv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), kv2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = kv2Var;
    }

    @Override // com.repackage.lv2.a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
            if (i != this.a) {
                this.b.b(2, "request permission fail");
                return;
            }
            for (int i2 : iArr) {
                if (i2 == -1) {
                    this.b.b(1, "user denied");
                    return;
                }
            }
            this.b.a("permission granted successful");
        }
    }
}
