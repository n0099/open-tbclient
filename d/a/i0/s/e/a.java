package d.a.i0.s.e;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f49700a;

    /* renamed from: b  reason: collision with root package name */
    public b f49701b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f49702c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49703d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f49704a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f49705b;

        /* renamed from: c  reason: collision with root package name */
        public String f49706c;

        /* renamed from: d  reason: collision with root package name */
        public String f49707d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f49708e;

        /* renamed from: f  reason: collision with root package name */
        public String f49709f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f49710g;

        /* renamed from: h  reason: collision with root package name */
        public String f49711h;

        /* renamed from: i  reason: collision with root package name */
        public String f49712i;
        public boolean j;
        public String k;

        public b() {
            this.f49704a = null;
            this.f49708e = false;
            this.f49709f = "0";
            this.f49711h = "0";
            this.f49712i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f49705b = z;
        }

        public void c(String str) {
            this.f49712i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f49704a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f49704a = null;
            }
            if (a.this.f49701b != null) {
                a.this.f49701b.cancel();
                a.this.f49701b = null;
            }
            if (a.this.f49702c != null) {
                a.this.f49702c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f49709f = str;
        }

        public void e(String str) {
            this.f49711h = str;
        }

        public void f(boolean z) {
            this.f49708e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f49710g = bdUniqueId;
        }

        public void h(String str) {
            this.f49706c = str;
        }

        public void i(String str) {
            this.f49707d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f49706c != null) {
                    NetWork netWork = new NetWork();
                    this.f49704a = netWork;
                    if (this.f49705b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f49704a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f49704a.addPostData("portrait", this.f49706c);
                    if (!StringUtils.isNull(this.f49709f)) {
                        this.f49704a.addPostData("from_type", this.f49709f);
                    }
                    if (!StringUtils.isNull(this.f49712i)) {
                        this.f49704a.addPostData("forum_id", this.f49712i);
                    }
                    this.f49704a.addPostData("in_live", this.f49711h);
                    this.f49704a.addPostData("authsid", this.k);
                    this.f49704a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f49704a.postNetData();
                    AuthTokenData.parse(postNetData);
                    return postNetData;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            a.this.f49701b = null;
            if (this.f49704a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f13330a = this.f49704a.getNetContext().getResponse().isRequestSuccess();
                aVar.f13331b = this.f49704a.getErrorString();
                aVar.f13333d = this.f49705b;
                aVar.f13332c = this.f49707d;
                aVar.f13335f = this.f49708e;
                aVar.j = a.this.f49703d;
                aVar.b(str, this.j);
                if (this.f49704a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.l = null;
                }
                int serverErrorCode = this.f49704a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.k) || d.a.j0.n3.a.a(a.this.i(), serverErrorCode, this.f49704a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f49710g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f49705b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f49700a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.a.i0.s.h.a.f(a.this.f49700a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f49700a = tbPageContext;
    }

    public void g() {
        b bVar = this.f49701b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.i0.r.d0.b.j().g("first_call_attention", true)) {
            d.a.i0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f49700a.getPageActivity()).areNotificationsEnabled(), !d.a.i0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f49703d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f49703d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f49700a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f49703d = z;
    }

    public void k(d.a.c.a.e eVar) {
        this.f49702c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f49701b == null) {
            b bVar = new b();
            this.f49701b = bVar;
            bVar.setPriority(2);
            this.f49701b.b(z);
            this.f49701b.h(str);
            this.f49701b.i(str2);
            this.f49701b.f(z2);
            this.f49701b.d(str3);
            this.f49701b.g(bdUniqueId);
            this.f49701b.c(str4);
            this.f49701b.e(str5);
            this.f49701b.execute(new Integer[0]);
        }
    }
}
