package com.dxmpay.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.paysdk.ui.PassNormalizeActivity;
import java.util.Map;
/* loaded from: classes3.dex */
public final class PassUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ACCOUNT = "pass_account";
    public static final String PASS_ACCOUNT_TYPE = "pass_account_type";
    public static final String PASS_AUTH_SID = "pass_auth_sid";
    public static final String PASS_BDUSS = "pass_bduss";
    public static final String PASS_DISPLAY_NAME = "pass_display_name";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_NEW_REQ = "pass_new_req";
    public static final String PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String PASS_PASSWORD = "pass_code";
    public static final String PASS_PTOKEN = "pass_ptoken";
    public static final String PASS_SID = "pass_sid";
    public static final String PASS_STOKEN = "pass_stoken";
    public static final String PASS_TYPE = "pass_util_type";
    public static final String PASS_UBI = "pass_ubi";
    public static final String PASS_UID = "pass_uid";
    public static final String PASS_UNION_ID = "pass_union_id";
    public static final String PASS_USER_NAEME = "pass_user_name";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static IPassNormalize f54022b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f54023c;

    /* renamed from: d  reason: collision with root package name */
    public static IPassNormalize f54024d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface IPassNormalize {
        boolean onNormalize(Context context, int i2, Map<String, String> map);
    }

    /* loaded from: classes3.dex */
    public static class PassNormalize implements IPassNormalize {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PassNormalize() {
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

        @Override // com.dxmpay.wallet.core.utils.PassUtil.IPassNormalize
        public boolean onNormalize(Context context, int i2, Map<String, String> map) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, map)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("统一处理正常化 type=");
                sb.append(i2);
                sb.append("#map=");
                sb.append(map == null);
                sb.toString();
                if (i2 == 1 && map != null) {
                    String str = map.get("pass_open_bduss");
                    if ("0".equals(map.get("pass_error_code")) && !TextUtils.isEmpty(str)) {
                        IPassNormalize iPassNormalize = PassUtil.f54024d;
                        if (iPassNormalize != null) {
                            iPassNormalize.onNormalize(context, i2, map);
                        }
                        return true;
                    }
                }
                return i2 == 2 && map != null;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends Web2NativeLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f54025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f54027g;

        /* renamed from: com.dxmpay.wallet.core.utils.PassUtil$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C2063a implements ILoginBackListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f54028e;

            public C2063a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54028e = aVar;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    if (PassUtil.f54022b != null) {
                        IPassNormalize iPassNormalize = PassUtil.f54022b;
                        a aVar = this.f54028e;
                        iPassNormalize.onNormalize(aVar.f54025e, aVar.f54026f, aVar.f54027g);
                    }
                    IPassNormalize unused = PassUtil.f54022b = null;
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    this.f54028e.f54027g.put("pass_open_bduss", str);
                    if (PassUtil.f54022b != null) {
                        IPassNormalize iPassNormalize = PassUtil.f54022b;
                        a aVar = this.f54028e;
                        iPassNormalize.onNormalize(aVar.f54025e, aVar.f54026f, aVar.f54027g);
                    }
                    IPassNormalize unused = PassUtil.f54022b = null;
                }
            }
        }

        public a(Context context, int i2, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54025e = context;
            this.f54026f = i2;
            this.f54027g = map;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        /* renamed from: a */
        public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, web2NativeLoginResult) == null) {
                if (PassUtil.f54022b != null) {
                    PassUtil.f54022b.onNormalize(this.f54025e, this.f54026f, this.f54027g);
                }
                IPassNormalize unused = PassUtil.f54022b = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, web2NativeLoginResult) == null) {
                WalletLoginHelper.getInstance().getOpenBduss(true, new C2063a(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, web2NativeLoginResult) == null) {
                if (PassUtil.f54022b != null) {
                    PassUtil.f54022b.onNormalize(this.f54025e, this.f54026f, this.f54027g);
                }
                IPassNormalize unused = PassUtil.f54022b = null;
            }
        }

        @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
        public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, web2NativeLoginResult) == null) {
                if (PassUtil.f54022b != null) {
                    PassUtil.f54022b.onNormalize(this.f54025e, this.f54026f, this.f54027g);
                }
                IPassNormalize unused = PassUtil.f54022b = null;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(682388746, "Lcom/dxmpay/wallet/core/utils/PassUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(682388746, "Lcom/dxmpay/wallet/core/utils/PassUtil;");
                return;
            }
        }
        f54023c = new Object();
    }

    public PassUtil() {
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

    public static void backNormalized(Context context, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, map) == null) {
            if (map != null && !TextUtils.isEmpty(map.get("pass_error_code")) && "0".equals(map.get("pass_error_code"))) {
                SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new a(context, i2, map), true);
                return;
            }
            IPassNormalize iPassNormalize = f54022b;
            if (iPassNormalize != null) {
                iPassNormalize.onNormalize(context, i2, map);
            }
            f54022b = null;
        }
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - a;
            String str = "wait =" + currentTimeMillis;
            if (currentTimeMillis >= 500 || currentTimeMillis <= 0) {
                return 0L;
            }
            String str2 = "需要wait =" + currentTimeMillis;
            return currentTimeMillis;
        }
        return invokeV.longValue;
    }

    public static void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = System.currentTimeMillis();
        }
    }

    public static void passNormalized(Context context, String str, int i2, IPassNormalize iPassNormalize) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65543, null, context, str, i2, iPassNormalize) == null) || iPassNormalize == null || context == null) {
            return;
        }
        long c2 = c();
        if (c2 > 0) {
            try {
                synchronized (f54023c) {
                    f54023c.wait(c2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        f54022b = iPassNormalize;
        Intent intent = new Intent(context, PassNormalizeActivity.class);
        intent.putExtra("normalize_url", str);
        intent.putExtra("pass_util_type", i2);
        context.startActivity(intent);
    }

    public static void registerPassNormalize(IPassNormalize iPassNormalize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iPassNormalize) == null) {
            f54024d = iPassNormalize;
        }
    }
}
