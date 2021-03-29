package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public abstract class m<T, V extends TypeAdapter.ViewHolder> extends d.b.b.j.e.a<T, V> {
    public d.b.i0.c2.o.b m;
    public PbFragment n;
    public VideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    public m(d.b.i0.c2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.P(), bdUniqueId);
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        i0(bVar);
    }

    @Override // d.b.b.j.e.a
    public View X(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        d.b.b.j.e.p pVar = (d.b.b.j.e.p) viewGroup;
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

    public void i0(d.b.i0.c2.o.b bVar) {
        if (bVar != null) {
            this.m = bVar;
            this.n = bVar.y0();
            VideoPbFragment I = bVar.I();
            this.o = I;
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                this.f42358e = pbFragment.getActivity();
            } else if (I != null) {
                this.f42358e = I.getActivity();
            } else {
                this.f42358e = null;
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.q = z;
    }
}
