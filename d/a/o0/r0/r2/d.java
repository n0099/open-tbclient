package d.a.o0.r0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.horizonalList.widget.HListView;
import d.a.c.e.p.l;
import d.a.o0.r0.a1;
import d.a.o0.r0.y;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.o0.z.c<y> {
    public List<d.a.o0.c1.b.c> A;
    public View.OnClickListener B;
    public HListView x;
    public d.a.o0.c1.b.b y;
    public FrsSchoolRecommendItemView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.i() != null) {
                d.this.i().a(view, null);
            }
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.B = new a();
        HListView hListView = new HListView(b());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.z = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        d.a.o0.c1.b.b bVar = new d.a.o0.c1.b.b(b(), R.layout.frs_school_recommend_user, this.z);
        this.y = bVar;
        bVar.d(this.B);
        this.x.setAdapter((ListAdapter) this.y);
        this.u.addView(this.x);
        this.t.setVisibility(8);
        this.n.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // d.a.o0.z.c, d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        super.o(tbPageContext, i2);
        if (this.x == null || this.y == null) {
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        this.y.b(i2);
    }

    public final boolean y(List<d.a.o0.c1.b.c> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        if (!ListUtils.isEmpty(this.A) && ListUtils.getCount(this.A) == ListUtils.getCount(list)) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.A); i2++) {
                d.a.o0.c1.b.c cVar = (d.a.o0.c1.b.c) ListUtils.getItem(this.A, i2);
                d.a.o0.c1.b.c cVar2 = (d.a.o0.c1.b.c) ListUtils.getItem(list, i2);
                if ((cVar instanceof a1) && (cVar2 instanceof a1) && !((a1) cVar).f62182a.getUserId().equals(((a1) cVar2).f62182a.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: z */
    public void n(y yVar) {
        super.v(yVar);
        if (yVar == null || ListUtils.isEmpty(yVar.getDataList())) {
            return;
        }
        if (StringUtils.isNull(yVar.mGroupTitle)) {
            this.n.setText(b().getResources().getString(R.string.school_recommend));
        } else {
            this.n.setText(yVar.mGroupTitle);
        }
        if (y(yVar.getDataList())) {
            List<d.a.o0.c1.b.c> dataList = yVar.getDataList();
            this.A = dataList;
            this.y.c(dataList);
            this.y.notifyDataSetChanged();
        }
    }
}
