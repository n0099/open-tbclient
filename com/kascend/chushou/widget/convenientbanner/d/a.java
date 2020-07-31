package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private ArrayList<ImageView> nGD;
    private int[] nGd;
    private c nGn;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nGD = arrayList;
        this.nGd = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nGn != null) {
            this.nGn.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nGn != null) {
            this.nGn.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nGD.size(); i2++) {
            this.nGD.get(i).setImageResource(this.nGd[1]);
            if (i != i2) {
                this.nGD.get(i2).setImageResource(this.nGd[0]);
            }
        }
        if (this.nGn != null) {
            this.nGn.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nGn = cVar;
    }
}
