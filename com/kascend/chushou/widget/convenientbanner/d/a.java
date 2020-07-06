package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private c nxE;
    private ArrayList<ImageView> nxU;
    private int[] nxu;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nxU = arrayList;
        this.nxu = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nxE != null) {
            this.nxE.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nxE != null) {
            this.nxE.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nxU.size(); i2++) {
            this.nxU.get(i).setImageResource(this.nxu[1]);
            if (i != i2) {
                this.nxU.get(i2).setImageResource(this.nxu[0]);
            }
        }
        if (this.nxE != null) {
            this.nxE.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nxE = cVar;
    }
}
