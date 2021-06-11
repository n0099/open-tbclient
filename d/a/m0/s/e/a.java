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
    public TbPageContext f54269a;

    /* renamed from: b  reason: collision with root package name */
    public b f54270b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f54271c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54272d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54273a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54274b;

        /* renamed from: c  reason: collision with root package name */
        public String f54275c;

        /* renamed from: d  reason: collision with root package name */
        public String f54276d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54277e;

        /* renamed from: f  reason: collision with root package name */
        public String f54278f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f54279g;

        /* renamed from: h  reason: collision with root package name */
        public String f54280h;

        /* renamed from: i  reason: collision with root package name */
        public String f54281i;
        public boolean j;
        public String k;

        public b() {
            this.f54273a = null;
            this.f54277e = false;
            this.f54278f = "0";
            this.f54280h = "0";
            this.f54281i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f54274b = z;
        }

        public void c(String str) {
            this.f54281i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f54273a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f54273a = null;
            }
            if (a.this.f54270b != null) {
                a.this.f54270b.cancel();
                a.this.f54270b = null;
            }
            if (a.this.f54271c != null) {
                a.this.f54271c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f54278f = str;
        }

        public void e(String str) {
            this.f54280h = str;
        }

        public void f(boolean z) {
            this.f54277e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f54279g = bdUniqueId;
        }

        public void h(String str) {
            this.f54275c = str;
        }

        public void i(String str) {
            this.f54276d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f54275c != null) {
                    NetWork netWork = new NetWork();
                    this.f54273a = netWork;
                    if (this.f54274b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f54273a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f54273a.addPostData("portrait", this.f54275c);
                    if (!StringUtils.isNull(this.f54278f)) {
                        this.f54273a.addPostData("from_type", this.f54278f);
                    }
                    if (!StringUtils.isNull(this.f54281i)) {
                        this.f54273a.addPostData("forum_id", this.f54281i);
                    }
                    this.f54273a.addPostData("in_live", this.f54280h);
                    this.f54273a.addPostData("authsid", this.k);
                    this.f54273a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f54273a.postNetData();
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
            a.this.f54270b = null;
            if (this.f54273a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f12636a = this.f54273a.getNetContext().getResponse().isRequestSuccess();
                aVar.f12637b = this.f54273a.getErrorString();
                aVar.f12639d = this.f54274b;
                aVar.f12638c = this.f54276d;
                aVar.f12641f = this.f54277e;
                aVar.j = a.this.f54272d;
                aVar.b(str, this.j);
                if (this.f54273a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.l = null;
                }
                int serverErrorCode = this.f54273a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.k) || d.a.n0.o3.a.a(a.this.i(), serverErrorCode, this.f54273a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f54279g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f54274b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f54269a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.a.m0.s.h.a.f(a.this.f54269a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f54269a = tbPageContext;
    }

    public void g() {
        b bVar = this.f54270b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.m0.r.d0.b.j().g("first_call_attention", true)) {
            d.a.m0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f54269a.getPageActivity()).areNotificationsEnabled(), !d.a.m0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f54272d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f54272d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f54269a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f54272d = z;
    }

    public void k(d.a.c.a.e eVar) {
        this.f54271c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f54270b == null) {
            b bVar = new b();
            this.f54270b = bVar;
            bVar.setPriority(2);
            this.f54270b.b(z);
            this.f54270b.h(str);
            this.f54270b.i(str2);
            this.f54270b.f(z2);
            this.f54270b.d(str3);
            this.f54270b.g(bdUniqueId);
            this.f54270b.c(str4);
            this.f54270b.e(str5);
            this.f54270b.execute(new Integer[0]);
        }
    }
}
