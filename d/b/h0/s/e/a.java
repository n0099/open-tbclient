package d.b.h0.s.e;

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
    public TbPageContext f51288a;

    /* renamed from: b  reason: collision with root package name */
    public b f51289b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.a.e f51290c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51291d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51292a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51293b;

        /* renamed from: c  reason: collision with root package name */
        public String f51294c;

        /* renamed from: d  reason: collision with root package name */
        public String f51295d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51296e;

        /* renamed from: f  reason: collision with root package name */
        public String f51297f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f51298g;

        /* renamed from: h  reason: collision with root package name */
        public String f51299h;
        public String i;
        public boolean j;
        public String k;

        public b() {
            this.f51292a = null;
            this.f51296e = false;
            this.f51297f = "0";
            this.f51299h = "0";
            this.i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f51293b = z;
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
            NetWork netWork = this.f51292a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f51292a = null;
            }
            if (a.this.f51289b != null) {
                a.this.f51289b.cancel();
                a.this.f51289b = null;
            }
            if (a.this.f51290c != null) {
                a.this.f51290c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f51297f = str;
        }

        public void e(String str) {
            this.f51299h = str;
        }

        public void f(boolean z) {
            this.f51296e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f51298g = bdUniqueId;
        }

        public void h(String str) {
            this.f51294c = str;
        }

        public void i(String str) {
            this.f51295d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f51294c != null) {
                    NetWork netWork = new NetWork();
                    this.f51292a = netWork;
                    if (this.f51293b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f51292a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f51292a.addPostData("portrait", this.f51294c);
                    if (!StringUtils.isNull(this.f51297f)) {
                        this.f51292a.addPostData("from_type", this.f51297f);
                    }
                    if (!StringUtils.isNull(this.i)) {
                        this.f51292a.addPostData("forum_id", this.i);
                    }
                    this.f51292a.addPostData("in_live", this.f51299h);
                    this.f51292a.addPostData("authsid", this.k);
                    this.f51292a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f51292a.postNetData();
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
            a.this.f51289b = null;
            if (this.f51292a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f13692a = this.f51292a.getNetContext().getResponse().isRequestSuccess();
                aVar.f13693b = this.f51292a.getErrorString();
                aVar.f13695d = this.f51293b;
                aVar.f13694c = this.f51295d;
                aVar.f13696e = this.f51296e;
                aVar.i = a.this.f51291d;
                aVar.b(str, this.j);
                if (this.f51292a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.k = null;
                }
                int serverErrorCode = this.f51292a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.j) || d.b.i0.m3.a.a(a.this.i(), serverErrorCode, this.f51292a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f51298g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f51293b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f51288a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.b.h0.s.h.a.f(a.this.f51288a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f51288a = tbPageContext;
    }

    public void g() {
        b bVar = this.f51289b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.b.h0.r.d0.b.i().g("first_call_attention", true)) {
            d.b.h0.r.d0.b.i().s("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f51288a.getPageActivity()).areNotificationsEnabled(), !d.b.h0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f51291d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f51291d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f51288a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f51291d = z;
    }

    public void k(d.b.b.a.e eVar) {
        this.f51290c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f51289b == null) {
            b bVar = new b();
            this.f51289b = bVar;
            bVar.setPriority(2);
            this.f51289b.b(z);
            this.f51289b.h(str);
            this.f51289b.i(str2);
            this.f51289b.f(z2);
            this.f51289b.d(str3);
            this.f51289b.g(bdUniqueId);
            this.f51289b.c(str4);
            this.f51289b.e(str5);
            this.f51289b.execute(new Integer[0]);
        }
    }
}
