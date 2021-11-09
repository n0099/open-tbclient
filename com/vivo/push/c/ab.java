package com.vivo.push.c;

import android.content.Context;
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
/* loaded from: classes2.dex */
public abstract class ab extends com.vivo.push.v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public PushMessageCallback f70245b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pushMessageCallback) == null) {
            this.f70245b = pushMessageCallback;
        }
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, publicKey, str, str2)) == null) {
            if (!com.vivo.push.p.a().d()) {
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
                    if (com.vivo.push.util.t.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                        com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                        return true;
                    }
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is " + str);
                    Context context = this.f70427a;
                    com.vivo.push.util.p.c(context, "vertify fail srcDigest is " + str);
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
