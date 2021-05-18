package d.a.k0.d2.k.e;

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
public abstract class o<T, V extends TypeAdapter.ViewHolder> extends d.a.c.j.e.a<T, V> {
    public d.a.k0.d2.o.i m;
    public PbFragment n;
    public VideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    public o(d.a.k0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar == null ? null : iVar.A(), bdUniqueId);
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        f0(iVar);
    }

    @Override // d.a.c.j.e.a
    public View W(int i2, View view, ViewGroup viewGroup, T t, V v) {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        d.a.c.j.e.p pVar = (d.a.c.j.e.p) viewGroup;
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

    public void f0(d.a.k0.d2.o.i iVar) {
        if (iVar != null) {
            this.m = iVar;
            this.n = iVar.z0();
            VideoPbFragment w = iVar.w();
            this.o = w;
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                this.f39564e = pbFragment.getActivity();
            } else if (w != null) {
                this.f39564e = w.getActivity();
            } else {
                this.f39564e = null;
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.q = z;
    }
}
