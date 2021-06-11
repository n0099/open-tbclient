package d.a.n0.z;

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
public class i extends d.a.n0.z.c<d.a.n0.z.e0.i> {
    public LayoutInflater A;
    public View B;
    public View.OnClickListener C;
    public LikeModel D;
    public List<d.a.n0.c1.b.c> E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public HListView x;
    public d.a.n0.c1.b.b y;
    public CardExtendForumItemHolder z;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.a.e {
        public a() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if ((obj instanceof d.a.n0.e3.w) && i.this.D.getErrorCode() == 0) {
                return;
            }
            if (AntiHelper.m(i.this.D.getErrorCode(), i.this.D.getErrorString())) {
                AntiHelper.u(i.this.b(), i.this.D.getErrorString());
            } else {
                i.this.k().showToast(i.this.D.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            i.this.O(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            i.this.O(((Long) customResponsedMessage.getData()).longValue(), true);
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
                        if (d.a.c.e.p.k.isForumName(str)) {
                            i.this.D.L(str, valueOf);
                            TiebaStatic.log(new StatisticItem(i.this.F).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                        }
                    }
                } else if (view.getTag(R.id.tag_forum_name) != null) {
                    String str2 = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                    if (d.a.c.e.p.k.isForumName(str2)) {
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
        J();
        if (this.y == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 10; i2++) {
                arrayList.add(String.valueOf(i2));
            }
            d.a.n0.c1.b.b bVar = new d.a.n0.c1.b.b(b(), R.layout.extend_forum_item, this.z);
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

    public final d.a.n0.z.e0.g I(String str) {
        if (ListUtils.getCount(this.E) > 0) {
            for (d.a.n0.c1.b.c cVar : this.E) {
                if (cVar != null && (cVar instanceof d.a.n0.z.e0.g)) {
                    d.a.n0.z.e0.g gVar = (d.a.n0.z.e0.g) cVar;
                    if (String.valueOf(gVar.f67189d).equals(str)) {
                        return gVar;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public final void J() {
        this.C = new d();
    }

    public final boolean K(List<d.a.n0.c1.b.c> list, List<d.a.n0.c1.b.c> list2) {
        int i2;
        if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
            return false;
        }
        boolean z = true;
        while (i2 < ListUtils.getCount(list)) {
            d.a.n0.c1.b.c cVar = (d.a.n0.c1.b.c) ListUtils.getItem(list, i2);
            d.a.n0.c1.b.c cVar2 = (d.a.n0.c1.b.c) ListUtils.getItem(list2, i2);
            if (cVar != null && (cVar instanceof d.a.n0.z.e0.g) && cVar2 != null && (cVar2 instanceof d.a.n0.z.e0.g)) {
                d.a.n0.z.e0.g gVar = (d.a.n0.z.e0.g) cVar;
                d.a.n0.z.e0.g gVar2 = (d.a.n0.z.e0.g) cVar2;
                if (gVar.f67189d != gVar2.f67189d) {
                    z = false;
                }
                if (!gVar.f67187b.equals(gVar2.f67187b)) {
                    z = false;
                }
                i2 = gVar.f67188c.equals(gVar2.f67188c) ? i2 + 1 : 0;
            }
            z = false;
        }
        return z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: L */
    public void n(d.a.n0.z.e0.i iVar) {
        super.v(iVar);
        if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
            int count = ListUtils.getCount(iVar.getDataList());
            if (count > 10) {
                ArrayList arrayList = new ArrayList(iVar.getDataList());
                iVar.getDataList().clear();
                iVar.getDataList().addAll(arrayList.subList(0, 10));
            }
            this.J = iVar.i();
            this.I = iVar.g();
            if (K(iVar.getDataList(), this.E)) {
                return;
            }
            boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.E);
            this.E = iVar.getDataList();
            if (count <= 0) {
                m().setVisibility(8);
                return;
            }
            m().setVisibility(0);
            d.a.n0.c1.b.b bVar = this.y;
            if (bVar != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < this.E.size(); i2++) {
                        arrayList2.add(String.valueOf(i2));
                    }
                    d.a.n0.c1.b.b bVar2 = new d.a.n0.c1.b.b(b(), R.layout.extend_forum_item, this.z);
                    this.y = bVar2;
                    bVar2.c(this.E);
                    this.y.d(this.C);
                    this.x.setAdapter((ListAdapter) this.y);
                    o(k(), TbadkCoreApplication.getInst().getSkinType());
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

    public void M(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener = this.K;
        if (customMessageListener == null || this.L == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.L.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.K);
        MessageManager.getInstance().registerListener(this.L);
    }

    public void N(String str, String str2, String str3, String str4) {
        this.F = str2;
        this.G = str3;
        this.H = str4;
    }

    public final void O(long j, boolean z) {
        d.a.n0.z.e0.g I = I(String.valueOf(j));
        if (I != null) {
            I.f67190e = z;
        }
        d.a.n0.c1.b.b bVar = this.y;
        if (bVar != null) {
            bVar.c(this.E);
            this.y.notifyDataSetChanged();
        }
    }

    @Override // d.a.n0.z.c, d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        d.a.n0.c1.b.b bVar;
        super.o(tbPageContext, i2);
        if (this.x == null || (bVar = this.y) == null) {
            return;
        }
        bVar.b(i2);
    }

    @Override // d.a.n0.z.b
    public void setFrom(String str) {
        super.setFrom(str);
    }
}
