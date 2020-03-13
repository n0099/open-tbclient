package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private int[] nhQ;
    private c nia;
    private ArrayList<ImageView> nir;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nir = arrayList;
        this.nhQ = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nia != null) {
            this.nia.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nia != null) {
            this.nia.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nir.size(); i2++) {
            this.nir.get(i).setImageResource(this.nhQ[1]);
            if (i != i2) {
                this.nir.get(i2).setImageResource(this.nhQ[0]);
            }
        }
        if (this.nia != null) {
            this.nia.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nia = cVar;
    }
}
