package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iac;
import com.baidu.tieba.jac;
import com.baidu.tieba.kac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.WeiboSsoSdk;
/* loaded from: classes10.dex */
public final class WeiboSsoManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WeiboSsoManager";
    public transient /* synthetic */ FieldHolder $fh;
    public String aid;

    /* loaded from: classes10.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public WeiboSsoManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                WeiboSsoSdk.i().m(new jac(this) { // from class: com.sina.weibo.sdk.sso.WeiboSsoManager.1
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.tieba.jac
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
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e(TAG, e.getMessage());
            }
        }
    }

    public String getMfp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return iac.n(context);
        }
        return (String) invokeL.objValue;
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

    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            LogUtil.d(TAG, "init config");
            kac kacVar = new kac();
            kacVar.j(context);
            kacVar.i(str);
            kacVar.k("1478195010");
            kacVar.l("1000_0001");
            WeiboSsoSdk.j(kacVar);
            initAid();
        }
    }
}
