package d.b.i0.a1.b.e;

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
import d.b.h0.r.q.v0;
import d.b.i.b0;
import d.b.i.k0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class s extends d.b.c.j.e.a<d.b.i0.a1.b.f.a, ThreadCardViewHolder<d.b.i0.a1.b.f.a>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.c.j.e.s o;
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
        public NetWork f52391a;

        public b(s sVar) {
            this.f52391a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f52391a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f52391a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                NetWork netWork = new NetWork();
                this.f52391a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                this.f52391a.addPostData("dislike_from", "concernpage");
                this.f52391a.addPostData("dislike_type", "1");
                this.f52391a.getNetContext().getRequest().mIsNeedTbs = true;
                return this.f52391a.postNetData();
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
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i0.a1.b.h.a aVar = new d.b.i0.a1.b.h.a(this.n, this.m);
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
        p.t(this.f42855e.getString(R.string.concern_recommend_dialog_title));
        p.w(true);
        p.k = true;
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.a1.b.f.a aVar, ThreadCardViewHolder<d.b.i0.a1.b.f.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem("c13565");
        statisticItem.param("obj_source", aVar.B() ? 1 : 2);
        d.b.i0.x.t.b().a(statisticItem);
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(aVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void l0(d.b.c.j.e.s sVar) {
        this.o = sVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.p = str;
    }
}
