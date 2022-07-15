package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public abstract class v03<T> implements lj2<byte[], T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v03() {
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

    public abstract void a(@NonNull T t, @NonNull nj2 nj2Var) throws Exception;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.lj2
    public /* bridge */ /* synthetic */ byte[] call(Object obj) throws Exception {
        return call2((v03<T>) obj);
    }

    @Override // com.repackage.lj2
    /* renamed from: call  reason: avoid collision after fix types in other method */
    public final byte[] call2(T t) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            nj2 nj2Var = new nj2(byteArrayOutputStream);
            a(t, nj2Var);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            nj2Var.close();
            byteArrayOutputStream.close();
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }
}
