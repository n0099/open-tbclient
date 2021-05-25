package d.a.n0.b1.b.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.b0;
import d.a.i.l0;
import d.a.m0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class s extends d.a.c.j.e.a<d.a.n0.b1.b.f.a, ThreadCardViewHolder<d.a.n0.b1.b.f.a>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.j.e.s o;
    public String p;
    public NEGFeedBackView.b q;

    /* loaded from: classes4.dex */
    public class a implements NEGFeedBackView.b {
        public a() {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            if (arrayList == null || v0Var == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921425, s.this.n.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            new b(s.this, null).execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51368a;

        public b(s sVar) {
            this.f51368a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f51368a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f51368a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                NetWork netWork = new NetWork();
                this.f51368a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.f51368a.addPostData("dislike_from", "concernpage");
                this.f51368a.addPostData("dislike_type", "1");
                this.f51368a.getNetContext().getRequest().mIsNeedTbs = true;
                return this.f51368a.postNetData();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
        }

        public /* synthetic */ b(s sVar, a aVar) {
            this(sVar);
        }
    }

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.n0.b1.b.h.a aVar = new d.a.n0.b1.b.h.a(this.n, this.m);
        aVar.p(true);
        bVar.n(aVar);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.j(this.m);
        b0 o = threadCardViewHolder.o(false);
        o.u(this.q);
        o.s(false);
        o.t(this.f39228e.getString(R.string.concern_recommend_dialog_title));
        o.w(true);
        o.k = true;
        return threadCardViewHolder;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.b.f.a aVar, ThreadCardViewHolder<d.a.n0.b1.b.f.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem("c13565");
        statisticItem.param("obj_source", aVar.B() ? 1 : 2);
        d.a.n0.z.t.b().a(statisticItem);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.n0.o.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(aVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void h0(d.a.c.j.e.s sVar) {
        this.o = sVar;
    }
}
