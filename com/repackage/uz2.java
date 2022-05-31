package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
/* loaded from: classes7.dex */
public abstract class uz2<T> implements li2<T, byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uz2() {
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

    public abstract T a(@NonNull mi2 mi2Var) throws Exception;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.li2
    public final T call(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            mi2 mi2Var = new mi2(byteArrayInputStream);
            T a = a(mi2Var);
            mi2Var.close();
            byteArrayInputStream.close();
            return a;
        }
        return (T) invokeL.objValue;
    }
}
