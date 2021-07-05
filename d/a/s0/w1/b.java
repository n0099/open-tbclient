package d.a.s0.w1;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.CheckShowNameDialogSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.l.a;
import d.a.r0.r.l.e;
import d.a.r0.r.q.r0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1866b f68958a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1260a f68959b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68960c;

        public a(C1866b c1866b, a.InterfaceC1260a interfaceC1260a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1866b, interfaceC1260a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68958a = c1866b;
            this.f68959b = interfaceC1260a;
            this.f68960c = str;
        }

        @Override // d.a.r0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1260a interfaceC1260a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC1260a = this.f68959b) == null) {
                return;
            }
            interfaceC1260a.a(this.f68960c, 1, null);
        }

        @Override // d.a.r0.r.l.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f68958a.d(str);
                this.f68958a.execute(new String[0]);
            }
        }
    }

    /* renamed from: d.a.s0.w1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1866b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f68961a;

        /* renamed from: b  reason: collision with root package name */
        public final String f68962b;

        /* renamed from: c  reason: collision with root package name */
        public final String f68963c;

        /* renamed from: d  reason: collision with root package name */
        public final String f68964d;

        /* renamed from: e  reason: collision with root package name */
        public String f68965e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1260a f68966f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f68967g;

        /* renamed from: d.a.s0.w1.b$b$a */
        /* loaded from: classes9.dex */
        public class a implements a.InterfaceC1260a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1866b c1866b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1866b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.l.a.InterfaceC1260a
            public void a(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                }
            }

            @Override // d.a.r0.r.l.a.InterfaceC1260a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // d.a.r0.r.l.a.InterfaceC1260a
            public void c(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1866b(String str, String str2, String str3, a.InterfaceC1260a interfaceC1260a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC1260a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68961a = null;
            this.f68962b = str;
            this.f68963c = str2;
            this.f68964d = str3;
            this.f68967g = z;
            this.f68966f = interfaceC1260a == null ? new a(this) : interfaceC1260a;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01e1  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            InterceptResult invokeL;
            AccountData accountData;
            int i2;
            int i3;
            JSONObject jSONObject;
            a.b d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.f68961a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.f68961a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.f68961a.addPostData("bdusstoken", this.f68963c + "|" + this.f68964d);
                if (!StringUtils.isNull(this.f68965e)) {
                    this.f68961a.addPostData("stoken", this.f68965e);
                }
                this.f68961a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.f68961a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.f68961a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f68961a.postNetData();
                if (!this.f68961a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    r0 r0Var = new r0();
                    r0Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(r0Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(r0Var.b().getUserId());
                    String str = this.f68963c;
                    if (this.f68967g && (d2 = e.d(d.a.r0.r.l.a.b().d(str))) != null) {
                        str = d2.f55783a + "|" + d2.f55784b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(r0Var.b().getPortrait());
                    if (r0Var.b() != null && r0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(r0Var.b().getBaijiahaoInfo().avatar)) {
                        accountData.setBjhAvatar(r0Var.b().getBaijiahaoInfo().avatar);
                    }
                    accountData.setStoken(this.f68965e);
                    accountData.setIsActive(1);
                    if (r0Var.a() != null) {
                        accountData.setTbs(r0Var.a().getTbs());
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                if (accountData != null) {
                    netWork.addPostData(HttpRequest.BDUSS, accountData.getBDUSS());
                    netWork.addPostData("stoken", d.a.r0.r.l.e.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                    i2 = 0;
                } else {
                    try {
                        jSONObject = new JSONObject(postNetData2);
                        JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                                if (optJSONObject != null && CheckShowNameDialogSwitch.KEY.equals(optJSONObject.optString("name"))) {
                                    i2 = optJSONObject.optInt("type", 0);
                                    break;
                                }
                            }
                        }
                        i2 = 0;
                    } catch (JSONException e2) {
                        e = e2;
                        i3 = 0;
                    }
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                        if (accountData != null && jSONObject2 != null) {
                            accountData.setNameShow(jSONObject2.optString("name_show"));
                        }
                    } catch (JSONException e3) {
                        i3 = i2;
                        e = e3;
                        e.printStackTrace();
                        i2 = i3;
                        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                        return accountData;
                    }
                }
                TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                return accountData;
            }
            return (AccountData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
                super.onPostExecute(accountData);
                int i2 = 0;
                ReloginManager.g().o(false);
                d.a.r0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f68961a.getServerErrorCode(), this.f68961a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f68966f.c(accountData);
                    return;
                }
                String str = null;
                if (this.f68961a != null) {
                    str = this.f68961a.getErrorString();
                    i2 = this.f68961a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f68966f.a(this.f68962b, i2, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.f68961a != null) {
                    this.f68961a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f68965e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f68966f.b(this.f68962b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1260a interfaceC1260a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC1260a)) == null) {
            d.a.r0.r.l.e eVar = new d.a.r0.r.l.e();
            C1866b c1866b = new C1866b(str, str2, str3, interfaceC1260a, false);
            if (d.a.r0.r.l.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1866b, interfaceC1260a, str));
            } else {
                if (d.a.r0.r.l.e.b()) {
                    c1866b.d(str4);
                }
                c1866b.execute(new String[0]);
            }
            return c1866b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
