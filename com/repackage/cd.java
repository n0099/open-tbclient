package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class cd implements id {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public cd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
    }

    @Override // com.repackage.id
    public Object a(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ydVar)) == null) {
            Class<?> a = ydVar.a();
            if (a != Boolean.class && a != Boolean.TYPE) {
                if (a == Short.class || a == Short.TYPE) {
                    return Short.valueOf((short) (!this.a ? 1 : 0));
                }
                if (a == Integer.class || a == Integer.TYPE) {
                    return Integer.valueOf(!this.a ? 1 : 0);
                }
                if (a == Long.class || a == Long.TYPE) {
                    return Long.valueOf(!this.a ? 1 : 0);
                }
                if (a == Float.class || a == Float.TYPE) {
                    return Float.valueOf(!this.a ? 1 : 0);
                }
                if (a == Double.class || a == Double.TYPE) {
                    return Double.valueOf(!this.a ? 1 : 0);
                }
                if (a == Character.class || a == Character.TYPE) {
                    return Character.valueOf((char) (!this.a ? 1 : 0));
                }
                if (a == String.class) {
                    return String.valueOf(this.a);
                }
                if (a == char[].class) {
                    return String.valueOf(this.a).toCharArray();
                }
                if (a == byte[].class) {
                    try {
                        return ci.e(String.valueOf(this.a), 0);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return Boolean.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
