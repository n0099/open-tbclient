package d.a.n0.b1.c.e;

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
public class s extends d.a.c.k.e.a<d.a.n0.b1.c.f.a, ThreadCardViewHolder<d.a.n0.b1.c.f.a>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.k.e.s o;
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
        public NetWork f55051a;

        public b(s sVar) {
            this.f55051a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f55051a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f55051a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                NetWork netWork = new NetWork();
                this.f55051a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.f55051a.addPostData("dislike_from", "concernpage");
                this.f55051a.addPostData("dislike_type", "1");
                this.f55051a.getNetContext().getRequest().mIsNeedTbs = true;
                return this.f55051a.postNetData();
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

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.n0.b1.c.h.a aVar = new d.a.n0.b1.c.h.a(this.n, this.m);
        aVar.p(true);
        bVar.n(aVar);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.m);
        b0 p = threadCardViewHolder.p(false);
        p.u(this.q);
        p.s(false);
        p.t(this.f42909e.getString(R.string.concern_recommend_dialog_title));
        p.w(true);
        p.k = true;
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.c.f.a aVar, ThreadCardViewHolder<d.a.n0.b1.c.f.a> threadCardViewHolder) {
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

    public void i0(d.a.c.k.e.s sVar) {
        this.o = sVar;
    }
}
