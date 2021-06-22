package d.a.o0.e2.k.e;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
/* loaded from: classes5.dex */
public abstract class o<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public d.a.o0.e2.o.i m;
    public PbFragment n;
    public VideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    public o(d.a.o0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar == null ? null : iVar.B(), bdUniqueId);
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        g0(iVar);
    }

    @Override // d.a.c.k.e.a
    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        d.a.c.k.e.p pVar = (d.a.c.k.e.p) viewGroup;
        return null;
    }

    public int e0(int i2) {
        int i3 = this.r.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
        this.r.put(i2, dimensionPixelSize);
        return dimensionPixelSize;
    }

    public void g0(d.a.o0.e2.o.i iVar) {
        if (iVar != null) {
            this.m = iVar;
            this.n = iVar.C0();
            VideoPbFragment x = iVar.x();
            this.o = x;
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                this.f43012e = pbFragment.getActivity();
            } else if (x != null) {
                this.f43012e = x.getActivity();
            } else {
                this.f43012e = null;
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.q = z;
    }
}
