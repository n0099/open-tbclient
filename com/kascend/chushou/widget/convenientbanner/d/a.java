package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private c mGA;
    private ArrayList<ImageView> mGQ;
    private int[] mGq;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.mGQ = arrayList;
        this.mGq = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.mGA != null) {
            this.mGA.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.mGA != null) {
            this.mGA.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.mGQ.size(); i2++) {
            this.mGQ.get(i).setImageResource(this.mGq[1]);
            if (i != i2) {
                this.mGQ.get(i2).setImageResource(this.mGq[0]);
            }
        }
        if (this.mGA != null) {
            this.mGA.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.mGA = cVar;
    }
}
