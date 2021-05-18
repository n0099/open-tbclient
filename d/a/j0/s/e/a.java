package d.a.j0.s.e;

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
    public TbPageContext f50519a;

    /* renamed from: b  reason: collision with root package name */
    public b f50520b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f50521c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50522d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f50523a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f50524b;

        /* renamed from: c  reason: collision with root package name */
        public String f50525c;

        /* renamed from: d  reason: collision with root package name */
        public String f50526d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50527e;

        /* renamed from: f  reason: collision with root package name */
        public String f50528f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f50529g;

        /* renamed from: h  reason: collision with root package name */
        public String f50530h;

        /* renamed from: i  reason: collision with root package name */
        public String f50531i;
        public boolean j;
        public String k;

        public b() {
            this.f50523a = null;
            this.f50527e = false;
            this.f50528f = "0";
            this.f50530h = "0";
            this.f50531i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f50524b = z;
        }

        public void c(String str) {
            this.f50531i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f50523a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f50523a = null;
            }
            if (a.this.f50520b != null) {
                a.this.f50520b.cancel();
                a.this.f50520b = null;
            }
            if (a.this.f50521c != null) {
                a.this.f50521c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f50528f = str;
        }

        public void e(String str) {
            this.f50530h = str;
        }

        public void f(boolean z) {
            this.f50527e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f50529g = bdUniqueId;
        }

        public void h(String str) {
            this.f50525c = str;
        }

        public void i(String str) {
            this.f50526d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f50525c != null) {
                    NetWork netWork = new NetWork();
                    this.f50523a = netWork;
                    if (this.f50524b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f50523a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f50523a.addPostData("portrait", this.f50525c);
                    if (!StringUtils.isNull(this.f50528f)) {
                        this.f50523a.addPostData("from_type", this.f50528f);
                    }
                    if (!StringUtils.isNull(this.f50531i)) {
                        this.f50523a.addPostData("forum_id", this.f50531i);
                    }
                    this.f50523a.addPostData("in_live", this.f50530h);
                    this.f50523a.addPostData("authsid", this.k);
                    this.f50523a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f50523a.postNetData();
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
            a.this.f50520b = null;
            if (this.f50523a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f12666a = this.f50523a.getNetContext().getResponse().isRequestSuccess();
                aVar.f12667b = this.f50523a.getErrorString();
                aVar.f12669d = this.f50524b;
                aVar.f12668c = this.f50526d;
                aVar.f12671f = this.f50527e;
                aVar.j = a.this.f50522d;
                aVar.b(str, this.j);
                if (this.f50523a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.l = null;
                }
                int serverErrorCode = this.f50523a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.k) || d.a.k0.n3.a.a(a.this.i(), serverErrorCode, this.f50523a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f50529g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f50524b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f50519a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.a.j0.s.h.a.f(a.this.f50519a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f50519a = tbPageContext;
    }

    public void g() {
        b bVar = this.f50520b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.j0.r.d0.b.j().g("first_call_attention", true)) {
            d.a.j0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f50519a.getPageActivity()).areNotificationsEnabled(), !d.a.j0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f50522d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f50522d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f50519a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f50522d = z;
    }

    public void k(d.a.c.a.e eVar) {
        this.f50521c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f50520b == null) {
            b bVar = new b();
            this.f50520b = bVar;
            bVar.setPriority(2);
            this.f50520b.b(z);
            this.f50520b.h(str);
            this.f50520b.i(str2);
            this.f50520b.f(z2);
            this.f50520b.d(str3);
            this.f50520b.g(bdUniqueId);
            this.f50520b.c(str4);
            this.f50520b.e(str5);
            this.f50520b.execute(new Integer[0]);
        }
    }
}
