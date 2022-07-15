package com.repackage;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
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
import com.repackage.an4;
import com.repackage.en4;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class al7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements en4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ an4.a b;
        public final /* synthetic */ String c;

        public a(b bVar, an4.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = aVar;
            this.c = str;
        }

        @Override // com.repackage.en4.b
        public void onFailed() {
            an4.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.b) == null) {
                return;
            }
            aVar.a(this.c, 1, null);
        }

        @Override // com.repackage.en4.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d(str);
                this.a.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public final String b;
        public final String c;
        public final String d;
        public String e;
        public final an4.a f;
        public final boolean g;

        /* loaded from: classes5.dex */
        public class a implements an4.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.an4.a
            public void a(String str, int i, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                }
            }

            @Override // com.repackage.an4.a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // com.repackage.an4.a
            public void c(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public b(String str, String str2, String str3, an4.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.g = z;
            this.f = aVar == null ? new a(this) : aVar;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01b4  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            InterceptResult invokeL;
            AccountData accountData;
            int i;
            int i2;
            an4.b d;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.a.addPostData("bdusstoken", this.c + "|" + this.d);
                if (!StringUtils.isNull(this.e)) {
                    this.a.addPostData("stoken", this.e);
                }
                this.a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (!this.a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    gp4 gp4Var = new gp4();
                    gp4Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(gp4Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(gp4Var.b().getUserId());
                    String str = this.c;
                    if (this.g && (d = dl7.d(an4.b().c(str))) != null) {
                        str = d.a + "|" + d.b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(gp4Var.b().getPortrait());
                    accountData.setStoken(this.e);
                    accountData.setIsActive(1);
                    if (gp4Var.a() != null) {
                        accountData.setTbs(gp4Var.a().getTbs());
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                if (accountData != null) {
                    netWork.addPostData(HttpRequest.BDUSS, accountData.getBDUSS());
                    netWork.addPostData("stoken", en4.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                    i = 0;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(postNetData2);
                        JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i3 = 0; i3 < length; i3++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                                if (optJSONObject != null && CheckShowNameDialogSwitch.KEY.equals(optJSONObject.optString("name"))) {
                                    i = optJSONObject.optInt("type", 0);
                                    break;
                                }
                            }
                        }
                        i = 0;
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                            if (accountData != null && jSONObject2 != null) {
                                accountData.setNameShow(jSONObject2.optString("name_show"));
                            }
                        } catch (JSONException e) {
                            i2 = i;
                            e = e;
                            e.printStackTrace();
                            i = i2;
                            TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
                            return accountData;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        i2 = 0;
                    }
                }
                TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
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
                int i = 0;
                ReloginManager.g().o(false);
                mt4.a(DI.ACCOUNT, -1L, 0, "cslogin_result", this.a.getServerErrorCode(), this.a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f.c(accountData);
                    return;
                }
                String str = null;
                if (this.a != null) {
                    str = this.a.getErrorString();
                    i = this.a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f047b);
                }
                this.f.a(this.b, i, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f.b(this.b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, an4.a aVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, aVar)) == null) {
            en4 en4Var = new en4();
            b bVar = new b(str, str2, str3, aVar, false);
            if (en4.b() && StringUtils.isNull(str4)) {
                en4Var.c(str2, new a(bVar, aVar, str));
            } else {
                if (en4.b()) {
                    bVar.d(str4);
                }
                bVar.execute(new String[0]);
            }
            return bVar;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
