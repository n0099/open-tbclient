package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private ArrayList<ImageView> nGF;
    private int[] nGf;
    private c nGp;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nGF = arrayList;
        this.nGf = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nGp != null) {
            this.nGp.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nGp != null) {
            this.nGp.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nGF.size(); i2++) {
            this.nGF.get(i).setImageResource(this.nGf[1]);
            if (i != i2) {
                this.nGF.get(i2).setImageResource(this.nGf[0]);
            }
        }
        if (this.nGp != null) {
            this.nGp.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nGp = cVar;
    }
}
