package d.b.i0.p0;

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
import d.b.h0.r.q.z1;
/* loaded from: classes4.dex */
public abstract class k<T, V extends TypeAdapter.ViewHolder> extends d.b.b.j.e.a<T, V> {
    public boolean m;
    public FrsViewData n;
    public TbPageContext<?> o;
    public f p;
    public d.b.b.j.e.s q;
    public int r;
    public i s;
    public boolean t;
    public d.b.i0.x.b0 u;
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
        i(tbPageContext, bdUniqueId2);
    }

    @Override // d.b.b.j.e.a
    public View X(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.r = TbadkCoreApplication.getInst().getSkinType();
        this.q = (d.b.b.j.e.s) viewGroup;
        if (t instanceof z1) {
            ((z1) t).w.Z3(2);
            return null;
        }
        return null;
    }

    public View h0(ViewGroup viewGroup, int i) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            return listView.getChildAt(i - (listView.getFirstVisiblePosition() - listView.getHeaderViewsCount()));
        } else if (viewGroup instanceof BdRecyclerView) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) viewGroup;
            return bdRecyclerView.findViewHolderForAdapterPosition(i - (bdRecyclerView.getFirstVisiblePosition() - bdRecyclerView.getHeaderViewsCount())).itemView;
        } else if (viewGroup instanceof RecyclerView) {
            return ((RecyclerView) viewGroup).findViewHolderForAdapterPosition(i).itemView;
        } else {
            return null;
        }
    }

    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f42358e = tbPageContext.getPageActivity();
            this.o = tbPageContext;
            this.i = bdUniqueId;
        }
    }

    public TbPageTag i0() {
        return this.v;
    }

    public boolean j0() {
        int i;
        TbPageTag tbPageTag = this.v;
        if (tbPageTag == null) {
            return false;
        }
        int i2 = tbPageTag.tabType;
        return i2 == 91 || (i = tbPageTag.tabId) == 89 || i == 504 || i2 == 15 || i2 == 16 || i2 == 3;
    }

    public boolean l0() {
        return this.t;
    }

    public void m0() {
        this.f42358e = null;
        this.o = null;
        this.p = null;
        this.f42359f = null;
        this.f42360g = null;
        i iVar = this.s;
        if (iVar != null) {
            iVar.a();
            this.s = null;
        }
    }

    public void n0(i iVar) {
        this.s = iVar;
    }

    public void o0(f fVar) {
        this.p = fVar;
    }

    public void p0(FrsViewData frsViewData) {
        this.n = frsViewData;
    }

    public void q0(d.b.b.j.e.s sVar) {
        this.q = sVar;
    }

    public void r0(TbPageTag tbPageTag) {
        this.v = tbPageTag;
    }

    public void s0(int i) {
    }

    public void setFromCDN(boolean z) {
        this.m = z;
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.m = false;
        this.v = null;
        i(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }
}
