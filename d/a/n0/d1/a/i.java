package d.a.n0.d1.a;

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
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.n0.d1.c.m;
/* loaded from: classes4.dex */
public class i extends d.a.c.j.e.a<m, QualityThreadItemHolder> {
    public int m;
    public HotTopicActivity n;
    public b o;
    public w p;

    /* loaded from: classes4.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar == null || !(nVar instanceof m)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            i.this.g0((m) nVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f52481e;

        /* renamed from: f  reason: collision with root package name */
        public String f52482f;

        public b() {
        }

        public void a(String str, String str2) {
            this.f52481e = str;
            this.f52482f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.k.isForumName(this.f52481e)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.f39228e).createNormalCfg(this.f52481e, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new StatisticItem("c10523").param("fid", this.f52482f));
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
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        m0(i2, view, viewGroup, mVar, qualityThreadItemHolder);
        return view;
    }

    public final void g0(m mVar) {
        if (mVar == null || mVar.c()) {
            return;
        }
        String valueOf = String.valueOf(mVar.f52600g);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.n.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.n), "hot_topic")));
        TiebaStatic.log(new StatisticItem("c10522").param("tid", valueOf).param("obj_id", this.n.getHotTopicId()));
    }

    public final void h0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null) {
            return;
        }
        if (mVar.c()) {
            qualityThreadItemHolder.f16801c.setVisibility(0);
            qualityThreadItemHolder.f16802d.setVisibility(0);
            qualityThreadItemHolder.f16804f.setVisibility(8);
            qualityThreadItemHolder.f16803e.setVisibility(8);
            qualityThreadItemHolder.f16802d.setText(mVar.f52599f.trim());
            SkinManager.setBackgroundColor(qualityThreadItemHolder.a(), R.color.CAM_X0201);
            return;
        }
        qualityThreadItemHolder.f16801c.setVisibility(8);
        qualityThreadItemHolder.f16802d.setVisibility(8);
        qualityThreadItemHolder.f16804f.setVisibility(0);
        qualityThreadItemHolder.f16803e.setVisibility(0);
        qualityThreadItemHolder.f16805g.V(mVar.o, 10, false);
        qualityThreadItemHolder.f16806h.setText(mVar.f52601h.trim());
        qualityThreadItemHolder.f16807i.setText(mVar.j.trim());
        qualityThreadItemHolder.j.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}));
        qualityThreadItemHolder.k.setText(StringHelper.numberUniformFormat(mVar.k));
        qualityThreadItemHolder.l.setText(StringHelper.numFormatOver10000(mVar.f52602i));
        n0(qualityThreadItemHolder, mVar);
    }

    public final void i0(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        if (qualityThreadItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || qualityThreadItemHolder.f16799a == skinType) {
            return;
        }
        qualityThreadItemHolder.f16799a = skinType;
        SkinManager.setBackgroundResource(qualityThreadItemHolder.a(), R.drawable.list_item_selector);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16802d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16806h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f16807i, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f16804f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f16801c, R.color.CAM_X0204);
        qualityThreadItemHolder.f16805g.setImageDrawable(null);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public QualityThreadItemHolder P(ViewGroup viewGroup) {
        return new QualityThreadItemHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.hot_topic_quality_item, viewGroup, false));
    }

    public View m0(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        if (mVar != null && qualityThreadItemHolder != null) {
            i0(qualityThreadItemHolder, view);
            h0(qualityThreadItemHolder, mVar);
        }
        return view;
    }

    public final void n0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        if (qualityThreadItemHolder == null || mVar == null || this.n == null) {
            return;
        }
        Z(this.p);
        this.o.a(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}), String.valueOf(mVar.m));
        qualityThreadItemHolder.j.setOnClickListener(this.o);
    }
}
