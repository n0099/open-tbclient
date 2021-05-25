package d.a.m0.s.e;

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
    public TbPageContext f50592a;

    /* renamed from: b  reason: collision with root package name */
    public b f50593b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f50594c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50595d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f50596a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f50597b;

        /* renamed from: c  reason: collision with root package name */
        public String f50598c;

        /* renamed from: d  reason: collision with root package name */
        public String f50599d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50600e;

        /* renamed from: f  reason: collision with root package name */
        public String f50601f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f50602g;

        /* renamed from: h  reason: collision with root package name */
        public String f50603h;

        /* renamed from: i  reason: collision with root package name */
        public String f50604i;
        public boolean j;
        public String k;

        public b() {
            this.f50596a = null;
            this.f50600e = false;
            this.f50601f = "0";
            this.f50603h = "0";
            this.f50604i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f50597b = z;
        }

        public void c(String str) {
            this.f50604i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f50596a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f50596a = null;
            }
            if (a.this.f50593b != null) {
                a.this.f50593b.cancel();
                a.this.f50593b = null;
            }
            if (a.this.f50594c != null) {
                a.this.f50594c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f50601f = str;
        }

        public void e(String str) {
            this.f50603h = str;
        }

        public void f(boolean z) {
            this.f50600e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f50602g = bdUniqueId;
        }

        public void h(String str) {
            this.f50598c = str;
        }

        public void i(String str) {
            this.f50599d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f50598c != null) {
                    NetWork netWork = new NetWork();
                    this.f50596a = netWork;
                    if (this.f50597b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f50596a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f50596a.addPostData("portrait", this.f50598c);
                    if (!StringUtils.isNull(this.f50601f)) {
                        this.f50596a.addPostData("from_type", this.f50601f);
                    }
                    if (!StringUtils.isNull(this.f50604i)) {
                        this.f50596a.addPostData("forum_id", this.f50604i);
                    }
                    this.f50596a.addPostData("in_live", this.f50603h);
                    this.f50596a.addPostData("authsid", this.k);
                    this.f50596a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f50596a.postNetData();
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
            a.this.f50593b = null;
            if (this.f50596a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f12574a = this.f50596a.getNetContext().getResponse().isRequestSuccess();
                aVar.f12575b = this.f50596a.getErrorString();
                aVar.f12577d = this.f50597b;
                aVar.f12576c = this.f50599d;
                aVar.f12579f = this.f50600e;
                aVar.j = a.this.f50595d;
                aVar.b(str, this.j);
                if (this.f50596a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.l = null;
                }
                int serverErrorCode = this.f50596a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.k) || d.a.n0.o3.a.a(a.this.i(), serverErrorCode, this.f50596a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f50602g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f50597b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f50592a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.a.m0.s.h.a.f(a.this.f50592a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f50592a = tbPageContext;
    }

    public void g() {
        b bVar = this.f50593b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.m0.r.d0.b.j().g("first_call_attention", true)) {
            d.a.m0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f50592a.getPageActivity()).areNotificationsEnabled(), !d.a.m0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f50595d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f50595d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f50592a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f50595d = z;
    }

    public void k(d.a.c.a.e eVar) {
        this.f50594c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f50593b == null) {
            b bVar = new b();
            this.f50593b = bVar;
            bVar.setPriority(2);
            this.f50593b.b(z);
            this.f50593b.h(str);
            this.f50593b.i(str2);
            this.f50593b.f(z2);
            this.f50593b.d(str3);
            this.f50593b.g(bdUniqueId);
            this.f50593b.c(str4);
            this.f50593b.e(str5);
            this.f50593b.execute(new Integer[0]);
        }
    }
}
