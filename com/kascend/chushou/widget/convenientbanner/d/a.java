package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private c naA;
    private ArrayList<ImageView> naQ;
    private int[] naq;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.naQ = arrayList;
        this.naq = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.naA != null) {
            this.naA.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.naA != null) {
            this.naA.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.naQ.size(); i2++) {
            this.naQ.get(i).setImageResource(this.naq[1]);
            if (i != i2) {
                this.naQ.get(i2).setImageResource(this.naq[0]);
            }
        }
        if (this.naA != null) {
            this.naA.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.naA = cVar;
    }
}
