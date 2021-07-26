package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes6.dex */
public final class q extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UnvarnishedMessage f39312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q() {
        super(3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.c(aVar);
            aVar.a("msg_v1", this.f39312a.unpackToJson());
        }
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            super.d(aVar);
            String a2 = aVar.a("msg_v1");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(a2);
            this.f39312a = unvarnishedMessage;
            unvarnishedMessage.setMsgId(f());
        }
    }

    public final UnvarnishedMessage e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39312a : (UnvarnishedMessage) invokeV.objValue;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "OnMessageCommand" : (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            UnvarnishedMessage unvarnishedMessage = this.f39312a;
            if (unvarnishedMessage == null) {
                return null;
            }
            return unvarnishedMessage.unpackToJson();
        }
        return (String) invokeV.objValue;
    }
}
