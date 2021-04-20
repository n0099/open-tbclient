package d.b.i0.x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardExtendForumItemHolder;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends d.b.i0.x.c<d.b.i0.x.e0.i> {
    public LayoutInflater A;
    public View B;
    public View.OnClickListener C;
    public LikeModel D;
    public List<d.b.i0.b1.b.c> E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public HListView x;
    public d.b.i0.b1.b.b y;
    public CardExtendForumItemHolder z;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.a.e {
        public a() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if ((obj instanceof d.b.i0.d3.w) && i.this.D.getErrorCode() == 0) {
                return;
            }
            if (AntiHelper.m(i.this.D.getErrorCode(), i.this.D.getErrorString())) {
                AntiHelper.u(i.this.b(), i.this.D.getErrorString());
            } else {
                i.this.l().showToast(i.this.D.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            i.this.Q(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            i.this.Q(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == R.id.forum_add_love) {
                    if (ViewHelper.checkUpIsLogin(i.this.m().getContext())) {
                        String str = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (d.b.c.e.p.k.isForumName(str)) {
                            i.this.D.H(str, valueOf);
                            TiebaStatic.log(new StatisticItem(i.this.F).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                        }
                    }
                } else if (view.getTag(R.id.tag_forum_name) != null) {
                    String str2 = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                    if (d.b.c.e.p.k.isForumName(str2)) {
                        if (view.getId() == R.id.m_forum_name_textview) {
                            TiebaStatic.log(new StatisticItem(i.this.H).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                        } else {
                            TiebaStatic.log(new StatisticItem(i.this.G).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                        }
                        if (!StringUtils.isNull(i.this.I) && !StringUtils.isNull(i.this.J)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.m().getContext()).createCfgForpersonalized(str2, i.this.I, i.this.J)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.m().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                }
            }
        }
    }

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.K = new b(2001336);
        this.L = new c(2001335);
        HListView hListView = new HListView(b());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        LayoutInflater from = LayoutInflater.from(b());
        this.A = from;
        this.B = from.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.z = new CardExtendForumItemHolder(this.B);
        this.u.addView(this.x);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.x.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        K();
        if (this.y == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            d.b.i0.b1.b.b bVar = new d.b.i0.b1.b.b(b(), R.layout.extend_forum_item, this.z);
            this.y = bVar;
            bVar.d(this.C);
            this.x.setAdapter((ListAdapter) this.y);
        }
        this.m.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.D = likeModel;
        likeModel.setLoadDataCallBack(new a());
        this.x.setOnItemClickListener(null);
    }

    public final d.b.i0.x.e0.g J(String str) {
        if (ListUtils.getCount(this.E) > 0) {
            for (d.b.i0.b1.b.c cVar : this.E) {
                if (cVar != null && (cVar instanceof d.b.i0.x.e0.g)) {
                    d.b.i0.x.e0.g gVar = (d.b.i0.x.e0.g) cVar;
                    if (String.valueOf(gVar.f63783d).equals(str)) {
                        return gVar;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public final void K() {
        this.C = new d();
    }

    public final boolean L(List<d.b.i0.b1.b.c> list, List<d.b.i0.b1.b.c> list2) {
        int i;
        if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
            return false;
        }
        boolean z = true;
        while (i < ListUtils.getCount(list)) {
            d.b.i0.b1.b.c cVar = (d.b.i0.b1.b.c) ListUtils.getItem(list, i);
            d.b.i0.b1.b.c cVar2 = (d.b.i0.b1.b.c) ListUtils.getItem(list2, i);
            if (cVar != null && (cVar instanceof d.b.i0.x.e0.g) && cVar2 != null && (cVar2 instanceof d.b.i0.x.e0.g)) {
                d.b.i0.x.e0.g gVar = (d.b.i0.x.e0.g) cVar;
                d.b.i0.x.e0.g gVar2 = (d.b.i0.x.e0.g) cVar2;
                if (gVar.f63783d != gVar2.f63783d) {
                    z = false;
                }
                if (!gVar.f63781b.equals(gVar2.f63781b)) {
                    z = false;
                }
                i = gVar.f63782c.equals(gVar2.f63782c) ? i + 1 : 0;
            }
            z = false;
        }
        return z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: M */
    public void n(d.b.i0.x.e0.i iVar) {
        super.w(iVar);
        if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
            int count = ListUtils.getCount(iVar.getDataList());
            if (count > 10) {
                ArrayList arrayList = new ArrayList(iVar.getDataList());
                iVar.getDataList().clear();
                iVar.getDataList().addAll(arrayList.subList(0, 10));
            }
            this.J = iVar.n();
            this.I = iVar.j();
            if (L(iVar.getDataList(), this.E)) {
                return;
            }
            boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.E);
            this.E = iVar.getDataList();
            if (count <= 0) {
                m().setVisibility(8);
                return;
            }
            m().setVisibility(0);
            d.b.i0.b1.b.b bVar = this.y;
            if (bVar != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.E.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    d.b.i0.b1.b.b bVar2 = new d.b.i0.b1.b.b(b(), R.layout.extend_forum_item, this.z);
                    this.y = bVar2;
                    bVar2.c(this.E);
                    this.y.d(this.C);
                    this.x.setAdapter((ListAdapter) this.y);
                    o(l(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                bVar.c(this.E);
                this.y.notifyDataSetChanged();
                return;
            }
            return;
        }
        m().setVisibility(8);
    }

    public void O(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener = this.K;
        if (customMessageListener == null || this.L == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.L.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.K);
        MessageManager.getInstance().registerListener(this.L);
    }

    public void P(String str, String str2, String str3, String str4) {
        this.F = str2;
        this.G = str3;
        this.H = str4;
    }

    public final void Q(long j, boolean z) {
        d.b.i0.x.e0.g J = J(String.valueOf(j));
        if (J != null) {
            J.f63784e = z;
        }
        d.b.i0.b1.b.b bVar = this.y;
        if (bVar != null) {
            bVar.c(this.E);
            this.y.notifyDataSetChanged();
        }
    }

    @Override // d.b.i0.x.c, d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        d.b.i0.b1.b.b bVar;
        super.o(tbPageContext, i);
        if (this.x == null || (bVar = this.y) == null) {
            return;
        }
        bVar.b(i);
    }

    @Override // d.b.i0.x.b
    public void setFrom(String str) {
        super.setFrom(str);
    }
}
