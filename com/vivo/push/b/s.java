package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes2.dex */
public final class s extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InsideNotificationItem f71151a;

    /* renamed from: b  reason: collision with root package name */
    public String f71152b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s() {
        super(4);
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
            String b2 = com.vivo.push.util.q.b(this.f71151a);
            this.f71152b = b2;
            aVar.a("notification_v1", b2);
        }
    }

    public final InsideNotificationItem d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71151a : (InsideNotificationItem) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f71152b)) {
                InsideNotificationItem insideNotificationItem = this.f71151a;
                if (insideNotificationItem == null) {
                    return null;
                }
                return com.vivo.push.util.q.b(insideNotificationItem);
            }
            return this.f71152b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "OnNotifyArrivedCommand" : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            super.d(aVar);
            String a2 = aVar.a("notification_v1");
            this.f71152b = a2;
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            InsideNotificationItem a3 = com.vivo.push.util.q.a(this.f71152b);
            this.f71151a = a3;
            if (a3 != null) {
                a3.setMsgId(f());
            }
        }
    }
}
