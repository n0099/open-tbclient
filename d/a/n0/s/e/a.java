package d.a.n0.s.e;

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
    public TbPageContext f54376a;

    /* renamed from: b  reason: collision with root package name */
    public b f54377b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.a.e f54378c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54379d;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54380a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54381b;

        /* renamed from: c  reason: collision with root package name */
        public String f54382c;

        /* renamed from: d  reason: collision with root package name */
        public String f54383d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54384e;

        /* renamed from: f  reason: collision with root package name */
        public String f54385f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f54386g;

        /* renamed from: h  reason: collision with root package name */
        public String f54387h;

        /* renamed from: i  reason: collision with root package name */
        public String f54388i;
        public boolean j;
        public String k;

        public b() {
            this.f54380a = null;
            this.f54384e = false;
            this.f54385f = "0";
            this.f54387h = "0";
            this.f54388i = null;
            this.j = false;
        }

        public void b(boolean z) {
            this.f54381b = z;
        }

        public void c(String str) {
            this.f54388i = str;
            if (str != null) {
                this.j = true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f54380a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f54380a = null;
            }
            if (a.this.f54377b != null) {
                a.this.f54377b.cancel();
                a.this.f54377b = null;
            }
            if (a.this.f54378c != null) {
                a.this.f54378c.c(Boolean.FALSE);
            }
        }

        public void d(String str) {
            this.f54385f = str;
        }

        public void e(String str) {
            this.f54387h = str;
        }

        public void f(boolean z) {
            this.f54384e = z;
        }

        public void g(BdUniqueId bdUniqueId) {
            this.f54386g = bdUniqueId;
        }

        public void h(String str) {
            this.f54382c = str;
        }

        public void i(String str) {
            this.f54383d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.f54382c != null) {
                    NetWork netWork = new NetWork();
                    this.f54380a = netWork;
                    if (this.f54381b) {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                        this.f54380a.setNeedSig(true);
                    } else {
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.f54380a.addPostData("portrait", this.f54382c);
                    if (!StringUtils.isNull(this.f54385f)) {
                        this.f54380a.addPostData("from_type", this.f54385f);
                    }
                    if (!StringUtils.isNull(this.f54388i)) {
                        this.f54380a.addPostData("forum_id", this.f54388i);
                    }
                    this.f54380a.addPostData("in_live", this.f54387h);
                    this.f54380a.addPostData("authsid", this.k);
                    this.f54380a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f54380a.postNetData();
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
            a.this.f54377b = null;
            if (this.f54380a != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.f12718a = this.f54380a.getNetContext().getResponse().isRequestSuccess();
                aVar.f12719b = this.f54380a.getErrorString();
                aVar.f12721d = this.f54381b;
                aVar.f12720c = this.f54383d;
                aVar.f12723f = this.f54384e;
                aVar.j = a.this.f54379d;
                aVar.b(str, this.j);
                if (this.f54380a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.l = null;
                }
                int serverErrorCode = this.f54380a.getServerErrorCode();
                if (AntiHelper.a(a.this.i(), serverErrorCode, aVar.k) || d.a.o0.o3.a.a(a.this.i(), serverErrorCode, this.f54380a.getErrorString())) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f54386g));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                if (this.f54381b && serverErrorCode == 0) {
                    a aVar2 = a.this;
                    boolean[] h2 = aVar2.h(aVar2.f54376a);
                    if (h2 != null) {
                        if (h2[0] || h2[1]) {
                            d.a.n0.s.h.a.f(a.this.f54376a, h2, 1);
                        }
                    }
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f54376a = tbPageContext;
    }

    public void g() {
        b bVar = this.f54377b;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && d.a.n0.r.d0.b.j().g("first_call_attention", true)) {
            d.a.n0.r.d0.b.j().t("first_call_attention", false);
            zArr = new boolean[]{!NotificationManagerCompat.from(this.f54376a.getPageActivity()).areNotificationsEnabled(), !d.a.n0.s.d.d.d().s()};
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f54379d) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.f54379d) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public Activity i() {
        TbPageContext tbPageContext = this.f54376a;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void j(boolean z) {
        this.f54379d = z;
    }

    public void k(d.a.c.a.e eVar) {
        this.f54378c = eVar;
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        m(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.f54377b == null) {
            b bVar = new b();
            this.f54377b = bVar;
            bVar.setPriority(2);
            this.f54377b.b(z);
            this.f54377b.h(str);
            this.f54377b.i(str2);
            this.f54377b.f(z2);
            this.f54377b.d(str3);
            this.f54377b.g(bdUniqueId);
            this.f54377b.c(str4);
            this.f54377b.e(str5);
            this.f54377b.execute(new Integer[0]);
        }
    }
}
