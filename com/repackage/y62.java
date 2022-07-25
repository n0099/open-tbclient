package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class y62 extends ja2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ia2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y62() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
    }

    @Override // com.repackage.ia2
    public String c(gz1 gz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gz1Var)) == null) {
            if (gz1Var == null || this.d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (ia2 ia2Var : this.d) {
                sb.append(ia2Var.d("event" + i, gz1Var));
                i++;
            }
            if (ia2.b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.ia2
    public void h(gz1 gz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gz1Var) == null) || gz1Var == null || gz1Var.isWebView() || this.d.size() <= 0) {
            return;
        }
        if (ia2.b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (ia2 ia2Var : this.d) {
            JSEvent e = ia2Var.e(gz1Var);
            if (e != null) {
                j(gz1Var, e);
                if (ia2.b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                }
            }
        }
    }

    public y62 t(ia2 ia2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ia2Var)) == null) {
            if (ia2Var != null && !this.d.contains(ia2Var)) {
                this.d.add(ia2Var);
            }
            return this;
        }
        return (y62) invokeL.objValue;
    }
}
