package d.a.s0.u.b.b;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v2.o0;
import d.a.q0.b.k.a;
import d.a.q0.b.l.b;
import d.a.q0.b.o.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f65624d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f65625e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.u.b.b.b f65626a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.q0.a.m.c> f65627b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f65628c;

    /* renamed from: d.a.s0.u.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1691a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65629a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1691a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65629a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 1) {
                    this.f65629a.r(TbadkCoreApplication.getInst());
                } else if (num.intValue() == 2) {
                    this.f65629a.v(SapiAccountManager.getInstance().isLogin());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65630e;

        public b(a aVar) {
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
            this.f65630e = aVar;
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
                this.f65630e.v(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                if (getUserInfoResult != null) {
                    this.f65630e.f65626a.f65649f = getUserInfoResult.portraitHttps;
                }
                this.f65630e.v(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.m.a f65631a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f65632b;

        /* renamed from: d.a.s0.u.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1692a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f65633e;

            public C1692a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65633e = cVar;
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
                    this.f65633e.f65631a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                    this.f65633e.f65631a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    this.f65633e.f65632b.f65626a.f65645b = SapiAccountManager.getInstance().getSession().bduss;
                    this.f65633e.f65632b.f65626a.f65651h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.f65633e.f65632b.f65626a.f65644a = getUserInfoResult.displayname;
                    this.f65633e.f65632b.f65626a.f65650g = getUserInfoResult.uid;
                    this.f65633e.f65632b.f65626a.f65649f = getUserInfoResult.portraitHttps;
                    d.a.q0.a.k2.g.h.a().putString("bd_box_display_name", this.f65633e.f65632b.f65626a.f65644a);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_uid", this.f65633e.f65632b.f65626a.f65650g);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f65633e.f65632b.f65626a.f65649f);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_bduss", this.f65633e.f65632b.f65626a.f65645b);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_ptoken", this.f65633e.f65632b.f65626a.f65651h);
                    this.f65633e.f65631a.onResult(0);
                    this.f65633e.f65632b.v(true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2, d.a.q0.a.m.a aVar2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65632b = aVar;
            this.f65631a = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1692a(this), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f65631a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.m.a f65634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f65635f;

        public d(a aVar, d.a.q0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65635f = aVar;
            this.f65634e = aVar2;
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
                this.f65634e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.f65634e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.f65635f.f65626a.f65645b = SapiAccountManager.getInstance().getSession().bduss;
                this.f65635f.f65626a.f65651h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f65635f.f65626a.f65644a = getUserInfoResult.displayname;
                this.f65635f.f65626a.f65650g = getUserInfoResult.uid;
                this.f65635f.f65626a.f65649f = getUserInfoResult.portraitHttps;
                d.a.q0.a.k2.g.h.a().putString("bd_box_display_name", this.f65635f.f65626a.f65644a);
                d.a.q0.a.k2.g.h.a().putString("bd_box_uid", this.f65635f.f65626a.f65650g);
                d.a.q0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f65635f.f65626a.f65649f);
                d.a.q0.a.k2.g.h.a().putString("bd_box_bduss", this.f65635f.f65626a.f65645b);
                d.a.q0.a.k2.g.h.a().putString("bd_box_ptoken", this.f65635f.f65626a.f65651h);
                this.f65635f.m();
                this.f65634e.onResult(0);
                this.f65635f.v(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65636e;

        public e(a aVar) {
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
            this.f65636e = aVar;
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
                this.f65636e.f65626a.f65645b = SapiAccountManager.getInstance().getSession().bduss;
                this.f65636e.f65626a.f65651h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f65636e.f65626a.f65644a = getUserInfoResult.displayname;
                this.f65636e.f65626a.f65650g = getUserInfoResult.uid;
                this.f65636e.f65626a.f65649f = getUserInfoResult.portraitHttps;
                d.a.q0.a.k2.g.h.a().putString("bd_box_display_name", this.f65636e.f65626a.f65644a);
                d.a.q0.a.k2.g.h.a().putString("bd_box_uid", this.f65636e.f65626a.f65650g);
                d.a.q0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f65636e.f65626a.f65649f);
                d.a.q0.a.k2.g.h.a().putString("bd_box_bduss", this.f65636e.f65626a.f65645b);
                d.a.q0.a.k2.g.h.a().putString("bd_box_ptoken", this.f65636e.f65626a.f65651h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends AddressManageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f65638f;

        public f(a aVar, String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65637e = str;
            this.f65638f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, addressManageResult) == null) {
                if ("0".equals(this.f65637e) || this.f65638f == null) {
                    if (a.f65625e) {
                        Log.d(a.f65624d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.f65625e) {
                        Log.d(a.f65624d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    this.f65638f.b();
                } else {
                    this.f65638f.a(addressManageResult.map.get("addrId"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends InvoiceBuildCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f65640f;

        public g(a aVar, String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65639e = str;
            this.f65640f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, invoiceBuildResult) == null) {
                if ("0".equals(this.f65639e) || this.f65640f == null) {
                    if (a.f65625e) {
                        Log.d(a.f65624d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.f65625e) {
                        Log.d(a.f65624d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    this.f65640f.b();
                } else {
                    this.f65640f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f65639e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f65641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f65642f;

        public h(a aVar, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65642f = aVar;
            this.f65641e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onFailure(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: d */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) == null) {
                this.f65642f.f65626a.f65646c = openBdussResult.openBduss;
                this.f65642f.f65626a.f65647d = openBdussResult.unionid;
                this.f65642f.f65626a.f65648e = openBdussResult.tplStokenMap;
                d.a.q0.a.k2.g.h.a().putString("bd_box_open_bduss", this.f65642f.f65626a.f65646c);
                d.a.q0.a.k2.g.h.a().putString("bd_box_union_id", this.f65642f.f65626a.f65647d);
                d.a.q0.a.k2.g.h.a().putString("bd_box_stoken", o0.s(this.f65642f.f65626a.f65648e));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, this.f65642f.f65626a.f65646c);
                    jSONObject.put("unionid", this.f65642f.f65626a.f65647d);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.f65642f.f65626a.f65648e.keySet()) {
                        jSONObject2.put(str, this.f65642f.f65626a.f65648e.get(str));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", this.f65642f.f65626a.f65650g);
                    jSONObject.put("bduss", this.f65642f.f65626a.f65645b);
                    jSONObject.put("displayname", this.f65642f.f65626a.f65644a);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f65641e.a(jSONObject.toString());
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

    /* loaded from: classes9.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f65643a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1173641258, "Ld/a/s0/u/b/b/a$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1173641258, "Ld/a/s0/u/b/b/a$i;");
                    return;
                }
            }
            f65643a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(356320251, "Ld/a/s0/u/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(356320251, "Ld/a/s0/u/b/b/a;");
                return;
            }
        }
        f65625e = k.f49133a;
    }

    public /* synthetic */ a(C1691a c1691a) {
        this();
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? i.f65643a : (a) invokeV.objValue;
    }

    public void f(d.a.q0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f65627b.add(cVar);
        }
    }

    public void g(Context context, String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar) == null) {
            AddressManageDTO addressManageDTO = new AddressManageDTO();
            addressManageDTO.type = str;
            addressManageDTO.sweepLightLoading = true;
            PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new f(this, str, dVar));
        }
    }

    public void h(Context context, String str, a.d dVar) {
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
            d.a.s0.u.b.b.b bVar = this.f65626a;
            if (bVar == null) {
                if (f65625e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f65649f)) {
                o();
            }
            return this.f65626a.f65649f;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.s0.u.b.b.b bVar = this.f65626a;
            if (bVar == null) {
                if (f65625e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f65645b)) {
                o();
            }
            return this.f65626a.f65645b;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.s0.u.b.b.b bVar = this.f65626a;
            if (bVar == null) {
                if (f65625e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f65644a)) {
                o();
            }
            return this.f65626a.f65644a;
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, arrayList, cVar) == null) {
            if (this.f65626a == null) {
                if (f65625e) {
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
            d.a.s0.u.b.b.b bVar = this.f65626a;
            if (bVar == null) {
                if (f65625e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f65650g)) {
                o();
            }
            return this.f65626a.f65650g;
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
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.f65626a == null) {
            d.a.s0.u.b.b.b bVar = new d.a.s0.u.b.b.b();
            this.f65626a = bVar;
            bVar.f65649f = d.a.q0.a.k2.g.h.a().getString("bd_box_avatar_url", "");
            this.f65626a.f65645b = d.a.q0.a.k2.g.h.a().getString("bd_box_bduss", "");
            this.f65626a.f65651h = d.a.q0.a.k2.g.h.a().getString("bd_box_ptoken", "");
            this.f65626a.f65650g = d.a.q0.a.k2.g.h.a().getString("bd_box_uid", "");
            this.f65626a.f65646c = d.a.q0.a.k2.g.h.a().getString("bd_box_open_bduss", "");
            this.f65626a.f65647d = d.a.q0.a.k2.g.h.a().getString("bd_box_union_id", "");
            this.f65626a.f65648e = o0.t(d.a.q0.a.k2.g.h.a().getString("bd_box_stoken", ""));
            this.f65626a.f65644a = d.a.q0.a.k2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.s0.u.b.b.b bVar = this.f65626a;
            if (bVar != null && TextUtils.isEmpty(bVar.f65645b)) {
                o();
            }
            return SapiAccountManager.getInstance().isLogin();
        }
        return invokeV.booleanValue;
    }

    public void t(Context context, Bundle bundle, d.a.q0.a.m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, bundle, aVar) == null) {
            if (this.f65626a == null) {
                this.f65626a = new d.a.s0.u.b.b.b();
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
            loginActivityConfig.getIntent().putExtra(IntentConfig.CLOSE, true);
            if (bundle != null && (i2 = bundle.getInt("key_login_mode", 1)) > 1) {
                if (i2 == 4) {
                    i2 = 1;
                }
                loginActivityConfig.setIsFromAiapp(true);
                loginActivityConfig.setThirdPartyLoginForResult(i2, "");
            }
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
            MessageManager.getInstance().registerListener(new c(this, 2921362, aVar));
        }
    }

    public void u(d.a.q0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            SapiAccountManager.getInstance().logout();
            v(false);
            this.f65626a = new d.a.s0.u.b.b.b();
            d.a.q0.a.k2.g.h.a().putString("bd_box_display_name", "");
            d.a.q0.a.k2.g.h.a().putString("bd_box_uid", "");
            d.a.q0.a.k2.g.h.a().putString("bd_box_avatar_url", "");
            d.a.q0.a.k2.g.h.a().putString("bd_box_bduss", "");
            d.a.q0.a.k2.g.h.a().putString("bd_box_ptoken", "");
            if (aVar != null) {
                aVar.onResult(0);
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            for (d.a.q0.a.m.c cVar : this.f65627b) {
                cVar.a(z);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(this.f65628c);
        }
    }

    public void x(d.a.q0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(this, aVar), SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, getUserInfoResult) == null) {
            if (getUserInfoResult != null) {
                try {
                    d.a.q0.a.k2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                    if (this.f65626a == null) {
                        this.f65626a = new d.a.s0.u.b.b.b();
                    }
                    this.f65626a.f65645b = SapiAccountManager.getInstance().getSession().bduss;
                    this.f65626a.f65651h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.f65626a.f65644a = getUserInfoResult.displayname;
                    this.f65626a.f65650g = getUserInfoResult.uid;
                    this.f65626a.f65649f = getUserInfoResult.portraitHttps;
                    d.a.q0.a.k2.g.h.a().putString("bd_box_display_name", this.f65626a.f65644a);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_uid", this.f65626a.f65650g);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f65626a.f65649f);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_bduss", this.f65626a.f65645b);
                    d.a.q0.a.k2.g.h.a().putString("bd_box_ptoken", this.f65626a.f65651h);
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(this), this.f65626a.f65645b);
                    return;
                } catch (Exception e2) {
                    if (f65625e) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            u(null);
        }
    }

    public a() {
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
        this.f65628c = new C1691a(this, 2921537);
        this.f65627b = new ArrayList();
    }
}
