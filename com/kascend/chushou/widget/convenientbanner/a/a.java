package com.kascend.chushou.widget.convenientbanner.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import com.kascend.chushou.widget.convenientbanner.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class a<T> extends RecyclerView.Adapter<b<T>> {
    protected List<T> acJ;
    private boolean njL;
    private final int njS;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> njT;
    private ConvenientBanner njU;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.njT = aVar;
        this.njS = aVar.getLayoutId();
        this.acJ = list;
        this.njL = z;
        this.njU = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.njS, viewGroup, false);
        if (this.njU != null) {
            inflate.setTag(this.njU);
        }
        return this.njT.dC(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.acJ.get(i % this.acJ.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bH(this.acJ.get(i % this.acJ.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.acJ == null || this.acJ.size() == 0) {
            return 0;
        }
        if (this.njL) {
            return Integer.MAX_VALUE;
        }
        return this.acJ.size();
    }

    public int bdI() {
        return this.acJ.size();
    }
}
