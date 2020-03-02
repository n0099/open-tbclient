package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private int[] nhF;
    private c nhP;
    private ArrayList<ImageView> nig;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nig = arrayList;
        this.nhF = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nhP != null) {
            this.nhP.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nhP != null) {
            this.nhP.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nig.size(); i2++) {
            this.nig.get(i).setImageResource(this.nhF[1]);
            if (i != i2) {
                this.nig.get(i2).setImageResource(this.nhF[0]);
            }
        }
        if (this.nhP != null) {
            this.nhP.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nhP = cVar;
    }
}
