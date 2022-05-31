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
public class x52 extends i92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<h92> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x52() {
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

    @Override // com.repackage.h92
    public String c(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fy1Var)) == null) {
            if (fy1Var == null || this.d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (h92 h92Var : this.d) {
                sb.append(h92Var.d("event" + i, fy1Var));
                i++;
            }
            if (h92.b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.h92
    public void h(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var) == null) || fy1Var == null || fy1Var.isWebView() || this.d.size() <= 0) {
            return;
        }
        if (h92.b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (h92 h92Var : this.d) {
            JSEvent e = h92Var.e(fy1Var);
            if (e != null) {
                j(fy1Var, e);
                if (h92.b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                }
            }
        }
    }

    public x52 t(h92 h92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h92Var)) == null) {
            if (h92Var != null && !this.d.contains(h92Var)) {
                this.d.add(h92Var);
            }
            return this;
        }
        return (x52) invokeL.objValue;
    }
}
