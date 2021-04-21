package d.b.j0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.QualityThreadItemHolder;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.j0.c1.c.m;
/* loaded from: classes4.dex */
public class i extends d.b.c.j.e.a<m, QualityThreadItemHolder> {
    public int m;
    public HotTopicActivity n;
    public b o;
    public w p;

    /* loaded from: classes4.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar == null || !(nVar instanceof m)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            i.this.j0((m) nVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f53847e;

        /* renamed from: f  reason: collision with root package name */
        public String f53848f;

        public b() {
        }

        public void a(String str, String str2) {
            this.f53847e = str;
            this.f53848f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.c.e.p.k.isForumName(this.f53847e)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.f43095e).createNormalCfg(this.f53847e, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new StatisticItem("c10523").param("fid", this.f53848f));
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.o = new b(this, null);
        this.p = new a();
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        o0(i, view, viewGroup, mVar, qualityThreadItemHolder);
        return view;
    }

    public final void j0(m mVar) {
        if (mVar == null || mVar.a()) {
            return;
        }
        String valueOf = String.valueOf(mVar.f53958g);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.n.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.n), "hot_topic")));
        TiebaStatic.log(new StatisticItem("c10522").param("tid", valueOf).param("obj_id", this.n.getHotTopicId()));
    }

    public final void l0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null) {
            return;
        }
        if (mVar.a()) {
            qualityThreadItemHolder.f17281c.setVisibility(0);
            qualityThreadItemHolder.f17282d.setVisibility(0);
            qualityThreadItemHolder.f17284f.setVisibility(8);
            qualityThreadItemHolder.f17283e.setVisibility(8);
            qualityThreadItemHolder.f17282d.setText(mVar.f53957f.trim());
            SkinManager.setBackgroundColor(qualityThreadItemHolder.a(), R.color.CAM_X0201);
            return;
        }
        qualityThreadItemHolder.f17281c.setVisibility(8);
        qualityThreadItemHolder.f17282d.setVisibility(8);
        qualityThreadItemHolder.f17284f.setVisibility(0);
        qualityThreadItemHolder.f17283e.setVisibility(0);
        qualityThreadItemHolder.f17285g.W(mVar.o, 10, false);
        qualityThreadItemHolder.f17286h.setText(mVar.f53959h.trim());
        qualityThreadItemHolder.i.setText(mVar.j.trim());
        qualityThreadItemHolder.j.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}));
        qualityThreadItemHolder.k.setText(StringHelper.numberUniformFormat(mVar.k));
        qualityThreadItemHolder.l.setText(StringHelper.numFormatOver10000(mVar.i));
        p0(qualityThreadItemHolder, mVar);
    }

    public final void m0(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        if (qualityThreadItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || qualityThreadItemHolder.f17279a == skinType) {
            return;
        }
        qualityThreadItemHolder.f17279a = skinType;
        SkinManager.setBackgroundResource(qualityThreadItemHolder.a(), R.drawable.list_item_selector);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f17282d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f17286h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.i, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f17284f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f17281c, R.color.CAM_X0204);
        qualityThreadItemHolder.f17285g.setImageDrawable(null);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public QualityThreadItemHolder R(ViewGroup viewGroup) {
        return new QualityThreadItemHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.hot_topic_quality_item, viewGroup, false));
    }

    public View o0(int i, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        if (mVar != null && qualityThreadItemHolder != null) {
            m0(qualityThreadItemHolder, view);
            l0(qualityThreadItemHolder, mVar);
        }
        return view;
    }

    public final void p0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null || this.n == null) {
            return;
        }
        c0(this.p);
        this.o.a(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}), String.valueOf(mVar.m));
        qualityThreadItemHolder.j.setOnClickListener(this.o);
    }
}
