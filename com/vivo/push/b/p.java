package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class p extends com.vivo.push.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f43843b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f43844c;

    /* renamed from: d  reason: collision with root package name */
    public long f43845d;

    /* renamed from: e  reason: collision with root package name */
    public InsideNotificationItem f43846e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), insideNotificationItem};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f43845d = j;
        this.f43846e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.a("package_name", this.a);
            aVar.a("notify_id", this.f43845d);
            aVar.a("notification_v1", com.vivo.push.util.q.b(this.f43846e));
            aVar.a("open_pkg_name", this.f43843b);
            aVar.a("open_pkg_name_encode", this.f43844c);
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43845d : invokeV.longValue;
    }

    public final InsideNotificationItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43846e : (InsideNotificationItem) invokeV.objValue;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "OnNotificationClickCommand" : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.a = aVar.a("package_name");
            this.f43845d = aVar.b("notify_id", -1L);
            this.f43843b = aVar.a("open_pkg_name");
            this.f43844c = aVar.b("open_pkg_name_encode");
            String a = aVar.a("notification_v1");
            if (!TextUtils.isEmpty(a)) {
                this.f43846e = com.vivo.push.util.q.a(a);
            }
            InsideNotificationItem insideNotificationItem = this.f43846e;
            if (insideNotificationItem != null) {
                insideNotificationItem.setMsgId(this.f43845d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p() {
        super(5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
