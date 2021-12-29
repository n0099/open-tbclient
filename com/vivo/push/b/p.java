package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes4.dex */
public final class p extends com.vivo.push.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f63023b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f63024c;

    /* renamed from: d  reason: collision with root package name */
    public long f63025d;

    /* renamed from: e  reason: collision with root package name */
    public InsideNotificationItem f63026e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), insideNotificationItem};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f63025d = j2;
        this.f63026e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.a("package_name", this.a);
            aVar.a("notify_id", this.f63025d);
            aVar.a("notification_v1", com.vivo.push.util.q.b(this.f63026e));
            aVar.a("open_pkg_name", this.f63023b);
            aVar.a("open_pkg_name_encode", this.f63024c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63025d : invokeV.longValue;
    }

    public final InsideNotificationItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63026e : (InsideNotificationItem) invokeV.objValue;
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
            this.f63025d = aVar.b("notify_id", -1L);
            this.f63023b = aVar.a("open_pkg_name");
            this.f63024c = aVar.b("open_pkg_name_encode");
            String a = aVar.a("notification_v1");
            if (!TextUtils.isEmpty(a)) {
                this.f63026e = com.vivo.push.util.q.a(a);
            }
            InsideNotificationItem insideNotificationItem = this.f63026e;
            if (insideNotificationItem != null) {
                insideNotificationItem.setMsgId(this.f63025d);
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
}
