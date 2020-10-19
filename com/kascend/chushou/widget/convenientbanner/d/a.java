package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private c ozF;
    private ArrayList<ImageView> ozV;
    private int[] ozv;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.ozV = arrayList;
        this.ozv = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.ozF != null) {
            this.ozF.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.ozF != null) {
            this.ozF.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.ozV.size(); i2++) {
            this.ozV.get(i).setImageResource(this.ozv[1]);
            if (i != i2) {
                this.ozV.get(i2).setImageResource(this.ozv[0]);
            }
        }
        if (this.ozF != null) {
            this.ozF.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.ozF = cVar;
    }
}
