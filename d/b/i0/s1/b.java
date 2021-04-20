package d.b.i0.s1;

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
        public final /* synthetic */ C1574b f61471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1095a f61472b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61473c;

        public a(C1574b c1574b, a.InterfaceC1095a interfaceC1095a, String str) {
            this.f61471a = c1574b;
            this.f61472b = interfaceC1095a;
            this.f61473c = str;
        }

        @Override // d.b.h0.r.l.e.b
        public void onFailed() {
            a.InterfaceC1095a interfaceC1095a = this.f61472b;
            if (interfaceC1095a != null) {
                interfaceC1095a.a(this.f61473c, 1, null);
            }
        }

        @Override // d.b.h0.r.l.e.b
        public void onSuccess(String str) {
            this.f61471a.d(str);
            this.f61471a.execute(new String[0]);
        }
    }

    /* renamed from: d.b.i0.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1574b extends BdAsyncTask<String, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f61474a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f61475b;

        /* renamed from: c  reason: collision with root package name */
        public final String f61476c;

        /* renamed from: d  reason: collision with root package name */
        public final String f61477d;

        /* renamed from: e  reason: collision with root package name */
        public String f61478e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC1095a f61479f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f61480g;

        /* renamed from: d.b.i0.s1.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements a.InterfaceC1095a {
            public a(C1574b c1574b) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1095a
            public void a(String str, int i, String str2) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1095a
            public void b(String str) {
            }

            @Override // d.b.h0.r.l.a.InterfaceC1095a
            public void c(AccountData accountData) {
            }
        }

        public C1574b(String str, String str2, String str3, a.InterfaceC1095a interfaceC1095a, boolean z) {
            this.f61475b = str;
            this.f61476c = str2;
            this.f61477d = str3;
            this.f61480g = z;
            this.f61479f = interfaceC1095a == null ? new a(this) : interfaceC1095a;
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
            this.f61474a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
            this.f61474a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            this.f61474a.addPostData("bdusstoken", this.f61476c + FieldBuilder.SE + this.f61477d);
            if (!StringUtils.isNull(this.f61478e)) {
                this.f61474a.addPostData("stoken", this.f61478e);
            }
            this.f61474a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.f61474a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.f61474a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f61474a.postNetData();
            if (!this.f61474a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                accountData = null;
            } else {
                q0 q0Var = new q0();
                q0Var.c(postNetData);
                accountData = new AccountData();
                accountData.setAccount(q0Var.b().getUserName());
                accountData.setPassword("");
                accountData.setID(q0Var.b().getUserId());
                String str = this.f61476c;
                if (this.f61480g && (d2 = e.d(d.b.h0.r.l.a.b().d(str))) != null) {
                    str = d2.f51036a + FieldBuilder.SE + d2.f51037b;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(q0Var.b().getPortrait());
                if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                }
                accountData.setStoken(this.f61478e);
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
            d.b.h0.r.z.a.a("account", -1L, 0, "cslogin_result", this.f61474a.getServerErrorCode(), this.f61474a.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.f61479f.c(accountData);
                return;
            }
            String str = null;
            if (this.f61474a != null) {
                str = this.f61474a.getErrorString();
                i = this.f61474a.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.f61479f.a(this.f61475b, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f61474a != null) {
                this.f61474a.cancelNetConnect();
            }
        }

        public void d(String str) {
            this.f61478e = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.f61479f.b(this.f61475b);
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1095a interfaceC1095a) {
        d.b.h0.r.l.e eVar = new d.b.h0.r.l.e();
        C1574b c1574b = new C1574b(str, str2, str3, interfaceC1095a, false);
        if (d.b.h0.r.l.e.b() && StringUtils.isNull(str4)) {
            eVar.c(str2, new a(c1574b, interfaceC1095a, str));
        } else {
            if (d.b.h0.r.l.e.b()) {
                c1574b.d(str4);
            }
            c1574b.execute(new String[0]);
        }
        return c1574b;
    }
}
