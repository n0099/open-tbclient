package com.repackage;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ha9 extends ea9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String h = "XMUnionID";
    public static boolean i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755654831, "Lcom/repackage/ha9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755654831, "Lcom/repackage/ha9;");
                return;
            }
        }
        i = w99.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha9(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i) {
            Log.e(h, "xiaomi XMUnionID !!");
        }
        this.d = "";
        this.b = false;
        this.c = false;
        this.g = -200;
    }

    @Override // com.repackage.da9
    public da9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.c = wm9.b();
                this.d = wm9.a(this.a);
                this.g = 0;
            } catch (Exception e) {
                if (i) {
                    Log.e(h, "xiaomi init4UnionId error", e);
                }
            }
            return this;
        }
        return (da9) invokeV.objValue;
    }
}
