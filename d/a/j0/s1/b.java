package d.a.j0.s1;

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
import d.a.i0.r.l.a;
import d.a.i0.r.l.e;
import d.a.i0.r.q.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1536b f60053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1056a f60054b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60055c;

        public a(C1536b c1536b, a.InterfaceC1056a interfaceC1056a, String str) {
            this.f60053a = c1536b;
            this.f60054b = interfaceC1056a;
            this.f60055c = str;
        }

        @Override // d.a.i0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1056a interfaceC1056a = this.f60054b;
            if (interfaceC1056a != null) {
                interfaceC1056a.a(this.f60055c, 1, null);
            }
        }

        @Override // d.a.i0.r.l.e.b
        public void onSuccess(String str) {
            this.f60053a.d(str);
            this.f60053a.execute(new String[0]);
        }
    }

    /* renamed from: d.a.j0.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1536b extends BdAsyncTask<String, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f60056a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f60057b;

        /* renamed from: c  reason: collision with root package name */
        public final String f60058c;

        /* renamed from: d  reason: collision with root package name */
        public final String f60059d;

        /* renamed from: e  reason: collision with root package name */
        public String f60060e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1056a f60061f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f60062g;

        /* renamed from: d.a.j0.s1.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements a.InterfaceC1056a {
            public a(C1536b c1536b) {
            }

            @Override // d.a.i0.r.l.a.InterfaceC1056a
            public void a(String str, int i2, String str2) {
            }

            @Override // d.a.i0.r.l.a.InterfaceC1056a
            public void b(String str) {
            }

            @Override // d.a.i0.r.l.a.InterfaceC1056a
            public void c(AccountData accountData) {
            }
        }

        public C1536b(String str, String str2, String str3, a.InterfaceC1056a interfaceC1056a, boolean z) {
            this.f60057b = str;
            this.f60058c = str2;
            this.f60059d = str3;
            this.f60062g = z;
            this.f60061f = interfaceC1056a == null ? new a(this) : interfaceC1056a;
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
            this.f60056a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
            this.f60056a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            this.f60056a.addPostData("bdusstoken", this.f60058c + FieldBuilder.SE + this.f60059d);
            if (!StringUtils.isNull(this.f60060e)) {
                this.f60056a.addPostData("stoken", this.f60060e);
            }
            this.f60056a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.f60056a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.f60056a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f60056a.postNetData();
            if (!this.f60056a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                accountData = null;
            } else {
                q0 q0Var = new q0();
                q0Var.c(postNetData);
                accountData = new AccountData();
                accountData.setAccount(q0Var.b().getUserName());
                accountData.setPassword("");
                accountData.setID(q0Var.b().getUserId());
                String str = this.f60058c;
                if (this.f60062g && (d2 = e.d(d.a.i0.r.l.a.b().d(str))) != null) {
                    str = d2.f48989a + FieldBuilder.SE + d2.f48990b;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(q0Var.b().getPortrait());
                if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                }
                accountData.setStoken(this.f60060e);
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
                netWork.addPostData("stoken", d.a.i0.r.l.e.a(accountData));
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
            d.a.i0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f60056a.getServerErrorCode(), this.f60056a.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.f60061f.c(accountData);
                return;
            }
            String str = null;
            if (this.f60056a != null) {
                str = this.f60056a.getErrorString();
                i2 = this.f60056a.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.f60061f.a(this.f60057b, i2, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f60056a != null) {
                this.f60056a.cancelNetConnect();
            }
        }

        public void d(String str) {
            this.f60060e = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.f60061f.b(this.f60057b);
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1056a interfaceC1056a) {
        d.a.i0.r.l.e eVar = new d.a.i0.r.l.e();
        C1536b c1536b = new C1536b(str, str2, str3, interfaceC1056a, false);
        if (d.a.i0.r.l.e.b() && StringUtils.isNull(str4)) {
            eVar.c(str2, new a(c1536b, interfaceC1056a, str));
        } else {
            if (d.a.i0.r.l.e.b()) {
                c1536b.d(str4);
            }
            c1536b.execute(new String[0]);
        }
        return c1536b;
    }
}
