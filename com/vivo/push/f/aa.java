package com.vivo.push.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;
/* loaded from: classes8.dex */
public abstract class aa extends com.vivo.push.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PushMessageCallback b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(com.vivo.push.o oVar) {
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
        this.c = 0;
    }

    public final int a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, notifyArriveCallbackByUser)) == null) {
            if (notifyArriveCallbackByUser == null) {
                com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.a.getPackageName() + " 应用到达回调返回值为空，不做处理");
                com.vivo.push.util.u.b(this.a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
                return 2163;
            } else if (notifyArriveCallbackByUser.isIntercept()) {
                com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.a.getPackageName() + " 应用主动拦截通知");
                com.vivo.push.util.u.b(this.a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
                return ErrorConstant.Code.META_ERROR_FATAL;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c = i;
        }
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pushMessageCallback) == null) {
            this.b = pushMessageCallback;
        }
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, publicKey, str, str2)) == null) {
            if (!com.vivo.push.e.a().d()) {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
                return true;
            } else if (publicKey == null) {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify key is null");
                return false;
            } else if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "contentTag is null");
                return false;
            } else if (!TextUtils.isEmpty(str2)) {
                try {
                    com.vivo.push.util.u.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                    if (com.vivo.push.util.ab.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                        com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is success");
                        return true;
                    }
                    com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
                    com.vivo.push.util.u.c(this.a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify exception");
                    return false;
                }
            } else {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is null");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
                if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
                    return 2104;
                }
                if (Build.VERSION.SDK_INT >= 26 && notificationManager != null) {
                    try {
                        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
                        if (notificationChannel != null) {
                            if (notificationChannel.getImportance() == 0) {
                                return 2121;
                            }
                            return 0;
                        }
                        return 0;
                    } catch (Exception unused) {
                        com.vivo.push.util.u.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
                        return 0;
                    }
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }
}
