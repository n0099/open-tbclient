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
    public TbPageContext f51289a;

    /* renamed from: b  reason: collision with root package name */
    public b f51290b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.a.e f51291c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51292d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51293a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51294b;

        /* renamed from: c  reason: collision with root package name */
        public String f51295c;

        /* renamed from: d  reason: collision with root package name */
        public String f51296d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51297e;

        /* renamed from: f  reason: collision with root package name */
        public String f51298f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f51299g;

        /* renamed from: h  reason: collision with root package name */
        public String f51300h;
        public String i;
        public boolean j;
        public String k;

        public b() {
            this.f51293a = null;
            this.f51297e = false;
            this.f51298f = "0";
            this.f51300h = "0";
            this.i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f51294b = z;
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
            NetWork netWork = this.f51293a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f51293a = null;
            }
            if (a.this.f51290b != null) {
                a.this.f51290b.cancel();
                a.this.f51290b = null;
            }
            if (a.this.f51291c != null) {
                a.this.f51291c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f51298f = str;
        }

        public void e(String str) {
            this.f51300h = str;
        }

        public void f(boolean z) {
            this.f51297e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f51299g = bdUniqueId;
        }

        public void h(String str) {
            this.f51295c = str;
        }

        public void i(String str) {
            this.f51296d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f51295c != null) {
                    NetWork netWork = new NetWork();
                    this.f51293a = netWork;
                    if (this.f51294b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f51293a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f51293a.addPostData("portrait", this.f51295c);
                    if (!StringUtils.isNull(this.f51298f)) {
                        this.f51293a.addPostData("from_type", this.f51298f);
                    }
                    if (!StringUtils.isNull(this.i)) {
                        this.f51293a.addPostData("forum_id", this.i);
                    }
                    this.f51293a.addPostData("in_live", this.f51300h);
                    this.f51293a.addPostData("authsid", this.k);
                    this.f51293a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f51293a.postNetData();
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
            a.this.f51290b = null;
            if (this.f51293a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f13693a = this.f51293a.getNetContext().getResponse().isRequestSuccess();
                aVar.f13694b = this.f51293a.getErrorString();
                aVar.f13696d = this.f51294b;
                aVar.f13695c = this.f51296d;
                aVar.f13697e = this.f51297e;
                aVar.i = a.this.f51292d;
                aVar.b(str, this.j);
                if (this.f51293a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.k = null;
                }
                int serverErrorCode = this.f51293a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.j) || d.b.i0.m3.a.a(a.this.i(), serverErrorCode, this.f51293a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f51299g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f51294b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f51289a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.b.h0.s.h.a.f(a.this.f51289a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f51289a = tbPageContext;
    }

    public void g() {
        b bVar = this.f51290b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.b.h0.r.d0.b.i().g("first_call_attention", true)) {
            d.b.h0.r.d0.b.i().s("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f51289a.getPageActivity()).areNotificationsEnabled(), !d.b.h0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f51292d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f51292d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f51289a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f51292d = z;
    }

    public void k(d.b.b.a.e eVar) {
        this.f51291c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f51290b == null) {
            b bVar = new b();
            this.f51290b = bVar;
            bVar.setPriority(2);
            this.f51290b.b(z);
            this.f51290b.h(str);
            this.f51290b.i(str2);
            this.f51290b.f(z2);
            this.f51290b.d(str3);
            this.f51290b.g(bdUniqueId);
            this.f51290b.c(str4);
            this.f51290b.e(str5);
            this.f51290b.execute(new Integer[0]);
        }
    }
}
