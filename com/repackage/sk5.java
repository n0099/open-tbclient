package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kg3;
import com.repackage.og3;
import com.repackage.zh3;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sk5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "sk5";
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public tk5 a;
    public List<vf1> b;
    public final CustomMessageListener c;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sk5 sk5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, Integer.valueOf(i)};
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
            this.a = sk5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 1) {
                    this.a.r(TbadkCoreApplication.getInst());
                } else if (num.intValue() == 2) {
                    this.a.v(SapiAccountManager.getInstance().isLogin());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk5 a;

        public b(sk5 sk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.a.v(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                if (getUserInfoResult != null) {
                    this.a.a.f = getUserInfoResult.portraitHttps;
                }
                this.a.v(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf1 a;
        public final /* synthetic */ sk5 b;

        /* loaded from: classes7.dex */
        public class a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                    this.a.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                    this.a.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    this.a.b.a.b = SapiAccountManager.getInstance().getSession().bduss;
                    this.a.b.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.a.b.a.a = getUserInfoResult.displayname;
                    this.a.b.a.g = getUserInfoResult.uid;
                    this.a.b.a.f = getUserInfoResult.portraitHttps;
                    v73.a().putString("bd_box_display_name", this.a.b.a.a);
                    v73.a().putString("bd_box_uid", this.a.b.a.g);
                    v73.a().putString("bd_box_avatar_url", this.a.b.a.f);
                    v73.a().putString("bd_box_bduss", this.a.b.a.b);
                    v73.a().putString("bd_box_ptoken", this.a.b.a.h);
                    this.a.a.onResult(0);
                    this.a.b.v(true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sk5 sk5Var, int i, tf1 tf1Var) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, Integer.valueOf(i), tf1Var};
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
            this.b = sk5Var;
            this.a = tf1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new a(this), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf1 a;
        public final /* synthetic */ sk5 b;

        public d(sk5 sk5Var, tf1 tf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, tf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sk5Var;
            this.a = tf1Var;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                this.a.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.a.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.b.a.b = SapiAccountManager.getInstance().getSession().bduss;
                this.b.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.b.a.a = getUserInfoResult.displayname;
                this.b.a.g = getUserInfoResult.uid;
                this.b.a.f = getUserInfoResult.portraitHttps;
                v73.a().putString("bd_box_display_name", this.b.a.a);
                v73.a().putString("bd_box_uid", this.b.a.g);
                v73.a().putString("bd_box_avatar_url", this.b.a.f);
                v73.a().putString("bd_box_bduss", this.b.a.b);
                v73.a().putString("bd_box_ptoken", this.b.a.h);
                this.b.m();
                this.a.onResult(0);
                this.b.v(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk5 a;

        public e(sk5 sk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.a.a.b = SapiAccountManager.getInstance().getSession().bduss;
                this.a.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.a.a.a = getUserInfoResult.displayname;
                this.a.a.g = getUserInfoResult.uid;
                this.a.a.f = getUserInfoResult.portraitHttps;
                v73.a().putString("bd_box_display_name", this.a.a.a);
                v73.a().putString("bd_box_uid", this.a.a.g);
                v73.a().putString("bd_box_avatar_url", this.a.a.f);
                v73.a().putString("bd_box_bduss", this.a.a.b);
                v73.a().putString("bd_box_ptoken", this.a.a.h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends AddressManageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kg3.d b;

        public f(sk5 sk5Var, String str, kg3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, addressManageResult) == null) {
                if ("0".equals(this.a) || this.b == null) {
                    if (sk5.e) {
                        Log.d(sk5.d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (sk5.e) {
                        Log.d(sk5.d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    this.b.c();
                } else {
                    this.b.b(addressManageResult.map.get("addrId"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends InvoiceBuildCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zh3.d b;

        public g(sk5 sk5Var, String str, zh3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, invoiceBuildResult) == null) {
                if ("0".equals(this.a) || this.b == null) {
                    if (sk5.e) {
                        Log.d(sk5.d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (sk5.e) {
                        Log.d(sk5.d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    this.b.c();
                } else {
                    this.b.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og3.c a;
        public final /* synthetic */ sk5 b;

        public h(sk5 sk5Var, og3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk5Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sk5Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) == null) {
                this.b.a.c = openBdussResult.openBduss;
                this.b.a.d = openBdussResult.unionid;
                this.b.a.e = openBdussResult.tplStokenMap;
                v73.a().putString("bd_box_open_bduss", this.b.a.c);
                v73.a().putString("bd_box_union_id", this.b.a.d);
                v73.a().putString("bd_box_stoken", zc3.s(this.b.a.e));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, this.b.a.c);
                    jSONObject.put("unionid", this.b.a.d);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.b.a.e.keySet()) {
                        jSONObject2.put(str, this.b.a.e.get(str));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", this.b.a.g);
                    jSONObject.put("bduss", this.b.a.b);
                    jSONObject.put("displayname", this.b.a.a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.a.a(jSONObject.toString());
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public static final sk5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-10801649, "Lcom/repackage/sk5$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-10801649, "Lcom/repackage/sk5$i;");
                    return;
                }
            }
            a = new sk5(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755317644, "Lcom/repackage/sk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755317644, "Lcom/repackage/sk5;");
                return;
            }
        }
        e = rf1.a;
    }

    public /* synthetic */ sk5(a aVar) {
        this();
    }

    public static sk5 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? i.a : (sk5) invokeV.objValue;
    }

    public void f(vf1 vf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vf1Var) == null) {
            this.b.add(vf1Var);
        }
    }

    public void g(Context context, String str, kg3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar) == null) {
            AddressManageDTO addressManageDTO = new AddressManageDTO();
            addressManageDTO.type = str;
            addressManageDTO.sweepLightLoading = true;
            PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new f(this, str, dVar));
        }
    }

    public void h(Context context, String str, zh3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, dVar) == null) {
            InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
            invoiceBuildDTO.TYPE = str;
            PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new g(this, str, dVar));
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            tk5 tk5Var = this.a;
            if (tk5Var == null) {
                if (e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(tk5Var.f)) {
                o();
            }
            return this.a.f;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tk5 tk5Var = this.a;
            if (tk5Var == null) {
                if (e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(tk5Var.b)) {
                o();
            }
            return this.a.b;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tk5 tk5Var = this.a;
            if (tk5Var == null) {
                if (e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(tk5Var.a)) {
                o();
            }
            return this.a.a;
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void n(String str, ArrayList<String> arrayList, og3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, arrayList, cVar) == null) {
            if (this.a == null) {
                if (e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return;
            }
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = str;
            getOpenBdussDTO.targetTplList.addAll(arrayList);
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new h(this, cVar));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                SapiAccountManager.getInstance().getConfignation();
            } catch (Exception unused) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
            }
            try {
                SapiAccountManager.getInstance().isLogin();
                if (SapiAccountManager.getInstance().isLogin()) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new e(this), SapiAccountManager.getInstance().getSession().bduss);
                }
            } catch (NullPointerException unused2) {
            }
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            tk5 tk5Var = this.a;
            if (tk5Var == null) {
                if (e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(tk5Var.g)) {
                o();
            }
            return this.a.g;
        }
        return (String) invokeV.objValue;
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            w();
            r(context);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.a == null) {
            tk5 tk5Var = new tk5();
            this.a = tk5Var;
            tk5Var.f = v73.a().getString("bd_box_avatar_url", "");
            this.a.b = v73.a().getString("bd_box_bduss", "");
            this.a.h = v73.a().getString("bd_box_ptoken", "");
            this.a.g = v73.a().getString("bd_box_uid", "");
            this.a.c = v73.a().getString("bd_box_open_bduss", "");
            this.a.d = v73.a().getString("bd_box_union_id", "");
            this.a.e = zc3.t(v73.a().getString("bd_box_stoken", ""));
            this.a.a = v73.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            tk5 tk5Var = this.a;
            if (tk5Var != null && TextUtils.isEmpty(tk5Var.b)) {
                o();
            }
            return SapiAccountManager.getInstance().isLogin();
        }
        return invokeV.booleanValue;
    }

    public void t(Context context, Bundle bundle, tf1 tf1Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, bundle, tf1Var) == null) {
            if (this.a == null) {
                this.a = new tk5();
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
            loginActivityConfig.getIntent().putExtra("close", true);
            if (bundle != null && (i2 = bundle.getInt("key_login_mode", 1)) > 1) {
                if (i2 == 4) {
                    i2 = 1;
                }
                loginActivityConfig.setIsFromAiapp(true);
                loginActivityConfig.setThirdPartyLoginForResult(i2, "");
            }
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
            MessageManager.getInstance().registerListener(new c(this, 2921362, tf1Var));
        }
    }

    public void u(tf1 tf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tf1Var) == null) {
            SapiAccountManager.getInstance().logout();
            v(false);
            this.a = new tk5();
            v73.a().putString("bd_box_display_name", "");
            v73.a().putString("bd_box_uid", "");
            v73.a().putString("bd_box_avatar_url", "");
            v73.a().putString("bd_box_bduss", "");
            v73.a().putString("bd_box_ptoken", "");
            if (tf1Var != null) {
                tf1Var.onResult(0);
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            for (vf1 vf1Var : this.b) {
                if (vf1Var != null) {
                    vf1Var.a(z);
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public void x(tf1 tf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tf1Var) == null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(this, tf1Var), SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, getUserInfoResult) == null) {
            if (getUserInfoResult != null) {
                try {
                    v73.a().putString("host_account_info_string", getUserInfoResult.toString());
                    if (this.a == null) {
                        this.a = new tk5();
                    }
                    this.a.b = SapiAccountManager.getInstance().getSession().bduss;
                    this.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.a.a = getUserInfoResult.displayname;
                    this.a.g = getUserInfoResult.uid;
                    this.a.f = getUserInfoResult.portraitHttps;
                    v73.a().putString("bd_box_display_name", this.a.a);
                    v73.a().putString("bd_box_uid", this.a.g);
                    v73.a().putString("bd_box_avatar_url", this.a.f);
                    v73.a().putString("bd_box_bduss", this.a.b);
                    v73.a().putString("bd_box_ptoken", this.a.h);
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(this), this.a.b);
                    return;
                } catch (Exception e2) {
                    if (e) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            u(null);
        }
    }

    public sk5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this, 2921537);
        this.b = new ArrayList();
    }
}
