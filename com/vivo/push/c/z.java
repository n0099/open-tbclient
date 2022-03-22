package com.vivo.push.c;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.security.PublicKey;
/* loaded from: classes7.dex */
public abstract class z extends com.vivo.push.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public PushMessageCallback f43881b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pushMessageCallback) == null) {
            this.f43881b = pushMessageCallback;
        }
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, publicKey, str, str2)) == null) {
            if (!com.vivo.push.e.a().d()) {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
                return true;
            } else if (publicKey == null) {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify key is null");
                return false;
            } else if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "contentTag is null");
                return false;
            } else if (!TextUtils.isEmpty(str2)) {
                try {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                    if (com.vivo.push.util.u.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                        com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                        return true;
                    }
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
                    com.vivo.push.util.p.c(this.a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify exception");
                    return false;
                }
            } else {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is null");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
