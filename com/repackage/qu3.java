package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qu3 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements V8Engine.WorkerFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu3 a;

        public a(qu3 qu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu3Var;
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.WorkerFactory
        public V8Engine onCreateWorker() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ru3 ru3Var = new ru3(this.a.getInitBasePath());
                ru3Var.J0();
                ru3Var.r(new b72(ru3Var));
                ru3Var.I0(new c72(ru3Var));
                return ru3Var.n0();
            }
            return (V8Engine) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu3(@NonNull String str, @NonNull m72 m72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, m72Var, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, m72Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (m72) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        V8Engine v8Engine = this.a;
        if (v8Engine == null) {
            return;
        }
        v8Engine.setWorkerFactoryDelegate(new a(this));
    }

    @Override // com.repackage.p62
    public EventTarget C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new qt3(this) : (EventTarget) invokeV.objValue;
    }

    @Override // com.repackage.r62, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p62
    @NonNull
    public EventTarget w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new nt3(this) : (EventTarget) invokeV.objValue;
    }
}
