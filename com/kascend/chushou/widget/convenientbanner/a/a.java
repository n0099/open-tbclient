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
    protected List<T> acz;
    private boolean nhM;
    private final int nhT;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> nhU;
    private ConvenientBanner nhV;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.nhU = aVar;
        this.nhT = aVar.getLayoutId();
        this.acz = list;
        this.nhM = z;
        this.nhV = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: E */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.nhT, viewGroup, false);
        if (this.nhV != null) {
            inflate.setTag(this.nhV);
        }
        return this.nhU.dC(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.acz.get(i % this.acz.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bH(this.acz.get(i % this.acz.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.acz == null || this.acz.size() == 0) {
            return 0;
        }
        if (this.nhM) {
            return Integer.MAX_VALUE;
        }
        return this.acz.size();
    }

    public int bdC() {
        return this.acz.size();
    }
}
