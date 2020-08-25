package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private int[] nZW;
    private c oag;
    private ArrayList<ImageView> oaw;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.oaw = arrayList;
        this.nZW = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.oag != null) {
            this.oag.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.oag != null) {
            this.oag.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.oaw.size(); i2++) {
            this.oaw.get(i).setImageResource(this.nZW[1]);
            if (i != i2) {
                this.oaw.get(i2).setImageResource(this.nZW[0]);
            }
        }
        if (this.oag != null) {
            this.oag.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.oag = cVar;
    }
}
