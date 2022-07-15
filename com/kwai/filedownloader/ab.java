package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public final class ab implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Handler> a;

    public ab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
    }

    public static void a(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, handler) == null) {
            handler.sendEmptyMessage(2);
        }
    }

    public static void b(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, handler) == null) {
            handler.sendEmptyMessage(3);
        }
    }

    @Override // com.kwai.filedownloader.w
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i = 0; i < this.a.size(); i++) {
                a(this.a.get(this.a.keyAt(i)));
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public final void a(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            for (Integer num : list) {
                b(this.a.get(num.intValue()));
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.a.get(i) != null : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.w
    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() : invokeV.intValue;
    }
}
