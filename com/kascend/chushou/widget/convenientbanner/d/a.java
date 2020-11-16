package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private int[] pBO;
    private c pBY;
    private ArrayList<ImageView> pCo;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.pCo = arrayList;
        this.pBO = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.pBY != null) {
            this.pBY.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.pBY != null) {
            this.pBY.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.pCo.size(); i2++) {
            this.pCo.get(i).setImageResource(this.pBO[1]);
            if (i != i2) {
                this.pCo.get(i2).setImageResource(this.pBO[0]);
            }
        }
        if (this.pBY != null) {
            this.pBY.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.pBY = cVar;
    }
}
