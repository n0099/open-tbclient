package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class qi2 extends oe2<fj2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qi2() {
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

    @Override // com.repackage.oe2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setDataSource" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oe2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull fj2 fj2Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, fj2Var) == null) || (obj = command.obj) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        boolean z = command.arg1 != 0;
        String str = (String) arrayList.get(0);
        String f = q93.l().f(str, (String) arrayList.get(1));
        command.ret = fj2Var.O(str, f, (String) arrayList.get(2), z) ? 1 : 0;
        String str2 = command.what;
        d(fj2Var, str2, "DataSource: " + str + " ;UserAgent: " + ((String) arrayList.get(2)) + " ;Cookies: " + f + ";hideUrlLog: " + z, true);
    }
}
