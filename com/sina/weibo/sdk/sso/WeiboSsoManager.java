package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.WeiboSsoSdk;
import d.m.a.a;
import d.m.a.b;
import d.m.a.c;
/* loaded from: classes7.dex */
public final class WeiboSsoManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WeiboSsoManager";
    public transient /* synthetic */ FieldHolder $fh;
    public String aid;

    /* loaded from: classes7.dex */
    public static class Instance {
        public static /* synthetic */ Interceptable $ic;
        public static final WeiboSsoManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859409760, "Lcom/sina/weibo/sdk/sso/WeiboSsoManager$Instance;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-859409760, "Lcom/sina/weibo/sdk/sso/WeiboSsoManager$Instance;");
                    return;
                }
            }
            instance = new WeiboSsoManager();
        }

        public Instance() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static synchronized WeiboSsoManager getInstance() {
        InterceptResult invokeV;
        WeiboSsoManager weiboSsoManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (WeiboSsoManager.class) {
                weiboSsoManager = Instance.instance;
            }
            return weiboSsoManager;
        }
        return (WeiboSsoManager) invokeV.objValue;
    }

    private void initAid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            try {
                WeiboSsoSdk.i().m(new b(this) { // from class: com.sina.weibo.sdk.sso.WeiboSsoManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WeiboSsoManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // d.m.a.b
                    public void handler(WeiboSsoSdk.d dVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                            if (dVar != null) {
                                this.this$0.aid = dVar.a();
                                return;
                            }
                            LogUtil.d(WeiboSsoManager.TAG, "VisitorLoginInfo is null.");
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.e(TAG, e2.getMessage());
            }
        }
    }

    public String getAid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            LogUtil.d(TAG, "getAid()");
            if (TextUtils.isEmpty(this.aid)) {
                init(context, str);
            }
            return this.aid;
        }
        return (String) invokeLL.objValue;
    }

    public String getMfp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? a.n(context) : (String) invokeL.objValue;
    }

    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            LogUtil.d(TAG, "init config");
            c cVar = new c();
            cVar.l(context);
            cVar.k(str);
            cVar.m("1478195010");
            cVar.n("1000_0001");
            WeiboSsoSdk.j(cVar);
            initAid();
        }
    }

    public WeiboSsoManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
