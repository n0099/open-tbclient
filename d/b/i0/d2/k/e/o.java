package d.b.i0.d2.k.e;

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
/* loaded from: classes3.dex */
public abstract class o<T, V extends TypeAdapter.ViewHolder> extends d.b.c.j.e.a<T, V> {
    public d.b.i0.d2.o.i m;
    public PbFragment n;
    public VideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    public o(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar == null ? null : iVar.P(), bdUniqueId);
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        i0(iVar);
    }

    @Override // d.b.c.j.e.a
    public View X(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        d.b.c.j.e.p pVar = (d.b.c.j.e.p) viewGroup;
        return null;
    }

    public int h0(int i) {
        int i2 = this.r.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        this.r.put(i, dimensionPixelSize);
        return dimensionPixelSize;
    }

    public void i0(d.b.i0.d2.o.i iVar) {
        if (iVar != null) {
            this.m = iVar;
            this.n = iVar.y0();
            VideoPbFragment I = iVar.I();
            this.o = I;
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                this.f42855e = pbFragment.getActivity();
            } else if (I != null) {
                this.f42855e = I.getActivity();
            } else {
                this.f42855e = null;
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.q = z;
    }
}
