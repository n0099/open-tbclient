package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements c {
    private ArrayList<ImageView> nhA;
    private int[] nha;
    private c nhk;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nhA = arrayList;
        this.nha = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nhk != null) {
            this.nhk.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nhk != null) {
            this.nhk.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nhA.size(); i2++) {
            this.nhA.get(i).setImageResource(this.nha[1]);
            if (i != i2) {
                this.nhA.get(i2).setImageResource(this.nha[0]);
            }
        }
        if (this.nhk != null) {
            this.nhk.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nhk = cVar;
    }
}
