package d.a.j0.i0.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.i0.r.f0.f;
import d.a.i0.r.q.o0;
import d.a.i0.r.q.o1;
import d.a.i0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.i0.a0.b, d.a.i0.g0.c.a {

    /* renamed from: e  reason: collision with root package name */
    public EnterForumFragment f54985e;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumModel f54987g;

    /* renamed from: h  reason: collision with root package name */
    public RecentlyVisitedForumModel f54988h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.l3.d f54989i;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public BaseFragmentActivity o;
    public long p;
    public boolean q;
    public LikeModel r;
    public ViewEventCenter s;
    public d.a.i0.r.f0.a t;
    public d.a.j0.i0.m.d v;
    public boolean w;
    public View x;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.i0.m.b f54986f = null;
    public d.a.i0.r.s.a j = null;
    public int u = 1;
    public CustomMessageListener y = new d(2921032);
    public d.a.c.c.g.a z = new g(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    public d.a.c.a.e A = new j();
    public final EnterForumModel.f B = new k();
    public f.g C = new b();

    /* renamed from: d.a.j0.i0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1284a implements a.e {
        public C1284a() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            a.this.j = null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.f15186c.y();
            a.this.f54987g.D(!StringUtils.isNull(a.this.n));
            a.this.f54988h.LoadData();
            a.this.f54987g.Q(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f54993b;

        public c(a aVar, String str, boolean z) {
            this.f54992a = str;
            this.f54993b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f54992a)) {
                return null;
            }
            d.a.j0.e1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f54992a), this.f54993b);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            a.this.m = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.f54986f == null || !a.this.f54986f.F()) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CustomMessageTask.CustomRunnable<o0> {
        public f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<o0> run(CustomMessage<o0> customMessage) {
            o0 o0Var = new o0();
            ArrayList arrayList = new ArrayList();
            if (a.this.f54987g != null && a.this.f54987g.w() != null && a.this.f54987g.w().e() != null && ListUtils.getCount(a.this.f54987g.w().e().b()) > 0) {
                Iterator<d.a.j0.i0.d.f> it = a.this.f54987g.w().e().b().iterator();
                while (it.hasNext()) {
                    d.a.j0.i0.d.f next = it.next();
                    if (next != null) {
                        HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                        hotTopicBussinessData.setForumId(d.a.c.e.m.b.f(next.D(), 0L));
                        hotTopicBussinessData.setForumName(next.G());
                        hotTopicBussinessData.setForumAvatar(next.B());
                        arrayList.add(hotTopicBussinessData);
                    }
                }
                o0Var.a(arrayList);
            }
            return new CustomResponsedMessage<>(2016527, o0Var);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.c.c.g.a {
        public g(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
            if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.f54987g.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.f54986f.G();
                if (responsedMessage.hasError()) {
                    if (a.this.f54986f.S()) {
                        a.this.f54986f.w0(a.this.x);
                        return;
                    }
                    return;
                }
                if (z) {
                    a.this.f54987g.J((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.f54987g.I((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.i0.d.f f54998e;

        public h(d.a.j0.i0.d.f fVar) {
            this.f54998e = fVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (!d.a.c.e.p.l.D()) {
                a.this.o.showToast(R.string.delete_like_fail);
            } else {
                new n(this.f54998e).execute(new d.a.j0.i0.d.f[0]);
            }
            TiebaStatic.eventStat(a.this.o.getPageContext().getPageActivity(), "recom_flist_unlike", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {
        public i(a aVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.a.c.a.e {
        public j() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(a.this.r.getErrorCode(), a.this.r.getErrorString())) {
                AntiHelper.u(a.this.o.getPageContext().getPageActivity(), a.this.r.getErrorString());
            } else if (obj != null) {
                a.this.f54987g.D(!StringUtils.isNull(a.this.n));
            } else if (StringUtils.isNull(a.this.r.getErrorString())) {
            } else {
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), a.this.r.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements EnterForumModel.f {
        public k() {
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            if (eVar == null || a.this.f54985e == null) {
                return;
            }
            if (eVar.f15282c == 1) {
                a.this.f54986f.G();
            }
            if (eVar.f15281b) {
                int i2 = eVar.f15282c;
                if (i2 == 1) {
                    a.this.l = true;
                    d.a.j0.i0.d.d dVar = eVar.f15283d;
                    a.this.M(dVar);
                    if (dVar.h() > 0) {
                        d.a.i0.r.d0.b.j().v("key_LIKE_forum_sort_state", dVar.h());
                    }
                } else if (i2 == 0 && !a.this.l) {
                    d.a.j0.i0.d.d dVar2 = eVar.f15283d;
                    a.this.f54987g.O(dVar2);
                    a.this.M(dVar2);
                }
            } else {
                String str = eVar.f15280a;
                if (str != null && !str.equals("")) {
                    a.this.o.showToast(eVar.f15280a);
                    a.this.f54986f.a0(d.a.i0.r.d0.b.j().k("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
            }
            if (eVar.f15282c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.G()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.f15282c == 1 && a.this.p > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.p, a.this.f54987g.y() - a.this.p, a.this.f54987g.A(), a.this.f54987g.z(), currentTimeMillis - a.this.f54987g.x());
                a.this.p = -1L;
            }
            String string = a.this.o.getResources().getString(R.string.enter_forum_search_tip);
            d.a.j0.i0.d.d dVar3 = eVar.f15283d;
            if (dVar3 != null && dVar3.d() != null) {
                HotSearchInfoData d2 = eVar.f15283d.d();
                d.a.i0.r.d0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(d2));
                if (d2 != null && d2.s() != null) {
                    string = d2.s();
                }
            }
            a.this.T(string);
            d.a.j0.i0.d.d dVar4 = eVar.f15283d;
            if (dVar4 == null || dVar4.c() == null) {
                return;
            }
            a.this.f54986f.m0(eVar.f15283d.c());
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.i0.d.d f55002e;

        public l(d.a.j0.i0.d.d dVar) {
            this.f55002e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(a.this.o.getPageContext(), new String[]{this.f55002e.f().v()});
            a.this.j.dismiss();
            a.this.j = null;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends BdAsyncTask<d.a.j0.i0.d.f, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55004a = null;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j0.i0.d.f f55005b;

        public m(d.a.j0.i0.d.f fVar) {
            this.f55005b = null;
            this.f55005b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(d.a.j0.i0.d.f... fVarArr) {
            d.a.j0.i0.d.f fVar = this.f55005b;
            if (fVar != null) {
                try {
                    if (fVar.D() == null || fVar.G() == null) {
                        return null;
                    }
                    if (fVar.E() == 0) {
                        this.f55004a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                    } else {
                        this.f55004a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                    }
                    this.f55004a.addPostData("forum_id", fVar.D());
                    this.f55004a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f55004a.postNetData();
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f55004a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f55004a = null;
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.U(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((m) str);
            a.this.U(false);
            int E = this.f55005b.E();
            NetWork netWork = this.f55004a;
            if (netWork != null) {
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.q = true;
                    if (a.this.f54985e.isAdded() && a.this.o != null) {
                        a.this.o.showToast(a.this.o.getActivity().getString(E > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.f54987g.D(true);
                } else if (a.this.o == null) {
                } else {
                    if (!StringUtils.isNull(this.f55004a.getErrorString())) {
                        a.this.o.showToast(this.f55004a.getErrorString());
                    } else if (a.this.f54985e.isAdded()) {
                        a.this.o.showToast(a.this.o.getActivity().getString(E > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends BdAsyncTask<d.a.j0.i0.d.f, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55007a = null;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j0.i0.d.f f55008b;

        public n(d.a.j0.i0.d.f fVar) {
            this.f55008b = null;
            this.f55008b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(d.a.j0.i0.d.f... fVarArr) {
            d.a.j0.i0.d.f fVar = this.f55008b;
            if (fVar != null) {
                try {
                    if (fVar.D() == null || fVar.G() == null) {
                        return null;
                    }
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                    this.f55007a = netWork;
                    netWork.addPostData("fid", fVar.D());
                    this.f55007a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, fVar.G());
                    this.f55007a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f55007a.postNetData();
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f55007a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f55007a = null;
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.U(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((n) str);
            a.this.U(false);
            NetWork netWork = this.f55007a;
            if (netWork != null) {
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.q = true;
                    if (a.this.f54985e.isAdded() && a.this.o != null) {
                        a.this.o.showToast(a.this.o.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.Q(false, this.f55008b.D());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.f55008b.D()));
                    long f2 = d.a.c.e.m.b.f(this.f55008b.D(), 0L);
                    if (f2 > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(f2)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f55008b.G()));
                    }
                    a.this.f54986f.g0(this.f55008b, a.this.f54987g.B());
                    a.this.f54987g.G(this.f55008b);
                } else if (a.this.o == null) {
                } else {
                    if (!StringUtils.isNull(this.f55007a.getErrorString())) {
                        a.this.o.showToast(this.f55007a.getErrorString());
                    } else if (a.this.f54985e.isAdded()) {
                        a.this.o.showToast(a.this.o.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }
    }

    public a(EnterForumFragment enterForumFragment) {
        this.f54987g = null;
        this.k = true;
        this.l = false;
        this.p = -1L;
        this.f54985e = enterForumFragment;
        this.o = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.s = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        d.a.j0.q0.m2.d.d();
        this.p = System.currentTimeMillis();
        this.k = true;
        this.l = false;
        this.n = "";
        this.f54987g = new EnterForumModel(this.o.getPageContext());
        this.f54988h = new RecentlyVisitedForumModel();
        this.r = new LikeModel(this.o.getPageContext());
        this.f54989i = new d.a.j0.l3.d(this.o.getPageContext());
        this.r.setLoadDataCallBack(this.A);
        this.f54987g.P(this.B);
        d.a.i0.r.d0.b.j().t("enter_forum_edit_mode", false);
        d.a.j0.i0.j.a.b().c(this.f54985e.getFragmentActivity(), d.a.c.e.p.l.r(this.f54985e.getFragmentActivity()));
        E();
        D();
        O();
    }

    public View A() {
        return this.x;
    }

    public final void B() {
        d.a.i0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
    }

    public void C() {
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null) {
            bVar.Q(this.x);
        }
    }

    public final void D() {
        P();
        this.f54985e.registerListener(this.z);
        this.f54985e.registerListener(this.y);
    }

    public final void E() {
        this.x = LayoutInflater.from(this.o.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        d.a.j0.i0.m.b bVar = new d.a.j0.i0.m.b(this.f54985e, this.x, this.s, this.f54988h, this.f54987g);
        this.f54986f = bVar;
        bVar.o0(this.C);
        I(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void F() {
        this.t = new d.a.i0.r.f0.a(this.o.getPageContext());
    }

    public final boolean G() {
        return !this.f54985e.isHidden();
    }

    public void H() {
        if (this.f54986f == null) {
            return;
        }
        x(false);
    }

    public void I(int i2) {
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null) {
            bVar.W(i2);
        }
        d.a.j0.i0.m.d dVar = this.v;
        if (dVar != null) {
            dVar.r();
        }
    }

    public void J() {
        u();
        d.a.j0.i0.j.a.b().a();
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null) {
            bVar.X();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        RecentlyVisitedForumModel recentlyVisitedForumModel = this.f54988h;
        if (recentlyVisitedForumModel != null) {
            recentlyVisitedForumModel.onDestroy();
        }
        EnterForumModel enterForumModel = this.f54987g;
        if (enterForumModel != null) {
            enterForumModel.onDestroy();
        }
        ViewEventCenter viewEventCenter = this.s;
        if (viewEventCenter != null) {
            viewEventCenter.removeEventDelegate(this);
        }
    }

    public void K() {
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null && bVar.K() != null) {
            this.f54986f.K().z();
        }
        RecentlyVisitedForumModel recentlyVisitedForumModel = this.f54988h;
        if (recentlyVisitedForumModel != null) {
            recentlyVisitedForumModel.onPause();
        }
        EnterForumModel enterForumModel = this.f54987g;
        if (enterForumModel != null) {
            enterForumModel.onPause();
        }
        d.a.j0.i0.m.b bVar2 = this.f54986f;
        if (bVar2 != null) {
            bVar2.Y();
        }
    }

    public void L() {
        if (this.f54985e.isAdded() && this.f54985e.isPrimary()) {
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f54988h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.t();
            }
        } else {
            B();
        }
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null) {
            bVar.Z();
        }
    }

    public void M(d.a.j0.i0.d.d dVar) {
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar == null) {
            return;
        }
        if (dVar == null) {
            bVar.w0(this.x);
            return;
        }
        d.a.j0.i0.d.g e2 = dVar.e();
        ArrayList<d.a.j0.i0.d.f> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        v(arrayList, dVar.g());
        W(dVar);
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(d.a.i0.r.d0.b.j().p("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.s() != null) {
            T(hotSearchInfoData.s());
        }
        this.f54986f.b0();
        this.f54986f.a0(dVar.h());
    }

    public void N(boolean z) {
        EnterForumFragment enterForumFragment;
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar == null || (enterForumFragment = this.f54985e) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.f54985e.isResumed()) {
                this.f54986f.x0();
            } else {
                this.f54986f.G();
            }
        } else {
            bVar.G();
        }
        this.f54986f.n0(z);
    }

    public final void O() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public final void P() {
        this.f54985e.registerListener(new e(2007010));
    }

    public final void Q(boolean z, String str) {
        new c(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void R(d.a.j0.i0.d.c cVar) {
        this.f54986f.j0(cVar);
        this.f54985e.L0(cVar);
    }

    public void S(BdUniqueId bdUniqueId) {
        d.a.j0.i0.m.b bVar = this.f54986f;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
    }

    public final void T(String str) {
        if (this.f54985e.I0() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f54985e.I0().W(str.trim());
        } else {
            this.f54985e.I0().W(this.o.getActivity().getString(R.string.enter_forum_search_tip));
        }
    }

    public void U(boolean z) {
        if (this.t == null) {
            F();
        }
        this.t.h(z);
    }

    public void V(d.a.j0.i0.d.f fVar) {
        if (fVar == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.o.getPageContext().getPageActivity());
        aVar.setMessage(String.format(this.o.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.G()));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new h(fVar));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new i(this));
        aVar.setButtonTextColor(R.color.CAM_X0105);
        aVar.create(this.o.getPageContext());
        aVar.show();
    }

    public final void W(d.a.j0.i0.d.d dVar) {
        if (dVar == null || dVar.f() == null || !this.f54985e.isPrimary() || this.j != null) {
            return;
        }
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.o.getActivity());
        if (frsPrivateCommonDialogView.a(dVar.f())) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.o.getActivity());
            this.j = aVar;
            aVar.setContentViewSize(2);
            this.j.setContentView(frsPrivateCommonDialogView);
            this.j.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new l(dVar));
            this.j.setCloseButton(new C1284a());
            this.j.create(this.o.getPageContext()).show();
        }
    }

    @Override // d.a.i0.a0.b
    public void a(d.a.c.j.d.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    @Override // d.a.i0.g0.c.a
    public BdUniqueId getUniqueId() {
        return this.o.getUniqueId();
    }

    @Override // d.a.i0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    @Override // d.a.i0.g0.c.a
    public boolean onEventDispatch(d.a.i0.g0.c.b bVar) {
        int b2 = bVar.b();
        d.a.i0.g0.b.a a2 = bVar.a();
        switch (b2) {
            case 1:
                if (this.u == 2 || !(a2 instanceof d.a.j0.i0.d.f)) {
                    return false;
                }
                d.a.j0.i0.d.f fVar = (d.a.j0.i0.d.f) a2;
                String G = fVar.G();
                if (d.a.c.e.p.k.isForumName(G)) {
                    FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageContext().getPageActivity()).createNormalCfg(G, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                    Object c2 = bVar.c();
                    if (c2 instanceof Bundle) {
                        Intent intent = callFrom.getIntent();
                        if (fVar.H() && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                            intent.putExtra("transition_type", 2);
                            Bundle bundle = (Bundle) c2;
                            intent.putExtra("info_forum_image_rect", bundle.getParcelable("info_forum_image_rect"));
                            intent.putExtra("info_forum_image_url", fVar.B());
                            intent.putExtra("info_forum_name_rect", bundle.getParcelable("info_forum_name_rect"));
                            intent.putExtra("info_forum_name_text", G);
                            intent.putExtra("info_forum_head_background_color", fVar.J());
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                if (fVar.L().night != null && fVar.L().night.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", fVar.L().night.pattern_image);
                                }
                            } else if (fVar.L().day != null && fVar.L().day.pattern_image != null) {
                                intent.putExtra("info_forum_head_background_vector", fVar.L().day.pattern_image);
                            }
                        } else {
                            intent.putExtra("transition_type", 0);
                        }
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, fVar.C());
                        fVar.U(0L);
                    }
                    this.o.sendMessage(new CustomMessage(2003000, callFrom));
                    if (this.o.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(G)) {
                        TiebaStatic.log(new StatisticItem("c12888"));
                    }
                    TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.f54987g.w().h() != 1 ? 1 : 2).param("fid", fVar.D()));
                    return true;
                }
                break;
            case 2:
                if (this.u == 2) {
                    return false;
                }
                if (d.a.i0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                d.a.i0.r.d0.b.j().t("enter_forum_edit_mode", true);
                if (this.f54985e.getView() != null && this.f54985e.getView().getParent() != null) {
                    this.f54985e.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                d.a.i0.r.d0.b.j().t("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (a2 instanceof d.a.j0.i0.d.f) {
                    V((d.a.j0.i0.d.f) a2);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.o.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_6", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new StatisticItem("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.o.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                this.o.finish();
                return true;
            case 9:
                d.a.j0.i0.m.b bVar2 = this.f54986f;
                if (bVar2 != null) {
                    bVar2.x0();
                }
                return true;
            case 10:
                this.u = 2;
                return true;
            case 11:
                this.u = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.u == 2) {
                    return true;
                }
                if (this.v == null) {
                    this.v = new d.a.j0.i0.m.d(this.o.getPageContext(), this.s);
                }
                if (a2 instanceof d.a.j0.i0.d.f) {
                    this.v.s((d.a.j0.i0.d.f) a2);
                    this.v.l();
                }
                return true;
            case 13:
                if (a2 instanceof d.a.j0.i0.d.f) {
                    d.a.j0.i0.d.f fVar2 = (d.a.j0.i0.d.f) a2;
                    new m(fVar2).execute(new d.a.j0.i0.d.f[0]);
                    TiebaStatic.log(new StatisticItem("c13370").param("obj_type", fVar2.E() <= 0 ? 1 : 2).param("fid", fVar2.D()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (!this.f54989i.d() && (a2 instanceof d.a.j0.i0.d.f)) {
                    UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((d.a.j0.i0.d.f) a2).D() + "&nomenu=1"});
                }
                return true;
            case 16:
                R((d.a.j0.i0.d.c) bVar.d());
                break;
            case 17:
                R((d.a.j0.i0.d.c) bVar.d());
                break;
            case 18:
                R((d.a.j0.i0.d.c) bVar.d());
                break;
        }
        return false;
    }

    public void u() {
        EnterForumModel enterForumModel = this.f54987g;
        if (enterForumModel != null) {
            enterForumModel.cancelLoadData();
        }
    }

    public final void v(List<d.a.j0.i0.d.f> list, o1 o1Var) {
        if (list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.f54986f.e0(this.f54987g.R(list, d.a.i0.z0.f.a()), o1Var, this.f54987g.B());
    }

    public void w(boolean z) {
        if (this.f54986f == null || this.f54985e == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }

    public void x(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        if (this.w || this.f54987g == null || this.f54986f == null) {
            return;
        }
        String str = this.n;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.n = currentAccount;
        if (this.k) {
            this.k = false;
            z2 = false;
            z3 = true;
        } else {
            z2 = (currentAccount == null || currentAccount.equals(str)) ? false : true;
            z3 = false;
        }
        if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
            z2 = true;
        }
        if (z) {
            z2 = true;
        }
        if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
            EnterForumModel enterForumModel2 = this.f54987g;
            if (enterForumModel2 != null && enterForumModel2.w() != null && this.f54987g.w().e() != null) {
                Iterator<d.a.j0.i0.d.f> it = this.f54987g.w().e().b().iterator();
                while (it.hasNext()) {
                    d.a.j0.i0.d.f next = it.next();
                    if (TbadkCoreApplication.getInst().hasSignedForum(next.G())) {
                        next.V(1);
                        int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.G());
                        if (signLevelUpValue > 0) {
                            next.W(signLevelUpValue);
                        }
                    }
                }
            }
            TbadkCoreApplication.getInst().clearSignedForum();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                d.a.j0.d3.n0.a.g(currentAccount2);
            }
            this.f54986f.V(this.f54987g.B());
        }
        if (z3 || z2) {
            u();
            if (z2) {
                EnterForumModel enterForumModel3 = this.f54987g;
                if (enterForumModel3 != null) {
                    enterForumModel3.C(!StringUtils.isNull(this.n));
                }
                this.f54988h.LoadData();
            } else if (!z3 || (enterForumModel = this.f54987g) == null) {
            } else {
                enterForumModel.C(!StringUtils.isNull(this.n));
            }
        }
    }

    public void y() {
        if (this.f54986f == null) {
            return;
        }
        x(true);
    }

    public d.a.j0.i0.m.b z() {
        return this.f54986f;
    }
}
