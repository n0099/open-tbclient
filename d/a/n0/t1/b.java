package d.a.n0.t1;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.CheckShowNameDialogSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.m0.r.l.a;
import d.a.m0.r.l.e;
import d.a.m0.r.q.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1667b f64565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1197a f64566b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f64567c;

        public a(C1667b c1667b, a.InterfaceC1197a interfaceC1197a, String str) {
            this.f64565a = c1667b;
            this.f64566b = interfaceC1197a;
            this.f64567c = str;
        }

        @Override // d.a.m0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1197a interfaceC1197a = this.f64566b;
            if (interfaceC1197a != null) {
                interfaceC1197a.a(this.f64567c, 1, null);
            }
        }

        @Override // d.a.m0.r.l.e.b
        public void onSuccess(String str) {
            this.f64565a.d(str);
            this.f64565a.execute(new String[0]);
        }
    }

    /* renamed from: d.a.n0.t1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1667b extends BdAsyncTask<String, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f64568a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f64569b;

        /* renamed from: c  reason: collision with root package name */
        public final String f64570c;

        /* renamed from: d  reason: collision with root package name */
        public final String f64571d;

        /* renamed from: e  reason: collision with root package name */
        public String f64572e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1197a f64573f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f64574g;

        /* renamed from: d.a.n0.t1.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements a.InterfaceC1197a {
            public a(C1667b c1667b) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1197a
            public void a(String str, int i2, String str2) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1197a
            public void b(String str) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1197a
            public void c(AccountData accountData) {
            }
        }

        public C1667b(String str, String str2, String str3, a.InterfaceC1197a interfaceC1197a, boolean z) {
            this.f64569b = str;
            this.f64570c = str2;
            this.f64571d = str3;
            this.f64574g = z;
            this.f64573f = interfaceC1197a == null ? new a(this) : interfaceC1197a;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01de  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            AccountData accountData;
            int i2;
            int i3;
            a.b d2;
            this.f64568a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
            this.f64568a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            this.f64568a.addPostData("bdusstoken", this.f64570c + "|" + this.f64571d);
            if (!StringUtils.isNull(this.f64572e)) {
                this.f64568a.addPostData("stoken", this.f64572e);
            }
            this.f64568a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.f64568a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.f64568a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f64568a.postNetData();
            if (!this.f64568a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                accountData = null;
            } else {
                q0 q0Var = new q0();
                q0Var.c(postNetData);
                accountData = new AccountData();
                accountData.setAccount(q0Var.b().getUserName());
                accountData.setPassword("");
                accountData.setID(q0Var.b().getUserId());
                String str = this.f64570c;
                if (this.f64574g && (d2 = e.d(d.a.m0.r.l.a.b().d(str))) != null) {
                    str = d2.f53539a + "|" + d2.f53540b;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(q0Var.b().getPortrait());
                if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                }
                accountData.setStoken(this.f64572e);
                accountData.setIsActive(1);
                if (q0Var.a() != null) {
                    accountData.setTbs(q0Var.a().getTbs());
                }
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
            netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                netWork.addPostData(HttpRequest.BDUSS, accountData.getBDUSS());
                netWork.addPostData("stoken", d.a.m0.r.l.e.a(accountData));
            }
            String postNetData2 = netWork.postNetData();
            if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                i2 = 0;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(postNetData2);
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
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                        if (accountData != null && jSONObject2 != null) {
                            accountData.setNameShow(jSONObject2.optString("name_show"));
                        }
                    } catch (JSONException e2) {
                        i3 = i2;
                        e = e2;
                        e.printStackTrace();
                        i2 = i3;
                        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                        return accountData;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i3 = 0;
                }
            }
            TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
            return accountData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            int i2 = 0;
            ReloginManager.g().o(false);
            d.a.m0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f64568a.getServerErrorCode(), this.f64568a.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.f64573f.c(accountData);
                return;
            }
            String str = null;
            if (this.f64568a != null) {
                str = this.f64568a.getErrorString();
                i2 = this.f64568a.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.f64573f.a(this.f64569b, i2, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f64568a != null) {
                this.f64568a.cancelNetConnect();
            }
        }

        public void d(String str) {
            this.f64572e = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.f64573f.b(this.f64569b);
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1197a interfaceC1197a) {
        d.a.m0.r.l.e eVar = new d.a.m0.r.l.e();
        C1667b c1667b = new C1667b(str, str2, str3, interfaceC1197a, false);
        if (d.a.m0.r.l.e.b() && StringUtils.isNull(str4)) {
            eVar.c(str2, new a(c1667b, interfaceC1197a, str));
        } else {
            if (d.a.m0.r.l.e.b()) {
                c1667b.d(str4);
            }
            c1667b.execute(new String[0]);
        }
        return c1667b;
    }
}
