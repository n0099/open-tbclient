package d.a.n0.t1;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.FieldBuilder;
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
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1611b f60873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1141a f60874b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60875c;

        public a(C1611b c1611b, a.InterfaceC1141a interfaceC1141a, String str) {
            this.f60873a = c1611b;
            this.f60874b = interfaceC1141a;
            this.f60875c = str;
        }

        @Override // d.a.m0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1141a interfaceC1141a = this.f60874b;
            if (interfaceC1141a != null) {
                interfaceC1141a.a(this.f60875c, 1, null);
            }
        }

        @Override // d.a.m0.r.l.e.b
        public void onSuccess(String str) {
            this.f60873a.d(str);
            this.f60873a.execute(new String[0]);
        }
    }

    /* renamed from: d.a.n0.t1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1611b extends BdAsyncTask<String, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f60876a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f60877b;

        /* renamed from: c  reason: collision with root package name */
        public final String f60878c;

        /* renamed from: d  reason: collision with root package name */
        public final String f60879d;

        /* renamed from: e  reason: collision with root package name */
        public String f60880e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1141a f60881f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f60882g;

        /* renamed from: d.a.n0.t1.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements a.InterfaceC1141a {
            public a(C1611b c1611b) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1141a
            public void a(String str, int i2, String str2) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1141a
            public void b(String str) {
            }

            @Override // d.a.m0.r.l.a.InterfaceC1141a
            public void c(AccountData accountData) {
            }
        }

        public C1611b(String str, String str2, String str3, a.InterfaceC1141a interfaceC1141a, boolean z) {
            this.f60877b = str;
            this.f60878c = str2;
            this.f60879d = str3;
            this.f60882g = z;
            this.f60881f = interfaceC1141a == null ? new a(this) : interfaceC1141a;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01dd  */
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
            this.f60876a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
            this.f60876a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            this.f60876a.addPostData("bdusstoken", this.f60878c + FieldBuilder.SE + this.f60879d);
            if (!StringUtils.isNull(this.f60880e)) {
                this.f60876a.addPostData("stoken", this.f60880e);
            }
            this.f60876a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.f60876a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.f60876a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f60876a.postNetData();
            if (!this.f60876a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                accountData = null;
            } else {
                q0 q0Var = new q0();
                q0Var.c(postNetData);
                accountData = new AccountData();
                accountData.setAccount(q0Var.b().getUserName());
                accountData.setPassword("");
                accountData.setID(q0Var.b().getUserId());
                String str = this.f60878c;
                if (this.f60882g && (d2 = e.d(d.a.m0.r.l.a.b().d(str))) != null) {
                    str = d2.f49863a + FieldBuilder.SE + d2.f49864b;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(q0Var.b().getPortrait());
                if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                }
                accountData.setStoken(this.f60880e);
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
            d.a.m0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f60876a.getServerErrorCode(), this.f60876a.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.f60881f.c(accountData);
                return;
            }
            String str = null;
            if (this.f60876a != null) {
                str = this.f60876a.getErrorString();
                i2 = this.f60876a.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.f60881f.a(this.f60877b, i2, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f60876a != null) {
                this.f60876a.cancelNetConnect();
            }
        }

        public void d(String str) {
            this.f60880e = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.f60881f.b(this.f60877b);
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1141a interfaceC1141a) {
        d.a.m0.r.l.e eVar = new d.a.m0.r.l.e();
        C1611b c1611b = new C1611b(str, str2, str3, interfaceC1141a, false);
        if (d.a.m0.r.l.e.b() && StringUtils.isNull(str4)) {
            eVar.c(str2, new a(c1611b, interfaceC1141a, str));
        } else {
            if (d.a.m0.r.l.e.b()) {
                c1611b.d(str4);
            }
            c1611b.execute(new String[0]);
        }
        return c1611b;
    }
}
