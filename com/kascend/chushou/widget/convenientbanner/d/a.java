package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements c {
    private int[] ngV;
    private c nhf;
    private ArrayList<ImageView> nhv;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nhv = arrayList;
        this.ngV = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nhf != null) {
            this.nhf.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nhf != null) {
            this.nhf.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nhv.size(); i2++) {
            this.nhv.get(i).setImageResource(this.ngV[1]);
            if (i != i2) {
                this.nhv.get(i2).setImageResource(this.ngV[0]);
            }
        }
        if (this.nhf != null) {
            this.nhf.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nhf = cVar;
    }
}
