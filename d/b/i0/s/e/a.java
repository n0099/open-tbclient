package d.b.i0.s.e;

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
    public TbPageContext f52042a;

    /* renamed from: b  reason: collision with root package name */
    public b f52043b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.a.e f52044c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52045d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f52046a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52047b;

        /* renamed from: c  reason: collision with root package name */
        public String f52048c;

        /* renamed from: d  reason: collision with root package name */
        public String f52049d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52050e;

        /* renamed from: f  reason: collision with root package name */
        public String f52051f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f52052g;

        /* renamed from: h  reason: collision with root package name */
        public String f52053h;
        public String i;
        public boolean j;
        public String k;

        public b() {
            this.f52046a = null;
            this.f52050e = false;
            this.f52051f = "0";
            this.f52053h = "0";
            this.i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f52047b = z;
        }

        public void c(String str) {
            this.i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f52046a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f52046a = null;
            }
            if (a.this.f52043b != null) {
                a.this.f52043b.cancel();
                a.this.f52043b = null;
            }
            if (a.this.f52044c != null) {
                a.this.f52044c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f52051f = str;
        }

        public void e(String str) {
            this.f52053h = str;
        }

        public void f(boolean z) {
            this.f52050e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f52052g = bdUniqueId;
        }

        public void h(String str) {
            this.f52048c = str;
        }

        public void i(String str) {
            this.f52049d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f52048c != null) {
                    NetWork netWork = new NetWork();
                    this.f52046a = netWork;
                    if (this.f52047b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f52046a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f52046a.addPostData("portrait", this.f52048c);
                    if (!StringUtils.isNull(this.f52051f)) {
                        this.f52046a.addPostData("from_type", this.f52051f);
                    }
                    if (!StringUtils.isNull(this.i)) {
                        this.f52046a.addPostData("forum_id", this.i);
                    }
                    this.f52046a.addPostData("in_live", this.f52053h);
                    this.f52046a.addPostData("authsid", this.k);
                    this.f52046a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f52046a.postNetData();
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
            a.this.f52043b = null;
            if (this.f52046a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f13362a = this.f52046a.getNetContext().getResponse().isRequestSuccess();
                aVar.f13363b = this.f52046a.getErrorString();
                aVar.f13365d = this.f52047b;
                aVar.f13364c = this.f52049d;
                aVar.f13366e = this.f52050e;
                aVar.i = a.this.f52045d;
                aVar.b(str, this.j);
                if (this.f52046a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.k = null;
                }
                int serverErrorCode = this.f52046a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.j) || d.b.j0.n3.a.a(a.this.i(), serverErrorCode, this.f52046a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f52052g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f52047b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f52042a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.b.i0.s.h.a.f(a.this.f52042a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f52042a = tbPageContext;
    }

    public void g() {
        b bVar = this.f52043b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.b.i0.r.d0.b.j().g("first_call_attention", true)) {
            d.b.i0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f52042a.getPageActivity()).areNotificationsEnabled(), !d.b.i0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f52045d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f52045d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f52042a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f52045d = z;
    }

    public void k(d.b.c.a.e eVar) {
        this.f52044c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f52043b == null) {
            b bVar = new b();
            this.f52043b = bVar;
            bVar.setPriority(2);
            this.f52043b.b(z);
            this.f52043b.h(str);
            this.f52043b.i(str2);
            this.f52043b.f(z2);
            this.f52043b.d(str3);
            this.f52043b.g(bdUniqueId);
            this.f52043b.c(str4);
            this.f52043b.e(str5);
            this.f52043b.execute(new Integer[0]);
        }
    }
}
