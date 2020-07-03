package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private c nxB;
    private ArrayList<ImageView> nxR;
    private int[] nxr;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nxR = arrayList;
        this.nxr = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nxB != null) {
            this.nxB.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nxB != null) {
            this.nxB.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nxR.size(); i2++) {
            this.nxR.get(i).setImageResource(this.nxr[1]);
            if (i != i2) {
                this.nxR.get(i2).setImageResource(this.nxr[0]);
            }
        }
        if (this.nxB != null) {
            this.nxB.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nxB = cVar;
    }
}
