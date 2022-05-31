package com.repackage;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class fh2 extends bd2<sh2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fh2() {
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

    @Override // com.repackage.bd2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setSurface" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bd2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull sh2 sh2Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, sh2Var) == null) || (obj = command.obj) == null) {
            return;
        }
        sh2Var.setSurface((Surface) obj);
        String str = command.what;
        d(sh2Var, str, "Surface:" + command.obj.hashCode(), false);
    }
}
