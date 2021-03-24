package d.b.i0.r1;

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
import d.b.h0.r.l.a;
import d.b.h0.r.l.e;
import d.b.h0.r.q.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1502b f59729a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1081a f59730b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f59731c;

        public a(C1502b c1502b, a.InterfaceC1081a interfaceC1081a, String str) {
            this.f59729a = c1502b;
            this.f59730b = interfaceC1081a;
            this.f59731c = str;
        }

        @Override // d.b.h0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1081a interfaceC1081a = this.f59730b;
            if (interfaceC1081a != null) {
                interfaceC1081a.a(this.f59731c, 1, null);
            }
        }

        @Override // d.b.h0.r.l.e.b
        public void onSuccess(String str) {
            this.f59729a.d(str);
            this.f59729a.execute(new String[0]);
        }
    }

    /* renamed from: d.b.i0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1502b extends BdAsyncTask<String, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f59732a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f59733b;

        /* renamed from: c  reason: collision with root package name */
        public final String f59734c;

        /* renamed from: d  reason: collision with root package name */
        public final String f59735d;

        /* renamed from: e  reason: collision with root package name */
        public String f59736e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1081a f59737f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f59738g;

        /* renamed from: d.b.i0.r1.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements a.InterfaceC1081a {
            public a(C1502b c1502b) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1081a
            public void a(String str, int i, String str2) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1081a
            public void b(String str) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1081a
            public void c(AccountData accountData) {
            }
        }

        public C1502b(String str, String str2, String str3, a.InterfaceC1081a interfaceC1081a, boolean z) {
            this.f59733b = str;
            this.f59734c = str2;
            this.f59735d = str3;
            this.f59738g = z;
            this.f59737f = interfaceC1081a == null ? new a(this) : interfaceC1081a;
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
            int i;
            int i2;
            a.b d2;
            this.f59732a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
            this.f59732a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            this.f59732a.addPostData("bdusstoken", this.f59734c + FieldBuilder.SE + this.f59735d);
            if (!StringUtils.isNull(this.f59736e)) {
                this.f59732a.addPostData("stoken", this.f59736e);
            }
            this.f59732a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.f59732a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.f59732a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f59732a.postNetData();
            if (!this.f59732a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                accountData = null;
            } else {
                q0 q0Var = new q0();
                q0Var.c(postNetData);
                accountData = new AccountData();
                accountData.setAccount(q0Var.b().getUserName());
                accountData.setPassword("");
                accountData.setID(q0Var.b().getUserId());
                String str = this.f59734c;
                if (this.f59738g && (d2 = e.d(d.b.h0.r.l.a.b().d(str))) != null) {
                    str = d2.f50628a + FieldBuilder.SE + d2.f50629b;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(q0Var.b().getPortrait());
                if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                }
                accountData.setStoken(this.f59736e);
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
                netWork.addPostData("stoken", d.b.h0.r.l.e.a(accountData));
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
                    } catch (JSONException e2) {
                        i2 = i;
                        e = e2;
                        e.printStackTrace();
                        i = i2;
                        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
                        return accountData;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i2 = 0;
                }
            }
            TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
            return accountData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            int i = 0;
            ReloginManager.g().o(false);
            d.b.h0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f59732a.getServerErrorCode(), this.f59732a.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.f59737f.c(accountData);
                return;
            }
            String str = null;
            if (this.f59732a != null) {
                str = this.f59732a.getErrorString();
                i = this.f59732a.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.f59737f.a(this.f59733b, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f59732a != null) {
                this.f59732a.cancelNetConnect();
            }
        }

        public void d(String str) {
            this.f59736e = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.f59737f.b(this.f59733b);
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1081a interfaceC1081a) {
        d.b.h0.r.l.e eVar = new d.b.h0.r.l.e();
        C1502b c1502b = new C1502b(str, str2, str3, interfaceC1081a, false);
        if (d.b.h0.r.l.e.b() && StringUtils.isNull(str4)) {
            eVar.c(str2, new a(c1502b, interfaceC1081a, str));
        } else {
            if (d.b.h0.r.l.e.b()) {
                c1502b.d(str4);
            }
            c1502b.execute(new String[0]);
        }
        return c1502b;
    }
}
