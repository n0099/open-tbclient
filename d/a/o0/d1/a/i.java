package d.a.o0.d1.a;

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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.o0.d1.c.m;
/* loaded from: classes4.dex */
public class i extends d.a.c.k.e.a<m, QualityThreadItemHolder> {
    public int m;
    public HotTopicActivity n;
    public b o;
    public w p;

    /* loaded from: classes4.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar == null || !(nVar instanceof m)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            i.this.h0((m) nVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f56295e;

        /* renamed from: f  reason: collision with root package name */
        public String f56296f;

        public b() {
        }

        public void a(String str, String str2) {
            this.f56295e = str;
            this.f56296f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.k.isForumName(this.f56295e)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.f43012e).createNormalCfg(this.f56295e, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new StatisticItem("c10523").param("fid", this.f56296f));
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
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        l0(i2, view, viewGroup, mVar, qualityThreadItemHolder);
        return view;
    }

    public final void h0(m mVar) {
        if (mVar == null || mVar.b()) {
            return;
        }
        String valueOf = String.valueOf(mVar.f56414g);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.n.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.n), "hot_topic")));
        TiebaStatic.log(new StatisticItem("c10522").param("tid", valueOf).param("obj_id", this.n.getHotTopicId()));
    }

    public final void i0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null) {
            return;
        }
        if (mVar.b()) {
            qualityThreadItemHolder.f16959c.setVisibility(0);
            qualityThreadItemHolder.f16960d.setVisibility(0);
            qualityThreadItemHolder.f16962f.setVisibility(8);
            qualityThreadItemHolder.f16961e.setVisibility(8);
            qualityThreadItemHolder.f16960d.setText(mVar.f56413f.trim());
            SkinManager.setBackgroundColor(qualityThreadItemHolder.a(), R.color.CAM_X0201);
            return;
        }
        qualityThreadItemHolder.f16959c.setVisibility(8);
        qualityThreadItemHolder.f16960d.setVisibility(8);
        qualityThreadItemHolder.f16962f.setVisibility(0);
        qualityThreadItemHolder.f16961e.setVisibility(0);
        qualityThreadItemHolder.f16963g.U(mVar.o, 10, false);
        qualityThreadItemHolder.f16964h.setText(mVar.f56415h.trim());
        qualityThreadItemHolder.f16965i.setText(mVar.j.trim());
        qualityThreadItemHolder.j.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}));
        qualityThreadItemHolder.k.setText(StringHelper.numberUniformFormat(mVar.k));
        qualityThreadItemHolder.l.setText(StringHelper.numFormatOver10000(mVar.f56416i));
        m0(qualityThreadItemHolder, mVar);
    }

    public final void j0(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        if (qualityThreadItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || qualityThreadItemHolder.f16957a == skinType) {
            return;
        }
        qualityThreadItemHolder.f16957a = skinType;
        SkinManager.setBackgroundResource(qualityThreadItemHolder.a(), R.drawable.list_item_selector);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16960d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16964h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16965i, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f16962f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f16959c, R.color.CAM_X0204);
        qualityThreadItemHolder.f16963g.setImageDrawable(null);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public QualityThreadItemHolder Q(ViewGroup viewGroup) {
        return new QualityThreadItemHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.hot_topic_quality_item, viewGroup, false));
    }

    public View l0(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        if (mVar != null && qualityThreadItemHolder != null) {
            j0(qualityThreadItemHolder, view);
            i0(qualityThreadItemHolder, mVar);
        }
        return view;
    }

    public final void m0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null || this.n == null) {
            return;
        }
        a0(this.p);
        this.o.a(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}), String.valueOf(mVar.m));
        qualityThreadItemHolder.j.setOnClickListener(this.o);
    }
}
