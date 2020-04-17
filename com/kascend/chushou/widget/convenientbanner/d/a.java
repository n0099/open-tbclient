package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private ArrayList<ImageView> mGL;
    private int[] mGl;
    private c mGv;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.mGL = arrayList;
        this.mGl = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.mGv != null) {
            this.mGv.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.mGv != null) {
            this.mGv.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.mGL.size(); i2++) {
            this.mGL.get(i).setImageResource(this.mGl[1]);
            if (i != i2) {
                this.mGL.get(i2).setImageResource(this.mGl[0]);
            }
        }
        if (this.mGv != null) {
            this.mGv.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.mGv = cVar;
    }
}
