package com.sdk.mobile.manager.oauth.cucc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.o.a;
import com.sdk.y.d;
import com.sdk.y.f;
/* loaded from: classes9.dex */
public class OauthManager extends SDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile OauthManager manager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public OauthManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static OauthManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (manager == null) {
                synchronized (OauthManager.class) {
                    if (manager == null) {
                        manager = new OauthManager(context);
                    }
                }
            }
            return manager;
        }
        return (OauthManager) invokeL.objValue;
    }

    public <T> void getAuthoriseCode(int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, callBack) == null) {
            new f(this.mContext, i, callBack).a(1);
        }
    }

    public <T> void getMobileForCode(String str, int i, CallBack<T> callBack) {
        e<T> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, callBack) == null) {
            if (a.a(str).booleanValue()) {
                SDKManager.toFailed(callBack, 101001, "授权码不能为空");
                return;
            }
            f fVar = new f(this.mContext, i, callBack);
            com.sdk.b.a.a(fVar.e);
            com.sdk.z.a aVar = new com.sdk.z.a(fVar.e, new com.sdk.y.e(fVar));
            if (a.a(null).booleanValue()) {
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData(YYInnerSSOLoginActivity.o, str);
                a = aVar.a(aVar.i, "/api/netm/v1.0/qhbt", dataInfo, new com.sdk.g.a(aVar), 0, f.a.b);
            } else {
                DataInfo dataInfo2 = new DataInfo();
                dataInfo2.putData(YYInnerSSOLoginActivity.o, str);
                dataInfo2.putData("mobile", null);
                a = aVar.a(aVar.i, "/api/netm/v1.0/qhbv", dataInfo2, new com.sdk.g.a(aVar), 0, f.a.b);
            }
            fVar.g = a;
        }
    }

    public <T> void getMobileForCode(String str, String str2, int i, CallBack<T> callBack) {
        e<T> a;
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, str, str2, i, callBack) == null) {
            if (a.a(str).booleanValue()) {
                i2 = 101001;
                str3 = "授权码不能为空";
            } else if (a.a(str2).booleanValue()) {
                i2 = 101002;
                str3 = "认证的手机号不能为空";
            } else {
                com.sdk.y.f fVar = new com.sdk.y.f(this.mContext, i, callBack);
                Context context = fVar.e;
                a.b(com.sdk.b.a.a, "oauth cache clear", com.sdk.b.a.b);
                com.sdk.k.a.a(context, "accessCode1");
                com.sdk.z.a aVar = new com.sdk.z.a(fVar.e, new d(fVar));
                if (a.a(str2).booleanValue()) {
                    DataInfo dataInfo = new DataInfo();
                    dataInfo.putData(YYInnerSSOLoginActivity.o, str);
                    a = aVar.a(aVar.i, "/api/netm/v1.0/qhbt", dataInfo, new com.sdk.g.a(aVar), 0, f.a.b);
                } else {
                    DataInfo dataInfo2 = new DataInfo();
                    dataInfo2.putData(YYInnerSSOLoginActivity.o, str);
                    dataInfo2.putData("mobile", str2);
                    a = aVar.a(aVar.i, "/api/netm/v1.0/qhbv", dataInfo2, new com.sdk.g.a(aVar), 0, f.a.b);
                }
                fVar.g = a;
                return;
            }
            SDKManager.toFailed(callBack, i2, str3);
        }
    }
}
