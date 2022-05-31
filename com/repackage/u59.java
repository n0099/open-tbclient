package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k59;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes7.dex */
public class u59 extends q59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u59(n59 n59Var, v59 v59Var, k59.a aVar) {
        super(n59Var, v59Var, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n59Var, v59Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((n59) objArr2[0], (v59) objArr2[1], (k59.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.q59
    public RandomAccessFile e(File file, String str, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, str, Long.valueOf(j)})) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            randomAccessFile.seek(0L);
            return randomAccessFile;
        }
        return (RandomAccessFile) invokeCommon.objValue;
    }

    @Override // com.repackage.q59
    public Map<String, String> f(v59 v59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v59Var)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.repackage.q59
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.q59
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? u59.class.getSimpleName() : (String) invokeV.objValue;
    }

    @Override // com.repackage.q59
    public void j(v59 v59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v59Var) == null) {
        }
    }

    @Override // com.repackage.q59
    public void n(v59 v59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v59Var) == null) {
        }
    }
}
