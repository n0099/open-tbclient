package d.a.n0.r0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public abstract class k<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public boolean m;
    public FrsViewData n;
    public TbPageContext<?> o;
    public f p;
    public d.a.c.k.e.s q;
    public int r;
    public i s;
    public boolean t;
    public d.a.n0.z.b0 u;
    public TbPageTag v;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        resources.getDimensionPixelSize(R.dimen.ds8);
        resources.getDimensionPixelSize(R.dimen.ds16);
        resources.getDimensionPixelSize(R.dimen.ds1);
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = false;
        this.v = null;
        o(tbPageContext, bdUniqueId2);
    }

    @Override // d.a.c.k.e.a
    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        this.r = TbadkCoreApplication.getInst().getSkinType();
        this.q = (d.a.c.k.e.s) viewGroup;
        if (t instanceof z1) {
            ((z1) t).w.e4(2);
            return null;
        }
        return null;
    }

    public View e0(ViewGroup viewGroup, int i2) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            return listView.getChildAt(i2 - (listView.getFirstVisiblePosition() - listView.getHeaderViewsCount()));
        } else if (viewGroup instanceof BdRecyclerView) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) viewGroup;
            return bdRecyclerView.findViewHolderForAdapterPosition(i2 - (bdRecyclerView.getFirstVisiblePosition() - bdRecyclerView.getHeaderViewsCount())).itemView;
        } else if (viewGroup instanceof RecyclerView) {
            return ((RecyclerView) viewGroup).findViewHolderForAdapterPosition(i2).itemView;
        } else {
            return null;
        }
    }

    public TbPageTag g0() {
        return this.v;
    }

    public boolean h0() {
        return this.t;
    }

    public void i0() {
        this.f42909e = null;
        this.o = null;
        this.p = null;
        this.f42910f = null;
        this.f42911g = null;
        i iVar = this.s;
        if (iVar != null) {
            iVar.a();
            this.s = null;
        }
    }

    public void j0(i iVar) {
        this.s = iVar;
    }

    public void k0(f fVar) {
        this.p = fVar;
    }

    public void l0(FrsViewData frsViewData) {
        this.n = frsViewData;
    }

    public void m0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }

    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f42909e = tbPageContext.getPageActivity();
            this.o = tbPageContext;
            this.f42913i = bdUniqueId;
        }
    }

    public void p0(TbPageTag tbPageTag) {
        this.v = tbPageTag;
    }

    public void q0(int i2) {
    }

    public void setFrom(String str) {
    }

    public void setFromCDN(boolean z) {
        this.m = z;
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.m = false;
        this.v = null;
        o(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }
}
