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
/* loaded from: classes6.dex */
public class k72 extends va2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ua2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k72() {
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

    @Override // com.repackage.ua2
    public String c(sz1 sz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sz1Var)) == null) {
            if (sz1Var == null || this.d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (ua2 ua2Var : this.d) {
                sb.append(ua2Var.d("event" + i, sz1Var));
                i++;
            }
            if (ua2.b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.ua2
    public void h(sz1 sz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sz1Var) == null) || sz1Var == null || sz1Var.isWebView() || this.d.size() <= 0) {
            return;
        }
        if (ua2.b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (ua2 ua2Var : this.d) {
            JSEvent e = ua2Var.e(sz1Var);
            if (e != null) {
                j(sz1Var, e);
                if (ua2.b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                }
            }
        }
    }

    public k72 t(ua2 ua2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ua2Var)) == null) {
            if (ua2Var != null && !this.d.contains(ua2Var)) {
                this.d.add(ua2Var);
            }
            return this;
        }
        return (k72) invokeL.objValue;
    }
}
