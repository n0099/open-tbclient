package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private ArrayList<ImageView> pAL;
    private int[] pAl;
    private c pAv;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.pAL = arrayList;
        this.pAl = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.pAv != null) {
            this.pAv.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.pAv != null) {
            this.pAv.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.pAL.size(); i2++) {
            this.pAL.get(i).setImageResource(this.pAl[1]);
            if (i != i2) {
                this.pAL.get(i2).setImageResource(this.pAl[0]);
            }
        }
        if (this.pAv != null) {
            this.pAv.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.pAv = cVar;
    }
}
