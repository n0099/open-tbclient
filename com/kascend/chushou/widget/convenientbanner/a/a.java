package com.kascend.chushou.widget.convenientbanner.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import com.kascend.chushou.widget.convenientbanner.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class a<T> extends RecyclerView.Adapter<b<T>> {
    protected List<T> aCA;
    private boolean nxB;
    private final int nxI;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> nxJ;
    private ConvenientBanner nxK;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.nxJ = aVar;
        this.nxI = aVar.getLayoutId();
        this.aCA = list;
        this.nxB = z;
        this.nxK = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: J */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.nxI, viewGroup, false);
        if (this.nxK != null) {
            inflate.setTag(this.nxK);
        }
        return this.nxJ.dv(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.aCA.get(i % this.aCA.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bw(this.aCA.get(i % this.aCA.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aCA == null || this.aCA.size() == 0) {
            return 0;
        }
        return this.nxB ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aCA.size();
    }

    public int buU() {
        return this.aCA.size();
    }
}
