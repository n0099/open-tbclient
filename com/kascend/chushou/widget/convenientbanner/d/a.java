package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private int[] nhD;
    private c nhN;
    private ArrayList<ImageView> nie;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nie = arrayList;
        this.nhD = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nhN != null) {
            this.nhN.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nhN != null) {
            this.nhN.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nie.size(); i2++) {
            this.nie.get(i).setImageResource(this.nhD[1]);
            if (i != i2) {
                this.nie.get(i2).setImageResource(this.nhD[0]);
            }
        }
        if (this.nhN != null) {
            this.nhN.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nhN = cVar;
    }
}
