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
public class x62 extends ia2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ha2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x62() {
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

    @Override // com.repackage.ha2
    public String c(fz1 fz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fz1Var)) == null) {
            if (fz1Var == null || this.d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (ha2 ha2Var : this.d) {
                sb.append(ha2Var.d("event" + i, fz1Var));
                i++;
            }
            if (ha2.b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.ha2
    public void h(fz1 fz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fz1Var) == null) || fz1Var == null || fz1Var.isWebView() || this.d.size() <= 0) {
            return;
        }
        if (ha2.b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (ha2 ha2Var : this.d) {
            JSEvent e = ha2Var.e(fz1Var);
            if (e != null) {
                j(fz1Var, e);
                if (ha2.b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                }
            }
        }
    }

    public x62 t(ha2 ha2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ha2Var)) == null) {
            if (ha2Var != null && !this.d.contains(ha2Var)) {
                this.d.add(ha2Var);
            }
            return this;
        }
        return (x62) invokeL.objValue;
    }
}
